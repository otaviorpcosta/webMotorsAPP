#language: pt

@webMotors
Funcionalidade: Login

  @ct01
  Cenário: Validar acesso ao sistema quando pular o login
    Dado que o usuário esteja no sistema do webmotors
    Quando clicar na opção Pular login
    Então o sistema direciona o usuário para a tela de home

  @ct02
  Cenário: Validar funcionalidade da opção do menu Buscar
    Dado que o usuário esteja no sistema do webmotors
    Quando clicar na opção Pular login
    E clicar no menu Buscar
    Então o sistema direciona o usuário para a tela filtros

  @ct03
  Cenário: Validar busca de carro desejado
    Dado que o usuário esteja no sistema do webmotors
    Quando clicar na opção Pular login
    E clicar no menu Buscar
    E selecionar a Marca desejada
    E clicar na opção Ver anúncios
    Então o sistema direciona o usuário para a tela de listagem de veículos

  @ct04
  Cenário: Validar seleção do veículo desejado
    Dado que o usuário esteja no sistema do webmotors
    Quando clicar na opção Pular login
    E clicar no menu Buscar
    E selecionar a Marca desejada
    E clicar na opção Ver anúncios
    E clicar no veículo desejado
    Então o sistema direciona o usuário para a tela de detalhes do veículo

  @ct05
  Cenário: Validar o contato para negociação com os vendedores
    Dado que o usuário esteja no sistema do webmotors
    Quando clicar na opção Pular login
    E clicar no menu Buscar
    E selecionar a Marca desejada
    E clicar na opção Ver anúncios
    E clicar no veículo desejado
    E clicar na opção de Enviar mensagem para o vendedor
    E preencher o formulário com dados válidos
    E clicar na opção de Enviar
    Então o sistema exibe mensagem informando que a proposta foi enviada