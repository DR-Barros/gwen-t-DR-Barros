package cl.uchile.dcc
package gwent.contoller.states

import gwent.controller.GameController

class StartStateTest extends munit.FunSuite {
  var c: GameController = _

  override def beforeEach(context: BeforeEach): Unit = {
    c = new GameController()
  }
  test("Al Hacer handle en el estado Start se inicializan los jugadores, el tablero"){
    assert(c.isStart())
    c.handleState()
    assert(c.p1.isDefined)
    assert(c.p2.isDefined)
    assert(c.board.isDefined)
    assert(c.isRoundInit())
  }
}
