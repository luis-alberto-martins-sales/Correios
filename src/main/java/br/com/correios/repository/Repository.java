package br.com.correios.repository;

import java.util.Collection;

import br.com.correios.model.Copiavel;

public class Repository<T extends Copiavel<T>> {

    private final Collection<T> colecao;

    public Repository(Collection<T> colecao) {
        this.colecao = colecao;
    }

    public Repository<T> salvar(T t) {
        this.colecao.add(t.copiar());
        return this;
    }

    public Repository<T> alterar(T antigo, T novo) {
        this.deletar(antigo).salvar(novo);
        return this;
    }

    public T buscar( T t) {

        return this.colecao.stream()
                .filter(t::equals)
                .findFirst()
                .get()
                .copiar();
    }

    public Repository<T> deletar(T t) {
        this.colecao.remove(t);
        return this;
    }

    public void imprimir(){
        this.colecao.forEach(System.out::println);
    }

}
