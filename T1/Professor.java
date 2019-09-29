public class Professor{
    private String nome;
    private String acronimo;

    //-----------------------Constructors----------------------------------//
    public Professor(){

    }

    public Professor(String nome, String acronimo){
        this.nome = nome;
        this.acronimo = acronimo;
    }

    //-----------------------Getters----------------------------------//
    public String getNome(){
        return this.nome;
    }
    public String getAcronimo(){
        return this.acronimo;
    }

    //-----------------------Setters----------------------------------//
    public void setNome(String nome){
        this.nome = nome;
    }

    public void setAcronimo(String acronimo){
        this.acronimo = acronimo;
    }
}