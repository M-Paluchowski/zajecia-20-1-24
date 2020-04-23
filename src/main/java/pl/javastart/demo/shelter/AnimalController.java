package pl.javastart.demo.shelter;

import javafx.scene.text.FontPosture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

@Controller
@RequestMapping("/shelter")
public class AnimalController {

//    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    public AnimalController(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @GetMapping
    String home(Model model) {
        Set<Animal> animals = animalRepository.findAll();
        model.addAttribute("animals", animals);
        return "shelterIndex";
    }

    @GetMapping("/animal")
    String details(@RequestParam String name, Model model) {
        Animal animal = animalRepository.findByName(name);

        if (animal != null) {
            model.addAttribute("animal", animal);
            return "shelterAnimalSite";
        } else {
            return "redirect:/";
        }
    }
}
