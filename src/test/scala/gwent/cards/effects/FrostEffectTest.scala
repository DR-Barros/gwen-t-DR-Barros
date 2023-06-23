package cl.uchile.dcc
package gwent.cards.effects

import gwent.board.Board

class FrostEffectTest extends munit.FunSuite {
  var board: Board = _
  var frost: FrostEffect = _

  override def beforeEach(context: BeforeEach): Unit = {
    board = new Board()
    frost = new FrostEffect()
  }

  test("Un efecto de escarcha se llama: Escarcha mordiente") {
    assertEquals(frost.getName(), "Escarcha mordiente")
  }
}
