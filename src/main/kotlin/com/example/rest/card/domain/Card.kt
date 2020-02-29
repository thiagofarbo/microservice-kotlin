package com.example.rest.card.domain

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer
import lombok.AllArgsConstructor
import lombok.NoArgsConstructor
import java.math.BigDecimal
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name="card")
@AllArgsConstructor
@NoArgsConstructor
class Card (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,
    val name: String,
    val amout: BigDecimal,

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
    @JsonSerialize(using = LocalDateSerializer::class)
    @JsonDeserialize(using = LocalDateDeserializer::class)
    val expirationDate: LocalDate,
    val status:StatusCard
)