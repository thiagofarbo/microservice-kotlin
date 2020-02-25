package com.example.rest.kotlin.service

import com.example.rest.kotlin.domain.Card
import com.example.rest.kotlin.repository.CardRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CardService {

    @Autowired
    lateinit var cardRepository: CardRepository

    fun createCard(card:Card): Card {
        var createdCard: Card = this.cardRepository.save(card)
        println(createdCard)
        return card;
    }
}