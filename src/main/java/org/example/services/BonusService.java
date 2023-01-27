package org.example.services;

import org.example.models.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BonusService {

    public BigDecimal cacularBonus(Funcionario funcionario) {
        BigDecimal bonus = new BigDecimal("0.1");
        BigDecimal valor = funcionario.getSalario().multiply(bonus);

        BigDecimal bonuxMax = BigDecimal.valueOf(1000);

        if (valor.compareTo(bonuxMax) > 0) {
            valor = BigDecimal.ZERO;
        }
        return valor.setScale(2, RoundingMode.HALF_UP);
    }
}
