package cl.uchile.dcc
package gwent.factories
import gwent.cards.effects.{BondEffect, MoralEffect, NullEffect, UnitEffect}

abstract class AbstractUnitCardFactory extends CardFactory {
  protected def effect(n: Int): UnitEffect = {
    n match
      case 1 => return new BondEffect
      case 2 => return new MoralEffect
      case _ => return  new NullEffect
  }
}
