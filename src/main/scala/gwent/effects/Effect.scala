package cl.uchile.dcc
package gwent.effects

trait Effect {
  def getName(): String
  def apply(): Unit
}
