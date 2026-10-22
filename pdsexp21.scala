object FruitPriceAnalysis  {
  def main(args: Array[String]): Unit = {

    val numbers = (1 to 10).toList
    println("Original List:")
    println(numbers)

    val evenNumbers = numbers.filter(_ % 2 == 0)
    println("\nEven Numbers:")
    println(evenNumbers)

    val multipliedNumbers = numbers.map(_ * 3)
    println("\nNumbers Multiplied by 3:")
    println(multipliedNumbers)

    val tuples = numbers.flatMap(n => List((n, n * n)))
    println("\nNumber and Its Square:")
    println(tuples)

    val product = numbers.foldLeft(1)(_ * _)
    println("\nProduct of All Elements:")
    println(product)
  }
}
