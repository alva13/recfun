package recfun

import scala.annotation.tailrec

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {
      if (c==0||c==r) 1
      else pascal(c,r-1) + pascal(c-1,r-1)
    }
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      def loop(acc: Int, chars: List[Char]): Boolean =
        if (acc < 0 || (chars.isEmpty && acc!=0)) false
        else if (chars.isEmpty && acc==0) true
        else loop(if (chars.head == '(') acc + 1 else if (chars.head == ')') acc - 1 else acc, chars.tail)
    loop(0,chars)
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
      if (coins.tail.isEmpty) if (money % coins.head == 0) 1 else 0
      else if (money == 0) 1
      else if (money < 0) 0
      else countChange(money, coins.tail) + countChange(money - coins.head, coins)
    }
  }
