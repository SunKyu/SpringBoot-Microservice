package se.magnus.util.exceptions

import java.lang.RuntimeException

class InvalidInputException: RuntimeException{
    constructor(): super()
    constructor(message: String): super()
    constructor(message: String, cause: Throwable): super(message, cause)
    constructor(cause: Throwable): super(cause)
}