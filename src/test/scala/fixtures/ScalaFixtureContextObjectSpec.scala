package fixtures

import com.h2.entities.{Customer, Dollars}
import com.h2.services.{CustomerService, ProductService}
import matchers.UnitSpec

import java.util.UUID

class ScalaFixtureContextObjectSpec extends UnitSpec{
  trait ACustomer {
    private val service: CustomerService = new CustomerService {}
    private val custID: UUID = service.createNewCustomer("nancy","williams","nancy@workday.com","1982/07/01")
    val customer: Customer = service.getCustomer(custID).get
  }

  trait AProduct {
    private val service: ProductService = new ProductService {}
    private val productID: UUID = service.addNewDepositProduct("CoreChecking", 2000, 4)
    val product = service.getDepositProduct(productID).get
  }

  trait ADollars {
    val fiveThousandDollars = Dollars(5000)
  }

  behavior of "ACustomer"
  it should "return a customer with non-emoty email address" in new ACustomer {
    customer.email.toString should not be empty
  }

  behavior of "AProduct"
  it should "return a valid product with more 1000 dollars min balance requirement" in new AProduct {
    product.minimumBalancePerMonth should be >= Dollars(1000)
  }

  behavior of "A Product with some money"
  it should "return true for 5000 dollars be greater than the product minimum balance requirement" in new ADollars with AProduct {
    fiveThousandDollars should be >= product.minimumBalancePerMonth
  }
}
