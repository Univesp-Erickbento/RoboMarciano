package com.example.robomarcianoapp

class MarcianoPremium(
    private val acao: MarcianoInterface
) : Marciano() {

    fun agir(): String {
        return acao.agir()
    }

    override fun responda(comando: String): String {

        return if (comando.equals("agir", ignoreCase = true)) {

            "É pra já!\n${agir()}"

        } else {

            super.responda(comando)
        }
    }
}