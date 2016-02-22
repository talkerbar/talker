<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">"utf-8">
  	<title>商品列表-大学生生活服务平台</title>
  	<script src="/talker/js/jquery.min.js"></script>
  	<script src="/talker/js/center.js"></script>
  	<script src="/talker/js/news.js"></script>
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
				<li id="top-warp-top-left"></li>
			 	<li id="top-warp-top-right"><span><a href="/talker/public/login">登陆</a></span><span><a href="/talker/public/regist">注册</a></span></li>
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
			 		<div><a href="/talker/center/commodity">个人中心</a></div>
			 		<div><a href="/talker/center/release">出售商品</a></div>
			 	</li>
			 </ul>
		</div>
		<div class="top-warp-bottom list-top-special">
  			<div class="all-sort-warp all-sort-special">
	            <ul>
	              <li id="sort-first"><a href="/talker/public/list" target="_blank">全部商品分类</a><span class="all-sort"></span></li>
	              <li><a href="/talker/public/mobile-computers" target="_blank">手机/电脑/电脑配件</a></li>
	              <li><a href="/talker/public/car" target="_blank">摩托车/电动车/自行车</a></li>
	              <li><a href="/talker/public/digital-3c" target="_blank">数码3C产品</a></li>
	              <li><a href="/talker/public/books" target="_blank">书籍/书刊音像/文体用品</a></li>
	              <li><a href="/talker/public/camera" target="_blank">相机/摄像机</a></li>
	              <li><a href="/talker/public/other" target="_blank">其他闲置</a></li>
	            </ul>   
	         </div>
	         <div class="nav-items">
	              <ul>
	                <li><a href="/talker/public/index">首页</a></li>
	                <li><a href="/talker/public/list" target="_blank">我要买</a></li>
	                <li><a href="/talker/center/release">我要卖</a></li>
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
          <li><a href="/talker/center/commodity">我的宝贝</a></li>
          <li><a href="/talker/center/info">我的资料</a></li>
          <li id="current">我的消息</li>
          <li class="lastli"><a href="/talker/center/release">出售闲置</a></li>
        </ul>
      </div>
      <div class="warp-center-content floatLeft">
        <div class="warp-msg">
          <div class="warp-msg-nav">
            <ul>
              <li class="warp-msg-current" id="received-message">我收到的留言</li>
              <li id="post-message">我发布的留言</li>
            </ul>
          </div>
          <div class="warp-msg-body">
            <!-- 留言 -->
	        <div class="message">
	          <div class="message-post">
	          	<textarea id="J_commentText"></textarea>
	          	<div class="btn-post"><a href="javascript:void(0);" data-parent-id="-1" data-c-id="0">回复留言</a></div>
	          </div>
	          <div class="message-record">
	          </div>
	        </div>
          </div>
        </div>
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