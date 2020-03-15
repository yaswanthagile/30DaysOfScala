package com.practice

object Currying {
  def sum(x: Int => Int)(a: Int, b: Int) = {
   def accumilate(a: Int, acc: Int): Int = {
     if(a > b) acc else accumilate(a + 1, x(a) + acc)
   }
    accumilate(a, 0);
 }

  def main(args: Array[String]): Unit = {
    val sumOfSquares = sum(x => x * x)_
    println(sumOfSquares(1, 3))
  }
}
