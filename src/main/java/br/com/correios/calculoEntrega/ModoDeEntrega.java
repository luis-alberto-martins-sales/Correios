package br.com.correios.calculoEntrega;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.function.BiPredicate;

public enum ModoDeEntrega {
    COMUM((t1, t2) -> t1.plusDays(15L).isAfter(t2),
            new BigDecimal(5)),
    SEDEX_12((t1, t2) ->
            t1.truncatedTo(ChronoUnit.DAYS).plusDays(1L).plusHours(12L).isAfter(t2),
            new BigDecimal(20)),
    SEDEX_HOJE((t1, t2) -> ChronoUnit.DAYS.between(t1,t2)==0,
            new BigDecimal(25));

    private final BiPredicate<LocalDateTime, LocalDateTime> condicao;
    private final BigDecimal taxa;

    ModoDeEntrega(BiPredicate<LocalDateTime, LocalDateTime> condicao, BigDecimal taxa){
        this.condicao=condicao;
        this.taxa=taxa;
    }

    public BigDecimal getTaxa(){
        return this.taxa;
    }

    public Boolean test(LocalDateTime t1, LocalDateTime t2){
        return this.condicao.test(t1, t2);
    }


}
