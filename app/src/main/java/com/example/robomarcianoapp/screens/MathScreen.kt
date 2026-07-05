package com.example.robomarcianoapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.foundation.text.KeyboardOptions

import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun MathScreen(
    navController: NavController
) {

    var n1 by remember { mutableStateOf("") }
    var n2 by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text("Calculadora Marciana", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = n1,
            onValueChange = { n1 = it },
            label = { Text("Número 1") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = n2,
            onValueChange = { n2 = it },
            label = { Text("Número 2") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row {
            Button(onClick = {
                result = (n1.toDouble() + n2.toDouble()).toString()
            }) { Text("+") }

            Spacer(Modifier.width(8.dp))

            Button(onClick = {
                result = (n1.toDouble() - n2.toDouble()).toString()
            }) { Text("-") }

            Spacer(Modifier.width(8.dp))

            Button(onClick = {
                result = (n1.toDouble() * n2.toDouble()).toString()
            }) { Text("x") }

            Spacer(Modifier.width(8.dp))

            Button(onClick = {
                result = (n1.toDouble() / n2.toDouble()).toString()
            }) { Text("/") }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text("Resultado: $result")

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Voltar")
        }
    }
}