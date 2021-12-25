package lee.study.scala

class ControlAbstract {

}
// 控制抽象
object ControlAbstract{
  def main(args: Array[String]): Unit = {
    // 传值参数
    def f0(a:Int):Unit = {
      println("a："+a)
      println("a："+a)
    }
    f0(23)

    def f1():Int = {
      println("f1调用")
      12
    }
    f0(f1())
    println("====================")
    // 传递代码块
    // ()=>Int 表示传递的返回值为Int的代码块
    def f2(a: =>Int) :Unit = {
      println(a + ":a")
      println(a + ":a")
    }
    f2(23)
    f2(f1())




  }
}
