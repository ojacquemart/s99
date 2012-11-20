package com.ninety.nine.problems.test

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ListsSuite extends FunSuite {

  // http://aperiodic.net/phil/scala/s-99/

  import com.ninety.nine.problems.Lists._

  test("P01 (*) Find the last element of a list.") {
    assert(last(List(1, 2, 3)) == 3)
    assert(last(List('x')) == 'x')
    assert(last(List(1, 1, 2, 3, 5, 8)) == 8)
  }

  test("P02 (*) Find the last but one element of a list.") {
    assert(penultimate(List(1, 1, 2, 3, 5, 8)) === 5)
  }

  test("P03 (*) Find the Kth element of a list.") {
    assert(nth(2, List(1, 1, 2, 3, 5, 8)) === 2)
  }

  test("P04 (*) Find the number of elements of a list.") {
    assert(length(List(1, 1, 2, 3, 5, 8)) === 6)
  }

  test("P05 (*) Reverse a list.") {
    assert(reverse(List(1, 1, 2, 3, 5, 8)) === List(8, 5, 3, 2, 1, 1))
  }

  test("P06 (*) Find out whether a list is a palindrome.") {
    assert(isPalindrome(List(1, 2, 3, 2, 1)) === true)
  }

  test("P07 (**) Flatten a nested list structure.") {
    assert(flatten(List(List(1, 1), 2, List(3, List(5, 8)))) === List(1, 1, 2, 3, 5, 8))
  }

  test("P08 (**) Eliminate consecutive duplicates of list elements.") {
    assert(compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) === List('a, 'b, 'c, 'a, 'd, 'e))
  }

  test("P09 (**) Pack consecutive duplicates of list elements into sublists.") {
    assert(pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) === List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e)))
  }

  test("P10 (*) Run-length encoding of a list.") {
    assert(encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) === List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
  }

  test("P11 (*) Modified run-length encoding.") {
    assert(encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) === List((4, 'a), 'b, (2, 'c), (2, 'a), 'd, (4, 'e)))
  }

  test("P12 (**) Decode a run-length encoded list.") {
    assert(decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))) === List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  }

  test("P13 (**) Run-length encoding of a list (direct solution).") {
    assert(encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) === List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
  }

  test("P14 (*) Duplicate the elements of a list.") {
    assert(duplicate(List('a, 'b, 'c, 'c, 'd)) === List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd))
  }

  test("P15 (**) Duplicate the elements of a list a given number of times.") {
    assert(duplicateN(3, List('a, 'b, 'c, 'c, 'd)) === List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd))
  }

  test("P16 (**) Drop every Nth element from a list.") {
    assert(drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) === List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k))
  }

  test("P17 (*) Split a list into two parts.") {
    assert(split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) === (List('a, 'b, 'c), List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
  }

  test("P18 (**) Extract a slice from a list.") {
    assert(slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) == List('d, 'e, 'f, 'g))
  }

  test("P19 (**) Rotate a list N places to the left.") {
    assert(rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) === List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c))
    assert(rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) === List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i))
  }

  test("P20 (*) Remove the Kth element from a list.") {
    assert(removeAt(1, List('a, 'b, 'c, 'd)) === (List('a, 'c, 'd), 'b))
  }

  test("P21 (*) Insert an element at a given position into a list.") {
    assert(insertAt('new, 1, List('a, 'b, 'c, 'd)) === List('a, 'new, 'b, 'c, 'd))
  }

  test("22 (*) Create a list containing all integers within a given range.") {
    assert(range(4, 9) === List(4, 5, 6, 7, 8, 9))
  }

  test("P23 (**) Extract a given number of randomly selected elements from a list. Hint: Use the solution to problem P20.") {
//    assert(randomSelect(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h)) === List('e, 'd, 'a))
    // Not testable cause of random...
  }

  test("P24 (*) Lotto: Draw N different random numbers from the set 1..M.") {
//    assert(lotto(6, 49) === List(23, 1, 17, 33, 21, 37))
    // Not testable cause of random...
  }

  test("P25 (*) Generate a random permutation of the elements of a list. Use the solution of problem P23.") {
//    assert(randomPermute(List('a, 'b, 'c, 'd, 'e, 'f)) === List('b, 'a, 'd, 'c, 'e, 'f))
     // Not testable cause of random...
  }

  test("P26 (**) Generate the combinations of K distinct objects chosen from the N elements of a list.") {
    // In how many ways can a committee of 3 be chosen from a group of 12 people? We all know that there are C(12,3) = 220 possibilities (C(N,K) denotes the well-known binomial coefficient). For pure mathematicians, this result may be great. But we want to really generate all the possibilities.
    val c1 = combinations(1, List('a,'b,'c))
    val a1 = List(List('a), List('b), List('c))
    assert(c1.length == a1.length && c1.toSet == a1.toSet)
  }

  test("P27 (**) Group the elements of a set into disjoint subsets.") {
    //assert(group3(List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida")) === List(List(List("Aldo", "Beat"), List("Carla", "David", "Evi"), List("Flip", "Gary", "Hugo", "Ida"))))
    // TODO: do later.
  }

  test("P28 (**) Sorting a list of lists according to length of sublists.") {
    assert(lsort(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o))) ===  List(List('o), List('d, 'e), List('d, 'e), List('m, 'n), List('a, 'b, 'c), List('f, 'g, 'h), List('i, 'j, 'k, 'l)))
  }

}