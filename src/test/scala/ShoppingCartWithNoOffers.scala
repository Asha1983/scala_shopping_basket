/**
  * Created by Ramu on 18/04/2017.
  */
import org.scalatest.{Matchers, GivenWhenThen, FeatureSpec}
import com.hmrc.shoppingcart._

class ShoppingCartWithNoOffers extends FeatureSpec with GivenWhenThen with Matchers
{
  feature ("Basic Shopping Cart"){

    scenario("Testing Checkout with 1 apple and no offer"){

      Given("A shopping cart")
      val shoppingCart =  ShoppingCart

      When("Add products with no offers")
      val items = Array("apple");

      Then("Total sum should be simple sum of prices")
      shoppingCart.checkout(items) should be (0.60)
    }

    scenario("Testing Checkout with 1 orange and no offer"){

      Given("A shopping cart")
      val shoppingCart =  ShoppingCart

      When("Add one orange")
      val items = Array("orange");

      Then("Total sum should be price of one orange")
      shoppingCart.checkout(items) should be (0.25)
    }

    scenario("Testing Checkout with no offer and multiple items"){

      Given("A shopping cart")
      val shoppingCart =  ShoppingCart

      When("Add products with no offers")
      val items = Array("apple","orange","orange");

      Then("Total sum should be simple sum of prices")
      shoppingCart.checkout(items) should be (1.10)
    }
  }

}