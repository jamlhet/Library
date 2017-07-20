package com.uniandes.library

/**
  * Created by juan on 17/07/17.
  */
object Main extends App{
  println("Hola mundo")
  val left = new MyEmptySet[Int]
  val right = new MyEmptySet[Int]
  val first = new MyNonEmptySet[Int](1,left,right)
  println(s"Contains ${first.contains(1)}")
  first.insert(2)
  println(s"Contains ${first.contains(2)}")
}