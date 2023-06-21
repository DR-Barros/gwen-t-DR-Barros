package cl.uchile.dcc
package gwent.cards.effects

import gwent.board.Board

class MoralEffectTest extends munit.FunSuite {
  var board: Board = _
  var bond: MoralEffect = _

  override def beforeEach(context: BeforeEach): Unit = {
    board = new Board()
    bond = new MoralEffect()
  }

  test("Un efecto de Moral se llama: Refuerzo moral") {
    assertEquals(bond.getName(), "Refuerzo moral")
  }
}
