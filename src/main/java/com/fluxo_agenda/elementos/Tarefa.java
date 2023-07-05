package com.fluxo_agenda.elementos;

public class Tarefa {
    private String id;
    private String descricao;
    private String status;

    //Construtores
    public Tarefa(String descricao, String status, String id) {
        this.descricao = descricao;
        this.status = status;
        this.id = id;
    }

    public Tarefa () {
        this.descricao = "";
        this.status = "";
    }

    //Compara duas tarefass
    public boolean comparaTarefaPorId(String id){
        return this.id.equals(id);
    }

    public boolean comparaTarefasPorDescricao(String descricao) {
        return this.descricao.toLowerCase().equals(descricao.toLowerCase());
    }

    //Getters e setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}