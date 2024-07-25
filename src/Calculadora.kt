fun calculadora(tokens: ArrayList<String>) {
    val stack = ArrayDeque<Double>()
    val operators = setOf("+", "-", "*", "/", "^", "r", "e")
    val postfix = ArrayDeque<String>()
    val opStack = ArrayDeque<String>()
    val precedence = mapOf(
        "+" to 1, "-" to 1, "*" to 2, "/" to 2, "^" to 3, "r" to 3, "e" to 3
    )

    // Eliminar espacios y filtrar tokens vacíos
    val cleanedTokens = tokens.map { it.trim() }.filter { it.isNotEmpty() }

    fun toPostfix() {
        for (token in cleanedTokens) {
            when {
                token.toDoubleOrNull() != null -> postfix.add(token)
                token == "(" -> opStack.add(token)
                token == ")" -> {
                    while (opStack.isNotEmpty() && opStack.last() != "(") {
                        postfix.add(opStack.removeLast())
                    }
                    opStack.removeLast()
                }
                token in operators -> {
                    while (opStack.isNotEmpty() && precedence[opStack.last()] ?: 0 >= (precedence[token] ?: 0)) {
                        postfix.add(opStack.removeLast())
                    }
                    opStack.add(token)
                }
                else -> {
                    println("Token no reconocido: $token")
                    return
                }
            }
        }
        while (opStack.isNotEmpty()) {
            postfix.add(opStack.removeLast())
        }
    }

    fun evaluatePostfix() {
        for (token in postfix) {
            when {
                token.toDoubleOrNull() != null -> stack.add(token.toDouble())
                token in operators -> {
                    if (stack.size < 2 && token != "r" && token != "e") {
                        println("Error: Operadores binarios requieren dos operandos.")
                        return
                    }
                    val b = stack.removeLast()
                    val a = if (stack.isNotEmpty()) stack.removeLast() else 0.0

                    val result = when (token) {
                        "+" -> a + b
                        "-" -> a - b
                        "*" -> a * b
                        "/" -> a / b
                        "^" -> Math.pow(a, b)
                        "r" -> Math.sqrt(b)
                        "e" -> Math.exp(b)
                        else -> {
                            println("Operador no soportado.")
                            return
                        }
                    }
                    stack.add(result)
                }
                else -> {
                    println("Token no reconocido: $token")
                    return
                }
            }
        }
        if (stack.size != 1) {
            println("Error: La expresión no está correctamente balanceada.")
        } else {
            println("Resultado: ${stack.last()}")
        }
    }

    toPostfix()
    evaluatePostfix()
}
