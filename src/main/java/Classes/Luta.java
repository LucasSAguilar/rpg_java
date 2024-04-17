package Classes;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

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
        Person jogadorInativo;

        int numSelecao = definirPrimeiroAgir();

        if (numSelecao == 1) {
            jogadorSelecionado = lutadorUm;
            jogadorInativo = lutadorDois;
        } else {
            jogadorSelecionado = lutadorDois;
            jogadorInativo = lutadorUm;
        }

        while (lutadorUm.getVida() > 0 && lutadorDois.getVida() > 0) {
            Movimento movimentoEscolhido = definirMovimento(jogadorSelecionado);
            boolean acertou = definirAcerto(jogadorInativo, movimentoEscolhido);
            boolean teveAcertoCritico = definirAcertoCritico();
            
            if (jogadorSelecionado == lutadorUm) {
                jogadorSelecionado = lutadorDois;
                jogadorInativo = lutadorUm;

            }
            if (jogadorSelecionado == lutadorDois) {
                jogadorSelecionado = lutadorUm;
                jogadorInativo = lutadorDois;
            }
        }

    }

    public Movimento definirMovimento(Person jogadorSelecionado) {
        List<Movimento> movimentos = jogadorSelecionado.getMovimentos();
        System.out.println("Escolha seu movimento, " + jogadorSelecionado.getNome());
        for (int i = 0; i <= 2; i++) {
            System.out.println(i + " - " + movimentos.get(i));
        }
        Scanner scanner = new Scanner(System.in);
        int numEscolhido = scanner.nextInt();
        return movimentos.get(numEscolhido);
    }
    

    public boolean definirAcerto(Person atacado, Movimento movimento) {
        boolean acertou = false;
        int numDado = rodarDado();
        int resultado = numDado - movimento.dificuldade_acerto;
        if (resultado > atacado.CA) {
            acertou = true;
            System.out.println("--------- Você acertou em cheio! ---------");
        } else {
            System.out.println("--------- Que pena, você errou! ---------");
        }
        System.out.println("Os resultados foram:");
        System.out.println("Valor no dado: " + numDado);
        System.out.println("Dificuldade de acerto: " + movimento.getDificuldade_acerto());
        System.out.println("CA do inimigo: " + atacado.getCA());
        System.out.println("Valor final: " + resultado);

        return acertou;
    }

    public boolean definirAcertoCritico(){
    return true;
    }
}
