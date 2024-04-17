package Classes;

import java.util.List;

public class Person {

    String nome;
    List<Movimento> movimentos;
    int vida;
    int CA;
    int tenacidade;

    public Person(String nome, int vida, int ca, List<Movimento> movimentos, int tenacidade) {
        this.nome = nome;
        this.vida = vida;
        this.CA = ca;
        this.movimentos = movimentos;
        this.tenacidade = tenacidade;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVida() {
        return this.vida;
    }

    public int getCA() {
        return CA;
    }

    public void setCA(int CA) {
        this.CA = CA;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public Movimento agir(int escolha) {
        return this.movimentos.get(escolha);
    }

    public int getTenacidade() {
        return tenacidade;
    }

    public void setTenacidade(int tenacidade) {
        this.tenacidade = tenacidade;
    }

    public List<Movimento> getMovimentos() {
        return movimentos;
    }

    public void setMovimentos(List<Movimento> movimentos) {
        this.movimentos = movimentos;
    }

}
