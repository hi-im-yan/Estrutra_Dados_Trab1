import java.util.Objects;
import java.util.Stack;

public class Turma {

    private String nome;
    private String acronimo;

    //pilha que irá armazenar professores que foi tentado atribuir na Turma
    private Stack<Professor> professores = new Stack<Professor>();
    private Professor professor;

    // -----------------------Constructors----------------------------------//
    public Turma() {

    }

    public Turma(String nome, String acronimo) {
        this.nome = nome;
        this.acronimo = acronimo;
        this.professor = null;
    }

    // -----------------------Getters----------------------------------//

    public String getNome() {
        return this.nome;
    }

    public String getAcronimo() {
        return this.acronimo;
    }

    public Professor getProfessor() {
        return this.professor;
    }

    public Stack<Professor> getProfessores() {
        return this.professores;
    }

    // -----------------------Setters----------------------------------//
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAcronimo(String acronimo) {
        this.acronimo = acronimo;
    }

    public void setProfessor(Professor professor) {
        // Caso essa turma não tenha professor ainda, é atribuido um professor fixo para turma
        if (this.professor == null)
            this.professor = professor;

        //se o professor não existir na pilha, ele é adicionado
        if (this.professores.search(professor) == -1)
            this.professores.push(professor);
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