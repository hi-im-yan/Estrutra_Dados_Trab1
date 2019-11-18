import java.util.Stack;
import java.util.Objects;


public class Aula {

    private int diaDaSemana;
    private String horarioInicial;
    private int duracaoAula;


    private Turma turma;
    private SalaLab sala;
    //variavel que contém turmas na mesma sala, mesmo dia e mesmo horário
    private Stack<String> extraTurmas = new Stack<String>();

    public Aula(int diaDaSemana, String horarioInicial, int duracaoAula, Turma turma, SalaLab sala) {
        this.diaDaSemana = diaDaSemana;
        this.horarioInicial = horarioInicial;
        this.duracaoAula = duracaoAula;
        this.turma = turma;
        this.sala = sala;
        this.extraTurmas.push(turma.getAcronimo());
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

    //caso o atributo turma for nulo, vai ser atribuido uma nova turma, isso evita sobreposição
    public void setTurma(Turma turma) {
        if (this.turma == null)
            this.turma = turma;

        //turmas extras serão alocadas na variável extraTurmas
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
