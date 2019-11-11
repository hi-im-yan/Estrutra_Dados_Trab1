import java.util.ArrayList;
import java.util.List;

public class Professor{
    private String nome;
    private String acronimo;

    private List<String> turmasMinistradasNoMesmoHorario = new ArrayList<String>();

    //-----------------------Constructors----------------------------------//
    public Professor(){

    }

    public Professor(String nome, String acronimo){
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

    public List getListaTurmasNoMesmoHorario(){
        return this.turmasMinistradasNoMesmoHorario;
    }

    //-----------------------Setters----------------------------------//
    public void setNome(String nome){
        this.nome = nome;
    }

    public void setAcronimo(String acronimo){
        this.acronimo = acronimo;
    }

    public void setTurmaNoMesmoHorario(String turma){
        if(!turmasMinistradasNoMesmoHorario.contains(turma))
        this.turmasMinistradasNoMesmoHorario.add(turma);
    }


    public String toString(){
        return this.acronimo;
    }
}