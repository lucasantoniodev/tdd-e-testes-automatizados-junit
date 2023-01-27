package org.example.services;

import org.example.models.Desempenho;
import org.example.models.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.function.BiFunction;

public class ReajusteService {

    public void concederReajuste(Funcionario funcionario, Desempenho desempenho) {
        BigDecimal salario = funcionario.getSalario();
        BiFunction<BigDecimal, String, BigDecimal> reajuste = (salarioAtual, ajuste) -> {
            BigDecimal beneficio = salarioAtual.multiply(new BigDecimal(ajuste).setScale(2, RoundingMode.HALF_UP));

            return salarioAtual.add(beneficio).setScale(2, RoundingMode.HALF_UP);
        };

        switch (desempenho) {
            case A_DESEJAR:
                funcionario.setSalario(reajuste.apply(salario, "0.03"));
                break;
            case BOM:
                funcionario.setSalario(reajuste.apply(salario, "0.15"));
                break;
            case OTIMO:
                funcionario.setSalario(reajuste.apply(salario, "0.20"));
                break;
        }
    }
}
