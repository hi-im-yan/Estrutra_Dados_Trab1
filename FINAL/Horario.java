import java.util.*;

public class Horario {
    private int duracao;
    private String horarioInicial;
    private static String[][] intervalos = {{"9h15", "9h25"}, {"12h25", "13h15"}, {"15h15", "15h25"}, {"18h25", "18h30"}, {"20h30", "20h40"}};
    public boolean isValid() {

        //como depois desses horarios não existem intervalos, sempre retornará válido
        if(this.horarioInicial.equals("20h40") || this.horarioInicial.equals("21h40"))
            return true;
        
        int indexOfH = this.horarioInicial.indexOf("h");
        int horaInicial = Integer.parseInt(this.horarioInicial.substring(0, indexOfH));
        int minutoInicial = Integer.parseInt(this.horarioInicial.substring(indexOfH + 1, this.horarioInicial.length()));
        int horaResultante = horaInicial + this.duracao;
        String strResultante = horaResultante + "h" + minutoInicial;

        //se o horário da aula extrapolar o último intervalo, é retornado inválido
        if(strResultante.hashCode() > "20h30".hashCode())
            return false;
        
        boolean flag = true;
        for(int i = 0; i < intervalos.length; i++){
            //se o horario inicial foi igual ao final do intervalo e menor que o inicio do próximo intervalo, é retornado verdadeiro
            if(this.horarioInicial.hashCode() == intervalos[i][1].hashCode() && strResultante.hashCode() < intervalos[i+1][0].hashCode()){
                return true;
            }
            //se o horario final da aula for maior que o final do intervalo atual e menor que o início do próximo intervalo
            //significa que a aula passou por um intervalo, o que extrapola o horário permitido. Portanto retorna inválido
            if(strResultante.hashCode() > intervalos[i][1].hashCode() && strResultante.hashCode() < intervalos[i+1][0].hashCode()){
                flag = false;
            }
        }
        return flag;
    }


    public Horario(int duracao, String horarioInicial) {
        this.duracao = duracao;
        this.horarioInicial = horarioInicial;
    }


    public int getDuracao() {
        return this.duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String getHorarioInicial() {
        return this.horarioInicial;
    }

    public void setHorarioInicial(String horarioInicial) {
        this.horarioInicial = horarioInicial;
    }

    public String[][] getIntervalos() {
        return this.intervalos;
    }

    public Horario duracao(int duracao) {
        this.duracao = duracao;
        return this;
    }

    public Horario horarioInicial(String horarioInicial) {
        this.horarioInicial = horarioInicial;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Horario)) {
            return false;
        }
        Horario horario = (Horario) o;
        return Objects.equals(duracao, horario.duracao) && Objects.equals(horarioInicial, horario.horarioInicial)
                && Objects.equals(intervalos, horario.intervalos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(duracao, horarioInicial, intervalos);
    }

    @Override
    public String toString() {
        return "{" + " duracao='" + getDuracao() + "'" + ", horarioInicial='" + getHorarioInicial() + "'"
                + ", intervalos='" + getIntervalos() + "'" + "}";
    }

}