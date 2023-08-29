package hu.tothlp.chatdemo.chat

import hu.tothlp.chatdemo.chat.dto.Message
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller


@Controller
class MessageController {
    // Handles messages from /app/chat. (Note the Spring adds the /app prefix for us).
    @MessageMapping("/chat") // Sends the return value of this method to /topic/messages
    @SendTo("/topic/messages")
    fun getMessages(dto: Message): Message = dto
}