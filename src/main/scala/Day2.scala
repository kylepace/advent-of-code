object Day2 {
  private val additionCode = 1
  private val terminalCode = 99

  def intCode(codes: List[Int]): List[Int] = intcode_h(codes, 0)

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
