package se.magnus.microservices.core.recommendation

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RecommendationServiceApplication

fun main(args: Array<String>) {
	runApplication<RecommendationServiceApplication>(*args)
}
