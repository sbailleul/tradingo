package com.esgi.tradingo

import com.esgi.tradingo.configurations.ElasticSearchConfiguration
import org.elasticsearch.client.RestHighLevelClient
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.elasticsearch.client.ClientConfiguration
import org.springframework.data.elasticsearch.client.RestClients
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories


@Configuration
@EnableElasticsearchRepositories(basePackages = ["com.esgi.tradingo.repositories"])
@ComponentScan(basePackages = ["com.esgi.tradingo"])
class ElasticsearchClientConfig(val config: ElasticSearchConfiguration) : AbstractElasticsearchConfiguration() {
    @Bean
    override fun elasticsearchClient(): RestHighLevelClient {
        val clientConfiguration = ClientConfiguration
            .builder()
            .connectedTo(config.host)
            .build()
        return RestClients.create(clientConfiguration).rest()
    }
}