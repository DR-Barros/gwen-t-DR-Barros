package cl.uchile.dcc
package gwent.cards.effects

import gwent.board.Board

class BondEffectTest extends munit.FunSuite {
  var board: Board = _
  var bond: BondEffect = _

  override def beforeEach(context: BeforeEach): Unit = {
    board = new Board()
    bond = new BondEffect()
  }

  test("Un efecto de vinculo se llama: Vínculo estrecho") {
    assertEquals(bond.getName(), "Vínculo estrecho")
  }

}
