package com.controllers;

import java.io.IOException;
import java.util.ArrayList;

import com.fluxo_agenda.OperacoesAgenda;
import com.fluxo_agenda.elementos.Tarefa;
import com.panes.TarefaPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JanelaPrincipalController {
    @FXML
    private Button botaoEditarTarefa;

    @FXML
    private Button botaoNovaTarefa;

    @FXML
    private Button botaoSair;


    @FXML
    private VBox tarefasVBox;

    @FXML
    private ScrollPane scrollPane;

    private OperacoesAgenda operacoesAgenda;

    private ArrayList<Pane> painelTarefas;

    @FXML
    void acaoEditarTarefa(ActionEvent event) {
        try {
            //Altera a cena para a tela de edição de tarefas
            Parent root = FXMLLoader.load(getClass().getResource("/com/principal_agenda/editar_tarefa.fxml"));
            Scene scene = new Scene(root, 500, 300);

            //Pega o "palco" atual e o esconde
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.hide();

            //atualiza o operacoesAgenda
            stage.setUserData(operacoesAgenda);

            stage.setTitle("Editar tarefa");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show(); //exibe o novo "palco"

        } catch (IOException e) {
            System.out.println("Erro ao abrir a aba");
        }
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

            //atualiza o operacoesAgenda
            stage.setUserData(operacoesAgenda);

            stage.setTitle("Adicionar tarefa");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show(); //exibe o novo "palco"

        } catch (IOException e) {
            System.out.println("Erro ao abrir a aba");
        }
    }

    @FXML
    //recarregar a tela para exibir as alterações na tela
    void acaoAtualizar(ActionEvent event) {
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        if (stage.getUserData() != null)
            operacoesAgenda = (OperacoesAgenda) stage.getUserData();

        initialize();
    }

    @FXML
    void acaoSair(ActionEvent event) {
        System.exit(1);
    }


    @FXML
    void initialize() {
        painelTarefas = new ArrayList<>();
        tarefasVBox.getChildren().clear();

        if(operacoesAgenda == null)
            operacoesAgenda = new OperacoesAgenda(); //inicializa o operações agenda se ele estiver vazio

        //Cria um pane para cada tarefa e o adiciona à VBox
        for (Tarefa tarefa : operacoesAgenda.getTarefas()) {
            TarefaPane tarefaPane = new TarefaPane(tarefa.getDescricao(), tarefa.getStatus(), tarefa.getId());
            tarefasVBox.getChildren().add(tarefaPane);
        }

        scrollPane.setFitToWidth(true); //Para remover a rolagem horizontal
    }

}
