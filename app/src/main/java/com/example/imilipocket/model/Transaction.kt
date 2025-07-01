package com.example.imilipocket.model

import java.io.Serializable

data class Transaction(
    val id: String,                   // Unique ID for the transaction
    val title: String,                // Name or label of transaction
    val amount: String,               // Money amount (positive or negative)
    val category: String,             // Category like Food, Transport etc.
    val date: String,                 // Date as a string (we’ll use formatted date)
    val type: TransactionType        // INCOME or EXPENSE
) : Serializable

enum class TransactionType : Serializable {
    INCOME,
    EXPENSE
}
