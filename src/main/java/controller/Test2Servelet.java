package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;

public class Test2Servelet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String ss = req.getParameter("xx");




            String fileContent = "";
        try {
            File f = new File(ss);
            if (f.isFile() && f.exists()) {
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(f),"UTF-8");
                BufferedReader reader = new BufferedReader(read);
                String line;
                while ((line = reader.readLine()) != null) {
                    fileContent += line+"<br />";
                }
                read.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        req.setAttribute("xxxx",fileContent);
        req.getRequestDispatcher("/view/detail.jsp").forward(req,resp);
    }
}
