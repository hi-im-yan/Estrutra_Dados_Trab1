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
  private static final Stack<String> EXCEPTIONS = new Stack<String>();
  
  private static Professor tempProfessor = null;
  private static Turma tempTurma = null;
  private static SalaLab tempSala = null;
  private static boolean turmaIsFound = false;
  private static boolean professorIsFound = false;
  
  public static void main(String[] paramArrayOfString) {
    leituraDeDados();
    AULAS.forEach(aula -> {
      aula.verificarErros(EXCEPTIONS);
    });
    exibicaoDeErros();
  }
  
  private static void leituraDeDados() {

    //Leitura de professor e seu acronimo
    String str = IN.nextLine();
    while (!str.equals("")) {
      String nome = str.substring(1, str.indexOf(",") - 1);
      //System.out.println(nome);
      String acronimo = str.substring(str.indexOf(",") + 3, str.length() - 1);
      //System.out.println(acronimo);
      PROFESSORES.add(new Professor(nome, acronimo));
      str = IN.nextLine();
    } 
    
    //Leitura da turma e seu acronimo
    str = IN.nextLine();
    while (!str.equals("")) {
      String nome = str.substring(1, str.indexOf(",") - 1);
      //System.out.println(nome);
      String acronimo = str.substring(str.indexOf(",") + 3, str.length() - 1);
      //System.out.println(acronimo);
      TURMAS.add(new Turma(nome, acronimo));
      str = IN.nextLine();
    } 
    
    //Leitura da Sala e seu acronimo
    str = IN.nextLine();
    while (!str.equals("")) {
      String nome = str.substring(1, str.indexOf(",") - 1);
      //System.out.println(nome);
      String acronimo = str.substring(str.indexOf(",") + 3, str.length() - 1);
      //System.out.println(acronimo);
      SALAS.add(new SalaLab(nome, acronimo));
      str = IN.nextLine();
    } 

    //Leitura da turma(acronimo), dia, horário, tempo de aula, sala(acronimo)
    str = IN.nextLine();
    while (!str.equals("")) {
      String acrTurma = str.substring(1, str.indexOf(",") - 1);
      str = str.substring(str.indexOf(",") + 3, str.length());
      int dia = Integer.parseInt(str.substring(0, str.indexOf(",") - 1));
      str = str.substring(str.indexOf(",") + 3, str.length());
      String horario = str.substring(0, str.indexOf(",") - 1);
      str = str.substring(str.indexOf(",") + 3, str.length());
      int duracao = Integer.parseInt(str.substring(0, str.indexOf(",") - 1));
      str = str.substring(str.indexOf(",") + 3, str.length());
      String acrSala = str.substring(0, str.length() - 1);
      //System.out.println("Aula: " + acrTurma + " " + dia + " " + horario + " " + duracao + " " + acrSala);
      
      if (duracao > 2) {
        EXCEPTIONS.push(new String("Duracao de aula de : " + acrTurma + " ultrapassa os limites permitidos."));
      }
      
      TURMAS.forEach(t -> {
            if (t.getAcronimo().equals(acrTurma)) {
              tempTurma = t;
            }
          });
      
      SALAS.forEach(paramSalaLab -> {
            if (paramSalaLab.getAcronimo().equals(acrSala)) {
              tempSala = paramSalaLab;
            }
          });
      
      if (tempTurma == null) {
        EXCEPTIONS.push(new String("Turma: " + acrTurma + " nao existe."));
      } else if (tempSala == null) {
        EXCEPTIONS.push(new String("Sala: " + acrSala + " nao existe."));
      } else {
        AULAS.add(new Aula(dia, horario, duracao, tempTurma, tempSala));
      } 
      
      tempTurma = null;
      tempSala = null;
      str = IN.nextLine();
    } 
    
    //Leitura da turma(acronimo) e professor(acronimo)
    str = IN.nextLine();
    while (!str.equals("")) {
      String turma = str.substring(1, str.indexOf(",") - 1);
      //System.out.println(turma);
      String professor = str.substring(str.indexOf(",") + 3, str.length() - 1);
      //System.out.println(professor);
      PROFESSORES.forEach(p -> {
            if (p.getAcronimo().equals(professor)) {
              professorIsFound = true;
              tempProfessor = p;
            } 
          });
      TURMAS.forEach(t -> {
        if(t.getAcronimo().equals(turma)) {
              turmaIsFound = true;
              t.setProfessor(tempProfessor);
          }
      });

      tempProfessor = null;
      if (!professorIsFound) {
        EXCEPTIONS.push(new String("O Professor: " + professor + " nao existe"));
      }
      if (!turmaIsFound) {
        EXCEPTIONS.push(new String("A Turma: " + turma + " nao existe"));
      }
      
      professorIsFound = false;
      turmaIsFound = false;
      str = IN.nextLine();
    } 
  }
  
  private static void exibicaoDeErros() {
    EXCEPTIONS.forEach(paramException -> 
        System.out.println(paramException));
  }
}
