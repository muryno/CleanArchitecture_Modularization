package com.muryno.data.utils

abstract class ApiDataToDomainMapper<INPUT : Any, OUTPUT : Any> {
    fun toDomain(input: INPUT): OUTPUT = try {
        map(input)
    } catch (throwable: Throwable) {
        throw MapperException("Could not map ${input::class.simpleName} to Domain", throwable)
    }

    protected abstract fun map(input: INPUT): OUTPUT
}