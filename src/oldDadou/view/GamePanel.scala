package oldDadou.view
import swing._
import oldDadou.game.Grid

class GamePanel(dimx : Int, dimy : Int, grid : Grid) extends Panel {

  val cellsize : Int = 120
  val node : Color = new Color(136,124,175)
  val back : Color = new Color(38,23,88)
  
  var init = {
    this.maximumSize = new Dimension( (dimx * cellsize), (dimy * cellsize) )
  }
  
  override def paintComponent(g: Graphics2D) {
    val dx = g.getClipBounds.width.toFloat  / dimx
    val dy = g.getClipBounds.height.toFloat / dimy
    
    for(line <- 0 to dimx - 1) {
      for(row <- 0 to dimy - 1) {
        if(grid.getValue(row , line) == 1) {
          g.setColor(node)
        } else {
          g.setColor(back)
        }
        var x1 = (line * dx).toInt
        var y1 = (row * dy).toInt
        var x2 = ((line + 1) * dx).toInt
        var y2 = ((row + 1) * dy).toInt        
        g.getClipBounds
        g.fillRect(x1, y1, x2, y2)
      }
    }
  }
  
}