<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  	<title>商品列表-大学生生活服务平台</title>
  	<script src="/talker/js/jquery.min.js"></script>
    <link rel="stylesheet" href="/talker/css/common.css">
    <link rel="stylesheet" href="/talker/css/success.css">
  </head>
  <body>
  	<!-- Top Begin -->
  	<div class="top-warp">
  		<div class="top-warp-top">
  			<ul>
  				<li id="top-warp-top-left"></li><!--
  			 --><li id="top-warp-top-right"><span><a href="/talker/login">登陆</a></span><span>注册</span></li>
  			</ul>
  		</div>
  		<div class="top-warp-center">
  			 <ul>
  			 	<li class="top-warp-center-left">
  			 		<div><a href="/talker"><img src="" alt="logo" id="logo"></a></div>
  			 		<div><img src="" alt="slogan" id="slogan"></div>
  			 	</li><!--
         --><li class="top-warp-center-center">
               <div>
	               <input type="text" name="key" id="key"><!--
	            --><span id="search">搜索</span>
         	    </div>
          </li><!--
  			 --><li class="top-warp-center-right">
  			 		<div><a href="center.html">个人中心</a></div>
  			 		<div><a href="">出售商品</a></div>
  			 	</li>
  			 </ul>
  		</div>
  		<div class="top-warp-bottom list-top-special">
    		<div class="all-sort-warp">
	            <ul>
	              <li id="sort-first">全部商品分类</li>
	              <li>手机/电脑/电脑配件</li>
	              <li>摩托车/电动车/自行车</li>
	              <li>数码3C产品</li>
	              <li>书籍/文体用品</li>
	              <li>箱包配饰</li>
	              <li>生活服务</li>
	            </ul>   
	         </div>
	         <div class="nav-items">
	              <ul>
	                <li>首页</li>
	                <li>我要买</li>
	                <li>我要卖</li>
	              </ul>
	         </div>
  		</div>
  	</div>
  	<!-- Top End -->

    <!-- success -->
    <div class="success-warp">
      <div class="content">
        <h3 class="success-word">${ResponseModel.message }</h3>
        <p class="success-warn">卖闲置不用缴纳保证金，请警惕骗子买家提示无法完成付款，通过其他旺旺或邮箱诱导缴纳保证金的行为。</p>
      </div>
      <div class="button-warp">
        <a href="/talker/center/commodity">查看宝贝</a><a href="/talker/center/release">继续添加</a>
      </div>
    </div>
    <!-- success -->

    <!-- talker bottom  -->
    <div class="bottom-warp">
      <ul>
        <li class="li35">
          <h3>淘客吧</h3>
          <p>ICP备案号：豫ICP备14028764号</p>
          <p>©2015 Talkerbar.com</p>
        </li>
        <li class="li10">
          <h3>平台</h3>
          <p><a href="">关于我们</a></p>
          <p><a href="">招聘信息</a></p>
          <p><a href="">联系我们</a></p>
       </li>
       <li class="li10">
          <h3>消费者</h3>
          <p><a href="">帮助中心</a></p>
          <p><a href="">意见反馈</a></p>
       </li>
       <li class="li10">
          <h3>商家</h3>
          <p><a href="">帮助中心</a></p>
          <p><a href="">商家培训</a></p>
          <p><a href="">入住须知</a></p>
       </li>
        <li class="li35">
           <h3></h3>
           <p class="say me">这个世界有无数个中心，每天还在递增。</p>
           <p class="author me">———《视界》</p>
        </li>
      </ul>
    </div>
    <!-- talker bottom  -->
</body>
</html>