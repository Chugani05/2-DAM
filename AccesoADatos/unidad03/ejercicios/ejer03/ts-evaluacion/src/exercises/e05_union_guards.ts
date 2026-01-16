import { JwtPayload, Role } from "../models";

/**
 * E05 – Union + type guards (unknown) + JWT
 */

export function normalizeId(id: string | number): string {
  // number => String; string => trim; vacío => Error
  if (typeof id == "string") {
    if (id.trim().length == 0) {
      throw new Error("Invalid type");
    }
    return id.trim();
  }
  return id.toString();
}

export function isJwtPayload(value: unknown): value is JwtPayload {
  // objeto no null con sub string no vacía, role USER/ADMIN, exp number finito >=0
  throw new Error("TODO");
}

export function requireRole(payload: JwtPayload, role: Role): void {
  // lanza Error si payload.role != role
  if (payload.role != role) {
    throw new Error("Invalid role");
  }
}
