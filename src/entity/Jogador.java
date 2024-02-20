package entity;

public class Jogador {
    private int pontos;
    private String nome;

    public int getPontos(){
        return pontos;
    }
    public String getNome(){
        return nome;
    }

    public void setId(int pontos){
        this.pontos = pontos;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void ganharPonto() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ganharPonto'");
    }
}
