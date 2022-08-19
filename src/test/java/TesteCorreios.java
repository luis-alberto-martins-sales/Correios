import br.com.correios.calculoEntrega.CalcularTaxaDeEntrega;
import br.com.correios.calculoEntrega.ModoDeEntrega;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.function.BiFunction;

public class TesteCorreios {
    private final BiFunction<LocalDateTime,LocalDateTime,BigDecimal> calculo =
            new CalcularTaxaDeEntrega();

    @Test
    public void deveCalcularTaxaEntregaComum(){
        BigDecimal taxa = calculo.apply(LocalDateTime.MIN,LocalDateTime.MIN.plusDays(5));
        Assert.assertEquals(ModoDeEntrega.COMUM.getTaxa(),taxa);
    }

    @Test
    public void deveCalcularTaxaSEDEX12(){
        BigDecimal taxa = calculo.apply(LocalDateTime.MIN,LocalDateTime.MIN.plusDays(1));
        Assert.assertEquals(ModoDeEntrega.SEDEX_12.getTaxa(),taxa);
    }

    @Test
    public void deveCalcularTaxaSEDEXHoje(){
        BigDecimal taxa = calculo.apply(LocalDateTime.MIN,LocalDateTime.MIN.plusHours(1));
        Assert.assertEquals(ModoDeEntrega.SEDEX_HOJE.getTaxa(),taxa);
    }
}
