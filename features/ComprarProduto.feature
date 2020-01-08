@tag
Feature: Comprar produto
  Como consumidor
  Quero adicionar um produto ao carrinho
  Para fazer a compra do produto escolhido

  Background: Usuário na tela de compras
    Given Que estou na página Shop

  @automatizado
  Scenario Outline: Efetuar a compra de um produto
    When Adiciono um <Produto> ao carrinho
    And Clico no botão que leva ao carrinho
    And Clico no botão que confirma os itens do carrinho
    And Insiro o local de entrega como sendo <Local>
    And Concordo com os termos
    And Clico para efetuar a compra
    Then Devo visualizar uma mensagem de sucesso

    Examples: 
      | Produto  |	Local		|
      | iphone X |	Brasil	|