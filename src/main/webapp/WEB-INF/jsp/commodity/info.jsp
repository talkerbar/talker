<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  	<title>商品列表-大学生生活服务平台</title>
  	<script src="/talker/js/jquery.min.js"></script>
    <script src="/talker/js/info.js"></script>
    <script src="/talker/js/school.js"></script>
    <script src="/talker/js/professional.js"></script>
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
          <img src="/talker/head/${rm.object.userInfoOut.icon}">
          <input type="file" id="first-head-select"/>
        </div>
        <ul>
          <li><a href="/talker/center/commodity">我的宝贝</a></li>
          <li id="current">我的资料</li>
          <li><a href="/talker/center/news">我的消息</a></li>
          <li class="lastli"><a href="/talker/center/release">出售闲置</a></li>
        </ul>
      </div>
      <div class="warp-center-content floatLeft">
        <div class="userinfo floatLeft">
           <ul>
             <li>
               <label for="name">
                 	<strong class="star">*</strong>昵称
               </label>
               <input type="text" id="nickname" value="${rm.object.userInfoOut.nickname }">
               <span class="inputTip">请输入昵称</span>
             </li>
             <li>
               <label for="name">
                 	<strong class="star">*</strong>真实姓名
               </label>
               <input type="text" id="realname" value="${rm.object.userInfoOut.realname }">
               <span class="inputTip">请输入真实姓名</span>
             </li>
             <li>
               <label>
                 	<strong class="star">*</strong>性别
               </label>
               <input type="radio" name="gender" value="1" ${rm.object.userInfoOut.gender==1?"checked":""} id="male"><label for="male">男</label><!--  
               --><input type="radio" name="gender" value="2" ${rm.object.userInfoOut.gender==2?"checked":""} id="female"><label for="female">女</label>
               <span class="inputTip">请选择性别</span>
             </li>
             <li>
               <label for="grade">
                 	年级
               </label>
               <select id="grade" name="grade">
               		<option value="0">请选择</option>
               		<option value="1" ${rm.object.userInfoOut.grade==1?"selected":""}>大一</option>
               		<option value="2" ${rm.object.userInfoOut.grade==2?"selected":""}>大二</option>
               		<option value="3" ${rm.object.userInfoOut.grade==3?"selected":""}>大三</option>
               		<option value="4" ${rm.object.userInfoOut.grade==4?"selected":""}>大四</option>
               		<option value="5" ${rm.object.userInfoOut.grade==5?"selected":""}>研一</option>
               		<option value="6" ${rm.object.userInfoOut.grade==6?"selected":""}>研二</option>
               		<option value="7" ${rm.object.userInfoOut.grade==7?"selected":""}>研三</option>
               		<option value="8" ${rm.object.userInfoOut.grade==8?"selected":""}>博一</option>
               		<option value="9" ${rm.object.userInfoOut.grade==9?"selected":""}>博二</option>
               </select>
               <span class="inputTip">请选择生日</span>
             </li>
             <li>
               <label for="telephone">
                 	<strong class="star">*</strong>手机号
               </label>
               <input type="text" id="telephone" value="${rm.object.userInfoOut.telephone}">
               <span class="inputTip">请输入手机号</span>
             </li>
             <li>
               <label for="schoolName">
                 	<strong class="star">*</strong>学校
               </label>
               <input type="hidden" id="schoolid" value="${rm.object.userInfoOut.schoolid}"/>
               <input type="text" id="schoolName" value="${rm.object.userInfoOut.schoolName}">
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
             <li>
               <label for="professionalName">
                 	专业
               </label>
               <input type="hidden" id="professionalid"/>
               <input type="text" id="professionalName" value="${rm.object.userInfoOut.professionalName}">
               <span class="inputTip">请选择专业</span>
               <!--专业-->
               <div class="warp_professionalDate">
                  <div class="warp_parent">
                    <ul>
                    </ul>
                  </div>
                  <div class="warp_professional">
                    <ul>
                    </ul>
                  </div>
                </div>
               <!--专业-->
             </li>
             <li>
               <input type="submit" id="userinfo" value="提交">
             </li>
           </ul>
         </div>
         <div class="userinfo userlogin floatLeft">
           <ul>
             <li>
               <label for="name">
                 	登录名
               </label>
               <input type="text" id="name" value="${rm.object.username}" readonly="readonly">
             </li>
             <li>
               <label for="name">
                 	密码
               </label>
               <input type="password" id="name" value="${rm.object.password}" readonly="readonly">
             </li>
             <li>
               <label for="oldpassword">
                	 旧密码
               </label>
               <input type="password" id="oldpassword">
               <span class="inputTip">请输入旧密码</span>
             </li>
             <li>
               <label for="password">
                 	新密码
               </label>
               <input type="password" id="password">
               <span class="inputTip">请输入新密码</span>
             </li>
             <li>
               <label for="repassword">
                 	再次输入
               </label>
               <input type="password" id="repassword">
               <span class="inputTip">请再次输入密码</span>
             </li>
             <li>
               <input type="submit" id="userlogin" value="提交">
             </li>
           </ul>
         </div>
      </div>
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
    <!-- 头像预览 -->
    <!-- <div class="preview-head">
		<ul>
			<li class="preview-head-title">
				<h3>自定义头像</h3>
			</li>
			<li class="preview-head-reselect">
				<input type="file" class="select-head"/>
				<button>重新选择</button>
				<span>支持jpg、png 图片,宽、高不小于200像素</span>
			</li>
			<li class="preview-head-content">
				<div class="preview-head-area">
					<img src="" id="head-area">
				</div>
				<div class="preview-head-sure">
					<img alt="头像预览" id="pre-head-base64">
				</div>
			</li>
			<li class="preview-head-confirm">
				<a href="javascript:void(0);" class="head-pre-save">确认</a>
				<a href="javascript:void(0);" class="head-pre-close">取消</a>
			</li>
		</ul>
	</div> -->
    <!-- 头像预览 -->
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