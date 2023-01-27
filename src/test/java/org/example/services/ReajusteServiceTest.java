package org.example.services;

/* O sistema deve permitir que os funcionários recebam um reajuste salarial anual baseado em seu desempenho,
*  obedecendo as seguintes regras:
*
*  1 - Se o desempenho foi "A desejar", reajuste será apenas de 3% do salário;
* 2 - Se o desempenho foi "Bom", reajsute será de 15% do salário;
* 3 - Se o desempenho foi "Ótimo", reajuste será de 20% do salário;
* */


import org.example.models.Desempenho;
import org.example.models.Funcionario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ReajusteServiceTest {

    @Test
    public void reajusteDeveriaSerDeTresPorcentoQuandoDesempenhoForADesejar(){
        ReajusteService service = new ReajusteService();

        Funcionario funcionario = new Funcionario("Ana", LocalDate.now(), new BigDecimal("1000"));


        service.concederReajuste(funcionario, Desempenho.A_DESEJAR);

        Assertions.assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }
}
