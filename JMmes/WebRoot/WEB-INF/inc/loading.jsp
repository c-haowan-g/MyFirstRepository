<%@ page language="java" pageEncoding="UTF-8"%>

<style>
.__loading {
	width: 150px;
	height: 15px;
	margin: 0 auto;
	margin-top: 100px;
}

.__loading span {
	display: inline-block;
	width: 15px;
	height: 100%;
	margin-right: 5px;
	border-radius: 50%;
	background: #607D8B;
	-webkit-animation: load 1s ease infinite;
}

.loading span:last-child {
	margin-right: 0px;
}

@-webkit-keyframes load { 0%{opacity: 1;} 100%{opacity:0.1;}
}
.__loading span:nth-child(1) {
	-webkit-animation-delay: 0.13s;
}

.__loading span:nth-child(2) {
	-webkit-animation-delay: 0.26s;
}

.__loading span:nth-child(3) {
	-webkit-animation-delay: 0.39s;
}

.__loading span:nth-child(4) {
	-webkit-animation-delay: 0.52s;
}

.__loading span:nth-child(5) {
	-webkit-animation-delay: 0.65s;
}

.__loading_block {
	margin: 0 auto;
	margin-top:200px;
}
#__loading_div{
    position:fixed;width:100%;height:100%;background:#e2e2e2;z-index:9999999;text-align:center;
}
</style>
<div id="__loading_div" style="">
	<div class="__loading_block">
		<div class="__loading">
			<span></span> <span></span> <span></span><span></span> <span></span>
		</div>
	</div>
</div>
<script>
	window.onload = function() {
		setTimeout(function(){
			$("#__loading_div").fadeOut(200);
		},500);
	}
</script>