import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

class Siscad {
  private static final List<Aula> AULAS = new ArrayList<Aula>();
  private static final List<Turma> TURMAS = new ArrayList<Turma>();
  private static final List<Professor> PROFESSORES = new ArrayList<Professor>();
  private static final List<SalaLab> SALAS = new ArrayList<SalaLab>();
  private static final Scanner IN = new Scanner(System.in);
  private static Erros erro = new Erros();

  private static Professor tempProfessor = null;
  private static Turma tempTurma = null;
  private static SalaLab tempSala = null;
  private static boolean turmaIsFound = false;
  private static boolean professorIsFound = false;

  private static List<String> horariosValidos = new ArrayList<>();


  public static void main(String[] paramArrayOfString) {
    Siscad.horariosValidos.add("7h15");
    Siscad.horariosValidos.add("8h15");
    Siscad.horariosValidos.add("9h25");
    Siscad.horariosValidos.add("10h25");
    Siscad.horariosValidos.add("11h25");
    Siscad.horariosValidos.add("13h15");
    Siscad.horariosValidos.add("14h15");
    Siscad.horariosValidos.add("15h25");
    Siscad.horariosValidos.add("16h25");
    Siscad.horariosValidos.add("17h25");
    Siscad.horariosValidos.add("18h30");
    Siscad.horariosValidos.add("19h30");
    Siscad.horariosValidos.add("20h40");
    Siscad.horariosValidos.add("21h40");

    leituraDeDados();

    erro.showAll();
  }

  private static void leituraDeDados() {

    // Leitura de professor e seu acronimo
    String str = IN.nextLine();
    while (!str.equals("")) {
      String nome = str.substring(1, str.indexOf(",") - 1);
      String acronimo = str.substring(str.indexOf(",") + 3, str.length() - 1);
      PROFESSORES.add(new Professor(nome, acronimo));
      str = IN.nextLine();
    }

    // Leitura da turma e seu acronimo
    str = IN.nextLine();
    while (!str.equals("")) {
      String nome = str.substring(1, str.indexOf(",") - 1);
      String acronimo = str.substring(str.indexOf(",") + 3, str.length() - 1);
      TURMAS.add(new Turma(nome, acronimo));
      str = IN.nextLine();
    }

    // Leitura da Sala e seu acronimo
    str = IN.nextLine();
    while (!str.equals("")) {
      String nome = str.substring(1, str.indexOf(",") - 1);
      String acronimo = str.substring(str.indexOf(",") + 3, str.length() - 1);
      SALAS.add(new SalaLab(nome, acronimo));
      str = IN.nextLine();
    }

    // Leitura da turma(acronimo), dia, horário, tempo de aula, sala(acronimo)
    str = IN.nextLine();
    while (!str.equals("")) {
      String acrTurma = str.substring(1, str.indexOf(",") - 1);
      str = str.substring(str.indexOf(",") + 3, str.length());
      int dia = 0;
      boolean diaValido = true;
      try {
        dia = Integer.parseInt(str.substring(0, str.indexOf(",") - 1));
      } catch (NumberFormatException e) {
        String d = str.substring(0, str.indexOf(",") - 1);
        switch (d.toLowerCase()) {
        case "s":
          dia = 7;
          break;
        case "d":
          dia = 8;
          break;
        default:
          //se o dia lido não for nenhum dia da semana, a aula não será criada
          diaValido = false;
          break;

        }
      }
      str = str.substring(str.indexOf(",") + 3, str.length());
      String horario = str.substring(0, str.indexOf(",") - 1);
      str = str.substring(str.indexOf(",") + 3, str.length());
      int duracao = Integer.parseInt(str.substring(0, str.indexOf(",") - 1));
      str = str.substring(str.indexOf(",") + 3, str.length());
      String acrSala = str.substring(0, str.length() - 1);

      //se o horario inicial for inválido, o erro é enviado para classe Erro
      if (!Siscad.horariosValidos.contains(horario))
        erro.setHorarioInicialInvalido(acrTurma);
      Horario hr = new Horario(duracao, horario);

      //se a duração da aula extrapolar o inicio de um intervalo, o erro é enviado para classe Erro
      if (!hr.isValid())
        erro.setHorariosUltrapassamLimitesPermitidos(acrTurma);

      //verificando se a turma lida está na lista de TURMAS
      TURMAS.forEach(t -> {
        if (t.getAcronimo().equals(acrTurma)) {
          tempTurma = t;
        }
      });
      //se a turma não for encontrada, o erro é enviado para classe Erro
      if (tempTurma == null) {
        erro.setTurmaInexistente(acrTurma);
      }

      //verificando se a sala lida está na lista de SALAS
      SALAS.forEach(paramSalaLab -> {
        if (paramSalaLab.getAcronimo().equals(acrSala)) {
          paramSalaLab.setTurmaExtraNoMesmoHorario(acrTurma);

          //se a a sala possuir mais de uma turma no mesmo horario, o erro é enviado para classe Erro
          if (paramSalaLab.getTurmaExtraNoMesmoHorario().size() > 1)
            erro.setSalaComTurmasNoMesmoHorario(paramSalaLab);
          tempSala = paramSalaLab;
        }
      });
      //se a sala não for encontrada, o erro é enviado para classe Erro
      if (tempSala == null) {
        erro.setSalaInexistente(acrSala);
      }

      //se a turma existir, a sala existir e o dia da semana for válido, é criado uma nova aula
      if (tempTurma != null && tempSala != null && diaValido) {
        AULAS.add(new Aula(dia, horario, duracao, tempTurma, tempSala));
      }

      tempTurma = null;
      tempSala = null;
      diaValido = true;
      str = IN.nextLine();
    }

    // Leitura da turma(acronimo) e professor(acronimo)
    str = IN.nextLine();
    while (!str.equals("")) {
      String turma = str.substring(1, str.indexOf(",") - 1);
      String professor = str.substring(str.indexOf(",") + 3, str.length() - 1);

      //verifica se o professor está na lista de PROFESSORES
      PROFESSORES.forEach(p -> {
        if (p.getAcronimo().equals(professor)) {
          professorIsFound = true;
          tempProfessor = p;
        }
      //se o professor não for encontrado, o erro é enviado para classe Erro
      });
      if (!professorIsFound) {
        erro.setProfessorInexistente(professor);
      }

      //verifica se a turma existe na lista de TURMAS
      TURMAS.forEach(t -> {
        if (t.getAcronimo().equals(turma)) {
          turmaIsFound = true;
          t.setProfessor(tempProfessor);

          //se a turma estiver com mais de um professor ministrando ela, o erro é enviado para classe Erro
          if (t.getProfessores().size() > 1)
            erro.setTurmaComVariosProfessores(t);
        }
      });
      //se a turma não for encontrada, o erro é enviado para classe Erro
      if (!turmaIsFound) {
        erro.setTurmaInexistente(turma);
      }

      //se o professor for encontrado, é checado se ele está ministrando várias aulas no mesmo horario
      if (tempProfessor != null)
        checarHorariosDoProfessor(tempProfessor.getAcronimo());

      tempProfessor = null;
      professorIsFound = false;
      turmaIsFound = false;
      str = IN.nextLine();
    }
  }

