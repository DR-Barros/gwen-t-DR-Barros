package cl.uchile.dcc
package gwent.cards.effects

import gwent.board.Board

import cl.uchile.dcc.gwent.cards.{Deck, DistanceCard, UnitCard}
import cl.uchile.dcc.gwent.players.UserPlayer

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
  test("Al aplicar apply el tablero le manda a sus cartas la notificacion de niebla") {
    val card: UnitCard = new DistanceCard("nombre", 14, new NullEffect)
    val player = new UserPlayer("P1", new Deck(Array(card)))
    player.stealCard()
    board.playCardSec1(player, 1)
    fog.apply(board)
    assert(card.isFog())
  }
}
