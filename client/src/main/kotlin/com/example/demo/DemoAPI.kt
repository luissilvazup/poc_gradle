package com.example.demo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/v1/demo")
interface DemoAPI {

    @GetMapping
    fun getDemo(): String

}