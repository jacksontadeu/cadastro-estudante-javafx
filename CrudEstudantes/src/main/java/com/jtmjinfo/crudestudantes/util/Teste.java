package com.jtmjinfo.crudestudantes.util;

import com.jtmjinfo.crudestudantes.dao.EstudanteDao;
import com.jtmjinfo.crudestudantes.model.Estudante;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Teste {
    public static void main(String[] args) throws SQLException {

//        Estudante est1 = new Estudante();
//        est1.setNome("Jackson para deletar");
//        est1.setIdade(49);
//        est1.setSexo("masculino");
//
//        EstudanteDao sql = new EstudanteDao();
//
//        sql.cadastrarEstudante(est1);


//        Estudante est2 = new Estudante();
//
//        est2.setNome("Luciana");
//        est2.setIdade(51);
//        est2.setSexo("feminino");

//        List<Estudante> estudantes = new ArrayList<>();
//        EstudanteDao sql = new EstudanteDao();
//        estudantes = sql.buscarTodos();
//
//        for (Estudante estudante : estudantes){
//
//            System.out.printf("Id: %d \n" +
//                    "Nome: %s \n" +
//                    "Idade : %d \n" +
//                    "Sexo: %s \n", estudante.getId(),estudante.getNome(),
//                    estudante.getIdade(), estudante.getSexo());
//        }
//        Estudante estudante = new Estudante();
//        EstudanteDao sql = new EstudanteDao();

//        estudante = sql.buscaPorId(1);
//
//        System.out.println(estudante);

//        Estudante estudante = new Estudante();
//        EstudanteDao sql = new EstudanteDao();
//        estudante.setNome("Jackson Tadeu");
//        estudante.setIdade(49);
//        estudante.setSexo("Masculino");
//
//         sql.editarEstudante(estudante, 1);

        EstudanteDao sql = new EstudanteDao();

        sql.removerEstudante(3);

    }
}
