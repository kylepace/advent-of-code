object Day4 {
  def passesDoubleTest(int: Int): Boolean =
    int.toString.toCharArray.map(c => c.toInt).toList.sliding(2).exists(i => i.head == i.last)

  def passesIncreasingTest(int: Int): Boolean =
    int.toString.toCharArray.map(c => c.toInt).toList.sliding(2).forall(i => i.head <= i.last)

  def countPossiblePasswords(passwords: List[Int]): Int =
    passwords
      .filter(p => passesDoubleTest(p))
      .count(p => passesIncreasingTest(p))
}
