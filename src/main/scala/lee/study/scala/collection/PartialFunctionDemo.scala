package lee.study.scala.collection

object PartialFunctionDemo {
  def main(args: Array[String]): Unit = {
    val list: List[(String, Int)] = List(("a",1),("b",2),("c",3),("d",4))

    // 1. map 转化
    val newList = list.map(tuple => (tuple._1, tuple._2))
    println(newList)
    // 2. 模式匹配
    val newList2 = list.map(tuple=>{
      tuple match {
        case (word,count) => (word, count+2)
      }
    })
    // 3. 偏函数
    val newList3 = list.map({ case (word,count) => (word, count+2)})
    println(newList)
    println(newList2)
    println(newList3)

    // 4. 求绝对值
    val positiveAbs: PartialFunction[Int, Int] = {
      case x if x > 0 => x
    }
    val negativeAbs: PartialFunction[Int, Int] = {
      case x if x < 0 => -x
    }
    val zeroAbs:PartialFunction[Int, Int] = {
      case 0 => 0
    }
    def abs(x: Int):Int = (positiveAbs orElse negativeAbs orElse zeroAbs) (x)

    println(abs(99))
    println(abs(-99))
    println(abs(0))
  }
}
