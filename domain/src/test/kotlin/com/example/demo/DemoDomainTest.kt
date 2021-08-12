package com.example.demo

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class DemoDomainTest {

    @Test
    fun `valida construtor DemoDomain`() {
        val demoDomain = DemoDomain("teste")

        Assertions.assertEquals("teste", demoDomain.name)
    }

    @Test
    fun `valida construtor DemoDomain com atributo vazio`() {
        val demoDomain = DemoDomain("")

        Assertions.assertEquals("", demoDomain.name)
    }
}