package oldDadou.view

import swing._
import scala.swing.event._
import java.awt.Dimension
import oldDadou.game.Grid

class GriddView(grid: Grid) extends MainFrame {

  val game = grid
  val panel : GamePanel = new GamePanel(game.dim._1, game.dim._2, grid )  
  
  var ui = new BoxPanel(Orientation.Vertical) {
    println("vue init")
    contents += panel
  } 

  def update = {
    panel.repaint()
  }

  title = "GUI Program #1"
  preferredSize = new Dimension(640, 640)
  contents = ui

}
