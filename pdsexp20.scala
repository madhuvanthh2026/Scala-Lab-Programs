
import scala.collection.mutable.HashMap

object Assessment3 {

  // Step 1: Define a function to merge two HashMaps and retain the higher grade
  def mergeHashMaps(map1: HashMap[String, Int],
                    map2: HashMap[String, Int]): HashMap[String, Int] = {

    // Step 2: Create a new HashMap and copy the first HashMap entries
    val merged = HashMap[String, Int]() ++ map1

    // Step 3: Iterate through the second HashMap
    for ((name, grade) <- map2) {

      // Step 4: Check whether the student name already exists
      if (merged.contains(name)) {

        // Step 5: Retain the higher grade if the student already exists
        merged(name) = merged(name).max(grade)
      } else {

        // Step 6: Add the student if the name does not exist
        merged(name) = grade
      }
    }

    // Step 7: Return the merged HashMap
    merged
  }

  // Step 8: Define a function to handle repeated keys using lists
  def handleCollisions(entries: List[(String, Int)]): HashMap[String, List[Int]] = {

    // Step 9: Create an empty HashMap to store lists of grades
    val chained = HashMap[String, List[Int]]()

    // Step 10: Iterate through the list of student names and grades
    for ((name, grade) <- entries) {

      // Step 11: Check whether the student name already exists
      if (chained.contains(name)) {

        // Step 12: Append the grade to the existing list
        chained(name) = chained(name) :+ grade
      } else {

        // Step 13: Create a new list for a student name that does not exist
        chained(name) = List(grade)
      }
    }

    // Step 14: Return the HashMap containing lists of grades
    chained
  }

  // Step 15: Define the main function
  def main(args: Array[String]): Unit = {

    // Step 16: Create the first HashMap with student names and grades
    val students = HashMap[String, Int](
      "Arun" -> 85,
      "Bala" -> 78,
      "Charan" -> 90
    )

    // Step 17: Update Arun's grade and add Divya's grade
    students("Arun") = 92
    students("Divya") = 88

    // Step 18: Display the first HashMap
    println("Student Grades:")
    println(students)

    // Step 19: Create the second HashMap with student names and grades
    val otherStudents = HashMap[String, Int](
      "Arun" -> 89,
      "Bala" -> 82,
      "Esha" -> 95
    )

    // Step 20: Display the second HashMap
    println("Second HashMap:")
    println(otherStudents)

    // Step 21: Merge both HashMaps using the function
    val mergedStudents = mergeHashMaps(students, otherStudents)

    // Step 22: Display the merged HashMap with the higher grades
    println("Merged HashMap (Higher Grade):")
    println(mergedStudents)

    // Step 23: Create a list containing repeated student names and grades
    val entries = List(
      ("Arun", 85),
      ("Bala", 78),
      ("Arun", 92),
      ("Charan", 90),
      ("Bala", 82)
    )

    // Step 24: Handle repeated names by storing grades in lists
    val chainedGrades = handleCollisions(entries)

    // Step 25: Display the HashMap with chaining
    println("HashMap with Chaining:")
    println(chainedGrades)
  }
}
