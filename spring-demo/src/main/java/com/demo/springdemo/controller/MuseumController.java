package com.demo.springdemo.controller;

import com.demo.springdemo.model.City;
import com.demo.springdemo.model.Museum;
import com.demo.springdemo.repository.MuseumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MuseumController {
    @Autowired

    MuseumRepository museumRepository;

    @GetMapping(value = "/Museum")
    public String initM(Model model){

      /*  List<Museum> museumList = List.of(
                new Museum("Louvre Museum", "Rue de Rivoli", 9334000, "Art", "Paris"  ),
                new Museum("National Museum of Natural History", "10th NW St & Constitution Ave", 8000000, "Natural History", "Washington DC" ),
                new Museum("National Museum of China", "16 E Chang'an Ave", 7450000, "History", "Beijing"),
                new Museum("National Air and Space Museum", "Independence Ave at 6th St SW", 6970000, "Science", "Washington DC"),
                new Museum("British Museum", "Great Russell St", 6701000, "History", "London"),
                new Museum("The Metropolitan Museum of Art", "E 82nd St at 5th Ave",6280000, "Art", "New York City"),
                new Museum("National Gallery","Trafalgar Square", 6031000, "Art","London"),
                new Museum("Vatican Museums","Viale Vaticano", 5459000, "Art", "Rome"),
                new Museum("Natural History Museum", "Cromwell Road", 5250000, "Natural History", "London"),
                new Museum("National Palace Museum","No. 221, Section 2, Zhishan Road", 4412000, "Art", "Taipei"),
                new Museum("Shanghai Science and Technology Museum", "2000 Century Avenue",3580000,"Science","Shanghai"),
                new Museum("Rodin Museum", "77 Rue de Varenne 75007", 700000, "Sculpture", "Paris")
        );*/

        List<Museum> museumList = museumRepository.findAll();
        model.addAttribute("museumList", museumList);

        return "Museum";
    }
    @GetMapping(value = "/FormM")
    public String initFM(Model model){
        Museum museum = new Museum();
        model.addAttribute("museum", museum);
        return "FormM";
    }

    @PostMapping(value = "/submitM")
    public String submitC(@ModelAttribute Museum museum){
        System.out.println("Museum added!");
        saveMuseum(museum);
        return "Index";
    }

    private void saveMuseum(Museum museum) {
        museumRepository.save(museum);
    }

}
