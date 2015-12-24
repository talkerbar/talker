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
    <link rel="stylesheet" href="/talker/css/list.css">
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