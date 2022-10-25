package com.muryno.presention.utils

abstract class DomainToPresentationMapper<INPUT : Any, OUTPUT : Any> {
    fun toPresentation(input: INPUT): OUTPUT = try {
        map(input)
    } catch (throwable: Throwable) {
        throw MapperException("Could not map ${input::class.simpleName} to Presentation", throwable)
    }

    protected abstract fun map(input: INPUT): OUTPUT
}