<%@ page contentType="text/html;charset=utf-8" %>

<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>查询手机</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">

</head>

<body>
    <div class="container">
        <jsp:include page="base.jsp" />
        
        <div class="row">
            <div class="col-md-10 col-md-offset-1">
                <div class="well">
                    <div>
                        <ul id="myTab" class="nav nav-tabs">
                            <li class="active">
                                <a href="#version" data-toggle="tab">
                                    手机版本号
                                </a>
                            </li>
                            <li>
                                <a href="#name" data-toggle="tab">手机名称</a>
                            </li>
                            <li>
                                <a href="#money" data-toggle="tab">手机价格</a>
                            </li>
                        </ul>
                    </div>
                    <br/>
                    <div id="myTabContent" class="tab-content">
                        <div class="tab-pane fade in active" id="version">
                            <label>
                                请输入手机版本号
                            </label>
                            <input type="text" />
                            <button type="submit">提交</button>
                        </div>
                        <div class="tab-pane fade" id="name">
                            <label>
                                请输入手机名称
                            </label>
                            <input type="text" />
                            <button type="submit">提交</button>
                        </div>
                        <div class="tab-pane fade" id="money">
                            <label>
                                请输入最低价格
                            </label>
                            <input type="text" />
                            <label>
                                请输入最高价格
                            </label>
                            <input type="text" />
                            <button type="submit">提交</button>
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