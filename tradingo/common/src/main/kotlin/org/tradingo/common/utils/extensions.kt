package org.tradingo.common.utils

import java.time.LocalDateTime

fun LocalDateTime.plusMilliseconds(milliseconds: Long?): LocalDateTime {
    if (milliseconds == null) return this
    plusSeconds(milliseconds / 1000)
    return this
}

fun LocalDateTime.minusMilliseconds(milliseconds: Long?): LocalDateTime {
    if (milliseconds == null) return this
    minusSeconds(milliseconds / 1000)
    return this
}