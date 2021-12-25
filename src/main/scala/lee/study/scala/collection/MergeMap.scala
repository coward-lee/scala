package lee.study.scala.collection

import scala.collection.mutable

object MergeMap {
  def main(args: Array[String]): Unit = {
    val map1 = Map("a" -> 1, "b" -> 3, "c" -> 6)
    val map2 = mutable.Map("1" -> 6, "b" -> 2, "d" -> 5)

    val map3 = map1.foldLeft(map2)(
      (mergeMap, kv) => {
        val key = kv._1
        val value = kv._2
        mergeMap(key) = mergeMap.getOrElse(key,0) + value
        mergeMap
      }
    )
    println(map3)
  }
}
