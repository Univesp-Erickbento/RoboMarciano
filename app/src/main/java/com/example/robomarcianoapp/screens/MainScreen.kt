package com.example.robomarcianoapp.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.robomarcianoapp.HistoryManager
import java.net.URLEncoder

@Composable
fun MainScreen(navController: NavController) {

    var mensagem by rememberSaveable { mutableStateOf("") }

    val context = LocalContext.current
    val savedStateHandle = navController.currentBackStackEntry?.savedStateHandle

    // 🔄 limpa campo ao voltar da ResponseScreen
    LaunchedEffect(savedStateHandle) {
        val shouldClear = savedStateHandle?.get<Boolean>("clear")

        if (shouldClear == true) {
            mensagem = ""
            savedStateHandle.remove<Boolean>("clear")
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text(
            text = "Robô Marciano 🤖",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = mensagem,
            onValueChange = { mensagem = it },
            label = { Text("Mensagem") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // 🤖 ENVIAR AO ROBÔ
        Button(
            onClick = {

                if (mensagem.isBlank()) {

                    Toast.makeText(
                        context,
                        "Escreva uma mensagem para o Marciano",
                        Toast.LENGTH_SHORT
                    ).show()

                } else {

                    // ✔ salva no histórico
                    HistoryManager.add(mensagem)

                    // ✔ protege caracteres especiais
                    val encoded = URLEncoder.encode(mensagem, "UTF-8")

                    navController.navigate("response/$encoded")
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Enviar ao Robô")
        }

        Spacer(modifier = Modifier.height(12.dp))

        // 🧮 CALCULADORA
        Button(
            onClick = {
                navController.navigate("math")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calculadora Marciana 🧮")
        }

        Spacer(modifier = Modifier.height(12.dp))

        // 📜 HISTÓRICO
        Button(
            onClick = {
                navController.navigate("history")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Histórico de comandos 📜")
        }
    }
}