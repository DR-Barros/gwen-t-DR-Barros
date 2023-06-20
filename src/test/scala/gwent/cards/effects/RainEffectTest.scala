package cl.uchile.dcc
package gwent.cards.effects

import gwent.board.Board

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
  test("al hacer apply al RainEffect el tablero cambia de estado a lluvioso"){
    rain.apply(board)
    assert(board.isRain())
  }
}
