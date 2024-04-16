package Classes;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Partida {

    int round;
    Person jogadorAtivo;
    Luta luta;

    public Partida(Luta luta) {
        this.round = 0;
        this.jogadorAtivo = definirPrimeiroAgir();
        this.luta = luta;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public Person getJogadorAtivo() {
        return jogadorAtivo;
    }

    public void setJogadorAtivo(Person jogadorAtivo) {
        this.jogadorAtivo = jogadorAtivo;
    }

    public Luta getLuta() {
        return luta;
    }

    public void setLuta(Luta luta) {
        this.luta = luta;
    }

    public int rodarDado() {
        Random random = new Random();
        return random.nextInt(19) + 1;
    }

    public Person definirPrimeiroAgir() {

        int dadoJogadorUm = rodarDado();
        int dadoJogadorDois = rodarDado();

        if (dadoJogadorUm > dadoJogadorDois) {
            return luta.getLutadorUm();
        } else if (dadoJogadorUm < dadoJogadorDois) {
            return luta.getLutadorDois();
        }
        return definirPrimeiroAgir();
    }

    public void iniciar() {
        while (this.luta.lutadorDois.getVida() > 0 && this.luta.lutadorUm.getVida() > 0) {
            System.out.println("---------- VEZ DO JOGADOR " + jogadorAtivo + "-----------");
            System.out.println("Escolha um movimento: ");
            List<Movimento> movimentos = jogadorAtivo.getMovimentos();

            for (int i = 0; i <= 2; i++) {
                System.out.println(i + " - " + movimentos.get(i).nome);
            }
            Scanner scanner = new Scanner(System.in);
            int escolha = scanner.nextInt();
        }
    }
}
