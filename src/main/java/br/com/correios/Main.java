package br.com.correios;

import br.com.correios.calculoEntrega.CalcularTaxaDeEntrega;
import br.com.correios.model.Produto;
import br.com.correios.repository.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {
        Repository<Produto> repo = new Repository(new HashSet());

        Produto carrinho = new Produto("Carro de brinquedo", new BigDecimal(10));
        Produto motinha = new Produto("Moto de brinquedo", new BigDecimal(5));
        Produto aviaozinho = new Produto("Avião de brinquedo", new BigDecimal(15));

        repo.salvar(carrinho)
                .salvar(motinha)
                .alterar(motinha,aviaozinho)
                .deletar(carrinho)
                .imprimir();

        //---------------------------------------

        BiFunction<LocalDateTime,LocalDateTime,BigDecimal> calculo = new CalcularTaxaDeEntrega();
        BigDecimal taxa = calculo.apply(LocalDateTime.now(),LocalDateTime.now().plusHours(1L));

        System.out.println(taxa);
    }
}