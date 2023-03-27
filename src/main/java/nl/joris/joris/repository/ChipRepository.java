package nl.joris.joris.repository;

import nl.joris.joris.model.Chip;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface ChipRepository extends CrudRepository<Chip, Long> {
}
