import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Erros{

    private Stack<String> turmaInexistente = new Stack<String>();
    private Stack<String> salaInexistente = new Stack<String>();
    private Stack<Professor> professorMinistrandoAulasNoMesmoHorario = new Stack<Professor>();
    private Stack<String> professorInexistente = new Stack<String>();

    public Stack teste(){
        return this.professorMinistrandoAulasNoMesmoHorario;
    }
    public Erros(){}

    public void setTurmaInexistente(String acrTurma){
        if(turmaInexistente.search(acrTurma) == -1)
            this.turmaInexistente.push(acrTurma);
    }

    public void setSalaInexistente(String acrSala){
        if(salaInexistente.search(acrSala) == -1)
            this.salaInexistente.push(acrSala);
    }

    public void setProfessorMinistrandoAulasNoMesmoHorario(Professor professor){
        if(professorMinistrandoAulasNoMesmoHorario.search(professor) == -1){
            this.professorMinistrandoAulasNoMesmoHorario.push(professor);
        }
    }

    public void setProfessorInexistente(String professor){
        if(professorInexistente.search(professor) == -1)
            this.professorInexistente.push(professor);
    }

    public void showAll(){

        if(turmaInexistente.size() > 0){
            System.out.print("A(s) turmas(s) ");
            turmaInexistente.forEach(t -> {
                if(t.equals(turmaInexistente.lastElement()))
                    System.out.println(t + " é(são) inexistente(s). ");
                else
                    System.out.print(t + ", ");
        });
        System.out.println();
        }


        if(salaInexistente.size() > 0){
            System.out.print("A(s) sala(s) ");
        salaInexistente.forEach(s -> {
            if(s.equals(salaInexistente.lastElement()))
                System.out.println(s + " é(são) inexistente(s). ");
            else
                System.out.print(s + ", ");
        });
        System.out.println();
        }

        professorMinistrandoAulasNoMesmoHorario.forEach(p ->{
            if(p.getListaTurmasNoMesmoHorario().size() > 0){
                //IS está ministrando duas turmas no mesmo horário: EDOO-T01,TRC3-T01 
                System.out.println(p.getAcronimo() + " está ministrando " + p.getListaTurmasNoMesmoHorario().size() + " turmas no mesmo horario: " +  p.getListaTurmasNoMesmoHorario());
            }
        });
        System.out.println();

        if(professorInexistente.size() > 0){
            System.out.print("O(s) professores(s) ");
        professorInexistente.forEach(p -> {
            if(p.equals(professorInexistente.lastElement()))
                System.out.println(p + " é(são) inexistente(s). ");
            else
                System.out.print(p + ", ");
        });
        System.out.println();
        }
    }
}