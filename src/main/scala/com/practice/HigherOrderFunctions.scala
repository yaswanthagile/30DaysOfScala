package com.practice

object HigherOrderFunctions {
  def sumOfSquare(from: Int, to: Int): Int = {
      def recursive(a: Int, acc:Int): Int = {
        if(a > to) acc else recursive(a + 1, a*a + acc)
      }
    recursive(from, 0)
  }

  /**
   * Function for squaring is assigned as higher order function. This function can abstracted further.
   * @param from
   * @param to
   * @return
   */
  def sumOfSquare2(from: Int, to: Int): Int = {
    val squareFunction = (x:Int) => x * x

    def recursive(a: Int, acc:Int): Int = {
      if(a > to) acc else recursive(a + 1, acc + squareFunction(a))
    }
    recursive(from, 0);
  }

  def sum(fun: Int => Int, from: Int, to: Int) = {
    def tailRecSum(a: Int, acc: Int): Int = {
      if(a > to) acc else tailRecSum(a + 1, fun(a) + acc )
    }
    tailRecSum(from, 0)
  }

  def main(args: Array[String]): Unit = {
    println(sumOfSquare(1,3))
    println(sumOfSquare2(1, 3))
    println(sum(x=> x * x, 1, 3))
  }
}
