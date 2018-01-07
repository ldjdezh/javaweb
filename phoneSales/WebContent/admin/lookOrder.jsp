<%@ page contentType="text/html;charset=utf-8" %>

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
                            <a class="navbar-brand" href="#">手机销售网后台系统</a>
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
                                <tr>
                                    <td>小明</td>
                                    <td>001</td>
                                    <td>360 N6</td>
                                    <td>1</td>
                                    <td>1399</td>
                                    <td>
                                        <form role="form">
                                            <div class="form-group">
                                                <select class="form-control">
                                                    <option>取消订单</option>
                                                    <option>发货</option>
                                                    <option>正在配送</option>
                                                    <option>已收货</option>
                                                </select>
                                                <button class="btn btn-default btn-sm" type="submit">
                                                    确定
                                                </button>
                                            </div>
                                        </form>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                        <span class="label label-info">共10页</span>
                        <span class="label label-info">当前在第1页</span>
                        <span class="label label-info">每页显示5条信息</span>
                        <ul class="pager">
                            <li class="previous">
                                <a href="#">&larr; 前一页</a>
                            </li>
                            <li class="next">
                                <a href="#">后一页 &rarr;</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>


        <script src="../js/jquery.min.js"></script>
        <script src="../js/bootstrap.min.js"></script>
</body>

</html>