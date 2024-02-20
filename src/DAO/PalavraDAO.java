package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import conexao.Conexao;
import entity.Nivel;
import entity.Palavra;

public class PalavraDAO {

    public Palavra buscarPalavraAleatoria() {
        Connection connection = Conexao.getConexao();
        String sql = "SELECT * FROM palavra ORDER BY RAND() LIMIT 1";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        ResultSet resultSet = null;
        try {
            resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                // Não há resultados, retornar null
                return null;
            }
            Palavra palavra = new Palavra();
            palavra.setPalavra(resultSet.getString("palavra"));
            palavra.setDica(resultSet.getString("dica"));
            // Verificar se a coluna id existe no ResultSet antes de tentar acessá-la
            if (resultSet.findColumn("id") > 0) {
                palavra.setId(resultSet.getInt("id"));
            }
            palavra.setNivel(new Nivel(resultSet.getInt("fk_Nivel_id")));
            return palavra;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
