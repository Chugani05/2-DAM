import { obtenerReservas, crearReservaRemota, actualizarReservaRemota, borrarReservaRemota } from "../src/api/apiReservasHotel";
import { ReservaHotel } from "../src/models";

declare const global: typeof globalThis & { fetch: jest.Mock };

beforeEach(() => {
  global.fetch = jest.fn();
});

test("GET /reservas: llama a la URL correcta", async () => {
  global.fetch.mockResolvedValue({ ok: true, status: 200, statusText: "OK", json: async () => [] });
  await obtenerReservas();
  expect(global.fetch).toHaveBeenCalledWith("http://localhost:3000/reservas");
});

test("GET /reservas: devuelve array tipado", async () => {
  const mock: ReservaHotel[] = [{ id: 1, habitacion: 101, cliente: "Ana", fechaEntrada: "i", fechaSalida: "f", confirmada: false }];
  global.fetch.mockResolvedValue({ ok: true, status: 200, statusText: "OK", json: async () => mock });
  const r = await obtenerReservas();
  expect(r).toEqual(mock);
});

test("GET: lanza error si !ok", async () => {
  global.fetch.mockResolvedValue({ ok: false, status: 500, statusText: "ERR", json: async () => [] });
  await expect(obtenerReservas()).rejects.toThrow("Error al cargar reservas");
});

test("POST: usa método POST, headers y body JSON", async () => {
  const created: ReservaHotel = { id: 10, habitacion: 101, cliente: "Ana", fechaEntrada: "i", fechaSalida: "f", confirmada: false };
  global.fetch.mockResolvedValue({ ok: true, status: 201, statusText: "Created", json: async () => created });

  await crearReservaRemota({ habitacion: 101, cliente: "Ana", fechaEntrada: "i", fechaSalida: "f", confirmada: false });
  const [url, opts] = global.fetch.mock.calls[0];

  expect(url).toBe("http://localhost:3000/reservas");
  expect(opts.method).toBe("POST");
  expect(opts.headers["Content-Type"]).toBe("application/json");
  expect(typeof opts.body).toBe("string");
  expect(opts.body).toContain('"habitacion":101');
});

test("POST: devuelve reserva creada", async () => {
  const created: ReservaHotel = { id: 10, habitacion: 101, cliente: "Ana", fechaEntrada: "i", fechaSalida: "f", confirmada: false };
  global.fetch.mockResolvedValue({ ok: true, status: 201, statusText: "Created", json: async () => created });
  const r = await crearReservaRemota({ habitacion: 101, cliente: "Ana", fechaEntrada: "i", fechaSalida: "f", confirmada: false });
  expect(r).toEqual(created);
});

test("UPDATE: llama a /reservas/{id}", async () => {
  const updated: ReservaHotel = { id: 1, habitacion: 101, cliente: "Ana", fechaEntrada: "i", fechaSalida: "f", confirmada: true };
  global.fetch.mockResolvedValue({ ok: true, status: 200, statusText: "OK", json: async () => updated });

  await actualizarReservaRemota(1, { confirmada: true });
  const [url] = global.fetch.mock.calls[0];
  expect(url).toBe("http://localhost:3000/reservas/1");
});

test("UPDATE: método PUT o PATCH (se acepta cualquiera)", async () => {
  const updated: ReservaHotel = { id: 1, habitacion: 101, cliente: "Ana", fechaEntrada: "i", fechaSalida: "f", confirmada: true };
  global.fetch.mockResolvedValue({ ok: true, status: 200, statusText: "OK", json: async () => updated });

  await actualizarReservaRemota(1, { confirmada: true });
  const [, opts] = global.fetch.mock.calls[0];
  expect(["PUT", "PATCH"]).toContain(opts.method);
});

test("UPDATE: envía JSON", async () => {
  const updated: ReservaHotel = { id: 1, habitacion: 101, cliente: "Ana", fechaEntrada: "i", fechaSalida: "f", confirmada: true };
  global.fetch.mockResolvedValue({ ok: true, status: 200, statusText: "OK", json: async () => updated });

  await actualizarReservaRemota(1, { confirmada: true });
  const [, opts] = global.fetch.mock.calls[0];
  expect(opts.headers["Content-Type"]).toBe("application/json");
  expect(opts.body).toContain('"confirmada":true');
});

test("DELETE: llama con método DELETE a /reservas/{id}", async () => {
  global.fetch.mockResolvedValue({ ok: true, status: 200, statusText: "OK" });
  await borrarReservaRemota(7);
  const [url, opts] = global.fetch.mock.calls[0];
  expect(url).toBe("http://localhost:3000/reservas/7");
  expect(opts.method).toBe("DELETE");
});

test("UPDATE: lanza error si !ok", async () => {
  global.fetch.mockResolvedValue({ ok: false, status: 400, statusText: "Bad Request", json: async () => ({}) });
  await expect(actualizarReservaRemota(1, { confirmada: true })).rejects.toThrow("Error al actualizar reserva 1");
});
