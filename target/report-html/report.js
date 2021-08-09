$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("classpath:features/searchTest.feature");
formatter.feature({
  "name": "Login",
  "description": "",
  "keyword": "Funcionalidade",
  "tags": [
    {
      "name": "@webMotors"
    }
  ]
});
formatter.scenario({
  "name": "Validar acesso ao sistema quando pular o login",
  "description": "",
  "keyword": "Cenário",
  "tags": [
    {
      "name": "@webMotors"
    },
    {
      "name": "@ct01"
    }
  ]
});
formatter.step({
  "name": "que o usuário esteja no sistema do webmotors",
  "keyword": "Dado "
});
formatter.match({
  "location": "steps.searchSteps.setup()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "clicar na opção Pular login",
  "keyword": "Quando "
});
formatter.match({
  "location": "steps.searchSteps.optionLogin()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "o sistema direciona o usuário para a tela de home",
  "keyword": "Então "
});
formatter.match({
  "location": "steps.searchSteps.screenHome()"
});
formatter.result({
  "status": "passed"
});
});