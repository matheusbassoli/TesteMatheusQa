#language: pt
#Author: Matheus Albertini Bassoli
@TesteQA
Funcionalidade: Criar um e-mail Gmail.

  @Firefox
  Esquema do Cenario: Teste
    Dado o usuario acessa a url <vUrl>
    Quando o usuario acessar a primeira tela de acesso o mesmo clicara no item criar conta
    E digitar na tela Criar sua Conta do Google o nome <vNome>
    E digitar na tela Criar sua Conta do Google o Sobrenome <vSobreNome>
    E digitar na tela Criar sua Conta do Google o item nome de usuario <vNomeUsuario>
    E digitar na tela Criar sua Conta do Google a senha <vSenha>
    E digitar na tela Criar sua Conta do Google confirmar senha <vConfirmarSenha>
    E na tela Criar sua Conta do Google clicar em proximo
    E digitar na tela bem vindo ao google o numero de telefone <vTelefone>
    E digitar na tela bem vindo ao google o endereco de email de recuperacao <vEmailRecu>
    E digitar na tela bem vindo ao google o dia de nascimento <vDia>
    E selecionar na tela bem vindo ao google o mes de nascimento <vMes>
    E digitar na tela bem vindo ao google o ano de nascimento <vAno>
    E selecionar na tela bem vindo ao google o genero <vGenero>
    E na tela bem vindo ao google clicar em proximo
    E na tela verifique seu numero de telefone clicar no item agora nao
    E clicar na tela Privacidade e Termos no item proximo
    E clicar na tela Privacidade e Termos no item proximo2
    E clicar na tela Privacidade e Termos no item proximo3
    E clicar na tela Privacidade e Termos no item concordo
    E clicar na tela inicial no item proximo
    E clicar na tela inicial no item ok

    Cenarios: 
      | vUrl                 | vNome        | vSobreNome | vNomeUsuario   | vSenha        | vConfirmarSenha | vTelefone  | vEmailRecu      | vDia | vMes     | vAno | vGenero   |
      | http://www.gmail.com | testeemail   | teste      | testeqaemail01 | 11teste198911 | 11teste198911   | 1141275746 | teste@teste.com |   01 | Abril    | 1950 | Masculino |
      | http://www.gmail.com | testeqaemail | teste      | testeqaemail02 | 11teste198911 | 11teste198911   | 1141275746 | teste@teste.com |   11 | Janeiro  | 1960 | Feminino  |
      | http://www.gmail.com | testeemailqa | teste      | testeqaemail03 | 11teste198911 | 11teste198911   | 1141275746 | teste@teste.com |   21 | Outubro  | 1970 | Masculino |
      | http://www.gmail.com | qatestemail  | teste      | testeqaemail04 | 11teste198911 | 11teste198911   | 1141275746 | teste@teste.com |   12 | Dezembro | 1980 | Feminino  |
      | http://www.gmail.com | testemail    | teste      | testeqaemail05 | 11teste198911 | 11teste198911   | 1141275746 | teste@teste.com |   05 | Maio     | 1990 | Masculino |
      | http://www.gmail.com | testqa       | teste      | testeqaemail06 | 11teste198911 | 11teste198911   | 1141275746 | teste@teste.com |   04 | Junho    | 1954 | Feminino  |
