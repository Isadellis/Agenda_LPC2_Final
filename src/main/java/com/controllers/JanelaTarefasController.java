package com.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class JanelaTarefasController {

    @FXML
    private Button botaoEditarTarefas;

    @FXML
    private Button botaoNovaTarefa;

    @FXML
    private Button botaoSair;

    @FXML
    void handlerEditarTarefa(ActionEvent event) {
        //Assim que clicar em editar deve ser possível editar todos os botões
    }

    @FXML
    void handlerNovaTarefa(ActionEvent event) {

    }

    @FXML
    void handlerSair(ActionEvent event) {
        System.exit(1);
    }

}