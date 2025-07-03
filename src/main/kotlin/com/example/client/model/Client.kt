package com.example.client.model

import io.micronaut.data.annotation.*
import java.time.Instant

@MappedEntity
data class Client(
    @Id
    @GeneratedValue
    val id: Long? = null,
    val name: String,
    @Relation(value = Relation.Kind.EMBEDDED)
    val relationship: Relationship,

    @DateCreated
    val createdAt: Instant = Instant.now(),
    @DateUpdated
    val updatedAt: Instant = Instant.now()
)
