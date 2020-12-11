package com.tcs.service2

import com.tcs.service2.DaprApplication
import org.apache.commons.cli.CommandLineParser
import org.apache.commons.cli.DefaultParser
import org.apache.commons.cli.Options
import org.springframework.boot.SpringApplication
import kotlin.jvm.JvmStatic
import java.lang.Exception

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

//@SpringBootApplication

object ServiceKotlinTemplateApplication {

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

//        runApplication<ServiceKotlinTemplateApplication>(*args)
      //  val app = SpringApplication(ServiceKotlinTemplateApplication::class.java)
       // app.run()

    }
}