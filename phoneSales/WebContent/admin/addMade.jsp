<%@ page contentType="text/html;charset=utf-8" %>
<%@ page import="java.util.*,cn.ldj.domain.*" %>

<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>手机类别</title>

    <link href="../css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
    <div class="container">
        <div class="row">
            <div class="col-md-10 col-md-offset-1">
                <nav class="navbar navbar-default" role="navigation">
                    <div class="container-fluid">
                        <div class="navbar-header">
                            <a class="navbar-brand" href="#">手机销售网后台系统</a>
                        </div>
                        <div>
                            <p class="navbar-text">手机类别</p>
                        </div>
                    </div>
                </nav>
            </div>
        </div>

        <div class="row">
            <jsp:include page="base.jsp" flush="true" />
            
            <div class="col-md-8">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <form action="AddMadeServlet" method="post" role="form">
                            <label for="name">输入新的手机类别</label>
                            <input name="class" type="text" class="form-control"/>
                            <button type="submit" class="btn btn-default">添加</button>
                        </form>
                        <br/>
                        <form action="DeleteMadeServlet" method="post" role="form">
                            <label for="name">选择要删除的手机类别</label>
                            <%
                            List<MobileClassify> list = (List<MobileClassify>)request.getAttribute("list");
                            %>
                            <select name="class" class="form-control">
                            	<%
                            	for(MobileClassify mc:list) {
                            	%>
                                <option value="<%=mc.getMid() %>"><%=mc.getName() %></option>
                                <%
                            	}
                                %>
                              </select>
                            <button type="submit" class="btn btn-default">删除</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
</div>

        <script src="../js/jquery.min.js"></script>
        <script src="../js/bootstrap.min.js"></script>
</body>

</html>