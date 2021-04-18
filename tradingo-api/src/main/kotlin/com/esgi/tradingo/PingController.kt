package com.esgi.tradingo

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
}