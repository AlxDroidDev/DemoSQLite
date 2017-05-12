## Demo Interativo para SQLite3

##### Parte da Atividade Auto-Instrucional apresentada por Alex Simonetti Abreu à disciplina:
    Banco de Dados 2
    Curso de Ciência da Computação  
    Universidade FUMEC
    
    Semestre 01 / 2017


**Nota:** O app deste repositório também estará disponível na Google Play Store. O link será colocado aqui na data adequada, antes da apresentação.

Para a construção destre projeto foi elaborado um banco de dados similar ao utilizado em sala de aula 
pelo Prof. Humberto em sua disciplina, contudo buscando apresentar alguns recursos avançados do SQLite3
que o colocam lado-a-lado com o SQL Server. Especificamente alguns dos recursos que foram utilizados:

+ Integridade Referencial, através de constraints e restrições de exclusão (ON DELETE CASCADE e ON DELETE RESTRICT)
- Valores default para colunas
+ Retorno da data de hoje
- Índices (Primário, secundário)
+ Views 
- Funções de agregação
+ Triggers:
  * AFTER [INSERT | DELETE | UPDATE]
  + FOR EACH ROW (*este recurso não existe no SQL Server a não ser que se use cursores*)
  * Para uma coluna específica (*equivaliente ao IF UPDATE(coluna) do SQL Server*)
  + Tabelas OLD e NEW (*equivalentes às referências a DELETED e INSERTED do SQL Server*)

  
Os recursos apresentados são apenas um pequeno subconjunto dos recursos suportados pelo
SQLite, e não era objetivo deste trabalho exaurir todo o potencial do SQLite3, mas sim 
dar aos colegas uma noção de suas capacidades, sobretudo quando comparado com o SQL Server. 

Uma lista maior das potencialidades será apresentada em sala de aula durante minha apresentação.
 
  
  


 
