package hu.tothlp.chatdemo.config

import org.springframework.context.annotation.Configuration
import org.springframework.messaging.simp.config.MessageBrokerRegistry
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker
import org.springframework.web.socket.config.annotation.StompEndpointRegistry
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer


@Configuration
@EnableWebSocketMessageBroker
class WebSocketConfiguration : WebSocketMessageBrokerConfigurer {
    override fun configureMessageBroker(registry: MessageBrokerRegistry) {

        // Set prefix for the endpoint that the client listens for our messages from
        registry.enableSimpleBroker("/topic")

        // Set prefix for endpoints the client will send messages to
        registry.setApplicationDestinationPrefixes("/app")
    }

    override fun registerStompEndpoints(registry: StompEndpointRegistry) {

        // Registers the endpoint where the connection will take place
        registry.addEndpoint("/stomp") // Allow the origin http://localhost:63343 to send messages to us. (Base URL of the client)
            .setAllowedOrigins("http://localhost:63343") // Enable SockJS fallback options
            .withSockJS()
    }
}