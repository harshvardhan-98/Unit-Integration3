package ValidatorTest

import org.scalatest.funsuite.AnyFunSuite
import com.knoldus.models.Company
import com.knoldus.validator.CompanyValidator

class CompanyValidatorTest extends AnyFunSuite {

  val firstCompany= new Company("Infosys", "infosys123@gmail.com", "Mysore")
  val secondCompany = new Company("Knoldus", "knoldus123@gmail.com", "Noida")
  val thirdCompany = new Company("Detusche", "detusche123gmail.com", "Gurugram")


  test("Check if firstCompany is not present in database and is thus a valid entry") {
    val expectedResult = true
    val resultingValue = (new CompanyValidator).companyIsValid(firstCompany)
    assert(expectedResult == resultingValue)
  }

  test("Check if secondCompany is an invalid entry as the company already exists in the database") {
    val expectedResult = false
    val resultingValue = (new CompanyValidator).companyIsValid(secondCompany)
    assert(expectedResult == resultingValue)
  }

  test("Check if thirdCompany is not present in database but having invalid email ID without '@'is thus an invalid entry") {
    val expectedResult = false
    val resultingValue = (new CompanyValidator).companyIsValid(thirdCompany)
    assert(expectedResult == resultingValue)
  }

}
