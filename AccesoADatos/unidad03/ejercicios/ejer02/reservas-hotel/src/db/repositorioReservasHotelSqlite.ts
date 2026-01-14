import type BetterSqlite3 from "better-sqlite3";
import { ReservaHotel, NuevaReserva, ActualizacionReserva, IdReserva } from "../models";
import { getDb, initDb } from "./db";

export class RepositorioReservasHotelSqlite {
  private db: BetterSqlite3.Database;

  constructor(db?: BetterSqlite3.Database) {
    this.db = db ?? getDb();
    initDb(this.db);
  }

  obtenerTodas(): ReservaHotel[] {
    throw new Error("TODO");
  }

  crear(nueva: NuevaReserva): ReservaHotel {
    void nueva;
    throw new Error("TODO");
  }

  actualizar(id: IdReserva, patch: ActualizacionReserva): ReservaHotel | undefined {
    void id; void patch;
    throw new Error("TODO");
  }

  borrar(id: IdReserva): boolean {
    void id;
    throw new Error("TODO");
  }

  borrarTodas(): void {
    throw new Error("TODO");
  }
}
