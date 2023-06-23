package cl.uchile.dcc
package gwent.cards.effects

import gwent.board.Board

class ClearEffectTest extends munit.FunSuite {
  var board: Board = _
  var clear: ClearEffect = _

  override def beforeEach(context: BeforeEach): Unit = {
    board = new Board()
    clear = new ClearEffect()
  }

  test("Un efecto de despejado se llama: Clima despejado") {
    assertEquals(clear.getName(), "Clima despejado")
  }
}
