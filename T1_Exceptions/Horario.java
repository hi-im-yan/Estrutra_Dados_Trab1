import java.util.*;

public class Horario {
    private int duracao;
    private String horarioInicial;
    private final Map<String,String> intervalos;

    public boolean isValid() {

        int indexOfH = this.horarioInicial.indexOf("h");
        int horaInicial = Integer.parseInt(this.horarioInicial.substring(0, indexOfH));
        int minutoInicial = Integer.parseInt(this.horarioInicial.substring(indexOfH + 1, this.horarioInicial.length()));
        int horaResultante = horaInicial + this.duracao;
        String strResultante = horaResultante + "h" + minutoInicial;

        boolean flag = true;
        for (Map.Entry<String,String> intervalo : intervalos.entrySet()) {
            if (intervalo.getKey().hashCode() <= strResultante.hashCode()
                    && intervalo.getValue().hashCode() > strResultante.hashCode()) {
                flag = false;
                break;
            }
        }

        return flag;
    }

    public Horario() {
        this.intervalos = new HashMap<>();
        this.intervalos.put("9h15", "9h25");
        this.intervalos.put("12h25", "13h15");
        this.intervalos.put("15h15", "15h25");
        this.intervalos.put("18h25", "18h30");
        this.intervalos.put("20h30", "20h40");
    }

    public Horario(int duracao, String horarioInicial, Map intervalos) {
        this.duracao = duracao;
        this.horarioInicial = horarioInicial;
        this.intervalos = intervalos;
    }

    public Horario(int duracao, String horarioInicial) {
        this.duracao = duracao;
        this.horarioInicial = horarioInicial;
        this.intervalos = new HashMap<>();
        this.intervalos.put("9h15", "9h25");
        this.intervalos.put("12h25", "13h15");
        this.intervalos.put("15h15", "15h25");
        this.intervalos.put("18h25", "18h30");
        this.intervalos.put("20h30", "20h40");
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

    public Map getIntervalos() {
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