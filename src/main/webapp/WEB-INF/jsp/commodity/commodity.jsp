<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  	<title>商品列表-大学生生活服务平台</title>
  	<script src="/talker/js/jquery.min.js"></script>
  	<script src="/talker/js/commodity.js"></script>
  	<script src="/talker/js/center.js"></script>
  	<script src="/talker/js/Image2Base64Head.js"></script>
  	<script src="/talker/js/imgAreaSelect/scripts/jquery.imgareaselect.pack.js"></script>
    <link rel="stylesheet" href="/talker/js/imgAreaSelect/css/imgareaselect-default.css" />
    <link rel="stylesheet" href="/talker/css/common.css">
    <link rel="stylesheet" href="/talker/css/center.css">
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
                <li>闲置数码</li>
                <li>闲置母婴</li>
                <li>家居日常</li>
                <li>影音家电</li>
                <li>鞋服配饰</li>
                <li>珠宝收藏</li>
              </ul>   
           </div>
           <div class="nav-items">
                <ul>
                  <li>校内淘</li>
                  <li>隔壁淘</li>
                  <li>同城淘</li>
                  <li>有人代购</li>
                  <li>一起回家</li>
                  <li>零花钱</li>
                  <li>我是学霸</li>
                </ul>
           </div>
  		</div>
  	</div>
  	<!-- Top End -->
    <div class="warp-center">
      <div class="warp-center-nav floatLeft">
        <div class="head-img">
          <img src="">
          <input type="file" id="first-head-select"/>
        </div>
        <ul>
          <li id="current">我的宝贝</li>
          <li><a href="/talker/center/info">我的资料</a></li>
          <li><a href="/talker/center/news">我的消息</a></li>
          <li class="lastli"><a href="/talker/center/release">出售闲置</a></li>
        </ul>
      </div>
      <div class="warp-center-content floatLeft">
	      <c:forEach var="data" items="${list }">
	        <div class="warp-commodity-list floatLeft">
	            <div class="warp-commodity-list-img floatLeft">
		            <a title="${data.title }" href="/talker/item?id=${data.id }"><img src="/talker/upload/${data.images[0].path }"></a>
	            </div>
	            <div class="warp-commodity-list-onfo floatLeft">
	              <p class="title"><a title="${data.title }" href="/talker/item?id=${data.id }">${data.title }</a></p>
	              <p class="price"><b class="opacity">￥</b><b class="color">${data.newprice }</b></p>
	              <p class="viewinfo"><span>浏览：${data.visits }</span><span>电话：${data.phoneRecords }</span><span>留言：0</span></p>
	            </div>
	            <div class="warp-commodity-list-operat floatLeft">
		            <c:choose>
		            	<c:when test="${data.status == 1 }">
		            		<p class="down" id="${data.id }">下架</p>
		            	</c:when>
		            	<c:otherwise>
			              	<p class="up" id="${data.id }">上架</p>
		            	</c:otherwise>
		            </c:choose>
		            <p class="del" id="${data.id }">删除</p>
	            </div>
	        </div>
	      </c:forEach>
      </div>
      </div>
      <!-- 提示  -->
   	  <div class="tip">
    	<div class="tip-content"></div>
    	 <div class="confirm">
    		<button>确认</button>
    	 </div>
        </div>
      <div class="tip-mask"></div>
      <!-- 提示  -->
      <!--遮罩-->
      <div class="mask"></div>
      <!--遮罩-->
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