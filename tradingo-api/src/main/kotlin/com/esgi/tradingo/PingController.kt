package com.esgi.tradingo

import org.springframework.boot.CommandLineRunner
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("pings")
class PingController {

    data class PingSample(val message: String);


    @GetMapping("{message}")
    fun getPing(@PathVariable message: String): ResponseEntity<PingSample>{
        return ResponseEntity.ok(PingSample(message))
    }

//    @Bean
//    fun commandLineRunner(ctx: ApplicationContext): CommandLineRunner? {
//        return CommandLineRunner { args: Array<String?>? ->
//            println("Let's inspect beans provided by Spring Boot:")
//            val beanNames: Unit = ctx.getBeanDefinitionNames()
//            Arrays.sort(beanNames)
//            for (beanName in beanNames) {
//                println(beanName)
//            }
//        }
//    }
//
//    @Bean
//    fun metricsCommonTags(): MeterRegistryCustomizer<MeterRegistry?>? {
//        return MeterRegistryCustomizer<MeterRegistry> { registry ->
//            registry.config().commonTags("application", "MYAPPNAME")
//        }
//    }
}