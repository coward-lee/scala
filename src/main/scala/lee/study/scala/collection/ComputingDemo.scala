package lee.study.scala.collection

object ComputingDemo {
  def main(args: Array[String]): Unit = {
    val list1 = List(1,223,8,3,4,5,6,7,8,9)
    val list2 = List(("a",1),("o",1),("c",1),("d",1),("e",1),("f",1))

    var sum = 0;
    // 1. 求和
    println(list1.sum)
    // 2. 乘积
    println(list1.product)
    // 3. 最大值
    println(list1.max)
    println(list2.maxBy((tuple:(String,Int))=> tuple._2))
    println(list2.maxBy(_._2))
    // 4. 最小值
    println(list1.min)
    println(list2.minBy(_._2))

    // 5. 排序
    println(list1.sorted)
    println(list1.sorted.reverse)
    println(list1.sorted(Ordering[Int].reverse))

    println(list2.sorted)
    println(list2.sortBy(_._2))
    println(list2.sortBy(_._2)(Ordering[Int].reverse))

    println(list1.sortWith(_ < _))
    println(list1.sortWith(_ > _))
  }
}
