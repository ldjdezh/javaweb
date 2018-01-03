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
                    <form role="form">
                        <div class="form-group">
                            <label for="name">选择某类手机</label>
                            <select class="form-control">
                                <option>所有手机</option>
                                <option>小米</option>
                                <option>华为</option>
                                <option>vivo</option>
                                <option>oppo</option>
                            </select>
                            <button type="submit" class="btn btn-default">确定</button>
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