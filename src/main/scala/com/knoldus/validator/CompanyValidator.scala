package com.knoldus.validator
import com.knoldus.db.CompanyReadDto
import com.knoldus.models.Company

class CompanyValidator {

  def companyIsValid(company: Company): Boolean = {

    val database_obj = new CompanyReadDto
    val companyExist = database_obj.getCompanyByName(company.name)

    val emailValidator = new EmailValidator
    val checkEmail = emailValidator.emailIsValid(company.emailId)
    if (checkEmail && companyExist == None)
      return true
    false
  }
  }