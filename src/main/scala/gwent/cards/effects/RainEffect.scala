package cl.uchile.dcc
package gwent.cards.effects
import gwent.board.{Board, BoardSection}

class RainEffect extends WeatherEffect {
  def getName(): String = "Lluvia torrencial"

  def apply(board: Board): Unit = {
    board.rain()
  }
}
