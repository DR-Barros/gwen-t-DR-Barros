package cl.uchile.dcc
package gwent.contoller.states

import gwent.controller.GameController

class RoundInitStateTest extends munit.FunSuite {
  var c: GameController = _

  override def beforeEach(context: BeforeEach): Unit = {
    c = new GameController()
  }
  test("Al Hacer handle en el estado RoundInit se decide si parte jugando P1 o P2"){
    c.roundInit()
    assert(c.isRoundInit())
    c.handleState()
    assert(c.isPlayer1Turn() || c.isPlayer2Turn())
  }
}
