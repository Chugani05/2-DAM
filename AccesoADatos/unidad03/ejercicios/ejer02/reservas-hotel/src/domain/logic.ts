import { Habitacion, Reserva, EstadoReserva } from "./models";

const MS_DIA = 1000 * 60 * 60 * 24;

function toDateOnlyUTC(isoYMD: string): Date {
  throw new Error("TODO");
}

export function calcularNoches(fechaEntrada: string, fechaSalida: string): number {
 throw new Error("TODO");
}

export function calcularPrecioTotal(reserva: Reserva, habitacion: Habitacion): number {
  throw new Error("TODO");
}


export function hayConflicto(a: Reserva, b: Reserva): boolean {
  throw new Error("TODO");
}
