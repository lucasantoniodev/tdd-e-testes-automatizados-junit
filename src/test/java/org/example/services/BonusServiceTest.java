package org.example.services;

import org.example.models.Funcionario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

class BonusServiceTest {

    private final Funcionario funcionario = new Funcionario(
            "Teco",
            LocalDate.now(),
            new BigDecimal("25000.00")
    );

    private final BonusService service = new BonusService();

    @Test
    void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
        BigDecimal result = service.cacularBonus(funcionario);

        Assertions.assertEquals(new BigDecimal("0.00"), result);
    }

    @Test
    void bonusDeveriaSerDezPorcentoDoSalario() {
        funcionario.setSalario(new BigDecimal("1000"));
        BigDecimal result = service.cacularBonus(funcionario);

        Assertions.assertEquals(new BigDecimal("100.00"), result);
    }

    @Test
    void bonusDeveriaSerDezPorcentoParaSalarioMaximoDeExatamente10000() {
        funcionario.setSalario(new BigDecimal("10000"));
        BigDecimal result = service.cacularBonus(funcionario);

        Assertions.assertEquals(new BigDecimal("1000.00"), result);
    }
}