# Projeto Cartão de Crédito FIAP - Transação

## Pré-requisitos para execução da aplicação de alunos

- Tecnologias necessárias.

  1- Para executar o projeto é necessário ter o JRE 8 ou JDK 8 instalado.
  
  2- Utilizar uma IDE para execução. (Eclipse é recomendado)
  
 ---

## Instalação e execução do projeto

`$ git clone https://github.com/camisbressan/fiap-cartao-transacao.git`

Após executar a aplicação de Alunos, no diretório `src` no pacote `br.com.fiap.cartao.transacao` existe um arquivo chamado `TransacaoApplication.java`. Abra esse arquivo e execute Run.

A carga de dados de transação inicial será feita através do arquivo `/src/main/resources/data.sql` e pode ser validada pela API de listagem de transação (http://localhost:8081/transacao) via Swagger e via Postman. 

Como teremos uma integração com outras empresas para lançamento das compras realizadas pelos alunos, todas as rotas obrigarão a utilização de um token para validação do acesso.

Segue abaixo exemplo de acesso as rotas no Postman.

Passo 1 - Gerar token de validação (http://localhost:8081/authenticate), simulando o acesso de uma empresa parceira:

{
  "senha": "password",
  "usuario": "fiapcartaotransacao"
}

![Postman_Autorizacao](docs/img/POSTMAN_AUTH.jpeg)

Passo 2 - Listar transações (http://localhost:8081/transacao) utilizando o token gerado:

IMAGEM 2

## Execução do extrato de transações por aluno

Para consultar todas as transações (compras) realizadas por um aluno específico, utilizar a rota (http://localhost:8081/extrato/aluno/1) que irá gerar um arquivo PDF, conforme exemplo abaixo:

Obs.: a aplicação de Alunos deve estar em execução e é necessário gerar o token de autenticação antes de chamar a API.

IMAGEM 3

Após o retorno da API clicar em ‘Save Response’ e ‘Save to a file’, selecionar a pasta e salvar o arquivo gerado ‘extratotransacoesporaluno.pdf’:

IMAGEM 4

Exemplo de extrato gerado em PDF:

IMAGEM 5

## Demais rotas para gestão das transações

A aplicação permite a criação e exclusão de uma transação, além das rotas de listar todas as transações, buscar uma transação específica e consultar todas as transações de um aluno.

http://localhost:8081/swagger-ui.html

IMAGEM 6
