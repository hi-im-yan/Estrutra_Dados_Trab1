
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
    
    private Turma turma;
    private SalaLab sala;

    public Aula(int diaDaSemana, String horarioInicial, int duracaoAula, Turma turma, SalaLab sala) {
        this.diaDaSemana = diaDaSemana;
        this.horarioInicial = horarioInicial;
        this.duracaoAula = duracaoAula;
        this.turma = turma;
        this.sala = sala;
    }
    
    

    @Override
    public String toString() {
        return "Aula{" + "diaDaSemana=" + diaDaSemana + ", horarioInicial=" + horarioInicial + ", duracaoAula=" + duracaoAula + ", turma=" + turma + ", sala=" + sala + '}';
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
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public SalaLab getSala() {
        return sala;
    }

    public void setSala(SalaLab sala) {
        this.sala = sala;
    }
    
    
    
}
