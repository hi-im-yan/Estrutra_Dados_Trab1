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

    public Stack<Professor> teste() {
        return this.professorMinistrandoAulasNoMesmoHorario;
    }

    public Erros() {
    }

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

    public void showAll() {
        System.out.println("\n");

        horariosUltrapassamLimitesPermitidos.forEach(turma -> {
            System.out.println("A duracao de aula da turma " + turma + " ultrapassa os limites permitidos.");
        });
        horarioInicialInvalido.forEach(turma -> {
            System.out.println("O horario inicial de  " + turma + " e invalido.");
        });
        SalaComTurmasNoMesmoHorario.forEach(s -> {
            System.out.println("A sala " + s.getAcronimo() + " está com mais de uma turma alocada no mesmo horario: "
                    + s.getTurmaExtraNoMesmoHorario());
        });

        professorMinistrandoAulasNoMesmoHorario.forEach(p -> {
            if (p.getListaTurmasNoMesmoHorario().size() > 0) {
                // IS está ministrando duas turmas no mesmo horário: EDOO-T01,TRC3-T01
                System.out.println(p.getAcronimo() + " está ministrando " + p.getListaTurmasNoMesmoHorario().size()
                        + " turmas no mesmo horario: " + p.getListaTurmasNoMesmoHorario());
            }
        });

        if (turmaInexistente.size() > 0) {
            System.out.print("A(s) turmas(s) ");
            turmaInexistente.forEach(t -> {
                if (t.equals(turmaInexistente.lastElement()))
                    System.out.println(t + " é(são) inexistente(s). ");
                else
                    System.out.print(t + ", ");
            });
            // System.out.println();
        }

        if (salaInexistente.size() > 0) {
            System.out.print("A(s) sala(s) ");
            salaInexistente.forEach(s -> {
                if (s.equals(salaInexistente.lastElement()))
                    System.out.println(s + " é(são) inexistente(s). ");
                else
                    System.out.print(s + ", ");
            });
            // System.out.println();
        }

        turmaComVariosProfessores.forEach(t -> {
            System.out.println("A turma " + t.getAcronimo() + " está sendo ministrada por mais de um professor:"
                    + t.getProfessores());
        });

        // System.out.println();

        if (professorInexistente.size() > 0) {
            System.out.print("O(s) professores(s) ");
            professorInexistente.forEach(p -> {
                if (p.equals(professorInexistente.lastElement()))
                    System.out.println(p + " é(são) inexistente(s). ");
                else
                    System.out.print(p + ", ");
            });
            // System.out.println();
        }

        System.out.println("\n");

    }
}