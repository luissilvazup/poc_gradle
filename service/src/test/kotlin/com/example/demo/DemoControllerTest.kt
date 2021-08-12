package com.example.demo

import io.mockk.clearAllMocks
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import java.nio.charset.StandardCharsets

@ExtendWith(SpringExtension::class)
@WebMvcTest(DemoController::class)
class DemoControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    private val apiPath = "/v1/demo"

    @BeforeEach
    fun init() {
        clearAllMocks()
    }

    @Test
    fun checkGetDemoTest() {

        val mvcResult = mockMvc.perform(
            MockMvcRequestBuilders.get(apiPath)
                .characterEncoding(StandardCharsets.UTF_8.name())
                .contentType(MediaType.APPLICATION_JSON_VALUE)
        )
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.valueOf("text/plain;charset=UTF-8")))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andDo(MockMvcResultHandlers.print())
            .andReturn()

        val messageToCompare = "hello world this a multi module project with the fucking gradle :)"
        val responseToCompare = mvcResult.response.contentAsString

        Assertions.assertEquals(messageToCompare, responseToCompare)
    }


}