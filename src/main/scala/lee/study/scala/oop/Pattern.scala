package lee.study.scala.oop

object PatternDemo{

  def main(args: Array[String]): Unit = {
    var p = new Pattern
    p.printInfo()
  }
}

class Pattern {
  var name = "类里面的内容"

  def this(name:String){
    this()
    this.name = name
  }

  def printInfo() = {
    println(s"class info ${Pattern.code} $name")
  }
}

// 而object 我们就暂时认为为是一个单例对象？
// 在伴生对象里面的属性和方法都可以视为静态方法或者静态属性
object Pattern{
  var code:String = "伴生对象里面的内容"

  // 在实例化的时候 使用 Pattern(args...)的时候相当于调用了伴生对象的apply方法
  def apply(): Pattern = new Pattern()
  def apply(name: String): Pattern = new Pattern(code)
}