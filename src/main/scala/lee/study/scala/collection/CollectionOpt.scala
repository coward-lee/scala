package lee.study.scala.collection

object CollectionOpt {
  def main(args: Array[String]): Unit = {
    val list1 = List(1,3,5,7,9)
    val set1 = Set(2,4,6,8,0)
    // 1. 获取集合长度
    println(list1.length)

    // 2. 获取集合大小
    println(set1.size)
    println(list1.size)
    // 3. 遍历
    set1.foreach(println)
    for (i<- list1.indices){
      println(i)
    }
    /// set(Elem) 是否存在在里面
    for ( i<- 0 until set1.size ){
      println(set1(i))
    }



    val list0 = List(1,2,3,999,4,5,6,7,8)
    val list2 = List(1,2,3,4,5,6666,6,7,8,223,122)
    val set0 = Set(1,2,3,4,5,6,7,8)
    val set2 = Set(1,2,3,4,5,6,7,8)
    // 1. 获取集合头
    println(list0.head)

    // 2. 获取集合的尾部
    println(list0.tail)

    // 3. 集合的最后一个数据
    println(list0.last)

    // 4. 集合的初始数据（不包含最后一个）
    println(list2.init)

    // 5. 反转
    println(list2.reverse)

    // 6. 取前（后）n个元素
    println(list1.takeRight(4))

    // 7. 去掉前（后）n个元素
    println(list1.drop(3))
    println(list1.dropRight(4))

    // 8. 并集
    val union = list0.concat(list2)
    println(union)
    println(list0:::list2)

    val unionSet = set0.union(set2)
    println(unionSet)
//    println(set0:::set2)

    // 9. 交集
    val intersection = list0.intersect(list2)
    println("intersection: "+intersection)

    // 10. 差集
    val diff1 = list0.diff(list2)
    val diff2 = list2.diff(list0)
    println(diff1)
    println(diff2)

    // 11. 拉链  生成二元组
    println("zip:" + list0.zip(list2))
    println("zip:" + list2.zip(list0))

    // 12. 滑窗
    println("------------------------------------------")
    list0.sliding(3).foreach(println)
    list0.sliding(4,2).foreach(println)
    list0.sliding(3,3).foreach(println)
    println()
  }
}
