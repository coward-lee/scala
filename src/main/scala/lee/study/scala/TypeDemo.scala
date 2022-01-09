package lee.study.scala

object TypeDemo {
  def main(args: Array[String]): Unit = {
    // 1.协变和逆变
    val child: Parent = new Child
//     协变
        class MyCollection01[+T]{}
        val children: MyCollection01[Parent] = new MyCollection01[Child]
    // 逆变
    //    val children: MyCollection[SubChild] = new MyCollection[Child]
    //    class MyCollection[-T]{}
    // 不变
    //    class MyCollection[T]{}

    // 2. 泛型的上下限
    def test[A <: Child](a:A): Unit = {
      println(a.getClass.getName)
    }
    // Parent 超过了child
//    test[Parent](new Child)
    test[Child](new Child)
    test[Child](new SubChild)
    test[SubChild](new SubChild)
  }
}


class Parent{}

class Child extends Parent{}

class SubChild extends Child{}

class MyCollection[-T]{}

