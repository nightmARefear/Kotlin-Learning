package BankingApp

import BankingApp.CustomExceptions.CustomExceptions

class CreditCard (
    val customer: Customer,
    private val bank: Bank
) {
    private var creditCardNumber: String? = null

    init {
        creditCardNumber = buildCreditCardNumber()
        // TODO: Bank()
    }

    private fun getCustomerTypeID(customerType: Utils.CustomerType): String {
        return when (customerType) {
            Utils.CustomerType.INDIVIDUAL -> "ft74"
            Utils.CustomerType.BUSINESS -> "wk48"
        }
    }

    private fun buildCreditCardNumber(): String {
        return bank.getVendorID() + getCustomerTypeID(customer.getCustomerType()).substring(2, 4) + Utils().generateRandomCharacters("0123456789", 9)
    }

    // getters
    fun getCreditCardNumber() = creditCardNumber ?: throw CustomExceptions.CreditCardNumberNotCreatedYet("Credit card number has not been created yet!")

    fun getBankName() = bank.getName()
}