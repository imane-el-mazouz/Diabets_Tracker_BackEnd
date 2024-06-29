package com.diabetestracker.controller;

import com.diabetestracker.model.Glycemie;
import com.diabetestracker.service.GlycemieService;
import com.diabetestracker.model.User;
import com.diabetestracker.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/glycemies")
public class GlycemiaController {

    @Autowired
    private GlycemieService glycemieService;

    @Autowired
    private UserService userService;

    @GetMapping
    public List<Glycemie> getAllGlycemies() {
        return glycemieService.getAllGlycemies();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Glycemie> getGlycemieById(@PathVariable Long id) {
        Glycemie glycemie = glycemieService.getGlycemieById(id);
        if (glycemie != null) {
            return ResponseEntity.ok(glycemie);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
//    @GetMapping("/{id}")
//    public Glycemie getGlycemieById(@PathVariable Long id) {
//        return glycemieService.getGlycemieById(id);
//    }

    @PostMapping
    public Glycemie saveGlycemie(@RequestBody Glycemie glycemie) {
        return glycemieService.saveGlycemie(glycemie);
    }

    @PutMapping("/{id}")
    public Glycemie updateGlycemie(@PathVariable Long id, @RequestBody Glycemie updatedGlycemie) {
        Glycemie existingGlycemie = glycemieService.getGlycemieById(id);

        if (existingGlycemie != null) {
            existingGlycemie.setValue(updatedGlycemie.getValue());
            existingGlycemie.setUnit(updatedGlycemie.getUnit());
            existingGlycemie.setDate(updatedGlycemie.getDate());
            existingGlycemie.setMealTime(updatedGlycemie.getMealTime());
            existingGlycemie.setSource(updatedGlycemie.getSource());
            return glycemieService.saveGlycemie(existingGlycemie);
        } else {
            throw new RuntimeException("Glycemie not found with id: " + id);
        }
    }


    @DeleteMapping("/{id}")
    public void deleteGlycemie(@PathVariable Long id) {
        glycemieService.deleteGlycemieById(id);
    }





}
