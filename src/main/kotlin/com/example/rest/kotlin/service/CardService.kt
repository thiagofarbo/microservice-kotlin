package com.example.rest.kotlin.service

import com.example.rest.kotlin.domain.Card
import com.example.rest.kotlin.repository.CardRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import javax.validation.constraints.Null
import javax.xml.ws.http.HTTPException

@Service
class CardService {
////        val resumoUm: Resumo = Resumo()
    @Autowired
    lateinit var cardRepository: CardRepository

    fun createCard(card:Card): Card {
        var createdCard: Card = this.cardRepository.save(card)
        return card;
    }

    fun findCard(cardId:Long): Card {
        var card: Optional<Card> = this.cardRepository.findById(cardId)
        if(!card.isPresent()){
            throw Exception("Card not found.")
        }
        return card.get();
    }
}