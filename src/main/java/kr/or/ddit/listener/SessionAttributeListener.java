package kr.or.ddit.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.users.model.UserVo;

public class SessionAttributeListener implements HttpSessionAttributeListener{

	private static final Logger logger = LoggerFactory.getLogger(SessionAttributeListener.class);
	
	//			userid, UserVo
	private Map<String, UserVo> userMap = new HashMap<String, UserVo>();
	
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		if ("S_MEMBER".equals(event.getName())) {
			// session에 저장된 id값 가져오기
//			HttpSession session = event.getSession();
//			MemberVo memberVo = (MemberVo)session.getAttribute("S_MEMBER");
			
			UserVo userVo = (UserVo)event.getValue();
			
			logger.debug("사용자 로그인 : {}", userVo.getUser_id());
			
			userMap.put(userVo.getUser_id(), userVo);
			
			ServletContext sc = event.getSession().getServletContext();
			sc.setAttribute("userMap", userMap);
		}
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		logger.debug("attributeRemoved : {}" , event.getName());
		
		if ("S_MEMBER".equals(event.getName())) {
			UserVo userVo = (UserVo)event.getValue();
			userMap.remove(userVo.getUser_id());
		}
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		
	}

}
