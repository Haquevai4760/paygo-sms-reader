package com.paygo.smsreader

data class Transaction(
    val amount: String,
    val trxId: String,
    val method: String
)

object SmsParser {

    fun parse(message: String): Transaction? {

        val amountRegex = Regex("Tk\\s?(\\d+)")
        val trxRegex = Regex("TrxID[: ]([A-Z0-9]+)")

        val amountMatch = amountRegex.find(message)
        val trxMatch = trxRegex.find(message)

        if (amountMatch != null && trxMatch != null) {

            val amount = amountMatch.groupValues[1]
            val trxId = trxMatch.groupValues[1]

            return Transaction(amount, trxId, "bkash")
        }

        return null
    }

}
