package cl.uchile.dcc
package gwent.cards.effects
import gwent.board.Board

trait WeatherEffect extends Effect {
  def apply(board: Board): Unit
}
