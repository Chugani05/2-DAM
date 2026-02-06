from datetime import date, timedelta
from fractions import Fraction
from math import gcd
from uuid import UUID, uuid4

from src.dependencies import get_current_user
from src.models import Habit, HabitCreate, HabitOut
from src.storage import habits
from fastapi import APIRouter, Depends, HTTPException

router = APIRouter()


@router.post("/")
def create_habit(body: HabitCreate, user=Depends(get_current_user)):
    if len(habits[user]) >= 5:
        raise HTTPException(400, "Máximo 5 hábitos")

    hid = uuid4()

    habits[user][hid] = Habit(
        id=hid,
        description=body.description,
        start_date=date.today(),
        last_check_date=None,
        logs={},
        current_streak=0,
        max_streak=0,
        total_days=0,
        fulfilled_days=0,
    )

    return habits[user][hid]


@router.post("/{hid}/check")
def check_today(hid: UUID, user=Depends(get_current_user)):
    habit = habits[user].get(hid)
    if not habit:
        raise HTTPException(404, "Hábito no encontrado")

    today = date.today()

    # primer check de la vida del hábito
    if habit.last_check_date is None:
        habit.current_streak = 1
        habit.max_streak = 1
        habit.fulfilled_days = 1
        habit.total_days = 1
        habit.last_check_date = today
        return habit

    # Si ya marcó hoy
    if habit.last_check_date == today:
        raise HTTPException(400, "El día actual ya fue registrado")

    yesterday = today - timedelta(days=1)

    if habit.last_check_date == yesterday:
        habit.current_streak += 1
    else:
        habit.current_streak = 1

    habit.max_streak = max(habit.max_streak, habit.current_streak)
    habit.fulfilled_days += 1
    habit.total_days = (today - habit.start_date).days + 1
    habit.last_check_date = today

    return habit


@router.get("/", response_model=dict[UUID, HabitOut])
def list_habits(user=Depends(get_current_user)):
    today = date.today()
    result = {}

    for hid, habit in habits[user].items():
        # recalcular total_days
        habit.total_days = (today - habit.start_date).days + 1

        # calcular ratio
        if habit.total_days > 0:
            ratio = Fraction(habit.fulfilled_days, habit.total_days)
            ratio_str = f"{ratio.numerator}/{ratio.denominator}"
        else:
            ratio_str = "0/1"

        result[hid] = HabitOut(
            id=hid,
            description=habit.description,
            start_date=habit.start_date,
            last_check_date=habit.last_check_date,
            current_streak=habit.current_streak,
            max_streak=habit.max_streak,
            fulfilled_days=habit.fulfilled_days,
            total_days=habit.total_days,
            ratio=ratio_str,
        )

    return result


@router.get("/{hid}", response_model=HabitOut)
def get_habit(hid: UUID, user=Depends(get_current_user)):
    today = date.today()
    habit = habits[user].get(hid)
    if not habit:
        raise HTTPException(status_code=404, detail="Hábito no encontrado")

    # Recalcular total de días
    habit.total_days = (today - habit.start_date).days + 1

    # Verificar racha
    if habit.last_check_date is None:
        habit.current_streak = 0
    else:
        # Si la última marca fue anterior a ayer, se rompe la racha
        if (today - habit.last_check_date).days > 1:
            habit.current_streak = 0
        # Si fue ayer o hoy, la racha se mantiene
        # Nota: si last_check_date == today → racha ya tiene valor correcto

    # Calcular ratio simplificado
    total = habit.total_days
    fulfilled = habit.fulfilled_days
    if total > 0:
        ratio = Fraction(fulfilled, total)
        ratio_str = f"{ratio.numerator}/{ratio.denominator}"
    else:
        ratio_str = "0/1"

    return HabitOut(
        id=hid,
        description=habit.description,
        start_date=habit.start_date,
        last_check_date=habit.last_check_date,
        current_streak=habit.current_streak,
        max_streak=habit.max_streak,
        fulfilled_days=habit.fulfilled_days,
        total_days=habit.total_days,
        ratio=ratio_str,
    )


@router.put("/{hid}")
def edit_habit(hid: UUID, body: HabitCreate, user=Depends(get_current_user)):
    habit = habits[user].get(hid)
    if not habit:
        raise HTTPException(status_code=404, detail="Hábito no encontrado")

    habit.description = body.description
    return habit


@router.delete("/{hid}")
def delete_habit(hid: UUID, user=Depends(get_current_user)):
    if hid not in habits[user]:
        raise HTTPException(404, "Hábito no encontrado")
    habits[user].pop(hid)
    return {"msg": "Hábito eliminado"}
