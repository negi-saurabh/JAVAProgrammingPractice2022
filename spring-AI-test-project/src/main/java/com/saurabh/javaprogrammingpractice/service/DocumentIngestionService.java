package com.saurabh.javaprogrammingpractice.service;


import org.springframework.ai.document.Document;
import org.springframework.ai.reader.TextReader;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DocumentIngestionService {

    private final VectorStore vectorStore;
    public DocumentIngestionService(VectorStore vectorStore){
        this.vectorStore = vectorStore;
    }

    public void ingest(){

        List<String> files = Arrays.asList("docs/returns-policy.txt", "docs/shipping-warranty.txt");

        for(String fileName : files) {
            TextReader textReader = new TextReader(new ClassPathResource(fileName));

            List<Document> documents = textReader.get();

            System.out.println(documents.size());

            for (Document document : documents) {
                System.out.println(document.getText());
            }

            List<Document> splitDocuments  =  new TokenTextSplitter().apply(documents);

            System.out.println(splitDocuments.size());
            vectorStore.add(splitDocuments);
        }
    }
}
