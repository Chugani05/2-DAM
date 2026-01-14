export interface ReservaHotel {
  id: number;
  habitacion: number;
  cliente: string;
  fechaEntrada: string; // ISO (en tests puede ser "i" y "f" para simplificar)
  fechaSalida: string;
  confirmada: boolean;
  observaciones?: string;
}

export type IdReserva = number;

export type FiltroReserva = "todas" | "pendientes" | "confirmadas";

export type OrigenDatos = "local" | "remoto";

export type NuevaReserva = Omit<ReservaHotel, "id">;

export type ActualizacionReserva = Partial<Omit<ReservaHotel, "id">>;
