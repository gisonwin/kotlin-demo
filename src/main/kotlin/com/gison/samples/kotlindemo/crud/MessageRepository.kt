package com.gison.samples.kotlindemo.crud

import org.springframework.data.repository.CrudRepository

interface MessageRepository : CrudRepository<Message, String>