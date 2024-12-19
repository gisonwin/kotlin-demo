package com.gison.samples.kotlindemo.h2

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("MESSAGES")
//data class Message(@Id val id:String?, val text:String)
data class Message(val text: String, @Id val id: String? = null)