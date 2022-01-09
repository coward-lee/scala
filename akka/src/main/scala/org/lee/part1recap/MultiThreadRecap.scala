package org.lee.part1recap

import scala.concurrent.Future
import scala.util.{Failure, Success}

object MultiThreadRecap extends App {

  val aThread =  new Thread(()=>(1 to 1000).foreach(_ => println(" ??????????????? ")))
  aThread.start()
  // aThread加入main线程，是的aThread和main串行化了
  aThread.join()
  println("???")

  val threadHello = new Thread(()=>(1 to 1000).foreach(_ => println(" hello ")))
  val threadBye = new Thread(()=>(1 to 1000).foreach(_ => println(" bye ")))
  threadHello.start()
  threadBye.start()

   class BankAccount(@volatile private var amount:Int){
     override def toString: String = "" + amount

     def  withDraw(money: Int) = this.amount -= money

     def safeWithDraw(money:Int) = this.synchronized{
       this.amount -= money
     }
   }

  // wait - notify mechanism

  import scala.concurrent.ExecutionContext.Implicits.global
  val future = Future{
    // 在不用线程中计算
    42
  }
  future.onComplete{
    case Success(42) => println(" 计算完成了？")
    case Failure(_) => println(" something happened with the meaning of life!")
  }

  //
  val aProcessedFuture = future.map( _ + 1) // 43

  val aFlatFuture = future.flatMap{
    value=> Future(value + 2)
  }

  val filterFuture = future.filter( _ % 2 == 0) // NoSuchElementException

  val aNonsenseFuture = for{
    meaningOfLife <- future
    filteredMeaning <- filterFuture
  }yield meaningOfLife +filteredMeaning

  // andThen, recover/recoverWith


  // Promises
}
