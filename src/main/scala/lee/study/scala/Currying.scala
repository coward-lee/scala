package lee.study.scala

class Currying {

}
object Currying{
  // 就是吧原来的函数列表（a,b,c,...）转化成列表函数(a)(b)(c)...
  def main(args: Array[String]): Unit = {
    def addCurrying(a:Int)(b:Int):Int = {
      a+b
    }
    def addNoncurrying(a:Int, b:Int):Int = {
      a+b
    }
  }
}
