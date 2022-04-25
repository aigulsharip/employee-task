package kz.daracademy.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "kz.daracademy.repository")
public class ElasticConfig extends AbstractElasticsearchConfiguration {
    @Override
    public RestHighLevelClient elasticsearchClient() {
        ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo("https://employee-task-4e9135.es.us-central1.gcp.cloud.es.io:9243")
                //.connectedTo(("localhost:9200"))
                .usingSsl()
                .withBasicAuth("elastic", "xYEJP6PXo6KZvoLrZT1W6jye")
                .build();

        return RestClients.create(clientConfiguration).rest();
    }
}
