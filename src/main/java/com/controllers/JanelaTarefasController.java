package com.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.agenda.ControlaFluxoAgenda;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class JanelaTarefasController {
    @FXML
    private Button botaoEditarTarefas;

    @FXML
    private Button botaoNovaTarefa;

    @FXML
    private Button botaoSair;

    private ControlaFluxoAgenda controlaFluxoAgenda;

    @FXML
    void acaoEditarTarefa(ActionEvent event) {

    }

    @FXML
    void acaoNovaTarefa(ActionEvent event) {
        try {
            //Altera a cena
            Parent root = FXMLLoader.load(getClass().getResource("/com/principal_agenda/adicionar_tarefa.fxml"));
            Scene scene = new Scene(root, 500, 300);

            //Pega o "palco" atual e o altera
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.hide();

            stage.setUserData(controlaFluxoAgenda);

            stage.setTitle("Adicionar tarefa");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();

        } catch (IOException e) {
            System.out.println("Erro ao abrir a aba");
        }
    }

    @FXML
    void acaoAtualizar(ActionEvent event) {

    }

    @FXML
    void acaoSair(ActionEvent event) {
        System.exit(1);
    }


    @FXML
    void initialize() {
        controlaFluxoAgenda = new ControlaFluxoAgenda();
    }

}
