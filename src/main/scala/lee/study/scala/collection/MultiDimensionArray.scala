package lee.study.scala.collection

class MultiDimensionArray {

}
object MultiDimensionArray{
  def main(args: Array[String]): Unit = {
    // 1. 创建
    val array : Array[Array[Int]]  = Array.ofDim[Int](2,3)
    // 2. 访问元素
    array(0)(2) = 29
    array(1)(0) = 99
    for ( i <- 0 until array.length;j <- 0 until array(i).length){
      println(array(i)(j))
    }
    println("+===================")

    for ( i <-  array.indices;j <-  array(i).indices){
      print(array(i)(j) +"\t")
      if (j==array(i).length -1) println()
    }

    array.foreach(arr =>{
      arr.foreach(i=>print(i + " "))
      println()
    })

  }
}
