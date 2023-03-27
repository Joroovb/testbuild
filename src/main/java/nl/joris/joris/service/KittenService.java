package nl.joris.joris.service;

import nl.joris.joris.controller.KittenRepository;
import nl.joris.joris.model.Kat;
import nl.joris.joris.model.Kitten;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class KittenService {

    @Autowired
    KittenRepository kittenRepository;

    public Kitten birthNewKitten(Kat kat, Kitten kitten) {
        kitten.setKat(kat);
        return kittenRepository.save(kitten);
    }
}
