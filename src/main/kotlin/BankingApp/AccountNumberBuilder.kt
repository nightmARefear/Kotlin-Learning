package BankingApp

import BankingApp.CustomExceptions.CustomExceptions
import java.util.*

class AccountNumberBuilder(
    private val vendorName: String,
    private val customerContinent: Utils.Continent,
    private val customerType: Utils.CustomerType,
    private val customerID: UUID
) {

    private var accountNumber: String

    init {
        accountNumber = buildAccountNumber()
    }

    private fun getVendorIdentifier(vendorName: String): String? {
        return when (vendorName) {
            "BankOfEngland" -> "10010"
            "BankOfGermany" -> "10011"
            "BankOfGreece" -> "10012"
            "BankOfJapan" -> "10013"
            "BankOfAustralia" -> "10014"
            "BankOfCanada" -> "10015"
            "BankOfBrazil" -> "10016"
            "BankOfEgypt" -> "10017"
            else -> {null}
        }
    }

    private fun getContinentID(): String {
        return when (customerContinent) {
            Utils.Continent.EUROPE -> "20010"
            Utils.Continent.SOUTH_AMERICA -> "20011"
            Utils.Continent.NORTH_AMERICA -> "20012"
            Utils.Continent.AFRICA -> "20013"
            Utils.Continent.ASIA -> "20014"
            Utils.Continent.OCEANIA -> "20015"
            Utils.Continent.ANTARCTICA -> "20016"
        }
    }

    private fun getCustomerTypeID(): String {
        return when (customerType) {
            Utils.CustomerType.INDIVIDUAL -> "ft74"
            Utils.CustomerType.BUSINESS -> "wk48"
        }
    }

    private fun buildAccountNumber(): String {
        val vendorIdentifier = getVendorIdentifier(vendorName)
            ?: throw CustomExceptions.InvalidVendorName("\nInvalid vendor name \"$vendorName\"")

        //                                                                                                                                                             shortenedCustomerUUID
        return vendorIdentifier + getContinentID() + getCustomerTypeID() + Utils().generateRandomCharacters("abcdefghijklmnopqrstuvwxyz0123456789", 4) + customerID.toString().split("-").last()
    }

    fun getAccountNumber() = accountNumber
}

