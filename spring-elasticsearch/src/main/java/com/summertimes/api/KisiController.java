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
        kisi.setAd("Elif");
        kisi.setSoyad("Taş");
        kisi.setAdres("test");
        kisi.setDogumTarihi("25.03.1995");
        kisi.setId("K0003");

        kisiRepository.save(kisi);
        Kisi kisi2 =new Kisi();
        kisi2.setAd("Ahmet");
        kisi2.setSoyad("Gürbüz");
        kisi2.setAdres("test");
        kisi2.setDogumTarihi("25.03.1993");
        kisi2.setId("K0004");
        kisiRepository.save(kisi2);
    }

    /*
    @GetMapping("/{search}")
    public ResponseEntity<List<Kisi>> getKisi(@PathVariable String search) {
        List<Kisi> kisiler = kisiRepository.getByCustomQuery(search);
        return ResponseEntity.ok(kisiler);
    }

     */
    @GetMapping("/{search}")
    public ResponseEntity<List<Kisi>> getKisi(@PathVariable String search) {
        List<Kisi> kisiler = kisiRepository.findByAdLikeOrSoyadLike(search, search);
        return ResponseEntity.ok(kisiler);
    }
}
