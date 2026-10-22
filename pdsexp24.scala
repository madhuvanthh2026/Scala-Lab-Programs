
import breeze.linalg._
import plotly._
import plotly.element._
import plotly.layout._
import plotly.Plotly._

object FruitRevenueAnalysis {

  def main(args: Array[String]): Unit = {

    // Step 1: Create the fruit sales dataset
    val fruitData = Seq(
      ("Apple", 120.0, 10.0),
      ("Banana", 60.0, 20.0),
      ("Apple", 130.0, 5.0),
      ("Orange", 80.0, 15.0),
      ("Banana", 65.0, 10.0),
      ("Orange", 90.0, 5.0)
    )

    // Step 2: Display the original dataset
    println("Fruit Sales Dataset:")
    println("Fruit\tPrice\tQuantity")

    fruitData.foreach {
      case (fruit, price, quantity) =>
        println(s"$fruit\t$price\t$quantity")
    }

    // Step 3: Calculate revenue for each record using Price * Quantity
    val revenues = DenseVector(
      fruitData.map {
        case (_, price, quantity) => price * quantity
      }.toArray
    )

    // Step 4: Calculate total revenue for each fruit type
    val revenueByFruit = fruitData.indices
      .groupBy(i => fruitData(i)._1)
      .map {
        case (fruit, indices) =>
          val totalRevenue = indices.map(i => revenues(i)).sum
          fruit -> totalRevenue
      }

    // Step 5: Display total revenue for each fruit
    println("\nTotal Revenue by Fruit:")

    revenueByFruit.toSeq.sortBy(_._1).foreach {
      case (fruit, revenue) =>
        println(s"$fruit: $revenue")
    }

    // Step 6: Prepare data for the Plotly bar chart
    val sortedRevenue = revenueByFruit.toSeq.sortBy(_._1)

    val fruitNames = sortedRevenue.map(_._1)
    val revenueValues = sortedRevenue.map(_._2)

    // Step 7: Create a Plotly bar chart
    val barChart = Bar(
      x = fruitNames,
      y = revenueValues
    )

    // Step 8: Set the chart title and axis labels
    val chartLayout = Layout(
      title = "Total Revenue by Fruit Type",
      xaxis = Axis(title = "Fruit Type"),
      yaxis = Axis(title = "Total Revenue")
    )

    // Step 9: Display the chart
    plot(barChart, chartLayout)
  }
}



