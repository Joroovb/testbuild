package nl.joris.joris.service;

import nl.joris.joris.model.Chip;
import nl.joris.joris.model.Kat;
import nl.joris.joris.repository.ChipRepository;
import nl.joris.joris.repository.KatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ChipService {

    @Autowired
    ChipRepository chipRepository;

    @Autowired
    KatRepository katRepository;

    public Chip newChip(Kat kat, Chip chip) {
        chip.setKat(kat);
        return chipRepository.save(chip);
    }
}
