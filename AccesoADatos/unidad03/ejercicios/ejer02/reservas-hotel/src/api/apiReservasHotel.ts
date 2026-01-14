import { ReservaHotel, IdReserva, NuevaReserva, ActualizacionReserva } from "../models";

const API_URL = "http://localhost:3000/reservas";

export async function obtenerReservas(): Promise<ReservaHotel[]> {
  // TODO: GET /reservas, lanzar error si !ok
  void API_URL;
  throw new Error("TODO");
}

export async function crearReservaRemota(nueva: NuevaReserva): Promise<ReservaHotel> {
  // TODO: POST /reservas, Content-Type JSON, lanzar error si !ok
  void nueva;
  throw new Error("TODO");
}

export async function actualizarReservaRemota(id: IdReserva, patch: ActualizacionReserva): Promise<ReservaHotel> {
  // TODO: PATCH (o PUT) /reservas/{id}, lanzar error si !ok
  void id; void patch;
  throw new Error("TODO");
}

export async function borrarReservaRemota(id: IdReserva): Promise<void> {
  // TODO: DELETE /reservas/{id}, lanzar error si !ok
  void id;
  throw new Error("TODO");
}
