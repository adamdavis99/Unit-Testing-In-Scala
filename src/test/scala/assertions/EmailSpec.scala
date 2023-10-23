package assertions

import com.h2.entities.Email
import org.scalatest.flatspec.AnyFlatSpec

class EmailSpec extends AnyFlatSpec{
  behavior of "An email"

  it should "return an Email object for a valid string" in {
    val email = Email("arunesh.sarker@workday.com")
    assert(email.localPart === "arunesh.sarker")
    assert(email.domain === "workday.com")
  }

  it should "return another Email object for another valid string" in {
    assertResult("jim") {
      Email("jim@workday.com").localPart
    }
  }

  it should "throw an exception when an email does not contain @ symbol" in {
    assertThrows[IllegalArgumentException] {
      Email("jim.com")
    }
  }

  it should "throw an exception when email contains more than 1 @ symbol" in {
    assertThrows[IllegalArgumentException] {
      Email("jim2@2@workday.com")
    }
  }

  it should "intercept correct error message when no @symbol is provided" in {
    val exception = intercept[IllegalArgumentException] { Email("workday.com") }
    assert(exception.isInstanceOf[IllegalArgumentException])
    assert(exception.getMessage.contains("does not contain '@'"))
  }

  it should "intercept correct error message when more than 1 @ symbol is provided" in {
    val exception = intercept[IllegalArgumentException] { Email("aneel@carl@workday.com") }
    assert(exception.isInstanceOf[IllegalArgumentException])
    assert(exception.getMessage.contains("should not contain '@'"))
  }

}
