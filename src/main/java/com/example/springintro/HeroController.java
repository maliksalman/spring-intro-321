package com.example.springintro;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/heroes")
public class HeroController {

    private final HeroRepository repository;

    public HeroController(HeroRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/{name}/{age}")
    public Hero addHero(@PathVariable("name") String name,
                        @PathVariable("age") int age) {
        return repository.save(new Hero(name, age));
    }

    @GetMapping
    public Iterable<Hero> listHeroes() {
        return repository.findAll();
    }
}
