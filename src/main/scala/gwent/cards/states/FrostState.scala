package cl.uchile.dcc
package gwent.cards.states

/** Estado Frost
 *
 * @author Daniel Radrigán
 * @since 1.0.0
 * @version 1.0.0
 */
class FrostState extends AbstractCardState {
  /**sobrescribe frost para que no haga nada */
  override def frost(): Unit = {}

  /**Dice que el estado es Frost */
  override def isFrost(): Boolean = true
}
