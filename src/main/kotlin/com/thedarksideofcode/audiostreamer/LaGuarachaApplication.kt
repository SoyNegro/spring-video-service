package com.thedarksideofcode.audiostreamer

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Configuration
import org.springframework.http.codec.ServerCodecConfigurer
import org.springframework.web.reactive.config.CorsRegistry
import org.springframework.web.reactive.config.EnableWebFlux
import org.springframework.web.reactive.config.WebFluxConfigurer


@SpringBootApplication
class LaGuarachaApplication

fun main(args: Array<String>) {
    SpringApplication.run(LaGuarachaApplication::class.java, *args)
}

