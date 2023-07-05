package com.excecao;

public class DuplicidadeException extends Exception{

    public DuplicidadeException() {
        super("Tarefa duplicada");
    }
}