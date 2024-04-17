package Classes;

public class Rodada {

    private Person playerAtivo;
    private Person playerInativo;

    public Rodada(Person playerAtivo, Person playerInativo) {
        this.playerAtivo = playerAtivo;
        this.playerInativo = playerInativo;
    }

    public Person getPlayerAtivo() {
        return playerAtivo;
    }

    public void setPlayerAtivo(Person playerAtivo) {
        this.playerAtivo = playerAtivo;
    }

    public Person getPlayerInativo() {
        return playerInativo;
    }

    public void setPlayerInativo(Person playerInativo) {
        this.playerInativo = playerInativo;
    }
    
    

}
