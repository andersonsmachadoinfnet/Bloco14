package br.anderson.infnet.appdr2tp3.model;

public interface Prototype<T> {
    public T clonar(T obj);
}
