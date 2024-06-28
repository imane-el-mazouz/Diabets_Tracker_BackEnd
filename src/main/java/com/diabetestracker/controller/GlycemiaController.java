package com.diabetestracker.controller;

import com.diabetestracker.model.Glycemie;
import com.diabetestracker.service.GlycemieService;
import com.diabetestracker.model.User;
import com.diabetestracker.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/glycemies")
@CrossOrigin(origins = "http://localhost:4200")
public class GlycemiaController {

    @Autowired
    private GlycemieService glycemieService;

    @Autowired
    private UserService userService;

    @GetMapping
    public List<Glycemie> getAllGlycemies() {
        return glycemieService.getAllGlycemies();
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
    public Glycemie updateGlycemie(@PathVariable Long id, @RequestBody Glycemie glycemie) {
        glycemie.setId(id);
        return glycemieService.saveGlycemie(glycemie);
    }

    @DeleteMapping("/{id}")
    public void deleteGlycemie(@PathVariable Long id) {
        glycemieService.deleteGlycemieById(id);
    }


}
