package cl.uchile.dcc
package gwent.cards.effects

import gwent.board.Board

class NullEffectTest extends munit.FunSuite {
  var board: Board = _
  var nulo: NullEffect = _

  override def beforeEach(context: BeforeEach): Unit = {
    board = new Board()
    nulo = new NullEffect()
  }

  test("Un efecto nulo no tiene nombre") {
    assertEquals(nulo.getName(), "Sin efecto")
  }
}
