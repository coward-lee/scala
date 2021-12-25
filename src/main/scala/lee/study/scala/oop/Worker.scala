package lee.study.scala.oop

object Worker{
  def main(args: Array[String]): Unit = {
    val stu = new Worker1
    new Worker1("name")
    new Worker1(Array("xxx","xxx"))
    val s4 = new Student4(999)
    s4.printInfo()
  }
}

// 可以将 下面的整个class 的类容就是一个构造函数
class Worker1 {
  println("默认构造方法")
  def this(name:String){
    // 必须直接再第一行调用构造器
    this()
    println("构造方法1    "+name)
  }
  def this(name:Array[String]){
    this("aaaa")
    println("构造方法2")
  }
}
class Student4{
  var name:String = _
  var age:Int = _
  def this(age:Int){
    this()
    name = "???"
    this.age = age
  }
  def printInfo() = {
    println(s"student4: name={${name}}, $age")
  }
}