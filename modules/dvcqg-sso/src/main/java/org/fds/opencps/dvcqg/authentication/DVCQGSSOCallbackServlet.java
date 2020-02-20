
package org.fds.opencps.dvcqg.authentication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author trungnt
 */
public class DVCQGSSOCallbackServlet extends HttpServlet {

	/**
	 * Default constructor.
	 */

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		String code = request.getParameter(DVCQGSSOTerm.CODE);
		
		String state = request.getParameter(DVCQGSSOTerm.STATE);

		StringBuffer responseContent = new StringBuffer();
//		responseContent.append("<script src=\"https://code.jquery.com/jquery-3.4.1.min.js\"></script>");
//		responseContent.append("<script src=\"https://cdn.jsdelivr.net/npm/gasparesganga-jquery-loading-overlay@2.1.6/dist/loadingoverlay.min.js\"></script>");
//		responseContent.append("<script>");
//		responseContent.append("$( document ).ready(function() {\r\n"); 
//		responseContent.append("var state = '" + state + "';\r\n");
//		responseContent.append("$.ajax('/o/rest/v2/dvcqgsso/userinfo?authToken=" + code +"&state=" + state + "', \r\n" + 
//				"{\r\n" + 
//				"    type: 'GET', \r\n" + 
//				"    dataType: 'json', \r\n" + 
//				"    timeout: 5000,  \r\n" + 
//				"    async: false,  \r\n" + 
//				"    success: function (data,status,xhr) {\r\n" + 
//				"		 $.LoadingOverlay(\"show\");\r\n" +
//				"        if(state == 'mapping'){\r\n" +
//				"        	doAuth(data);\r\n" + 
//				"        }else{\r\n" +
//				"        	if(parseInt(data.userId) > 0){\r\n" +
//				"        		doAuth(data);\r\n" + 
//				"        	}else{\r\n" +
//				"        		window.top.callback_dvcqg(data);\r\n" + 
//				"        	}\r\n" +
//				"        }\r\n" +
//				
//				"    },\r\n" + 
//				"    complete: function (data,status,xhr) {\r\n" + 
//				"		 $.LoadingOverlay(\"hide\");\r\n" +
//				"    },\r\n" + 
//				"    error: function (jqXhr, textStatus, errorMessage) { \r\n" + 
//				"        $('#userinfo').append('Error: ' + errorMessage);\r\n" + 
//				"    },\r\n" + 
//				"	beforeSend: function (xhr) {\r\n" + 
//				
//				"	}\r\n" + 
//				"});");
//		
//		responseContent.append("function doAuth(userinfo){\r\n" + 
//				"	$.ajax('/o/rest/v2/dvcqgsso/auth', \r\n" + 
//				"	{\r\n" + 
//				"		dataType: 'json', \r\n" + 
//				"		timeout: 5000,\r\n" + 
//				"		async: false,\r\n" + 
//				"		type:'POST',\r\n" + 
//				"		headers: {\r\n" + 
//				
//				"			Accept: 'application/json; charset=utf-8',\r\n" + 
//				"			\"Content-Type\": 'application/json; charset=utf-8'\r\n" + 
//				"		},\r\n" + 
//				"		data: JSON.stringify(userinfo),\r\n" + 
//				"		success: function (data,status,xhr) {\r\n" + 
//				"			$('#userinfo').append('Authorization successful');\r\n" + 
//				"        	window.top.callback_dvcqg(data);\r\n" + 
//				"		},\r\n" + 
//				"		\r\n" + 
//				"		error: function (jqXhr, textStatus, errorMessage) { \r\n" + 
//				"			\r\n" + 
//				"			$('#userinfo').append('Error: ' + errorMessage);\r\n" + 
//				"		},\r\n" + 
//				"		beforeSend: function (xhr) {\r\n" + 
//				
//				"		}\r\n" + 
//				"	});\r\n" + 
//				"};");
//		
//		responseContent.append("function doLogin2(data){\r\n" + 
//				"	$.ajax('/o/auth/dvcqg/validatetoken', \r\n" + 
//				"	{\r\n" + 
//				"		dataType: 'json', \r\n" + 
//				"		timeout: 5000,\r\n" + 
//				"		async: false,\r\n" + 
//				"		type:'POST',\r\n" + 
//				"		headers: {\r\n" + 
//				"			userId: data.userId,\r\n" + 
//				"			groupId: data.groupId,\r\n" + 
//				"			accessToken: data.accessToken,\r\n" + 
//				"			Accept: 'application/json; charset=utf-8',\r\n" + 
//				"			\"Content-Type\": 'application/json; charset=utf-8'\r\n" + 
//				"		},\r\n" + 
//			
//				"		success: function (data,status,xhr) {\r\n" + 
//			
//				"		},\r\n" + 
//				"		\r\n" + 
//				"		error: function (jqXhr, textStatus, errorMessage) { \r\n" + 
//			
//				"		},\r\n" + 
//				"		beforeSend: function (xhr) {\r\n" + 
//				
//				"		}\r\n" + 
//				"	});\r\n" + 
//				"};");
//		responseContent.append("});");
//		responseContent.append("</script>");
//		
//		responseContent.append("<style>");
//		responseContent.append("div#userinfo {\r\n" + 
//				"    display: block;\r\n" + 
//				"    height: 100%;\r\n" + 
//				"    width: 100%;\r\n" + 
//				"    background-color: #a5caef66;\r\n" + 
//				"}");
//		responseContent.append("</style>");
//		
//		responseContent.append("<div id=\"userinfo\"></div>");
		ClassLoader classLoader = getClass().getClassLoader();
		InputStream inputStream = classLoader.getResourceAsStream(DVCQGSSOTerm.SSO_FILE);
		InputStreamReader isReader = new InputStreamReader(inputStream);
	    BufferedReader reader = new BufferedReader(isReader);
	    StringBuffer sb = new StringBuffer();
	    String str;
	    while((str = reader.readLine())!= null){
	    	sb.append(str);
	    }
		
	    responseContent.append(sb.toString().replaceAll(DVCQGSSOTerm.CODE_REPLACE, code).replaceAll(DVCQGSSOTerm.STATE_REPLACE, state));
	    
		response.setContentType(DVCQGSSOTerm.TEXT_HTML);
		
		response.getWriter().write(responseContent.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.getWriter().write("NO CONTENT!");
	}
	
}
