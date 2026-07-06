package com.example.robomarcianoapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.robomarcianoapp.MarcianoPremium
import java.net.URLDecoder

@Composable
fun ResponseScreen(
    message: String,
    navController: NavController
) {

    // decodifica a mensagem (IMPORTANTE)
    val decodedMessage = remember(message) {
        URLDecoder.decode(message, "UTF-8")
    }

    val robot = remember {
        MarcianoPremium {
            "Ação personalizada"
        }
    }

    val response = remember(decodedMessage) {
        robot.responda(decodedMessage)
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

                navController.previousBackStackEntry
                    ?.savedStateHandle
                    ?.set("clear", true)

                navController.popBackStack()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Voltar")
        }
    }
}