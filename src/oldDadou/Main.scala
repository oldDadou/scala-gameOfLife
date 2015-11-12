package oldDadou

import swing._
import oldDadou.game.Grid
import oldDadou.view.GriddView


object Main {
        
  def main(args : Array[String]) {
    var game =  new Grid
    var filename = "example.txt"
    game.initfromFile(filename);
    val ui = new GriddView(game)
    ui.visible = true
    
    for(i <- 0 to 100) {
      game.step
      ui.update
      ui.repaint()
      Thread.sleep(500)
    }
  }
}
