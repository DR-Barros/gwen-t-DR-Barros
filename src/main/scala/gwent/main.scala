package cl.uchile.dcc
package gwent

import gwent.controller.GameController

@main
def main(): Unit = {
  val c: GameController = new GameController
  while (true){
    c.handleState()
  }
}