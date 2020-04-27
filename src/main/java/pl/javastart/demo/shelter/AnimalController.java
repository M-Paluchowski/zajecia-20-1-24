package pl.javastart.demo.shelter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static java.util.Objects.nonNull;

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
    String home(Model model,
                @RequestParam(required = false, name = "gatunek") AnimalSpecies species,
                @RequestParam(required = false) String order) {
        Set<Animal> animals;

        if (nonNull(species)) {
            animals = animalRepository.findBySpecies(species);
        } else {
            animals = animalRepository.findAll();
        }

        List<Animal> animalList = new ArrayList<>(animals);

        if (nonNull(order)) {
            int orderAsValue = (order.equals("ASC")) ? 1 : -1;
            animalList.sort((animalOne, animalTwo) -> animalOne.getName().compareTo(animalTwo.getName()) * orderAsValue);
        }

        model.addAttribute("animals", animalList);
        model.addAttribute("species", species);
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

    @GetMapping("/add")
    String addHome(Model model) {
        model.addAttribute("animal", new Animal());
        model.addAttribute("mode", "add");
        return "shelterAddAnimal";
    }

    @PostMapping("/add")
    String add(Animal animal) {
        System.out.println(animal);

        animalRepository.add(animal);
        return "redirect:/shelter/animal?name=" + animal.getName();
    }

    @GetMapping("/edit")
    String editForm(Model model, @RequestParam String name) {
        Animal animal = animalRepository.findByName(name);
        model.addAttribute("animal", animal);
        model.addAttribute("mode", "edit");
        return "shelterAddAnimal";
    }

    @PostMapping("/edit")
    String edit(Animal animalFromForm) {
        //TODO do zmiany na id
        Animal animalToChange = animalRepository.findByName(animalFromForm.getName());
        animalToChange.setDescription(animalFromForm.getDescription());
        animalToChange.setImageUrl(animalFromForm.getImageUrl());
        animalToChange.setName(animalFromForm.getName());
        animalFromForm.setSpecies(animalFromForm.getSpecies());

        //TODO tutaj powinien być jeszcze update w bazie

        return "redirect:/shelter/animal?name=" + animalToChange.getName();
    }
}
