import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import DAO.JogadorDAO;
import DAO.PalavraDAO;
import entity.Jogador;
import entity.Palavra;

public class JogoMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        JogadorDAO jogadorDAO = new JogadorDAO();
        PalavraDAO palavraDAO = new PalavraDAO();

        List<Palavra> palavrasUtilizadas = new ArrayList<>();

        System.out.println("Bem-vindo ao Jogo da Forca!");

        // Loop externo para controlar o fluxo do jogo
        boolean continuarJogo = true;
        while (continuarJogo) {
            // Cadastrar jogadores
            Jogador jogador1 = cadastrarJogador(scanner, jogadorDAO, "primeiro");
            Jogador jogador2 = cadastrarJogador(scanner, jogadorDAO, "segundo");

            // Mapa para armazenar as pontuações dos jogadores
            int pontuacaoJogador1 = 0;
            int pontuacaoJogador2 = 0;

            // Realizar três rodadas
            for (int rodada = 1; rodada <= 3; rodada++) {
                System.out.println("\nRodada " + rodada);

                // Menu para escolher o nível do jogo
                System.out.println("\nEscolha o nível do jogo:");
                System.out.println("1 - Fácil");
                System.out.println("2 - Médio");
                System.out.println("3 - Difícil");
                System.out.print("Digite o número correspondente ao nível desejado: ");
                int opcaoNivel = scanner.nextInt();

                // Inicializar o placar da rodada
                int placarRodadaJogador1 = 0;
                int placarRodadaJogador2 = 0;

                Palavra palavra = palavraDAO.buscarPalavraAleatoriaPorNivel(opcaoNivel);
                palavrasUtilizadas.add(palavra);

                // Buscar palavra aleatória do nível escolhido
                
                String palavraSecreta = palavra.getPalavra();
                String dica = palavra.getDica();

                System.out.println("Dica: " + dica);

                // Jogar a rodada alternadamente entre os jogadores
                boolean jogoEmAndamento = true;
                int jogadorAtual = 1;
                int tentativas = 5;
                StringBuilder letrasCorretas = new StringBuilder();
                StringBuilder letrasErradas = new StringBuilder();
                while (jogoEmAndamento && tentativas > 0) {
                    Jogador jogador = (jogadorAtual == 1) ? jogador1 : jogador2;
                    System.out.println("\nTurno de " + jogador.getNome());

                    System.out.println("\nPalavra: " + exibirPalavra(palavraSecreta, letrasCorretas));
                    System.out.println("Tentativas Restantes: " + tentativas);
                    System.out.println("Letras Erradas: " + letrasErradas);

                    // Solicitar uma letra ao jogador
                    System.out.print("Digite uma letra: ");
                    char letra = scanner.next().charAt(0);

                    // Verificar se a letra já foi tentada
                    if (letrasCorretas.indexOf(String.valueOf(letra)) != -1 || letrasErradas.indexOf(String.valueOf(letra)) != -1) {
                        System.out.println("Você já tentou essa letra. Tente outra.");
                        continue;
                    }

                    // Verificar se a letra está na palavra
                    if (palavraSecreta.indexOf(letra) != -1) {
                        System.out.println("Letra correta!");
                        letrasCorretas.append(letra);
                        if (palavraCompleta(palavraSecreta, letrasCorretas)) {
                            System.out.println("Parabéns, " + jogador.getNome() + "! Você acertou a palavra!");
                            if (jogadorAtual == 1) {
                                placarRodadaJogador1++;
                            } else {
                                placarRodadaJogador2++;
                            }
                            jogoEmAndamento = false;
                        }
                        jogador.ganharPonto();
                    } else {
                        System.out.println("Letra incorreta!");
                        tentativas--;
                        letrasErradas.append(letra);
                    }

                    // Alternar para o próximo jogador
                    jogadorAtual = (jogadorAtual == 1) ? 2 : 1;
                }

                // Atualizar as pontuações dos jogadores após cada rodada
                pontuacaoJogador1 += placarRodadaJogador1;
                pontuacaoJogador2 += placarRodadaJogador2;

                System.out.println("\nPalavras utilizadas nesta rodada:");
                for (Palavra palavraUtilizada : palavrasUtilizadas) {
                    System.out.println("- " + palavraUtilizada.getPalavra());
                }
                palavrasUtilizadas.clear(); 
                
            }

            

            // Verificar o vencedor
            String vencedor = (pontuacaoJogador1 > pontuacaoJogador2) ? jogador1.getNome() : (pontuacaoJogador1 < pontuacaoJogador2) ? jogador2.getNome() : "Empate";

            System.out.println("\nFim do Jogo!");
            System.out.println("Pontuação Final:");
            System.out.println(jogador1.getNome() + ": " + pontuacaoJogador1 + " pontos");
            System.out.println(jogador2.getNome() + ": " + pontuacaoJogador2 + " pontos");
            System.out.println("O vencedor é: " + vencedor);

            // Menu para continuar ou iniciar um novo jogo
            System.out.println("\nDeseja continuar jogando ou iniciar um novo jogo?");
            System.out.println("1 - Continuar Jogando");
            System.out.println("2 - Novo Jogo");
            System.out.print("Digite o número correspondente à opção desejada: ");
            int opcao = scanner.nextInt();
            if (opcao == 2) {
                // Apagar dados dos jogadores do banco
                jogadorDAO.apagarJogadores();
                System.out.println("Dados dos jogadores apagados.");
                continuarJogo = false;
            }

            System.out.println("\nDeseja atualizar o nome de algum jogador?");
            System.out.println("1 - Sim");
            System.out.println("2 - Não");
            System.out.print("Digite o número correspondente à opção desejada: ");
            int opcaoAtualizarNome = scanner.nextInt();
            if (opcaoAtualizarNome == 1) {
                System.out.print("Digite o número do jogador que deseja atualizar o nome (1 para primeiro jogador, 2 para segundo jogador): ");
                int numeroJogador = scanner.nextInt();
                Jogador jogador = (numeroJogador == 1) ? jogador1 : jogador2;
                System.out.print("Digite o novo nome para o jogador: ");
                String novoNome = scanner.next();
                jogador.setNome(novoNome);
                System.out.println("Nome atualizado com sucesso.");
}
}

}

    // Método para cadastrar um jogador
    private static Jogador cadastrarJogador(Scanner scanner, JogadorDAO jogadorDAO, String ordem) {
        System.out.print("Digite o nome do " + ordem + " jogador: ");
        String nome = scanner.next();
        Jogador jogador = new Jogador();
        jogador.setNome(nome);
        jogadorDAO.cadastrarJogador(jogador);
        return jogador;
    }

    

    // Método para exibir a palavra com as letras corretas já adivinhadas
    private static String exibirPalavra(String palavra, StringBuilder letrasCorretas) {
        StringBuilder palavraExibida = new StringBuilder();
        for (int i = 0; i < palavra.length(); i++) {
            char letra = palavra.charAt(i);
            if (letrasCorretas.indexOf(String.valueOf(letra)) != -1) {
                palavraExibida.append(letra);
            } else {
                palavraExibida.append("_");
            }
        }
        return palavraExibida.toString();
    }

    // Método para verificar se a palavra foi completamente adivinhada
    private static boolean palavraCompleta(String palavra, StringBuilder letrasCorretas) {
        for (int i = 0; i < palavra.length(); i++) {
            if (letrasCorretas.indexOf(String.valueOf(palavra.charAt(i))) == -1) {
                return false;
            }
        }
        return true;
    }

    
}
