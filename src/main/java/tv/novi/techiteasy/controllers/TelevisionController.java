package tv.novi.techiteasy.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/televisions")

public class TelevisionController {

    private final List<String> database;

    public TelevisionController() {
        this.database = new ArrayList<>();
    }

    @GetMapping
    public ResponseEntity<List<String>> getTelevision(@RequestParam(required = false) String name) {
        if (name != null) {
            List<String> toReturn = new ArrayList<>();
            for (String television : database) {
                if (television.contains(name)) {
                    toReturn.add(television);
                }
            }
            return ResponseEntity.ok(toReturn);
        } else {
            return ResponseEntity.ok(database);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getOneTelevision(@PathVariable int id) {
        String television = database.get(--id);
        return ResponseEntity.ok(television);
    }

    @PostMapping
    public ResponseEntity<?> postTelevision(@RequestBody String television) {
        database.add(television.trim());
        return ResponseEntity.created(URI.create("localhost:8080/televisions/" + database.size())).build();

    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateTelevision(@PathVariable int id, @RequestBody String updatedTelevision) {
        try {
            database.set(id - 1, updatedTelevision.trim());
            return ResponseEntity.ok("Television updated.");
        } catch (IndexOutOfBoundsException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTelevision(@PathVariable int id) {
        return ResponseEntity.ok("Television deleted.");
    }

}
