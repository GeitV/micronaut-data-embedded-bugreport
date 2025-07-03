package com.example.client

import com.example.client.model.RelationshipStatus
import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.repository.CrudRepository

@JdbcRepository(dialect = Dialect.POSTGRES)
interface RelationshipStatusRepository : CrudRepository<RelationshipStatus, Long>