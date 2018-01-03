<%@ page contentType="text/html;charset=utf-8" %>

<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>购物车</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">

</head>

<body>
    <div class="container">
        <%@ include file="base.html" %>

        <div class="row">
            <div class="col-md-10 col-md-offset-1">
                <div class="well">
                    <form role="form">
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th>
                                        <input type="checkbox" value="" />全选
                                    </th>
                                    <th>手机名称</th>
                                    <th>购买数量</th>
                                    <th>总额</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>
                                        <input type="checkbox" value="" />
                                    </td>
                                    <td>360 N6</td>
                                    <td>1</td>
                                    <td>1399</td>
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
                        <button data-toggle="modal" data-target="#myModal3" type="button" class="btn btn-default btn-lg">立即购买</button>

                        <div>
                            <div class="modal fade" id="myModal3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title" id="myModalLabel">确定购买</h4>
                                        </div>
                                        <div class="modal-body">共1399元</div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                            <button type="submit" class="btn btn-primary">立即购买</button>
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


        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
</body>

</html>