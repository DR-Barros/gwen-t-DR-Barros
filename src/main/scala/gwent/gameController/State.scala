package cl.uchile.dcc
package gwent.gameController

trait State {
  def handle(game: GameController): Unit
}
