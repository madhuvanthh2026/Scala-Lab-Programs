
case class Person(name: String, age: Int, city: String)

object Main {
  def main(args: Array[String]): Unit = {

    // Step 1: Create a list of Person objects
    val people = List(
      Person("Arun", 25, "Chennai"),
      Person("Priya", 32, "Vellore"),
      Person("Kumar", 28, "Chennai"),
      Person("Divya", 35, "Bangalore"),
      Person("Rahul", 22, "Vellore")
    )

    // Step 2: Display the original list of people
    println("Original List of People:")
    people.foreach(println)

    // Step 3: Define a function to filter people older than 30
    def filterOlderThan30(people: List[Person]): List[Person] = {
      people.filter(_.age > 30)
    }

    // Step 4: Display people older than 30
    println("\nPeople Older Than 30:")
    println(filterOlderThan30(people))

    // Step 5: Define a function to group people by city
    def groupByCity(people: List[Person]): Map[String, List[Person]] = {
      people.groupBy(_.city)
    }

    // Step 6: Display people grouped by city
    println("\nPeople Grouped by City:")
    groupByCity(people).foreach(println)

    // Step 7: Define a function to transform person details into strings
    def transformToString(people: List[Person]): List[String] = {
      people.map(p =>
        s"${p.name} is ${p.age} years old and lives in ${p.city}"
      )
    }

    // Step 8: Display person details as formatted strings
    println("\nPerson Details as Strings:")
    transformToString(people).foreach(println)

    // Step 9: Define a function to sort people by age
    def sortByAge(people: List[Person]): List[Person] = {
      people.sortBy(_.age)
    }

    // Step 10: Display people sorted by age in ascending order
    println("\nPeople Sorted by Age:")
    sortByAge(people).foreach(println)
  }
}


