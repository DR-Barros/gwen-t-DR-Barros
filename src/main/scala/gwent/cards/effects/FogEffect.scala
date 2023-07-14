package cl.uchile.dcc
package gwent.cards.effects
import gwent.board.Board

/** Efecto de Niebla Impenetrable */
class FogEffect extends WeatherEffect {
  /** entrega el nombre del efecto */
  def getName(): String = "Niebla impenetrable"

  /** aplica el efecto fog en el tablero
   *
   * @param board tablero de juego
   */
  def apply(board: Board): Unit = {
    board.fog()
  }
}
