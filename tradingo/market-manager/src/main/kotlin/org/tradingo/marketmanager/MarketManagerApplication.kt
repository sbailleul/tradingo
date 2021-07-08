package org.tradingo.marketmanager

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MarketManagerApplication

fun main(args: Array<String>) {
    runApplication<MarketManagerApplication>(*args)
}
