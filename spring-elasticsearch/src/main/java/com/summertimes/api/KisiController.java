package com.summertimes.api;

import com.summertimes.entity.Kisi;
import com.summertimes.repository.KisiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.List;

@RequestMapping("/kisi")
@RestController
public class KisiController {

    @Autowired
    private  KisiRepository kisiRepository;


    @PostConstruct
    public void init(){
        Kisi kisi =new Kisi();
        kisi.setAd("Hilal");
        kisi.setSoyad("Deneme");
        kisi.setAdres("test");
        kisi.setDogumTarihi("25.03.1995");
        kisi.setId("K0002");
        kisiRepository.save(kisi);
    }

    @GetMapping("/{search}")
    public ResponseEntity<List<Kisi>> getKisi(@PathVariable String search) {
        List<Kisi> kisiler = kisiRepository.getByCustomQuery(search);
        return ResponseEntity.ok(kisiler);
    }

}
