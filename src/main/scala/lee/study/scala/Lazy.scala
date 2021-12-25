package lee.study.scala

// 函数的惰性加载
class Lazy {

}
object Lazy{
  def main(args: Array[String]): Unit = {
    lazy val re = sum(22,33)
    println("main")
    println(re)
  }
  def sum(n1:Int , n2:Int):Int = {
    println("sum+++++")
    n1+n2
  }
}