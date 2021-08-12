package com.example.demo

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.RestController

@RestController
class DemoController : DemoAPI {

    @Value("\${perfilSpring}")
    private val perfilSpring: String = "default"

    override fun getDemo(): String {
        val demoDomain = DemoDomain("hello world")
        println(perfilSpring)
        return "${demoDomain.name} this a multi module project with the fucking gradle :)"
    }
}