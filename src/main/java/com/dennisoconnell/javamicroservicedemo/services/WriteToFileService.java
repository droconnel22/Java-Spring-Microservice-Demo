package com.dennisoconnell.javamicroservicedemo.services;


import com.dennisoconnell.javamicroservicedemo.models.Hello;
import com.dennisoconnell.javamicroservicedemo.repository.HelloRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.FileWriter;

@Service
public class WriteToFileService implements WriteToFile {

    private HelloRepository helloRepository;

    @Autowired
    public WriteToFileService(HelloRepository helloRepository) {
        this.helloRepository = helloRepository;
    }

    @Async
    @Override
    public void WriteHelloToFile(Integer id) throws  Exception {
        FileWriter fileWriter = null;
        try {
            if(helloRepository.findById(id).isPresent()){
                Hello hello = helloRepository.findById(id).get();
                // attach a file to FileWriter
                fileWriter =new FileWriter(hello.name+"_.json");
                ObjectMapper mapper = new ObjectMapper();

                //Object to JSON in file
                fileWriter.write(mapper.writeValueAsString(hello.toDto()));
            }

        } catch( Exception ex){
            throw new Exception("Failed to write History to File");
        } finally {
            fileWriter.close();
        }
    }

}
