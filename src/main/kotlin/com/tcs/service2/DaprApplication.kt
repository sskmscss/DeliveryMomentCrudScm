/*
 * Copyright (c) Microsoft Corporation.
 * Licensed under the MIT License.
 */
package com.tcs.service2

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

/**
 * Dapr's HTTP callback implementation via SpringBoot.
 * Scanning package io.dapr.springboot is required.
 */
@SpringBootApplication(scanBasePackages = ["io.dapr.springboot", "com.tcs.service2"])
class DaprApplication {
    /**
     * Starts Dapr's callback in a given port.
     * @param port Port to listen to.
     */
    fun start(port: Int) {
        println("SERVER PORT :: " + port)
        val app = SpringApplication(DaprApplication::class.java)
        app.run(String.format("--server.port=%d", port))
    }
}