
import org.knowm.xchart.CategoryChartBuilder
import org.knowm.xchart.CategorySeries
import scala.jdk.CollectionConverters._

object FruitPriceAnalysis {
  def main(args: Array[String]): Unit = {

    // Create the fruit dataset
    val dates = List(
      "2026-01-01",
      "2026-01-02",
      "2026-01-03",
      "2026-01-04",
      "2026-01-05"
    )

    val fruits = List("Apple", "Banana", "Apple", "Orange", "Apple")
    val prices = List(120.0, 60.0, 130.0, 80.0, 125.0)
    val quantities = List(10, 15, 8, 12, 20)

    // Combine the data into records
    val fruitData = dates.indices.map { i =>
      (dates(i), fruits(i), prices(i), quantities(i))
    }

    // Display the original dataset
    println("Original Fruit Dataset:")
    println("Date       Fruit    Price    Quantity")

    fruitData.foreach { case (date, fruit, price, quantity) =>
      println(f"$date%-12s $fruit%-8s $price%7.2f $quantity%10d")
    }

    // Filter records for apples
    val appleData = fruitData.filter(_._2 == "Apple")

    println("\nApple Dataset:")
    appleData.foreach(println)

    // Calculate the average price of apples
    val applePrices = appleData.map(_._3)
    val averagePrice = applePrices.sum / applePrices.size

    println(f"\nAverage Price of Apples: Rs. $averagePrice%.2f")

    // Extract apple dates and prices for the chart
    val appleDates = appleData.map(_._1)
    val chartPrices = appleData.map(_._3)

    // Create a line chart
    val chart = new CategoryChartBuilder()
      .width(800)
      .height(600)
      .title("Apple Price Trend Over Time")
      .xAxisTitle("Date")
      .yAxisTitle("Price (Rs.)")
      .build()

    // Set the chart style to a line chart
    chart.getStyler.setDefaultSeriesRenderStyle(
      CategorySeries.CategorySeriesRenderStyle.Line
    )

    // Add apple price data to the chart
    chart.addSeries(
      "Apple Price",
      appleDates.map(_.asInstanceOf[AnyRef]).asJava,
      chartPrices.map(Double.box).asJava
    )

    // Display the chart
    new org.knowm.xchart.SwingWrapper(chart).displayChart()
  }
}
