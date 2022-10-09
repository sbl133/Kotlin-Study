package com.lannstark.lec07

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

class FilePrinter {

    // checkedEX에 throws를 던지지 않아도 된다.
    fun readFile() {
        val currentFile = File(".")
        val file = File(currentFile.absolutePath + "/a.txt")
        val reader = BufferedReader(FileReader(file))
        println(reader.readLine())
        reader.close()
    }

    fun readFile(path: String) {
        BufferedReader(FileReader(path)).use{
            reader -> println(reader.readLine())
        }
    }
}