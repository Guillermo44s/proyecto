package com.example.proyecto2

class Fibonacci {

    fun sequenceFibonacci(n: Int): List<Int> {

        val fibonacciList = mutableListOf(0, 1) //Creamos una lista mutable, capas de cambiar.
        for (i in 2..n) {
            val next = fibonacciList[i - 1] + fibonacciList[i - 2]
            fibonacciList.add(next)
        }

      return fibonacciList
    }
}
