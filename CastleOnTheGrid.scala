import java.io._

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object Solution {

  case class Position(var x: Int, var y: Int)

  def minimumMoves(grid: Array[String], startX: Int, startY: Int, goalX: Int, goalY: Int): Int = {
    /*
    BFS Algorithm, we need to find min path, use a square array to store depths.
     */

    val depth = Array.ofDim[Int](grid.length, grid.length)

    val visited = mutable.Set[Position]()
    val toVisit = mutable.Queue[Position]()
    val destiny = Position(goalX, goalY)
    var current = Position(startX, startY)
    visited += current
    depth(current.x)(current.y) = 0

    var steps = 0

    while(visited.nonEmpty) {


      if (current == destiny) return depth(current.x)(current.y)

      val nexsts = generateMovements(current, grid).filterNot(visited.contains).filter(i => depth(i.x)(i.y) == 0)
      toVisit ++= nexsts
      nexsts.foreach { next =>
        depth(next.x)(next.y) = depth(current.x)(current.y) + 1
      }

      current = toVisit.dequeue()
      visited += current
    }

    -1

  }

  def generateMovements(position: Position, grid: Array[String]): Seq[Position] = {
    val ans = new ListBuffer[Position]()

    var next: Position = Position(position.x + 1, position.y)
    while (isValid(next, grid)) {
      ans += next.copy()
      next.x += 1
    }

    next = Position(position.x - 1, position.y)

    while (isValid(next, grid)) {
      ans += next.copy()
      next.x -= 1
    }

    next = Position(position.x, position.y + 1)

    while (isValid(next, grid)) {
      ans += next.copy()
      next.y += 1
    }

    next = Position(position.x, position.y - 1)

    while (isValid(next, grid)) {
      ans += next.copy()
      next.y -= 1
    }

    ans.toList
  }

  def isValid(position: Position, grid: Array[String]) = withinBounds(position, grid) && grid(position.x).charAt(position.y) != 'X'

  def withinBounds(position: Position, grid: Array[String]) = position.x >= 0 && position.x < grid.length && position.y >= 0 && position.y < grid.length

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(new OutputStreamWriter(System.out))

    val n = stdin.readLine.trim.toInt

    val grid = Array.ofDim[String](n)

    for (i <- 0 until n) {
      val gridItem = stdin.readLine
      grid(i) = gridItem}

    val startXStartY = stdin.readLine.split(" ")

    val startX = startXStartY(0).trim.toInt

    val startY = startXStartY(1).trim.toInt

    val goalX = startXStartY(2).trim.toInt

    val goalY = startXStartY(3).trim.toInt

    val result = minimumMoves(grid, startX, startY, goalX, goalY)

    printWriter.println(result)

    printWriter.close()
  }
}
