
object Main {

  // Step 1: Define the main function
  def main(args: Array[String]): Unit = {

    // Step 2: Create a list containing numbers from 1 to 10
    val numbers = (1 to 10).toList

    // Step 3: Display the original list
    println("Original List:")
    println(numbers)

    // Step 4: Filter and display even numbers from the list
    val evenNumbers = numbers.filter(_ % 2 == 0)
    println("\nEven Numbers:")
    println(evenNumbers)

    // Step 5: Multiply each number in the list by 3
    val multipliedNumbers = numbers.map(_ * 3)
    println("\nNumbers Multiplied by 3:")
    println(multipliedNumbers)

    // Step 6: Create tuples containing each number and its square
    val tuples = numbers.flatMap(n => List((n, n * n)))
    println("\nNumber and Its Square:")
    println(tuples)

    // Step 7: Calculate the product of all elements using foldLeft
    val product = numbers.foldLeft(1)(_ * _)

    // Step 8: Display the product of all elements
    println("\nProduct of All Elements:")
    println(product)
  }
}
