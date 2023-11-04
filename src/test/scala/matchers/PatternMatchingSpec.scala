package matchers

import com.h2.entities.Dollars
import com.h2.services.Currency
import org.scalatest.Inside

class PatternMatchingSpec extends UnitSpec with Inside {
  behavior of "Currency when pattern matching"

  it should "be able to assert on the values of a currency" in {
    val tenUSD: Currency = "10 USD"

    inside(tenUSD) {case Currency(code, amount, costInDollars) =>
      code should equal("USD")
      amount shouldEqual(10.0 +- 0.5)
      costInDollars should be > Dollars(12)
    }
  }

  it should "be able to 'matchPattern' on the currency code" in {
    val tenUSD: Currency = "10 USD"
    tenUSD should matchPattern {case Currency("USD", 10.0, _) => }
  }


}
