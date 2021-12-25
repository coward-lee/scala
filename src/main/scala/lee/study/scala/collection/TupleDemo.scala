package lee.study.scala.collection

/**
 * 元组 元素的组合
 * 可以存放不同类型
 * 元组变量的类型是(每一个元素的类型)
 */
class TupleDemo {

}
object TupleDemo{
  def main(args: Array[String]): Unit = {
    // 1. 创建元组
    val tuple1:(String, Int, String, Char) = ("hello", 10, "sss",'c')
    println(tuple1)

    // 2. 访问元素
    println(tuple1._1)
    println(tuple1._2)
    println(tuple1._3)
    println(tuple1._4)
    println(tuple1.productElement(1))

    // 3. 遍历元组
    println("==================================================")
    for(elem<- tuple1.productIterator) println(elem)

    // 4. 嵌套元组
    val mulTuple = (1,2,3,4,5,6,'2','c',"22")
    println(mulTuple)
  }
}
