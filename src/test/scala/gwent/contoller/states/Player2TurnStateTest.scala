package cl.uchile.dcc
package gwent.contoller.states

import gwent.controller.GameController

import cl.uchile.dcc.gwent.board.Board
import cl.uchile.dcc.gwent.cards.effects.NullEffect
import cl.uchile.dcc.gwent.cards.{Card, CorpCard}
import cl.uchile.dcc.gwent.cards.structures.Deck
import cl.uchile.dcc.gwent.players.UserPlayer

class Player2TurnStateTest extends munit.FunSuite {
  var c: GameController = _

  override def beforeEach(context: BeforeEach): Unit = {
    c = new GameController()
  }
  test("Si el player 2 no tiene las cartas para jugar para dado caso entonces salta su turno"){
    c.p2 = Some(new UserPlayer("Player", new Deck(new Array[Card](0))))
    c.board = Some(new Board)
    c.roundInit()
    c.player2Turn()
    c.handleState()
    assert(c.isPlayCardsP1())
  }
  test("Si el player 2 tiene las cartas para jugar para dado caso entonces pasa a jugar carta") {
    c.p2 = Some(new UserPlayer("Player", new Deck(Array[Card](new CorpCard("card", 20, new NullEffect),new CorpCard("card", 20, new NullEffect)))))
    c.p2.get.stealCard()
    c.board = Some(new Board)
    c.roundInit()
    c.player2Turn()
    c.handleState()
    assert(c.isPlayCardP2())
  }
}
