<%@ page contentType="text/html;charset=utf-8" %>

<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>登录</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">

</head>

<body>
    <div class="container">
        <jsp:include page="base.jsp" />

        <div class="row">
            <div class="col-md-6 col-md-offset-3">
                <div class="well">
                    <h2>用户登录</h2>
                    <form action="UserServlet?method=login" method="POST" role="form">
                        <%
                        String lognameInfo = (String)request.getAttribute("lognameInfo");
                        String passwordInfo = (String)request.getAttribute("passwordInfo");
                        %>
                        
                        <div>
                            <div class="form-group">
                                <label for="name">用户名称</label>
                                <input name="logname" type="text" class="form-control" />
                                <%
                                if(lognameInfo!=null) {
                                %>
                                <div class="alert alert-danger">
                              		<%=lognameInfo %>
                                </div>
                                <%} %>
                            </div>
                            <div class="form-group">
                                <label for="name">用户密码</label>
                                <input name="password" type="password" class="form-control" />
                                <%
                                if(passwordInfo!=null) {
                                %>
                                <div class="alert alert-danger">
                              		<%=passwordInfo %>
                                </div>
                                <%} %>
                            </div>

                        </div>
                        <div>
                            <button type="submit" class="btn btn-primary">
                                立即登录
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>



    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>

</html>