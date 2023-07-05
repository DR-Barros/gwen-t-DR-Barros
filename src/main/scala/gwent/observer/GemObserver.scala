package cl.uchile.dcc
package gwent.observer

import gwent.controller.GameController

class GemObserver extends Observer {
  private var gameController: Option[GameController] = None
  def update(o:ISubject, arg:Any) = {
    gameController.get.loose(o)
  }

  def setGameController(g:GameController): Unit = {
    gameController = Some(g)
  }
}
