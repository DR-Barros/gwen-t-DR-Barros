package cl.uchile.dcc
package gwent.observer

import gwent.controller.GameController

trait Observer {
  def update(o:ISubject, arg:Any): Unit
  def setGameController(g:GameController): Unit
}
