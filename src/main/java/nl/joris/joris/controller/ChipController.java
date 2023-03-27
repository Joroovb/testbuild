package nl.joris.joris.controller;

import nl.joris.joris.model.Chip;
import nl.joris.joris.service.ChipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/chip")
public class ChipController {

    @Autowired
    ChipService chipService;

//    //Create
//    @PostMapping("/{katid}/new")
//    public Chip newChip(@PathVariable(value = "katid") long katid, @RequestBody Chip chip) {
////        return chipService.newChip(katid, chip);
//    }
}
