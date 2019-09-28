import java.util.Stack;

public class Turma{

    private String nome;
    private String acronimo;
    //Professores está como pilha, pois pela lógica o primeiro professor que pegar a turma fica com ela.
    //First in, Last out.
    //A pilha armazena uma String pois ela precisa armazenar o acrônimo do professor e não um Professor.
    private Stack<String> professores = new Stack<String>(); 

    //-----------------------Constructors----------------------------------//
    public Turma(){

    }

    public Turma(String nome, String acronimo){
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

    public Stack getProfessores(){
        return this.professores;
    }

    public int getQuantidadeDeProfessoresNaTurma(){
        return this.professores.size();
    }

    //-----------------------Setters----------------------------------//
    public void setNome(String nome){
        this.nome = nome;
    }

    public void setAcronimo(String acronimo){
        this.acronimo = acronimo;
    }

    public void setProfessoresNaTurma(Professor professor){
        this.professores.push(professor.getAcronimo());
    }

    //-----------------------Verificar os erros----------------------------------//
    public void mostrarErro(){
        if(getQuantidadeDeProfessoresNaTurma() > 1){
            System.out.print("A turma " + this.acronimo + " está sendo ministrada por mais de um professor: ");
            while(!professores.isEmpty()){
                System.out.print(professores.pop() + " ");
            }
            System.out.println();
        }
    }
}