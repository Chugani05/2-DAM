import React, { useState } from "react";
import {
  View,
  Text,
  TextInput,
  Pressable,
  StyleSheet,
  Alert,
  ActivityIndicator,
} from "react-native";
import { useRouter } from "expo-router";
import { loginUser, registerUser } from "./api";

export default function LoginScreen() {
  const router = useRouter();
  const [alias, setAlias] = useState("");
  const [password, setPassword] = useState("");
  const [mode, setMode] = useState<"login" | "register">("login");
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState("");

  const passwordValidator = (password: string): string | null => {
    console.log(password)
    if (password.length < 6) {
      return "La contraseña debe contener al menos 6 caracteres.";
    }
    if (!/[A-Z]/.test(password)) {
      return "La contraseña debe contener al menos una letra mayuscula.";
    }
    if (!/[a-z]/.test(password)) {
      return "La contraseña debe contener al menos una letra minúscula.";
    }
    if (!/\d/.test(password)) {
      return "La contraseña debe contener al menos un número.";
    }
    if (!/[\.$%_?@]/.test(password)) {
      return "La contraseña debe contener al menos un caracter especial.";
    }
    return null;
  }

  const handleAuth = async () => {
    if (!alias || !password) {
      Alert.alert("Error", "Completa alias y contraseña");
      return;
    }
    const validationError = passwordValidator(password);
    if (validationError) {
      setError(validationError);
      return;
    }
    setLoading(true);
    try {
      if (mode === "register") {
        await registerUser(alias, password);
      } 
      await loginUser(alias, password);
      router.replace("/");
    } catch (e: any) {
      Alert.alert("Error", e.message || "Falló la solicitud");
    } finally {
      setLoading(false);
    }
  };

  return (
    <View style={styles.container}>
      <Text style={styles.title}>
        {mode === "login" ? "Iniciar sesión" : "Crear cuenta"}
      </Text>
      <TextInput
        placeholder="Alias"
        value={alias}
        onChangeText={(e) => setAlias(e)}
        style={styles.input}
        autoCapitalize="none"
      />
      <TextInput
        placeholder="Contraseña"
        value={password}
        onChangeText={(e) => setPassword(e)}
        style={styles.input}
        secureTextEntry
      />

      {error ? <Text style={{ color: "red" }}>{error}</Text> : null}

      {loading ? (
        <ActivityIndicator size="large" color="#0066cc" />
      ) : (
        <Pressable style={styles.button} onPress={handleAuth}>
          <Text style={styles.buttonText}>
            {mode === "login" ? "Entrar" : "Registrarse"}
          </Text>
        </Pressable>
      )}
      <Pressable
        onPress={() => setMode(mode === "login" ? "register" : "login")}
      >
        <Text style={styles.toggle}>
          {mode === "login"
            ? "¿No tienes cuenta? Regístrate"
            : "¿Ya tienes cuenta? Inicia sesión"}
        </Text>
      </Pressable>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    padding: 24,
    justifyContent: "center",
    backgroundColor: "#f9fafb",
  },
  title: {
    fontSize: 24,
    fontWeight: "600",
    marginBottom: 24,
    textAlign: "center",
    color: "#111827",
  },
  input: {
    height: 48,
    borderColor: "#d1d5db",
    borderWidth: 1,
    borderRadius: 8,
    paddingHorizontal: 12,
    marginBottom: 16,
    backgroundColor: "#fff",
  },
  button: {
    height: 48,
    backgroundColor: "#2563eb",
    borderRadius: 8,
    justifyContent: "center",
    alignItems: "center",
    marginBottom: 12,
  },
  buttonText: {
    color: "#fff",
    fontSize: 16,
    fontWeight: "600",
  },
  toggle: {
    color: "#2563eb",
    textAlign: "center",
    marginTop: 8,
  },
});
