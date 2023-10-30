package matchers

import com.h2.services.Currency

class ContainerSpec extends UnitSpec {
  behavior of "Currencies in a wallet"

  it should "contain a currency added to a list wallet" in {
    val oneUsd : Currency = "1 USD"
    val twoEuros : Currency = "2 EUR"
    val tenCad : Currency = "10 CAD"

    val wallet = List(oneUsd, twoEuros, tenCad)
    wallet should contain (oneUsd)
  }

  it should "contain a currency added to a Set wallet" in {
    val oneUsd : Currency = "1 USD"
    val twoEuros : Currency = "2 EUR"
    val tenCad : Currency = "10 CAD"

    val wallet = Set(oneUsd, twoEuros, tenCad)
    wallet should contain (oneUsd)
  }

  it should "contain a currency added to a Map wallet" in {
    val oneUsd : Currency = "1 USD"
    val twoEuros : Currency = "2 EUR"
    val tenCad : Currency = "10 CAD"

    val wallet : Map[String, Currency] = Map(
      "USD" -> oneUsd,
      "EUR" -> twoEuros,
      "CAD" -> tenCad
    )

    wallet should contain ("USD" -> oneUsd)
  }

  // one and only one of specified element

  it should "contain oneOf a currency added to a Set wallet" in {
    val oneUsd : Currency = "1 USD"
    val twoEuros : Currency = "2 EUR"
    val tenCad : Currency = "10 CAD"
    val hundredINR : Currency = "100 INR"

    val wallet = Set(oneUsd, twoEuros, tenCad)
    wallet should contain oneOf (oneUsd, hundredINR)
    wallet should contain oneElementOf(List(oneUsd, hundredINR))
  }

  it should "contain noneOf a currency added to a Set wallet" in {
    val oneUsd : Currency = "1 USD"
    val twoEuros : Currency = "2 EUR"
    val tenCad : Currency = "10 CAD"
    val hundredINR : Currency = "100 INR"

    val wallet = Set(oneUsd, twoEuros)
    wallet should contain noneOf (tenCad, hundredINR)
    wallet should contain noElementsOf (List(tenCad, hundredINR))
  }
  it should "not contain a currency not added to a list wallet" in {
    val oneUsd : Currency = "1 USD"
    val twoEuros : Currency = "2 EUR"
    val tenCad : Currency = "10 CAD"

    val wallet = List(oneUsd, twoEuros)
    wallet should not contain (tenCad)
  }

  it should "not contain a currency not added to a Set wallet" in {
    val oneUsd : Currency = "1 USD"
    val twoEuros : Currency = "2 EUR"
    val tenCad : Currency = "10 CAD"

    val wallet = Set(oneUsd, twoEuros)
    wallet should not contain (tenCad)
  }
  it should "not contain a currency not added to a Map wallet" in {
    val oneUsd : Currency = "1 USD"
    val twoEuros : Currency = "2 EUR"
    val tenCad : Currency = "10 CAD"

    val wallet : Map[String, Currency] = Map(
      "USD" -> oneUsd,
      "EUR" -> twoEuros
    )

    wallet should not contain ("CAD" -> tenCad)
  }




}
