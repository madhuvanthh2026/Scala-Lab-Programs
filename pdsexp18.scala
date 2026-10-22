
object Assessment1 {

  // Step 1: Define a function to calculate the sum of array elements
  def sumArray(arr: Array[Int]): Int = {
    arr.sum
  }

  // Step 2: Define a function to concatenate fruit names with commas
  def concatenateFruits(fruits: Array[String]): String = {
    fruits.mkString(", ")
  }

  // Step 3: Define the main function
  def main(args: Array[String]): Unit = {

    // Step 4: Create an integer array
    val numbers = Array(2, 5, 9, 14, 20)

    // Step 5: Calculate and display the sum of array elements
    println("Sum of array elements: " + sumArray(numbers))

    // Step 6: Create an array of five fruit names
    val fruits = Array("Apple", "Banana", "Mango", "Orange", "Grapes")

    // Step 7: Concatenate and display the fruit names
    println("Fruits: " + concatenateFruits(fruits))

    // Step 8: Display the integer array elements
    println("Integer array elements:")

    // Step 9: Iterate through the integer array and print each element
    for (num <- numbers) {
      println(num)
    }
  }
}

