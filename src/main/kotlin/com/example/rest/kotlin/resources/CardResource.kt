package com.example.rest.kotlin.resources

import com.example.rest.kotlin.domain.Card
import com.example.rest.kotlin.service.CardService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class CardResource {

    @Autowired
    lateinit var service: CardService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/cards")
    fun create(@RequestBody card: Card): ResponseEntity<Card> {
        return ResponseEntity.ok(this.service.createCard(card));
     }
}