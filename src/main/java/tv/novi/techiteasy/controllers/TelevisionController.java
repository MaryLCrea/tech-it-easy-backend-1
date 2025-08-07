package tv.novi.techiteasy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tv.novi.techiteasy.dtos.TelevisionRequestDto;
import tv.novi.techiteasy.dtos.TelevisionResponseDto;
import tv.novi.techiteasy.services.TelevisionService;

import java.net.URI;
import java.util.List;



@RestController
@RequestMapping("/televisions")
public class TelevisionController {

    private final TelevisionService televisionService;

    @Autowired
    public TelevisionController(TelevisionService televisionService) {
        this.televisionService = televisionService;
    }


    @GetMapping
    public ResponseEntity<List<TelevisionResponseDto>> getAllTelevisions() {
        List<TelevisionResponseDto> televisions = televisionService.getAllTelevisions();
        return ResponseEntity.ok(televisions);
    }


    @GetMapping("/{id}")
    public ResponseEntity<TelevisionResponseDto> getOneTelevision(@PathVariable Long id) {
        TelevisionResponseDto television = televisionService.getTelevisionById(id);
        return ResponseEntity.ok().body(television);
    }


    @PostMapping
    public ResponseEntity<TelevisionResponseDto> postTelevision(@RequestBody TelevisionRequestDto inputDto) {
        TelevisionResponseDto saved = televisionService.saveTelevision(inputDto);
        return ResponseEntity.created(URI.create("/televisions/" + saved.getId())).body(saved);
    }


    @PutMapping("/{id}")
    public ResponseEntity<TelevisionResponseDto> update(@PathVariable Long id, @RequestBody TelevisionRequestDto inputDto) {
        TelevisionResponseDto updatedDto = televisionService.updateTelevision(id, inputDto);
        return ResponseEntity.ok(updatedDto);
    }

   @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTelevision(@PathVariable Long id) {
        televisionService.deleteTelevision(id);
        return ResponseEntity.noContent().build();
    }
}
