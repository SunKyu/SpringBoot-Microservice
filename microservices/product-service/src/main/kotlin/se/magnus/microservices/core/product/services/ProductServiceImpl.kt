package se.magnus.microservices.core.product.services

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.RestController
import se.magnus.api.core.product.Product
import se.magnus.api.core.product.ProductService
import se.magnus.util.exceptions.InvalidInputException
import se.magnus.util.exceptions.NotFoundException
import se.magnus.util.http.ServiceUtil

@RestController
class ProductServiceImpl(
    val serviceUtil: ServiceUtil
): ProductService {
    private val LOG = LoggerFactory.getLogger(ProductServiceImpl::class.java)

    override fun getProduct(productId: Int): Product {
        LOG.debug("/product return the found product for productId={}", productId)

        if (productId < 1) throw InvalidInputException("Invalid productId: $productId")

        if (productId == 13) throw NotFoundException("No product found for productId: $productId")

        return Product(productId, "name-" + productId, 123, serviceUtil.getServiceAddress())
    }
}