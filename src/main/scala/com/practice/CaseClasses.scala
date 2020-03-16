package com.practice

object CaseClasses {
  val message_1 = Message("xyz@test.com", "zyx@test.com", "Hello zyx");
  val message_2 = Message("xyz@test.com", "zyx@test.com", "Hello zyx");
  val message_1_copy = Message("xyz@test.com", "zyx@test.com", "Hello zyx");

  def main(args: Array[String]): Unit = {
    // == matches with values equality.
    println(message_1 == message_1_copy)

    // Switch matches with values equality.
    println(findMatch(message_1))
    println(findMatch(message_2))

    // Matches with message_1 as values are equal
    println(findMatch(message_1_copy))
  }

  def findMatch(message: Message): String = {
    message match {
      case message_1 => "Message 1"
      case message_2 => "Message 2"
      case message_1_copy => "Message copy 1"
      case _ => "Default"
    }
  }


}

case class Message(from: String, to: String, body: String)