package com.example.robomarcianoapp

class MartianRobot {

    fun responder(mensagem: String): String {

        return when {

            mensagem.equals("oi", true) ->
                "Olá, humano!"

            mensagem.equals("bom dia", true) ->
                "Bom dia, terrestre!"

            mensagem.equals("boa tarde", true) ->
                "Boa tarde!"

            mensagem.equals("boa noite", true) ->
                "Boa noite!"

            mensagem.contains("nome", true) ->
                "Meu nome é Robô Marciano."

            mensagem.contains("idade", true) ->
                "Não possuo idade."

            mensagem.contains("marte", true) ->
                "Marte é meu planeta de origem."

            mensagem.isBlank() ->
                "Digite uma mensagem."

            else ->
                "Não entendi sua mensagem."
        }

    }

}