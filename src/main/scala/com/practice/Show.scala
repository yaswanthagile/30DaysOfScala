package com.practice

trait Show[A] {
  def show(a: A): String
}

object Show {

  def apply[A](implicit sh: Show[A]): Show[A] = sh;

  def show[A: Show](a: A) = Show[A].show(a)

  implicit class ShowOps[A: Show](a: A) {
    def show = Show[A].show(a)
  }

  def instance[A](fun: A => String): Show[A] = new Show[A] {
    def show(a: A): String = fun(a);
  }

  implicit val intShow: Show[Int] = instance(a => "This is Int: " + a)

  implicit val stringShow: Show[String] = instance(a => "This is String: " + a)
}
