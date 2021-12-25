package lee.study.scala.collection

class ImmutableSetDemo {

}
object ImmutableSetDemo{
  def main(args: Array[String]): Unit = {
    // 1. 创建
    val set1 = Set(12,23,123,12,312,23,3,4,123,4,23523,42,5,234)
    println(set1)
    // 2. 添加元素
    val set2 = set1 + 333
    println(set2)
    // 3. 合并set
    val set3 = Set(12,23,123,12,312,22,1,2,3,4,5)
    val set4 = set2 ++ set3
    println(set4)
    // 4. 删除元素
    val set5 = set3 - 12
    println(set5)
  }
}