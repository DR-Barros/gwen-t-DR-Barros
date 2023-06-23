package cl.uchile.dcc
package gwent.cards.effects
import gwent.board.{Board, BoardSection}

class ClearEffect extends WeatherEffect {
  def getName(): String = "Clima despejado"

  def apply(board: Board): Unit = {
    board. clear()
  }
}
