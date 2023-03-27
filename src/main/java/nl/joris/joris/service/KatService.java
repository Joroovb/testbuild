package nl.joris.joris.service;

import nl.joris.joris.model.Chip;
import nl.joris.joris.model.Kat;
import nl.joris.joris.model.Kitten;
import nl.joris.joris.repository.KatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class KatService {

    @Autowired
    KatRepository katRepository;

    @Autowired
    ChipService chipService;

    @Autowired
    KittenService kittenService;

    public Kat newKat(Kat kat) {
        return katRepository.save(kat);
    }

    public Iterable<Kat> getAllKatten() {
        return katRepository.findAll();
    }

    public Optional<Kat> getKayById(long id) {
        return katRepository.findById(id);
    }

    public String deleteKatById(long id) {
        if (katRepository.existsById(id)) {
            katRepository.deleteById(id);
            return "Goed gedaan!";
        }
        return "Die bestaat helaas niet";
    }

    public void deleteAllKatten() {
        katRepository.deleteAll();
    }

    public Kat updateKatById(long id, Kat kat) {
        if (!katRepository.existsById(id)) { // guard clause
            return null;
        }

        Kat oldKat = katRepository.findById(id).get();

        if (kat.getNaam() != null) {
            oldKat.setNaam(kat.getNaam());
        }

        if (kat.getLeeftijd() != null) {
            oldKat.setLeeftijd(kat.getLeeftijd());
        }

        return katRepository.save(oldKat);
    }

    public Kat addChipToKat(long id, Chip chip) {
        if (!katRepository.existsById(id)) {
            return null;
        }

        Kat kat = katRepository.findById(id).get();

        Chip tempChip = chipService.newChip(kat, chip);
        kat.setChip(tempChip);
        return katRepository.save(kat);
    }

    public Kat katGivesBirth(long id, Kitten kitten) {
        if (!katRepository.existsById(id)) {
            return null;
        }

        Kat kat = katRepository.findById(id).get();
        Kitten tempKitten = kittenService.birthNewKitten(kat, kitten);

        kat.getKittens().add(tempKitten);

        return katRepository.save(kat);
    }
}
