package rs.paragraf.web.example;

import java.io.*;
import java.util.*;
import javax.faces.bean.*;
import javax.faces.component.UIViewRoot;
import javax.faces.context.*;
import javax.faces.event.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped
public class NavigationBean implements Serializable {

	private String pageHeight;

	public String getPageHeight() {
		
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest myRequest = (HttpServletRequest)context.getExternalContext().getRequest();
		HttpSession mySession = myRequest.getSession();
		myRequest.getParameter("webParagrafPaneldividerHeight");
		pageHeight = new String("webParagrafPaneldividerHeight");
		return pageHeight;
		
	}

	public void setPageHeight(String pageHeight) {
		System.out.println("sph");
		this.pageHeight = pageHeight;
	}

	public String getStyle(){
		String style = String.format("width: 100%; height: %s", pageHeight);
		return(style);
	}

	public String doNav(){
		String retVal = null;
		FacesContext context = FacesContext.getCurrentInstance();
		Map<String, Object> requests = context.getExternalContext().getRequestMap();
		for (String requestName : requests.keySet()) {
		if (requests.get(requestName) instanceof HttpServletRequestWrapper) {
		HttpServletRequest request = (HttpServletRequest) ((HttpServletRequestWrapper) requests.get(requestName)).getRequest();
		retVal = request.getParameter("webParagrafPaneldividerHeight");
		}
		}
	    //pageHeight = (String) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("webParagrafPaneldividerHeight");
		pageHeight = retVal;
		return("testSplittera");
	}
}
