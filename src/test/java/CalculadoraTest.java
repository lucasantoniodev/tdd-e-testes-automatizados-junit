import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class CalculadoraTest {

    private final Calculadora calc = new Calculadora();

    @Test
    public void TestarMetodoSomarDaCalculadora() {
        int result = calc.somar(3, 7);

        Assertions.assertEquals(10, result);
    }
}
