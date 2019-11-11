import java.util.ArrayList;
import java.util.List;

public class SalaLab{
    private String nome;
    private String acronimo;
    private List<String> turmaExtra = new ArrayList<String>();
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

    public List getTurmaExtraNoMesmoHorario(){
        return this.turmaExtra;
    }

    //-----------------------Setters----------------------------------//
    public void setNome(String nome){
        this.nome = nome;
    }

    public void setAcronimo(String acronimo){
        this.acronimo = acronimo;
    }

    public void setTurmaExtraNoMesmoHorario(String turma){
        if(!turmaExtra.contains(turma))
        this.turmaExtra.add(turma);
    }
}