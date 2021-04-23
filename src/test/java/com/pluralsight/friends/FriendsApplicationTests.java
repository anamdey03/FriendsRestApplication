package com.pluralsight.friends;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pluralsight.friends.controller.FriendController;

@RunWith(SpringRunner.class)
@SpringBootTest
class FriendsApplicationTests {
	
	@Autowired
	FriendController friendController;

	@Test
	void contextLoads() {
		Assert.assertNotNull(friendController);
	}

}