  //função para checar se o professor está ministrando várias aulas no mesmo horario
  private static void checarHorariosDoProfessor(String acrProfessor) {

    //procura pelo acronimo do professor na lista de PROFESSORES
    for (Professor professor : PROFESSORES) {
      if (professor.getAcronimo().equals(acrProfessor))
        tempProfessor = professor;
    }

    //variável que armazena todas as aulas do professor
    List<Aula> aulasDoProfessor = new ArrayList<Aula>();
    AULAS.forEach(a -> {
      if (a.getTurma().getProfessor() != null) {
        if (acrProfessor.equals(a.getTurma().getProfessor().getAcronimo()))
          aulasDoProfessor.add(a);
      }
    });

    //se o professor tiver mais de uma aula no mesmo dia e mesmo horario inicial, o erro é enviado para classe Erro
    for (int i = 0; i < aulasDoProfessor.size(); i++) {
      for (int j = i + 1; j < aulasDoProfessor.size(); j++) {
        if (aulasDoProfessor.get(i).getDiaDaSemana() == aulasDoProfessor.get(j).getDiaDaSemana()) {
          if (aulasDoProfessor.get(i).getHorarioInicial().equals(aulasDoProfessor.get(j).getHorarioInicial()))
            erro.setProfessorMinistrandoAulasNoMesmoHorario(tempProfessor);
          tempProfessor.setTurmaNoMesmoHorario(aulasDoProfessor.get(i).getTurma().getAcronimo());
          tempProfessor.setTurmaNoMesmoHorario(aulasDoProfessor.get(j).getTurma().getAcronimo());

        }
      }
    }

    tempProfessor = null;
  }

}