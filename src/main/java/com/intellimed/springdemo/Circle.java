package com.intellimed.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class Circle implements Shape, ApplicationEventPublisherAware {
	private ApplicationEventPublisher publisher;
	@Autowired
	private MessageSource messageSource;

	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	private Point center;

	public Point getCenter() {
		return center;
	}

	@Required
	@Autowired
	@Qualifier("circleRelated")
	public void setCenter(Point center) {
		this.center = center;
	}

	public void draw() {
		// System.out.println("Circle is drawn! ");
		System.out.println(messageSource.getMessage("drawing.circle", null, "Default Drawing Circle Message", null));

		// System.out.println("The center is (" + center.getX() + ", " +
		// center.getY()+")");
		System.out.println(messageSource.getMessage("drawing.point", new Object[] { center.getX(), center.getY() },
				"Default Drawing Point Message", null));

		publisher.publishEvent(new DrawEvent(this));

	}

	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		this.publisher = publisher;
	}

}
