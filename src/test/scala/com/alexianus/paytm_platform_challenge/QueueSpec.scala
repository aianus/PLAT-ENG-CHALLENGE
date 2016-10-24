package com.alexianus.paytm_platform_challenge

class QueueSpec extends UnitSpec {
  describe("ImmutableQueue") {
    it("should allow construction of an empty queue") {
      val emptyQueue = Queue.empty[Any]
      emptyQueue shouldBe a [Queue[_]]
      emptyQueue shouldBe 'empty
      emptyQueue.head shouldBe None
    }

    it("should allow enqueing") {
      val emptyQueue = Queue.empty[Int]
      val one = emptyQueue.enQueue(1)

      one should not be 'empty
      one.head shouldBe Some(1)
    }

    it("should be immutable") {
      val emptyQueue = Queue.empty[Int]
      val one = emptyQueue.enQueue(1)

      emptyQueue shouldBe 'empty
      one should not be 'empty
    }

    it("should be FIFO") {
      val emptyQueue = Queue.empty[Int]
      val two = emptyQueue.enQueue(1).enQueue(2)
      two.head shouldBe Some(1)

      val one = two.deQueue()
      one.head shouldBe Some(2)

      val emptyAgain = one.deQueue()
      emptyAgain.head shouldBe None
      emptyAgain shouldBe 'empty
    }

    it("should throw an exception if dequeued while empty") {
      an [NoSuchElementException] should be thrownBy Queue.empty[Int].deQueue
    }

    it("should work when alternating enqueues and dequeues") {
      val emptyQueue = Queue.empty[Int]
      val one = emptyQueue.enQueue(1).enQueue(2).enQueue(3).enQueue(4)

      one.head shouldBe Some(1)

      val two = one.deQueue()
      two.head shouldBe Some(2)

      val two_2 = two.enQueue(5)
      two_2.head shouldBe Some(2)

      val three = two_2.deQueue()
      three.head shouldBe Some(3)

      val four = three.deQueue()
      four.head shouldBe Some(4)

      val five = four.deQueue()
      five.head shouldBe Some(5)

      val emptyAgain = five.deQueue()
      emptyAgain shouldBe 'empty
      emptyAgain.head shouldBe None
    }
  }
}
