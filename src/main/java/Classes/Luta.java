package Classes;

import java.util.Random;

public class Luta {

    Person lutadorUm;
    Person lutadorDois;

    public Luta(Person lutadorUm, Person lutadorDois) {
        this.lutadorUm = lutadorUm;
        this.lutadorDois = lutadorDois;
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


}
