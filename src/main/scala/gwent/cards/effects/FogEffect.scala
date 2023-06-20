package cl.uchile.dcc
package gwent.cards.effects
import gwent.board.{Board, BoardSection}

class FogEffect extends WeatherEffect {
  def getName(): String = "Niebla impenetrable"

  def apply(board: Board): Unit = {
    board.fog()
  }
}
