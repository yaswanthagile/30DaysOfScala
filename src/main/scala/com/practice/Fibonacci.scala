package com.practice

object Fibonacci {

  /**
   * Yes. Not optimized.
   * @param n
   * @return
   */
  def fibonacciNonTailRec(n: Int): Int = n match {
    case 0 | 1 => n
    case _ => fibonacciNonTailRec(n-1) + fibonacciNonTailRec(n - 2)
  }

  /**
   * Tail recursion to avoid stackoverflow. Yet to add memoization.
   * @param n
   * @return
   */
  def fibonacciTailRec(n: Int): Int = {

    def fib(n: Int, prev: Int, current: Int): Int = n match {
      case 0 => prev
      case 1 => current
      case _ => fib(n-1, current, prev + current);
    }
    fib(n, 0, 1)
  }

  def fibTailRec(n: Int, prev: Int, current: Int): Int = n match {
    case 0 => prev
    case 1 => current
    case _ => fibTailRec(n-1, current, prev + current);
  }


  /**
   * Tail recursion to avoid stackoverflow. Yet to add memoization.
   * @param n
   * @return
   */
  def fibonacciTailRec2(n: Int): Int = fibTailRec(n, 0, 1);

  /**
   * Lets optimize it a bit with tail recursions
   */

  /**
   * 0, 1, 1, 2, 3, 5
   * @param args
   */
  def main(args: Array[String]): Unit = {
    println(fibonacciNonTailRec(4))
    println(fibonacciTailRec(4))
  }
}
