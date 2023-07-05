package com.controllers;

import java.io.IOException;

import com.fluxo_agenda.OperacoesAgenda;
import com.excecao.DuplicidadeException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class AdicionarTarefaController {
    @FXML
    private Button botaoAdicionar;

    @FXML
    private Button botaoVoltar;

    @FXML
    private TextArea descricaoTextArea;

    @FXML
    private ComboBox<String> statusComboBox;

    private OperacoesAgenda operacoesAgenda;

    @FXML
    void initialize() {
        operacoesAgenda = new OperacoesAgenda();

        statusComboBox.getItems().add("Em andamento");
        statusComboBox.getItems().add("Concluída");

        statusComboBox.getSelectionModel().selectFirst();
    }

    @FXML
    void acaoAdicionar(ActionEvent event) {
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        if (stage.getUserData() != null)
            operacoesAgenda = (OperacoesAgenda) stage.getUserData(); //atualiza o operacoesAgenda se houver algo no userData

        //Tenta adicionar a nova tarefa
        try {
            operacoesAgenda.adicionarTarefa(descricaoTextArea.getText(), statusComboBox.getSelectionModel().getSelectedItem().toString());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Tarefa adicionada com sucesso");
            alert.setTitle("Adicionar tarefa");
            alert.show();

        } catch (DuplicidadeException e) { //Tarefas com a mesma descrição não serão aceitas
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Não foi possível criar a tarefa.");
            alert.setContentText("Tarefa duplicada");
            alert.setTitle("Adicionar tarefa");
            alert.show();

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Não foi possível criar a tarefa.");
            alert.setTitle("Adicionar tarefa");
            alert.show();

        }finally {
            resetaCampos();
        }
    }

    @FXML
    void acaoVoltar(ActionEvent event) {
        try {
            //Altera a cena para a tela de edição de tarefas
            Parent root = FXMLLoader.load(getClass().getResource("/com/principal_agenda/exibir_tarefas.fxml"));
            Scene scene = new Scene(root, 600, 500);

            //Esconde o palco atual
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.hide();

            //atualiza o operacoesAgenda
            stage.setUserData(operacoesAgenda);

            stage.setTitle("Edição tarefas");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show(); //Exibe o novo palco

        } catch (IOException e) {
            System.out.println("Erro ao abrir a aba");
        }
    }

    private void resetaCampos () {
        statusComboBox.getSelectionModel().selectFirst();
        descricaoTextArea.setText("");
    }
}