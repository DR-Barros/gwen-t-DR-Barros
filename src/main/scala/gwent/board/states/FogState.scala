package cl.uchile.dcc
package gwent.board.states

/** Clase Fog
 *
 * @author Daniel Radrigán
 * @since 1.0.0
 * @version 1.0.0 
 */
class FogState extends AbstractBoardState {
  /**sobrescribe fog para que no haga nada */
  override def fog(): Unit = {}

  /**Dice que el estado es Fog */
  override def isFog(): Boolean = true
}
