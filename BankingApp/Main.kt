package BankingApp

import java.time.Instant
import java.util.UUID

fun main() {
    var usedCustomerIDs = mutableSetOf<String>()

    //println("before account number builder object creation")

    val accountNumber = AccountNumberBuilder(
        "BankOfGreece",
        Utils.Continent.EUROPE,
        Utils.CustomerType.INDIVIDUAL,
        UUID.randomUUID()
    ).getAccountNumber()

    val customer1 = Customer(
        UUID.randomUUID(),
        "Alex",
        "Voliotis",
        "alexvoliotis500@email.com",
        Utils.Continent.OCEANIA,
        Utils.CustomerType.INDIVIDUAL,
        Instant.now()
    )
    usedCustomerIDs.add(customer1.getCustomerUUID().toString())
    println("customer1 before setting account number: $customer1")

    customer1.setAccountNumber("BankOfGreece")
    println("customer1 after setting account number: $customer1")
    //customer1.setAccountNumber("b") throws exception since account number has already been set
    println("\n${customer1.getFirstName()}")

    println(usedCustomerIDs)
    val randomUUID = UUID.randomUUID()
    println("randomUUID = $randomUUID, randomUUID = ${randomUUID.toString().length}")

    println("randomUUID.toString().split(\"-\") = ${randomUUID.toString().split("-").last()}")

    val listOfBanks = createBanks()

    for (bank in listOfBanks) {
        println(bank.getLocation().getCountryName())
    }

    val creditCard1 = CreditCard(customer1, listOfBanks[2])
    println(creditCard1)
    println("credit card number = ${creditCard1.getCreditCardNumber()}")

    println(creditCard1.customer)
}

fun createBanks(): List<Bank> {
    val listOfBanks = mutableListOf<Bank>()
    listOfBanks.add(Bank("BankOfEngland", "10010", Location("England", "London", "Waterpark", "3", "60200")))
    listOfBanks.add(Bank("BankOfGreece", "10012", Location("Greece", "Athens", "Waterpark", "3", "60200")))
    listOfBanks.add(Bank("BankOfJapan", "10013", Location("Japan", "Tokyo", "Waterpark", "3", "60200")))
    listOfBanks.add(Bank("BankOfAustralia", "10014", Location("Australia", "Canberra", "Waterpark", "3", "60200")))
    listOfBanks.add(Bank("BankOfCanada", "10015", Location("Canada", "Montreal", "lalalala", "3", "602200")))
    listOfBanks.add(Bank("BankOfBrazil", "10016", Location("Brazil", "Rio de Janeiro", "Waterpark", "3", "60200")))
    listOfBanks.add(Bank("BankOfEgypt", "10017", Location("Egypt", "Cairo", "Waterpark", "3", "60200")))

    return listOfBanks
}