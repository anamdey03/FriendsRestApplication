package com.pluralsight.friends.service;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.pluralsight.friends.model.Friend;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ServiceTest {

	@Autowired
	FriendService friendService;
	
	@Test
	public void testCreateReadDelete() {
		
		Friend friend = new Friend();
		friend.setFirstName("Malay");
		friend.setLastName("Sen");
		
		friendService.save(friend);
		
		Iterable<Friend> friends = friendService.findAll();
		
		Assertions.assertThat(friends).extracting(Friend::getFirstName).contains("Malay");
		
		friendService.delete(friend);
		Assertions.assertThat(friendService.findAll()).extracting(Friend::getFirstName).doesNotContain("Malay");
	}
}
