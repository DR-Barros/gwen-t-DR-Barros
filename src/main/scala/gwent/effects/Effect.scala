package cl.uchile.dcc
package gwent.effects

import gwent.board.{Board, BoardSection}

trait Effect {
  def getName(): String
  def apply(board: Board, boardSection: BoardSection): Unit
}
