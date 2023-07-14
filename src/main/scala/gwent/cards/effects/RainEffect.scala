package cl.uchile.dcc
package gwent.cards.effects
import gwent.board.{Board, BoardSection}

/** Efecto de Lluvia Torrencial */
class RainEffect extends WeatherEffect {
  /** entrega el nombre del efecto */
  def getName(): String = "Lluvia torrencial"

  /** aplica el efecto rain en el tablero
   *
   * @param board tablero de juego
   */
  def apply(board: Board): Unit = {
    board.rain()
  }
}
