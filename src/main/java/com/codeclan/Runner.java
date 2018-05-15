package com.codeclan;

import com.codeclan.db.DBFolder;
import com.codeclan.db.DBHelper;
import com.codeclan.models.File;
import com.codeclan.models.Folder;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Folder folder1 = new Folder("MyDocuments");
        DBHelper.save(folder1);
        Folder folder2 = new Folder("MyPics");
        DBHelper.save(folder2);

        File file1 = new File("file_1", ".txt", "2mb", folder1);
        DBHelper.save(file1);

        File file2 = new File("file_2", ".jpg", "2mb", folder2);
        DBHelper.save(file2);

        List<File> files = DBHelper.getAll(File.class);
        List<Folder> folders = DBHelper.getAll(Folder.class);

        Folder MyDocumentsFolder = DBHelper.find(Folder.class, folder1.getId());

        List<File> MyDocumentsFiles = DBFolder.getFilesInFolder(MyDocumentsFolder);

    }
}
