package cl.uchile.dcc
package gwent.cards.effects
import gwent.board.{Board, BoardSection}

class RainEffect extends Effect {
  def getName(): String = "Lluvia torrencial"

  def apply(board: Board, boardSection: BoardSection): Unit = {
    board.rain()
  }
}
