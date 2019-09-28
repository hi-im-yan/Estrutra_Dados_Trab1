import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

class Siscad {
  private static final List<Aula> AULAS = new ArrayList();
  private static final List<Turma> TURMAS = new ArrayList();
  private static final List<Professor> PROFESSORES = new ArrayList();
  private static final List<SalaLab> SALAS = new ArrayList();
  private static final Scanner IN = new Scanner(System.in);
  private static final Stack<Exception> EXCEPTIONS = new Stack();
  
  private static Turma tempTurma = null;
  private static SalaLab tempSala = null;




  
  private static boolean turmaIsFound = false;



  
  private static boolean professorIsFound = false;




  
  public static void main(String[] paramArrayOfString) {
    leituraDeDados();
    
    exibicaoDeErros();
  }
  
  private static void leituraDeDados() {
    String str = IN.nextLine();
    while (!str.equals("")) {
      String nome = str.substring(3, str.indexOf(",") - 3);
      String acronimo = str.substring(str.indexOf(",") + 5, str.length() - 3);
      PROFESSORES.add(new Professor(nome, acronimo));
      str = IN.nextLine();
    } 
    
    str = IN.nextLine();
    while (!str.equals("")) {
      String nome = str.substring(3, str.indexOf(",") - 3);
      String acronimo = str.substring(str.indexOf(",") + 5, str.length() - 3);
      TURMAS.add(new Turma(nome, acronimo));
      str = IN.nextLine();
    } 
    
    str = IN.nextLine();
    while (!str.equals("")) {
      String nome = str.substring(3, str.indexOf(",") - 3);
      String acronimo = str.substring(str.indexOf(",") + 5, str.length() - 3);
      SALAS.add(new SalaLab(nome, acronimo));
      str = IN.nextLine();
    } 
    str = IN.nextLine();
    while (!str.equals("")) {
      String acrTurma = str.substring(3, str.indexOf(",") - 3);
      str = str.substring(str.indexOf(",") + 3, str.length());
      int dia = Integer.parseInt(str.substring(2, str.indexOf(",") - 3));
      str = str.substring(str.indexOf(",") + 3, str.length());
      String horario = str.substring(2, str.indexOf(",") - 3);
      str = str.substring(str.indexOf(",") + 3, str.length());
      int duracao = Integer.parseInt(str.substring(2, str.indexOf(",") - 3));
      str = str.substring(str.indexOf(",") + 3, str.length());
      String acrSala = str.substring(2, str.length() - 3);
      
      System.out.println("Aula: " + acrTurma + " " + dia + " " + horario + " " + duracao + " " + acrSala);
      
      if (duracao > 2) {
        EXCEPTIONS.push(new RuntimeException("Duracao de aula de : " + acrTurma + " ultrapassa os limites permitidos."));
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
        EXCEPTIONS.push(new RuntimeException("Turma: " + acrTurma + " nao existe."));
      } else if (tempSala == null) {
        EXCEPTIONS.push(new RuntimeException("Sala: " + acrSala + " nao existe."));
      } else {
        AULAS.add(new Aula(dia, horario, duracao, tempTurma, tempSala));
      } 
      
      tempTurma = null;
      tempSala = null;
      str = IN.nextLine();
    } 
    
    str = IN.nextLine();
    while (!str.equals("")) {
      String turma = str.substring(3, str.indexOf(",") - 3);
      String professor = str.substring(str.indexOf(",") + 5, str.length() - 3);
      
      PROFESSORES.forEach(p -> {
            if (p.getAcronimo().equals(professor)) {
              professorIsFound = true;
              TURMAS.forEach(t -> {
                  if(t.getAcronimo().equals(turma)) {
                      turmaIsFound = true;
                      t.setProfessor(p);
                  }
              });
            } 
          });
      if (!professorIsFound) {
        EXCEPTIONS.push(new RuntimeException("O Professor: " + professor + " nao existe"));
      }
      if (!turmaIsFound) {
        EXCEPTIONS.push(new RuntimeException("A Turma: " + turma + " nao existe"));
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
