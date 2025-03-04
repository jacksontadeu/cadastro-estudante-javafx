package com.jtmjinfo.crudestudantes.repository;

import com.jtmjinfo.crudestudantes.model.Estudante;

import java.util.List;

public interface IEstudanteRepository {

    public void cadastrarEstudante(Estudante estudante);
    public Estudante buscaPorId(int id);
    public List<Estudante> buscarTodos();
    public Estudante editarEstudante(Estudante estudante, int id);
    public void removerEstudante(int id);

}
