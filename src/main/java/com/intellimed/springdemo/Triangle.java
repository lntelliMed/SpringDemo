package com.intellimed.springdemo;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Triangle implements Shape, InitializingBean, DisposableBean, ApplicationContextAware, BeanNameAware {

	private ApplicationContext context;

	public Triangle(String type) {
		this.type = type;
	}

	private String type;
	private List<Point> points;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}

	public void draw() {
		System.out.println(getType() + " triangle is drawn! The coordinates are " + getPoints());
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("InitializingBean afterPropertiesSet method called!");

	}

	public void destroy() throws Exception {
		System.out.println("DisposableBean destroy method called!");
	}

	public void myInit() {
		System.out.println("MyInit  method called!");
	}

	public void myDestroy() {
		System.out.println("MyDestroy  method called!");
	}

	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context = context;
	}

	public void setBeanName(String beanName) {
		System.out.println("The bean is called " + beanName);
	}

}
