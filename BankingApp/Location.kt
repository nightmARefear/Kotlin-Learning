package BankingApp

data class Location(
    private val countryName: String,
    private val city: String,
    private val streetName: String,
    private val streetNumber: String,
    private val postalCode: String
) {

    fun getCountryName() = countryName
    fun getCity() = city
    fun getStreetName() = streetName
    fun getStreetNumber() = streetNumber
    fun getPostalCode() = postalCode

}