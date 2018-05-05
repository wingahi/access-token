package cn.wgh.token.token.access.impl.test;

import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.wgh.token.access.impl.test.model.User;
import cn.wgh.token.base.token.access.emun.PlatformEmun;
import cn.wgh.token.util.utils.impl.LoginUtils;

public class LoginTest {

	public static void main(String[] args) throws InterruptedException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("redisTemplateSingle.xml");
		LoginUtils loginUtils = (LoginUtils) context.getBean("loginUtils");
		//for (int i = 0; i < 100; i++) {
			String token = loginUtils.login(100, new User(1000l, "test1000", new Date(), null), PlatformEmun.app);
			System.out.println(token);
			String token1 = loginUtils.getToken(100, PlatformEmun.app);
			System.out.println(token1);
			System.out.println(loginUtils.getUserIdByToken(token));
			System.out.println(loginUtils.getUserInfo(token));
			System.out.println(loginUtils.isLogin("1514185994547"));
			System.out.println(loginUtils.isLogin(token));
			System.out.println(loginUtils.isLogin(100l,PlatformEmun.app));
			System.out.println(loginUtils.isLogin(101l,PlatformEmun.app));
			Thread.sleep(500);
		//}
	}
}
