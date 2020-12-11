/*
 * Copyright (c) Microsoft Corporation.
 * Licensed under the MIT License.
 */
package com.tcs.service

import org.springframework.boot.autoconfigure.SpringBootApplication
import java.util.*

/**
 * Dapr's Main Application to run using fatjar. This class will call the main source provided by user dynamically.
 */
@SpringBootApplication

class DaprMainApplication

fun main(args: Array<String>) {
    val arguments: Array<String>
    require(args.size >= 1) { "Requires at least one argument - name of the main class" }
    arguments = Arrays.copyOfRange(args, 1, args.size)
    println("ARGS :: " + arguments)
    val mainClass = Class.forName(args[0])
    println("mainClass :: " + mainClass)
    val mainMethod = mainClass.getDeclaredMethod("mainFunction", Array<String>::class.java)
    println("mainMethod :: " + mainMethod)

    val methodArgs = arrayOfNulls<Any>(1)
    methodArgs[0] = arguments
    println("methodArgs :: " + methodArgs[0])

    mainMethod.invoke(mainClass, *methodArgs)
}