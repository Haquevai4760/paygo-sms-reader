package com.paygo.smsreader

object ApiService {

    fun send(transaction: Transaction) {

        println("Send to API: " + transaction.trxId)

    }

}
