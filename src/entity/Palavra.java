package entity;

public class Palavra {

    private int id;
    private String palavra;
    private String dica;
    private Nivel nivel;

    // Construtores, getters e setters

    public int getId(){
        return id;
    }
    public String getPalavra(){
        return palavra;
    }
    public String getDica(){
        return dica;
    }
    public Nivel getNivel() {
        return nivel;
    }


    public void setId(int id){
        this.id = id;
    }
    public void setPalavra(String palavra){
        this.palavra = palavra;
    }
    public void setDica(String dica){
        this.dica = dica;
    }
    public void setNivel(Nivel nivel) {
        this.nivel = nivel;}
}

