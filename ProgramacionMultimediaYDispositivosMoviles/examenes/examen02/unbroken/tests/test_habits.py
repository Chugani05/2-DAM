def auth(client):
    client.post("/auth/register", json={"alias": "u", "password": "p"})
    r = client.post("/auth/login", json={"alias": "u", "password": "p"})
    return {"Authorization": f"Bearer {r.json()['access_token']}"}


def test_create_limit_and_uuid(client):
    h = auth(client)
    ids = []
    for i in range(5):
        r = client.post("/habits/", json={"description": str(i)}, headers=h)
        ids.append(r.json()["id"])
    assert len(set(ids)) == 5
    assert (
        client.post("/habits/", json={"description": "x"}, headers=h).status_code == 400
    )


def test_create_habit(client):
    h = auth(client)
    r = client.post("/habits/", json={"description": "Read"}, headers=h)
    assert r.status_code == 200
    data = r.json()
    assert "id" in data
    assert data["description"] == "Read"


def test_update_habit(client):
    h = auth(client)
    r = client.post("/habits/", json={"description": "Exercise"}, headers=h)
    hid = r.json()["id"]
    r = client.put(f"/habits/{hid}", json={"description": "Yoga"}, headers=h)
    assert r.status_code == 200
    assert r.json()["description"] == "Yoga"


def test_rename_habit(client):
    h = auth(client)
    r = client.post("/habits/", json={"description": "Run"}, headers=h)
    hid = r.json()["id"]
    r = client.put(f"/habits/{hid}", json={"description": "Jog"}, headers=h)
    assert r.status_code == 200
    assert r.json()["description"] == "Jog"


def test_check_habit_streak_and_missed_day(client):
    from datetime import date
    from freezegun import freeze_time
    import src.services as services

    h = auth(client)
    # Day 1: mark habit as done
    with freeze_time("2023-01-01"):
        # Create a new habit
        r1 = client.post("/habits/", json={"description": "Learn japanese"}, headers=h)
        hid = r1.json()["id"]
        assert r1.json()["total_days"] == 0
        assert r1.json()["fulfilled_days"] == 0
        assert r1.json()["current_streak"] == 0
        assert r1.json()["max_streak"] == 0
        r1 = client.post(f"/habits/{hid}/check", headers=h)
        assert r1.json()["total_days"] == 1
        assert r1.json()["fulfilled_days"] == 1
        assert r1.json()["current_streak"] == 1
        assert r1.json()["max_streak"] == 1

    # Day 2: mark habit as done
    with freeze_time("2023-01-02"):
        r2 = client.get(f"/habits/{hid}", headers=h)
        assert r2.json()["total_days"] == 2
        assert r2.json()["fulfilled_days"] == 1
        assert r2.json()["current_streak"] == 1
        assert r2.json()["max_streak"] == 1
        r2 = client.post(f"/habits/{hid}/check", headers=h)
        assert r2.json()["total_days"] == 2
        assert r2.json()["fulfilled_days"] == 2
        assert r2.json()["current_streak"] == 2
        assert r2.json()["max_streak"] == 2

    # Day 3: skip the check (no request sent)
    with freeze_time("2023-01-03"):
        r3 = client.get(f"/habits/{hid}", headers=h)
        assert r3.json()["total_days"] == 3
        assert r3.json()["fulfilled_days"] == 2
        assert r3.json()["current_streak"] == 2
        assert r3.json()["max_streak"] == 2

    # Day 4: mark habit as done again
    with freeze_time("2023-01-04"):
        r4 = client.get(f"/habits/{hid}", headers=h)
        assert r4.json()["total_days"] == 4
        assert r4.json()["fulfilled_days"] == 2
        assert r4.json()["current_streak"] == 0
        assert r4.json()["max_streak"] == 2

        r4 = client.post(f"/habits/{hid}/check", headers=h)
        assert r4.json()["total_days"] == 4
        assert r4.json()["fulfilled_days"] == 3
        # Because day 2 was missed, streak should reset to 1
        assert r4.json()["current_streak"] == 1
        assert r4.json()["max_streak"] == 2

        # Rename the habit and ensure statistics persist
        new_desc = "Learn Japanese"
        rrename = client.put(
            f"/habits/{hid}", json={"description": new_desc}, headers=h
        )
        assert rrename.json()["description"] == new_desc

        rlist = client.get("/habits/", headers=h)
        habit_data = rlist.json()[str(hid)]
        assert habit_data["current_streak"] == 1
        assert habit_data["max_streak"] == 2
        assert habit_data["total_days"] == 4
        assert habit_data["fulfilled_days"] == 3


def test_delete_habit(client):
    h = auth(client)
    r = client.post("/habits/", json={"description": "Meditate"}, headers=h)
    hid = r.json()["id"]
    r = client.delete(f"/habits/{hid}", headers=h)
    assert r.status_code == 200
    assert r.json()["msg"] == "Hábito eliminado"
    r = client.get("/habits/", headers=h)
    assert hid not in r.json()


def test_delete_nonexistent_habit(client):
    h = auth(client)
    r = client.delete("/habits/00000000-0000-0000-0000-000000000000", headers=h)
    assert r.status_code == 404
