package cl.uchile.dcc
package gwent.gameController

import gwent.players.Player
import cl.uchile.dcc.gwent.board.Board


class GameController extends Controller{
  private var p1: Player = _
  private var p2: Player = _
  private var board: Board = _
  private var state: State = _

  def setState(aState: State): Unit = {
    state = aState
    state.setController(this)
  }
}
