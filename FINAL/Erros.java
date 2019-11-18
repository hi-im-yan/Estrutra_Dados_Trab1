import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Erros {

    private Stack<String> turmaInexistente = new Stack<String>();
    private Stack<String> salaInexistente = new Stack<String>();
    private Stack<Professor> professorMinistrandoAulasNoMesmoHorario = new Stack<Professor>();
    private Stack<String> professorInexistente = new Stack<String>();
    private Stack<Turma> turmaComVariosProfessores = new Stack<Turma>();
    private Stack<SalaLab> SalaComTurmasNoMesmoHorario = new Stack<SalaLab>();
    private Stack<String> horariosUltrapassamLimitesPermitidos = new Stack<String>();
    private Stack<String> horarioInicialInvalido = new Stack<String>();


    public Erros() {
    }

    //o método search() está servindo apenas para evitar duplicação de erros

    public void setTurmaInexistente(String acrTurma) {
        if (turmaInexistente.search(acrTurma) == -1)
            this.turmaInexistente.push(acrTurma);
    }

    public void setSalaInexistente(String acrSala) {
        if (salaInexistente.search(acrSala) == -1)
            this.salaInexistente.push(acrSala);
    }

    public void setProfessorMinistrandoAulasNoMesmoHorario(Professor professor) {
        if (professorMinistrandoAulasNoMesmoHorario.search(professor) == -1) {
            this.professorMinistrandoAulasNoMesmoHorario.push(professor);
        }
    }

    public void setProfessorInexistente(String professor) {
        if (professorInexistente.search(professor) == -1)
            this.professorInexistente.push(professor);
    }

    public void setTurmaComVariosProfessores(Turma turma) {
        if (turmaComVariosProfessores.search(turma) == -1)
            this.turmaComVariosProfessores.push(turma);
    }

    public void setSalaComTurmasNoMesmoHorario(SalaLab sala) {
        if (SalaComTurmasNoMesmoHorario.search(sala) == -1)
            this.SalaComTurmasNoMesmoHorario.push(sala);
    }

    public void setHorariosUltrapassamLimitesPermitidos(String turma) {
        if (horariosUltrapassamLimitesPermitidos.search(turma) == -1)
            this.horariosUltrapassamLimitesPermitidos.push(turma);
    }

    public void setHorarioInicialInvalido(String turma) {
        if (horarioInicialInvalido.search(turma) == -1)
            this.horarioInicialInvalido.push(turma);
    }

    //função que mostra todos os erros de conflitos e atribuições inexistentes.
    public void showAll() {

        SalaComTurmasNoMesmoHorario.forEach(s -> {
            System.out.print("A sala " + s.getAcronimo() + " está com mais de uma turma alocada no mesmo horario: ");
            s.getTurmaExtraNoMesmoHorario().forEach(sl -> {
                if(sl.equals(s.getTurmaExtraNoMesmoHorario().get(s.getTurmaExtraNoMesmoHorario().size() - 1)))
                    System.out.println(sl + ".");
                else
                    System.out.print(sl + ", ");
            });
        });

        horariosUltrapassamLimitesPermitidos.forEach(turma -> {
            System.out.println("A duracao de aula da turma " + turma + " ultrapassa os limites permitidos.");
        });

        horarioInicialInvalido.forEach(turma -> {
            System.out.println("O horario inicial de " + turma + " e invalido.");
        });
        professorMinistrandoAulasNoMesmoHorario.forEach(p -> {
            
            if (p.getListaTurmasNoMesmoHorario().size() > 0) {
                System.out.print(p.getAcronimo() + " está ministrando " + p.getListaTurmasNoMesmoHorario().size()
                        + " turmas no mesmo horario: ");
                p.getListaTurmasNoMesmoHorario().forEach(t -> {
                    if(t.equals(p.getListaTurmasNoMesmoHorario().get(p.getListaTurmasNoMesmoHorario().size() - 1)))
                        System.out.println(t + ".");
                    else
                        System.out.print(t + ", ");
                });
            }
        });

        if (turmaInexistente.size() > 0) {
            turmaInexistente.forEach(t -> {
                System.out.print("A turma "); System.out.println(t + " não existe.");
            });

        }

        if (salaInexistente.size() > 0) {
            salaInexistente.forEach(s -> {
                System.out.print("A sala "); System.out.println(s + " não existe.");
            });
        }

        turmaComVariosProfessores.forEach(t -> {
            System.out.print("A turma " + t.getAcronimo() + " está sendo ministrada por mais de um professor: ");
            t.getProfessores().forEach(te -> {
                if(te.equals(t.getProfessores().get(t.getProfessores().size() - 1)))
                    System.out.println(te + ".");
                else
                    System.out.print(te + ", ");
            });
        });


        if (professorInexistente.size() > 0) {
            professorInexistente.forEach(p -> {
                System.out.print("O professor "); System.out.println(p + " não existe.");
            });
        }
    }
}