<%@ page contentType="text/html;charset=utf-8" %>

<%@ page import="cn.ldj.domain.*" %>

<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>手机详情</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">

</head>

<body>
    <div class="container">
        <jsp:include page="base.jsp" />

		<%
		MobileForm mf = (MobileForm)request.getAttribute("mf");
		%>
        <div class="row">
            <div class="col-md-10 col-md-offset-1">
                <div class="well">
                    <div class="media">
                        <a class="media-left" href="#">
                            <img class="media-object" src="<%=request.getContextPath() %><%=mf.getMobile_pic() %>" alt="媒体对象">
                        </a>
                        <div class="media-body">
                            <h3 class="media-heading"><%=mf.getMobile_name() %></h3>
                            <p class="text-info"><%=mf.getMobile_mess() %></p>
                            <table class="table table-condensed">
                                <thead>
                                    <tr>
                                        <th>制造商</th>
                                        <th>价格</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td><%=mf.getMobile_made() %></td>
                                        <td>￥<%=mf.getMobile_price() %></td>
                                    </tr>
                                </tbody>
                            </table>
                            <form method="post" action="ShopCarServlet?method=addShop" role="form">
                            <input name="version" type="hidden" value="<%=mf.getMobile_version() %>" />
                                <button type="submit" class="btn btn-default btn-lg">加入购物车</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>

</html>