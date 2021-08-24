package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class BmiPrintServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收请求参数
        String strName = request.getParameter("name");
        String height = request.getParameter("h");
        String weight = request.getParameter("w");

        //计算bmi ： bmi = 体重/ 身高的平方
        float h = Float.valueOf(height);
        float w = Float.valueOf(weight);
        float bmi = w / (h * h);

        //判断bmi的范围
        String msg = "";
        if (bmi <= 18.5) {
            msg = "您比较瘦";
        } else if (bmi > 18.5 && bmi <= 23.9) {
            msg = "你的bmi是正常的";
        } else if (bmi > 24 && bmi <= 27) {
            msg = "你的身体比较胖";
        } else {
            msg = "你的身体肥胖";
        }
        System.out.println("msg=" + msg);
        msg = "您好：" + strName + "先生/女士, 您的bmi值是：" + bmi + "," + msg;

        //使用HttpServletResponse输出数据
        response.setContentType("text/html;charset=utf-8");
        //获取PrintWriter
        PrintWriter pw = response.getWriter();
        //输出数据
        pw.println(msg);
        //清空缓存
        pw.flush();
        //关闭close
        pw.close();
    }
}
