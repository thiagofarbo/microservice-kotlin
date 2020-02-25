package com.example.rest.kotlin.repository

import com.example.rest.kotlin.domain.Card
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CardRepository : JpaRepository<Card, Long>{
}