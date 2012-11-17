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
		assert(encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) === List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e)))
	}
	
	test("P12 (**) Decode a run-length encoded list.") {
		assert(decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))) === List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
	}
	
	test("P13 (**) Run-length encoding of a list (direct solution).") {
		assert(encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) === List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e)))
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
		assert(split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) === (List('a, 'b, 'c),List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
	}
	
	test("P18 (**) Extract a slice from a list.") {
		assert(slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) == List('d, 'e, 'f, 'g))
	}
	
	test("P19 (**) Rotate a list N places to the left.") {
		assert(rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) === List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c))
		assert(rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) === List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i))
	}
	
	test("P20 (*) Remove the Kth element from a list.") {
		assert(removeAt(1, List('a, 'b, 'c, 'd)) === (List('a, 'c, 'd),'b))
	}

}