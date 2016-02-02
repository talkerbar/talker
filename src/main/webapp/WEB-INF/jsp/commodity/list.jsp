<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  	<title>商品列表-大学生生活服务平台</title>
  	<script src="/talker/js/jquery.min.js"></script>
  	<script src="/talker/js/list.js"></script>
    <link rel="stylesheet" href="/talker/css/common.css">
    <link rel="stylesheet" href="/talker/css/list.css?v=1.0">
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
    
    <!-- 学校和分类开始 -->
    <div class="warp-school-sort">
       <div class="warp-school">
          <div class="warp-school-title inline-block">
            	学校
          </div><!--
       --><div class="warp-school-con inline-block">
            <ul id="all-school-name">
            </ul>
          </div>
       </div>
       <div class="warp-sort">
         <div class="warp-sort-title inline-block">
            	分类
          </div><!--
       --><div class="warp-sort-con inline-block">
            <ul id="all-sort-name">
            </ul>
          </div>
       </div>
    </div>
    <!-- 学校和分类结束 -->

    <!-- 排序开始 -->
    <div class="warp-sequence">
      <div class="warp-sequence-left">
         <ul>
           <li class="current">热度</li>
           <li>最新</li>
           <li>价格</li>
           <!-- <li>距离</li> -->
         </ul>
      </div>
      <div class="warp-sequence-right">
      </div>
    </div>
    <!-- 排序结束 -->

    <!-- 商品列表开始 -->
    <div class="warp-commodity">
      <div class="warp-commodity-list">
		  <div class="loading">
			  <img src="/talker/images/loading.gif">
		  </div>        
      </div>
    </div>
    <!-- 商品列表结束 -->
	<input type="hidden" id="sortidmore" value="${sortidmore}"/>
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