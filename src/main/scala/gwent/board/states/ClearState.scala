package cl.uchile.dcc
package gwent.board.states

class ClearState extends AbstractBoardState {
  override def clear(): Unit = {}

  override def isClear(): Boolean = true
}
