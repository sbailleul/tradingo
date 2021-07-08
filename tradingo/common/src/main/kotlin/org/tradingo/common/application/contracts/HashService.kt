package org.tradingo.common.application.contracts

interface HashService {
    fun hashPassword(password: String): String
    fun matches(password: String, hashedPassword: String): Boolean
}