package lee.study.scala.oop

object Extends{
  def main(args: Array[String]): Unit = {
    val ex = new Student1("name", 77,"888")
//    val ex1 = new Student1("888")
    ex.printInfo()
//    ex1.printInfo()
  }
}

class Extends {

}


class Student0{
  println("student   的构造器")
  var name:String = _
  var age: Int = _
  def this(name:String, age:Int){
    this()
    this.name = name
    this.age = age
  }
  def printInfo() = {
    println(s"${name}   ${age}")
  }
}
class Student1(name:String, age:Int) extends Student0{
  var stdNo: String = _
  println("Student1   的构造器")

  def this(name:String, age:Int,stdNo:String){
    this(name, age)
    this.stdNo = stdNo;
  }
//  def this(stdNo:String){
//    this()
//    this.stdNo = stdNo;
//  }
  override def printInfo(): Unit = {
    println(s"${name}   ${age}   ${stdNo}")
  }
}
