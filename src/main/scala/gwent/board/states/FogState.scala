package cl.uchile.dcc
package gwent.board.states

class FogState extends AbstractBoardState {
  override def fog(): Unit = {}

  override def isFog(): Boolean = true
}
