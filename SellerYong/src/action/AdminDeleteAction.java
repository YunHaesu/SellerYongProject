package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.AdminDeleteService;
import vo.ActionForward;

public class AdminDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		String id = request.getParameter("id");
		AdminDeleteService adminDeleteService = new AdminDeleteService();

		
			boolean isDeleteSuccess = adminDeleteService.removeAdmin(id);

			if (!isDeleteSuccess) {
				response.setContentType("text/html;charset = UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('삭제실패');");
				out.println("history.back();");
				out.println("</script>");
				out.close();
			} else {
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("admin.do");
			}
		
		return forward;
	}

}
