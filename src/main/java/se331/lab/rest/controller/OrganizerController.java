package se331.lab.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se331.lab.rest.dao.OrganizerImpl;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.service.OrganizerService;

import java.util.List;

@Controller
public class OrganizerController {
    @Autowired
    OrganizerService organizerService;

    @GetMapping("organizers")
    public ResponseEntity<?> getOrganizerLists(
        @RequestParam(value="_limit",required = false) Integer perPage,
        @RequestParam(value="_page",required = false) Integer page
    ){
        Page<Organizer> pageOutput = organizerService.getOrganizers(perPage,page);

        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count",String.valueOf(pageOutput.getTotalElements()));

        return new ResponseEntity<>(pageOutput.getContent(),responseHeader, HttpStatus.OK);
    }

    @GetMapping("organizers/{id}")
    public ResponseEntity<?> getOrganizer(@PathVariable("id") Long id){
        Organizer org = organizerService.getOrganizer(id);
        if(org != null){
            return ResponseEntity.ok(org);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The given id is not found");
        }
    }

    @PostMapping("/organizers")
    public ResponseEntity<?> addOrganizer(@RequestBody Organizer org){
        Organizer output = organizerService.save(org);
        return ResponseEntity.ok(org);
    }
}
