package matchers

import com.h2.services.CustomerService

class ObjectIdentitySpec extends UnitSpec {
  val customerService : CustomerService = new CustomerService {}
  behavior of "CustomerService when creating new Customers"

  it should "create one customer for a given email address" in {
    val (first, last, email, dOB) = ("Shane", "", "shane@workday.com", "1976/12/12")
    val customerID1 = customerService.createNewCustomer(first, last, email, dOB)
    val customerID2 = customerService.createNewCustomer(first, last, email, dOB)

    val customer1 = customerService.getCustomer(customerID1).get
    val customer2 = customerService.getCustomer(customerID2).get

    customer1 should be theSameInstanceAs(customer2)

  }
}
