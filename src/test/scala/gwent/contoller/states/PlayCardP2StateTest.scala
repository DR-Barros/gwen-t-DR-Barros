package cl.uchile.dcc
package gwent.contoller.states

import gwent.controller.GameController

import cl.uchile.dcc.gwent.board.Board
import cl.uchile.dcc.gwent.cards.{Card, CorpCard, WeatherCard}
import cl.uchile.dcc.gwent.cards.effects.{ClearEffect, NullEffect}
import cl.uchile.dcc.gwent.cards.structures.Deck
import cl.uchile.dcc.gwent.players.UserPlayer

class PlayCardP2StateTest extends munit.FunSuite {
  var c: GameController = _

  override def beforeEach(context: BeforeEach): Unit = {
    c = new GameController()
  }
  test("Si el player 2 tiene mas fuerza juega una carta de unidad"){
    val corp = new CorpCard("corp", 9, new NullEffect)
    c.p2 = Some(new UserPlayer("P2", new Deck(Array[Card](corp))))
    c.p2.get.stealCard()
    c.board = Some(new Board)
    c.roundInit()
    c.player2Turn()
    c.handleState()
    c.handleState()
    assertEquals(c.board.get.getSec2C()(0), corp)
    assert(c.isPlayer1Turn())
  }
  test("Si el player 2 tiene menos fuerza juega una carta de clima") {
    val clima = new WeatherCard("clima", new ClearEffect)
    val corp = new CorpCard("corp", 9, new NullEffect)
    c.p1 = Some(new UserPlayer("P2", new Deck(Array[Card](corp))))
    c.p2 = Some(new UserPlayer("P2", new Deck(Array[Card](clima))))
    c.p1.get.stealCard()
    c.p2.get.stealCard()
    c.board = Some(new Board)
    c.roundInit()
    c.board.get.playCardSec1(c.p1.get, 1)
    c.player2Turn()
    c.handleState()
    c.handleState()
    assertEquals(c.board.get.getSecW()(0), clima)
    assert(c.isPlayer1Turn())
  }
}
