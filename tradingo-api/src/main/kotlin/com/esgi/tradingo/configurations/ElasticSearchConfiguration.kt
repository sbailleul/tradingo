package com.esgi.tradingo.configurations

import com.esgi.tradingo.ElasticsearchClientConfig
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration


@Configuration
@ConfigurationProperties(prefix = "elastic-search")
class ElasticSearchConfiguration {
    val logger: Logger = LoggerFactory.getLogger(ElasticsearchClientConfig::class.java)

    init{
        logger.info("Elastic search host : $logger")
    }
    lateinit var host: String
    override fun toString(): String {
        return "ElasticSearchConfiguration(host='$host')"
    }


}