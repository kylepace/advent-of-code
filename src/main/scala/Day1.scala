object Day1 {
  def calculateModuleMass(mass: Int): Int = Math.round(mass / 3) - 2

  def calculateFullFuelRequirements(modules: List[Int]): Int = modules.map(calculateModuleMass).sum

  def calculateTotalFullFuelRequirements(modules: List[Int]): Int = modules.map(x => calculateTotalModuleMass(x, 0)).sum

  @scala.annotation.tailrec
  def calculateTotalModuleMass(mass: Int, acc: Int): Int = {
    val necessaryFuel = calculateModuleMass(mass)
    if (necessaryFuel >= 0)
      calculateTotalModuleMass(necessaryFuel, acc + necessaryFuel)
    else
      acc
  }
}