package matchers

import com.h2.services.CustomerService

import java.util.UUID

class LengthAndSizeSpec extends UnitSpec {
  val customerService: CustomerService = new CustomerService {}
  behavior of  "CustomerService for Length"

  it should "return correct length for customer's first and last name" in {
    val (first, last, email, dOB) = ("John", "Smith", "john@smith.com", "1992/12/31")

    val customerId = customerService.createNewCustomer(first, last, email, dOB)
    val customer = customerService.getCustomer(customerId).get

    customer.first should have length first.length
    customer.last should have length(last.length)
  }

  behavior of "CustomerService for size"
  it should "return correct size for number of customers created" in {
    val newCustomers: Seq[(String, String, String, String)] = List(
      ("John", "Smith", "john@smith.com", "1992/12/31"),
      ("Amy", "Grove", "amy@google.com", "1995/07/31")
    )
    val customerIds : Seq[UUID]= newCustomers.map(newCustomer =>
    customerService.createNewCustomer(newCustomer._1, newCustomer._2, newCustomer._3, newCustomer._4)
    )

    customerIds should have size 2


  }
}
