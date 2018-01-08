<%@ page contentType="text/html;charset=utf-8" %>

<%@ page import="java.util.*,cn.ldj.domain.*" %>

<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>查看手机</title>

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
                            <p class="navbar-text">查看手机</p>
                        </div>
                    </div>
                </nav>
            </div>
        </div>

        <div class="row">
            <jsp:include page="base.jsp" flush="true" />
            <%
            PageMobile pm = (PageMobile)request.getAttribute("pm");
            %>
            <div class="col-md-8">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th>手机图片</th>
                                    <th>手机名称</th>
                                    <th>价格</th>
                                    <td>操作</td>
                                </tr>
                            </thead>
                            <tbody>
                            <%
                            List<MobileForm> list = pm.getList();
                            for(MobileForm mf:list) {
                            %>
                                <tr>
                                    <td><img class="img-thumbnail" src="<%=request.getContextPath() %><%=mf.getMobile_pic() %>" /></td>
                                    <td><%=mf.getMobile_name() %></td>
                                    <td><%=mf.getMobile_price() %></td>
                                    <td>
                                        
                                            <div class="form-group">
                                            <form action="" method="post" role="form">
                                            <input value="<%=mf.getMobile_version() %>" type="hidden" name="version"/>
                                                <button class="btn btn-default btn-sm" type="submit">
                                                    修改
                                                </button>
                                            </form>
                                            <form action="" method="post" role="form">
                                            <input value="<%=mf.getMobile_version() %>" type="hidden" name="version"/>
                                                <button class="btn btn-default btn-sm" type="submit">
                                                    删除
                                                </button>
                                            </form>
                                            <form action="" method="post" role="form">
                                            <input value="<%=mf.getMobile_version() %>" type="hidden" name="version"/>
                                                <button class="btn btn-default btn-sm" type="submit">
                                                    查看详情
                                                </button>
                                            </form>
                                            </div>
                                        
                                    </td>
                                </tr>
                                <%} %>
                            </tbody>
                        </table>
                        <span class="label label-info">共<%=pm.getPageNum() %>页</span>
                        <span class="label label-info">当前在第<%=pm.getCurrentPage() %>页</span>
                        <span class="label label-info">每页显示<%=pm.getPageSize() %>条信息</span>
                        <ul class="pager">
                            <li class="previous">
                                <a href="GetAllPhone?page=<%=pm.getPre()%>">&larr; 前一页</a>
                            </li>
                            <li class="next">
                                <a href="GetAllPhone?page=<%=pm.getNext()%>">后一页 &rarr;</a>
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