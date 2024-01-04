package cl.uchile.dcc
package gwent.cards.states

/** Estado Fog
 *
 * @author Daniel Radrigán
 * @since 1.0.0
 * @version 1.0.0 
 */
class FogState extends AbstractCardState {
  /**sobrescribe fog para que no haga nada */
  override def fog(): Unit = {}

  /**Dice que el estado es Fog */
  override def isFog(): Boolean = true
}
