package lee.study.scala.oop

/**
 * 自身类型
 */
object SelfType {
  def main(args: Array[String]): Unit = {
    val user = new Register("xxx", "xxx")
    user.insert()
  }
}
class User(val name:String, val password:String)
class User0(val name:String)
trait Dao{
  // 可以理解为注入一个对象，但是这个对象的属性需要通过this去互殴去因为 _  表示this
  // 这样声明自身是User类
  _:User =>
  // 自身类型不能为多个
//  _:User0 =>

  def insert():Unit = {
    print(s"insert ${this.name} ${this.password}")
  }
}
class Register(name:String, password:String) extends User(name:String, password:String) with Dao