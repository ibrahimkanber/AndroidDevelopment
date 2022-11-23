package com.ibrahim.androidwithjetpackcompose.kotlinlab

//Getters and setters
/*
var <propertyName>[: <PropertyType>] [= <property_initializer>]
[<getter>]
[<setter>]

 */

/*
Companion object
In Kotlin, if you want to write a function or any member of the class that can be called without having the instance of the class then you can write the same as a member of a companion object inside the class. So, by declaring the companion object, you can access the members of the class by class name only(which is without explicitly creating the instance of the class).

To create a companion object, you need to add the companion keyword in front of the object declaration.
 */

//https://medium.com/@s.badamestani/lambda-in-kotlin-a6fc055a2c88
//https://blog.mindorks.com/companion-object-in-kotlin
class CompanionClass {

    companion object CompanionObject {

    }
}
val obj = CompanionClass.CompanionObject

class CompanionClass2 {

    companion object {

    }
}
val obj2 = CompanionClass2.Companion

class Rectangle(val width: Int, val height: Int) {
    val area: Int // property type is optional since it can be inferred from the getter's return type
        get() = this.width * this.height
}