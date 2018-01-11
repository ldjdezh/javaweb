<%@ page contentType="text/html;charset=utf-8" %>
<%@ page import="java.util.*,cn.ldj.domain.*" %>

<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>修改手机</title>

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
                            <p class="navbar-text">修改手机</p>
                        </div>
                    </div>
                </nav>
            </div>


        </div>

		<%
		List<MobileClassify> cList = (List<MobileClassify>)request.getAttribute("cList");
		MobileForm mf = (MobileForm)request.getAttribute("mf");
		%>

        <div class="row">
            <div class="col-md-10 col-md-offset-1">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <form action="ModifyPhoneServlet" method="POST" role="form" enctype="multipart/form-data">
                            <input value="<%=mf.getMobile_version() %>" name="version" type="hidden" />
                            <div class="form-group">
                                <label for="name">手机名称</label>
                                <input value="<%=mf.getMobile_name() %>" name="name" type="text" class="form-control" />
                            </div>
                            <div class="form-group">
                                <label for="name">手机类别</label>
                                <select name="class" class="form-control">
                                <%
                                for(MobileClassify mc:cList) {
                                %>
                                    <option value="<%=mc.getMid()%>"><%=mc.getName() %></option>
                                <%
                                }
                                %>
                                  </select>
                            </div>
                            <div class="form-group">
                                <label for="name">手机价格</label>
                                <input value="<%=mf.getMobile_price() %>" name="price" type="text" class="form-control" />
                            </div>
                            <div class="form-group">
                                <label for="name">手机信息</label>
                                <textarea name="mess" class="form-control" rows="3"><%=mf.getMobile_mess() %></textarea>
                            </div>
                            <div class="form-group">
                                <label for="inputfile">原手机图片</label>
                                <br/>
                                <img src="<%=request.getContextPath() %><%=mf.getMobile_pic() %>" class="img-thumbnail">
                                <br/>
                                <label for="inputfile">上传新图片</label>
                                <input name="file" type="file" id="inputfile">
                            </div>
                            <button data-toggle="modal" data-target="#myModal" type="button" class="btn btn-default">修改</button>

                            <div>
                                <!-- 模态框（Modal） -->
                                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                                    &times;
                                                </button>
                                                <h4 class="modal-title" id="myModalLabel">
                                                    提示
                                                </h4>
                                            </div>
                                            <div class="modal-body">
                                                确定修改?
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                                                </button>
                                                <button type="submit" class="btn btn-primary">
                                                    提交
                                                </button>
                                            </div>
                                        </div>
                                        <!-- /.modal-content -->
                                    </div>
                                    <!-- /.modal -->
                                </div>
                                </div>
                        </form>
                        </div>
                    </div>
                </div>
                </div>
                <script src="../js/jquery.min.js"></script>
                <script src="../js/bootstrap.min.js"></script>
</body>

</html>