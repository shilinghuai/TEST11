<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<h2>Hello World!test_test</h2>
${"xxx"}
<c:forEach items="${files}" var="file" >
  ${file}
    <form id="_form" method="post" action="${pageContext.request.contextPath}/test11">
    <input type="hidden" name="xx" value="${file}" />
    <input type="submit" value="查看" >
    </form>
    ---<br>
</c:forEach>
</body>
</html>
