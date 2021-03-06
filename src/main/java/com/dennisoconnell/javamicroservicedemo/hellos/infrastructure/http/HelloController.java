package com.dennisoconnell.javamicroservicedemo.hellos.infrastructure.http;
import com.dennisoconnell.javamicroservicedemo.hellos.domain.Gratitude;
import com.dennisoconnell.javamicroservicedemo.hellos.domain.GratitudeDto;
import com.dennisoconnell.javamicroservicedemo.hellos.domain.Hello;
import com.dennisoconnell.javamicroservicedemo.hellos.domain.HelloDto;
import com.dennisoconnell.javamicroservicedemo.hellos.infrastructure.file.WriteToFileService;
import com.dennisoconnell.javamicroservicedemo.hellos.infrastructure.mysql.HelloRepository;
import com.dennisoconnell.javamicroservicedemo.hellos.services.HelloService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.ValidationException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import java.util.stream.Collectors;

// Spring Controller REST methods are by default Asynchronized.
@RestController
@RequestMapping(value = "/api/v1/")
public class HelloController {

    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private HelloRepository helloRepository;

    @Autowired
    private WriteToFileService writeToFileService;

    @Autowired
    private HelloService helloService;

    @Async
    @GetMapping(value = "hello/check")
    public ResponseEntity<HelloDto> checkLogicHello() {
        Hello hello = new Hello("dennis");
        hello.AddGratitude(new Gratitude("Family","Mothers Day","Grateful for All Mothers",hello));
        return new ResponseEntity<>(hello.toDto(), HttpStatus.OK);
    }

    @GetMapping(value = "hello")
    public ResponseEntity<List<HelloDto>> getAllHello() {
        Iterable<Hello> hellos =  helloRepository.findAll();
        List<HelloDto> helloDtos = new ArrayList<>();
        for(Hello hello : hellos){
            helloDtos.add(hello.toDto());
        }
        return new ResponseEntity<>(helloDtos, HttpStatus.OK);
    }

    @GetMapping(value = "hello/{id}")
    public  ResponseEntity<HelloDto> getById(@PathVariable Integer id){
        return new ResponseEntity<>(helloRepository.findById(id).get().toDto(), HttpStatus.OK);
    }

    @Async
    @GetMapping(value = "hello/write/{id}")
    public Callable<ResponseEntity> getWriteToFileById(@PathVariable Integer id) throws Exception{
        writeToFileService.WriteHelloToFile(id);
        return new Callable<ResponseEntity>() {
            @Override
            public ResponseEntity call() throws Exception {
                return new ResponseEntity(HttpStatus.OK);
            }
        };
    }

    @PostMapping(value = "hello")
    public  ResponseEntity<HelloDto> postHello(@Valid @RequestBody HelloDto helloDto) throws Exception{
        return new ResponseEntity<>(helloService.CreateHello(helloDto).toDto(), HttpStatus.OK);
    }

    @GetMapping(value ="hello/search")
    public ResponseEntity<List<HelloDto>> getByParams(@Valid @RequestParam(value="name", required = true) String name){
        if(!name.isEmpty()) {
            return new ResponseEntity<>(helloRepository.findByName(name).stream().map(h -> h.toDto()).collect(Collectors.toList()), HttpStatus.OK);
        } else throw  new ValidationException("Client not specified.");
    }

    @PatchMapping(value = "hello")
    public  ResponseEntity<HelloDto> patchHello(@Valid @RequestBody HelloDto helloDto){
        if(helloDto.helloId > 0){

            Hello hello = new Hello(helloDto.name);
            for(GratitudeDto gratitudeDto : helloDto.gratitudes){
                if(gratitudeDto.gratitudeId > 0){
                    hello.GratitudeList.add(new Gratitude(gratitudeDto.gratitudeId, gratitudeDto.category, gratitudeDto.title, gratitudeDto.reason, hello));
                }
            }
            return new ResponseEntity<>(helloRepository.save(hello).toDto(), HttpStatus.OK);
        } else throw new ValidationException("Hello can not be created");
    }

    @DeleteMapping(value = "hello")
    public ResponseEntity deleteHello(@Valid @RequestBody HelloDto helloDto){
        if(this.helloRepository.findById(helloDto.helloId).isPresent()){
            helloRepository.deleteById(helloDto.helloId);
            return new ResponseEntity<>(HttpStatus.OK);
        } else throw new ValidationException("Hello can not be deleted");
    }

}
