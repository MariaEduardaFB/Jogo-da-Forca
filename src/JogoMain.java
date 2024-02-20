import java.util.Scanner;

import DAO.JogadorDAO;
import entity.Jogador;

public class JogoMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao Jogo da Forca!");
        System.out.print("Digite o seu nome: ");
        String nomeJogador = scanner.nextLine();

        Jogador jogador = new Jogador();
        jogador.setNome(nomeJogador);

        JogadorDAO jogadorDAO = new JogadorDAO();
        jogadorDAO.cadastrarJogador(jogador);

        System.out.println("Jogador cadastrado com sucesso!");
        scanner.close();
    }
}
