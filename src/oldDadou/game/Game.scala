package oldDadou.game

class Game extends Observable with Runnable {
  
  var playing : Boolean = false;
  
  var grid : Grid = new Grid

  var gameThread : Thread = new Thread(this)
  
  def initGame = {
    grid.init
  }
  
  def initFromFile(file :String) = {
    grid.initfromFile(file);
  }
  
  def getGrid : Grid  = {
    grid
  }
  
  def stop = {
    this.synchronized {
      if(!playing) this.wait
      playing = false
    }
    println("stopping the game")
    gameThread.join()
  }
  
  def start = {
    gameThread = new Thread(this)
    gameThread.start
  }
  
  override def run = {
    this.synchronized {
      notifyAll
      playing = true
     }
     while(playing) {
      grid.step
      notifyObs
      Thread.sleep(700)
    }
    println("game ended")
  }
  
  def getSizeX : Int = grid.dim._1
  
  def getSizeY : Int = grid.dim._2
  
}