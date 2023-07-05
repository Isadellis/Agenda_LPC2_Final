package com.fluxo_agenda;

import com.fluxo_agenda.elementos.Tarefa;
import com.excecao.DuplicidadeException;

import java.util.ArrayList;

public class OperacoesAgenda {
    private ArrayList<Tarefa> tarefas;

    public OperacoesAgenda(ArrayList<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    public OperacoesAgenda() {
        this.tarefas = new ArrayList<>();
    }

    //adiciona uma nova tarefa na agenda
    public void adicionarTarefa (String descricao, String status) throws DuplicidadeException {
        for (Tarefa tarefa : tarefas)
            if(tarefa.comparaTarefasPorDescricao(descricao))
                throw new DuplicidadeException();

        if(tarefas.isEmpty())
            tarefas.add(new Tarefa(descricao, status, String.valueOf(tarefas.size())));
        else
            tarefas.add(new Tarefa(descricao, status, String.valueOf(Integer.valueOf(tarefas.get(tarefas.size() - 1).getId()) + 1)));

    }

    //remove uma tarefa da agenda
    public boolean removeTarefa (String id) {
        for (Tarefa tarefa : tarefas)
            if(tarefa.comparaTarefaPorId(id))
                return tarefas.remove(tarefa);

        return false;
    }

    //edita uma tarefa da agenda
    public boolean editarTarefa (String id, String descricao, String status) {
        for (Tarefa tarefa : tarefas)
            if(tarefa.comparaTarefaPorId(id)) {
                tarefa.setStatus(status);
                tarefa.setDescricao(descricao);

                return true;
            }

        return false;
    }

    public ArrayList<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(ArrayList<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }
}