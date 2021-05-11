package se.magnus.util.http

import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

import org.springframework.http.HttpStatus.NOT_FOUND
import org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY
import org.springframework.http.server.reactive.ServerHttpRequest
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import se.magnus.util.exceptions.InvalidInputException
import se.magnus.util.exceptions.NotFoundException
import java.lang.Exception

@RestControllerAdvice
class GlobalControllerExceptionHandler {
    val LOG = LoggerFactory.getLogger(GlobalControllerExceptionHandler::class.java)

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(
        NotFoundException::class
    )
    @ResponseBody
    fun handleNotFoundExceptions(
        request: ServerHttpRequest,
        ex: Exception
    ): HttpErrorInfo {
        return createHttpErrorInfo(NOT_FOUND, request, ex)
    }

    @ResponseStatus(UNPROCESSABLE_ENTITY)
    @ExceptionHandler(
        InvalidInputException::class
    )
    @ResponseBody
    fun handleInvalidInputException(
        request: ServerHttpRequest,
        ex: Exception
    ): HttpErrorInfo {
        return createHttpErrorInfo(UNPROCESSABLE_ENTITY, request, ex)
    }

    private fun createHttpErrorInfo(
        httpStatus: HttpStatus,
        request: ServerHttpRequest,
        ex: Exception
    ): HttpErrorInfo {
        val path = request.path.pathWithinApplication().value()
        val message = ex.message
        LOG.debug(
            "Returning HTTP status: {} for path: {}, message: {}",
            httpStatus,
            path,
            message
        )
        return HttpErrorInfo(httpStatus, path, message!!)
    }
}