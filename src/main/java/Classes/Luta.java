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

            int dano = 0;
            boolean acertou = false;
            this.setRodada(this.getRodada() + 1);
            int tenacidadeJogadorUm = lutadorUm.getTenacidade();
            int tenacidadeJogadorDois = lutadorDois.getTenacidade();
            System.out.println("\n \n \n \n------------------------------------------------------------------------------------------------------------------ \n \n \n \n");
            System.out.println("====================" + this.getRodada() + "======================");
            System.out.println("HP jogador " + lutadorDois.getNome() + " | " + lutadorDois.getVida());
            System.out.println("HP jogador " + lutadorUm.getNome() + " | " + lutadorUm.getVida());
            System.out.println("====================" + this.getRodada() + "======================");

            Movimento movimentoEscolhido = definirMovimento(jogadorSelecionado);
            acertou = definirAcerto(jogadorInativo, movimentoEscolhido);

            if (acertou) {
                jogadorInativo.setTenacidade(jogadorInativo.getTenacidade() - movimentoEscolhido.getImpacto());
                dano = definirDano(movimentoEscolhido);
                System.out.println(lutadorUm.getNome() + lutadorUm.getTenacidade());
                System.out.println(lutadorDois.getNome() + lutadorDois.getTenacidade());

            }
            if (jogadorSelecionado == lutadorUm) {
                lutadorDois.setVida(lutadorDois.getVida() - dano);
                if (lutadorDois.getTenacidade() <= 0) {
                    System.out.println("Me parece que o " + lutadorDois.getNome() + "está abalado! Pode atacar novamente " + lutadorUm.getNome());
                    lutadorDois.setTenacidade(tenacidadeJogadorDois);

                } else {
                    jogadorSelecionado = lutadorDois;
                    jogadorInativo = lutadorUm;
                }

            } else if (jogadorSelecionado == lutadorDois) {
                lutadorUm.setVida(lutadorUm.getVida() - dano);
                if (lutadorUm.getTenacidade() <= 0) {
                    System.out.println("Me parece que o " + lutadorUm.getNome() + "está abalado! Pode atacar novamente " + lutadorDois.getNome());
                    lutadorUm.setTenacidade(tenacidadeJogadorUm);
                } else {

                    jogadorSelecionado = lutadorUm;
                    jogadorInativo = lutadorDois;
                }
            }
        }

        System.out.println("A luta acabou!");
        System.out.println("O vencedor foi: " + jogadorSelecionado.getNome());
    }

    public Movimento definirMovimento(Person jogadorSelecionado) {
        List<Movimento> movimentos = jogadorSelecionado.getMovimentos();
        System.out.println("Escolha seu movimento, " + jogadorSelecionado.getNome());
        for (int i = 0; i <= 2; i++) {
            System.out.println(i + " - " + movimentos.get(i).getNome());
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
            System.out.println("--------- Você acertou em cheio! ---------");
            acertou = true;
        } else {
            System.out.println("--------- Que pena, você errou! ---------");
        }
        System.out.println("Os resultados foram:");
        System.out.println("| Valor no dado: " + numDado);
        System.out.println("| Dificuldade de acerto: " + movimento.getDificuldade_acerto());
        System.out.println("| CA do inimigo: " + atacado.getCA());
        System.out.println("| Valor final: " + resultado);

        return acertou;
    }

    public int definirDano(Movimento movimento) {
        int dano = movimento.getDano();
        Random random = new Random();
        int numRandom = random.nextInt(10) + 1;
        if (numRandom <= movimento.getCritico()) {
            dano = dano * 2;
            System.out.println("FOI UM ACERTO CRÍTICO!");
        }

        System.out.println("| Seu dano foi: " + dano);

        return dano;
    }
}
