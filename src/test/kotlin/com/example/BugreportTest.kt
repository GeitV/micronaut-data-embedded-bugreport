package com.example

import com.example.client.ClientRepository
import com.example.client.RelationshipStatusRepository
import com.example.client.model.Client
import com.example.client.model.Relationship
import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.test.extensions.kotest5.annotation.MicronautTest
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import kotlin.jvm.optionals.getOrNull

@MicronautTest
class BugreportTest(
    private val clientRepository: ClientRepository,
    private val relationshipStatusRepository: RelationshipStatusRepository
) : StringSpec({

    "client is saved with relationship status" {
        val status = relationshipStatusRepository.findById(1).getOrNull()

        status.shouldNotBeNull()
        status.name shouldBe "Active"

        // when
        val newClient = clientRepository.save(
            Client(
                name = "Active Client",
                relationship = Relationship(
                    status = status
                )
            )
        )

        // then
        newClient.name shouldBe "Active Client"
        newClient.relationship.status.should { savedStatus ->
            savedStatus.id shouldBe status.id
            savedStatus.name shouldBe status.name
        }
    }
})
