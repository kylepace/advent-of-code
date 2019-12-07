import org.scalatest.FlatSpec

import scala.io.Source


/*
  1,0,0,0,99 becomes 2,0,0,0,99 (1 + 1 = 2).
  2,3,0,3,99 becomes 2,3,0,6,99 (3 * 2 = 6).
  2,4,4,5,99,0 becomes 2,4,4,5,99,9801 (99 * 99 = 9801).

  1,1,1,4,99,5,6,0,99 becomes 30,1,1,4,2,5,6,0,99.
*/

class Day2Spec extends FlatSpec {
  "intcode" should "handle addition" in {
    val input = List(1, 0, 0, 0, 99)
    val response = Day2.intCode(input)
    assert(response == List(2, 0, 0, 0, 99))
  }

  "intcode" should "handle multiplication" in {
    val input = List(2, 3, 0, 3, 99)
    val response = Day2.intCode(input)
    assert(response == List(2, 3, 0, 6, 99))
  }

  "intcode" should "handle multiplication with indexes outside top 4" in {
    val input = List(2, 4, 4, 5, 99, 0)
    val response = Day2.intCode(input)
    assert(response == List(2, 4, 4, 5, 99, 9801))
  }

  "intcode" should "handle more than one pass-through" in {
    val input = List(1, 1, 1, 4, 99, 5, 6, 0, 99)
    val response = Day2.intCode(input)
    assert(response == List(30, 1, 1, 4, 2, 5, 6, 0, 99))
  }

  "calculate part 1 solution" should "return correct result" in {
    val day2File = Source.fromURL(getClass.getResource("Day2Input.txt"))
    val intcodes = day2File.getLines.mkString.split(",").map(_.toInt).toList
    day2File.close

    val result = Day2.generateIntCode(12, 2, intcodes)
    assert(result.head == 4930687)
  }

  "calculate part 2 solution" should "return correct noun verb tuple" in {
    val day2File = Source.fromURL(getClass.getResource("Day2Input.txt"))
    val intcodes = day2File.getLines.mkString.split(",").map(_.toInt).toList
    day2File.close

    val result = Day2.findOutput(19690720, intcodes)
    assert(result._1 == 53)
    assert(result._2 == 35)
    assert((100 * result._1 + result._2) == 5335)
  }
}
