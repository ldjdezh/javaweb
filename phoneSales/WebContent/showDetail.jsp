<%@ page contentType="text/html;charset=utf-8" %>

<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>手机详情</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">

</head>

<body>
    <div class="container">
        <%@ include file="base.html" %>

        <div class="row">
            <div class="col-md-10 col-md-offset-1">
                <div class="well">
                    <div class="media">
                        <a class="media-left" href="#">
                            <img class="media-object" src="img/小米6.jpg" alt="媒体对象">
                        </a>
                        <div class="media-body">
                            <h3 class="media-heading">360 N6</h3>
                            <p class="text-info">青年新旗舰！5030mAh大电池/18W快充/5.93英寸全面屏/骁龙630/赠《全名枪战》豪杰礼包1张</p>
                            <table class="table table-condensed">
                                <thead>
                                    <tr>
                                        <th>制造商</th>
                                        <th>价格</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>360公司</td>
                                        <td>￥1399</td>
                                    </tr>
                                </tbody>
                            </table>
                            <form role="form">
                                <button type="button" class="btn btn-default btn-lg">加入购物车</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>

</html>