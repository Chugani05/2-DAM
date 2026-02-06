from datetime import datetime, timedelta, UTC

import jwt
from src.dependencies import get_current_user
from src.models import User
from src.storage import habits, users
from fastapi import APIRouter, Security, HTTPException

SECRET = "secret"
ALGO = "HS256"
router = APIRouter()


@router.post("/register")
def register(user: User):
    if user.alias in users:
        raise HTTPException(400, "Alias ya existe")
    users[user.alias] = user
    habits[user.alias] = {}
    return {"msg": "Usuario registrado"}


@router.post("/login")
def login(user: User):
    db = users.get(user.alias)
    if not db or db.password != user.password:
        raise HTTPException(401, "Credenciales inválidas")
    token = jwt.encode(
        {"sub": user.alias, "exp": datetime.now(UTC) + timedelta(hours=1)},
        SECRET,
        ALGO,
    )
    return {"access_token": token}


@router.delete("/me")
def delete_me(user: str = Security(get_current_user)):
    users.pop(user, None)
    habits.pop(user, None)
    return {"msg": "Usuario eliminado"}
