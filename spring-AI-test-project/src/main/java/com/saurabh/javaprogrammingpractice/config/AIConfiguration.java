package com.saurabh.javaprogrammingpractice.config;

import com.saurabh.javaprogrammingpractice.service.DocumentIngestionService;
import org.springframework.ai.document.Document;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.SimpleVectorStore;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AIConfiguration {

    @Bean
    public VectorStore vectorStore(EmbeddingModel embeddingModel ){
        return SimpleVectorStore.builder(embeddingModel).build();
    }

    @Bean
    CommandLineRunner runner(DocumentIngestionService service, VectorStore vectorStore) {
        return args -> {
            System.out.println("App started, this runs once");
            service.ingest();
            List<Document> list = vectorStore.similaritySearch(SearchRequest.builder().query("What is the capital of France?").topK(1).build());
            for (Document d : list) {
                System.out.println(d);
            }
        };
    }
}
