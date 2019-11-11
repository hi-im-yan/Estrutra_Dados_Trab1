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
  private static Erros erro = new Erros();
  
  private static Professor tempProfessor = null;
  private static Turma tempTurma = null;
  private static SalaLab tempSala = null;
  private static boolean turmaIsFound = false;
  private static boolean professorIsFound = false;
  
  private static Stack<String> turmaInexistente = new Stack<String>();
  private static Stack<String> professorInexistente = new Stack<String>();
  private static Stack<String> salaInexistente = new Stack<String>();


  public static void main(String[] paramArrayOfString) {
    leituraDeDados();

    // PROFESSORES.forEach(p -> {
    //   System.out.println(p.getListaTurmasNoMesmoHorario());
    // });

    
    //   System.out.println(erro.teste());

    // AULAS.forEach(a -> {
    //   System.out.println("---" + a.getTurma().getAcronimo() + " - " + a.getTurma().getProfessor().getAcronimo());
    // });

    // AULAS.forEach(aula -> {
    //   System.out.println(aula);
    // });
    // AULAS.forEach(aula -> {
    //   aula.verificarErros();
    // });
    // TURMAS.forEach(turma -> {
    //   turma.mostrarErro();
    // });
    // exibicaoDeErros();

    erro.showAll();

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

      if(tempTurma == null){
        erro.setTurmaInexistente(acrTurma);
      }
      
      SALAS.forEach(paramSalaLab -> {
            if (paramSalaLab.getAcronimo().equals(acrSala)) {
              tempSala = paramSalaLab;
            }
      });

      if(tempSala == null){
        erro.setSalaInexistente(acrSala);
      }
      
      if(tempTurma != null && tempSala != null) {

        boolean jahExisteEssaAula = false;

        for(Aula aula : AULAS){
          if(dia == aula.getDiaDaSemana() && aula.getHorarioInicial().equals(horario)){
            if(acrSala.equals(aula.getSala().getAcronimo())){
              //Se ja existir uma Aula com os mesmos atributos, ele vai conservar só a primeira atribuição
              jahExisteEssaAula = true;
            }
          }
        }

        
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
      if(!professorIsFound){
        erro.setProfessorInexistente(professor);
      }

      

      TURMAS.forEach(t -> {
        if(t.getAcronimo().equals(turma)) {
              turmaIsFound = true;
              //if(t.getProfessor() != null)

              t.setProfessor(tempProfessor);
          }
      });
      if(!turmaIsFound){
        erro.setTurmaInexistente(turma);
      }

      if(tempProfessor!=null)
      checarHorariosDoProfessor(tempProfessor.getAcronimo());

      tempProfessor = null;
      professorIsFound = false;
      turmaIsFound = false;
      str = IN.nextLine();
    } 
  }
  
  private static void checarHorariosDoProfessor(String acrProfessor){
    
    for(Professor professor : PROFESSORES){
      if(professor.getAcronimo().equals(acrProfessor))
        tempProfessor = professor;
    }
    //System.out.println("tempProfessor = " + tempProfessor.getAcronimo());
    List<Aula> aulasDoProfessor = new ArrayList<Aula>();
    AULAS.forEach(a -> {
      if(a.getTurma().getProfessor() != null){
        if(acrProfessor.equals(a.getTurma().getProfessor().getAcronimo()))
        aulasDoProfessor.add(a);
      }
    });
    
    for(int i = 0; i < aulasDoProfessor.size(); i++){
      for(int j = i + 1; j < aulasDoProfessor.size(); j++){
        //System.out.println(acrProfessor + " - " + aulasDoProfessor.get(i).getTurma().getAcronimo() + ", " + aulasDoProfessor.get(j).getTurma().getAcronimo());
        if(aulasDoProfessor.get(i).getDiaDaSemana() == aulasDoProfessor.get(j).getDiaDaSemana()){
          if(aulasDoProfessor.get(i).getHorarioInicial().equals(aulasDoProfessor.get(j).getHorarioInicial()))
              erro.setProfessorMinistrandoAulasNoMesmoHorario(tempProfessor);
              tempProfessor.setTurmaNoMesmoHorario(aulasDoProfessor.get(i).getTurma().getAcronimo());
              tempProfessor.setTurmaNoMesmoHorario(aulasDoProfessor.get(j).getTurma().getAcronimo());
            
        }
      }
    }

    tempProfessor = null;
  }

  private static void exibicaoDeErros() {
    EXCEPTIONS.forEach(paramException -> 
        System.out.println(paramException));

    exibeTurmasInexistentes();
    exibeProfessoresInexistentes();  
    exibeSalasInexistentes(); 
    exibeProfessorMinistrandoVariasAulasNoMesmoHorario();
  }

  //Casos inexistentes estão sendo checados durante a leitura
  //por isso as funções estão sendo colocadas dentro do arquivo siscad

  private static void exibeProfessoresInexistentes(){
    if(professorInexistente.size() > 0){
      System.out.print("O(s) professor(es): ");
    professorInexistente.forEach(p -> {
      if(p.equals(professorInexistente.lastElement()))
        System.out.println(p + " não existe(m).");
      else
        System.out.print(p + ", ");
    });
    }
  }

  private static void exibeTurmasInexistentes(){
    if(turmaInexistente.size() > 0){
      System.out.print("A(s) turma(s): ");
    turmaInexistente.forEach(t -> {
      if(t.equals(turmaInexistente.lastElement()))
        System.out.println(t + " não existe(m).");
      else
        System.out.print(t + ", ");
    });
    }
  }

  private static void exibeSalasInexistentes(){
    if(salaInexistente.size() > 0){
      System.out.print("A(s) sala(s): ");
    salaInexistente.forEach(t -> {
      if(t.equals(salaInexistente.lastElement()))
        System.out.println(t + " não existe(m).");
      else
        System.out.print(t + ", ");
    });
    }
  }

  private static void exibeProfessorMinistrandoVariasAulasNoMesmoHorario(){
    List<Aula> copiaAULAS = new ArrayList<Aula>(AULAS);

    copiaAULAS.forEach(aula -> {
      System.out.println(aula.getTurma());
    });
  }
}

