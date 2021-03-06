package mv.webyonhu.Yonhugeren;

import mv.beanyonhu.LikeShiPin;
import mv.beanyonhu.Pinlunyy;
import mv.daoyonhu.YonhuGerenDao;
import mv.vo.ResultVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/yhisyypl")
public class Yonhuidpinlun extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        int id2 = Integer.parseInt(id);

        try {
            List<Pinlunyy> pinlunyys = new YonhuGerenDao().yhplyy(id2);

            PrintWriter writer = resp.getWriter();
            writer.print(ResultVO.ok(pinlunyys).toJSON());
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().print("-1");
        }

    }


}
