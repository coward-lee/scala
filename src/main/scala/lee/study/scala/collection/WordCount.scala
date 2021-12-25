package lee.study.scala.collection

object WordCount {
  def main(args: Array[String]): Unit = {
    val stringList :List[String] = List(
      "hello",
      "hello world",
      "hello spark",
      "hello flink",
      "hello spark from scala",
      "hello flink from scala"
    )

    // 扁平化
    val wordList = stringList.flatMap(_.split(" "))
    println(wordList)
    // 分组
    val wordMap:Map[String, List[String]] = wordList.groupBy(str => str)
    println(wordMap)
    // 计数
    val countMap:Map[String, Int] = wordMap.map(kv => (kv._1, kv._2.length))
    println(countMap)
    // 排序
    val sortList:List[(String, Int)] = countMap.toList.sortWith(_._2>_._2)
    println(sortList)
  }
}
