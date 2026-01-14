import { Reserva } from "../domain/models";
import { ReservaRepository } from "../repositories/ReservaRepository";
import { ReservaRestService } from "../rest/ReservaRestService";

export async function syncRemotoALocal(
  repo: ReservaRepository,
  rest: ReservaRestService
): Promise<{ descargadas: number; insertadas: number }> {
  const remotas: Reserva[] = await rest.getReservas();
  // repo ya puede estar inicializado en tests, pero init debe ser idempotente
  await repo.init();
  const antes = (await repo.findAll()).length;
  await repo.upsertMany(remotas);
  const despues = (await repo.findAll()).length;
  return { descargadas: remotas.length, insertadas: Math.max(0, despues - antes) };
}
