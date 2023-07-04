package com.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.agenda.ControlaFluxoAgenda;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AdicionarTarefaController {
    @FXML
    private Button botaoSalvar;

    @FXML
    private Button botaoVoltar;

    @FXML
    private TextField descricaoTextField;

    @FXML
    private TextField tituloTextField;

    private ControlaFluxoAgenda controlaFluxoAgenda;

    @FXML
    void acaoSalvar(ActionEvent event) {
        if(controlaFluxoAgenda.adicionarTarefa(descricaoTextField.getText(), tituloTextField.getText(), false)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Tarefa adicionada com sucesso");
            alert.setTitle("Adicionar tarefa");
            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Não foi possível criar a tarefa");
            alert.setTitle("Adicionar tarefa");
            alert.show();
        }
    }

    @FXML
    void acaoVoltar(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/principal_agenda/exibir_tarefas.fxml"));
            Scene scene = new Scene(root, 450, 600);
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
    void initialize() {
        controlaFluxoAgenda = new ControlaFluxoAgenda();
    }
}