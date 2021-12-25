package lee.study.scala.collection

object WordCountPlus {
  def main(args: Array[String]): Unit = {
    val stringList :List[(String,Int)] = List(
      ("hello",2),
      ("hello world",2),
      ("hello spark",3),
      ("hello flink",5),
      ("hello spark from scala",1),
      ("hello flink from scala",3)
    )
    // 简单版本
    val sList = stringList.map(kv=>{
      (kv._1.trim +" ") * kv._2
    })
    val sList1 = sList.flatMap(_.split(" "))


    val value = sList1.groupBy(s => s)
      .map(kv => (kv._1, kv._2.length))
      .toList
      .sortBy(_._2)
    println(value)


    // 思路二，利用预统计的结果

    val result = stringList.flatMap(
      tuple =>{
        tuple._1.split(" ")
          .groupBy( s => s )
          .toList
          .map(kv =>(kv._1, kv._2.length * tuple._2))
      }
    )
    val retList = result.groupBy(item => item._1)

    println(result)
    println(retList)

    val value1 = retList.mapValues(
      li => li.map(_._2).sum
    ).toMap

    val value2 = value1.toList.sortWith(_._2 > _._2)
    print(value2)

//
//    val value3:ParSeq[Long] = (1 to 100).par.map(
//      x => Thread.currentThread.getId
//    )
//    print(value3)

  }
}
