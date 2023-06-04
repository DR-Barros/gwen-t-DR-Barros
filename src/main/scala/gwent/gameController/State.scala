package cl.uchile.dcc
package gwent.gameController

trait State {
  def setController(controller: Controller): Unit
}
