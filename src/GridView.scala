import swing._
import scala.swing.event._
import java.awt.{Color, Dimension, Graphics, Graphics2D, Point, geom}

class GriddView(grid : Grid) extends MainFrame {
  val game = grid
  
  var ui = new BoxPanel(Orientation.Vertical) {
    for(i <- 0 to game.dim._1 - 1) {
    	var panel = new BoxPanel(Orientation.Horizontal) {
        for(j <- 0 to game.dim._2 - 1) {
           var box = new CheckBox();
           if(grid.getValue(i, j) == 1)
             box.selected = true
           contents += box
        }
    	}
    	contents += panel
    }
  }
  
  def update = {
    ui = new BoxPanel(Orientation.Vertical) {
    for(i <- 0 to game.dim._1 - 1) {
    	var panel = new BoxPanel(Orientation.Horizontal) {
        for(j <- 0 to game.dim._2 - 1) {
           var box = new CheckBox();
           if(grid.getValue(i, j) == 1)
             box.selected = true
           contents += box          
           }
    	  }
    	  contents += panel
      }
    }
    contents = ui
  }

  title = "GUI Program #1"
  preferredSize = new Dimension(640, 780)
  contents = ui
  
}
