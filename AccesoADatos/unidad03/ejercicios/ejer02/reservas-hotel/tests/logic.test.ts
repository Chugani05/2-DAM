import { calcularNoches, calcularPrecioTotal, hayConflicto } from "../src/domain/logic";
import { EstadoReserva, Habitacion, Reserva } from "../src/domain/models";

describe("E2 – Lógica pura (domain/logic.ts)", () => {
  test("calcularNoches calcula noches correctamente", () => {
    expect(calcularNoches("2026-01-10", "2026-01-13")).toBe(3);
  });

  test("calcularNoches lanza error si salida <= entrada", () => {
    expect(() => calcularNoches("2026-01-10", "2026-01-10")).toThrow();
    expect(() => calcularNoches("2026-01-10", "2026-01-09")).toThrow();
  });

  test("calcularNoches lanza error si fecha inválida", () => {
    expect(() => calcularNoches("nope", "2026-01-13")).toThrow();
  });

  test("calcularPrecioTotal = noches * precioPorNoche", () => {
    const h: Habitacion = { id: "h1", numero: "101", tipo: "STD", precioPorNoche: 80 };
    const r: Reserva = {
      id: "r1",
      clienteId: "c1",
      habitacionId: "h1",
      fechaEntrada: "2026-02-01",
      fechaSalida: "2026-02-04",
      estado: EstadoReserva.CONFIRMADA
    };
    expect(calcularPrecioTotal(r, h)).toBe(240);
  });

  test("hayConflicto devuelve false si habitación distinta", () => {
    const a: Reserva = { id:"a", clienteId:"c", habitacionId:"h1", fechaEntrada:"2026-03-01", fechaSalida:"2026-03-05", estado: EstadoReserva.CONFIRMADA };
    const b: Reserva = { id:"b", clienteId:"c", habitacionId:"h2", fechaEntrada:"2026-03-04", fechaSalida:"2026-03-07", estado: EstadoReserva.CONFIRMADA };
    expect(hayConflicto(a,b)).toBe(false);
  });

  test("hayConflicto ignora canceladas", () => {
    const a: Reserva = { id:"a", clienteId:"c", habitacionId:"h1", fechaEntrada:"2026-03-01", fechaSalida:"2026-03-05", estado: EstadoReserva.CANCELADA };
    const b: Reserva = { id:"b", clienteId:"c", habitacionId:"h1", fechaEntrada:"2026-03-02", fechaSalida:"2026-03-03", estado: EstadoReserva.CONFIRMADA };
    expect(hayConflicto(a,b)).toBe(false);
  });

  test("hayConflicto detecta solape (intervalo semiabierto)", () => {
    const a: Reserva = { id:"a", clienteId:"c", habitacionId:"h1", fechaEntrada:"2026-03-01", fechaSalida:"2026-03-05", estado: EstadoReserva.CONFIRMADA };
    const b: Reserva = { id:"b", clienteId:"c", habitacionId:"h1", fechaEntrada:"2026-03-04", fechaSalida:"2026-03-07", estado: EstadoReserva.CONFIRMADA };
    expect(hayConflicto(a,b)).toBe(true);
  });

  test("hayConflicto NO hay conflicto si toca justo la salida", () => {
    const a: Reserva = { id:"a", clienteId:"c", habitacionId:"h1", fechaEntrada:"2026-03-01", fechaSalida:"2026-03-05", estado: EstadoReserva.CONFIRMADA };
    const b: Reserva = { id:"b", clienteId:"c", habitacionId:"h1", fechaEntrada:"2026-03-05", fechaSalida:"2026-03-07", estado: EstadoReserva.CONFIRMADA };
    expect(hayConflicto(a,b)).toBe(false);
  });
});
