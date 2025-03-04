package com.jtmjinfo.crudestudantes.controller;

import com.jtmjinfo.crudestudantes.dao.EstudanteDao;
import com.jtmjinfo.crudestudantes.model.Estudante;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;


import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class EstudanteController implements Initializable {

    @FXML
    private Button bt_editar;

    @FXML
    private Button bt_excluir;

    @FXML
    private Button bt_salvar;


    @FXML
    private RadioButton rb_feminino;

    @FXML
    private RadioButton rb_masculino;

    @FXML
    private TableColumn tc_id;

    @FXML
    private TableColumn tc_idade;

    @FXML
    private TableColumn tc_nome;

    @FXML
    private TableColumn tc_sexo;

    @FXML
    private TextField tf_idade;

    @FXML
    private TextField tf_nome;

    @FXML
    private TableView tv_estudante;

    Estudante estudante = new Estudante();
    EstudanteDao estudanteDao = new EstudanteDao();
    List<Estudante> todosEstudantes = new ArrayList<>();
    ObservableList<Estudante> estudantesObservableList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        prepararTabela();
        ocultarBotoes();

    }
    void mostrarBotoes(){
        this.bt_editar.setVisible(true);
        this.bt_excluir.setVisible(true);
        this.bt_salvar.setVisible(false);
    }
    void ocultarBotoes(){
        this.bt_editar.setVisible(false);
        this.bt_excluir.setVisible(false);
        this.bt_salvar.setVisible(true);
    }
    void limparCampos(){
        tf_nome.setText("");
        tf_idade.setText("");
    }
    void prepararTabela(){
        tc_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        tc_nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tc_idade.setCellValueFactory(new PropertyValueFactory<>("idade"));
        tc_sexo.setCellValueFactory(new PropertyValueFactory<>("sexo"));

        todosEstudantes = estudanteDao.buscarTodos();
        estudantesObservableList = FXCollections.observableList(todosEstudantes);

        tv_estudante.setItems(estudantesObservableList);
    }

    @FXML
    public void salvar(ActionEvent event) {
        if (validador()) {
            estudante.setNome(tf_nome.getText().toString());
            estudante.setIdade(Integer.valueOf(tf_idade.getText().toString()));
            if (rb_masculino.isSelected()) estudante.setSexo("Masculino");
            else if (rb_feminino.isSelected()) estudante.setSexo("Feminino");

            estudanteDao.cadastrarEstudante(estudante);
            prepararTabela();
            limparCampos();
        }
    }

    public boolean validador() {
        StringBuffer mensagem = new StringBuffer();

        if (tf_nome.getText().isEmpty() || tf_nome.getText().isBlank())
            mensagem.append("O campo nome não pode ser vazio!!! \n");
        if (tf_idade.getText().isEmpty() || tf_idade.getText().isBlank())
            mensagem.append("O campo idade não pode ser vazio!!!");


        if (mensagem.length() > 0) {
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setHeaderText("Erro");
            alerta.setContentText(mensagem.toString());
            alerta.show();
            return false;
        } else return true;

    }
    @FXML
    void preencherCampos(MouseEvent event) {

        estudante = (Estudante)tv_estudante.getSelectionModel().getSelectedItem();
        tf_nome.setText(estudante.getNome());
        tf_idade.setText(String.valueOf(estudante.getIdade()));
        if(estudante.getSexo().equalsIgnoreCase("Masculino")) rb_masculino.setSelected(true);
        else if (estudante.getSexo().equalsIgnoreCase("Feminino")) rb_feminino.setSelected(true);
        mostrarBotoes();
    }
    @FXML
    void deletarEstudante(ActionEvent event) {

        estudanteDao.removerEstudante(estudante.getId());
        prepararTabela();
        limparCampos();
        ocultarBotoes();

    }
    @FXML
    void editaEstudante(ActionEvent event) {
        if(validador()){
            estudante.setNome(tf_nome.getText().toString());
            estudante.setIdade(Integer.valueOf(tf_idade.getText().toString()));
            if (rb_masculino.isSelected()) estudante.setSexo("Masculino");
            else if (rb_feminino.isSelected()) estudante.setSexo("Feminino");
            estudanteDao.editarEstudante(estudante, estudante.getId());
            prepararTabela();
            limparCampos();
            ocultarBotoes();
        }
    }
}




