package com.codeclan.example.fileservice.components;
import com.codeclan.example.fileservice.models.File;
import com.codeclan.example.fileservice.models.Folder;
import com.codeclan.example.fileservice.models.User;
import com.codeclan.example.fileservice.repositories.FileRepository;
import com.codeclan.example.fileservice.repositories.FolderRepository;
import com.codeclan.example.fileservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FileRepository fileRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    UserRepository userRepository;


    public DataLoader() {

    }

    public void run(ApplicationArguments args) {
        User user = new User("User");
        userRepository.save(user);

        Folder folder = new Folder("Folder 1",user);
        folderRepository.save(folder);

        File file = new File("File 1","MP3",3045,folder);
        fileRepository.save(file);

        user.addFolder(folder);
        folder.addFile(file);

        userRepository.save(user);
        folderRepository.save(folder);
    }
}