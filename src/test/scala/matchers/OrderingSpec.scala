package matchers

import com.h2.services.Currency
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class OrderingSpec extends UnitSpec {
  behavior of "Currency conversion Cost in Comparison"

  it should "report equal costs for 10 USD, 10 USD" in {
    val tenUsd1: Currency = "10 USD"
    val tenUsd2: Currency = "10 USD"

    tenUsd1.costInDollars.amount should be >= tenUsd2.costInDollars.amount
  }

  it should "report higher costs for 100 USD, 10 USD" in {
    val hundredUsd: Currency = "100 USD"
    val tenUsd: Currency = "10 USD"

    hundredUsd.costInDollars.amount should be > tenUsd.costInDollars.amount
  }

  it should "report higher costs for 1 USD, 10 USD" in {
    val oneUsd: Currency = "1 USD"
    val tenUsd: Currency = "10 USD"

    oneUsd.costInDollars.amount should be < tenUsd.costInDollars.amount
  }


}
