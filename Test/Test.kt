import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class CalculadoraTest {

    @Test
    fun testSuma() {
        val tokens = arrayListOf("2", "+", "3")
        val result = captureOutput { calculadora(tokens) }
        assertEquals("Resultado: 5.0", result)
    }

    @Test
    fun testResta() {
        val tokens = arrayListOf("5", "-", "3")
        val result = captureOutput { calculadora(tokens) }
        assertEquals("Resultado: 2.0", result)
    }

    @Test
    fun testMultiplicacion() {
        val tokens = arrayListOf("2", "*", "3")
        val result = captureOutput { calculadora(tokens) }
        assertEquals("Resultado: 6.0", result)
    }

    @Test
    fun testDivision() {
        val tokens = arrayListOf("6", "/", "3")
        val result = captureOutput { calculadora(tokens) }
        assertEquals("Resultado: 2.0", result)
    }

    @Test
    fun testPotencia() {
        val tokens = arrayListOf("2", "^", "3")
        val result = captureOutput { calculadora(tokens) }
        assertEquals("Resultado: 8.0", result)
    }

    @Test
    fun testRaiz() {
        val tokens = arrayListOf("r", "9")
        val result = captureOutput { calculadora(tokens) }
        assertEquals("Resultado: 3.0", result)
    }

    @Test
    fun testExponencial() {
        val tokens = arrayListOf("e", "1")
        val result = captureOutput { calculadora(tokens) }
        assertEquals("Resultado: 2.718281828459045", result)
    }

    // Helper function to capture console output
    private fun captureOutput(block: () -> Unit): String {
        val stream = ByteArrayOutputStream()
        val originalOut = System.out
        System.setOut(PrintStream(stream))
        try {
            block()
        } finally {
            System.setOut(originalOut)
        }
        return stream.toString().trim()
    }

}
