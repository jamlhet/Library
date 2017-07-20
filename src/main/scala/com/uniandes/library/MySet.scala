package com.uniandes.library

/**
  * Created by juan on 17/07/17.
  */
abstract class MySet[T <% Ordered[T]] {
  def insert(x:T): MySet[T]
  def contains(x:T): Boolean
}

case class MyEmptySet[T <% Ordered[T]]() extends MySet[T]{
  override def contains(x: T): Boolean = false
  override def insert(x: T): MySet[T] =
    new MyNonEmptySet[T](
      x,
      new MyEmptySet[T],
      new MyEmptySet[T]
  )
}

case class MyNonEmptySet[T <% Ordered[T]](
                                       elem:T,
                                       left:MySet[T],
                                       right:MySet[T]
                                       )extends MySet[T]
{
  override def contains(x: T): Boolean = {
    if(x<elem)left.contains(x)
    else if (x>elem)right.contains(x)
    else true
  }

  override def insert(x: T): MySet[T] = {
    if (x<elem)new MyNonEmptySet[T](elem, left.insert(x), right)
    else if (x>elem)new MyNonEmptySet[T](elem,left,right.insert(x))
    else this
  }
}