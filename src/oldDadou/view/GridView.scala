package oldDadou.view

import swing._
import scala.swing.event._
import java.awt.Dimension
import oldDadou.game.Grid
import oldDadou.game.Observer
import oldDadou.game.Game

class GriddView(model: Game) extends MainFrame  with Observer {
  
  val game : Game = model
  val panel : GamePanel = new GamePanel(game.getSizeX, game.getSizeY, game.getGrid)  
  
  var ui = new BoxPanel(Orientation.Vertical) {
    println("vue init")
    contents += panel
  } 

  title = "GUI Program #1"
  preferredSize = new Dimension(640, 640)
  contents = ui
  
  override def update() {
    panel.repaint()
  }
  
  
}
