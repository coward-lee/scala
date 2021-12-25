package lee.study.scala.collection

import scala.collection.mutable.ListBuffer

class ListBufferDemo {

}

object ListBufferDemo{
  def main(args: Array[String]): Unit = {
    // 1. 创建
    // 利用new创建
    val list1: ListBuffer[Int] = new ListBuffer[Int]()
    // 利用伴生对象的apply方法
    val list2 = ListBuffer(12,23,345)
    println(list1)
    println(list2)
    println("=============")
    // 2. 添加
    list1.append(11)
    list2.prepend(222)
    println(list1)
    println(list2)
    println("=============")
    21 +=: 64 +=: list1 += 22222222
    println(list1)

    // 3. 合并list
    val list3 = list1 ++ list2
    println(list3)
    println("=================================")
    list1 ++= list2
    println(list1)
    println(list2)

    // 4. 修改元素
    list1(3) = 3333333
    println(list1)
    // 5. 删除元素
    list1.remove(5)
    list1 -= 222
    println(list1)
  }
}