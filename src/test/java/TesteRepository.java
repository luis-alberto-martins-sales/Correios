
import br.com.correios.model.Carteiro;
import br.com.correios.model.Produto;
import br.com.correios.repository.Repository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.NoSuchElementException;

public class TesteRepository {

    @Test
    public void deveSalvarProduto(){
        Repository<Produto> repo = new Repository(new HashSet());
        Produto carrinho1 = new Produto("Carro de brinquedo", new BigDecimal(10));
        repo.salvar(carrinho1);
        Produto carrinho2 = repo.buscar(carrinho1.copiar());
        Assert.assertEquals(carrinho1,carrinho2);
    }

    @Test
    public void deveAlterarProduto(){
        Repository<Produto> repo = new Repository(new HashSet<>());
        Produto carrinho = new Produto("Carro de brinquedo", new BigDecimal(10));
        repo.salvar(carrinho);
        Produto motinha = new Produto("Moto de brinquedo", new BigDecimal(5));
        repo.alterar(carrinho,motinha);
        Assertions.assertThrows(NoSuchElementException.class,()-> repo.buscar(carrinho));
        Assert.assertEquals(motinha.copiar(),repo.buscar(motinha));
    }

    @Test
    public void deveBuscarProduto(){
        Repository<Produto> repo = new Repository(new HashSet<>());
        Produto carrinho1 = new Produto("Carro de brinquedo", new BigDecimal(10));
        repo.salvar(carrinho1);
        Produto carrinho2 = repo.buscar(carrinho1.copiar());
        Assert.assertEquals(carrinho1,carrinho2);
    }

    @Test
    public void deveDeletarProduto(){
        Repository<Produto> repo = new Repository(new HashSet<>());
        Produto carrinho1 = new Produto("Carro de brinquedo", new BigDecimal(10));
        repo.salvar(carrinho1)
                        .deletar(carrinho1);
        Assertions.assertThrows(NoSuchElementException.class,()->repo.buscar(carrinho1));
    }

    @Test
    public void deveTestarCarteiro(){
        Repository<Carteiro> repo = new Repository(new HashSet<>());

        Carteiro adalberto = new Carteiro("Adalberto", "1");
        Carteiro bernardo = new Carteiro("Bernardo", "2");
        Carteiro charles = new Carteiro("Charles", "3");
        Carteiro dionisio = new Carteiro("Dionísio", "4");

        Carteiro carteiro = repo.salvar(adalberto)
                .salvar(bernardo)
                .alterar(bernardo,charles)
                .salvar(dionisio)
                .deletar(charles)
                .buscar(adalberto.copiar());

        Assert.assertEquals(adalberto,carteiro);
    }
}
