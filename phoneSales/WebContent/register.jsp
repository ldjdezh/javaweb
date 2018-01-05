<%@ page contentType="text/html;charset=utf-8" %>

<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>注册</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">

</head>

<body>
    <div class="container">
        <%@ include file="base.html" %>
        
        <%
        String lognameinfo = (String)request.getAttribute("lognameinfo");
        String passwordinfo = (String)request.getAttribute("passwordinfo");
        %>

        <div class="row">
            <div class="col-md-6 col-md-offset-3">
                <div class="well">
                    <h2>用户注册</h2>
                    <form action="RegisterServlet" method="post" role="form">
                        <div>
                            <div class="form-group">
                                <label for="name">用户名称</label>
                                <input name="logname" type="text" class="form-control"/>
                                <%
                                	if(lognameinfo != null) {
                                %>
                            		<div class="alert alert-danger">
                            			<%=lognameinfo %>
                            		</div>
                            	<% } %>
                            </div>
                            <div class="form-group">
                                <label for="name">用户密码</label>
                                <input name="password" type="password" class="form-control"/>
                               	<%
                               		if(passwordinfo!=null) {
                               	%>
	                               	<div class="alert alert-danger">
	                               		<%=passwordinfo %>
	                               	</div>
                               	<% } %>
                            </div>
                            <div class="form-group">
                                <label for="name">重复密码</label>
                                <input name="againPassword" type="password" class="form-control" />
                            </div>
                            <div class="form-group">
                                <label for="name">联系电话</label>
                                <input name="phone" type="text" class="form-control"  />
                            </div>
                            <div class="form-group">
                                <label for="name">邮寄地址</label>
                                <input name="address" type="text" class="form-control" />
                            </div>
                            <div class="form-group">
                                <label for="name">真实姓名</label>
                                <input name="realname" type="text" class="form-control" />
                            </div>
                        </div>
                        <div>
                            <button type="submit" class="btn btn-primary">
                                立即注册
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