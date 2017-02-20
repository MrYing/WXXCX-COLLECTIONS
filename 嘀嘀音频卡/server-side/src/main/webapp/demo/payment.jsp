<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <meta name="viewport" content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=0,width=device-width,initial-scale=1.0"/>
    <meta name="format-detection" content="telephone=no,email=no,date=no,address=no">
    <link rel="stylesheet" href="css/aui.2.0.css" type="text/css"/>
</head>
<style>
    body,html {
        font-family: 微软雅黑;
        height: 100%;

    }
    header{
        height: 8%;

    }
  section{
      height: 92%;
  }
.warp1{
	 height: auto; width: auto\9; width:100%;
    border-bottom: 1px solid #e0e0e0;
}
    .warp2{
	 height: auto; width: auto\9; width:100%;
        border-bottom: 1px solid #e0e0e0;
        padding: 5%;
    }
    .warp3{
        height: 50%;  }
    .name{
        font-size: 24px;
        text-align: center;
        padding: 10%;

    }
    .name img{
        height: 60px;
        width: 60px;
        display: inline-block;
        vertical-align: middle;
        position: relative;
        left: -4%;
    }
    .warp2 img{
        height: 30px;
        width: 20px;
        position: relative;
        left: 35%;
    }
    .warp2 input{
        font-size: 22px;
        margin: -10px 0 0 53px;
    }
 .pay_btn{
     background: url("image/anniu%20-%20Assistor.png") no-repeat;
	 height: auto; width: auto\9; width:100%;
     text-align: center;
     line-height: 48px;
 }
    .warp3{
        padding: 15% 5%;
    }
    .warp3 a{
        text-align: center;
        color: #ffffff;
    }
</style>
    <body>
    <header class="aui-bar aui-bar-nav aui-bar-light" style="background: #212121;color: #f5f5f5;font-size: 24px">
        <a class="aui-pull-left aui-btn" > <span class="aui-iconfont aui-icon-left"></span> </a>
        <div class="aui-title">
            向商户付款
        </div>
    </header>
    <section>
        <div class="warp1">
            <div class="name">
                <img src="image/shanghu%20-%20Assistor.png"/>
               <span> 久久茶餐厅</span>
            </div>
        </div>
        <div class="warp2">
            <div class="box">
                <h2>金额（元）</h2>
              <div class="aui-row" style="height: 108px;line-height: 108px;">
             <div class="aui-col-xs-2">  <img src="image/qian%20-%20Assistor.png"> </div>
                  <div class="aui-col-xs-10 aui-input">  <input type="text" placeholder="请填写收钱金额"/></div>
            </div>
        </div>
            </div>
        <div class="warp3">
            <div class="row pay_btn">
            <a href="javascript:void(0)">确认支付</a>
            </div>
        </div>
    </section>
</body>
</html>