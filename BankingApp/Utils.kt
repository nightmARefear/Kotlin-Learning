package BankingApp

import java.util.*
import kotlin.streams.asSequence

class Utils {
    enum class Continent {
        EUROPE,
        SOUTH_AMERICA,
        NORTH_AMERICA,
        AFRICA,
        ASIA,
        OCEANIA,
        ANTARCTICA
    }

    enum class CustomerType{
        INDIVIDUAL,
        BUSINESS
    }

    fun generateRandomCharacters(sourceText: String, size: Long): String {
        return Random().ints(size, 0, sourceText.length)
            .asSequence()
            .map(sourceText::get)
            .joinToString("")
    }
}