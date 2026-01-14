import { ReservaHotel, IdReserva, FiltroReserva } from "./models";

export function esIsoValida(iso: string): boolean {
  // TODO: devuelve true si iso es parseable con Date.parse
  void iso;
  throw new Error("TODO");
}

export function crearReserva(
  id: IdReserva,
  habitacion: number,
  cliente: string,
  fechaEntrada: string,
  fechaSalida: string,
  observaciones?: string
): ReservaHotel {
  // TODO: valida datos y construye la reserva (confirmada=false)
  void id; void habitacion; void cliente; void fechaEntrada; void fechaSalida; void observaciones;
  throw new Error("TODO");
}

export function confirmarReserva(reservas: ReservaHotel[], id: IdReserva): ReservaHotel[] {
  // TODO: marca confirmada sin mutar el array original
  void reservas; void id;
  throw new Error("TODO");
}

export function filtrarReservas(reservas: ReservaHotel[], filtro: FiltroReserva): ReservaHotel[] {
  // TODO: "todas" | "pendientes" | "confirmadas"
  void reservas; void filtro;
  throw new Error("TODO");
}

export function haySolapamiento(
  reservas: ReservaHotel[],
  habitacion: number,
  entradaISO: string,
  salidaISO: string
): boolean {
  // TODO: devuelve true si hay solape en la misma habitación
  void reservas; void habitacion; void entradaISO; void salidaISO;
  throw new Error("TODO");
}
