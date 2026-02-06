import { useEffect, useState } from "react";
import { useFocusEffect } from "@react-navigation/native";
import { useCallback } from "react";
import {
  View,
  Text,
  FlatList,
  StyleSheet,
  Pressable,
  ActivityIndicator,
  RefreshControl,
  TextInput,
  Button,
  Alert,
} from "react-native";
import { useRouter } from "expo-router";
import { getToken, clearToken, listHabits, createHabit, Habit } from "./api";

export default function HabitListScreen() {
  const router = useRouter();
  const [habits, setHabits] = useState<Record<string, Habit>>({});
  const [loading, setLoading] = useState(true);
  const [refreshing, setRefreshing] = useState(false);
  const [newDesc, setNewDesc] = useState("");

  const fetchHabits = async () => {
    try {
      const data = await listHabits();
      setHabits(data);
    } catch (e: any) {
      if (e.message?.includes("401") || e.message?.includes("Unauthorized")) {
        router.replace("/login");
      } else {
        Alert.alert("Error", e.message || "No se pudieron obtener los hábitos");
      }
    } finally {
      setLoading(false);
      setRefreshing(false);
    }
  };

  useFocusEffect(
    useCallback(() => {
      (async () => {
        const token = await getToken();
        if (!token) {
          router.replace("/login");
        } else {
          setLoading(true);
          await fetchHabits();
        }
      })();
    }, []),
  );

  const handleLogout = async () => {
    await clearToken();
    router.replace("/login");
  };

  const renderItem = ({ item }: { item: [string, Habit] }) => {
    const [id, habit] = item;
    return (
      <Pressable
        style={styles.item}
        onPress={() =>
          router.push({ pathname: "/habit/[hid]", params: { hid: id } })
        }
      >
        <Text style={styles.title}>{habit.description}</Text>
        <Text>Racha actual: {habit.current_streak}</Text>
        <Text>Máxima racha: {habit.max_streak}</Text>
      </Pressable>
    );
  };

  const handleCreate = async () => {
    if (!newDesc.trim()) {
      Alert.alert("Error", "La descripción no puede estar vacía");
      return;
    }
    try {
      await createHabit(newDesc.trim());
      setNewDesc("");
      await fetchHabits();
    } catch (e: any) {
      Alert.alert("Error", e.message || "No se pudo crear el hábito");
    }
  };

  if (loading) {
    return (
      <View style={styles.center}>
        <ActivityIndicator size="large" />
      </View>
    );
  }

  return (
    <View style={styles.container}>
      <View style={styles.header}>
        <Text style={styles.headerTitle}>Mis Hábitos</Text>
        <Pressable onPress={handleLogout}>
          <Text style={styles.logout}>Cerrar sesión</Text>
        </Pressable>
      </View>

      <View style={styles.createContainer}>
        <TextInput
          placeholder="Nuevo hábito"
          value={newDesc}
          onChangeText={setNewDesc}
          style={styles.input}
        />
        <Button title="Crear" onPress={handleCreate} />
      </View>

      <FlatList
        data={Object.entries(habits)}
        keyExtractor={([id]) => id}
        renderItem={renderItem}
        refreshControl={
          <RefreshControl
            refreshing={refreshing}
            onRefresh={() => {
              setRefreshing(true);
              fetchHabits();
            }}
          />
        }
        ListEmptyComponent={<Text>No tienes hábitos.</Text>}
      />
    </View>
  );
}

const styles = StyleSheet.create({
  container: { flex: 1, padding: 16, backgroundColor: "#fff" },
  header: {
    flexDirection: "row",
    justifyContent: "space-between",
    marginBottom: 12,
  },
  headerTitle: { fontSize: 22, fontWeight: "600" },
  logout: { color: "#d9534f" },
  createContainer: {
    flexDirection: "row",
    marginBottom: 12,
    alignItems: "center",
  },
  input: {
    flex: 1,
    height: 40,
    borderColor: "#d1d5db",
    borderWidth: 1,
    borderRadius: 8,
    paddingHorizontal: 8,
    marginRight: 8,
  },
  item: { padding: 12, borderBottomWidth: 1, borderBottomColor: "#eee" },
  title: { fontSize: 18, fontWeight: "500" },
  center: { flex: 1, justifyContent: "center", alignItems: "center" },
});
