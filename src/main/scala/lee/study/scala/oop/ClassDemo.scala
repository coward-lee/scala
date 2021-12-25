package lee.study.scala.oop

import scala.beans.BeanProperty


/**
 * [修饰符] class  类名{
 *  类体
 * }
 * 默认为public，但是不能手动指定public属性，可以指定其他属性
 */

class ClassDemo {


}
object ClassDemo{
  def main(args: Array[String]): Unit = {
    val student = new Student()
//    student.name // error private 不能直接访问
    println(student.age)
    println(student.sex)
  }
}

class Student{

  // 定义属性和初值  同样不加为public，可以指定其他属性如private
  private val name : String = "scala"
  @BeanProperty   // getter 和 setter
  val age : Int = 18
  var sex : String = _ // 赋值为空值 null
}