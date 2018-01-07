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
        <jsp:include page="base.jsp" />

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
                            <tr>
                                <td>csss</td>
                                <td>
                                    <img src="img/360N6Pro.jpg" class="img-thumbnail">
                                </td>
                                <td>苹果999</td>
                                <td>53453</td>
                                <td>
                                    <button type="button" class="btn btn-default btn-sm">点击查看</button>
                                </td>
                                <td>
                                    <button type="button" class="btn btn-default btn-sm">添加</button>
                                </td>
                            </tr>
                            <tr>
                                <td>csss</td>
                                <td>
                                    <img src="img/oppor11s.jpg" class="img-thumbnail">
                                </td>
                                <td>小米999</td>
                                <td>53453</td>
                                <td></td>
                                <td></td>
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

    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>

</html>