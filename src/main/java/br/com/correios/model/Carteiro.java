package br.com.correios.model;

import java.util.Objects;

public class Carteiro implements Copiavel<Carteiro>{
    private String nome;
    private String matricula;

    public Carteiro(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carteiro carteiro = (Carteiro) o;
        return nome.equals(carteiro.nome) && matricula.equals(carteiro.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, matricula);
    }

    @Override
    public String toString() {
        return "Carteiro{" +
                "nome='" + nome + '\'' +
                ", matricula='" + matricula + '\'' +
                '}';
    }
}
