package cl.uchile.dcc
package gwent.factories
import gwent.cards.effects.{BondEffect, MoralEffect, NullEffect, UnitEffect}

/** Clase abstracta Fabrica de cartas de unidad
 * 
 * Esta clase implementa el trait de fabricas de cartas y el metodo de este que aplica los efectos de unidad a las cartas
 *
 * @author Daniel Radrigan
 * @since 1.0.0
 * @version 1.0.0
 */
abstract class AbstractUnitCardFactory extends CardFactory {
  /** crea efectos para las cartas
   * 
   * Recibe un parametro entero y segun este crea el efecto indicado
   * 
   * @param n entero segun el cual se elige un efecto
   * @return devuelve un efecto de unidad
   */
  protected def effect(n: Int): UnitEffect = {
    n match
      case 1 => return new BondEffect
      case 2 => return new MoralEffect
      case _ => return  new NullEffect
  }
}
