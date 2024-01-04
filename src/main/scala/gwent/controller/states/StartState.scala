package cl.uchile.dcc
package gwent.controller.states
import gwent.players.{Player, UserPlayer}
import gwent.cards.*

import cl.uchile.dcc.gwent.board.Board
import cl.uchile.dcc.gwent.cards.effects.*
import cl.uchile.dcc.gwent.cards.structures.Deck
import cl.uchile.dcc.gwent.factories.{CardFactory, CorpCardFactory, DistanceCardFactory, SiegeCardFactory, WeatherCardFactory}
import cl.uchile.dcc.gwent.observer.GemObserver

import scala.util.Random

/** Estado que representa el comienzo del juego 
 *
 * @author Daniel Radrigan
 * @since 1.0.0
 * @version 1.0.0
 */
class StartState extends AbstractState {
  var factories: Option[CardFactory] = None
  /** acción que realiza el juego */
  def handle(): Unit = {
    c.get.p1 = Some(new UserPlayer("Jugador", createDeck()))
    c.get.p2 = Some(new UserPlayer("CPU", createDeck()))
    c.get.board = Some(new Board)
    c.get.observers += new GemObserver
    c.get.observers.foreach(observer =>
      observer.setGameController(c.get)
      c.get.p1.get.registerObserver(observer)
    )
    stealCards(c.get.p1.get)
    stealCards(c.get.p2.get)
    roundInit()
  }
  /** cambia el estado a RoundInit */
  override def roundInit(): Unit = changeState(new RoundInitState())
  /** Indica que el estado actual es Start */
  override def isStart(): Boolean = true
  /** Crea mazos de cartas */
  private def createDeck(): Deck = {
    var deck: Array[Card] = new Array[Card](0)
    factories = Some(new CorpCardFactory)
    for (i <- 0 to 5){
      deck = deck:+factories.get.create()
    }
    factories = Some(new DistanceCardFactory)
    for (i <- 0 to 5) {
      deck = deck :+ factories.get.create()
    }
    factories = Some(new SiegeCardFactory)
    for (i <- 0 to 5) {
      deck = deck :+ factories.get.create()
    }
    factories = Some(new WeatherCardFactory)
    for (i <- 0 to 6) {
      deck = deck :+ factories.get.create()
    }
    deck = Random.shuffle((deck).toSeq).toArray
    return new Deck(deck)
  }

  /** Roba 10 cartas del mazo del jugador
   * 
   * @param p jugador
   */
  private def stealCards(p:Player): Unit = {
    for (i <- 1 to 10){
      p.stealCard()
    }
  }
}
