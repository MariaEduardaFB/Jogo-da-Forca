import DAO.JogadorDAO;
import entity.Jogador;

public class JogoMain {
    public static void main(String[] args) {
        
        Jogador j = new Jogador();
        j.setNome("Duda");

        new JogadorDAO().cadastrarJogador(j);

    }
}
