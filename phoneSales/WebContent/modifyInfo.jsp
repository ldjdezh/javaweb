<%@ page contentType="text/html;charset=utf-8" %>
<%@ page import="cn.ldj.domain.*" %>
<jsp:useBean id="user" class="cn.ldj.domain.User" scope="session" />

<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>修改信息</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">

</head>

<body>
    <div class="container">
        <jsp:include page="base.jsp" />

        <div class="row">
            <div class="col-md-10 col-md-offset-1">
                <div class="well">
                    <form action="ModifyInfoServlet" method="post" role="form">
                        <div>
                            <label for="name">联系电话</label>
                            <input value='<jsp:getProperty property="phone" name="user"/>' name="phone" type="text" class="form-control" />
                        </div>
                        <div>
                            <label for="name">邮寄地址</label>
                            <input value='<jsp:getProperty property="address" name="user"/>' name="address" type="text" class="form-control" />
                        </div>
                        <div>
                            <label for="name">真实姓名</label>
                            <input value='<jsp:getProperty property="realname" name="user"/>' name="realname" type="text" class="form-control" />
                        </div>
                        <button data-toggle="modal" data-target="#myModal3" type="button" class="btn btn-default btn-lg">确定修改</button>

                        <div>
                            <div class="modal fade" id="myModal3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title" id="myModalLabel">提示</h4>
                                        </div>
                                        <div class="modal-body">
                                            是否确定修改?
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                            <button type="submit" class="btn btn-primary">确定</button>
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

    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>

</html>