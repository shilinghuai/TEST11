<%@ page import="java.io.File" %>
<%@ page import="java.io.FileInputStream" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<html>

<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="https://cdn.jsdelivr.net/npm/vue@2.5.17/dist/vue.js"></script></head>

<body>
<h2>Hello World!567</h2>
<div id="vueFirst">
    <p>{{message}}</p>
</div>
<form action="${pageContext.request.contextPath}/test" method="post">
    <input type="submit" value="注册">
</form>

<%
    File f=new File("D:\\111.txt");

    if(f.exists())



        try{

            FileInputStream in=new FileInputStream(f);

            byte[] buf =new byte[1024];

            int len=in.read(buf);

            String  s =new String(buf,0,len);

            out.println(s); // 这里用out就行了



        }catch(Exception e){

            System.out.println(e.getMessage());

        }

%>
</body>
<script>
    new Vue({
        el: '#vueFirst',
        data: {
            message: 'Hello World Vue.js'
        }
    })
</script>

</html>
