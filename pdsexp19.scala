
object Assessment2 {

  def squareList(numbers: List[Int]): List[Int] = {
    numbers.map(n => n * n)
  }

  def findIntersection(set1: Set[Char], set2: Set[Char]): Set[Char] = {
    set1.intersect(set2)
  }

  def main(args: Array[String]): Unit = {

    val primes = List(2, 3, 5, 7, 11)
    println("First five prime numbers: " + primes)

    val squaredPrimes = squareList(primes)
    println("Squared prime numbers: " + squaredPrimes)

    val text = "hello world"
    val charSet = text.toSet
    println("Unique characters: " + charSet)

    val anotherSet = Set('h', 'e', 'l', 'o', 'a', 'b')
    println("Second set: " + anotherSet)

    val commonCharacters = findIntersection(charSet, anotherSet)
    println("Intersection of sets: " + commonCharacters)

    val details = (101, "Scala", true)

    println("Tuple integer: " + details._1)
    println("Tuple string: " + details._2)
    println("Tuple boolean: " + details._3)
  }
}

