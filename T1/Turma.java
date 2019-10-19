import java.util.Objects;
import java.util.Stack;

public class Turma{

    private String nome;
    private String acronimo;
    //Professores está como pilha, pois pela lógica o primeiro professor que pegar a turma fica com ela.
    //First in, Last out.
    //A pilha armazena uma String pois ela precisa armazenar o acrônimo do professor e não um Professor.
    private Stack<Professor> professores = new Stack<Professor>(); 
    private Professor professor;

    //-----------------------Constructors----------------------------------//
    public Turma(){

    }

    public Turma(String nome, String acronimo){
        this.nome = nome;
        this.acronimo = acronimo;
        this.professor = null;
    }

    //-----------------------Getters----------------------------------//

    public String getNome(){
        return this.nome;
    }

    public String getAcronimo(){
        return this.acronimo;
    }

    public Professor getProfessor(){
        return this.professor;
    }

//    public int getQuantidadeDeProfessoresNaTurma(){
//        return this.professores.size();
//    }

    //-----------------------Setters----------------------------------//
    public void setNome(String nome){
        this.nome = nome;
    }

    public void setAcronimo(String acronimo){
        this.acronimo = acronimo;
    }

    public void setProfessor(Professor professor){
        //Caso essa turma não tenha professor ainda, é atribuido um professor fixo para essa turma
        if(this.professor == null){
            this.professor = professor;
        }
        this.professores.push(professor);
    }

    //-----------------------Verificar os erros----------------------------------//
   public void mostrarErro(Stack<String> EXP){
       if(professores.size() > 1){
           String result = new String("A turma " + this.acronimo + " está sendo ministrada por mais de um professor: ");
           while(!professores.isEmpty()){
               result += professores.pop().getAcronimo() + ", ";
           }
           result = result.substring(0, result.length() - 2);

           EXP.push(result);
       }
   }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Turma other = (Turma) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.acronimo, other.acronimo)) {
            return false;
        }
        return Objects.equals(this.professor, other.professor);
    } 

    @Override
    public String toString() {
        return "Turma{" + "nome=" + nome + ", acronimo=" + acronimo + ", professor=" + professor + '}';
    }
    
    
    
    
}