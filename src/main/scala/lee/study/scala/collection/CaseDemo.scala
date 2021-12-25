package lee.study.scala.collection

// 模式匹配
object CaseDemo {
  def main(args: Array[String]): Unit = {

    // 常量匹配
    def describe(x: Any) :String = x match{
      case "char" => "char[]"
      case "String" => "Stringxxxx"
      case 1 => "Int"
      case 2 => "List"
      case 3 => "Set"
      case _ => "default"
    }
    print(describe(2))
    print(describe("xxxxxxxxxxxxx"))

    // 类型匹配
    def typeDesc(x:Any):String = x match {
      case s:String => "String " + s
      case i:Int => "Int :"+i
      case list:List[String] => " List " + list
      case a => "default " + a
    }

    println(typeDesc("xxx"))
    println(typeDesc(111))
    println(typeDesc(List("ListString")))
    // 只有list String会被擦除
    println(typeDesc(List(1111,222)))
    println(typeDesc(Set("xxx")))

    // 方式一
    for ( list <- List(
      List(0),
      List("0"),
      List('0'),
      List(0,1),
      List(0,1,2),
      List(0,1,0),
      List(0,1,2,3),
      List(0,1,2,3,4),
      List(0,1,2,3,4,5)
    )){
      val result = list match {
        case List(0) => "0"
        case List(x,y) => "List(x,y)"
        case List(0,_*) => "List(0,_*)"
        case List(a) => "List(a)"
        case _ => "default"
      }
      println(result)
//      println(result(List("aa")))
//      println(result(List(1,2)))
//      println(result(List("xx")))
    }
    // 方式二
    val list = List(1, 2, 4, 7, 24)

    list match {
      case first :: second :: rest => println(s"firsrt : $first,second: $second,rest: $rest")
      case _ => println(" else ")
    }

    // 元组匹配
    for( tuple <- List(
      (0,1),
      (0,1,2),
      (2,2),
      (1,1,3,5)
    )){
      val  result = tuple match {
        case (a,b) => "" + a + "," + b
        case (0, _) => "(0,_)"
        case (a,1,_)=>"(a,1,_) "+ a
        case _ => " default"
      }
      println(result)
    }

    // 1. 元组声明
    val (x, y) = (10, " hello ")
    println(s"x:$x y: $y")
    val List(first, second, _*) = List(23,15,9,78)
    println(s"x:$first y: $second")

    val fir::sec::rest = List(23,15,9,78)
    println(s"x:$fir y: $sec, rest:$rest")

    // 2. for 推导式声明
    val list01:List[(String,Int)] = List(("a", 12), ("b", 23), ("c", 45), ("a", 45))
    // 遍历1
    for(elem <- list01){
      println(elem._1 + "  " + elem._2)
    }
    // 遍历2 将list定义为元组，对变量赋值
    for((word,count)<- list01){
      println(word +"  " +count)
    }
    // 只遍历一个位置的内容
    for((word,_)<- list01){
      println(word)
    }
    for(("a",count)<- list01){
      println(count)
    }

  }

}
