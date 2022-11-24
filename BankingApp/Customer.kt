package BankingApp

import java.time.Instant
import java.util.*


class Customer(private val customerUUID: UUID,
               firstName: String,
               lastName: String,
               email: String,
               continent: Utils.Continent,
               private val type: Utils.CustomerType,
               createdAt: Instant): Account(firstName, lastName, email, continent, createdAt) {
    private var accountNumber: String? = null
    private val creditCards: List<CreditCard>? = null

    private fun accountNumberExists() = accountNumber != null

    fun setAccountNumber(vendorName: String) {
        if (accountNumberExists()) throw AccountNumberAlreadyExists("\nBankingApp.Account number already exists for BankingApp.Customer: $this")

        accountNumber = AccountNumberBuilder(vendorName, continent, type, customerUUID).getAccountNumber()
    }

    private fun creditCardExists(creditCard: CreditCard): Boolean {
        return creditCards?.contains(creditCard) ?: false
    }

    // getters/setters
    fun getCustomerUUID() = customerUUID

    fun getCustomerType() = type

    // for testing purposes only!!!!!
    override fun toString(): String {
        return "BankingApp.Customer(customerID='$customerUUID', firstName='$firstName', lastName='$lastName', email='$email', continent=$continent, type=$type, createdAt=$createdAt, accountNumber=$accountNumber, creditCards=$creditCards)"
    }
}