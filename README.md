# Biblioteca ADS Desenvolvimento Desktop - Professor Silvio

## Trabalho do curso da 3ª Fase de ADS - Análise e Desenvolvimeno de Sistema - Faculdade Senac Palhoça

## Alunos:

[Felipe Araujo de Souza](https://github.com/arandel25/)

[Felipe Stahlhofer](https://github.com/felipeStahl/)

[Marcelo do Nascimento](https://github.com/pac57282)

[Titione Falacio de Amorim](https://github.com/titioneamorim/)

## Descrição do Projeto

Empréstimo biblioteca - Ranking por turma

* Emprestar livros da biblioteca com ranking de melhor leitor e melhor turma.

* A biblioteca XYZ está precisando de um software que gerencie seus empréstimos.

* O sistema precisa ter gerenciamento de livro para consulta (Autor, nome do livro), se está emprestado ou se existe na biblioteca.

* O sistema só empresta para alunos da faculdade. 

* O sistema deverá mostrar ranking de empréstimo por aluno no mês que preferir pesquisar.

* O sistema deverá mostrar ranking de empréstimo por turma também por mês. 

* O sistema deverá mostrar pesquisar por aluno onde mostre, nome do curso, fase, ano, número da matricula e quantos livros tem emprestado pelo mês da pesquisa. 

* O sistema deverá mostrar depois de logado, quantos livros estão atrasados.

* Somente o bibliotecário faz os empréstimos. 

* O coordenador do curso pode pesquisar os rankings de turmas e de alunos.

* Para cadastrar e gerenciar bibliotecários no sistema o usuário deverá ter permissão de administrador.


## Como executar o projeto

1) Rodar o arquivo br.com.util.GeradorTabela.java para gerar a tabela no Banco de Dados MySQL.
2) Executar o projeto a primeira vez, onde será gerado o usuário Admin com senha admin, e poderá acessar o sistema e cadastrar os colaboradores e alunos.
3) É recomendável popular os perfis (administrador, coordenador, bibliotecario, aluno), para poder realizar o login com os devidos Login's e após criar os cursos e turmas, conforme necessário.
4) Caso queira realizar apenas testes, poderá executar os testes que estão em Test Packages, onde irá popular a tabela com o nome de biblioteca no banco de dados MySQL.

## Descrição Perfil
* O perfil Administrador, é responsável em criar os usuários, cadastrar turmas e cursos.
* O perfil Coordenador, pode visualizar os empréstimos ativos, pesquisar por livros e verificar quais estão emprestados/disponíveis e ver os ranking's disponíveis.
* O perfil Bibliotecário é responsável por registrar o empréstimo/devolução dos livros, cadastrar/alterar/excluir livros e exemplares e visualizar os ranking's disponíveis.
* O perfil Aluno, pode verificar seus empréstimos ativos e pesquisar o acervo dos livros.
