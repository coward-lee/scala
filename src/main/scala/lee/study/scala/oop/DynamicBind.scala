package lee.study.scala.oop

/**
 * 方法和成员（但是变量的成员变量不能被重写）
 * 都会被动态绑定
 *
 */
class DynamicBind {

}
object DynamicBind{
  def main(args: Array[String]): Unit = {
    var p = new Person8
    p.p()
    var s = new Student8
    s.p()
  }
}

class Person8{
  // 可变的变量不能被重写
//  var name:String = "person"
  val name = "？？？"
  def p()={
    println(s"${name} +++")
  }
}
class Student8 extends Person8 {
  // 可变的变量不能被重写
  //  override var name:String = "student"
  override val name = "xxxx"
  override def p()={
    println(s"${name} ---")
  }
}