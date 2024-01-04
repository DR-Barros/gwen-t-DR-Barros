package cl.uchile.dcc
package gwent.cards.states

/** Estado Rain
 *
 * @author Daniel Radrigán
 * @since 1.0.0
 * @version 1.0.0
 */
class RainState extends  AbstractCardState {
  /**sobrescribe rain para que no haga nada */
  override def rain(): Unit = {}

  /**Dice que el estado es rain */
  override def isRain(): Boolean = true
}
