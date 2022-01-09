package org.lee.part1recap

import scala.concurrent.Future

// encapsulated 封装的？
//oop is not encapsulated
// rescue
object ThreadModelLimitations extends App {

  class BankAccount(@volatile private var amount:Int){
    override def toString: String = "" + amount

    def  withDraw(money: Int) =this.synchronized{
      this.amount -= money
    }
//    def  withDraw(money: Int) = this.amount -= money
//    def  deposit(money: Int) = this.amount += money
    def  deposit(money: Int) = this.synchronized{
      this.amount += money
    }
    def  getAmount = amount
  }

  val account = new BankAccount(2000)

  for (_ <- 1 to 1000){
    new Thread(() => account.withDraw(1)).start()
  }

  for (_ <- 1 to 1000){
    new Thread(() => account.deposit(1)).start()
  }
  println(account.getAmount)

  // oop encapsulation is broken in a multithreaded env
  // synchronization! locks to the rescue

  /**
   * DR #2：
   */

  var task: Runnable = null

  val runningThread: Thread = new Thread(() => {
    while (true){
      while (task == null){
        runningThread.synchronized{
          println("[background] waiting for a task...")
          runningThread.wait()
        }
      }

      task.synchronized{}
      println("[background] i have a task")
      task.run()
      task = null
    }
  })

  def delegate2BackgroundThread(r :Runnable) = {
    if (task == null) task = r

    runningThread.synchronized({
      runningThread.notify()
    })
  }
  runningThread.start()
  Thread.sleep(1000)
  delegate2BackgroundThread(()=> println(42))
  Thread.sleep(1000)
  delegate2BackgroundThread(() => println(" this should run in background"))


  /**
   * DR #3: tracing and dealing with errors in a multithreaded env is a PITN
   */
  // 1M number in between 10 threads

  import scala.concurrent.ExecutionContext.Implicits.global

  val futures = (0 to 9)
    .map(i=> 10000 * i until 10000 * (i + 1))
    .map(range => Future{
      if (range.contains(21234)) throw new RuntimeException("invalid number")
      range.sum
    })
  val sumFuture = Future.reduceLeft(futures)(_ + _)

  sumFuture.onComplete(println)


}
