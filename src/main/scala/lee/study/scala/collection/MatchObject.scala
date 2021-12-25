package lee.study.scala.collection

object MatchObject {
  def main(args: Array[String]): Unit = {
    val student = new Student("sss", 19)
    val result = student match {
      case Student("sss",18) => "sss , 18"
      case _ => "else"
    }
    println(result)

    val student1 = new Student1("sss", 18)
    val result1 = student1 match {
      case Student1("sss",18) => "sss , 18"
      case _ => "else"
    }
    println(result1)
  }

}
class Student(val name:String, val age:Int)

object Student{
  var name:String = _
  var age:Int = _

  def apply(name:String, age:Int): Student = new Student(name, age)

  def unapply(student: Student):Option[( String, Int)] = {
    if (student == null){
      None
    }else{
      Some((student.name, student.age))
    }
  }
}
// 样例类
case class Student1(name:String, age:Int)
