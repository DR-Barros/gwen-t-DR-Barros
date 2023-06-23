package cl.uchile.dcc
package gwent.cards.states
import gwent.cards.UnitCard

/** Clase Abstracta para los estados de las Cartas
 *
 * @author Daniel Radrigán
 * @since 1.0.0
 * @version 1.0.0
 */
abstract class AbstractCardState extends  CardState {
  /** La carta a la cual este estado pertenece */
  private var b: Option[UnitCard] = None

  /** Asigna la carta al estado
   *
   * @param card la Carta a asignar
   */
  def setCard(card: UnitCard): Unit = {
    b = Some(card)
  }

  /** Cambia el estado de la carta
   *
   * @param state estado al cual se va a cambiar
   */
  protected def changeState(state: CardState): Unit = {
    if (b.isDefined) {
      b.get.setState(state)
    }
  }

  /** Cambia el estado a Clear */
  def clear(): Unit = changeState(new ClearState())

  /** Cambia el estado a Fog */
  def fog(): Unit = changeState(new FogState())

  /** Cambia el estado a Frost */
  def frost(): Unit = changeState(new FrostState())

  /** Cambia el estado a Rain */
  def rain(): Unit = changeState(new RainState())

  /** Dice si el estado es Clear */
  def isClear(): Boolean = false

  /** Dice si el estado es Fog */
  def isFog(): Boolean = false

  /** Dice si el estado es Frost */
  def isFrost(): Boolean = false

  /** Dice si el estado es Rain */
  def isRain(): Boolean = false
}
