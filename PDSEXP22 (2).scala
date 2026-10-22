case class Person(name: String, age: Int, city: String)

object Main {
  def main(args: Array[String]): Unit = {

    val people = List(
      Person("Arun", 25, "Chennai"),
      Person("Priya", 32, "Vellore"),
      Person("Kumar", 28, "Chennai"),
      Person("Divya", 35, "Bangalore"),
      Person("Rahul", 22, "Vellore")
    )

    println("Original List of People:")
    people.foreach(println)

    def filterOlderThan30(people: List[Person]): List[Person] = {
      people.filter(_.age > 30)
    }

    println("\nPeople Older Than 30:")
    println(filterOlderThan30(people))

    def groupByCity(people: List[Person]): Map[String, List[Person]] = {
      people.groupBy(_.city)
    }

    println("\nPeople Grouped by City:")
    groupByCity(people).foreach(println)

    def transformToString(people: List[Person]): List[String] = {
      people.map(p =>
        s"${p.name} is ${p.age} years old and lives in ${p.city}"
      )
    }

    println("\nPerson Details as Strings:")
    transformToString(people).foreach(println)

    def sortByAge(people: List[Person]): List[Person] = {
      people.sortBy(_.age)
    }

    println("\nPeople Sorted by Age:")
    sortByAge(people).foreach(println)
  }
}


