package lee.study.scala.oop

class InstanceOfDemo {

}
object InstanceOfDemo{
  def main(args: Array[String]): Unit = {
    val ppp = new ParentInstance
    val pp:ParentInstance = new ChildInstance
    println(pp.isInstanceOf[ParentInstance])
    println(pp.isInstanceOf[ChildInstance])
    println(ppp.isInstanceOf[ChildInstance])
//    ppp.o()
//    ppp.asInstanceOf[ChildInstance]
//    ppp.o()
    pp.o()
    print( classOf[ParentInstance])
    print( classOf[ChildInstance])
    pp.asInstanceOf[ParentInstance]
    pp.o()

  }
}

class ParentInstance{
  def o() = {
    println("parent")
  }
}
class ChildInstance extends ParentInstance{
  override def o(): Unit = {
    print("child")
  }
}
