package BankingApp.CustomExceptions

class CustomExceptions {
    class AccountNumberAlreadyExists(errorMessage: String): RuntimeException(errorMessage)

    class InvalidVendorName(errorMessage: String): RuntimeException(errorMessage)

    class CreditCardNumberNotCreatedYet(errorMessage: String): RuntimeException(errorMessage)

    class CreditCardAlreadyExists(errorMessage: String): RuntimeException(errorMessage)

    class NonMatchingBankException(errorMessage: String): RuntimeException(errorMessage)
}