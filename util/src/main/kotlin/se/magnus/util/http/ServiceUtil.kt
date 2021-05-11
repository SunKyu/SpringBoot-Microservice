package se.magnus.util.http

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.net.InetAddress
import java.net.UnknownHostException

@Component
class ServiceUtil(
    @Value("\${server.port}")
    val port: String?
) {
    private val LOG = LoggerFactory.getLogger(ServiceUtil::class.java)
    private var serviceAddress: String? = null

    fun getServiceAddress(): String? {
        if (serviceAddress == null) {
            serviceAddress = findMyHostname() + "/" + findMyIpAddress() + ":" + port
        }
        return serviceAddress
    }

    private fun findMyHostname(): String? {
        return try {
            InetAddress.getLocalHost().hostName
        } catch (e: UnknownHostException) {
            "unknown host name"
        }
    }

    private fun findMyIpAddress(): String? {
        return try {
            InetAddress.getLocalHost().hostAddress
        } catch (e: UnknownHostException) {
            "unknown IP address"
        }
    }
}