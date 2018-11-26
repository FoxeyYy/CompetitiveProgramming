import java.io._

import scala.collection.mutable

object Solution {

  val beg = List('{', '[', '(')
  val ends = Map('}' -> '{', ')' -> '(', ']' -> '[')

  def isBalanced(s: String): String = {
  
  /*
  O(n) Time and space, using a stack, 
  if we find a beggining char we push into the stack, 
  else we check if top is our counter char
  */

    val stack = mutable.Stack[Char]()

    s.foreach {
        case c if beg.contains(c) => stack.push(c)
        case c if stack.nonEmpty && ends(c) == stack.top => stack.pop()
        case _ => return "NO"
    }

    if (stack.isEmpty) "YES" else "NO"

  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(new OutputStreamWriter(System.out))

    val t = stdin.readLine.trim.toInt

    for (tItr <- 1 to t) {
      val s = stdin.readLine

      val result = isBalanced(s)

      printWriter.println(result)
    }

    printWriter.close()
  }
}
