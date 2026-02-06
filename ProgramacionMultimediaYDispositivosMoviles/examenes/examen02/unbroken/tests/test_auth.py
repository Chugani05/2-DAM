def test_register_login(client):
    r = client.post("/auth/register", json={"alias": "a", "password": "b"})
    assert r.status_code == 200
    r = client.post("/auth/login", json={"alias": "a", "password": "b"})
    assert "access_token" in r.json()
