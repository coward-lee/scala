package lee.study.scala.oop

/**
 * trait 可以直接使用 extends 直接继承，
 * scala 也只能单继承多实现 实现使用关键字 with
 *
 *  菱形继承的情况
 *  钻石问题特征叠加
 *  从右到左的叠加顺序
 *
 */

object TraitDemo{
  def main(args: Array[String]): Unit = {
    val ti = new TraitImpl
    ti.play()

    // 特征的混入
    val tt = new TraitImpl with Talent{
      override def sing(): Unit = {
        println("sing")
      }

      override def dance(): Unit ={
        println("dance")
      }

      override def multi(): Unit = super.multi()
    }
    tt.play()
    tt.sing()
    tt.dance()

    val tt2 = new TraitImpl2
    tt2.multi()

    val myFootBall = new MyFootBall
    println(myFootBall.describe())
  }
}


trait TraitPerson{
  val demo = "trait demo"
  val name = "trait name"
  def play():Unit

}
trait Talent {
  def sing(): Unit

  def dance(): Unit

  def multi(): Unit = {
    println(" Talent multi")
  }
}


trait Skill{

  def multi():Unit = {
    println(" Skill multi")
  }
}

class TraitImpl extends TraitPerson {
  override val demo: String = "impl demo"
  override def play(): Unit = {
    println(s"demo：${demo}   demo:${name}")
  }
  def multi(): Unit = {
    println(" TraitImpl multi")
  }
}

// 直接with不行
// 在重写方法的时候，出现父类/特征对某一个属性或者方法实现了 会使用最后一个
// 原则就是从右往左叠加
class TraitImpl2 extends Object with Talent with Skill {
  override def sing(): Unit = {
    println("sing")
  }

  override def dance(): Unit ={
    println("dance")
  }

  override def multi(): Unit = {
    super.multi()
    println("TraitImpl2 multi")
  }
}


/**
 *  菱形继承的情况
 *  钻石问题特征叠加
 *  从右到左的叠加顺序
 */

trait Ball{
  def describe(): String = "ball"
}

trait ColorBall extends Ball{
  val color:String = "black-and-white"
  override def describe(): String = {
    color+"-" + super.describe()
  }
}
trait CategoryBall extends Ball{
  var category:String = "foot"
  override def describe(): String = {
    category+"-"+super.describe()
  }
}
// 定义一个自定义球
class MyFootBall extends CategoryBall with ColorBall{
  override def describe(): String = "my" + "-" + super.describe
}
