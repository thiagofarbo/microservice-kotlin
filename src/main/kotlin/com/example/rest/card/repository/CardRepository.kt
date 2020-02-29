package com.example.rest.card.repository

import com.example.rest.card.domain.Card
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CardRepository : JpaRepository<Card, Long>{
}