package cl.uchile.dcc
package gwent.cards.effects
import gwent.board.{Board, BoardSection}

class FogEffect extends Effect {
  def getName(): String = "Niebla impenetrable"

  def apply(board: Board, boardSection: BoardSection): Unit = {
    board.fog()
  }
}
