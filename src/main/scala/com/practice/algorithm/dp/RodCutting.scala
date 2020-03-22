package com.practice.algorithm.dp

object RodCutting {
  /**
   * Needs new impl
   * @param price
   * @param n
   * @return
   */
  def cutRot(price: IndexedSeq[Int], n: Int): Int = n match {
        case 0| -1 => 0
        case _ => (0 to n-1).foldLeft(-1)(
          (result: Int, head: Int) => Math.max(result,  price(head) + cutRot(price, n-head-1))
        )
  }

  def main(args: Array[String]): Unit = {
    val arr: IndexedSeq[Int] = IndexedSeq(1, 5, 8, 9, 10, 6, 10, 20);
    println(cutRot(arr, 7))
  }
}
