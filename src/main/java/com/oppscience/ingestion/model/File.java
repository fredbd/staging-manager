package com.oppscience.ingestion.model;

import jakarta.persistence.Entity;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
//@PropertyStrategy(mutable = false)
public class File extends Base {

//    @Id
//    @GeneratedValue
//    private UUID id;

    private String url;
    private String path;
    private String name;
    private String extension;
    private String mimeType;
    private Long size;

    public File() {}

    public File(String parentType, UUID parentId, String url, String path, String name, String extension, Long size) {
        super(parentType, parentId);
        this.url = url;
        this.path = path;
        this.name = name;
        this.extension = extension;
        this.size = size;
    }

    @Override
    public String toString() {
        return "File{" +
                "name='" + name + '\'' +
                "extension='" + extension + '\'' +
                "size='" + size + '\'' +
                '}';
    }
}
