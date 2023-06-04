package cl.uchile.dcc
package gwent.gameController

trait Controller {
  def setState(aState: State): Unit
}
