package br.com.correios.calculoEntrega;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BiFunction;

public class CalcularTaxaDeEntrega implements BiFunction<LocalDateTime,LocalDateTime,BigDecimal> {

    @Override
    public BigDecimal apply(LocalDateTime tempoPostagem, LocalDateTime tempoEntrega) {

        return Arrays.stream(ModoDeEntrega.values())
                .filter(m->m.test(tempoPostagem, tempoEntrega))
                .map(ModoDeEntrega::getTaxa)
                .sorted(Comparator.reverseOrder())
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}

