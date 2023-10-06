<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>秒杀商品详情</title>

    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.4.1/css/bootstrap-theme.min.css" integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<%--    <script src="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>--%>

    <link rel="stylesheet" href="../../css/bootstrap.css">
    <script src="../../js/jquery-3.7.0.js"></script>

    <style>
        body {
            text-align: center;
            margin: 0;
            padding: 0;
        }

        .timer {
            position: absolute;
            margin: auto;
            left: 0;
            top: -80%;
            right: 0;
            bottom: 0;
            height: 80px;
            width: 900px;
            background-color: crimson;
            font-size: 50px;
        }

        .timer .zero {
            display: inline;
            width: auto;
            height: auto;
            background-color: pink;
        }
        .row{
            position: absolute;
            margin: auto;
            left: 40%;
            top: 21%;
            right: 0;
            bottom: 0;
        }
    </style>

</head>
<body>

<div class="timer">
    <span>离抢购开始还有</span>

    <div class="zero" id="day"><span>00</span></div>
    <span>天</span>

    <div class="zero" id="hour"><span>00</span></div>
    <span>时</span>

    <div class="zero" id="min"><span>00</span></div>
    <span>分</span>

    <div class="zero" id="sec"><span>00</span></div>
    <span>秒</span>

</div>



<div class="row">
    <div class="col-sm-6 col-md-4">
        <div class="thumbnail">
            <img src="../../img/IPhone15.jpeg">
            <div class="caption">
                <h3>${requestScope.item.getName()}</h3>
                <p>限时抢购中</p>
                <p><button id="a_buy" href="#" class="btn btn-default" role="button" readonly="true">抢购</button></p>
            </div>
        </div>
    </div>
</div>


<script type="text/javascript">
    var serverTime;
    var startTime = new Date(${requestScope.item.getStartTime().time});
    var endTime = new Date(${requestScope.item.getEndTime().time});
    var productId = ${requestScope.item.getId()};
    var isGetURL = false;

    console.log(productId);

    $(document).ready(function () {

        $.ajax({
            url:"/getServerTime",
            method:"post",
            dataType:"json",
            success:function (data) {
                // console.log(data);
                serverTime = data.data;
                console.log(serverTime);
            }
        });

        //更新倒计时
         var timer = setInterval(function(){

             // 10:30
             // 10:15
            var temp = startTime.getTime() - serverTime;
            // console.log("startTime:"+startTime.getTime());
            // console.log("serverTime:"+serverTime);
            // console.log("temp:"+temp)
            var seckillTemp = serverTime - endTime.getTime();

            if (temp<0 && seckillTemp>=0){
                //说明抢购活动已经结束
                $("#a_buy").one("click",function (){
                    $(this).removeClass("btn-default").
                    removeClass("btn-success").
                    addClass("btn-warning").
                    addClass("disabled").
                    text("秒杀抢购时间已经结束");
                });

                clearInterval(timer);

                return null;
            }


            if (temp <=0 && seckillTemp<0){
                //说明已经进入秒杀开始时间
                if (isGetURL){
                    return null;
                }
                //给抢购绑定点击事件
                // $("#a_buy").click(function () {
                //     $(this).attr("readonly","false");
                //     var url = "/buy?"+"id="+productId;
                //     $(this).attr("href",url);
                // });
                isGetURL = true;
                $(".timer").addClass("btn-success");
                // 从后端获取商品购买的URL
                $.ajax({
                    url:"/getURL",
                    dataType: "json",
                    method: "post",
                    data:{id:productId},
                    // data: JSON.stringify({productId:productId}),
                    // contentType: "application/json;charset=UTF-8",
                    success:function (data){
                        console.log(data);
                        $("#a_buy").removeClass("btn-default").addClass("btn-success").one('click',function (event) {

                                var url = "/buy?"+"id="+productId;
                                $.get({
                                    url:url,
                                    success:function (data) {
                                        alert(data.data);
                                        console.log(data);
                                    }
                                });
                        });

                    },
                });

            }
            // console.log("seckillTemp:"+seckillTemp);

            // if (temp < 0 ){
            //
            //     // timer = null;
            //
            //
            //     return null;
            // }

            if (!isGetURL){
                var day = Math.floor(temp / 1000 / 60 / 60 /24) ;

                var hour = Math.floor(temp / 1000 / 60 / 60 % 24) ;

                var min = Math.floor(temp / 1000 / 60 % 60 ) ;

                var sec = Math.floor(temp / 1000 % 60 ) ;

                // console.log(day+":"+hour+":"+min+":"+sec);

                updateTimer("day",day);
                updateTimer("hour",hour);
                updateTimer("min",min);
                updateTimer("sec",sec);

                serverTime = serverTime + 1000;
                // console.log("1秒过去了");
            }

         },1000);

         function updateTimer(idVal,value) {
             var str = ".timer div[id='"+idVal+"']";
             // console.log(str);
             // console.log($(str).text());
             if (value<10){
                 $(str).text("0"+value);
             }else {
                 $(str).text(value);
             }
             // console.log($(str).text());
             // $(".timer div[id=idVal]")

         }

         // updateTimer("day","0");

    });

</script>
</body>
</html>
