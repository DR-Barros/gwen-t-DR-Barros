package cl.uchile.dcc
package gwent.board.states
import gwent.board.Board

/** Clase Abstracta para los estados de el tablero
 *
 * @author Daniel Radrigán
 * @since 1.0.0
 * @version 1.0.0
 */
abstract class AbstractBoardState extends BoardState {
  /** El Tablero del cual este estado pertenece */
  private var b: Option[Board] = None

  /** Asigna el tablero al estado
   *
   * @param board el tablero
   */
  def setBoard(board: Board): Unit = {
    b = Some(board)
  }

  /**Cambia el esatdo del tablero
   *
   * @param state estado al cual se va a cambiar
   */
  protected def changeState(state: BoardState): Unit = {
    if(b.isDefined){
      b.get.setState(state)
    }
  }

  /**Cambia el estado a Clear */
  def clear(): Unit = changeState(new ClearState())

  /**Cambia el estado a Fog */
  def fog(): Unit = changeState(new FogState())

  /**Cambia el estado a Frost */
  def frost(): Unit = changeState(new FrostState())

  /**Cambia el estado a Rain */
  def rain(): Unit = changeState(new RainState())

  /**Dice si el estado es Clear */
  def isClear(): Boolean = false

  /**Dice si el estado es Fog */
  def isFog(): Boolean = false

  /**Dice si el estado es Frost */
  def isFrost(): Boolean = false

  /**Dice si el estado es Rain */
  def isRain(): Boolean = false
}
