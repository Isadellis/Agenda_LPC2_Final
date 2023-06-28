package com.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class JanelaDisciplinasController {

    @FXML
    private Button botaoNovaDisciplina;

    @FXML
    private Button botaoSair;

    @FXML
    void handlerNovaDisciplina(ActionEvent event) {
        //Adicionar novo botão de disciplina
    }

    @FXML
    void handlerSair(ActionEvent event) {
        System.exit(1);
    }

}