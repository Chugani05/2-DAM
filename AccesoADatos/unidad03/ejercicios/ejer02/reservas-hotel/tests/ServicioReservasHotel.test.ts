// Nota FP: better-sqlite3 es CommonJS. Usamos require para evitar problemas ESM/CJS.
const Database = require("better-sqlite3") as typeof import("better-sqlite3");
import { RepositorioReservasHotelSqlite } from "../src/db/repositorioReservasHotelSqlite";
import { ServicioReservasHotel, ClienteReservasRemoto } from "../src/services/ServicioReservasHotel";
import { ReservaHotel } from "../src/models";

test("listar local aplica filtro", async () => {
  const db = new Database(":memory:");
  const repo = new RepositorioReservasHotelSqlite(db);
  repo.crear({ habitacion: 101, cliente: "Ana", fechaEntrada: "i", fechaSalida: "f", confirmada: false });
  repo.crear({ habitacion: 102, cliente: "Luis", fechaEntrada: "i", fechaSalida: "f", confirmada: true });

  const remoto: ClienteReservasRemoto = {
    obtenerReservas: async () => [],
    crearReservaRemota: async () => { throw new Error("no"); }
  };

  const svc = new ServicioReservasHotel(repo, remoto);
  const pendientes = await svc.listar("local", "pendientes");
  expect(pendientes).toHaveLength(1);
});

test("listar remoto usa cliente remoto", async () => {
  const db = new Database(":memory:");
  const repo = new RepositorioReservasHotelSqlite(db);

  const remotoData: ReservaHotel[] = [
    { id: 1, habitacion: 201, cliente: "Remoto", fechaEntrada: "i", fechaSalida: "f", confirmada: true }
  ];
  const remoto: ClienteReservasRemoto = {
    obtenerReservas: async () => remotoData,
    crearReservaRemota: async () => remotoData[0]
  };

  const svc = new ServicioReservasHotel(repo, remoto);
  const res = await svc.listar("remoto", "todas");
  expect(res).toEqual(remotoData);
});

test("crear elige origen", async () => {
  const db = new Database(":memory:");
  const repo = new RepositorioReservasHotelSqlite(db);

  const remoto: ClienteReservasRemoto = {
    obtenerReservas: async () => [],
    crearReservaRemota: async (n) => ({ id: 99, ...n })
  };

  const svc = new ServicioReservasHotel(repo, remoto);
  const local = await svc.crear("local", { habitacion: 101, cliente: "Ana", fechaEntrada: "i", fechaSalida: "f", confirmada: false });
  const remotoCreada = await svc.crear("remoto", { habitacion: 102, cliente: "Luis", fechaEntrada: "i", fechaSalida: "f", confirmada: false });

  expect(local.id).toBeGreaterThan(0);
  expect(remotoCreada.id).toBe(99);
});

test("sync: borra local e importa remoto", async () => {
  const db = new Database(":memory:");
  const repo = new RepositorioReservasHotelSqlite(db);
  repo.crear({ habitacion: 101, cliente: "Local", fechaEntrada: "i", fechaSalida: "f", confirmada: false });

  const remotoData: ReservaHotel[] = [
    { id: 1, habitacion: 201, cliente: "Remoto1", fechaEntrada: "i1", fechaSalida: "f1", confirmada: false },
    { id: 2, habitacion: 202, cliente: "Remoto2", fechaEntrada: "i2", fechaSalida: "f2", confirmada: true }
  ];
  const remoto: ClienteReservasRemoto = {
    obtenerReservas: async () => remotoData,
    crearReservaRemota: async (n) => ({ id: 999, ...n })
  };

  const svc = new ServicioReservasHotel(repo, remoto);
  const r = await svc.sincronizarRemotoALocal();
  expect(r.importadas).toBe(2);
  const all = repo.obtenerTodas();
  expect(all).toHaveLength(2);
  expect(all.some(x => x.cliente === "Local")).toBe(false);
});
