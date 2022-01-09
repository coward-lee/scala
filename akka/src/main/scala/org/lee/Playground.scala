package org.lee

import akka.actor.ActorSystem

object Playground extends App {
  println("???")
  val actor = ActorSystem("aaa")
  println(actor.name)
}
