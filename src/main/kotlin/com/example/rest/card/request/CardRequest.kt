package com.example.rest.card.request
import com.example.rest.card.domain.StatusCard
import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.NoArgsConstructor
import java.io.Serializable
import java.math.BigDecimal
import java.time.LocalDate

@Builder
@NoArgsConstructor
@AllArgsConstructor
open class CardRequest (
        val id: Long,
        val name: String,
        val amout: BigDecimal,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
        @JsonSerialize(using = LocalDateSerializer::class)
        @JsonDeserialize(using = LocalDateDeserializer::class)
        val expirationDate: LocalDate,
        val status: StatusCard
): Serializable{


}