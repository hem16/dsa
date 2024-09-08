package org.example.dp.decorator;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
* ------------------------
Decorator Design Pattern:
--------------------------

When we want to enhance the behavior of the object at run time w/o affecting actual implementation.
Decorator wraps the object within itself and provides same interface as the wrapped object.So the client of
original object doesn't need to change.

Role - Component-defines the method declared in i/f used by client.
Role - Concrete Component - Plain object which can be decorated.
Role - Decorator - Implements the same i/f(Component), provides additional behaviour.
                 - Maintains reference to component means it also have the reference of concrete component
                   ...Decorator can be abstract as well & depends on subclass to provides functionality.
*
*
*
 */
public class DecoratorDemo {
    public static void main(String[] args) {
        TextComponent plainText = new PlainText("Hello, World!");

        // Decorate with Bold
        TextComponent boldText = new BoldDecorator(plainText);
        System.out.println(boldText.format()); // Output: <b>Hello, World!</b>

        // Decorate with Italic
        TextComponent italicText = new ItalicDecorator(plainText);
        System.out.println(italicText.format()); // Output: <i>Hello, World!</i>

        // Decorate with Bold and Italic
        TextComponent boldItalicText = new BoldDecorator(new ItalicDecorator(plainText));
        System.out.println(boldItalicText.format()); // Output: <b><i>Hello, World!</i></b>

    }
}
