package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import conexao.Conexao;
import entity.Nivel;

public class NivelDAO {

    public Nivel buscarNivelPorId(int id) {

        // Conecta ao banco de dados
        Connection connection = Conexao.getConexao();

        // Cria a consulta SQL com PreparedStatement
        String sql = "SELECT * FROM nivel WHERE id = ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        // Executa a consulta
        ResultSet resultSet = null;
        try {
            resultSet = preparedStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        // Obtém o nível
        Nivel nivel = null;
        try {
            if (resultSet.next()) {
                nivel = new Nivel();
                nivel.setId(resultSet.getInt("id"));
                nivel.setNivel(resultSet.getString("nivel"));
                nivel.setPontuacao(resultSet.getInt("pontuacao"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Fecha a conexão com o banco de dados
        // Conexao.fecharConexao(); // Utilize se não estiver usando pool de conexões

        return nivel;
    }

    public List<Nivel> buscarTodosNiveis() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarTodosNiveis'");
    }

}

     

    
