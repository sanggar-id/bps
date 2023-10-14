package com.isfa.utils

/**
 * input: {name}
 * output: Hi, ${name}. Welcome!
 */
fun String.greeting(): String {
    return "Hi, $this. Welcome!"
}