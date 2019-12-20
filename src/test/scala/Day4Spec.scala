import org.scalatest.FlatSpec

class Day4Spec extends FlatSpec {
  "elf passcode double test" should "accept 111111" in {
    assert(Day4.passesDoubleTest(111111))
  }

  it should "not accept 123789" in {
    assert(!Day4.passesDoubleTest(123789))
  }

  "elf passcode increasing test" should "accept 111111" in {
    assert(Day4.passesIncreasingTest(111111))
  }

  it should "not accept 223450" in {
    assert(!Day4.passesIncreasingTest(223450))
  }

  "count possible passwords" should "return correct number of possible passwords" in {
    val possiblePasswords = List(111111, 223450, 123789)
    assert(Day4.countPossiblePasswords(possiblePasswords) == 1)
  }

  "count possible passwords" should "return correct puzzle solution" in {
    val passwordRange = (271973 to 785961).toList
    assert(Day4.countPossiblePasswords(passwordRange) == 5)
  }
}
