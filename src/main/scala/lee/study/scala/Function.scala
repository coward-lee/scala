package lee.study.scala

class Function{

}
object Function{


  def sum(x: Int , y :Int) : Int = {
    x + y
  }

  // 2. 定义二元计算函数,函数定义和数据都是参数
  // op:(Int, Int)=>Int  这个是一个整体， a,b 又是两个部分
  def dualEval(op:(Int, Int)=>Int, a: Int, b :Int):Int = {
    op(a,b)
  }
  // 函数作为返回值 Int=>Unit 表示返回Int映射到Unit的函数，有了这个声明就可以返回函数本身
  def returnFun(): Int=>Unit ={
    def f0(a:Int) :Unit = {
      print("函数的函数，在函数返回中"+a)
    }
    f0 // (明确某种)
  }



  def main(args: Array[String]): Unit = {
    print("xxxxxx")
    print(sum(1,2))



    def func2(i:Int)(s:String)(c:Char) :Boolean = {
      if (i == 0  && s == "" && c == '0') false else true
    }
    println(func2(0)("")('0'))
    println(func2(0)("")('1'))
    println(func2(2)("")('0'))
    println(func2(0)("111")('0'))

    // 闭包
    // 这个涉及到跨越问题
    def func(i :Int):String => (Char=>Boolean) = {
      def f1(s:String):Char =>Boolean = {
        def f2(c:Char):Boolean = {
          if (i == 0  && s == "" && c == '0') false else true
        }
        f2
      }
      f1
    }

    def add(a:Int,b :Int):Int= a+b
    // 固定一个参数的情况
    def addByFour(b:Int):Int = 4+b
    def addByFive(b:Int):Int = 4+b

    // 闭包???
    // 将固定参数传入，但是作为第一层传入
//    def addByFour2():Int =>Int ={
//      val a = 4
//      def addB(b:Int):Int = {
//        a+b
//      }
//      addB
//    }
//    def addByFour2(a:Int):Int =>Int ={
//      def addB(b:Int):Int = {
//        a+b
//      }
//      addB
//    }

//    def addByFive2():Int =>Int ={
//      val a = 5
//      def addB(b:Int):Int = a+b
//      addB
//    }
    // 闭包=====================
    def addByAny(a : Int):Int =>Int ={
      def addB(b:Int):Int = a+b
      addB
    }
    println(addByAny(35)(45))
    println(addByAny(35)(45))
    println(addByAny(35)(45))







  }


}