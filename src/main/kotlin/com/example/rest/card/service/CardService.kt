package com.example.rest.card.service

import com.example.rest.card.domain.Card
import com.example.rest.card.repository.CardRepository
import com.example.rest.card.request.CardRequest
import com.example.rest.card.request.CardResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import java.util.*

@Service
open class CardService {

    @Autowired
    lateinit var cardRepository: CardRepository

    open fun createCard(card:Card): Card {
        var createdCard: Card = this.cardRepository.save(card)
        return card;
    }

    open fun findCard(cardId:Long): Card {
        var card: Optional<Card> = this.cardRepository.findById(cardId)
        if(!card.isPresent()){
            throw Exception("Card not found.")
        }
        return card.get();
    }

    open fun listCards(page: Int, size: Int): Page<Card> {
        var cards = this.cardRepository.findAll(PageRequest.of(page, size))
        if(cards.isEmpty()){
            throw Exception("Card not found.")
        }
        return cards;
    }

    open fun updateCartd(cardId:Long, cardRequest: CardRequest): CardResponse {
        var card: Optional<Card> = this.cardRepository.findById(cardId!!)

        if(!card.isPresent()){
            throw Exception("Card not found.")
        }

        val cardUpdate: Card = Card(card.get().id, cardRequest.name, cardRequest.amout, cardRequest.expirationDate, cardRequest.status)
        var cardSaved: Card = this.cardRepository.save(cardUpdate)

        return CardResponse(cardSaved.id, cardSaved.name, cardSaved.amout, cardSaved.expirationDate, cardSaved.status)

    }

    open fun deleteCartd(cardId:Long): String {
        var card: Optional<Card> = this.cardRepository.findById(cardId)
        if(!card.isPresent()){
            throw Exception("Card not found.")
        }
        this.cardRepository.deleteById(cardId);
        return "Card deleted";
    }

}