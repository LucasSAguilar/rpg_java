package com.mycompany.rpggame;

import Classes.Luta;
import Classes.Movimento;
import Classes.Partida;
import Classes.Person;
import java.util.ArrayList;
import java.util.List;

public class RpgGame {

    public static void main(String[] args) {
        //String nome, int dano, int impacto, int critico, int dificuldade_acerto, int cura

        Movimento jogar_lamina = new Movimento("Lançar lâmina", 8, 0, 5, 5, 0);
        Movimento pulo_voraz = new Movimento("Pulo voraz", 4, 5, 0, 4, 0);

        Movimento soco_leve = new Movimento("Soco leve", 4, 1, 0, 1, 0);
        Movimento soco_forte = new Movimento("Soco forte", 6, 3, 0, 2, 0);
        Movimento chute = new Movimento("Chute", 7, 3, 0, 3, 0);
        Movimento pegar_folego = new Movimento("Pegar fôlego", 0, 0, 0, 0, 4);

        List<Movimento> setUm = new ArrayList<>();
        setUm.add(soco_leve);
        setUm.add(jogar_lamina);
        setUm.add(chute);

        List<Movimento> setDois = new ArrayList<>();
        setDois.add(soco_leve);
        setDois.add(pulo_voraz);
        setDois.add(soco_forte);

        List<Movimento> setTres = new ArrayList<>();
        setTres.add(soco_leve);
        setTres.add(pegar_folego);
        setTres.add(chute);

        Person playerUm = new Person("Shadow", 15, 6, setUm);
        Person playerDois = new Person("Dragon", 20, 8, setDois);
        Person playerTres = new Person("Sun", 17, 7, setTres);

        Luta luta = new Luta(playerUm, playerDois);
        Partida partida = new Partida(luta);
        partida.iniciar();
    }
}
