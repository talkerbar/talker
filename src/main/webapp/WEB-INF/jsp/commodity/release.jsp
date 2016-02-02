<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  	<title>商品列表-大学生生活服务平台</title>
  	<script src="/talker/js/jquery.min.js"></script>
  	<script src="/talker/js/center.js"></script>
    <script src="/talker/js/Image2Base64.js"></script>
    <script src="/talker/js/release.js"></script>
    <script src="/talker/js/school.js"></script>
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
    <div class="warp-center">
      <div class="warp-center-nav floatLeft">
        <div class="head-img">
          <img src="">
          <input type="file" id="first-head-select"/>
        </div>
        <ul>
          <li><a href="/talker/center/commodity">我的宝贝</a></li>
          <li><a href="/talker/center/info">我的资料</a></li>
          <li><a href="/talker/center/news">我的消息</a></li>
          <li class="lastli" id="current">出售闲置</li>
        </ul>
      </div>
      <form action="/talker/commodity/add" method="post" enctype="multipart/form-data">
      <div class="warp-center-content floatLeft">
        <div class="userinfo floatLeft commodityinfo">
           <ul>
             <li>
               <label for="name">
                 	标题
               </label>
               <input type="text" id="title" name="title">
               <span class="inputTip">请输入标题</span>
             </li>
             <li id="showSort">
               <label for="sort">
                 	类目
               </label>
               <input type="text" id="sort" value="请选择" readonly="readonly">
               <input type="hidden" id="sortValue" name="sortid">
               <span class="inputTip">请选择分类</span>
               <!-- 分类  -->
               <div id="warp_sortData">
                  <ul class="sortData">
                  </ul>
               </div>
               <!-- 分类 -->
             </li>
             <li>
               <label>
                 	新旧
               </label>
               <input type="radio" name="newandold" value="1" id="old" checked="checked"><label for="old">非全新</label><!--  
               --><input type="radio" name="newandold" value="2" id="new"><label for="new">全新</label>
             </li>
             <li>
               <label for="newprice">
                 	价格
               </label>
               <input type="text" id="newprice" name="newprice" placeholder="转卖价(元)">
               <input type="text" id="oldprice" name="oldprice" placeholder="原价(元)">
               <span class="inputTip">请输入转卖价</span>
             </li>
             <li>
               <label>
                 	讲价
               </label>
               <input type="radio" name="dicker" value="1" id="no" checked="checked"><label for="no">拒绝</label><!--  
               --><input type="radio" name="dicker" value="2" id="yes"><label for="yes">接收</label>
             </li>
             <li>
               <label for="cellnumber">
                	 联系方式
               </label>
               <input type="text" id="cellnumber" name="cellnumber" maxlength="11">
               <span class="inputTip">请输入11位联系方式</span>
             </li>
             <li>
               <label for="callname">
                 	联系称呼
               </label>
               <input type="text" id="callname" name="callname">
               <span class="inputTip">请输入联系称呼</span>
             </li>
             <li>
               <label for="schoolName">
                 	所在学校
               </label>
               <input type="text" value="请选择" id="schoolName" readonly="readonly"/>
               <input type="hidden" id="schoolid" name="schoolid"/>
               <span class="inputTip">请选择学校</span>
               <!--学校-->
               <div class="warp_schoolDate">
                  <div class="warp_province">
                    <ul>
                    </ul>
                  </div>
                  <div class="warp_school">
                    <ul>
                    </ul>
                  </div>
                </div>
               <!--学校-->
             </li>
             <li id="upImage">
               <label for="image">
                 	宝贝图片
               </label>
               <img src="/talker/images/up.png">
               <input type="file" id="image">
             </li>
             <li class="description">
               <label for="description">
                 	宝贝描述
               </label>
               <textarea id="description" name="description">1.使用时长：
2.新旧程度描述：
3.存在的问题：
4.到手时间/有效期/适用条件：</textarea>
             </li>
             <li>
               <input type="submit" id="commoditySubmit" value="立刻发布">
             </li>
           </ul>
         </div>
         <div class="showImg floatLeft">
         </div>
      </div>
      </form>
    </div>
    <!--遮罩-->
    <div class="mask"></div>
    <!--遮罩-->
    <!-- 提示  -->
    <div class="tip">
    	<div class="tip-content"></div>
    	<div class="confirm">
    		<button>确认</button>
    	</div>
    </div>
    <div class="tip-mask"></div>
    <!-- 提示  -->
    <!--图片计数器（1、限制图片的个数 2、防止id重复 3、标识是否是封面）-->
    <input type="hidden" value="0" id="index4img">
    <!--图片计数器-->
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