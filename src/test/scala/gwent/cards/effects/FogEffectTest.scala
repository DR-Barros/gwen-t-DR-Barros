package cl.uchile.dcc
package gwent.cards.effects

import gwent.board.Board

class FogEffectTest extends munit.FunSuite {
  var board: Board = _
  var fog: FogEffect = _

  override def beforeEach(context: BeforeEach): Unit = {
    board = new Board()
    fog = new FogEffect()
  }

  test("Un efecto de niebla se llama: Niebla impenetrable") {
    assertEquals(fog.getName(), "Niebla impenetrable")
  }
}
