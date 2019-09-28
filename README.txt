CLASSES E ATRIBUTOS:
	Professor -> Nome(STRING), Acronimo(STRING)
	Turma -> Nome, Acronimo, Professor
	SalaLab -> Nome, Acronimo, Turma
	QuadroHorario -> Horário, Dia, SalaLab

COISAS QUE DEVEM ESTAR CORRETAS:
	1. Um professor pode ministrar várias turmas.
	2. Uma turma deve ter somente um professor.
	3. Um horário pode ter várias salas ou laboratórios. 
	4. Uma sala ou laboratório deve ter somente uma turma alocada em um horário X.
	5. Os acrônimos devem ter de 1 até 12 caracteres.

COISAS QUE PRECISAM RETORNAR:
	1. Professor ministrando em duas ou mais turmas no mesmo horário.
	2. Uma turma sendo ministrada por mais de um professor.
	3. Sala ou laboratório com uma ou mais turmas alocadas no mesmo horário.
	4. Horário inicial de aula não permitido.
	5. Duração de aula extrapola os limites permitidos.
	6. Turma inexistente.
	7. Professor inexistente.
	8. Sala ou Laboratório inexistente.

CONDIÇÕES DO TRABALHO:
	1. Usar vetores, listas, filas e pilhas.
	2. Caso haja conflito entre horários, turmas, professores etc. Não sobrepor informações, apenas considerar o primeiro.

DADO AS INFORMAÇÕES QUE PRECISAM SER RETORNADAS É MELHOR QUE:
	1. O atributo professores na classe Turma devem estar em uma pilha. (Caso já tenha um professor na turma é só dar um pop)
	2. O atributo turma na classe SalaLab devem estar em filas. (Primeiro que pegar a sala fica com ela GG)
	3. O atributo SalaLab da classe QuadroHorario deve ser uma lista. (Um horário pode possuir várias salas)
	4. Professores devem estar armazenados em um vetor.
	


//---------------------------------------------------------Fim---------------------------------------------------//