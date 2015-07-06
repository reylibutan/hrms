package com.ryad.hrms.impl;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import com.ryad.hrms.service.MessageByLocaleService;

@Service
public class MessageByLocaleServiceImpl implements MessageByLocaleService {

	@Autowired
	private MessageSource messageResource;
	
	@Override
	public String getMessage(String key, Object[] args) {
		Locale locale = LocaleContextHolder.getLocale();
		
		return messageResource.getMessage(key, args, locale);
	}
}
