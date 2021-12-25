
package lee{
  object Outer{
    var out:String = "out";
  }
  package study{
    package scala{
      object Inner{
        def main(args: Array[String]): Unit = {
          println(Outer.out)
          Outer.out = "inner"
          println(Outer.out)
        }
      }
    }
  }
}