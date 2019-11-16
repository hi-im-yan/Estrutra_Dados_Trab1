import java.util.Stack;
import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Unknow
 */
public class Aula {

    private int diaDaSemana;
    private String horarioInicial;
    private int duracaoAula;

    // private HashMap<HashMap<Professor, Turma>,HashMap<Turma, Sala>>AULAS = new
    // HashMap<>();

    // for (MapEntry node : AULAS) {
    // for (EntryKey key : AULAS.keys()) {
    // key = new HashMap<>()
    // }
    // for
    // }
    private Turma turma;
    private SalaLab sala;
    private Stack<String> extraTurmas = new Stack<String>();

    public Aula(int diaDaSemana, String horarioInicial, int duracaoAula, Turma turma, SalaLab sala) {
        this.diaDaSemana = diaDaSemana;
        this.horarioInicial = horarioInicial;
        this.duracaoAula = duracaoAula;
        this.turma = turma;
        this.sala = sala;
        this.extraTurmas.push(turma.getAcronimo());
    }

    public void verificarErros() {
        if (this.extraTurmas.size() > 1) {
            exibeTurmaNaMesmaSalaMesmoHorario();
        }
    }

    public void exibeTurmaNaMesmaSalaMesmoHorario() {
        System.out.print(this.sala.getAcronimo() + " está com mais de uma turma alocada no mesmo horário: ");
        this.extraTurmas.forEach(et -> {
            if (et.equals(extraTurmas.lastElement()))
                System.out.println(et + ".");
            else
                System.out.print(et + ", ");
        });
    }

    @Override
    public String toString() {
        return "Aula{" + "diaDaSemana=" + diaDaSemana + ", horarioInicial=" + horarioInicial + ", duracaoAula="
                + duracaoAula + ", turma=" + turma + ", sala=" + sala + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Aula other = (Aula) obj;
        if (this.duracaoAula != other.duracaoAula) {
            return false;
        }
        if (!Objects.equals(this.horarioInicial, other.horarioInicial)) {
            return false;
        }
        if (this.diaDaSemana != other.diaDaSemana) {
            return false;
        }
        if (!Objects.equals(this.turma, other.turma)) {
            return false;
        }
        return Objects.equals(this.sala, other.sala);
    }

    public Stack<String> getExtraTurmas() {
        return extraTurmas;
    }

    public int getDiaDaSemana() {
        return diaDaSemana;
    }

    public void setDiaDaSemana(int diaDaSemana) {
        this.diaDaSemana = diaDaSemana;
    }

    public String getHorarioInicial() {
        return horarioInicial;
    }

    public void setHorarioInicial(String horarioInicial) {
        this.horarioInicial = horarioInicial;
    }

    public int getDuracaoAula() {
        return duracaoAula;
    }

    public void setDuracaoAula(int duracaoAula) {
        this.duracaoAula = duracaoAula;
    }

    public Turma getTurma() {
        return this.turma;
    }

    public void setTurma(Turma turma) {
        if (this.turma == null)
            this.turma = turma;

        if (this.extraTurmas.search(turma.getAcronimo()) == -1)
            extraTurmas.push(turma.getAcronimo());
    }

    public SalaLab getSala() {
        return sala;
    }

    public void setSala(SalaLab sala) {
        this.sala = sala;
    }

}
