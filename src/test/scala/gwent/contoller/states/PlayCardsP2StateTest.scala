package cl.uchile.dcc
package gwent.contoller.states

import gwent.controller.GameController

import cl.uchile.dcc.gwent.board.Board
import cl.uchile.dcc.gwent.cards.effects.NullEffect
import cl.uchile.dcc.gwent.cards.{Card, CorpCard}
import cl.uchile.dcc.gwent.cards.structures.Deck
import cl.uchile.dcc.gwent.players.UserPlayer

class PlayCardsP2StateTest extends munit.FunSuite {
  var c: GameController = _

  override def beforeEach(context: BeforeEach): Unit = {
    c = new GameController()
  }
  test("Si el player 2 tiene mas fuerza juega una carta de unidad si tiene"){
    val corp = new CorpCard("corp", 9, new NullEffect)
    c.p2 = Some(new UserPlayer("P2", new Deck(Array[Card](corp))))
    c.p2.get.stealCard()
    c.board = Some(new Board)
    c.roundInit()
    c.player1Turn()
    c.playCardsP2()
    c.handleState()
    assertEquals(c.board.get.getSec2C()(0), corp)
  }
  test("Si el player 2 tiene mas fuerza juega una carta de unidad si tiene") {
    c.p2 = Some(new UserPlayer("P2", new Deck(new Array[Card](0))))
    c.board = Some(new Board)
    c.roundInit()
    c.player1Turn()
    c.playCardsP2()
    c.handleState()
    assert(c.isFinishRound())
  }
}
