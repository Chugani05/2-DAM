import { Reserva } from "../domain/models";
import { ReservaRepository } from "../repositories/ReservaRepository";
import { ReservaRestService } from "../rest/ReservaRestService";

export type DataSource = "LOCAL" | "REMOTO";

export class ReservaService {
  constructor(
    private readonly source: DataSource,
    private readonly repo: ReservaRepository,
    private readonly rest: ReservaRestService
  ) {}

  async init(): Promise<void> {
    if (this.source === "LOCAL") await this.repo.init();
  }

  async listar(): Promise<Reserva[]> {
    return this.source === "LOCAL" ? this.repo.findAll() : this.rest.getReservas();
  }

  async obtener(id: string): Promise<Reserva | null> {
    if (this.source === "LOCAL") return this.repo.findById(id);
    try {
      return await this.rest.getReserva(id);
    } catch (e: any) {
      if (String(e?.message || "").includes("HTTP 404")) return null;
      throw e;
    }
  }

  async crear(reserva: Reserva): Promise<void> {
    if (this.source === "LOCAL") {
      await this.repo.create(reserva);
      return;
    }
    await this.rest.createReserva(reserva);
  }

  async cancelar(id: string): Promise<boolean> {
    if (this.source === "LOCAL") return this.repo.cancel(id);
    try {
      await this.rest.deleteReserva(id);
      return true;
    } catch (e: any) {
      if (String(e?.message || "").includes("HTTP 404")) return false;
      throw e;
    }
  }
}
