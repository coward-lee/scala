package lee.study.scala

/**
 * 1. 隐式函数
 *
 * 2. 隐式参数
 *  普通方法或者函数的参数可以通过implicit关键字声明为隐式参数，该方法调用时，
 *  就可以传入该参数，编译器会在相应的作用域寻找符合条件的隐式值
 *  同一作用域只能有一个隐式类
 * 3. 隐式类
 *  类的构造方法声明成为一个implicit
 *
 */
object ImplicitDemo {
  def main(args: Array[String]): Unit = {
    // 隐式函数
    implicit def convert(num: Int): MyRichInt = new MyRichInt(num)
    println(12.myMax(145))

    // 隐式类
    implicit class  MyRichIn2t(val self:Int){
      // 自定义的比较大小的方法
      def myMax2(n:Int):Int = if (n< self) self else n
      def myMin2(n:Int):Int = if (n< self) n else self
    }
    println(12.myMax2(145))

    // 隐式参数

    def sayHello(name : String = "alice" ):Unit = {
      println("hello，"+name)
    }
    sayHello()
    sayHello("???")
    // 同意作用域，同一类型只能有一个隐式值
    implicit val nnn : String = "implict demo"
    implicit val num : Int = 222
    def sayHi(implicit name : String  ):Unit = {
      println("hi，"+name)
    }
    sayHi("??")
//    sayHi()
    sayHi
    def sayAge(implicit name : Int  ):Unit = {
      println("hi，"+name)
    }
    sayAge
    def sayIm() = {
      println("hi, " + implicitly(Int))
    }
    sayIm()


  }


}

class  MyRichInt(val self:Int){
  // 自定义的比较大小的方法
  def myMax(n:Int):Int = if (n< self) self else n
  def myMin(n:Int):Int = if (n< self) n else self
}