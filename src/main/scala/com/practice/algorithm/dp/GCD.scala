package com.practice.algorithm.dp

import scala.annotation.tailrec

object GCD {
  @tailrec
  def GCD(a: Int, b: Int):Int = if(b == 0) a else GCD(a, a % b)

  def main(args: Array[String]): Unit = {
    println(GCD(10, 5))
  }

}
