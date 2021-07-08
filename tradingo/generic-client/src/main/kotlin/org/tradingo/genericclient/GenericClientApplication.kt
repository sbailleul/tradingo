package org.tradingo.genericclient

import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan("org.tradingo")
class GenericClientApplication

fun main(args: Array<String>) {
    runApplication<GenericClientApplication>(*args)
}
