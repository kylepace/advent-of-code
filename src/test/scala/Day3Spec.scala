import org.scalatest.FlatSpec
import scala.io.Source

class Day3Spec extends FlatSpec {
  "place wire strand" should "place wire to the right from start" in {
    val result = Day3.placeWireStrand(Point(0,0), "R4")
    assert(result.contains(Point(0, 1)))
    assert(result.contains(Point(0, 2)))
    assert(result.contains(Point(0, 3)))
    assert(result.contains(Point(0, 4)))
  }

  "place wire strand" should "place wire to the left from start" in {
    val result = Day3.placeWireStrand(Point(0,0), "L4")
    assert(result.contains(Point(0, -1)))
    assert(result.contains(Point(0, -2)))
    assert(result.contains(Point(0, -3)))
    assert(result.contains(Point(0, -4)))
  }

  "place wire strand" should "place wire up from start" in {
    val result = Day3.placeWireStrand(Point(0,0), "U4")
    assert(result.contains(Point(1, 0)))
    assert(result.contains(Point(2, 0)))
    assert(result.contains(Point(3, 0)))
    assert(result.contains(Point(4, 0)))
  }

  "place wire strand" should "place wire down from start" in {
    val result = Day3.placeWireStrand(Point(0,0), "D4")
    assert(result.contains(Point(-1, 0)))
    assert(result.contains(Point(-2, 0)))
    assert(result.contains(Point(-3, 0)))
    assert(result.contains(Point(-4, 0)))
  }

  "place wires" should "place three wires in order" in {
    val result = Day3.placeWires(List("U2", "R2", "D2"))
    assert(result.contains(Point(1, 0)))
    assert(result.contains(Point(2, 0)))

    assert(result.contains(Point(2, 1)))
    assert(result.contains(Point(2, 2)))

    assert(result.contains(Point(1, 2)))
    assert(result.contains(Point(0, 2)))
  }

  "get manhattan distance" should "get correct manhattan distance" in {
    val firstWire = Day3.placeWires(List("R8", "U5", "L5", "D3"))
    val secondWire = Day3.placeWires(List("U7", "R6", "D4", "L4"))
    val result = Day3.getManhattanDistance(firstWire, secondWire)

    assert(result == 6)
  }

  "calculate total manhattan distance" should "return my personal puzzle result" in {
    val day3File = Source.fromURL(getClass.getResource("Day3Input.txt"))
    val wires = day3File.getLines().map(s => s.split(',').toList).toList
    val firstWire = Day3.placeWires(wires.head)
    val secondWire = Day3.placeWires(wires.last)

    val result = Day3.getManhattanDistance(firstWire, secondWire)

    assert(result == 529)
  }

  "calculate step distance" should "return fewest steps to intersection" in {
    val firstWire = Day3.placeWires(List("R8", "U5", "L5", "D3"))
    val secondWire = Day3.placeWires(List("U7", "R6", "D4", "L4"))

    assert(Day3.getFewestSteps(firstWire, secondWire) == 30)
  }

  "calculate step distance" should "return my personal puzzle results" in {
    val day3File = Source.fromURL(getClass.getResource("Day3Input.txt"))
    val wires = day3File.getLines().map(s => s.split(',').toList).toList
    val firstWire = Day3.placeWires(wires.head)
    val secondWire = Day3.placeWires(wires.last)

    assert(Day3.getFewestSteps(firstWire, secondWire) == 30)
  }
}
