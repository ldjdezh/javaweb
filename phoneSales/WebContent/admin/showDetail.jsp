<%@ page contentType="text/html;charset=utf-8" %>

<%@ page import="java.util.*,cn.ldj.domain.*" %>

<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>手机详情</title>

    <link href="../css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
    <div class="container">
        <div class="row">
            <div class="col-md-10 col-md-offset-1">
                <nav class="navbar navbar-default" role="navigation">
                    <div class="container-fluid">
                        <div class="navbar-header">
                            <a class="navbar-brand" href="manager.jsp">手机销售网后台系统</a>
                        </div>
                        <div>
                            <p class="navbar-text">手机详情</p>
                        </div>
                    </div>
                </nav>
            </div>
            
            <%
			MobileForm mf = (MobileForm)request.getAttribute("mf");
			%>
            <div class="col-md-10 col-md-offset-1">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="media">
                            <a class="media-left" href="#">
                                <img class="media-object" src="<%=request.getContextPath() %><%=mf.getMobile_pic() %>" alt="媒体对象">
                            </a>
                            <div class="media-body">
                                <h3 class="media-heading"><%=mf.getMobile_name() %></h3>
                                <table class="table table-bordered">
                                    <tbody>
                                        <tr>
                                            <td>
                                                <label for="name">手机版本号</label>
                                            </td>
                                            <td><%=mf.getMobile_version() %></td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <label for="name">手机名称</label>
                                            </td>
                                            <td><%=mf.getMobile_name() %></td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <label for="name">手机制造商</label>
                                            </td>
                                            <td><%=mf.getMobile_made() %></td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <label for="name">手机价格</label>
                                            </td>
                                            <td><%=mf.getMobile_price() %></td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <label for="name">手机信息</label>
                                            </td>
                                            <td><%=mf.getMobile_mess() %></td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="../js/jquery.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
</body>

</html>