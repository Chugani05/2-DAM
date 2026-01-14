import sqlite3 from "sqlite3";
import { open, Database } from "sqlite";
import { EstadoReserva, Reserva } from "../domain/models";
import { ReservaRepository } from "./ReservaRepository";

export class SQLiteReservaRepository implements ReservaRepository {
  private db: Database<sqlite3.Database, sqlite3.Statement> | null = null;

  constructor(private readonly filename: string) {}

  async init(): Promise<void> {
    this.db = await open({ filename: this.filename, driver: sqlite3.Database });
    await this.db.exec(`
      PRAGMA foreign_keys = ON;
      CREATE TABLE IF NOT EXISTS reservas (
        id TEXT PRIMARY KEY,
        clienteId TEXT NOT NULL,
        habitacionId TEXT NOT NULL,
        fechaEntrada TEXT NOT NULL,
        fechaSalida TEXT NOT NULL,
        estado TEXT NOT NULL
      );
      CREATE INDEX IF NOT EXISTS idx_reservas_habitacion ON reservas(habitacionId);
    `);
  }

  private ensureDb(): Database<sqlite3.Database, sqlite3.Statement> {
    if (!this.db) throw new Error("DB no inicializada. Llama a init() primero.");
    return this.db;
  }

  async create(reserva: Reserva): Promise<void> {
    const statement = this.db.prepare(
      "INSERT INTO reservas (clienteId, habitacionId, fechaEntrada, fechaSalida, estado) VALUES (?, ?, ?, ?, ?)"
    );
    const execution = statement.run(reserva);
    const reserva.id = Number(execution.lastInsertRowid);
  }

  async findAll(): Promise<Reserva[]> {
    const statement = this.db?.prepare("SELECT * FROM reservas ORDER BY fechaEntrada");
    return statement.all() as Reserva[];
  }

  async findById(id: string): Promise<Reserva | null> {
   const statement = this.db.prepare("SELECT * FROM reservas WHERE id = ?");
    return statement.get(id) as Reserva;
  }

  async cancel(id: string): Promise<boolean> {
    const statement = this.db.prepare(
      "UPDATE reservas SET estado = ? WHERE id = ?"
    );
    const execution = statement.run(
      reservas.estado ? 1 : 0,
      reservas.id
    );
    const hasChanges = execution.changes > 0;
    return hasChanges ? true : false;
  }

  async upsertMany(reservas: Reserva[]): Promise<void> {
    const statement = this.db.prepare(
      "INSERT INTO reservas (clienteId, habitacionId, fechaEntrada, fechaSalida, estado) VALUES (?, ?, ?, ?, ?) ON CONFLICT(id) DO NOTHING"
    );
    const execution = statement.run(reservas);
    const reservas.id = Number(execution.lastInsertRowid);
  }
}
