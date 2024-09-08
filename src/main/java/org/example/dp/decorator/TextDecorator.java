package org.example.dp.decorator;

// TextDecorator.java
public abstract class TextDecorator implements TextComponent {
    protected TextComponent decoratedText;

    public TextDecorator(TextComponent decoratedText) {
        this.decoratedText = decoratedText;
    }

    public String format() {
        return decoratedText.format();
    }
}
