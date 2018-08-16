package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class TestServelet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = getServletContext().getRealPath("file"+ File.separator+"untitled1");
        ArrayList<String> files = new ArrayList<String>();
        File file = new File(path);
        File[] tempList = file.listFiles();

        for (int i = 0; i < tempList.length; i++) {
            if (tempList[i].isFile()) {
//              System.out.println("文     件：" + tempList[i]);
                files.add(tempList[i].toString());
            }
            if (tempList[i].isDirectory()) {
//              System.out.println("文件夹：" + tempList[i]);
            }
        }
        req.setAttribute("files",files);
        req.setAttribute("xxx","xxx");
        req.getRequestDispatcher("/view/loginSuccess.jsp").forward(req,resp);
    }
}
