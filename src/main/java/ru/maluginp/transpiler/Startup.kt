package ru.maluginp.transpiler

class Startup {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Parser().execute()
        }
    }
}
