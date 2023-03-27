package nl.joris.joris.controller;

import nl.joris.joris.model.Kitten;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface KittenRepository extends CrudRepository<Kitten, Long> {
}
