package cl.uchile.dcc
package gwent.contoller.states

import gwent.controller.GameController

class FinishRoundStateTest extends munit.FunSuite {
  var c: GameController = _

  override def beforeEach(context: BeforeEach): Unit = {
    c = new GameController()
  }
  test("Si están empatados al final de la ronda ambos pierden una gema"){
    c.handleState()
    c.player2Turn()
    c.playCardsP1()
    c.finishRound()
    c.handleState()
    assertEquals(c.p1.get.getGems(), 1)
    assertEquals(c.p2.get.getGems(), 1)
    assert(c.isNextRound())
  }
  test("Si el player 2 tiene mas fuerza el player 1 pierde una gema"){
    c.handleState()
    c.player2Turn()
    c.handleState()
    c.handleState()
    c.playCardsP2()
    c.finishRound()
    c.handleState()
    assertEquals(c.p1.get.getGems(), 1)
    assertEquals(c.p2.get.getGems(), 2)
    assert(c.isNextRound())
  }
  test("Si un jugador se queda sin gemas termina el juego"){
    c.handleState()
    c.player2Turn()
    c.handleState()
    c.handleState()
    c.playCardsP2()
    c.finishRound()
    c.handleState()
    assertEquals(c.p1.get.getGems(), 1)
    assertEquals(c.p2.get.getGems(), 2)
    c.roundInit()
    c.player2Turn()
    c.handleState()
    c.handleState()
    c.playCardsP2()
    c.finishRound()
    c.handleState()
    assertEquals(c.p1.get.getGems(), 0)
    assertEquals(c.p2.get.getGems(), 2)
    assert(c.getIsFinish())
  }
}
