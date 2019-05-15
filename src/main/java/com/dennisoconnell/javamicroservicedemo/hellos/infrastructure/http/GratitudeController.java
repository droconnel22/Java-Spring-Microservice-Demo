package com.dennisoconnell.javamicroservicedemo.hellos.infrastructure.http;


import com.dennisoconnell.javamicroservicedemo.hellos.domain.Gratitude;
import com.dennisoconnell.javamicroservicedemo.hellos.domain.GratitudeDto;
import com.dennisoconnell.javamicroservicedemo.hellos.infrastructure.mysql.GratitudeRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.ValidationException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/")
public class GratitudeController {
    private static final Logger log = LoggerFactory.getLogger(GratitudeController.class);

    @Autowired
    private GratitudeRepository gratitudeRepository;

    @GetMapping(value = "gratitude")
    public  ResponseEntity<List<GratitudeDto>> getAllGratitudes(){
        return new ResponseEntity<>(gratitudeRepository.findAll().stream().map(g -> g.toDto()).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping(value = "gratitude/{id}")
    public  ResponseEntity<GratitudeDto> getById(@PathVariable Integer id){
        return new ResponseEntity<>(gratitudeRepository.findById(id).get().toDto(), HttpStatus.OK);
    }

    @GetMapping(value ="gratitude/search")
    public ResponseEntity<List<GratitudeDto>> getByParams(@Valid @RequestParam(value="category", required = true) String category) throws Exception{
        if(!category.isEmpty()) {
            List<Gratitude>gratitudeList = gratitudeRepository.findByCategory(category);
            return new ResponseEntity<>(gratitudeList.stream().map(g -> g.toDto()).collect(Collectors.toList()), HttpStatus.OK);
        } else throw  new ValidationException("Client not specified.");
    }


    @PatchMapping(value = "gratitude")
    public  ResponseEntity<GratitudeDto> patchGratitude(@Valid @RequestBody GratitudeDto gratitudeDto){
        if(gratitudeDto.gratitudeId > 0){
            //Integer Id, String category, String title, String reason, Hello hello
            Date createdDate =  new Date(gratitudeDto.createdOn);
            Gratitude gratitude = new Gratitude(gratitudeDto.gratitudeId, gratitudeDto.category, gratitudeDto.title, gratitudeDto.reason,createdDate);
            return new ResponseEntity<>(gratitudeRepository.save(gratitude).toDto(), HttpStatus.OK);
        } else throw new ValidationException("Gratitude can not be patched");
    }

    @DeleteMapping(value = "gratitude/{id}")
    public ResponseEntity deleteGratitude(@PathVariable Integer Id){
        if(gratitudeRepository.findById(Id).isPresent()){
            gratitudeRepository.deleteById(Id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else throw new ValidationException("Gratitude can not be deleted");
    }
}
