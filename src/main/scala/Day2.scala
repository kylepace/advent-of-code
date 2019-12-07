object Day2 {
  private val additionCode = 1
  private val terminalCode = 99

  def generateIntCode(noun: Int, verb: Int, codes: List[Int]): List[Int] =
    intCode(codes.updated(1, noun).updated(2, verb))

  def findOutput(output: Int, codes: List[Int]): (Int, Int) = {
    val rangesToCheck = generateTestPairs(100)
    rangesToCheck.map(r =>  (r._1, r._2, generateIntCode(r._1, r._2, codes).head)).filter(i => i._3 == output).map(r => (r._1, r._2)).head
  }

  def intCode(codes: List[Int]): List[Int] = intcode_h(codes, 0)

  private def generateTestPairs(max: Int): Seq[(Int, Int)] =
    for (i <- 0 until max; j <- 0 until max)
      yield (i, j)

  private def op(opcode: Int) = (x: Int, y: Int) =>
    if (opcode == additionCode) x + y
    else x * y

  @scala.annotation.tailrec
  private def intcode_h(codes: List[Int], index: Int): List[Int] = {
    val i = index * 4
    val opcode = codes(0 + i)
    if (opcode == terminalCode) codes
    else intcode_h(codes.updated(codes(3 + i), op(opcode)(codes(codes(1 + i)), codes(codes(2 + i)))), index + 1)
  }
}
