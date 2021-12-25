package lee.study.scala.collection

class ListDemo {

}

object ListDemo{
  def main(args: Array[String]): Unit = {
    // 1.不能直接利用对象去创建，而是需要时用伴生对象去创建对象也就是那倒单例对象
    // 因为使用了 sealed 关键字 只能在当前文件下创建对象
    // sealed abstract class List[+A]  extends AbstractSeq[A]
    val list1 = List(22,22,33,445,66,7,8,9)
    println(list1.mkString("-"))
    list1.foreach(println(_))
    // 2.添加元素
    val list2 = 10 +: list1
    val list3 = list1 :+ 23
    println(list1)
    println(list2)
    println(list3)

    // 3.
    println("=========================")
    val list4 = list2.::(12,23,34,45,56)
    println(list4)

    val list5 = Nil.::(12,23,34,45,56)
    println(list5)

    val list6 = 32 :: 32 :: Nil
    val list7 = 17 :: 69 :: 22 :: Nil
    println(list6)
    println(list7)

    val list8 = list6 :: list7
    println(list8)
    val list9 = list6 ::: list7
    println(list9)
    val list10 = list6 ++ list7
    println(list10)
  }
}