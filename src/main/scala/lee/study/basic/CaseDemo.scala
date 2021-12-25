package lee.study.basic;

case class CaseDemo (var name:String, var age:Int)
object test{
  def main(args: Array[String]): Unit = {
    println(CaseDemo("aaa",123))
  }
}

