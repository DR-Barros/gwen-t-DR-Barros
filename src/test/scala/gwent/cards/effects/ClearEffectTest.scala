package cl.uchile.dcc
package gwent.cards.effects

import gwent.board.Board

import cl.uchile.dcc.gwent.cards.{Deck, SiegeCard, UnitCard}
import cl.uchile.dcc.gwent.players.UserPlayer

class ClearEffectTest extends munit.FunSuite {
  var board: Board = _
  var clear: ClearEffect = _

  override def beforeEach(context: BeforeEach): Unit = {
    board = new Board()
    clear = new ClearEffect()
  }

  test("Un efecto de despejado se llama: Clima despejado") {
    assertEquals(clear.getName(), "Clima despejado")
  }
  test("Al aplicar apply el tablero le manda a sus cartas la notificacion de clear") {
    val card: UnitCard = new SiegeCard("nombre", 14, new NullEffect)
    val player = new UserPlayer("P1", new Deck(Array(card)))
    player.stealCard()
    board.playCardSec1(player, 1)
    clear.apply(board)
    assert(card.isClear())
  }
}
