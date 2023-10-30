package matchers

import com.h2.services.{Currency, CustomerService}

class EmptinessSpec extends UnitSpec {
  val custoemrService : CustomerService = new CustomerService {}
  behavior of "Customer for emptiness"

  it should "return empty name for customer's last name" in {
    val (first, last, email, dOB) = ("Shane", "", "shane@workday.com", "1976/12/12")
    val customerID = custoemrService.createNewCustomer(first, last, email, dOB)
    val customer = custoemrService.getCustomer(customerID).get

    customer.last should be (empty)
    customer.last shouldBe empty
  }

  behavior of "currencies inside wallet"

  it should "be empty when no currencies are added to the wallet" in {
    val wallet : List[Currency] = List.empty

    wallet shouldBe empty
  }
}
