<%@ page contentType="text/html;charset=utf-8" %>
<%@ page import="java.util.*,cn.ldj.domain.*" %>

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
        <jsp:include page="base.jsp" />

        <div class="row">
            <div class="col-md-10 col-md-offset-1">
                <div class="well">
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th>手机名称</th>
                                    <th>单价</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                List<ShopCar> carList = (List<ShopCar>)request.getSession().getAttribute("carList");
                                
                                double price = 0;
                                for(ShopCar shopCar:carList) {
                                	double p = shopCar.getMf().getMobile_price();
                                	price += p;
                                %>
                                <tr>
                                    <td><%=shopCar.getMf().getMobile_name() %></td>
                                    <td><%=p %></td>
                                </tr>
                                <%
                                }
                                %>
                            </tbody>
                        </table>
                        <button data-toggle="modal" data-target="#myModal3" type="button" class="btn btn-default btn-lg">立即购买</button>

                        <div>
                            <div class="modal fade" id="myModal3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title" id="myModalLabel">确定购买</h4>
                                        </div>
                                        <div class="modal-body">共<%=price %>元</div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                            <form action="OrderServlet?method=addOrder" method="post" role="form">
                                            <button type="submit" class="btn btn-primary">立即购买</button>
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
</div>

        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
</body>

</html>