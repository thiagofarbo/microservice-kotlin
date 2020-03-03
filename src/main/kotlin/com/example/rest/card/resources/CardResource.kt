package com.example.rest.card.resources

import com.example.rest.card.domain.Card
import com.example.rest.card.request.CardRequest
import com.example.rest.card.request.CardResponse
import com.example.rest.card.service.CardService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
@Api(value = "/cards", description = "Resources to manage cards")
@ApiOperation(value = "Cards", notes = "Resources to manage cards", response = CardResource::class)
@ApiResponses(
        value = *arrayOf(
                ApiResponse(code = 201, message = "Created"),
                ApiResponse(code = 401, message = "You are not authorized access the resource"),
                ApiResponse(code = 404, message = "Resource not found")
        )
)
class CardResource {

    @Autowired
    lateinit var service: CardService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/cards")
    @ApiOperation(value = "Create a card ", response = CardResource::class)
    open fun create(@Valid @RequestBody card: Card): ResponseEntity<Card> {
        return ResponseEntity.ok(this.service.createCard(card));
     }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/cards/{cardId}")
    @ApiOperation(value = "Find a card by card id ", response = CardResource::class)
    open fun findCardById(@PathVariable("cardId") cardId: Long): ResponseEntity<Card> {
        return ResponseEntity.ok(this.service.findCard(cardId));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/cards")
    @ApiOperation(value = "List all cards", response = CardResource::class)
    open fun listCards(@RequestParam(defaultValue = "0") page: Int, @RequestParam(defaultValue = "50") size: Int): ResponseEntity<Page<Card>> {
        return ResponseEntity.ok(this.service.listCards(page, size));
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/cards/{cardId}")
    @ApiOperation(value = "Delete a card by card id ", response = CardResource::class)
    open fun delete(@PathVariable("cardId") cardId: Long): ResponseEntity<String> {
        return ResponseEntity.ok(this.service.deleteCartd(cardId));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/cards/{cardId}")
    @ApiOperation(value = "Update a card ", response = CardResource::class)
    open fun update(@PathVariable("cardId") cardId: Long, @Valid @RequestBody cardRequest: CardRequest): ResponseEntity<CardResponse> {
        return ResponseEntity.ok(this.service.updateCartd(cardId, cardRequest));
    }
}