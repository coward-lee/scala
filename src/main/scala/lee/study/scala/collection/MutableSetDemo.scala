package lee.study.scala.collection

import scala.collection.mutable
import scala.collection.mutable.Set

class MutableSetDemo {

}
object MutableSetDemo{
  def main(args: Array[String]): Unit = {

    // 1. 创建
    val set1 = mutable.Set(12,23,123,12,312,23,3,4,123,4,23523,42,5,234)
    println(set1)

    // 2. 添加元素
    println("====================================")
    val set2 = set1+11
    println(set2)
    println(set1)
    println("====================================")
    set1+=11
    println(set1)
    val result = set1.add(222)
    println(result)

    // 3. 删除元素
    val set3 = set1 - 12
    val result2 = set1.remove(123)
    println(set3)
    println(result2)
    val set0 = mutable.Set(22,1,2,3,4,5,6,7,8,9)
    // 4. 合并
    val set4 = set1 ++ set0
    println(set4)
    println(set1)
    println(set0)
    set0++=set1
    println(set1)
    println(set0)
  }
}
