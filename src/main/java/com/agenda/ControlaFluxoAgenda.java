package com.agenda;

import com.agenda.elementos.Tarefa;

import java.util.ArrayList;

public class ControlaFluxoAgenda {
    /* conter: um arrayList com as disciplinas ou tarefas (caso não seja criada a aba de disciplina)
     *  método para adicionar e remover elementos do array list, métodos para gravar e alterar o arquivo de texto gerado*/
    private ArrayList<Tarefa> tarefas;

    public ControlaFluxoAgenda(ArrayList<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    public ControlaFluxoAgenda() {
        this.tarefas = new ArrayList<>();
    }

    //adiciona uma nova tarefa na agenda
    public boolean adicionarTarefa (String descricao, String titulo, boolean concluida) {
        return tarefas.add(new Tarefa(descricao, titulo, concluida));
    }

    //remove tarefa da agenda
    public boolean removeTarefa (String descricao, String titulo, boolean concluida) {
        for (Tarefa tarefa : tarefas)
            if(tarefa.comparaTarefa(descricao, titulo, concluida))
                return tarefas.remove(tarefa);

        return false;
    }

    public ArrayList<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(ArrayList<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }
}