package cl.uchile.dcc
package gwent.contoller.states

import gwent.controller.GameController

import cl.uchile.dcc.gwent.cards.UnitCard

import scala.collection.mutable.ArrayBuffer

class NextRoundStateTest extends munit.FunSuite {
  var c: GameController = _

  override def beforeEach(context: BeforeEach): Unit = {
    c = new GameController()
  }

  test("") {
    c.handleState()
    c.player2Turn()
    c.handleState()
    c.handleState()
    c.playCardsP2()
    c.finishRound()
    c.handleState()
    assert(c.isNextRound())
    c.handleState()
    assertEquals(c.p1.get.handSize(), 10)
    assertEquals(c.p2.get.handSize(), 10)
    assertEquals(c.board.get.getSecW()(0), null)
    assertEquals(c.board.get.getSec1S(), new ArrayBuffer[UnitCard](0))
    assertEquals(c.board.get.getSec1D(), new ArrayBuffer[UnitCard](0))
    assertEquals(c.board.get.getSec1C(), new ArrayBuffer[UnitCard](0))
    assertEquals(c.board.get.getSec2S(), new ArrayBuffer[UnitCard](0))
    assertEquals(c.board.get.getSec2D(), new ArrayBuffer[UnitCard](0))
    assertEquals(c.board.get.getSec2C(), new ArrayBuffer[UnitCard](0))
  }
}
