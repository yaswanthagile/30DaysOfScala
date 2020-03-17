package com.practice

object CurryingFurther {
  def product(fun: Int => Int)(a:Int, b:Int):Int = {
     if(a > b) 1 else fun(a) + product(fun)(a+1, b);
  }

  def factorial(n: Int) = product(x => x)(1, n)

  /**
   * Not for faint hearted. Stepping into world of functions
   */
  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int = {
    if(a > b) zero
    else combine(f(a), mapReduce(f, combine, zero)(a+1, b))
  }

  def factorialWithMapReduce(n: Int): Int = mapReduce(x => x, (a, b) => a * b, 1)(1, n);

  def main(args: Array[String]): Unit = {
    val result = product(x => x* x)(1, 3)
    println("sum of products of 1 to 3 is: " + result)
    val factorial = factorialWithMapReduce(4)
    println("Factorial: " + factorial)
  }
}
