package com.dennisoconnell.javamicroservicedemo.hellos.services;


import com.dennisoconnell.javamicroservicedemo.hellos.domain.Gratitude;
import com.dennisoconnell.javamicroservicedemo.hellos.domain.GratitudeDto;
import com.dennisoconnell.javamicroservicedemo.hellos.domain.Hello;
import com.dennisoconnell.javamicroservicedemo.hellos.domain.HelloDto;
import com.dennisoconnell.javamicroservicedemo.hellos.infrastructure.mysql.GratitudeRepository;
import com.dennisoconnell.javamicroservicedemo.hellos.infrastructure.mysql.HelloRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    private static final Logger log = LoggerFactory.getLogger(HelloService.class);

    @Autowired
    private HelloRepository helloRepository;

    @Autowired
    private GratitudeRepository gratitudeRepository;

    public Hello CreateHello(HelloDto helloDto) throws Exception{
        if(helloDto.helloId == 0) {

            Hello hello = new Hello(helloDto.name);
            for(GratitudeDto gratitudeDto : helloDto.gratitudes) {
                if (gratitudeDto.gratitudeId == 0) {
                    hello.GratitudeList.add(new Gratitude(gratitudeDto.category, gratitudeDto.title, gratitudeDto.reason, hello));
                }
            }
            return helloRepository.save(hello);
        } else throw  new Exception("Can not create an already existing entity");
    }
}
