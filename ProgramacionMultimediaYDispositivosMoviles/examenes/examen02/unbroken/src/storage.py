from typing import Dict
from uuid import UUID

from src.models import Habit, User

users: Dict[str, User] = {}
habits: Dict[str, Dict[UUID, Habit]] = {}
