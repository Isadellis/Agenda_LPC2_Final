package com.agenda.elementos;

import java.util.ArrayList;

public class Tarefa {
    private String descricao;

    private String titulo;

    private boolean concluida;

    //Construtores
    public Tarefa(String descricao, String titulo, boolean concluida) {
        this.descricao = descricao;
        this.titulo = titulo;
        this.concluida = concluida;
    }

    public Tarefa () {
        this.descricao = "";
        this.titulo = "";
        this.concluida = false;
    }

    //Compara duas tarefass
    public boolean comparaTarefa (String descrica, String titulo, boolean concluida){
        return ((this.descricao.equals(descricao)) && (this.titulo.equals(titulo)) && (this.concluida == concluida));
    }

    //Getters e setterss
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }
}