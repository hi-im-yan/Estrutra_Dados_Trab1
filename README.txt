Pra galerinha que for pegar e olhar esse código.

O código final ta na pasta FINAL. A deadline desse trabalho tava bem próximo então talvez tenha algumas gambiarras. Todos os "erros" são enviadas para a Classe Erro afim de deixar organizado. Os "erros" são identificados em tempo de leitura pois era mais fácil assim mesmo.

Modo de compilação e arquivo teste está dentro da pasta FINAL também. Pra ser sincero a única coisa difícil desse trabalho foi a leitura dele, o resto é mera comparação do que existe, não existe, válido ou inválido... Simples comparação de valores.

Foi tentado deixar bonito usando HashMap e os krl, mas deu preguiça e o prazo de entrega tava chegando. Fica a vontade em melhorar esse código, mas da um pull request no final do seu trabalho pra ver o que você fez pra melhorar o código. É nois.
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

NOTA FINAL: 9,3.
Yan e Carlos (NOTA 9,3): T1.txt OK e T2.txt faltou 2.10 (-0,2) e exige-se 3.1.

Critérios de correção:

T1. txt é:
"Irineu Sotoma", "IS"
"Outro Professor", "OP"

"Estrutura de Dados e Programacao Orientada a Objetos - T01", "EDOO-T01"
"Topicos em Redes de Computadores III - T01", "TRC3-T01"
"Sistemas Operacionais - T20", "SO-T20"

"Laboratorio de Ensino I", "LAB1"
"Sala do Multiuso M13", "M13"
"Sala do Multiuso M12", "M12"
"Laboratorio de Ensino X", "LABX"

"SO-T20", "2", "7h15", "4", "M12"
"EDOO-T01", "2", "18h30", "2", "LAB1"
"EDOO-T01", "4", "18h30", "2", "M13"
"EDOO-T01", "6", "18h30", "2", "LAB1"
"TRC3-T01", "4", "18h30", "2", "M13"

"EDOO-T01", "IS"
"TRC3-T01", "IS"
"SO-T20", "OP"
"OD-T01", "IS"
"SO-T20", "IS"

Exemplo de saída para o caso T1.txt:
1.1) Duração de aula de SO-T20 ultrapassa os limites permitidos
1.2) M13 está com mais de uma turma alocada no mesmo horário: EDOO-T01,TRC3-T01
1.3) IS está ministrando duas turmas no mesmo horário: EDOO-T01,TRC3-T01
1.4) OD-T01 é uma turma inexistente.
1.5) SO-T20 está sendo ministrada por mais de um professor: OP IS

T2. txt é:
"Irineu Sotoma", "IS"
"Outro Professor", "OP"
"João da Silva", "JS"

"Estrutura de Dados e Programacao Orientada a Objetos - T01", "EDOO-T01"
"Topicos em Redes de Computadores III - T01", "TRC3-T01"
"Sistemas Operacionais - T20", "SO-T20"
"Inteligencia Artificial - T-05", "IA-T05"
"Banco de Dados - T02", "BD-T02"

"Laboratorio de Ensino I", "LAB1"
"Sala do Multiuso M13", "M13"
"Sala do Multiuso M12", "M12"
"Sala do Multiuso M10", "M10"
"Laboratorio de Ensino X", "LABX"

"SO-T20", "2", "7h15", "4", "M12"
"EDOO-T01", "2", "18h30", "2", "LAB1"
"EDOO-T01", "4", "18h30", "2", "M13"
"EDOO-T01", "6", "18h30", "2", "LAB1"
"TRC3-T01", "4", "18h30", "2", "M13"
"TRC3-T01", "4", "8h15", "2", "M13"
"SO-T20", "2", "7h15", "4", "M11"
"LFA-T01", "2", "7h15", "2", "M9"
"SO-T20", "2", "7h14", "4", "M12"
"IA-T05", "4", "18h30", "2", "M12"
"SO-T20", "3", "8h15", "1", "LABX"
"TRC3-T01", "5", "7h15", "2", "M10"
"TRC3-T01", "2", "18h30", "2", "M10"
"TRC3-T01", "4", "13h15", "2", "M13"
"TRC3-T01", "6", "10h25", "2", "M13"
"BD-T02", "3", "20h40", "1", "LABX"

"EDOO-T01", "IS"
"IA-T05", "IS"
"TRC3-T01", "IS"
"SO-T20", "OP"
"OD-T01", "IS"
"SO-T20", "IS"
"LFA-T01", "LM"
"BD-T02", "JS"

Exemplo de saída para o caso T2.txt:
2.1) Duração de aula de SO-T20 ultrapassa os limites permitidos
2.2) M13 está com mais de uma turma alocada no mesmo horário: EDOO-T01,TRC3-T01
2.3) Duração de aula de TRC3-T01 ultrapassa os limites permitidos
2.4) Sala ou Laboratório M11 inexistente.
2.5) Duração de aula de SO-T20 ultrapassa os limites permitidos
2.6) Turma LFA-T01 inexistente.
2.7) Sala ou Laboratório M9 inexistente.
2.8) Horário inicial 7h14 da disciplina SO-T20 não é permitido
2.9) Duração de aula de SO-T20 ultrapassa os limites permitidos
2.10) M12 está com mais de uma turma alocada no mesmo horário: SO-T20,SO-T20
2.11) IS está ministrando duas turmas no mesmo horário: EDOO-T01,IA-T05
2.12) IS está ministrando duas turmas no mesmo horário: EDOO-T01,TRC3-T01
2.13) IS está ministrando duas turmas no mesmo horário: IA-T05,TRC3-T01
2.14) OD-T01 é uma turma inexistente.
2.15) SO-T20 está sendo ministrada por mais de um professor: OP IS
2.16) LFA-T01 é uma turma inexistente.
2.17) Professor LM inexistente.

  Para quem exigiu linhas em branco adicionais ao final do arquivo de entrada:
3.1) -0,5.

  Para quem utilizou exigência adicional ao final de cada bloco (;):
3.2) -0,2.

  Para quem não indicou corretamente a forma de compilar:
3.3) -0,2.

  Houve necessidade de utilizar -encoding latin1 na compilação e não foi informado pelo aluno:
3.4) -0,2.

  Para quem exigiu que a abreviatura de horas fosse em maiúsculo:
3.5) -0,2.
