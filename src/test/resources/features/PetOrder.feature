@Order
Feature: Escenario GET y POST

  Scenario Outline: Post Orden
    Given la url es "https://petstore.swagger.io/v2"
    When cuando creo la orden "<IdOrder>" de la mascota "<IdPet>"
    Then valido que la respuesta sea 200
    Examples:
      | IdOrder | IdPet |
      | 5       | 2     |

  Scenario Outline: Get Orden
    Given la url es "https://petstore.swagger.io/v2"
    When cuando consulta la orden "<IdOrder>"
    Then valido que la respuesta sea 200
    Examples:
      | IdOrder |  |
      | 5       |  |