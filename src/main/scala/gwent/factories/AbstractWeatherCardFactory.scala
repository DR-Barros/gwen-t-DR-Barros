package cl.uchile.dcc
package gwent.factories

import gwent.cards.effects.{ClearEffect, FogEffect, FrostEffect, RainEffect, UnitEffect, WeatherEffect}

/** Clase abstracta Fabrica de cartas de clima
 *
 * Esta clase implementa el trait de fabricas de cartas y el método de este que aplica los efectos de clima a las cartas
 *
 * @author Daniel Radrigan
 * @since 1.0.0
 * @version 1.0.0
 */
abstract class AbstractWeatherCardFactory extends CardFactory {
  /** crea efectos para las cartas
   *
   * Recibe un parametro entero y según este crea el efecto indicado
   *
   * @param n entero según el cual se elige un efecto
   * @return devuelve un efecto de clima
   */
  protected def effect(n: Int): WeatherEffect = {
    n match
      case 1 => return new FogEffect
      case 2 => return new FrostEffect
      case 3 => return new RainEffect
      case _ => return new ClearEffect
  }
}
