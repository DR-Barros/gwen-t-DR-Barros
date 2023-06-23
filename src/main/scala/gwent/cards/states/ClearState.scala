package cl.uchile.dcc
package gwent.cards.states

/** Estado Clear
 *
 * @author Daniel Radrigán
 * @since 1.0.0
 * @version 1.0.0 
 */
class ClearState extends AbstractCardState {
  /** sobrescribe clear para que no haga nada */
  override def clear(): Unit = {}

  /** Dice que el estado es Clear */
  override def isClear(): Boolean = true
}
