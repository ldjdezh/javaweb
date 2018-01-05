<%@ page contentType="text/html;charset=utf-8" %>

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
        <%@ include file="base.html" %>

        <div class="row">
            <div class="col-md-10 col-md-offset-1">
                <div class="well">
                    <form role="form" method="POST" action="index.html">
                        <div>
                            <label for="name">原密码</label>
                            <input type="text" class="form-control" name="password" />
                        </div>
                        <div>
                            <label for="name">新密码</label>
                            <input type="text" class="form-control" name="newPassword" />
                        </div>
                        <div>
                            <label for="name">再次输入新密码</label>
                            <input type="text" class="form-control" name="againPassword" />
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