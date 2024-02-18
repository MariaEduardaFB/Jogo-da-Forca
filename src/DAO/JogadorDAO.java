package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexao.Conexao;
import entity.Jogador;

public class JogadorDAO {
    public void cadastrarJogador(Jogador jogador){

        String sql = "INSERT INTO JOGADOR (NOME) VALUES(?)";
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
}
