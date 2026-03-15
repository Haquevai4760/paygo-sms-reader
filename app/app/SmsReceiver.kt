package com.paygo.smsreader

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Telephony

class SmsReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        if (intent.action == Telephony.Sms.Intents.SMS_RECEIVED_ACTION) {

            val messages = Telephony.Sms.Intents.getMessagesFromIntent(intent)

            for (sms in messages) {

                val sender = sms.displayOriginatingAddress
                val message = sms.messageBody

                if (sender.contains("bKash") || sender.contains("NAGAD")) {

                    val trx = SmsParser.parse(message)

                    if (trx != null) {
                        ApiService.send(trx)
                    }

                }

            }

        }

    }

}
