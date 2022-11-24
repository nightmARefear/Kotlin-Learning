package BankingApp

import java.time.Instant

abstract class Account(
    var firstName: String,
    var lastName: String,
    var email: String,
    var continent: Utils.Continent,
    protected val createdAt: Instant
) {
}