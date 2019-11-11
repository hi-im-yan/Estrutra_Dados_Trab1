public class SalaLab{
    private String nome;
    private String acronimo;
    //private Stack<Turma> turmaExtra = new Stack<Turma>();
    //-----------------------Constructors----------------------------------//
    public SalaLab(){

    }

    public SalaLab(String nome, String acronimo){
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