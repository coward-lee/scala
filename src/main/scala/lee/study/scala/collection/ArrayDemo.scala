package lee.study.scala.collection

/**
 * 集合类型
 */
class ArrayDemo {

}
object ArrayDemo{
  def main(args: Array[String]): Unit = {
    // 1. 数组的创建
    val arr1 : Array[Int] = new Array[Int](5)
    val arr2  = Array(1,2,3,4)
    // 2. 访问
    println(arr1(1))
    println(arr2(1))

    println("========================================================")
    // 3. 数组遍历
    // 3.1 for
    for( i<- 0 until arr2.length){
      println(arr2(i))
    }
    for ( i <- arr2.indices) println(arr2(i))
    // 3.2 增强for循环
    for (elem <- arr2) println(elem)
    // 3.2 迭代器
    val iter = arr2.iterator
    while (iter.hasNext) println(iter.next())
    println("----------------------------")
    arr2.foreach(println(_))
    println(arr2.mkString("--"))

    // 4. 添加数组
    // scala 将类型是从右到左来判断
    val newArr1 = arr2.:+(73)
    val newArr2 = arr2.+:(73)
    val newArr3 = arr2 :+ 73
    val newArr4 = 73 +: 73 +: 73 +: 73 +: arr2
    println(arr2.mkString("-"))
    println(newArr2.mkString("-"))
    println(newArr1.mkString("-"))
    println(newArr3.mkString("-"))
    println(newArr4.mkString("-"))
  }
}