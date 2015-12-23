package com.navent.handlebars.utils

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

import net.jawr.web.resource.bundle.locale.LocaleResolver

import org.springframework.context.i18n.LocaleContext
import org.springframework.web.servlet.i18n.AbstractLocaleContextResolver
import org.springframework.web.servlet.support.RequestContextUtils as RCU

class DefaultJawrLocaleResolver extends  AbstractLocaleContextResolver implements LocaleResolver {
	
	Locale defaultLocale
	
	@Override
	public LocaleContext resolveLocaleContext(HttpServletRequest arg0) {
		final Locale locale = this.resolveLocale(arg0)
		return new LocaleContext() {
            public Locale getLocale() {
				return locale
            }
        }
	}

	@Override
	public Locale resolveLocale(HttpServletRequest request) {
		def locale = RCU.getLocale(request)
		if (locale != null)
			return locale
		else
			return this.getDefaultLocale()
	}
	
	@Override
	public void setLocaleContext(HttpServletRequest arg0,HttpServletResponse arg1, LocaleContext arg2) {
	}

	@Override
	public String resolveLocaleCode(HttpServletRequest arg0) {
		Locale locale = this.resolveLocale(arg0)
		return locale.toString()
	}

}
