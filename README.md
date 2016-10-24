# PLAT-ENG-CHALLENGE

## Instructions

```bash
git clone https://github.com/aianus/PLAT-ENG-CHALLENGE.git paytm_platform_challenge
cd paytm_platform_challenge
sbt test
```

## Notes

I only got through part one before the recruiter emailed me again and told me to do the [WebLogs Challenge](https://github.com/aianus/WeblogChallenge) instead.

Implementation is located in src/main/scala/com/alexianus/paytm_platform_challenge/

Tests are located in src/test/scala/com/alexianus/paytm_platform_challenge/

## Original Challenge


In object-oriented and functional programming, an immutable object is an object whose state cannot be modified after it is created. This is in contrast to a mutable object which can be modified after it is created. 

Classes should be immutable unless there's a very good reason to make them mutable. If a class cannot be made immutable, limit its mutability as much as possible. The JDK contains many immutable classes, including String, the boxed primitive classes, and BigInteger and etc. Basically the immutable classes are less prone to error. 

Please implement an immutable queue with the following api:

Scala Version:
```scala
trait Queue[T] {
  def isEmpty: Boolean
  def enQueue(t: T): Queue[T]
  # Removes the element at the beginning of the immutable queue, and returns the new queue.
  def deQueue(): Queue[T]
  def head: Option[T]
}
object Queue {
  def empty[T]: Queue[T] = ???
}
```
