# Gwen't

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

This work is licensed under a
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/)

Context
-------

This project's goal is to create a (simplified) clone of the
[_Gwent_](https://www.playgwent.com/en)card game developed by [_CD PROJEKT RED_](https://cdprojektred.com/en/)

## Cartas
Se crea un Trait Card en el cual se especifica todo lo que debe tener todas las cartas. 
Este Trait va a ser implementado  por las clases WeatherCard y UnitCard (abstract). Además, 
Se crea una carta especial (emptyCard) cuya única función es ser devuelta cuando Deck o CardsHand
están vacíos y de esta forma señalar que esta vacío.

### Interface de carta:
Todas las cartas comparten una interface (Trait) en común que especifica los métodos que deben tener todas 
las cartas. Todas las cartas deben tener un nombre y un tipo (clima, cuerpo a cuerpo, a distancia o de 
asedio) por lo que deben tener un método que devuelva estos valores para poder utilizarlos, 
respectivamente estos métodos son getName y getCardType.

** Insertar png con una foto del trait

En un futuro cuando se implemente el tablero se usara getCardType para identificar a que parte de este debe ir cada carta.




### Tipos de carta:

#### WeatherCard:
Las cartas de clima son un tipo de carta especial, que se colocan en la zona de clima, 
para poder asegurar que se colocan en esa zona es que getCardType devuelve "Weather".

Estas cartas tendrán el poder de afectar el campo de batalla y brindar ventajas o desventajas a los jugadores, 
una vez que se implemeten los efectos.
Por ahora su implementación es de esta forma:

** Insertar png con una foto del esquema UML

#### UnitCard:
La Clase abstracta UnitCard tiene 3 subclases, las cuales son CorpCard, SiegeCard y DistanceCard
las que respectivamente representan Unidades cuerpo a cuerpo, Unidades de asedio y Unidades a distancia.
Esta clase define los métodos getName y getStrength que devuelve el nombre y fuerza que debe tener una carta de unidad.

** Insertar png con una foto del esquema UML

1. #### CorpCard: 
    Esta subclase de UnitCard representa las cartas cuerpo a cuerpo, hereda los métodos getName y getStrength
    de UnitCard y añade la implementación del método getCardType para que devuelva "CorpCard"
2. #### SiegeCard:
   Esta subclase de UnitCard representa las cartas cuerpo a cuerpo, hereda los métodos getName y getStrength
   de UnitCard y añade la implementación del método getCardType para que devuelva "SiegeCard"
3. #### DistanceCard:
   Esta subclase de UnitCard representa las cartas cuerpo a cuerpo, hereda los métodos getName y getStrength
   de UnitCard y añade la implementación del método getCardType para que devuelva "DistanceCard"
---

## Jugadores
Los jugadores del juego van a recibir tanto la posición en el tablero como su mazo de cartas. Como
hasta ahora no se ha implementado que el juego le entregue un mazo, para simular que este haya
sido barajado a la hora de robar se va a sacar una carta aleatoria del mazo. De esta forma nos aseguramos
que el juego no se vuelva repetitivo.




---
**The rest of the documentation is left for the users of this template to complete**

