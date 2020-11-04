package kr.or.ddit.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ApplicationListener implements ServletContextListener{ // 서버가 켜질 때 기동이 되는 부분

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// 초기화 부분
		ServletContext sc = sce.getServletContext();
		String cp = sc.getContextPath();
		sc.setAttribute("cp", cp);
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

}
