package lee.study.scala.collection

import scala.collection.mutable.ArrayBuffer


/**
 * 推荐不可变类型改变使用符号
 * 可变使用函数调用的形式
 */
class ArrayBufferDemo {

}
object ArrayBufferDemo{
  def main(args: Array[String]): Unit = {
    // 1. 创建
    val arr1: ArrayBuffer[Int] = new ArrayBuffer[Int]
    val arr2 = ArrayBuffer(23,22,25,25,267)
    val arr3 = ArrayBuffer(23,22,25,25,267)
    println(arr1.mkString(","))
    println(arr2.mkString("x"))
    // 2. 访问
    arr1  += 39
    println(arr2(0))
    // 3. 遍历同不变数组一样
    val newArr1 = arr1 :+ 15
    val newArr2 = 16 +: arr1
    println(newArr1.mkString(","))
    println(newArr2.mkString(","))
    println(newArr1 == arr1)

    // 添加
    // 往前和往后加
    val newArr3 = arr1 += 15
    val newArr4 = 16 +=: arr1
    println(newArr3.mkString(","))
    println(arr1 == newArr3)

    println(newArr3.mkString(","))
    println(arr1 == newArr3)
    println(newArr4.mkString(","))
    println(newArr4 == arr1)
    arr1.prepend(111)
    arr1.append(222)
    arr1.insert(2,223232)
    println(arr1.mkString("-"))

    // 删除
    // 都是按照索引来删除的
    arr1.remove(2)
    println(arr1.mkString("-"))
    arr1.remove(0,2)
    println(arr1.mkString("-"))
    arr1-=15
    println(arr1.mkString("-"))


    // 可变->不可变
    val arr: ArrayBuffer[Int] = ArrayBuffer(23,46,98)
    val newArr = arr.toArray
    // 不可变到可变
    val arrImmutable = Array(11,22,44,55,66)
    val buffer = arrImmutable.toBuffer




  }
}
