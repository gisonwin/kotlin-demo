package com.gison.samples.kotlindemo

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping("/")
class MessageController(private val service: MessageService) {
    //    @GetMapping
//    fun index(@RequestParam("name") name: String) = "Hello,$name"
    @GetMapping
    fun listMessages() = ResponseEntity.ok(service.findMessages())

//    @GetMapping("list")
//    fun listMessages() = listOf(
//        Message("1", "Hello!"),
//        Message("2", "Bonjour!"),
//        Message("3", "Privet!")
//    )

    @PostMapping
    fun post(@RequestBody message: Message): ResponseEntity<Message> {
        val savedMessage = service.save(message)
        return ResponseEntity.created(URI("/${savedMessage.id}")).body(savedMessage)
    }

    @GetMapping("/{id}")
    fun getMessage(@PathVariable id: String): ResponseEntity<Message> = service.findMessageById(id)?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()


}