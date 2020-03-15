package com.practice

object Factorial {

  /**
   * Calculates factorial recursively. Its not tail-recursive, so it will fail with stackoverflow for bigger numbers
   * @param n
   * @return
   */
  def factorialRecursive(n: Int) : Int = {
    if(n == 1) 1 else n * factorialRecursive(n - 1)
  }

  /**
   * Tail recursive to avoid possible stackoverflow
   * @param n
   * @param acc
   */
  def factorialTailRec(n: Int, acc: Int): Unit = {
    if(n == 1) 1 else factorialTailRec(n-1, n * acc);
  }

  def main(args: Array[String]): Unit = {
    println(factorialRecursive(4));
    println(factorialTailRec(4, 1));
  }
}
