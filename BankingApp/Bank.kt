package BankingApp

import BankingApp.CustomExceptions.CustomExceptions

data class Bank(
    private val name: String,
    private val vendorID: String,
    private val location: Location,
    private var listOfCreditCards: MutableList<CreditCard> = mutableListOf()
) {
    fun getName() = name

    fun getLocation() = location

    fun getVendorID() = vendorID

    fun addCreditCard(creditCard: CreditCard): Boolean {
        if (!name.equals(creditCard.getBankName())) throw CustomExceptions.NonMatchingBankException("Credit card $creditCard is not of the same bank (${getName()})!")
        if (listOfCreditCards.contains(creditCard)) throw CustomExceptions.CreditCardAlreadyExists("Credit card $creditCard already exists!")

        listOfCreditCards.add(creditCard)
        return listOfCreditCards.contains(creditCard)
    }
}