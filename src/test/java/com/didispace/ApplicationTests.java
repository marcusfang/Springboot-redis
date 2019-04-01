package com.didispace;

import com.didispace.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes =Application.class)
public class ApplicationTests {

	@Resource
	private StringRedisTemplate stringRedisTemplate;

	@Resource
	private RedisTemplate<String, User> redisTemplate;

	@Test
	public void test() throws Exception {

		// 保存字符串
		stringRedisTemplate.opsForValue().set("abc", "111");
		Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("abc"));

		// 保存对象
		User user = new User("chaoren","超人", 20);
		redisTemplate.opsForValue().set(user.getNickName(), user);

		user = new User("bianfuxia","蝙蝠侠", 30);
		redisTemplate.opsForValue().set(user.getNickName(), user);

		user = new User("zhizhuxia","蜘蛛侠", 40);
		redisTemplate.opsForValue().set(user.getNickName(), user);

		Assert.assertEquals(20, redisTemplate.opsForValue().get("chaoren").getAge().longValue());
		Assert.assertEquals(30, redisTemplate.opsForValue().get("bianfuxia").getAge().longValue());
		Assert.assertEquals(40, redisTemplate.opsForValue().get("zhizhuxia").getAge().longValue());

	}

}
