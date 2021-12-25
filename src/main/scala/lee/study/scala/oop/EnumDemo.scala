package lee.study.scala.oop

class EnumDemo {

}

/**
 * 对象应用类
 */
object EnumDemo extends App {
  println("app start")
}

object EnumDemo1 extends Enumeration{
  val MONDAY = Value(1,"monday")
  val TUESDAY = Value(1,"tuesday")
}