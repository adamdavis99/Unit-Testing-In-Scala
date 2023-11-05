package fixtures

import com.h2.services.Currency
import matchers.UnitSpec

class ScalaFixtureSpec extends UnitSpec {

  def fixture= new {
    val currency1: Currency = "10 USD"
    val currency2 : Currency = "10 USD"
  }
  behavior of "Currency equals"

  it should "match 2 $10 currencies as equal when using should === matchers"in {
    val f = fixture
    f.currency1 should === (f.currency2)
  }

  it should "match 2 $10 currencies as equal when using shouldEqual matchers"in {
    val f = fixture

     f.currency1 shouldEqual (f.currency2)
  }
}
