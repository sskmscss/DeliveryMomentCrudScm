/*
 * Copyright (c) Microsoft Corporation.
 * Licensed under the MIT License.
 */
package com.tcs.service2

//import com.tcs.service2.DaprApplication.start
//import org.springframework.boot.autoconfigure.SpringBootApplication
import org.apache.commons.cli.CommandLineParser
import org.apache.commons.cli.DefaultParser
import org.apache.commons.cli.Options
import kotlin.jvm.JvmStatic
import java.lang.Exception
import java.lang.InterruptedException
import java.util.*
import org.springframework.boot.SpringApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer
import com.tcs.service2.DaprApplication
/**
 * Service for subscriber.
 * 1. Build and install jars:
 * mvn clean install
 * 2. Run the server:
 * dapr run --components-path ./components --app-id subscriber --app-port 3000 --dapr-http-port 3005 -- \
 * java -jar examples/target/dapr-java-sdk-examples-exec.jar io.dapr.examples.pubsub.http.Subscriber -p 3000
 */
//@SpringBootApplication
object Subscriber {
    /**
     * This is the entry point for this example app, which subscribes to a topic.
     * @param args The port this app will listen on.
     * @throws Exception An Exception on startup.
     */
    @Throws(Exception::class)
    @JvmStatic
    fun mainFunction(args: Array<String>) {
        val options = Options()
        options.addRequiredOption("p", "port", true, "The port this app will listen on")
        val parser: CommandLineParser = DefaultParser()
        val cmd = parser.parse(options, args)

        // If port string is not valid, it will throw an exception.
        val port = cmd.getOptionValue("port").toInt()
        println(" PORT RECEIVED : " + port)
        DaprApplication().start(port)
        // Start Dapr's callback endpoint.
        // start(port)
//        val app = SpringApplication(Subscriber::class.java)
//        app.run(String.format("--server.port=%d", port))
    }
}