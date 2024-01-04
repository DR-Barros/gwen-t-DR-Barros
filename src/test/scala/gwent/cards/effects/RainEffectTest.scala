package cl.uchile.dcc
package gwent.cards.effects

import gwent.board.Board
import cl.uchile.dcc.gwent.cards.structures.Deck

import cl.uchile.dcc.gwent.cards.{SiegeCard, UnitCard}
import cl.uchile.dcc.gwent.players.UserPlayer

class RainEffectTest extends munit.FunSuite {
  var board: Board = _
  var rain: RainEffect = _

  override def beforeEach(context: BeforeEach): Unit = {
    board = new Board()
    rain = new RainEffect()
  }

  test("Un efecto de lluvia se llama: Lluvia torrencial"){
    assertEquals(rain.getName(), "Lluvia torrencial")
  }
  test("Al aplicar apply el tablero le manda a sus cartas la notificacion de rain"){
    val card: UnitCard = new SiegeCard("nombre", 14, new NullEffect)
    val player = new UserPlayer("P1", new Deck(Array(card)))
    player.stealCard()
    board.playCardSec1(player, 1)
    rain.apply(board)
    assert(card.isRain())
  }
}
