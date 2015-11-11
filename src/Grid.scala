import scala.io.Source

class Grid {
  val dim = (20, 20) 
  var grid : Array[Array[Int]] = Array.ofDim[Int](dim._1, dim._2)
  
  def init = {
    println("init")
    for(line <- 0 to dim._1 - 1) 
      for(row <- 0 to dim._2 - 1) {
        grid(line)(row) = 1
      }
  }
  
  def initfromFile(file : String) = {
    var lines = Source.fromFile(file).getLines().toArray;
    for(i <- 0 to lines.length - 1) {
      var line = lines(i).split(" ").toArray;
      for(j <- 0 to line.length - 1) {
        grid(i)(j) = line(j).toInt;
      }
    }
  }
 
  def print = {
    grid.foreach({x => 
      x.foreach({ 
          elem => printf(" %d ", elem)
      })
      println
    })
  }
  
  def getLine(x : Int) : Array[Int] = {
    grid(x)
  }
  
  def getValue(x : Int, y : Int) : Int = {
     grid(x)(y)
  }
  
  def getNumberNeigh(x : Int, y : Int) : Int = {
    var i = 0;
    var j = 0;
    var number = 0;
    for(i <- x - 1  to x + 1) {
      if(i >= 0 && i < dim._1) {
        for(j <- y - 1 to y + 1) {
          if(j >= 0 && j < dim._2 &&  getValue(i, j) == 1) {
            if(!(i == x && j == y))  
              number += 1;
          }
        }
      }
    }
    number
  }
  
  def neighMap : Array[Array[Int]] = {
    var map : Array[Array[Int]]= Array.ofDim[Int](dim._1, dim._2)
    for(line <- 0 to dim._1 - 1) 
      for(row <- 0 to dim._2 - 1) {
        map(line)(row) = getNumberNeigh(line, row)
      }
     map
  }
  
  def printArray2D(array :  Array[Array[Int]]) = {
    array.foreach({x => 
        x.foreach({ 
            elem => printf(" %d ", elem)
        })
      println
    })
  }
  
  def step() = {
//    printArray2D(neighMap)
    var newGrid : Array[Array[Int]]= Array.ofDim[Int](dim._1, dim._2)
    for(line <- 0 to dim._1 - 1) {
      for(row <- 0 to dim._2 - 1) {
        var nbAround = getNumberNeigh(line, row)
        var cell : Int = getValue(line, row)
        if(cell == 0 && nbAround == 3) {
          newGrid(line)(row) = 1
        } else if (cell == 1 && nbAround == 3) {
          newGrid(line)(row) = 1
        } else if(cell == 1 && nbAround == 2) {
          newGrid(line)(row) = 1
        } else { 
          newGrid(line)(row) = 0
        }
      }
    }
    grid = newGrid
  }
}