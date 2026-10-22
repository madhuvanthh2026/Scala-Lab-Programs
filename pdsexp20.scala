
import scala.collection.mutable.HashMap

object Assessment3 {

  def mergeHashMaps(map1: HashMap[String, Int],
                    map2: HashMap[String, Int]): HashMap[String, Int] = {
    val merged = HashMap[String, Int]() ++ map1

    for ((name, grade) <- map2) {
      if (merged.contains(name)) {
        merged(name) = merged(name).max(grade)
      } else {
        merged(name) = grade
      }
    }

    merged
  }

  def handleCollisions(entries: List[(String, Int)]): HashMap[String, List[Int]] = {
    val chained = HashMap[String, List[Int]]()

    for ((name, grade) <- entries) {
      if (chained.contains(name)) {
        chained(name) = chained(name) :+ grade
      } else {
        chained(name) = List(grade)
      }
    }

    chained
  }

  def main(args: Array[String]): Unit = {

    val students = HashMap[String, Int](
      "Arun" -> 85,
      "Bala" -> 78,
      "Charan" -> 90
    )

    students("Arun") = 92
    students("Divya") = 88

    println("Student Grades:")
    println(students)

    val otherStudents = HashMap[String, Int](
      "Arun" -> 89,
      "Bala" -> 82,
      "Esha" -> 95
    )

    println("Second HashMap:")
    println(otherStudents)

    val mergedStudents = mergeHashMaps(students, otherStudents)

    println("Merged HashMap (Higher Grade):")
    println(mergedStudents)

    val entries = List(
      ("Arun", 85),
      ("Bala", 78),
      ("Arun", 92),
      ("Charan", 90),
      ("Bala", 82)
    )

    val chainedGrades = handleCollisions(entries)

    println("HashMap with Chaining:")
    println(chainedGrades)
  }
}

