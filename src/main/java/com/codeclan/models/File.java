package com.codeclan.models;

import javax.persistence.*;

@Entity //ADDED
@Table(name="files")
public class File {

    private int id;
    private String name;
    private String extension;
    private String size;
    private Folder folder;

    public File() {
    }

    public File(String name, String extension, String size, Folder folder) {
        this.name = name;
        this.extension = extension;
        this.size = size;
        this.folder = folder;
    }

    @Id // ADDED
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ADDED
    @Column(name = "id") // ADDED
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "extension")
    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    @Column(name = "size")
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @ManyToOne // ADDED
    @JoinColumn(name="folder_id", nullable = false)
    public Folder getFolder() {
        return folder;
    }

    public void setFolder(Folder folder) {
        this.folder = folder;
    }
}
