package com.example.rest.card.service

import com.example.rest.card.domain.Card
import com.example.rest.card.repository.CardRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
public class CardService {
////        val resumoUm: Resumo = Resumo()
    @Autowired
    lateinit var cardRepository: CardRepository

    public fun createCard(card:Card): Card {
        var createdCard: Card = this.cardRepository.save(card)
        return card;
    }

    public fun findCard(cardId:Long): Card {
        var card: Optional<Card> = this.cardRepository.findById(cardId)
        if(!card.isPresent()){
            throw Exception("Card not found.")
        }
        return card.get();
    }
}