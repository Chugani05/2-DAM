import { Reserva } from "../domain/models";

export interface ReservaRepository {
  /**
   * 
   */
  init(): Promise<void>;

  /**
   * 
   * @param reserva 
   */
  create(reserva: Reserva): Promise<void>;

  /**
   * Returns all the reservations.
   */
  findAll(): Promise<Reserva[]>;

  /**
   * Return all the reservations by ID, if it dosen't exist, it returns null.
   * @param id Unique ID.
   */
  findById(id: string): Promise<Reserva | null>;

  /**
   * Cancel an reservation by it's ID.
   * @param id Unique ID.
   */
  cancel(id: string): Promise<boolean>;

  /**
   * 
   * @param reservas 
   */
  upsertMany(reservas: Reserva[]): Promise<void>;
}
