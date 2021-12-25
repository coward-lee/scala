package lee.study.basic

import scala.util.control.Breaks
import scala.util.control.Breaks._

/**
 * 遍历
 */
class ForDemo {

}
object ForDemo{
  def main(args: Array[String]): Unit = {
    // 1. 范围遍历
    // 1 to 10 包括
    for (i <- 1 to 10){
      print(i+". hello")
    }
    println("=============================================")
    for (i <- 1.to(10)){
      print(i+". hello")
    }

    println("=============================================")
    for ( i <- Range(1,10)){
      print(i+". hello")
    }

    println("=============================================")
    for(i <- 1 until 10){
      print(i+".hello")
    }
    println("=============================================")

    // 2. 集合遍历

    for ( i <- Array(12,34,21)){
      print(i+",")
    }
    println()
    for ( i <- List(12,34,21)){
      print(i+",")
    }
    println()
    for ( i <- Array(12,34,21)){
      print(i+",")
    }
    println()
    // 3. 循环守卫
    for ( i <- 1 to 10 if i != 5){
      print(i+"  ")
    }
    // 1  2  3  4  6  7  8  9  10
    // 4. 循环步长
    println()
    for (i <- 1 to 10 by 2){
      print(i+"  ")
    }
//    println("i <- 1 to 10 by -2")
//    for (i <- 1 to 10 by -2){
//      print(i+"  ")
//    }
    println()
    for (i <- Range(1,10).reverse ){
      println(i)
    }
    println()
    // 不行
//    for (i <- 1 to 10 reverse ){
//      println(i)
//    }
//    println()
    for (i <- 1 to 9; j <- 1 to i){
        print(s"$i * $j ${i*j} \t")
      if (i==j) println()
    }

    // 5. 引入变量
    for (i <- 1 to 10; j = 10 -i){
      print(i+" "+j)
    }
    for {
      i <- 1 to 10
         j = 10 -i
    }{
      print(i+" "+j)
    }
    print()

    //  6.循环中断
    // 6.1 抛出异常退出循环
    try{
      for (i <- 0 until 5){
        if (i==3)
          throw new RuntimeException
        println(i)
      }
    }catch {
      case e: Exception => // do nothing
    }
    // 6.2 使用scala的breaks类的break方法，实现异常结束
    breakable(
      for(i<- 0 until 5){
        if (i == 3)
          Breaks.break()
        println(i)
      }
    )

  }
}