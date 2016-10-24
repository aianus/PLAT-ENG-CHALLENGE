package com.alexianus.paytm_platform_challenge

import java.util.NoSuchElementException

import scala.collection.immutable.List

trait Queue[T] {
  def isEmpty: Boolean
  def enQueue(t: T): Queue[T]
  // Removes the element at the beginning of the immutable queue, and returns the new queue.
  def deQueue(): Queue[T]
  def head: Option[T]
}

class ImmutableQueue[T] private (read_contents: List[T], write_contents: List[T]) extends Queue[T] {
  // Store queue as two immutable stacks (linked lists) a la
  // https://stackoverflow.com/questions/69192/how-to-implement-a-queue-using-two-stacks
  // Space requirement is always O(n)
  // O(1)
  def this() = this(Nil, Nil)
  // O(1)
  def isEmpty = read_contents.isEmpty
  // O(1) amortized
  def enQueue(t: T) = read_contents match {
    case Nil => new ImmutableQueue((t :: write_contents).reverse, Nil)
    case _ => new ImmutableQueue(read_contents, t :: write_contents)
  }
  // O(1) amortized
  def deQueue() = read_contents match {
    case Nil => throw new NoSuchElementException
    case car :: Nil => new ImmutableQueue(write_contents.reverse, Nil)
    case car :: cdr => new ImmutableQueue(cdr, write_contents)
  }
  // O(1)
  def head = read_contents.headOption
}
object Queue {
  def empty[T]: Queue[T] = new ImmutableQueue[T]
}
