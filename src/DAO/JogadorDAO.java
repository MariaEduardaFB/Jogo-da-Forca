package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexao.Conexao;
import entity.Jogador;

public class JogadorDAO {
    public void cadastrarJogador(Jogador jogador){

        String sql = "INSERT INTO jogador (NOME) VALUES(?)";
        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, jogador.getNome());
            ps.execute();
            ps.close();
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void apagarJogadores() {
        String sql = "DELETE FROM jogador";
        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.executeUpdate();
            System.out.println("Jogadores apagados com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
