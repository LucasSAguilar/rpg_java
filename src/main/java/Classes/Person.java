package Classes;

public class Person {

    String nome;
    int vida;
    int CA;

    public Person(String nome, int vida, int ca) {
        this.nome = nome;
        this.vida = vida;
        this.CA = ca;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public int getVida(){
        return this.vida;
    }

    public int getCA() {
        return CA;
    }

    public void setCA(int CA) {
        this.CA = CA;
    }
    
    public void setVida(int vida){
        this.vida = vida;
    }
    
       public void tomarGolpe (int dano){
        this.vida = vida - dano;
    }
       
      public void recuperarVida (int cura){
        this.vida = vida + cura;
    }
    
}
