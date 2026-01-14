// Nota FP: better-sqlite3 es CommonJS. Usamos require para evitar problemas ESM/CJS.
const Database = require("better-sqlite3") as typeof import("better-sqlite3");
import type BetterSqlite3 from "better-sqlite3";

export function initDb(db: BetterSqlite3.Database) {
  db.exec(`
    CREATE TABLE IF NOT EXISTS reservas (
      id INTEGER PRIMARY KEY AUTOINCREMENT,
      habitacion INTEGER NOT NULL,
      cliente TEXT NOT NULL,
      fechaEntrada TEXT NOT NULL,
      fechaSalida TEXT NOT NULL,
      confirmada INTEGER NOT NULL,
      observaciones TEXT
    )
  `);
}

export function getDb(file = "reservas.db"): BetterSqlite3.Database {
  const db = new Database(file);
  initDb(db);
  return db;
}
