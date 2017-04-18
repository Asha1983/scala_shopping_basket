/**
  * Created by Ramu on 18/04/2017.
  */
import org.scalatest.{Matchers, GivenWhenThen, FeatureSpec}
import com.hmrc.shoppingcart._

class ShoppingCartWithOffers extends FeatureSpec with GivenWhenThen with Matchers
{

  feature ("Shopping Cart with Offers"){

    scenario("Testing Checkout BOGOF offer"){

      Given("A shopping cart")
      val shoppingCart =  ShoppingCart

      When("2 apples added to the basket")
      val items = Array("apple","apple");

      Then("Total price should be same as one apple")
      shoppingCart.checkoutWithOffers(items) should be (0.60)
    }

    scenario("Testing Checkout 3for2 offer"){

      Given("A shopping cart")
      val shoppingCart =  ShoppingCart

      When("3 oranges added to the basket")
      val items = Array("orange","orange","orange");

      Then("Total price should equal to prices of 2 oranges")
      shoppingCart.checkoutWithOffers(items) should be (0.50)
    }

    scenario("Testing Checkout both 3for2 and BOGOF offers"){

      Given("A shopping cart")
      val shoppingCart =  ShoppingCart

      When("3 oranges and 2 apples added to the basket")
      val items = Array("orange","orange","orange","apple","apple");

      Then("Total price should equal to prices of 2 oranges and 1 apple")
      shoppingCart.checkoutWithOffers(items) should be (1.10)
    }


    scenario("Testing Checkout with no offer"){

      Given("A shopping cart")
      val shoppingCart =  ShoppingCart

      When("2 oranges and 1 apple added to the basket")
      val items = Array("orange","orange","apple");

      Then("Total price should equal to prices of 2 oranges and 1 apple")
      shoppingCart.checkoutWithOffers(items) should be (1.10)
    }

  }
}