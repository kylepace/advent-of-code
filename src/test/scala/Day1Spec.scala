import org.scalatest.FlatSpec
import scala.io.Source

class Day1Spec extends FlatSpec {
  "calculate module mass" should "return correct mass" in {
    assert(Day1.calculateModuleMass(100756) == 33583)
  }

  "calculate full fuel requirements" should "return correct total mass" in {
    val moduleMasses = List(12, 14, 1969, 100756)
    val expectedTotalMass = 34241
    assert(Day1.calculateFullFuelRequirements(moduleMasses) == expectedTotalMass)
  }

  "calculate unique puzzle fuel reqs" should "return my personal fuel reqs" in {
    val day1File = Source.fromURL(getClass.getResource("Day1Input.txt"))
    val moduleMasses = day1File.getLines().map(s => s.toInt).toList
    val expectedValue = 3391707
    day1File.close()

    assert(Day1.calculateFullFuelRequirements(moduleMasses) == expectedValue)
  }

  "calculate total fuel burn" should "return total recursive fuel needed" in {
    assert(Day1.calculateTotalModuleMass(14, 0) == 2)
    assert(Day1.calculateTotalModuleMass(1969, 0) == 966)
    assert(Day1.calculateTotalModuleMass(100756, 0) == 50346)
  }

  "calculate total unique puzzle fuel reqs" should "return my total personal fuel reqs" in {
    val day1File = Source.fromURL(getClass.getResource("Day1Input.txt"))
    val moduleMasses = day1File.getLines().map(s => s.toInt).toList
    val expectedValue = 5084676
    day1File.close()

    assert(Day1.calculateTotalFullFuelRequirements(moduleMasses) == expectedValue)
  }
}
