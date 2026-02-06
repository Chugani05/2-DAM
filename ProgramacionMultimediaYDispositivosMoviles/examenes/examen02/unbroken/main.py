import uvicorn
from src.auth import router as auth_router
from src.services import router as habit_router
from fastapi import FastAPI

app = FastAPI(title="Habit Tracker API")

app.include_router(auth_router, prefix="/auth", tags=["auth"])
app.include_router(habit_router, prefix="/habits", tags=["habits"])

if __name__ == "__main__":
    uvicorn.run("main:app", port=5000, log_level="info", reload=True)
