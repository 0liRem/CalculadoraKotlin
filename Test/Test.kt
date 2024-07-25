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
