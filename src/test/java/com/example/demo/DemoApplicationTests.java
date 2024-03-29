package com.example.demo;

import com.example.demo.dao.AlphaDao;
import com.example.demo.service.AlphaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
@ContextConfiguration(classes = DemoApplication.class)
class DemoApplicationTests implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext=applicationContext;
	}

	@Test
	public void testApplicationContext(){
		System.out.println(applicationContext);

		AlphaDao alphaDao=applicationContext.getBean(AlphaDao.class);
		System.out.println(alphaDao.select());

		alphaDao=applicationContext.getBean("alphaDaoHibernate",AlphaDao.class);
		System.out.println(alphaDao.select());


	}

	@Test
	public void testBeanManagement(){
		AlphaService alphaService=applicationContext.getBean(AlphaService.class);
		System.out.println(alphaService);

		alphaService=applicationContext.getBean(AlphaService.class);
		System.out.println(alphaService);
	}

	@Test
	public void testBeanConfig(){
		SimpleDateFormat simpleDateFormat=applicationContext.getBean(SimpleDateFormat.class);
		System.out.println(simpleDateFormat.format(new Date()));
	}

	@Autowired
	@Qualifier("alphaDaoHibernate")
	private AlphaDao alphaDao;

	@Autowired
	private AlphaService alphaService;


	@Test
	public void testSI(){
		System.out.println(alphaDao);
		System.out.println(alphaService);
	}
}


