<%@ page contentType="text/html;charset=utf-8" %>

<%@ page import="java.util.*,cn.ldj.domain.*" %>

<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>查看订单</title>

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
                            <p class="navbar-text">查看订单</p>
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
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th>用户</th>
                                    <th>订单号</th>
                                    <th>手机名称</th>
                                    <th>数量</th>
                                    <th>价格</th>
                                    <th>状态</th>
                                </tr>
                            </thead>
                            <tbody>
                            <%
                            PageOrder po = (PageOrder)request.getAttribute("po");
                            List<OrderForm> list = po.getList();
                            %>
                            
                            <%
                            for(OrderForm of:list) {
                            	MobileForm mf = of.getMobileForm();
                            	User user = of.getUser();
                            %>
                                <tr>
                                    <td><%=user.getLogname() %></td>
                                    <td><%=of.getOid() %></td>
                                    <td><%=mf.getMobile_name() %></td>
                                    <td><%=of.getNum() %></td>
                                    <td><%=of.getSum() %></td>
                                    <td>
                                        	正在配送
                                    </td>
                                </tr>
                                <%
                            	}
                                %>
                            </tbody>
                        </table>
                        <span class="label label-info">共<%=po.getPageNum() %>页</span>
                        <span class="label label-info">当前在第<%=po.getCurrentPage() %>页</span>
                        <span class="label label-info">每页显示<%=po.getPageSize() %>条信息</span>
                        <ul class="pager">
                            <li class="previous">
                                <a href="AdminServlet?method=lookOrder&page=<%=po.getPre()%>">&larr; 前一页</a>
                            </li>
                            <li class="next">
                                <a href="AdminServlet?method=lookOrder&page=<%=po.getNext()%>">后一页 &rarr;</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
</div>

        <script src="../js/jquery.min.js"></script>
        <script src="../js/bootstrap.min.js"></script>
</body>

</html>