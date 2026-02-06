from datetime import date
from typing import Dict, Optional
from uuid import UUID

from pydantic import BaseModel


class User(BaseModel):
    alias: str
    password: str


class Habit(BaseModel):
    id: UUID
    description: str
    start_date: date
    last_check_date: Optional[date]
    logs: Dict[date, bool]  # remove it
    current_streak: int
    max_streak: int
    total_days: int
    fulfilled_days: int


class HabitCreate(BaseModel):
    description: str


class HabitOut(BaseModel):
    id: UUID
    description: str
    start_date: date
    last_check_date: date | None
    current_streak: int
    max_streak: int
    fulfilled_days: int
    total_days: int
    ratio: str
