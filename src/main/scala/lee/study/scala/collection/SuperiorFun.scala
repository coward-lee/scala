package lee.study.scala.collection

object SuperiorFun {
  def main(args: Array[String]): Unit = {
    val list1 = List(1,2,3,4,5,6,7,8,9,0)
    val list2:List[List[Int]] = List(List(1,2,3,4,5,6,7,8,9,0),List(1,2,3,4,5,6,7,8,9,0),List(1,2,3,4,5,6,7,8,9,0))

    // 1. 过滤
    println(list1.filter(_ % 2 == 1))

    // 2. 转化/映射
    println(list1.map(_*2))
    println(list1.map(_^2))
    // 3. 扁平化
    println(list2.flatten)
    // 4. 扁平化+映射
    println(list2.flatMap(_.init))

    // 5. 分组
    val value = list1.groupBy(_ % 2)
    println(value)

    // 6. reduce 直接进行归约即可
    // 左往有加
    println(list1.reduce(_ + _))
    // 左往有加
    println(list1.reduceLeft(_ + _))
    // 右往左加
    println(list1.reduceRight(_ + _))
    println("=========================")

    val list3 = List(3,4,5,6,7)
    // 左到右
    println(list3.reduce(_ - _))
    // 左到右
    println(list3.reduceLeft(_ - _))
    // 右到左
    println(list3.reduceRight(_ - _))

    // 7. fold 需要传入一个值来进行操作
    println(list3.fold(10)(_ + _))
    println(list3.foldLeft(10)(_ - _))
    println(list3.foldRight(10)(_ - _))

  }
}
