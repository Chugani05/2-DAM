import { useEffect, useState } from "react";
import { MaterialCommunityIcons } from "@expo/vector-icons";
import {
  View,
  Text,
  StyleSheet,
  Button,
  ActivityIndicator,
  Alert,
  Modal,
  TextInput,
  TouchableOpacity,
} from "react-native";
import { useLocalSearchParams, useRouter } from "expo-router";
import { Habit, checkHabit, listHabits, editHabit, deleteHabit } from "../api";

export default function HabitDetailScreen() {
  const router = useRouter();
  const { hid } = useLocalSearchParams<{ hid: string }>();
  const [habit, setHabit] = useState<Habit | null>(null);
  const [loading, setLoading] = useState(true);
  const [checking, setChecking] = useState(false);
  const [modalVisible, setModalVisible] = useState(false);
  const [newDesc, setNewDesc] = useState("");

  const loadHabit = async () => {
    try {
      const all = await listHabits();
      const h = all[hid];
      setHabit(h);
      setNewDesc(h?.description ?? "");
    } catch (e: any) {
      Alert.alert("Error", e.message || "No se pudo cargar el hábito");
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    loadHabit();
  }, [habit]);

  const handleCheck = async (done: boolean) => {
    setChecking(true);
    try {
      const updated = await checkHabit(hid, done);
      setHabit(updated);
      Alert.alert("Éxito", "Hábito marcado como cumplido");
    } catch (e: any) {
      Alert.alert("Error", e.message || "No se pudo registrar");
    } finally {
      setChecking(false);
    }
  };

  const handleEdit = async () => {
    if (!newDesc.trim()) {
      Alert.alert("Error", "La descripción no puede estar vacía");
      return;
    }
    try {
      const updated = await editHabit(hid, newDesc.trim());
      setHabit(updated);
      setModalVisible(false);
      Alert.alert("Éxito", "Hábito actualizado");
    } catch (e: any) {
      Alert.alert("Error", e.message || "No se pudo editar");
    }
  };

  const handleDelete = async () => {
    Alert.alert(
      "Confirmar borrado",
      "Eliminar este hábito borrará todas sus estadísticas permanentemente.",
      [
        { text: "Cancelar", style: "cancel" },
        {
          text: "Eliminar",
          style: "destructive",
          onPress: async () => {
            try {
              await deleteHabit(hid);
              router.dismissAll();
              router.navigate("/");
            } catch (e: any) {
              Alert.alert("Error", e.message || "No se pudo eliminar");
            }
          },
        },
      ],
    );
  };

  if (loading) {
    return (
      <View style={styles.center}>
        <ActivityIndicator size="large" />
      </View>
    );
  }

  if (!habit) {
    return (
      <View style={styles.center}>
        <Text>Hábito no encontrado.</Text>
        <Button title="Volver" onPress={() => router.back()} />
      </View>
    );
  }

  const today = new Date().toISOString().slice(0, 10);

  const todayLog = habit.last_check_date == today;
  const fireColor = todayLog ? "#e25822" : "#cccccc";

  return (
    <View style={styles.container}>
      <Text style={styles.title}>{habit.description}</Text>

      <View style={styles.iconRow}>
        <MaterialCommunityIcons name="fire" size={36} color={fireColor} />
        <Text style={styles.iconLabel}>
          Racha: {habit.current_streak}
          día{habit.current_streak !== 1 ? "s " : " "}
        </Text>
      </View>

      <View style={styles.iconRow}>
        <MaterialCommunityIcons name="check-circle" size={24} color="#4caf50" />
        <Text style={styles.iconLabel}>Cumplidos: {habit.fulfilled_days}</Text>
      </View>

      <View style={styles.iconRow}>
        <MaterialCommunityIcons name="star" size={24} color="#ffd700" />
        <Text style={styles.iconLabel}>Máxima racha: {habit.max_streak}</Text>
      </View>

      <Text style={styles.info}>
        Inicio: {habit.start_date} ({habit.fulfilled_days} días cumplidos)
      </Text>

      {!todayLog && (
        <View style={styles.buttons}>
          <Button
            title="Cumplí hoy"
            onPress={() => handleCheck(true)}
            disabled={checking}
          />
        </View>
      )}

      <View style={styles.editRow}>
        <TouchableOpacity
          onPress={() => setModalVisible(true)}
          style={styles.editButton}
        >
          <MaterialCommunityIcons name="pencil" size={24} color="#2563eb" />
        </TouchableOpacity>
        <TouchableOpacity onPress={handleDelete} style={styles.editButton}>
          <MaterialCommunityIcons name="delete" size={24} color="#d9534f" />
        </TouchableOpacity>
      </View>

      <Button title="Volver" onPress={() => router.back()} />

      <Modal visible={modalVisible} animationType="slide" transparent>
        <View style={styles.modalOverlay}>
          <View style={styles.modalContent}>
            <Text style={styles.modalTitle}>Renombrar hábito</Text>
            <TextInput
              style={styles.modalInput}
              value={newDesc}
              onChangeText={setNewDesc}
            />
            <View style={styles.modalButtons}>
              <Button title="Cancelar" onPress={() => setModalVisible(false)} />
              <Button title="Guardar" onPress={handleEdit} />
            </View>
          </View>
        </View>
      </Modal>
    </View>
  );
}

const styles = StyleSheet.create({
  container: { flex: 1, padding: 16, backgroundColor: "#fff" },
  title: { fontSize: 22, fontWeight: "600", marginBottom: 12 },
  iconRow: { flexDirection: "row", alignItems: "center", marginVertical: 8 },
  iconLabel: { marginLeft: 8, fontSize: 16 },
  info: { marginTop: 12, fontSize: 14, color: "#555" },
  buttons: { marginTop: 16, alignItems: "center" },
  editRow: { flexDirection: "row", justifyContent: "flex-end", marginTop: 12 },
  editButton: { marginHorizontal: 8 },
  modalOverlay: {
    flex: 1,
    backgroundColor: "rgba(0,0,0,0.5)",
    justifyContent: "center",
    alignItems: "center",
  },
  modalContent: {
    width: "80%",
    backgroundColor: "#fff",
    borderRadius: 8,
    padding: 16,
    elevation: 5,
  },
  modalTitle: { fontSize: 18, fontWeight: "600", marginBottom: 12 },
  modalInput: {
    borderWidth: 1,
    borderColor: "#ddd",
    borderRadius: 6,
    padding: 8,
    marginBottom: 12,
  },
  modalButtons: { flexDirection: "row", justifyContent: "space-between" },
  center: { flex: 1, justifyContent: "center", alignItems: "center" },
});
