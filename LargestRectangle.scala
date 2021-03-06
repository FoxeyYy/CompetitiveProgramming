import java.io._

import scala.collection.mutable

//https://www.hackerrank.com/challenges/largest-rectangle/problem
object LargestRectangle {

  case class Building(index: Int, height: Int)

  /*
    Use a stack to keep track of previous buildings.
    If current building's height is > than prev, 
    we now that max size is either currents height * all prev higher buildings
    or previous building height * all prev higher buildings.
    
    Once we have traveled all previous higher buildings 
    we add the current height associated with lowest index that is higher than current.
    
    Finally, if stack isn't empty we just travel it using its info to calculate area,
    we are sure that remaining stack buildings are lower than any to their right.
  */
  def largestRectangle(h: Array[Int]): Long = {
    val heights = mutable.Stack[Building]()
    var answ = 0

    for((num, i) <- h.zipWithIndex) {

      var left = i

      while(heights.nonEmpty && heights.top.height > num) {
        val prev = heights.pop()
        answ = math.max(answ, num*(i + 1 - prev.index))
        answ = math.max(answ, prev.height * (i - prev.index))
        left = prev.index
      }

      heights.push(Building(left, num))

    }

    heights.foreach (
      (building) => answ = math.max(answ, building.height * (h.length - building.index))
    )

    answ
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(new OutputStreamWriter(System.out))

    val n = stdin.readLine.trim.toInt

    val h = stdin.readLine.split(" ").map(_.trim.toInt)
    val result = largestRectangle(h)

    printWriter.println(result)

    printWriter.close()
  }
}
