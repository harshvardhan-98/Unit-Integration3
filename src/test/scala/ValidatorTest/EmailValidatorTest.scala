package ValidatorTest

import com.knoldus.validator.EmailValidator
import org.scalatest.funsuite.AnyFunSuite

class EmailValidatorTest extends AnyFunSuite {

  val emailValidator_obj = new EmailValidator
  test("Checking with a valid Email ") {

    val expectedResult = true
    val result = emailValidator_obj.emailIsValid("harshrawat1148@gmail.com")
    assert(expectedResult == result)
  }

  test("Checking if it returns false on invalid Email without '@'") {

    val expectedResult = false
    val resultingValue = emailValidator_obj.emailIsValid("harshrawat1148gmail.com")
    assert(expectedResult == resultingValue)
  }

  test("Checking if it returns false on  invalid Email with special characters in domain name") {

    val expectedResult = false
    val resultingValue = emailValidator_obj.emailIsValid("harshrawat1148@g?#??mail.com")
    assert(expectedResult == resultingValue)
  }

  test("Checking if it returns false on  invalid Email with special characters in recipient's Name") {

    val expectedResult = false
    val resultingValue = emailValidator_obj.emailIsValid("harshrawat1148?*@gmail.com")
    assert(expectedResult == resultingValue)
  }

  test("Checking if it returns false on Email with invalid Top Level Domain") {

    val expectedResult = false
    val resultingValue = emailValidator_obj.emailIsValid("harshrawat1148@gmail.crm")
    assert(expectedResult == resultingValue)
  }
}
