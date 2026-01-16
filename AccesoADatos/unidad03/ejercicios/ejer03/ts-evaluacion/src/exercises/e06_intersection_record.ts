import { Task } from "../models";

/**
 * E06 – Intersection + Record
 */

export type AdminTask = Task & { adminOnly: true };

export function makeAdminTask(task: Task): AdminTask {
  // devuelve task + adminOnly=true (sin mutar task original)
  return {id: task.id, title: task.title, completed: task.completed, createdAt: task.createdAt, adminOnly: true}
}

export function buildAuthHeaders(token: string): Record<string, string> {
  // { Authorization: "Bearer <token>", "Content-Type": "application/json" } token trim no vacío
  const trimmed = token.trim();
  if (trimmed.length > 0) {
    return { Authorization: `Bearer ${trimmed}`, "Content-Type": "application/json" }
  } 
  throw new Error("invalid token")
}

export function groupByCompleted(tasks: Task[]): Record<"done" | "pending", Task[]> {
  // retorna { done: [...], pending: [...] } (arrays nuevos)
  const pending = tasks.filter(task => !task.completed);
  const completed = tasks.filter(task => task.completed);
  return { done: completed, pending: pending };
}
