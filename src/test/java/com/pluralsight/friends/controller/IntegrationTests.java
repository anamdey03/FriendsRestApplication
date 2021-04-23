package com.pluralsight.friends.controller;

import javax.validation.ValidationException;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pluralsight.friends.model.Friend;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IntegrationTests {

	@Autowired
	FriendController friendController;
	
	@Test
	public void createReadDelete() {
		
		Friend friend = new Friend();
		friend.setFirstName("Dola");
		friend.setLastName("Sen");
		
		Friend friendResult = friendController.postFriend(friend);
		
		Iterable<Friend> friends = friendController.getFriend();
	    Assertions.assertThat(friends).anyMatch(f -> f.getFirstName().contains("Dola"));

	    friendController.deleteFriend(friendResult.getId());
	    Assertions.assertThat(friendController.getFriend()).extracting(Friend::getFirstName).doesNotContain("Dola");
	}
	
	@Test(expected = ValidationException.class)
	public void errorHandlingValidationExceptionThrown() {
		friendController.somethingIsWrong();
	}
}
