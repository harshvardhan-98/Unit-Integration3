package ValidatorTest

import org.scalatest.funsuite.AnyFunSuite
import com.knoldus.models.Employee
import com.knoldus.validator.EmployeeValidator
class EmployeeValidatorTest extends AnyFunSuite{

  val firstEmployee = Employee("Mark", "David", 28,50000, "Software Consultant", "Philips", "mohdAmir123@gmail.com" )
  val secondEmployee = Employee("Jassi", "Gill", 26,30000, "Software Trainee", "Philips", "gilljassi@gmail.com" )
  val thirdEmployee = Employee("Dawayne", "Bravo", 23,65000, "Sr. Software Consultant", "TCS", "DjBravo43@gmail.com" )
  val fourthEmployee = Employee("Steve", "Jobs", 21,25000, "Software Trainee", "Knoldus", "Captainamerica21?@gmail.com" )


  test("Checking if firstEmployee working in Infosys(company present in Database)"){
    val expectResult = true
    val result = (new EmployeeValidator).employeeIsValid(firstEmployee)
    assert(expectResult == result)
  }


  test("Checking if secondEmployee working in Philips(company present in Database)"){

    val expectResult = true
    val result = (new EmployeeValidator).employeeIsValid(secondEmployee)
    assert(expectResult == result)
  }


  test("Checking if thirdEmployee working in company TCS(company not present in Database)"){

    val expectResult = false
    val result = (new EmployeeValidator).employeeIsValid(thirdEmployee)
    assert(expectResult == result)
  }

  test("Checking if fourthEmployee working in Knoldus(company present in Database)"){
    val expectResult = false
    val result = (new EmployeeValidator).employeeIsValid(fourthEmployee)
    assert(expectResult == result)
  }

}
