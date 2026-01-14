import { FiltroReserva, NuevaReserva, OrigenDatos, ReservaHotel } from "../models";
import { filtrarReservas } from "../reservas";
import { RepositorioReservasHotelSqlite } from "../db/repositorioReservasHotelSqlite";

export interface ClienteReservasRemoto {
  obtenerReservas(): Promise<ReservaHotel[]>;
  crearReservaRemota(nueva: NuevaReserva): Promise<ReservaHotel>;
}

export class ServicioReservasHotel {
  constructor(
    private repoLocal: RepositorioReservasHotelSqlite,
    private remoto: ClienteReservasRemoto
  ) {}

  async listar(origen: OrigenDatos, filtro: FiltroReserva): Promise<ReservaHotel[]> {
    // TODO: si origen es remoto, pedir al cliente remoto y aplicar filtro
    //       si origen es local, leer del repo y aplicar filtro
    void origen; void filtro;
    throw new Error("TODO");
  }

  async crear(origen: OrigenDatos, nueva: NuevaReserva): Promise<ReservaHotel> {
    // TODO: crear en remoto o en local según origen
    void origen; void nueva;
    throw new Error("TODO");
  }

  async sincronizarRemotoALocal(): Promise<{ importadas: number }> {
    // TODO: descargar remoto, borrarTodas local, insertar una a una y devolver importadas
    throw new Error("TODO");
  }
}
