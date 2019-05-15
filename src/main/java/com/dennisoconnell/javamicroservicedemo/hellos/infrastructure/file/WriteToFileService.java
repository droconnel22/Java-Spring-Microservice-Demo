package com.dennisoconnell.javamicroservicedemo.hellos.infrastructure.file;


import com.dennisoconnell.javamicroservicedemo.hellos.domain.Hello;
import com.dennisoconnell.javamicroservicedemo.hellos.infrastructure.mysql.HelloRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileWriter;

@Service
public class WriteToFileService {

    @Autowired
    private HelloRepository helloRepository;


    public WriteToFileService() {
    }


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
