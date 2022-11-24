package BankingApp

import java.time.Instant

abstract class Account(
    protected var firstName: String,
    protected var lastName: String,
    protected var email: String,
    protected var continent: Utils.Continent,
    protected val createdAt: Instant
) {
    @JvmName("getFirstName1")
    fun getFirstName() = firstName
    @JvmName("setFirstName1")
    fun setFirstName(firstName: String) {
        this.firstName = firstName
    }

    @JvmName("getLastName1")
    fun getLastName() = lastName
    @JvmName("setLastName1")
    fun setLastName(lastName: String) {
        this.lastName = lastName
    }

    @JvmName("getEmail1")
    fun getEmail() = email
    @JvmName("setEmail1")
    fun setEmail(email: String) {
        this.email = email
    }
}