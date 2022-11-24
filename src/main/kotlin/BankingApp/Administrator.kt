package BankingApp

import java.time.Instant
import java.util.UUID

class Administrator(
    private val administratorUUID: UUID,
    firstName: String,
    lastName: String,
    email: String,
    continent: Utils.Continent,
    private val type: Utils.CustomerType,
    createdAt: Instant
) : Account(firstName, lastName, email, continent, createdAt) {
}