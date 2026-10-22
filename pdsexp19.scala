
object Assessment2 {

  // Step 1: Define a function to square each element in the list
  def squareList(numbers: List[Int]): List[Int] = {
    numbers.map(n => n * n)
  }

  // Step 2: Define a function to find the intersection of two sets
  def findIntersection(set1: Set[Char], set2: Set[Char]): Set[Char] = {
    set1.intersect(set2)
  }

  // Step 3: Define the main function
  def main(args: Array[String]): Unit = {

    // Step 4: Create a list of the first five prime numbers
    val primes = List(2, 3, 5, 7, 11)
    println("First five prime numbers: " + primes)

    // Step 5: Square each prime number and display the result
    val squaredPrimes = squareList(primes)
    println("Squared prime numbers: " + squaredPrimes)

    // Step 6: Create a string and convert it into a set of unique characters
    val text = "hello world"
    val charSet = text.toSet
    println("Unique characters: " + charSet)

    // Step 7: Create another set of characters
    val anotherSet = Set('h', 'e', 'l', 'o', 'a', 'b')
    println("Second set: " + anotherSet)

    // Step 8: Find and display the intersection of the two sets
    val commonCharacters = findIntersection(charSet, anotherSet)
    println("Intersection of sets: " + commonCharacters)

    // Step 9: Create a tuple containing an integer, a string, and a boolean
    val details = (101, "Scala", true)

    // Step 10: Access and display each tuple element
    println("Tuple integer: " + details._1)
    println("Tuple string: " + details._2)
    println("Tuple boolean: " + details._3)
  }
}

