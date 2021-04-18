package com.esgi.tradingo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class TradingoApplication

fun main(args: Array<String>) {
	runApplication<TradingoApplication>(*args)
}
