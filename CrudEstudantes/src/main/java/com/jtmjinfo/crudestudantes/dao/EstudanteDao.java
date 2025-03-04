package com.jtmjinfo.crudestudantes.dao;

import com.jtmjinfo.crudestudantes.model.Estudante;
import com.jtmjinfo.crudestudantes.repository.IEstudanteRepository;
import com.jtmjinfo.crudestudantes.util.Conexao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

public class EstudanteDao implements IEstudanteRepository {
    @Override
    public void cadastrarEstudante(Estudante estudante) {
        try {
            String sql = "INSERT INTO estudante(nome,idade,sexo) VALUES(?,?,?)";
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
            ps.setString(1, estudante.getNome());
            ps.setInt(2, estudante.getIdade());
            ps.setString(3, estudante.getSexo());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro " + e.getMessage());
        }
    }

    @Override
    public Estudante buscaPorId(int id) {
        Estudante estudante = null;
        try {
            String sql = "SELECT * FROM estudante WHERE id=?";

            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                estudante = new Estudante();
                estudante.setId(rs.getInt("id"));
                estudante.setNome(rs.getString("nome"));
                estudante.setIdade(rs.getInt("idade"));
                estudante.setSexo(rs.getString("sexo"));
            }

        } catch (Exception e) {
            System.out.println("Erro " + e.getMessage());
        }

        return estudante;
    }

    @Override
    public List<Estudante> buscarTodos() {
        List<Estudante> estudantes = new ArrayList<>();

        try {
            ResultSet rs = null;
            String sql = "select * from estudante";
            PreparedStatement ps =Conexao.obterConexao().prepareStatement(sql);

            rs = ps.executeQuery();

            while(rs.next()){
                Estudante estudante = new Estudante();

                estudante.setId(rs.getInt("id"));
                estudante.setNome(rs.getString("nome"));
                estudante.setIdade(rs.getInt("idade"));
                estudante.setSexo(rs.getString("sexo"));

                estudantes.add(estudante);
            }

        } catch (Exception e) {
            System.out.println("Erro " + e.getMessage());
        }
        return estudantes;
    }

    @Override
    public Estudante editarEstudante(Estudante estudante, int id) {

        try{

            String sql = "update estudante set nome =?, idade=? , sexo=?  where id = ?";

            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
            ps.setString(1, estudante.getNome());
            ps.setInt(2, estudante.getIdade());
            ps.setString(3, estudante.getSexo());
            ps.setInt(4, id);

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Erro " + e.getMessage());
        }


        return null;

    }

    @Override
    public void removerEstudante(int id) {

        try {
            String sql = "delete from estudante where id = ?";

            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
            ps.setInt(1, id);

            ps.execute();

        } catch (Exception e) {
            System.out.println("Erro " + e.getMessage());
        }

    }
}
