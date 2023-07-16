package cl.uchile.dcc
package gwent.factories

import gwent.cards.effects.{ClearEffect, FogEffect, FrostEffect, RainEffect, UnitEffect, WeatherEffect}

abstract class AbstractWeatherCardFactory extends CardFactory {
  protected def effect(n: Int): WeatherEffect = {
    n match
      case 1 => return new FogEffect
      case 2 => return new FrostEffect
      case 3 => return new RainEffect
      case _ => return new ClearEffect
  }
}
