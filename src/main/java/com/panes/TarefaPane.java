package com.panes;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class TarefaPane extends Pane {
    private Label statusLabel;
    private TextArea descricaoTextArea;
    private Label idLabel;

    public TarefaPane(String descricao, String status, String id) {
        this.statusLabel = new Label(status);
        this.descricaoTextArea = new TextArea(descricao);
        this.idLabel = new Label(id);

        personalizaElementos();
        bloqueiaEdicao();

        this.getChildren().add(painelGrid());
    }

    private void personalizaElementos () {
        this.setStyle("-fx-border-style: hidden hidden solid hidden; -fx-border-width: 1; -fx-border-color: #B0A4D8;");

        statusLabel.setPrefHeight(30);
        statusLabel.setPrefWidth(100);

        descricaoTextArea.setPrefHeight(100);
        descricaoTextArea.setPrefWidth(300);

        idLabel.setPrefWidth(30);
        idLabel.setPrefHeight(30);
    }

    private void bloqueiaEdicao () {
        descricaoTextArea.setEditable(false);
    }

    private BorderPane painelGrid () {
        BorderPane borderPane = new BorderPane();
        GridPane paneLeft = new GridPane();

        //painel esquerda
        paneLeft.setHgap(10);
        paneLeft.add(idLabel, 0, 0);
        paneLeft.add(statusLabel, 1, 0);

        //personaliza o border pane
        borderPane.setPrefHeight(150);
        borderPane.setPrefWidth(450);

        BorderPane.setMargin(paneLeft, new Insets(5));
        BorderPane.setMargin(descricaoTextArea, new Insets(5));

        //adiciona os elementos no borderPane
        borderPane.setLeft(paneLeft);
        borderPane.setCenter(descricaoTextArea);

        return borderPane;
    }

    //Getters e Setters
    public Label getStatusLabel() {
        return statusLabel;
    }

    public void setStatusLabel(Label statusLabel) {
        this.statusLabel = statusLabel;
    }

    public TextArea getDescricaoTextArea() {
        return descricaoTextArea;
    }

    public void setDescricaoTextArea(TextArea descricaoTextArea) {
        this.descricaoTextArea = descricaoTextArea;
    }

    public Label getIdLabel() {
        return idLabel;
    }

    public void setIdLabel(Label idLabel) {
        this.idLabel = idLabel;
    }
}