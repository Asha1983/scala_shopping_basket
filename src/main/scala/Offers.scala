package com.hmrc.shoppingcart

/**
  * Created by Ramu on 18/04/2017.
  */
object Offers {

  def bogof(noOfItems: Int, price: Double): Double = ((noOfItems / 2) + (noOfItems % 2)) * price

  def threeForTwo(noOfItems: Int, price: Double): Double = (2 * (noOfItems/3) + (noOfItems %3)) * price

  def offer(item: String): Int => Double = {

    val price: Double =  ShoppingCart.getPrice(item)
    item toLowerCase() match {
      case "apple" => (noOfItems:Int) => bogof(noOfItems, price)
      case "orange" => (noOfItems:Int) => threeForTwo(noOfItems, price)
      case _ => (noOfItems:Int) => noOfItems * price
    }

  }

}
