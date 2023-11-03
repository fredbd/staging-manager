package com.oppscience.ingestion.model;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@Entity
public class TextDocument extends Base {

    private String text;

    public TextDocument() {}

    public TextDocument(String parentType, UUID parentId, String text) {
        super(parentType, parentId);
        this.text = text;
    }

    @Override
    public String toString() {
        return "TextDocument{" +
                "base='" + super.toString() + '\'' +
                "text='" + text + '\'' +
                '}';
    }
}
