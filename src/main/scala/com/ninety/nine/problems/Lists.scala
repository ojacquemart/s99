package com.ninety.nine.problems

import common._

object Lists {

  def last(xs: List[Int]) = xs.reverse.head

  def penultimate(xs: List[Int]) = xs.reverse.tail.head

  def nth(n: Int, xs: List[Int]) = xs(n)

  def length(xs: List[Int]) = xs.size

  def reverse(xs: List[Int]) = xs.reverse

  def isPalindrome(xs: List[Int]) = xs.reverse == xs

  def flatten(xs1: List[Any]): List[Any] = {
    xs1 flatMap {
      case ms: List[_] => flatten(ms)
      case e => List(e)
    }
  }

  def compress(xs: List[Symbol]): List[Symbol] = xs match {
    case Nil => List()
    case x :: tail => x :: compress(tail dropWhile (_ == x))
  }

  def pack(xs: List[Symbol]): List[List[Symbol]] = {
    if (xs.isEmpty) List(List())
    else {
      val (span, tail) = xs span { _ == xs.head }
      if (tail.isEmpty) List(span)
      else span :: pack(tail)
    }
  }

  def encode(xs: List[Symbol]): List[(Int, Symbol)] = {
    pack(xs) map (x => (x.size, x.head))
  }

  def encodeModified(xs: List[Symbol]): List[Any] = {
    encode(xs) map (x => if (x._1 == 1) x._2 else x)
  }

  def decode(xs: List[(Int, Symbol)]): List[Symbol] = {
    xs flatMap (x => List.fill(x._1)(x._2))
  }

  def encodeDirect(xs: List[Symbol]): List[(Int, Symbol)] = encode(xs)

  def duplicate(xs: List[Symbol]): List[Symbol] = {
    xs flatMap (x => List(x, x))
  }

  def duplicateN(n: Int, xs: List[Symbol]): List[Symbol] = {
    xs flatMap (x => List.fill(n)(x))
  }

  def drop(n: Int, xs: List[Symbol]): List[Symbol] = {
    ???
  }

  def split(n: Int, xs: List[Symbol]): (List[Symbol], List[Symbol]) = {
    ???
  }

  def slice(start: Int, end: Int, xs: List[Symbol]): List[Symbol] = {
    ???
  }

  def rotate(n: Int, xs: List[Symbol]): List[Symbol] = {
    ???
  }
  
  def removeAt(n: Int, xs: List[Symbol]): (List[Symbol], List[Symbol]) = {
    ???
  }
}