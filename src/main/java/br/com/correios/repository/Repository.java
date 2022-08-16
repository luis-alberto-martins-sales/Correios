package br.com.correios.repository;

public interface Repository<T> {
    void salvar(T t);

    void alterar(T t);

    void buscar(T t);

    void deletar(T t);
}
