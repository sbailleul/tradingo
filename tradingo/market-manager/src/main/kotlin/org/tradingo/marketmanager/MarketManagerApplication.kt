package org.tradingo.marketmanager

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan("org.tradingo")
class MarketManagerApplication

fun main(args: Array<String>) {
    runApplication<MarketManagerApplication>(*args)
}
