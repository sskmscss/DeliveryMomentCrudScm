/*
 * Copyright (c) Microsoft Corporation.
 * Licensed under the MIT License.
 */
package com.tcs.service

import io.dapr.client.DaprClient
import kotlin.jvm.JvmStatic
import io.dapr.client.DaprClientBuilder
import java.lang.Exception
import java.lang.InterruptedException
import java.util.*

/**
 * Message publisher.
 * 1. Build and install jars:
 * mvn clean install
 * 2. Run the program:
 * dapr run --components-path ./components --app-id publisher --dapr-http-port 3006 -- \
 * java -jar examples/target/dapr-java-sdk-examples-exec.jar io.dapr.examples.pubsub.http.Publisher
 */
object Publisher {
    //Number of messages to be sent: 10
    private const val NUM_MESSAGES = 10

    //The title of the topic to be used for publishing
    private const val TOPIC_NAME = "aksKafkaTest"

    //private static final String TOPIC_NAME = "ageventhub01topic01";
    //The name of the pubseb
    //private static final String PUBSUB_NAME = "messagebus";
    private const val PUBSUB_NAME = "pubsub"

    /**
     * This is the entry point of the publisher app example.
     * @param args Args, unused.
     * @throws Exception A startup Exception.
     */
    @Throws(Exception::class)
    @JvmStatic
    fun mainFunction(args: Array<String>) {
        //Creating the DaprClient: Using the default builder client produces an HTTP Dapr Client
        val client : DaprClient = DaprClientBuilder().build()

//        client.build().use { client ->
            for (i in 0 until NUM_MESSAGES) {
                val message = String.format("This is message #%d", i)
                //Publishing messages
                client.publishEvent(PUBSUB_NAME, TOPIC_NAME, message).block()
                println("Published message: $message")
                try {
                    Thread.sleep((1000 * Math.random()).toLong())
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                    Thread.currentThread().interrupt()
                    return
                }
//            }

            //Publishing a single bite: Example of non-string based content published
            client.publishEvent(
                    PUBSUB_NAME,
                    TOPIC_NAME, byteArrayOf(1),
                    Collections.singletonMap("content-type", "application/octet-stream")).block()
            println("Published one byte.")

            // This is an example, so for simplicity we are just exiting here.
            // Normally a dapr app would be a web service and not exit main.
            println("Done.")
        }
    }
}