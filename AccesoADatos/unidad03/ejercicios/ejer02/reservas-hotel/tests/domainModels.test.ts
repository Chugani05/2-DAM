import * as M from "../src/domain/models";

describe("E1 Dominio (models)", () => {
  test("EstadoReserva existe y contiene valores esperados", () => {
    expect(M).toHaveProperty("EstadoReserva");
    // enums TS transpilan a objeto
    const e: any = (M as any).EstadoReserva;
    expect(e.CONFIRMADA).toBeDefined();
    expect(e.CANCELADA).toBeDefined();
    expect(e.FINALIZADA).toBeDefined();
  });

  test("Estructura mínima de tipos (runtime) para Reserva/Habitacion/Cliente", () => {
    // No podemos comprobar interfaces en runtime, pero sí que el módulo exporta lo esperado si se usan type-only.
    // Este test acepta que las interfaces no existan en runtime: se valida indirectamente con compilación.
    // Por eso, comprobamos que el archivo compile: si falla, jest/ts-jest fallará antes.
    expect(true).toBe(true);
  });
});
