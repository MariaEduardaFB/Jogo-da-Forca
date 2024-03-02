<p align="center">
  <img src="https://github.com/MariaEduardaFB/Jogo-da-Forca/assets/133064900/2f9b75b6-d748-40c2-9606-4e4e57725de8"  width= "300" heigth= "300">
</p>

# Jogo da Forca

## 📌 Descrição
Este é um jogo simples da forca implementado em Java. Os jogadores tentam adivinhar uma palavra oculta, letra por letra, antes de esgotarem suas tentativas. Cada jogador tem a oportunidade de adivinhar uma palavra em três níveis de dificuldade: Fácil, Médio e Difícil.

## 📌 Funcionalidades
- Cadastrar jogadores
- Escolher nível de dificuldade
- Adivinhar letras
- Receber dicas
- Atualizar nome do jogador
- Visualizar pontuação final
- Continuar jogando ou iniciar um novo jogo

## 🗒️ Requisitos
- JDK 8 ou superior ✔️
- MySQL ✔️
- Biblioteca MySQL Connector/J 8.2.0 ✔️

## 🎲 Como Jogar
1. Clone ou baixe este repositório em seu computador.
2. Importe o projeto em sua IDE preferida.
3. Certifique-se de ter um servidor MySQL em execução.
4. Execute o script `forcabd.sql` para criar o banco de dados e inserir algumas palavras.
5. Certifique-se de adicionar a biblioteca `mysql-connector-java-8.2.0.jar` ao seu classpath.
6. Execute a classe `JogoMain` para iniciar o jogo.


## 💻 Conceitos de Programação Orientada a Objetos (POO)
- **Encapsulamento**: Presente nas classes `Jogador`, `Nivel`, `Palavra`, `JogadorDAO`, `NivelDAO` e `PalavraDAO`, onde os atributos são definidos como privados (`private`) e acessados por meio de métodos getters e setters.
- **Herança**: Não está claramente evidenciado no código fornecido, mas poderia ser introduzido se houvesse uma hierarquia de classes relacionadas.
- **Polimorfismo**: Não está claramente evidenciado no código fornecido, mas poderia ser introduzido ao criar métodos com o mesmo nome em diferentes classes ou ao usar interfaces.
- **Abstração**: Presente nas classes `Jogador`, `Nivel` e `Palavra`, onde representam conceitos abstratos relevantes para o jogo.
- **Associação**: Visto entre classes, como `JogoMain` e `JogadorDAO`, onde `JogoMain` utiliza os serviços de `JogadorDAO`.
- **Composição**: Ocorre em `JogoMain`, onde instâncias de `Jogador` e `JogadorDAO` são criadas e utilizadas para operações de jogador durante o jogo.

<p align="center">
🌻 Eduarda Batista 🌻
  <br>
🌹 Vicencya Nayara 🌹
</p>

<p align= "center">
  
Disciplina: `Programação Orientada à Objetos`.
<br>
Professor(a): `Jamires Costa`
</p>




<p align="center">
  <img src="https://github.com/MariaEduardaFB/Jogo-da-Forca/assets/133064900/526534bd-7346-4cc2-93d1-6f7c1181cafa"  width= "100" heigth= "100">
</p>


