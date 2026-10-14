package com.saurabh.javaprogrammingpractice.config;

import com.saurabh.javaprogrammingpractice.service.DocumentIngestionService;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.vectorstore.SimpleVectorStore;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AIConfiguration {

    @Bean
    public VectorStore vectorStore(EmbeddingModel embeddingModel ){
        return SimpleVectorStore.builder(embeddingModel).build();
    }

    @Bean
    CommandLineRunner runner(DocumentIngestionService service) {
        return args -> {
            System.out.println("App started, this runs once");
            service.ingest();
        };
    }
}
