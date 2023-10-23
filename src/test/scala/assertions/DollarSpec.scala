package assertions

import org.scalatest.flatspec.AnyFlatSpec
import com.h2.entities.Dollars

class DollarSpec extends AnyFlatSpec{
  behavior of "A dollar"

  it should "create a correct Dollar object for number" in {
    val tenDollars = Dollars(10)
    assert("$10" === tenDollars.toString)
  }

  it should "correctly identify that $10 > $5" in {
    val tenDollars = Dollars(10)
    val fiveDollars = Dollars(5)
    assert(tenDollars > fiveDollars)
  }

  it should "correctly identify that $2 < $5" in {
    val twoDollars = Dollars(2)
    val fiveDollars = Dollars(5)
    assert(twoDollars < fiveDollars)
  }

  it should "correctly add two Dollar amounts" in {
    val twoDollars = Dollars(2)
    val fiveDollars = Dollars(5)

    assertResult(expected = "$7") {
      (twoDollars + fiveDollars).toString
    }
  }

  it should "correctly subtract two Dollar amounts" in {
    val twoDollars = Dollars(2)
    val fiveDollars = Dollars(5)

    assertResult(expected = "$3") {
      (fiveDollars - twoDollars).toString
    }
  }

  it should "correctly identify that $4 == $4" in {
    val fourDollars = Dollars(4)
    assertResult(expected = true) {
      fourDollars === fourDollars
    }
  }

  it should "throw an exception when invalid integer is provided to create dollar" in {
    assertThrows[ArithmeticException] {
      Dollars(10 / 0)
    }
  }

  it should "hav every dollar more than 0" in {
    //val dollars: List[Dollars] = List(Dollars(1), Dollars(2), Dollars(3))
    val dollars: List[Dollars] = List.empty

    assume(dollars.nonEmpty, "The Dollars coming from API should be non-empty")

    dollars.foreach(d => {
      assert(d.amount > 0)
    })
  }

}
