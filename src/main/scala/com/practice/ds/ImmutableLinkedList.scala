package com.practice.ds

import java.util

abstract class NodeSpec {
  def insert(x: Int): NodeSpec
  def contains(x: Int): Boolean
}

class NilNode extends NodeSpec {

  override def insert(x: Int): NodeSpec = new NewNode(x, new NilNode)
  override def contains(x: Int): Boolean = false

  override def toString: String = "--> NIL"
}

class NewNode(root: Int, next: NodeSpec) extends NodeSpec {
  override def insert(x: Int): NodeSpec = new NewNode(root, next insert x)
  override def contains(x: Int): Boolean = if (x == root) true else next contains x

  override def toString: String = {
    print(root)
    print(", ")
    next.toString()
  };
}
class ImmutableLinkedList {
  def apply(start: Int): NodeSpec = {
    new NewNode(start, new NilNode)
  }
}

object ImmutableLinkedList {
  def main(args: Array[String]): Unit = {
    val list = new ImmutableLinkedList().apply(10)
    val list2 = list insert 5;
    val list3 = list2 insert 20
    println(list)
    println(list2)
    println(list3)
  }
}