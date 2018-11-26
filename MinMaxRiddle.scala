import java.io._

import scala.collection.mutable

object Solution {

  def riddle(arr: Array[Long]): Array[Long] = {
  
  /*O(n) by using stacks,
  We first build an index to find which is the left-most element for each number which is still minimum,
  then we make the same for right-most minimums.
  
  Now we now possible maximums for right - left - 1,
  we take the maximum possible and finally we fill by ans[i] > ans[i + 1]
  */
  

    val stack = mutable.Stack[Int]()

    val left = Array.fill(arr.length)(-1)
    val right = Array.fill(arr.length)(arr.length)

    arr.indices.foreach { i =>

      while(stack.nonEmpty && (arr(stack.top) >= arr(i)) ) {
        stack.pop()
      }

      if (stack.nonEmpty) left(i) = stack.top

      stack.push(i)
    }

    stack.clear()

    arr.indices.reverse.foreach { i =>

      while(stack.nonEmpty && (arr(stack.top) >= arr(i)) ) {
        stack.pop()
      }

      if (stack.nonEmpty) right(i) = stack.top

      stack.push(i)
    }

    val ans = Array.ofDim[Long](arr.length)

    arr.indices.foreach{ i =>
      val index = right(i) - left(i) - 2
      ans(index) = math.max(arr(i), ans(index))
    }

    arr.indices.reverse.tail.foreach { i =>
      ans(i) = math.max(ans(i), ans(i+1))
    }

    ans

  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(new OutputStreamWriter(System.out))

    val n = stdin.readLine.trim.toInt

    val arr = stdin.readLine.split(" ").map(_.trim.toLong)
    val res = riddle(arr)

    printWriter.println(res.mkString(" "))

    printWriter.close()
  }
}
