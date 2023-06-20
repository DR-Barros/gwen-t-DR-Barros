package cl.uchile.dcc
package gwent.cards.effects
import gwent.board.{Board, BoardSection}

class FrostEffect extends Effect {
  def getName(): String = "Escarcha mordiente"

  def apply(board: Board, boardSection: BoardSection): Unit = {
    board.frost()
  }
}
