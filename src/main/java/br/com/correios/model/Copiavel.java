package br.com.correios.model;

import org.apache.commons.lang.SerializationUtils;

import java.io.Serializable;

public interface Copiavel<T> extends Serializable {
    default T copiar(){
        return (T) SerializationUtils.clone(this);
    }
}
