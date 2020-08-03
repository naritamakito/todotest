package test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * TODO管理をおこなうサーブレット。
 * (ログイン画面のみ)
 */
public class TodoServlet extends HttpServlet {
	
	/**
	 * シリアルバージョンUID(おまじない)
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	* JSPのベースディレクトリ。
	*/
	private static final String JSP_BASE = "/WEB-INF/jsp/";
	
	
	
	/**
	 * 構築します。
	 */
	public TodoServlet() {
		;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 要求からactionパラメータを取得
		String action = req.getParameter("action");

		String forward = null;
		if("login".equals(action)) {
			// ログイン画面の処理
			// login.jspへフォワードする
			forward = JSP_BASE + "login.jsp";
		}else{
			// 不正なアクションの場合
			throw new ServletException("不正なリクエストです");
		}
		
		// JSPへのフォワード
		RequestDispatcher dispatcher = req.getRequestDispatcher(forward);
		dispatcher.forward(req, resp);
	}

}
