package org.example.dp.decorator;

// ItalicDecorator.java
public class ItalicDecorator extends TextDecorator {
    public ItalicDecorator(TextComponent decoratedText) {
        super(decoratedText);
    }

    @Override
    public String format() {
        return "<i>" + decoratedText.format() + "</i>";
    }
}

