package test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * TODO�Ǘ��������Ȃ��T�[�u���b�g�B
 * (���O�C����ʂ̂�)
 */
public class TodoServlet extends HttpServlet {
	
	/**
	 * �V���A���o�[�W����UID(���܂��Ȃ�)
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	* JSP�̃x�[�X�f�B���N�g���B
	*/
	private static final String JSP_BASE = "/WEB-INF/jsp/";
	
	
	
	/**
	 * �\�z���܂��B
	 */
	public TodoServlet() {
		;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// �v������action�p�����[�^���擾
		String action = req.getParameter("action");

		String forward = null;
		if("login".equals(action)) {
			// ���O�C����ʂ̏���
			// login.jsp�փt�H���[�h����
			forward = JSP_BASE + "login.jsp";
		}else{
			// �s���ȃA�N�V�����̏ꍇ
			throw new ServletException("�s���ȃ��N�G�X�g�ł�");
		}
		
		// JSP�ւ̃t�H���[�h
		RequestDispatcher dispatcher = req.getRequestDispatcher(forward);
		dispatcher.forward(req, resp);
	}

}
