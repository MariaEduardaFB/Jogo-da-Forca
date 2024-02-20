package entity;

public class Nivel {

    private int id;
    private String nivel;
    private int pontuacao;

    // Construtor com argumentos
    public Nivel(int id, String nivel, int pontuacao) {
        this.id = id;
        this.nivel = nivel;
        this.pontuacao = pontuacao;
    }

    // Construtor vazio (opcional)
    public Nivel() {
    }

    public Nivel(int int1) {
        //TODO Auto-generated constructor stub
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNivel() {
        return nivel;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public int getTentativas() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTentativas'");
    }

    public void decrementarTentativas() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'decrementarTentativas'");
    }
}

