package org.example.dp.decorator;

// BoldDecorator.java
public class BoldDecorator extends TextDecorator {
    public BoldDecorator(TextComponent decoratedText) {
        super(decoratedText);
    }

    @Override
    public String format() {
        return "<b>" + decoratedText.format() + "</b>";
    }
}

