<%@ page contentType="text/html;charset=utf-8" %>

<%@ page import="java.util.*,cn.ldj.domain.*" %>

<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>浏览手机</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">

</head>

<body>
    <div class="container">
        <jsp:include page="base.jsp" />

		<%
		PageMobile pm = (PageMobile)request.getAttribute("pm");
		String clazz = (String)request.getAttribute("class");
		String version=(String)request.getAttribute("version");
		String name = (String)request.getAttribute("name");
		String low = (String)request.getAttribute("low");
		String high = (String)request.getAttribute("high");
		
		clazz = (clazz == null)?"":clazz;
		version = (version == null)?"":version;
		name = (name == null)?"":name;
		low = (low== null)?"":low;
		high = (high==null)?"":high;
		List<MobileForm> list = pm.getList();
		%>
        <div class="row">
            <div class="col-md-10 col-md-offset-1">
                <div class="well">
                    <table class="table table-bordered">
                        <caption>当前显示的内容</caption>
                        <thead>
                            <tr>
                                <th>手机标识号</th>
                                <th>手机图片</th>
                                <th>手机名称</th>
                                <th>手机价格</th>
                                <th>查看详情</th>
                                <th>添加到购物车</th>
                            </tr>
                        </thead>
                        <tbody>
                        <%
                        for(MobileForm mf:list) {
                        %>
                            <tr>
                                <td><%=mf.getMobile_version() %></td>
                                <td>
                                    <img src="<%=request.getContextPath() %><%=mf.getMobile_pic() %>" class="img-thumbnail">
                                </td>
                                <td><%=mf.getMobile_name() %></td>
                                <td><%=mf.getMobile_price() %></td>
                                <td>
                                <form action="MobileServlet?method=showDetail" role="form" method="post">
                                <input name="version" type="hidden" value="<%=mf.getMobile_version() %>" />
                                    <button type="submit" class="btn btn-default btn-sm">点击查看</button>
                               	</form>
                                </td>
                                <td>
                                <form action="ShopCarServlet?method=addShop" role="form" method="post">
                                <input name="version" type="hidden" value="<%=mf.getMobile_version() %>" />
                                    <button type="submit" class="btn btn-default btn-sm">添加</button>
                                </form>
                                </td>
                            </tr>
                        <%
                       	}
                        %>
                        </tbody>
                    </table>
                    <span class="label label-info">共<%=pm.getPageNum() %>页</span>
                    <span class="label label-info">当前在第<%=pm.getCurrentPage() %>页</span>
                    <span class="label label-info">每页显示<%=pm.getPageSize() %>条信息</span>
                    <ul class="pager">
                        <li class="previous">
                            <a href="MobileServlet?method=getList&page=<%=pm.getPre()%>
                            &class=<%=clazz%>&version=<%=version%>&name=<%=name%>&low=<%=low%>&
                            high=<%=high%>">
                            &larr; 前一页
                            </a>

                        </li>
                        <li class="next">
                            <a href="MobileServlet?method=getList&page=<%=pm.getNext()%>
                            &class=<%=clazz%>&version=<%=version%>&name=<%=name%>&low=<%=low%>&
                            high=<%=high%>">后一页 &rarr;</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>

    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>

</html>