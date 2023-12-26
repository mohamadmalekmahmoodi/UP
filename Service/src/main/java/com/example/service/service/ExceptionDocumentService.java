package com.example.service.service;

import com.example.common.documents.ExceptionDocument;
import com.example.service.repositories.ExceptionDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExceptionDocumentService {
    @Autowired
     private ExceptionDocumentRepository exceptionDocumentRepository;


    public void save(ExceptionDocument exceptionDocument){
         exceptionDocumentRepository.save(exceptionDocument);
    }
}
