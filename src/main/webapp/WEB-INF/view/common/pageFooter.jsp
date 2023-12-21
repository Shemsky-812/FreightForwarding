<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- BEGIN FOOTER -->
<div class="page-footer">
    <div class="page-footer-inner"> 2017 &copy; 招银云创.
        <a href="http://www.mbcloud.com" title="招银云创" target="_blank">mbcloud.com</a>
    </div>
    <div class="scroll-to-top">
        <i class="icon-arrow-up"></i>
    </div>
</div>
<!-- END FOOTER -->
<script src="${ctx}/assets/mouse-click/js/mo.min.js"></script>
<script src="${ctx}/assets/mouse-click/js/mojs-player.min.js"></script>
<!-- 鼠标点击事件
<script>
'use strict';

var _extends = Object.assign || function (target) { for (var i = 1; i < arguments.length; i++) {if (window.CP.shouldStopExecution(2)){break;} var source = arguments[i]; for (var key in source) {if (window.CP.shouldStopExecution(1)){break;} if (Object.prototype.hasOwnProperty.call(source, key)) { target[key] = source[key]; } }
window.CP.exitedLoop(1);
 }
window.CP.exitedLoop(2);
 return target; };

var OPTS = {
    fill: 'none',
    radius: 25,
    strokeWidth: { 50: 0 },
    scale: { 0: 1 },
    angle: { 'rand(-35, -70)': 0 },
    duration: 500,
    left: 0,
    top: 0,
    easing: 'cubic.out'
};

var circle1 = new mojs.Shape(_extends({}, OPTS, {
    stroke: '#2AB4C0'
}));

var circle2 = new mojs.Shape(_extends({}, OPTS, {
    radius: { 0: 15 },
    strokeWidth: { 30: 0 },
    stroke: '#1BA39C',
    delay: 'rand(75, 150)'
}));

document.addEventListener('click', function (e) {
    circle1.tune({ x: e.pageX, y: e.pageY }).replay();

    circle2.tune({ x: e.pageX, y: e.pageY }).replay();
});
</script>
 -->