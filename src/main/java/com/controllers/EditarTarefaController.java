package com.controllers;

import java.io.IOException;

import com.fluxo_agenda.OperacoesAgenda;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class EditarTarefaController {
    @FXML
    private Button botaoEditar;

    @FXML
    private Button botaoExcluir;

    @FXML
    private Button botaoVoltar;

    @FXML
    private TextArea descricaoTextArea;

    @FXML
    private TextField idTextField;

    @FXML
    private ComboBox<String> statusComboBox;

    private OperacoesAgenda operacoesAgenda;

    @FXML
    void initialize() {
        operacoesAgenda = new OperacoesAgenda();

        statusComboBox.getItems().add("Em andamento");
        statusComboBox.getItems().add("Concluída");

        statusComboBox.getSelectionModel().selectFirst(); //seleciona a primeira opção para evitar nullPointerExceptions
    }

    @FXML
    void acaoEditar(ActionEvent event) {
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        if (stage.getUserData() != null)
            operacoesAgenda = (OperacoesAgenda) stage.getUserData(); //atualiza o operacoesAgenda se houver algo no userData

        if(operacoesAgenda.editarTarefa(idTextField.getText(), descricaoTextArea.getText(), statusComboBox.getSelectionModel().getSelectedItem().toString())) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Tarefa editada com sucesso");
            alert.setTitle("Editar tarefa");
            alert.show();

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Não foi possível editar a tarefa");
            alert.setTitle("Editar tarefa");
            alert.show();
        }

        resetaCampos();
    }

    @FXML
    void acaoExcluir(ActionEvent event) {
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        if (stage.getUserData() != null)
            operacoesAgenda = (OperacoesAgenda) stage.getUserData(); //atualiza o operacoesAgenda se houver algo no userData

        if (operacoesAgenda.removeTarefa(idTextField.getText())){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Tarefa removida com sucesso");
            alert.setTitle("Remover tarefa");
            alert.show();

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Não foi possível remover a tarefa");
            alert.setTitle("Remover tarefa");
            alert.show();
        }

        resetaCampos();
    }

    @FXML
    void acaoVoltar(ActionEvent event) {
        try {
            //Troca de cena para a tela principal
            Parent root = FXMLLoader.load(getClass().getResource("/com/principal_agenda/exibir_tarefas.fxml"));
            Scene scene = new Scene(root, 600, 500);

            //Pega o palco atual e o esconde
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.hide();

            stage.setUserData(operacoesAgenda); //Passa o operacoesAgenda com os dados atualizados para a nova tela

            stage.setTitle("Edição tarefas");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show(); //exibe o novo palco

        } catch (IOException e) {
            System.out.println("Erro ao abrir a aba");
        }
    }

    private void resetaCampos () {
        statusComboBox.getSelectionModel().selectFirst(); //deixa o primeiro elemento como selecionado para evitar nullPointers
        idTextField.setText("");
        descricaoTextArea.setText("");
    }
}