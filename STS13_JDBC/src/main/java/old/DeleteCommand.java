package old;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DeleteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int cnt = 0;
		WriteDAO dao = new WriteDAO();
		int uid = Integer.parseInt(request.getParameter("uid"));
		
		try {
			cnt = dao.deleteByUid(uid);
		}catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("delete", cnt);
	}

}
