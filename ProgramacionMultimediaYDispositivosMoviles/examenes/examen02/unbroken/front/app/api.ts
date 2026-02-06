import AsyncStorage from "@react-native-async-storage/async-storage";

const API_BASE = "http://10.0.2.2:5000"; //https://127.0.0.1:5555/

export async function setToken(token: string): Promise<void> {
  await AsyncStorage.setItem("authToken", token);
}

export async function getToken(): Promise<string | null> {
  return await AsyncStorage.getItem("authToken");
}

export async function clearToken(): Promise<void> {
  await AsyncStorage.removeItem("authToken");
}

async function authHeaders(): Promise<HeadersInit> {
  const token = getToken();
  return token
    ? {
        Auth: `Bearer${token}`,
        "Content-Type": "application/json",
      }
    : {
        "Content-Type": "application/json",
      };
}

async function apiRequest<T>(
  endpoint: string,
  options: RequestInit = {},
): Promise<T> {
  const url = `${API_BASE}${endpoint}`;
  const headers = await authHeaders();
  const response = await fetch(url, { ...options, headers });
  if (!response.ok) {
    const err = await response.text();
    throw new Error(`API error ${response.status}: ${err}`);
  }
  return (await response.json()) as T;
}

export async function registerUser(alias: string, password: string) {
  return apiRequest<{ msg: string }>(`/auth/register`, {
    method: "POST",
    body: JSON.stringify({ alias, password }),
  });
}

export async function loginUser(alias: string, password: string) {
  const data = await apiRequest<{ access_token: string }>(`/auth/login`, {
    method: "POST",
    body: JSON.stringify({ alias, password }),
  });
  await setToken(data.access_token);
  console.log(data.access_token);
  return data.access_token;
}

export type Habit = {
  id: string;
  description: string;
  start_date: string;
  last_check_date: string;
  logs: Record<string, boolean>;
  current_streak: number;
  max_streak: number;
  total_days: number;
  fulfilled_days: number;
};

export async function listHabits(): Promise<Record<string, Habit>> {
  return apiRequest<Record<string, Habit>>(`/habits/`);
}

export async function createHabit(description: string): Promise<Habit> {
  return apiRequest<Habit>(`/habits/`, {
    method: "POST",
    body: JSON.stringify({ description }),
  });
}

export async function editHabit(
  habitId: string,
  description: string,
): Promise<Habit> {
  return apiRequest<Habit>(`/habits/${habitId}`, {
    method: "PUT",
    body: JSON.stringify({ description }),
  });
}

export async function deleteHabit(habitId: string) {
  return apiRequest<{ msg: string }>(`/habits/${habitId}`, {
    method: "DELETE",
  });
}

export async function checkHabit(
  habitId: string,
  done: boolean,
): Promise<Habit> {
  const endpoint = `/habits/${habitId}/check?done=${done}`;
  return apiRequest<Habit>(endpoint, {
    method: "POST",
  });
}
