<%@ page contentType="text/html;charset=utf-8" %>

<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>删除手机</title>

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
                            <p class="navbar-text">删除手机</p>
                        </div>
                    </div>
                </nav>
            </div>
        </div>

        <div class="row">
            <div class="col-md-10 col-md-offset-1">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <table class="table table-bordered">
                            <tbody>
                                <tr>
                                    <td>
                                        <label for="name">手机版本号</label>
                                    </td>
                                    <td>001</td>
                                </tr>
                                <tr>
                                    <td>
                                        <label for="name">手机名称</label>
                                    </td>
                                    <td>小米6</td>
                                </tr>
                                <tr>
                                    <td>
                                        <label for="name">手机制造商</label>
                                    </td>
                                    <td>小米公司</td>
                                </tr>
                                <tr>
                                    <td>
                                        <label for="name">手机价格</label>
                                    </td>
                                    <td>1234</td>
                                </tr>
                                <tr>
                                    <td>
                                        <label for="name">手机信息</label>
                                    </td>
                                    <td>呵呵</td>
                                </tr>
                            </tbody>
                        </table>
                        <div>
                            <label for="inputfile">手机图片</label>
                            <br/>
                            <img src="../img/vivox20.jpg" class="img-thumbnail">
                        </div>
                        <button data-toggle="modal" data-target="#myModal" type="button" class="btn btn-default">删除</button>

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
                                            确定删除?
                                        </div>
                                        <div class="modal-footer">
                                            <form role="form">
                                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                                                </button>
                                                <button type="submit" class="btn btn-primary">
                                                    提交
                                                </button>
                                            </form>
                                        </div>
                                    </div>
                                    <!-- /.modal-content -->
                                </div>
                                <!-- /.modal -->
                            </div>
                        </div>
                    </div>
                </div>
            </div>


            <script src="../js/jquery.min.js"></script>
            <script src="../js/bootstrap.min.js"></script>
</body>

</html>