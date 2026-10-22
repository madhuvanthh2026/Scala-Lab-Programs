
import vegas._
import vegas.render.WindowRenderer._

object FruitPriceAnalysis {

  def main(args: Array[String]): Unit = {

    // Step 1: Create the original fruit dataset
    val fruitData = Seq(
      Map("Date" -> "2026-01-01", "Fruit" -> "Apple", "Price" -> 120),
      Map("Date" -> "2026-01-02", "Fruit" -> "Banana", "Price" -> 60),
      Map("Date" -> "2026-01-03", "Fruit" -> "Apple", "Price" -> 130),
      Map("Date" -> "2026-01-04", "Fruit" -> "Orange", "Price" -> 80),
      Map("Date" -> "2026-01-05", "Fruit" -> "Apple", "Price" -> 125)
    )

    // Step 2: Display the original fruit dataset
    println("Original Fruit Dataset:")
    fruitData.foreach(println)

    // Step 3: Filter the dataset to select only Apple records
    val appleData = fruitData.filter(
      row => row("Fruit") == "Apple"
    )

    // Display the filtered Apple dataset
    println("\nApple Dataset:")
    appleData.foreach(println)

    // Step 4: Extract the prices of Apples
    val applePrices = appleData.map(
      row => row("Price").toString.toDouble
    )

    // Step 5: Calculate the average price of Apples
    val averagePrice = applePrices.sum / applePrices.length

    // Display the average price
    println("\nAverage Price of Apples: " + averagePrice)

    // Step 6: Prepare Apple data for chart visualization
    val chartData = appleData.map { row =>
      Map(
        "Date" -> row("Date"),
        "Price" -> row("Price").toString.toDouble
      )
    }

    // Step 7: Create a Vegas line chart
    val chart = Vegas("Apple Price Trend Over Time")
      .withData(chartData)
      .encodeX("Date", Nom)
      .encodeY("Price", Quant)
      .mark(Line)

    // Step 8: Display the chart in a separate window
    chart.window.show
  }
}
