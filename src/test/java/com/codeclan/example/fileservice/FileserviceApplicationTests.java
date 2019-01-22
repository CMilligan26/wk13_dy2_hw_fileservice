package com.codeclan.example.fileservice;

import com.codeclan.example.fileservice.models.File;
import com.codeclan.example.fileservice.models.Folder;
import com.codeclan.example.fileservice.models.User;
import com.codeclan.example.fileservice.repositories.FileRepository;
import com.codeclan.example.fileservice.repositories.FolderRepository;
import com.codeclan.example.fileservice.repositories.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileserviceApplicationTests {

	@Autowired
	FileRepository fileRepository;
	@Autowired
	FolderRepository folderRepository;
	@Autowired
	UserRepository userRepository;

	private User user;
	private Folder folder;
	private File file;

	@Before
	public void before(){
		user = new User("User");
		folder = new Folder("Folder 1",user);
		file = new File("File 1","MP3",3045,folder);
	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void canSaveAll(){
		userRepository.save(user);
		folderRepository.save(folder);
		fileRepository.save(file);
	}

	@Test
	public void canAddFileToFolders(){
		userRepository.save(user);
		folderRepository.save(folder);
		fileRepository.save(file);
		folder.addFile(file);
		folderRepository.save(folder);
	}

	@Test
	public void canAddFolderToUser(){
		userRepository.save(user);
		folderRepository.save(folder);
		fileRepository.save(file);
		user.addFolder(folder);
		userRepository.save(user);
	}

}

