package cl.uchile.dcc
package gwent.cards.effects
import gwent.board.Board

/** Efecto de Escarcha mordiente */
class FrostEffect extends WeatherEffect {
  /** entrega el nombre del efecto */
  def getName(): String = "Escarcha mordiente"

  /** aplica el efecto frost en el tablero
   *
   * @param board tablero de juego
   */
  def apply(board: Board): Unit = {
    board.frost()
  }
}
