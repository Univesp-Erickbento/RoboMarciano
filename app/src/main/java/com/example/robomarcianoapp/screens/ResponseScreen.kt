package com.example.robomarcianoapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.robomarcianoapp.MartianRobot

@Composable
fun ResponseScreen(
    message: String,
    navController: NavController
) {

    // ✔ cria o robô uma única vez
    val robot = remember { MartianRobot() }

    // ✔ calcula resposta baseada na mensagem
    val response = remember(message) {
        robot.responder(message)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text(
            text = "Resposta do Robô 🤖",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text(
                    text = response,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {

                // ✔ avisa MainScreen para limpar campo
                navController.previousBackStackEntry
                    ?.savedStateHandle
                    ?.set("clear", true)

                // ✔ volta para tela principal
                navController.popBackStack()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Voltar")
        }
    }
}