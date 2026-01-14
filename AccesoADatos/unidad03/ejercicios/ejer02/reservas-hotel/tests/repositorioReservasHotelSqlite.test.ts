// Nota FP: better-sqlite3 es CommonJS. Usamos require para evitar problemas ESM/CJS.
const Database = require("better-sqlite3") as typeof import("better-sqlite3");
import { RepositorioReservasHotelSqlite } from "../src/db/repositorioReservasHotelSqlite";

test("init: crea tabla reservas", () => {
  const db = new Database(":memory:");
  const repo = new RepositorioReservasHotelSqlite(db);
  const rows = db.prepare("SELECT name FROM sqlite_master WHERE type='table' AND name='reservas'").all();
  expect(rows.length).toBe(1);
  expect(repo.obtenerTodas()).toEqual([]);
});

test("crear + obtenerTodas", () => {
  const db = new Database(":memory:");
  const repo = new RepositorioReservasHotelSqlite(db);
  const creada = repo.crear({ habitacion: 101, cliente: "Ana", fechaEntrada: "i", fechaSalida: "f", confirmada: false });
  expect(creada.id).toBeGreaterThan(0);
  expect(repo.obtenerTodas()).toHaveLength(1);
});

test("guardar confirmada como 0/1 y leer boolean", () => {
  const db = new Database(":memory:");
  const repo = new RepositorioReservasHotelSqlite(db);
  const creada = repo.crear({ habitacion: 101, cliente: "Ana", fechaEntrada: "i", fechaSalida: "f", confirmada: true });
  const raw = db.prepare("SELECT confirmada FROM reservas WHERE id = ?").get(creada.id) as any;
  expect(raw.confirmada).toBe(1);
  expect(repo.obtenerTodas()[0].confirmada).toBe(true);
});

test("actualizar parcial conserva campos", () => {
  const db = new Database(":memory:");
  const repo = new RepositorioReservasHotelSqlite(db);
  const creada = repo.crear({ habitacion: 101, cliente: "Ana", fechaEntrada: "i", fechaSalida: "f", confirmada: false, observaciones: "X" });
  const upd = repo.actualizar(creada.id, { confirmada: true });
  expect(upd!.cliente).toBe("Ana");
  expect(upd!.observaciones).toBe("X");
  expect(upd!.confirmada).toBe(true);
});

test("borrar", () => {
  const db = new Database(":memory:");
  const repo = new RepositorioReservasHotelSqlite(db);
  const creada = repo.crear({ habitacion: 101, cliente: "Ana", fechaEntrada: "i", fechaSalida: "f", confirmada: false });
  expect(repo.borrar(creada.id)).toBe(true);
  expect(repo.obtenerTodas()).toHaveLength(0);
});

test("actualizar id inexistente devuelve undefined", () => {
  const db = new Database(":memory:");
  const repo = new RepositorioReservasHotelSqlite(db);
  expect(repo.actualizar(999, { confirmada: true })).toBeUndefined();
});
