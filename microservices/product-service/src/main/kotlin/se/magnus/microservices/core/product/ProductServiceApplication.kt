package se.magnus.microservices.core.product

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
//import se.magnus.microservices.core.api3.ApiService.sum

@SpringBootApplication
class ProductServiceApplication

fun main(args: Array<String>) {
    //sum(10, 10)
	runApplication<ProductServiceApplication>(*args)
}
