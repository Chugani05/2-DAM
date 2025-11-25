import { useRouter } from "expo-router";
import React, { useContext, useState } from "react";
import { Button, Text, TextInput, View, Alert } from "react-native";
import { AuthContext } from "../context/AuthContext";

export default function Login() {
  const { login, token } = useContext(AuthContext);
  const [expenses, setExpenses] = useState([
    {
      id: "e.id",
      desc: "e.description",
      amount: "e.amount",
      paid_by: "e.paid_by",
    },
  ]);
  const router = useRouter();

  const handleDelete = (id: string) => {
    console.log("Borro la id " + id);
    Alert.alert("Voy a borrar");
    for (let i=0; i<expenses.length; i++) {
      console.log(expenses[i]);
      if (expenses[i].id == id) {
        expenses.splice(i, 1);
        let newExpenses = [...expenses];
        setExpenses(newExpenses);
      }
    }
  };

  const handleEdit = () => {
    Alert.alert("Voy a edit");
  };

  return (
    <View style={{ flex: 1, justifyContent: "center", padding: 20 }}>
      <Text>Mi grupo</Text>
      {expenses.map((e) => (
        <View key={e.id}>
          <Text
            onPress={() => router.replace("/groupdetail")}
          >{`Precio: ${e.amount} - ${e.desc}`}</Text>
          <Button title="Editar" onPress={handleEdit} />
          <Button title="Borrar" onPress={() => handleDelete(e.id)} />
        </View>
      ))}

      <Button title="Volver a mis grupos" onPress={() => router.replace("/")} />
    </View>
  );
}
