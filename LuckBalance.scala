import java.io._
import java.math._
import java.security._
import java.text._
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._

object Solution {

  object MinOrder extends Ordering[Int] {
    def compare(x:Int, y:Int) = y compare x
  }

  def luckBalance(k: Int, contests: Array[Array[Int]]): Int = {

    //Store important contests in a min-heap to ensure o(1) access
    val minHeap = scala.collection.mutable.PriorityQueue.empty(MinOrder)

    var sol = 0

    // O(n) time
    contests.foreach { el =>
      val luck = el(0)
      val imp = el(1)

      if (imp == 1) {
          minHeap += luck
      }
      
      sol += luck
    }

    //Now just dicrease each min twice (We added mins before)
    for (_ <- 1 to minHeap.size - k) {
      sol -= 2 * minHeap.dequeue()
    }

    sol

  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(new OutputStreamWriter(System.out))

    val nk = stdin.readLine.split(" ")

    val n = nk(0).trim.toInt

    val k = nk(1).trim.toInt

    val contests = Array.ofDim[Int](n, 2)

    for (i <- 0 until n) {
      contests(i) = stdin.readLine.split(" ").map(_.trim.toInt)
    }

    val result = luckBalance(k, contests)

    printWriter.println(result)

    printWriter.close()
  }
}
