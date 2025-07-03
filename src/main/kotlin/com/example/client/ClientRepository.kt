package com.example.client

import com.example.client.model.Client
import io.micronaut.data.annotation.Join
import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.repository.CrudRepository

@JdbcRepository(dialect = Dialect.POSTGRES)
@Join(value = "relationship.status", type = Join.Type.LEFT_FETCH)
interface ClientRepository : CrudRepository<Client, Long>