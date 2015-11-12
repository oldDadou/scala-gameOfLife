package oldDadou.game


class Observable {
  
  var observers : List[Observer] = List()
  
  def addObeserver(obs : Observer) : Unit = {
    observers = observers :+ obs;
  }
 
  def notifyObs() : Unit = {
    observers.foreach(obs => obs.update)
  }
    
}