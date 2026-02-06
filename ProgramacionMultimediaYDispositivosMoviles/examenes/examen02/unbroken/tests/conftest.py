import pytest
from fastapi import FastAPI
from fastapi.testclient import TestClient
from src.auth import router as auth_router
from src.services import router as habit_router
from src.storage import users, habits


@pytest.fixture
def client():
    users.clear()
    habits.clear()
    app = FastAPI()
    app.include_router(auth_router, prefix="/auth", tags=["auth"])
    app.include_router(habit_router, prefix="/habits", tags=["habits"])
    return TestClient(app)
