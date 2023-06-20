package cl.uchile.dcc
package gwent.cards.effects
import gwent.board.{Board, BoardSection}

class FrostEffect extends WeatherEffect {
  def getName(): String = "Escarcha mordiente"

  def apply(board: Board): Unit = {
    board.frost()
  }
}
