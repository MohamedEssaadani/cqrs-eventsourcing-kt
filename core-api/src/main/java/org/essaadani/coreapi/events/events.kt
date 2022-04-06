package org.essaadani.coreapi.events

import org.axonframework.modelling.command.TargetAggregateIdentifier

abstract class BaseCommand<T>(
        open val id: T
)

data class CustomerCreatedEvent(
        override val id: String,
        val name: String,
        val email: String
):BaseCommand<String>(id)

data class CustomerUpdatedEvent(
        override val id: String,
        val name: String,
        val email: String
):BaseCommand<String>(id)


