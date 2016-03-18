import com.navent.handlebars.utils.I18nSpringMessageSource


class HandlebarsPluginGrailsPlugin {
    // the plugin version
    def version = "1.0.2"
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "2.4 > *"
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
        "grails-app/views/error.gsp"
    ]

    // TODO Fill in these fields
    def title = "Handlebars Plugin" // Headline display name of the plugin
    def author = "EPineiro"
    def authorEmail = "epineiro@navent.com"
    def description = '''\
Plugin to integrate handlebars as a template engine for a grails application.
It provides:
- A singleton object to render handlebars templates in a controller
- Helpers to integrate asset bundling functionality into handlebars templates (as oposing to use gsp)
- Bettter integration of handlebars functionality with grails (e.g. use of messageSource bean with i18n standard helper of handlebars)
'''

    // URL to the plugin's documentation
    def documentation = "http://grails.org/plugin/handlebars-plugin"

    // Extra (optional) plugin metadata

    // License: one of 'APACHE', 'GPL2', 'GPL3'
//    def license = "APACHE"

    // Details of company behind the plugin (if there is one)
    def organization = [ name: "Navent", url: "http://www.navent.com/" ]

    // Any additional developers beyond the author specified above.
//    def developers = [ [ name: "Joe Bloggs", email: "joe@bloggs.net" ]]

    // Location of the plugin's issue tracker.
//    def issueManagement = [ system: "JIRA", url: "http://jira.grails.org/browse/GPMYPLUGIN" ]

    // Online location of the plugin's browseable source code.
//    def scm = [ url: "http://svn.codehaus.org/grails-plugins/" ]

    def doWithWebDescriptor = { xml ->
        // TODO Implement additions to web.xml (optional), this event occurs before
    }

    def doWithSpring = { ->
		
		i18nMessageSource(I18nSpringMessageSource) {
			source = ref('messageSource')
		}
		
		//este bean ofrece una implementacion por default del localeResolver, utilizado por el helper i18n de handlebars
		//el mismo puede ser reemplazado por una implementacion custom en la aplicacion que utilice este plugin
		//simplemente definiendo el bean de nombre 'localeResolver' a nivel de aplicacion
		localeResolver(org.springframework.web.servlet.i18n.SessionLocaleResolver) {
	      defaultLocale = new Locale("es","AR")
	      java.util.Locale.setDefault(defaultLocale)
	   }
	}

    def doWithDynamicMethods = { ctx ->
        // TODO Implement registering dynamic methods to classes (optional)
    }

    def doWithApplicationContext = { ctx ->
        // TODO Implement post initialization spring config (optional)
    }

    def onChange = { event ->
        // TODO Implement code that is executed when any artefact that this plugin is
        // watching is modified and reloaded. The event contains: event.source,
        // event.application, event.manager, event.ctx, and event.plugin.
    }

    def onConfigChange = { event ->
        // TODO Implement code that is executed when the project configuration changes.
        // The event is the same as for 'onChange'.
    }

    def onShutdown = { event ->
        // TODO Implement code that is executed when the application shuts down (optional)
    }
}
