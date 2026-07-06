package com.example.robomarcianoapp

fun interface MarcianoInterface {
    fun agir(): String
}

open class Marciano {

    private val pergunta = "Certamente"
    private val grito = "Opa! Calma aí!"
    private val perguntaGrito = "Relaxa, eu sei o que estou fazendo!"
    private val eu = "A responsabilidade é sua"
    private val vazio = "Não me incomode"
    private val outro = "Tudo bem, como quiser"

    open fun responda(comando: String): String {

        return when {

            comando.isBlank() ->
                vazio

            comando.contains("eu", ignoreCase = true) ->
                eu

            comando.contains("?") &&
                    comando.split(" ").any { it == it.uppercase() && it.isNotBlank() } ->
                perguntaGrito

            comando.split(" ").any { it == it.uppercase() && it.isNotBlank() } ->
                grito

            comando.contains("?") ->
                pergunta

            else ->
                outro
        }
    }
}