@tag
Feature: Comprar produto
  Como consumidor
  Quero adicionar um produto ao carrinho
  Para fazer a compra do produto escolhido

  Background: Usuário na tela de compras
    Given Que estou na página Shop

  @automatizado
  Scenario: Comprar sem ter produto no carrinho
    When Clico no botão que leva ao carrinho
    And Clico no botão que confirma os itens do carrinho
    Then Não devo ir para a página que finaliza a compra