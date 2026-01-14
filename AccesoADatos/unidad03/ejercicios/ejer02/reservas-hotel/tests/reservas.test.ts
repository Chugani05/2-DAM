import { crearReserva, confirmarReserva, filtrarReservas, haySolapamiento, esIsoValida } from "../src/reservas";
import { ReservaHotel } from "../src/models";

function seed(): ReservaHotel[] {
  return [
    crearReserva(1, 101, "Ana", "2026-01-10T12:00:00Z", "2026-01-12T10:00:00Z"),
    { ...crearReserva(2, 101, "Luis", "2026-01-12T12:00:00Z", "2026-01-13T10:00:00Z"), confirmada: true },
    crearReserva(3, 102, "Ana Maria", "2026-01-10T12:00:00Z", "2026-01-12T10:00:00Z"),
  ];
}

test("esIsoValida: true para ISO parseable", () => {
  expect(esIsoValida("2026-01-10T12:00:00Z")).toBe(true);
});

test("esIsoValida: false para vacío", () => {
  expect(esIsoValida("")).toBe(false);
});

test("esIsoValida: false para texto", () => {
  expect(esIsoValida("nope")).toBe(false);
});

test("crearReserva: confirmada debe ser false", () => {
  const r = crearReserva(9, 201, "X", "2026-01-01T00:00:00Z", "2026-01-02T00:00:00Z");
  expect(r.confirmada).toBe(false);
});

test("crearReserva: mantiene observaciones si se pasan", () => {
  const r = crearReserva(9, 201, "X", "2026-01-01T00:00:00Z", "2026-01-02T00:00:00Z", "VIP");
  expect(r.observaciones).toBe("VIP");
});

test("confirmarReserva: marca confirmada", () => {
  const base = seed();
  const res = confirmarReserva(base, 1);
  expect(res.find(r => r.id === 1)!.confirmada).toBe(true);
});

test("confirmarReserva: no muta array original", () => {
  const base = seed();
  confirmarReserva(base, 1);
  expect(base.find(r => r.id === 1)!.confirmada).toBe(false);
});

test("confirmarReserva: no cambia otros elementos", () => {
  const base = seed();
  const res = confirmarReserva(base, 1);
  expect(res.find(r => r.id === 3)!.confirmada).toBe(false);
});

test("filtrarReservas: pendientes", () => {
  const base = seed();
  expect(filtrarReservas(base, "pendientes")).toHaveLength(2);
});

test("filtrarReservas: confirmadas", () => {
  const base = seed();
  expect(filtrarReservas(base, "confirmadas")).toHaveLength(1);
});

test("filtrarReservas: todas", () => {
  const base = seed();
  expect(filtrarReservas(base, "todas")).toHaveLength(3);
});

test("haySolapamiento: true si solapa en misma habitación", () => {
  const base = seed();
  expect(haySolapamiento(base, 101, "2026-01-11T00:00:00Z", "2026-01-11T01:00:00Z")).toBe(true);
});

test("haySolapamiento: false si distinta habitación", () => {
  const base = seed();
  expect(haySolapamiento(base, 999, "2026-01-11T00:00:00Z", "2026-01-11T01:00:00Z")).toBe(false);
});

test("haySolapamiento: NO solapa si entrada coincide con salida (checkout/checkin)", () => {
  const base = [
    crearReserva(1, 101, "Ana", "2026-01-10T12:00:00Z", "2026-01-12T10:00:00Z"),
  ];
  expect(haySolapamiento(base, 101, "2026-01-12T10:00:00Z", "2026-01-13T10:00:00Z")).toBe(false);
});

test("haySolapamiento: true si fechas inválidas o rango inválido", () => {
  const base = seed();
  expect(haySolapamiento(base, 101, "bad", "also-bad")).toBe(true);
  expect(haySolapamiento(base, 101, "2026-01-12T10:00:00Z", "2026-01-12T10:00:00Z")).toBe(true);
});
