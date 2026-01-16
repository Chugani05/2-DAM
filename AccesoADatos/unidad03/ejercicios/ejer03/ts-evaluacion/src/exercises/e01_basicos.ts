/**
 * E01 – Tipos básicos: string/number/boolean/null/undefined
 */

export function normalizeBearer(authHeader: string): string {
  // trim + "Bearer <token>" (case-insensitive), colapsa espacios a 1, Error si inválido
  if (!authHeader) {
    throw new Error("authHeader can't be null or empty");
  }
  const normalized = authHeader.trim().split(/\s+/);
  if (normalized[0].toLowerCase() != "bearer" || normalized.length != 2) {
    throw new Error("Invalid authHeader");
  }
  return "B" + normalized.join(" ").substring(1);
}

export function clamp01(value: number): number {
  // Devuelve value limitado a [0,1]. Error si NaN o no finito.
  if (Number.isNaN(value) || !Number.isFinite(value)) {
    throw new Error("Invalid value");
  }
  return Math.max(Math.min(value, 1), 0);
}

export function safeBool(value: boolean | null | undefined): boolean {
  // null/undefined => false; boolean => mismo valor
  return value == null || value == undefined ? false : value;
}
