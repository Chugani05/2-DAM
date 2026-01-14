export enum EstadoReserva {
  CONFIRMADA = "CONFIRMADA",
  CANCELADA = "CANCELADA",
  FINALIZADA = "FINALIZADA"
}

/**
 * Represents a Cliente
 */
export interface Cliente {
  /**
   * Unique ID.
   */
  id: string;
  /**
   * Name of the cliente.
   */
  nombre: string;
  /**
   * Email of the cliente.
   */
  email: string;

}

/**
 * Represents a Room
 */
export interface Habitacion {
  /**
   * Unique ID.
   */
  id: string;
  /**
   * Room number.
   */
  numero: string;
  /**
   * Room tipe.
   */
  tipo: string;
  /**
   * Price per night of a room.
   */
  precioPorNoche: Number;

}

export interface Reserva {
  /**
   * Unique ID.
   */
  id: string;
  /**
   * Cliente ID.
   */
  clienteId: string;
  /**
   * Room ID.
   */
  habitacionId: string;
  /**
   * Entry date to the room.
   */
  fechaEntrada: string;
  /**
   * Departure date from the room.
   */
  fechaSalida: string;
  /**
   * Reservation status, can be CONFIRMD, CANCELED or FINALLIZED.
   */
  estado: EstadoReserva;

}
