package cl.uchile.dcc
package gwent.contoller.states

import gwent.controller.GameController

import cl.uchile.dcc.gwent.board.Board
import cl.uchile.dcc.gwent.cards.effects.NullEffect
import cl.uchile.dcc.gwent.cards.{Card, CorpCard}
import cl.uchile.dcc.gwent.cards.structures.Deck
import cl.uchile.dcc.gwent.players.UserPlayer

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
  test("Si el player 1 tiene mas fuerza el player 2 pierde una gema") {
    c.p2 = Some(new UserPlayer("Player", new Deck(new Array[Card](0))))
    c.p1 = Some(new UserPlayer("Player", new Deck(Array[Card](new CorpCard("card", 20, new NullEffect), new CorpCard("card", 20, new NullEffect)))))
    c.p1.get.stealCard()
    c.board = Some(new Board)
    c.roundInit()
    c.player2Turn()
    c.playCardsP1()
    c.board.get.playCardSec1(c.p1.get, 1)
    c.finishRound()
    c.handleState()
    assertEquals(c.p1.get.getGems(), 2)
    assertEquals(c.p2.get.getGems(), 1)
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
