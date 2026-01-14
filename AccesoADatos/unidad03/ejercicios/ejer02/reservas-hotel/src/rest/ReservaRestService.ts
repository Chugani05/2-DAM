import { Reserva } from "../domain/models";

export class ReservaRestService {
  
  async getReservas(): Promise<Reserva[]> {
    throw new Error("TODO");
  }

  async getReserva(id: string): Promise<Reserva> {
    throw new Error("TODO");
  }

  async createReserva(reserva: Reserva): Promise<Reserva> {
    throw new Error("TODO");
  }

  async updateReserva(id: string, patch: Partial<Reserva>): Promise<Reserva> {
    throw new Error("TODO");
  }

  async deleteReserva(id: string): Promise<void> {
    throw new Error("TODO");
  }
}
