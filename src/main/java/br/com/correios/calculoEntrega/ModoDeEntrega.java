package br.com.correios.calculoEntrega;

import java.math.BigDecimal;

public enum ModoDeEntrega {
    COMUM(new BigDecimal(5)),
    SEDEX_12(new BigDecimal(20)),
    SEDEX_HOJE(new BigDecimal(25));

    private final BigDecimal taxa;

    ModoDeEntrega(BigDecimal taxa){
        this.taxa=taxa;
    }
}
