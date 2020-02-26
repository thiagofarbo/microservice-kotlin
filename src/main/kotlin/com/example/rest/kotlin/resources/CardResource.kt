package com.example.rest.kotlin.resources

import com.example.rest.kotlin.domain.Card
import com.example.rest.kotlin.service.CardService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

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
    fun create(@RequestBody card: Card): ResponseEntity<Card> {
        return ResponseEntity.ok(this.service.createCard(card));
     }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/cards/{cardId}")
    @ApiOperation(value = "Find a card by card id ", response = CardResource::class)
    fun findCardById(@PathVariable("cardId") cardId: Long): ResponseEntity<Card> {
        return ResponseEntity.ok(this.service.findCard(cardId));
    }
}