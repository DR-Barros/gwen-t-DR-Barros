package cl.uchile.dcc
package gwent.controller.states
import gwent.players.{Player, UserPlayer}
import gwent.cards.*

import cl.uchile.dcc.gwent.board.Board
import cl.uchile.dcc.gwent.cards.effects.*
import cl.uchile.dcc.gwent.cards.structures.Deck
import cl.uchile.dcc.gwent.observer.GemObserver

import scala.util.Random

/** Estado que representa el comienzo del juego 
 *
 * @author Daniel Radrigan
 * @since 1.0.0
 * @version 1.0.0
 */
class StartState extends AbstractState {
  private val corpCards: Array[Card] = Array(
    new CorpCard("Anakin Skywalker", 17, new MoralEffect),
    new CorpCard("Obi-Wan Kenobi", 18, new BondEffect),
    new CorpCard("Qui-Gon Jinn", 14, new NullEffect),
    new CorpCard("Palpatine", 20, new MoralEffect),
    new CorpCard("Doku", 19, new NullEffect),
    new CorpCard("Darth Maul", 15, new NullEffect),
    new CorpCard("Ahsoka Tano", 12, new NullEffect),
    new CorpCard("Yoda", 20, new BondEffect),
    new CorpCard("Mace Windu", 19, new MoralEffect),
    new CorpCard("Plo Koon", 14, new NullEffect),
    new CorpCard("Even Piell", 9, new NullEffect),
    new CorpCard("Kit Fisto", 16, new NullEffect),
    new CorpCard("Luminara Undull", 19, new MoralEffect),
    new CorpCard("Asajj Ventress", 14, new NullEffect),
    new CorpCard("Kanan Jarrus", 12, new NullEffect),
    new CorpCard("Ezra Bridger", 11, new NullEffect),
    new CorpCard("Luke Skywalker", 19, new MoralEffect),
    new CorpCard("Kylo Ren", 14, new NullEffect),
    new CorpCard("Rey", 14, new MoralEffect),
    new CorpCard("General Grievous", 16, new NullEffect)
  )
  private val distanceCards: Array[Card] = Array(
    new DistanceCard("Leia", 20, new MoralEffect),
    new DistanceCard("Han Solo", 20, new BondEffect),
    new DistanceCard("Boba Fett", 14, new NullEffect),
    new DistanceCard("Jango Fett", 13, new NullEffect),
    new DistanceCard("Cad Bane", 15, new NullEffect),
    new DistanceCard("Din Djarin", 16, new BondEffect),
    new DistanceCard("Zuckuss", 5, new NullEffect),
    new DistanceCard("Poe Dameron", 13, new NullEffect),
    new DistanceCard("Finn", 10, new MoralEffect),
    new DistanceCard("Chewbacca", 17, new NullEffect),
    new DistanceCard("Jar Jar Binks", 4, new MoralEffect),
    new DistanceCard("Lando Calrissian", 11, new NullEffect),
    new DistanceCard("Cody", 15, new MoralEffect),
    new DistanceCard("Cincos", 13, new NullEffect),
    new DistanceCard("Stormtropper", 10, new NullEffect),
    new DistanceCard("Droideka", 14, new NullEffect),
    new DistanceCard("Droide de Batalla B2", 9, new NullEffect)
  )
  private val siegeCards: Array[Card] = Array(
    new SiegeCard("At AT", 15, new NullEffect),
    new SiegeCard("At ST", 12, new NullEffect),
    new SiegeCard("At TE", 14, new NullEffect),
    new SiegeCard("Estrella de la Muerte", 20, new MoralEffect),
    new SiegeCard("Halcón milenario", 16, new MoralEffect),
    new SiegeCard("X Wings", 13, new BondEffect),
    new SiegeCard("Y Wings", 10, new BondEffect),
    new SiegeCard("Caza Tie", 13, new BondEffect),
    new SiegeCard("Interceptor Tie", 13, new NullEffect),
    new SiegeCard("Caza Delta 7", 12, new NullEffect),
    new SiegeCard("Esclavo I", 10, new NullEffect),
    new SiegeCard("Destructor Estela", 17, new NullEffect),
    new SiegeCard("Razor Crest", 11, new NullEffect),
    new SiegeCard("Caza estelar N-1", 8, new NullEffect)
  )
  private val weatherCards: Array[Card] = Array(
    new WeatherCard("Alderan", new ClearEffect),
    new WeatherCard("Aldahani", new ClearEffect),
    new WeatherCard("Ahch-To", new RainEffect),
    new WeatherCard("Dagobah", new FogEffect),
    new WeatherCard("Kamino", new RainEffect),
    new WeatherCard("Jedha", new FrostEffect),
    new WeatherCard("Mon Cala", new FogEffect),
    new WeatherCard("Hoth", new FrostEffect),
    new WeatherCard("ilum", new FrostEffect),
    new WeatherCard("Mygeeto", new FrostEffect),
    new WeatherCard("Bespin", new FogEffect),
    new WeatherCard("Yavin", new FogEffect),
    new WeatherCard("Narkina 5", new RainEffect),
    new WeatherCard("Niamos", new ClearEffect),
    new WeatherCard("Rodia", new ClearEffect),
    new WeatherCard("Ryloth", new ClearEffect),
    new WeatherCard("Scarif", new ClearEffect),
    new WeatherCard("Shili", new RainEffect)
  )
  /** acción que realiza el juego */
  def handle(): Unit = {
    c.get.p1 = Some(new UserPlayer("Player 1", createDeck()))
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
    var c: Array[Card] = Random.shuffle(corpCards.toSeq).toArray
    c = c.take(6)
    var d: Array[Card] = Random.shuffle(distanceCards.toSeq).toArray
    d = d.take(6)
    var s: Array[Card] = Random.shuffle(siegeCards.toSeq).toArray
    s = s.take(6)
    var w: Array[Card] = Random.shuffle(weatherCards.toSeq).toArray
    w = w.take(7)
    var deck: Array[Card] =Random.shuffle((c ++ d ++ s ++ w).toSeq).toArray
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
