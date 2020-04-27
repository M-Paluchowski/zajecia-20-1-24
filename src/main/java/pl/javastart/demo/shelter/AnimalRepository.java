package pl.javastart.demo.shelter;

import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

//@Component
//@Service
@Repository
public class AnimalRepository {

    private Set<Animal> animals = new HashSet<>();

    public AnimalRepository() {
        this.animals.add(new Animal("Azor",
                "Azor to super piesek",
                "https://www.psy.pl/wp-content/uploads/2017/05/szczesliwy-pies.jpg",
                AnimalSpecies.DOG));
        this.animals.add(new Animal("Rudy",
                "Rudy to jest super kot",
                "https://www.zooplus.pl/magazyn/wp-content/uploads/2018/07/szcz%C4%99%C5%9Bliwy-kot-768x513.jpg",
                AnimalSpecies.CAT));
        this.animals.add(new Animal("Makak",
                "Makak to super małpka",
                "https://zasoby.ekologia.pl/animal/a/599/makak-magot.jpg",
                AnimalSpecies.OTHER));
    }

    public Animal findByName(String name) {

        for (Animal animal : animals) {
            if (animal.getName().equals(name)) {
                return animal;
            }
        }

        return null;
    }

    public Set<Animal> findAll() {
        return new HashSet<>(this.animals);
    }

    public Set<Animal> findBySpecies(AnimalSpecies species) {
        return animals.stream()
                .filter(animal -> animal.getSpecies() == species)
                .collect(toSet());
    }
}
