package com.example.service.repositories;

import com.example.common.documents.ExceptionDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExceptionDocumentRepository extends MongoRepository<ExceptionDocument,String> {
}
