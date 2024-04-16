package Classes;

import java.util.List;

public class Person {

    String nome;
    List<Movimento> movimentos;
    int vida;
    int CA;

    public Person(String nome, int vida, int ca, List<Movimento> movimentos) {
        this.nome = nome;
        this.vida = vida;
        this.CA = ca;
        this.movimentos = movimentos;
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
        // procurar na lista de movimentos o numero dessa escolha
        return this.movimentos.get(escolha);
    }
}
