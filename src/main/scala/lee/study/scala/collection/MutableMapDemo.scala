package lee.study.scala.collection

import scala.collection.mutable

class MutableMapDemo {

}
object MutableMapDemo{
  def main(args: Array[String]): Unit = {
    val map1: mutable.Map[String, Int] = mutable.Map("a" -> 13,  "b"->23)
    println(map1)
    map1.foreach(println)
    // 2. 添加元素
    map1.put("xxx",1111)
    println(map1)
    map1 += (("xx",11))
    println(map1)

    // 3. 删除元素
    map1.remove("xx")
    println(map1)
    println(map1.getOrElse("xx", 0))
    // 4. 更新元素
    println("============================================")
    map1.update("xx", 10000)
    println(map1.getOrElse("xx", 0))

    // 5. 合并
    val map2: mutable.Map[String, Int] = mutable.Map("aaa"->111,"a"->1,"aa"->11)
//    map1 ++=map2
    println(map1)
    println(map2)

    val map3 = map1++map2
    println(map3)
    println(map3.getClass)

  }
}
