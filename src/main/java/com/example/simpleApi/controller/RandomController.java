package com.example.simpleApi.controller;

import com.example.simpleApi.model.RandomGenerator;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/random")
public class RandomController {
    @RequestMapping(value="/letters")
    public @ResponseBody
    String getRandomLetters(){
        return new RandomGenerator().generateRandomLetters(100);
    }
    @RequestMapping(value="/letters/{n}")
    public @ResponseBody
    String getNRandomLetters(@PathVariable int n){
        return new RandomGenerator().generateRandomLetters(n);
    }
    @RequestMapping(value="/words")
    public @ResponseBody
    String getWords(){
        return new RandomGenerator().generateRandomWords();
    }
    @RequestMapping(value="/words/{n}")
    public @ResponseBody
    String getWords(@PathVariable int n){
        return new RandomGenerator().generateRandomWords(n);
    }
}
