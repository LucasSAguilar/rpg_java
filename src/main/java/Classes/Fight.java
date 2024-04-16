package Classes;

public class Fight {

    Person lutadorUm;
    Person lutadorDois;

    public Fight(Person lutadorUm, Person lutadorDois) {
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
    
}
