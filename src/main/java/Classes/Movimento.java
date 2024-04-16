
package Classes;

public class Movimento {
    
    String nome; 
    int dano;
    int impacto;
    int critico;
    int dificuldade_acerto;
    int cura;

    public Movimento(String nome, int dano, int impacto, int critico, int dificuldade_acerto, int cura) {
        this.nome = nome;
        this.dano = dano;
        this.impacto = impacto;
        this.critico = critico;
        this.dificuldade_acerto = dificuldade_acerto;
        this.cura = cura;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public int getImpacto() {
        return impacto;
    }

    public void setImpacto(int impacto) {
        this.impacto = impacto;
    }

    public int getCura() {
        return cura;
    }

    public void setCura(int cura) {
        this.cura = cura;
    }

    public int getCritico() {
        return critico;
    }

    public void setCritico(int critico) {
        this.critico = critico;
    }

    public int getDificuldade_acerto() {
        return dificuldade_acerto;
    }

    public void setDificuldade_acerto(int dificuldade_acerto) {
        this.dificuldade_acerto = dificuldade_acerto;
    }
}
