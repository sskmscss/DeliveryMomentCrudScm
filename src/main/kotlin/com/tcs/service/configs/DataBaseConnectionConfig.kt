package com.tcs.service.configs

import com.mongodb.ConnectionString
import org.springframework.data.mongodb.core.MongoTemplate
import com.mongodb.client.MongoClients
import com.mongodb.MongoClientSettings
import com.mongodb.client.MongoClient
import com.tcs.service.utility.Utility
import khttp.responses.Response
import org.apache.logging.log4j.kotlin.logger
import org.json.JSONObject
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.lang.Exception
import javax.annotation.PostConstruct


class DataBaseConnectionConfig {
    fun mongo(): MongoClient? {
        println("MONGO CALLED")
        val logger = logger()

        val connectionString = ConnectionString(Utility.getUtilitySecret("azurekeyvault", "deliverymomentdbapi").toString())
println(connectionString)
        val mongoClientSettings = MongoClientSettings.builder().applyConnectionString(connectionString).build()

        return MongoClients.create(mongoClientSettings)
    }


    @Bean
    fun mongoTemplate(): MongoTemplate {
        println("I AM CREATING A BEAN!!!!!!!")

        return MongoTemplate(mongo()!!, Utility.getUtilitySecret("azurekeyvault", "deliverycruddb").toString())
    }
}