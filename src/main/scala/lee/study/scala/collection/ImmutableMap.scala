package lee.study.scala.collection

object ImmutableMap {
  def main(args: Array[String]): Unit = {
    // 1. 创建map
    val map1: Map[String, Int]= Map("a"->13, "b"->23, "hello"->1)
    println(map1)
    println(map1.getClass)

    // 2. 遍历元素
    map1.foreach(println)
    map1.foreach((kv:(String , Int)) => println(kv))

    println("=====================================================")
    // 3. 取map中所有的key或者value
    for(key <- map1.keys){
      println(s"$key  -----> ${map1.get(key)}")
    }
    // 4. 访问一个元素
    println(map1.get("a").get)
    println(map1.get("a"))
    println(map1.getOrElse("a", "xxx" -> 0))
    println(map1("a"))
    // 由于不可变不能调用put方法
  }
}
