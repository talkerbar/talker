<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>淘客吧-大学生生活服务平台</title>
	<script src="/talker/js/jquery.min.js"></script>
	<script src="/talker/js/swiper.js"></script>
	<script src="/talker/js/index.js"></script>
  	<link rel="stylesheet" href="/talker/css/index.css">
  	<link rel="stylesheet" href="/talker/css/common.css">
  	<link rel="stylesheet" href="/talker/css/swiper.css">
</head>
<body>
	<!-- Top Begin -->
	<div class="top-warp">
		<div class="top-warp-top">
			<ul>
				<li id="top-warp-top-left"></li>
			 	<li id="top-warp-top-right"><span><a href="/talker/login">登陆</a></span><span><a href="/talker/regist">注册</a></span></li>
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
		<div class="top-warp-bottom">
  			<div class="all-sort-warp">
	            <ul>
	              <li id="sort-first">全部商品分类<span class="all-sort"></span></li>
	              <li>手机/电脑/电脑配件</li>
	              <li>摩托车/电动车/自行车</li>
	              <li>数码3C产品</li>
	              <li>书籍/书刊音像/文体用品</li>
	              <li>相机/摄像机</li>
	              <li>其他闲置</li>
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
    <div class="rotation-warp swiper-container swiper-container-tab">
    	<ul id="rotation-warp-ul"  class="swiper-wrapper">
	        <li class="swiper-slide">
	          <a href="/talker/list">
	            <img src="/talker/images/1.jpg" alt="">
	          </a>
	        </li>
      </ul>
      <!-- <ol class="swiper-pagination swiper-pagination-tab"></ol> -->
    </div>

    <div class="content-warp">
       <!--  Hot ad  -->
      <div class="hot-id-warp">
       <div>
         <a href="">
           <img src="/talker/images/2015ad.jpg" alt="">
         </a>
       </div>
     </div>
     <!--  Hot Goods  -->
     <div class="hot-goods-warp">
       <div id="hot-goods-warp-nav">
         <h2>热门商品</h2>
         <p class="hot-text">HOT TODAY</p>
         <p>
           <span>
              <!-- 本周 -->
           </span>
           <span>
              <!-- 本月 -->
           </span>
         </p>
       </div>
       <div class="hot-goods-warp-googs">
           <ul>
           </ul>
       </div>
     </div>
     <!--  Hot Goods end -->
     <!--  图书馆  -->
     <div class="floor-warp">
       <div class="floor-warp-text">
          <h2 class="inline-block">图书馆</h2>
          <p class="hot-text inline-block"></p>
       </div>
       <div class="floor-warp-subject">
         <div class="floor-warp-subject-items inline-block">
             <a href=""><img src="/talker/images/2015me.jpg" alt=""></a>
         </div><!--
      --><div class="floor-warp-subject-body inline-block">
              <ul class="ul-warp">
                <li class="ul-warp-rotation swiper-container swiper-container-library">
                  <ul class="ul-warp-rotation-ul swiper-wrapper">
                    <li class="swiper-slide">
                      <a href="">
                        <img src="/talker/images/2015small.jpg" alt="">
                      </a>
                    </li>
                    <li class="swiper-slide">
                      <a href="">
                        <img src="/talker/images/2015small.jpg" alt="">
                      </a>
                    </li>
                    <li class="swiper-slide">
                      <a href="">
                        <img src="/talker/images/2015small.jpg" alt="">
                      </a>
                    </li>
                    <li class="swiper-slide">
                      <a href="">
                        <img src="/talker/images/2015small.jpg" alt="">
                      </a>
                    </li>
                  </ul>
                  <ol class="swiper-pagination swiper-pagination-library"></ol>
                </li><!--
             --><li class="ul-warp-4">
                   <ul>
                     <li></li>
                     <li></li>
                     <li></li>
                     <li></li>
                   </ul>
                </li><!--
             --><li class="ul-warp-2">
                   <ul>
                     <li></li>
                     <li></li>
                   </ul>
               </li><!--
             --><li class="ul-warp-2">
                    <ul>
                     <li></li>
                     <li></li>
                   </ul>
                </li>
              </ul>
         </div>
       </div>
       
     </div>
     <!-- 图书馆 -->

     <!-- 车行  -->
     <div class="floor-warp">
       <div class="floor-warp-text">
          <h2 class="inline-block">车行</h2>
          <p class="hot-text inline-block"></p>
       </div>
       <div class="floor-warp-subject">
         <div class="floor-warp-subject-items inline-block">
             <a href=""><img src="/talker/images/2015me.jpg" alt=""></a>
         </div><!--
      --><div class="floor-warp-subject-body inline-block">
              <ul class="ul-warp">
                <li class="ul-warp-rotation swiper-container swiper-container-vehicle">
                  <ul class="ul-warp-rotation-ul swiper-wrapper">
                    <li class="swiper-slide">
                      <a href="">
                        <img src="/talker/images/2015small.jpg" alt="">
                      </a>
                    </li>
                    <li class="swiper-slide">
                      <a href="">
                        <img src="/talker/images/2015small.jpg" alt="">
                      </a>
                    </li>
                    <li class="swiper-slide">
                      <a href="">
                        <img src="/talker/images/2015small.jpg" alt="">
                      </a>
                    </li>
                    <li class="swiper-slide">
                      <a href="">
                        <img src="/talker/images/2015small.jpg" alt="">
                      </a>
                    </li>
                  </ul>
                  <ol class="swiper-pagination swiper-pagination-vehicle"></ol>
                </li>
                <li class="ul-warp-4">
                   <ul>
                     <li></li>
                     <li></li>
                     <li></li>
                     <li></li>
                   </ul>
                </li>
                <li class="ul-warp-2">
                   <ul>
                     <li></li>
                     <li></li>
                   </ul>
               </li>
               <li class="ul-warp-2">
                    <ul>
                     <li></li>
                     <li></li>
                   </ul>
                </li>
              </ul>
         </div>
       </div>
       
     </div>
     <!-- 车行 -->

    <!-- 电子城  -->
     <div class="floor-warp">
       <div class="floor-warp-text">
          <h2 class="inline-block">电子城</h2>
          <p class="hot-text inline-block"></p>
       </div>
       <div class="floor-warp-subject">
         <div class="floor-warp-subject-items inline-block">
             <a href=""><img src="/talker/images/2015me.jpg" alt=""></a>
         </div><!--
      --><div class="floor-warp-subject-body inline-block">
              <ul class="ul-warp">
                <li class="ul-warp-rotation swiper-container swiper-container-digital">
                  <ul class="ul-warp-rotation-ul swiper-wrapper">
                    <li class="swiper-slide">
                      <a href="">
                        <img src="/talker/images/2015small.jpg" alt="">
                      </a>
                    </li>
                    <li class="swiper-slide">
                      <a href="">
                        <img src="/talker/images/2015small.jpg" alt="">
                      </a>
                    </li>
                    <li class="swiper-slide">
                      <a href="">
                        <img src="/talker/images/2015small.jpg" alt="">
                      </a>
                    </li>
                    <li class="swiper-slide">
                      <a href="">
                        <img src="/talker/images/2015small.jpg" alt="">
                      </a>
                    </li>
                  </ul>
                  <ol class="swiper-pagination swiper-pagination-digital"></ol>
                </li><!--
             --><li class="ul-warp-4">
                   <ul>
                     <li></li>
                     <li></li>
                     <li></li>
                     <li></li>
                   </ul>
                </li><!--
             --><li class="ul-warp-2">
                   <ul>
                     <li></li>
                     <li></li>
                   </ul>
               </li><!--
             --><li class="ul-warp-2">
                    <ul>
                     <li></li>
                     <li></li>
                   </ul>
                </li>
              </ul>
         </div>
       </div>
       
     </div>
     <!-- 电子城 -->
    </div>
    
    <!--  bottom ad  -->
      <div class="bottom-ad-warp">
       <div>
         <a href="">
           <img src="/talker/images/2015ad.jpg" alt="">
         </a>
       </div>
     </div>
    <!-- daren -->
<!--     <div class="daren-warp">
       <div id="daren-warp-text">
          <p>Forever</p><span>●</span><h2>不离不弃</h2>
       </div>
       <div id="daren-warp-con">
         <div id="daren-warp-con-left">
            <ul>
              <li class="current-daren">1</li>
          <li>2</li>
          <li>3</li>
          <li>4</li>
          <li>5</li>
            </ul>
         </div>
         <div id="daren-warp-con-right">
           <ul>
             <li>
               <a href="">
                 <img src="" alt="">
               </a>
             </li>
             <li>
               <a href="">
                 <img src="" alt="">
               </a>
             </li>
             <li>
               <a href="">
                 <img src="" alt="">
               </a>
             </li>
             <li>
               <a href="">
                 <img src="" alt="">
               </a>
             </li>
             <li>
               <a href="">
                 <img src="" alt="">
               </a>
             </li>
           </ul>
         </div>
       </div>
    </div> -->
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