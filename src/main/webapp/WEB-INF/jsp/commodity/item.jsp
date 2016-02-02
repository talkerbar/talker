<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  	<title>商品列表-大学生生活服务平台</title>
  	<script src="/talker/js/jquery.min.js"></script>
  	<script src="/talker/js/swiper.js"></script>
  	<script src="/talker/js/item.js"></script>
    <link rel="stylesheet" href="/talker/css/common.css">
    <link rel="stylesheet" href="/talker/css/item.css">
    <link rel="stylesheet" href="/talker/css/swiper.css">
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
	                <li>首页</li>
	                <li>我要买</li>
	                <li>我要卖</li>
	              </ul>
	         </div>
  		</div>
  	</div>
  	<!-- Top End -->
    
    <!-- 商家、商品基本信息开始 -->
    <div class="warp-commodity">
      <div class="warp-shop-detail">
          <ul>
            <li>
               <div>
                 <p class="shop-detail-head">上传者</p>
                 <p class="shop-detail-data">${commodity.userInfoOut.nickname }</p>
               </div>
            </li>
            <li>
               <div>
                 <p class="shop-detail-head">上传时间</p>
                 <p class="shop-detail-data">${commodity.createTime }</p>
               </div>
            </li>
            <li>
               <div>
                 <p class="shop-detail-head">浏览次数</p>
                 <p class="shop-detail-data">${commodity.visits }</p>
               </div>
            </li>
            <li>
               <div>
                 <p class="shop-detail-head">联系次数</p>
                 <p class="shop-detail-data">${commodity.phoneRecords }</p>
               </div>
            </li>
          </ul>
      </div>
      <div class="warp-commodity-detail">
        <div class="detail-big-img">
          <div>
              <img src="/talker/upload/${commodity.images[0].path }" alt="">
          </div>
        </div>
        <div class="detail-small-img swiper-container">
          <ul class="swiper-wrapper">
          	<c:forEach var="image" items="${commodity.images}">
	            <li class="swiper-slide">
	                <div>
	                  <img src="/talker/upload/${image.path }" alt="">
	                </div>
	            </li>
          	</c:forEach>
          </ul>
        </div>
        <div class="detail-desc">
          <div id="detail-desc-title">
            ${commodity.title }
          </div><!-- 标题 -->
          <div>
            <label for="1">转卖价</label>
            <span id="1"><b>￥${commodity.newprice }</b></span>
          </div><!-- 转卖价 -->
          <div>
            <label for="2">原价</label>
            <span id="2"><s>￥${commodity.oldprice }</s></span>
          </div><!-- 原价 -->
          <div>
            <label for="3">接受还价</label>
            <span id="3">${commodity.dicker eq 1?"接受":"不接受" }</span>
          </div><!-- 是否接受还价 -->
          <div>
            <label for="4">成色</label>
            <span id="4">${commodity.newandold eq 1?"全新":"非全新" }</span>
          </div><!-- 新旧程度 -->
          <div>
            <label for="5">来自</label>
            <span id="5">${commodity.schoolName }</span>
          </div><!-- 商品所在学校 -->
          <div>
            <label for="6">称呼</label>
            <span id="6">${commodity.callname }</span>
          </div><!-- 称呼 -->
          <div>
            <label for="7">联系电话</label>
            <span id="7">${commodity.starcellnumber }</span>
          </div><!-- 联系方式 -->
          <div>
            <button class="mobile">获取联系方式</button>
          </div>
          <input type="hidden" id="commodity-id" value="${commodity.id }"/>
        </div>
      </div>
    </div>
    <!-- 商家、商品基本信息结束 -->
    
    <!-- 商品附加信息开始 -->
    <div class="warp-nav-main">
        <!-- 商品附加导航 -->
        <div class="nav-mian-top">
          <ul>
            <li class="current" id="nav-mian-top-desc">
              	宝贝介绍
              <i class="bor"></i>
            </li>
            <li id="nav-mian-top-message">
              	留言
              <i class="bor"></i>
            </li>	
          </ul>
        </div>
        <!-- 宝贝介绍 -->
        <div class="nav-mian-detail">
             <h2>宝贝介绍</h2>
             <textarea disabled="disabled">${commodity.description }</textarea>
        </div>
        <!-- 留言 -->
        <div class="message">
          <div class="message-head">留言</div>
          <div class="message-post">
          	<textarea id="J_commentText"></textarea>
          	<div class="btn-post"><a href="javascript:void(0);" data-parent-id="-1">发表留言</a></div>
          </div>
          <div class="message-record">
          </div>
        </div>
    </div>
    <!-- 商品附加信息结束 -->
    <!-- 登陆  -->
    <div class="content">
		<ul>
			<li class="desc">
				<span>登陆</span>
				<span>免费注册</span>
			</li>
			<li class="username info">
				<span class="icon-username icon"></span>
				<input type="text" name="username" id="username"/>
			</li>
			<li class="password info">
				<span class="icon-password icon"></span>
				<input type="password" name="password" id="password"/>
			</li>
			<li class="help">
				<a href="">忘记密码？</a>
				<p class="login-error-tip"></p>
			</li>
			<li class="confirm-login">
				<button>登陆</button>
			</li>
			<li class="other">
			</li>
		</ul>
	</div>
    <!-- 登陆  -->
	<!-- 提示  -->
    <div class="tip">
    	<div class="tip-content"></div>
    	<div class="confirm">
    		<button>确认</button>
    	</div>
    </div>
    <div class="tip-mask"></div>
    <!-- 提示  -->
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