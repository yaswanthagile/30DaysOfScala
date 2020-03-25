package com.practice.ds

/**
 * Persistant datastructures: Binary tree
 */
abstract class IntSet {
  def contains (x: Int): Boolean
  def insert(x: Int): IntSet
}

class EmptyNode extends IntSet {
  def contains(x: Int): Boolean = false
  override def insert(x: Int): IntSet = new Node(x, new EmptyNode, new EmptyNode)
  override def toString: String = ".";
}

class Node(root: Int, left: IntSet, right: IntSet) extends IntSet {
  def contains(x: Int): Boolean = {
    if (x < root) left contains x
    else if(x > root) right contains x
    else true
  }

  /**
   * Creates a copy of tree until new entry
   * @param x
   * @return
   */
  override def insert(x: Int): IntSet =
    if (x < root) new Node(root, left insert x, right)
    else if (x > root) new Node(root, left, right insert x)
    else this

  override def toString: String = "{" + left + "{" + root + "}" + right + "}";
}

object IntSet {
  def main(args: Array[String]): Unit = {
    val tree = new Node(5, new EmptyNode, new EmptyNode);
    val tree2 = tree insert 6
    val tree3 = tree2 insert 2
    val tree4 = tree3 insert 3

    println(tree)
    println(tree2)
    println(tree3)
    println(tree4)
  }
}