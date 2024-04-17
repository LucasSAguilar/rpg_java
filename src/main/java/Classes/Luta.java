package Classes;

import java.util.Random;

public class Luta {

    Person lutadorUm;
    Person lutadorDois;
    int rodada;

    public Luta(Person lutadorUm, Person lutadorDois) {
        this.lutadorUm = lutadorUm;
        this.lutadorDois = lutadorDois;
    }

    public int getRodada() {
        return rodada;
    }

    public void setRodada(int rodada) {
        this.rodada = rodada;
    }

    public Person getLutadorUm() {
        return lutadorUm;
    }

    public void setLutadorUm(Person lutadorUm) {
        this.lutadorUm = lutadorUm;
    }

    public Person getLutadorDois() {
        return lutadorDois;
    }

    public void setLutadorDois(Person lutadorDois) {
        this.lutadorDois = lutadorDois;
    }

    public int rodarDado() {
        Random random = new Random();
        return random.nextInt(19) + 1;
    }

    public int definirPrimeiroAgir() {

        int dadoJogadorUm = rodarDado();
        int dadoJogadorDois = rodarDado();

        if (dadoJogadorUm > dadoJogadorDois) {
            return 1;
        } else if (dadoJogadorUm < dadoJogadorDois) {
            return 2;
        }
        return definirPrimeiroAgir();
    }

    public void iniciarLuta() {
        Person jogadorSelecionado;
        int numSelecao = definirPrimeiroAgir();

        if (numSelecao == 1) {
            jogadorSelecionado = lutadorUm;
        } else {
            jogadorSelecionado = lutadorDois;
        }

        while (lutadorUm.getVida() > 0 && lutadorDois.getVida() > 0) {
            iniciarRodada(jogadorSelecionado);
            if (jogadorSelecionado == lutadorUm) {
                jogadorSelecionado = lutadorDois;
            }
            if (jogadorSelecionado == lutadorDois) {
                jogadorSelecionado = lutadorUm;
            }
        }
       
    }

    public void iniciarRodada(Person jogadorSelecionado) {
    }

}
