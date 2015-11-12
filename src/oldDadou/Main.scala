package oldDadou

import swing._
import oldDadou.game.Grid
import oldDadou.view.GriddView
import oldDadou.game.Game
import oldDadou.view.GriddView


object Main {
        
  def main(args : Array[String]) {
	  var filename = "example.txt"

	  var game =  new Game
	  game.initFromFile(filename)
    var ui   = new GriddView(game)
    game.addObeserver(ui)
	  ui.visible = true
    
	  game.start
	  Thread.sleep(5000)
	  game.stop
	  
  }
}
