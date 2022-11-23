package com.ibrahim.androidwithjetpackcompose.kotlinlab

//https://kotlinlang.org/docs/reflection.html

/*


:: is used for Reflection in kotlin

Class Reference val myClass = MyClass::class
Function Reference this::isEmpty
Property Reference ::someVal.isInitialized
Constructor Reference ::MyClass

Android API only accepts Java classes,
that's why you need to pass a Java class.
IntroAndLang::class returns a KClass (a Kotlin class),
then .java returns the Java class.
Note that all Kotlin classes are compiled to
Java classes (.class binaries) in the end.Ω
 */

class MyClass {
    val y = 9

    companion object {
        val hello = 9

    }

}

//Class references
val c = MyClass::class.java

//Functional reference
val numbers = listOf(1, 2, 3)

fun isOdd(x: Int) = x % 2 != 0

fun show() {
    println(numbers.filter(::isOdd))
}

fun main(){
    println(numbers.filter(::isOdd))
}

