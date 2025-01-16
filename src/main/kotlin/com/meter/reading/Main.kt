package com.meter.reading

import java.io.File

fun main(args: Array<String>) {
    println("awaaaaa")
    if (args.isEmpty()) {
        println("Please provide the file path as a command-line argument")
        return
    }
    val filePath = args[0]
    val fileContent = File(filePath).readText()
    println("File content: \n$fileContent")
}