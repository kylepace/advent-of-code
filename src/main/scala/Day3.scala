case class Point(x: Int, y: Int)

object Day3 {
  def placeWireStrand(start: Point, instruction: String): Vector[Point] = {
    val direction = instruction(0)
    val wireLength = instruction.substring(1).toInt

    (direction match {
      case 'R' => for (i <- start.y + 1 until wireLength + start.y + 1) yield Point(start.x, i)
      case 'L' => for (i <- start.y + -1 until -wireLength - 1 + start.y by -1) yield Point(start.x, i)
      case 'U' => for (i <- start.x + 1 until wireLength + 1 + start.x) yield Point(i, start.y)
      case 'D' => for (i <- start.x + -1 until -wireLength - 1 + start.x by -1) yield Point(i, start.y)
    }).toVector
  }

  def placeWires(instructions: List[String]): Vector[Point] = placeWires_h(instructions, Point(0, 0))

  def getManhattanDistance(firstWire: Vector[Point], secondWire: Vector[Point]): Int =
    firstWire.intersect(secondWire).map(x => Math.abs(x.x - 0) + Math.abs(x.y - 0)).min

  def getFewestSteps(firstWire: Vector[Point], secondWire: Vector[Point]): Int =
    firstWire
      .intersect(secondWire)
      .map(i => firstWire.indexOf(i) + 1 + secondWire.indexOf(i) + 1)
      .min

  private def placeWires_h(instructions: List[String], start: Point): Vector[Point] = instructions match {
    case Nil => Vector.empty
    case h :: t =>
      val points = placeWireStrand(start, h)
      points ++ placeWires_h(t, points.last)
  }
}
