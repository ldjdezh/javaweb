<%@ page contentType="text/html;charset=utf-8" %>
<%@ page import="java.util.*,cn.ldj.domain.*" %>

<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>添加手机</title>

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
                            <p class="navbar-text">添加手机</p>
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
                        <form action="AddPhoneServlet" method="POST" role="form" enctype="multipart/form-data">
                            <div class="form-group">
                                <label for="name">手机版本号</label>
                                <input name="version" type="text" class="form-control" />
                            </div>
                            <div class="form-group">
                                <label for="name">手机名称</label>
                                <input name="name" type="text" class="form-control" />
                            </div>
                            <div class="form-group">
                                <label for="name">手机制造商</label>
                                <%
                                List<MobileClassify> list = (List<MobileClassify>)request.getAttribute("list");
                                %>
                                <select name="made" class="form-control">
                                	<%
                                	for(MobileClassify mc:list) {
                                	%>
                                    <option value="<%=mc.getMid()%>"><%=mc.getName()%></option>
                                    <%
                                    }
                                    %>
                                  </select>
                            </div>
                            <div class="form-group">
                                <label for="name">手机价格</label>
                                <input name="price" type="text" class="form-control" />
                            </div>
                            <div class="form-group">
                                <label for="name">手机信息</label>
                                <textarea name="mess" class="form-control" rows="3"></textarea>
                            </div>
                            <div class="form-group">
                                <label for="inputfile">手机图片</label>
                                <input name="file" type="file" id="inputfile">
                            </div>
                            <button type="submit" class="btn btn-default">提交</button>
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