package cl.uchile.dcc
package gwent.cards.effects
import gwent.board.Board

/** Efecto de Clima despejado */
class ClearEffect extends WeatherEffect {
  /** entrega el nombre del efecto */
  def getName(): String = "Clima despejado"

  /** aplica el efecto clear en el tablero
   * 
   * @param board tablero de juego
   */
  def apply(board: Board): Unit = {
    board.clear()
  }
}
