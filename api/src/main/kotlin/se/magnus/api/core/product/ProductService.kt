package se.magnus.api.core.product

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

interface ProductService {
    @GetMapping(
        "/product/{productId}",
        produces = arrayOf("appliction/json")
    )
    fun getProduct(@PathVariable productId: Int): Product
}