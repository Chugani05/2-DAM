import { Role } from "../models";
import { isJwtPayload } from "./e05_union_guards";

/**
 * E04 – Tuples y enum
 */

export type JwtParts = [header: string, payload: string, signature: string];

export function splitJwt(token: string): JwtParts {
  // "a.b.c" => [a,b,c] exactamente 3 partes, si no => Error
  const splited = token.split(".");
  if (splited.length != 3) {
    throw new Error("token has more or less then 3 parts");
  }
  return splited as JwtParts;
}

export function roleFromString(value: string): Role {
  // "ADMIN"|"USER" (case-insensitive) => Role; si no => Error
  const upperCaseValue = value.toUpperCase();
  if (upperCaseValue == "ADMIN" || upperCaseValue == "USER") {
    return upperCaseValue as Role;
  } 
  throw new Error("Invalid role")
}

export function formatUserTag(username: string, role: Role): string {
  // "juan", ADMIN => "juan#ADMIN" (username trim, no vacío)
  const trimmedUsername = username.trim();
  if (trimmedUsername.length == 0) {
    throw new Error("Invalid username");
  }
  return trimmedUsername + "#" + role;
}
