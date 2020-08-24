package com.mary.instragram.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mary.instragram.domain.image.Image;
import com.mary.instragram.domain.image.ImageRepository;
import com.mary.instragram.domain.tag.Tag;
import com.mary.instragram.domain.tag.TagRepository;
import com.mary.instragram.domain.user.User;
import com.mary.instragram.domain.user.UserRepository;
import com.mary.instragram.domain.user.UserRole;

@RestController
public class TestApiController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ImageRepository imageRepository;
	
	@Autowired
	private TagRepository tagRepository;

	@GetMapping("test/api/join")
	public User join() {
		User user = User.builder().name("김마리").password("1234").phone("01000001111").bio("김말이").role(UserRole.USER)
				.build();
		User userEntity = userRepository.save(user);
		return userEntity;
	}

	@GetMapping("test/api/image")
	public List<Image> image() {
		User userEntity = userRepository.findById(1).get();
		Image image = Image.builder().location("다낭").caption("설명").user(userEntity).build();
		Image imageEntity=imageRepository.save(image);
		List<Tag> tags=new ArrayList<>();
		Tag tag1=Tag.builder()
				.name("#다낭")
				.image(imageEntity)
				.build();
		tags.add(tag1);
		Tag tag2=Tag.builder()
				.name("#여행")
				.image(imageEntity)
				.build();
		tags.add(tag2);		
		
		tagRepository.saveAll(tags);
		
		List<Image> newImageEntitys=imageRepository.findAll();
		return newImageEntitys; // MessageConverter의 Jackson
	}
	
	@GetMapping("/test/api/tag/list")
	public List<Image> list(){
		return imageRepository.findAll();
	}
}
