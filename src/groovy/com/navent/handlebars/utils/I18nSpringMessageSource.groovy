package com.navent.handlebars.utils

import java.util.Locale;

import com.github.jknack.handlebars.helper.I18nSource

/**
 * I18nSource para el i18n helper de handlebars que obtiene los mensajes desde el bean messageSource de grails
 *
 */
class I18nSpringMessageSource implements I18nSource {

	def source;
	
	@Override
	public String[] keys(final String basename, final Locale locale) {
	 
		Set applicationKeys = source.getMergedProperties(locale).getProperties().keySet()
		Set pluginsKeys = source.getMergedPluginProperties(locale).getProperties().keySet()
		
		Set resultSet = [] as Set
		resultSet.addAll(applicationKeys)
		resultSet.addAll(pluginsKeys)
		
		return resultSet.toArray(new String[resultSet.size()]);
	}
  
	@Override
	public String message(final String key, final Locale locale, final Object... args) {
	  return source.getMessage(key, args, locale)
	}
}
