package cl.uchile.dcc
package gwent.cards.effects

import gwent.board.Board

import cl.uchile.dcc.gwent.cards.{CorpCard, Deck, UnitCard}
import cl.uchile.dcc.gwent.players.UserPlayer

class FrostEffectTest extends munit.FunSuite {
  var board: Board = _
  var frost: FrostEffect = _

  override def beforeEach(context: BeforeEach): Unit = {
    board = new Board()
    frost = new FrostEffect()
  }

  test("Un efecto de escarcha se llama: Escarcha mordiente") {
    assertEquals(frost.getName(), "Escarcha mordiente")
  }
  test("Al aplicar apply el tablero le manda a sus cartas la notificacion de frost") {
    val card: UnitCard = new CorpCard("nombre", 14, new NullEffect)
    val player = new UserPlayer("P1", new Deck(Array(card)))
    player.stealCard()
    board.playCardSec1(player, 1)
    frost.apply(board)
    assert(card.isFrost())
  }
}
