package com.knoldus.validator

class EmailValidator {

  def emailIsValid(emailId: String): Boolean = {

    if (checkTheSymbol(emailId) && nameOfRecipient(emailId) && domain(emailId) && topLevelDomain(emailId))
      return true

    false

  }

  def checkTheSymbol (emailId: String): Boolean = {
    for (i <- 0 until emailId.length)
      if (emailId.charAt (i) == '@')
        return true
    false
  }

  def nameOfRecipient (emailId: String): Boolean = {
    var index = 0
    while (emailId.charAt (index) != '@') {
      if (emailId.charAt (index) == '.') return true

      if (! Character.isLetterOrDigit (emailId.charAt (index) ) ) return false
      index = index + 1
    }
    true
  }

  def domain (emailId: String): Boolean = {

    if (! checkTheSymbol(emailId) ) return false
    var index = emailId.indexOf ("@") + 1
    while (emailId.charAt (index) != '.') {
      if (! Character.isLetterOrDigit (emailId.charAt (index) ) ) return false
      index = index + 1
    }
    true
  }

  def topLevelDomain (emailId: String): Boolean = {

    if (! checkTheSymbol(emailId) ) return false
    val index = emailId.indexOf (".")
    val toplevelDomain = emailId.substring (index)
    if (toplevelDomain.equals (".com") || toplevelDomain.equals (".net") || toplevelDomain.equals (".org") || toplevelDomain.equals (".co.in"))
      return true
    false

  }
}