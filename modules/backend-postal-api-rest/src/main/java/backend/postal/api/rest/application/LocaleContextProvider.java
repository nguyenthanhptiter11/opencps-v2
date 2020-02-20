package backend.postal.api.rest.application;

import com.liferay.portal.kernel.util.Portal;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import javax.ws.rs.ext.Provider;

import org.apache.cxf.jaxrs.ext.ContextProvider;
import org.apache.cxf.message.Message;
import org.opencps.api.service.util.ConfigConstants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Adam Brandizzi
 */
@Component(immediate = true, service = LocaleContextProvider.class)
@Provider
public class LocaleContextProvider implements ContextProvider<Locale> {

	@Override
	public Locale createContext(Message message) {
		return _portal.getLocale((HttpServletRequest) message.getContextualProperty(ConfigConstants.HTTP_REQUEST));
	}

	@Reference
	private Portal _portal;

}