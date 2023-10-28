package matchers

import com.h2.services.Currency
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class EqualitySpec extends UnitSpec {
  behavior of "Currency equals"
  it should "match 2 $10 currencies as equal when using should equal matchers"in {
    val curr1 : Currency = "10 USD"
    val curr2 : Currency = "10 USD"

    curr1 should equal (curr2)
  }

  it should "match 2 $10 currencies as equal when using should === matchers"in {
    val curr1 : Currency = "10 USD"
    val curr2 : Currency = "10 USD"

    curr1 should === (curr2)
  }

  it should "match 2 $10 currencies as equal when using shouldEqual matchers"in {
    val curr1 : Currency = "10 USD"
    val curr2 : Currency = "10 USD"

    curr1 shouldEqual (curr2)
  }

  it should "match 2 $10 currencies as equal when using shouldBe matchers"in {
    val curr1 : Currency = "10 USD"
    val curr2 : Currency = "10 USD"

    curr1 shouldBe (curr2)
  }

  it should "match 2 $10 currencies as equal when using should be matchers"in {
    val curr1 : Currency = "10 USD"
    val curr2 : Currency = "10 USD"

    curr1 should be (curr2)
  }


}
