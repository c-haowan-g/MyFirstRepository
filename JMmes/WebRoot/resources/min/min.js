/*! jQuery v1.12.4 | (c) jQuery Foundation | jquery.org/license */
!function(a,b){"object"==typeof module&&"object"==typeof module.exports?module.exports=a.document?b(a,!0):function(a){if(!a.document){throw new Error("jQuery requires a window with a document")}return b(a)}:b(a)}("undefined"!=typeof window?window:this,function(a,b){var c=[],d=a.document,e=c.slice,f=c.concat,g=c.push,h=c.indexOf,i={},j=i.toString,k=i.hasOwnProperty,l={},m="1.12.4",n=function(a,b){return new n.fn.init(a,b)},o=/^[\s\uFEFF\xA0]+|[\s\uFEFF\xA0]+$/g,p=/^-ms-/,q=/-([\da-z])/gi,r=function(a,b){return b.toUpperCase()};n.fn=n.prototype={jquery:m,constructor:n,selector:"",length:0,toArray:function(){return e.call(this)},get:function(a){return null!=a?0>a?this[a+this.length]:this[a]:e.call(this)},pushStack:function(a){var b=n.merge(this.constructor(),a);return b.prevObject=this,b.context=this.context,b},each:function(a){return n.each(this,a)},map:function(a){return this.pushStack(n.map(this,function(b,c){return a.call(b,c,b)}))},slice:function(){return this.pushStack(e.apply(this,arguments))},first:function(){return this.eq(0)},last:function(){return this.eq(-1)},eq:function(a){var b=this.length,c=+a+(0>a?b:0);return this.pushStack(c>=0&&b>c?[this[c]]:[])},end:function(){return this.prevObject||this.constructor()},push:g,sort:c.sort,splice:c.splice},n.extend=n.fn.extend=function(){var a,b,c,d,e,f,g=arguments[0]||{},h=1,i=arguments.length,j=!1;for("boolean"==typeof g&&(j=g,g=arguments[h]||{},h++),"object"==typeof g||n.isFunction(g)||(g={}),h===i&&(g=this,h--);i>h;h++){if(null!=(e=arguments[h])){for(d in e){a=g[d],c=e[d],g!==c&&(j&&c&&(n.isPlainObject(c)||(b=n.isArray(c)))?(b?(b=!1,f=a&&n.isArray(a)?a:[]):f=a&&n.isPlainObject(a)?a:{},g[d]=n.extend(j,f,c)):void 0!==c&&(g[d]=c))}}}return g},n.extend({expando:"jQuery"+(m+Math.random()).replace(/\D/g,""),isReady:!0,error:function(a){throw new Error(a)},noop:function(){},isFunction:function(a){return"function"===n.type(a)},isArray:Array.isArray||function(a){return"array"===n.type(a)},isWindow:function(a){return null!=a&&a==a.window},isNumeric:function(a){var b=a&&a.toString();return !n.isArray(a)&&b-parseFloat(b)+1>=0},isEmptyObject:function(a){var b;for(b in a){return !1}return !0},isPlainObject:function(a){var b;if(!a||"object"!==n.type(a)||a.nodeType||n.isWindow(a)){return !1}try{if(a.constructor&&!k.call(a,"constructor")&&!k.call(a.constructor.prototype,"isPrototypeOf")){return !1}}catch(c){return !1}if(!l.ownFirst){for(b in a){return k.call(a,b)}}for(b in a){}return void 0===b||k.call(a,b)},type:function(a){return null==a?a+"":"object"==typeof a||"function"==typeof a?i[j.call(a)]||"object":typeof a},globalEval:function(b){b&&n.trim(b)&&(a.execScript||function(b){a.eval.call(a,b)})(b)},camelCase:function(a){return a.replace(p,"ms-").replace(q,r)},nodeName:function(a,b){return a.nodeName&&a.nodeName.toLowerCase()===b.toLowerCase()},each:function(a,b){var c,d=0;if(s(a)){for(c=a.length;c>d;d++){if(b.call(a[d],d,a[d])===!1){break}}}else{for(d in a){if(b.call(a[d],d,a[d])===!1){break}}}return a},trim:function(a){return null==a?"":(a+"").replace(o,"")},makeArray:function(a,b){var c=b||[];return null!=a&&(s(Object(a))?n.merge(c,"string"==typeof a?[a]:a):g.call(c,a)),c},inArray:function(a,b,c){var d;if(b){if(h){return h.call(b,a,c)}for(d=b.length,c=c?0>c?Math.max(0,d+c):c:0;d>c;c++){if(c in b&&b[c]===a){return c}}}return -1},merge:function(a,b){var c=+b.length,d=0,e=a.length;while(c>d){a[e++]=b[d++]}if(c!==c){while(void 0!==b[d]){a[e++]=b[d++]}}return a.length=e,a},grep:function(a,b,c){for(var d,e=[],f=0,g=a.length,h=!c;g>f;f++){d=!b(a[f],f),d!==h&&e.push(a[f])}return e},map:function(a,b,c){var d,e,g=0,h=[];if(s(a)){for(d=a.length;d>g;g++){e=b(a[g],g,c),null!=e&&h.push(e)}}else{for(g in a){e=b(a[g],g,c),null!=e&&h.push(e)}}return f.apply([],h)},guid:1,proxy:function(a,b){var c,d,f;return"string"==typeof b&&(f=a[b],b=a,a=f),n.isFunction(a)?(c=e.call(arguments,2),d=function(){return a.apply(b||this,c.concat(e.call(arguments)))},d.guid=a.guid=a.guid||n.guid++,d):void 0},now:function(){return +new Date},support:l}),"function"==typeof Symbol&&(n.fn[Symbol.iterator]=c[Symbol.iterator]),n.each("Boolean Number String Function Array Date RegExp Object Error Symbol".split(" "),function(a,b){i["[object "+b+"]"]=b.toLowerCase()});function s(a){var b=!!a&&"length" in a&&a.length,c=n.type(a);return"function"===c||n.isWindow(a)?!1:"array"===c||0===b||"number"==typeof b&&b>0&&b-1 in a}var t=function(a){var b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u="sizzle"+1*new Date,v=a.document,w=0,x=0,y=ga(),z=ga(),A=ga(),B=function(a,b){return a===b&&(l=!0),0},C=1<<31,D={}.hasOwnProperty,E=[],F=E.pop,G=E.push,H=E.push,I=E.slice,J=function(a,b){for(var c=0,d=a.length;d>c;c++){if(a[c]===b){return c}}return -1},K="checked|selected|async|autofocus|autoplay|controls|defer|disabled|hidden|ismap|loop|multiple|open|readonly|required|scoped",L="[\\x20\\t\\r\\n\\f]",M="(?:\\\\.|[\\w-]|[^\\x00-\\xa0])+",N="\\["+L+"*("+M+")(?:"+L+"*([*^$|!~]?=)"+L+"*(?:'((?:\\\\.|[^\\\\'])*)'|\"((?:\\\\.|[^\\\\\"])*)\"|("+M+"))|)"+L+"*\\]",O=":("+M+")(?:\\((('((?:\\\\.|[^\\\\'])*)'|\"((?:\\\\.|[^\\\\\"])*)\")|((?:\\\\.|[^\\\\()[\\]]|"+N+")*)|.*)\\)|)",P=new RegExp(L+"+","g"),Q=new RegExp("^"+L+"+|((?:^|[^\\\\])(?:\\\\.)*)"+L+"+$","g"),R=new RegExp("^"+L+"*,"+L+"*"),S=new RegExp("^"+L+"*([>+~]|"+L+")"+L+"*"),T=new RegExp("="+L+"*([^\\]'\"]*?)"+L+"*\\]","g"),U=new RegExp(O),V=new RegExp("^"+M+"$"),W={ID:new RegExp("^#("+M+")"),CLASS:new RegExp("^\\.("+M+")"),TAG:new RegExp("^("+M+"|[*])"),ATTR:new RegExp("^"+N),PSEUDO:new RegExp("^"+O),CHILD:new RegExp("^:(only|first|last|nth|nth-last)-(child|of-type)(?:\\("+L+"*(even|odd|(([+-]|)(\\d*)n|)"+L+"*(?:([+-]|)"+L+"*(\\d+)|))"+L+"*\\)|)","i"),bool:new RegExp("^(?:"+K+")$","i"),needsContext:new RegExp("^"+L+"*[>+~]|:(even|odd|eq|gt|lt|nth|first|last)(?:\\("+L+"*((?:-\\d)?\\d*)"+L+"*\\)|)(?=[^-]|$)","i")},X=/^(?:input|select|textarea|button)$/i,Y=/^h\d$/i,Z=/^[^{]+\{\s*\[native \w/,$=/^(?:#([\w-]+)|(\w+)|\.([\w-]+))$/,_=/[+~]/,aa=/'|\\/g,ba=new RegExp("\\\\([\\da-f]{1,6}"+L+"?|("+L+")|.)","ig"),ca=function(a,b,c){var d="0x"+b-65536;
return d!==d||c?b:0>d?String.fromCharCode(d+65536):String.fromCharCode(d>>10|55296,1023&d|56320)},da=function(){m()};try{H.apply(E=I.call(v.childNodes),v.childNodes),E[v.childNodes.length].nodeType}catch(ea){H={apply:E.length?function(a,b){G.apply(a,I.call(b))}:function(a,b){var c=a.length,d=0;while(a[c++]=b[d++]){}a.length=c-1}}}function fa(a,b,d,e){var f,h,j,k,l,o,r,s,w=b&&b.ownerDocument,x=b?b.nodeType:9;if(d=d||[],"string"!=typeof a||!a||1!==x&&9!==x&&11!==x){return d}if(!e&&((b?b.ownerDocument||b:v)!==n&&m(b),b=b||n,p)){if(11!==x&&(o=$.exec(a))){if(f=o[1]){if(9===x){if(!(j=b.getElementById(f))){return d}if(j.id===f){return d.push(j),d}}else{if(w&&(j=w.getElementById(f))&&t(b,j)&&j.id===f){return d.push(j),d}}}else{if(o[2]){return H.apply(d,b.getElementsByTagName(a)),d}if((f=o[3])&&c.getElementsByClassName&&b.getElementsByClassName){return H.apply(d,b.getElementsByClassName(f)),d}}}if(c.qsa&&!A[a+" "]&&(!q||!q.test(a))){if(1!==x){w=b,s=a}else{if("object"!==b.nodeName.toLowerCase()){(k=b.getAttribute("id"))?k=k.replace(aa,"\\$&"):b.setAttribute("id",k=u),r=g(a),h=r.length,l=V.test(k)?"#"+k:"[id='"+k+"']";while(h--){r[h]=l+" "+qa(r[h])}s=r.join(","),w=_.test(a)&&oa(b.parentNode)||b}}if(s){try{return H.apply(d,w.querySelectorAll(s)),d}catch(y){}finally{k===u&&b.removeAttribute("id")}}}}return i(a.replace(Q,"$1"),b,d,e)}function ga(){var a=[];function b(c,e){return a.push(c+" ")>d.cacheLength&&delete b[a.shift()],b[c+" "]=e}return b}function ha(a){return a[u]=!0,a}function ia(a){var b=n.createElement("div");try{return !!a(b)}catch(c){return !1}finally{b.parentNode&&b.parentNode.removeChild(b),b=null}}function ja(a,b){var c=a.split("|"),e=c.length;while(e--){d.attrHandle[c[e]]=b}}function ka(a,b){var c=b&&a,d=c&&1===a.nodeType&&1===b.nodeType&&(~b.sourceIndex||C)-(~a.sourceIndex||C);if(d){return d}if(c){while(c=c.nextSibling){if(c===b){return -1}}}return a?1:-1}function la(a){return function(b){var c=b.nodeName.toLowerCase();return"input"===c&&b.type===a}}function ma(a){return function(b){var c=b.nodeName.toLowerCase();return("input"===c||"button"===c)&&b.type===a}}function na(a){return ha(function(b){return b=+b,ha(function(c,d){var e,f=a([],c.length,b),g=f.length;while(g--){c[e=f[g]]&&(c[e]=!(d[e]=c[e]))}})})}function oa(a){return a&&"undefined"!=typeof a.getElementsByTagName&&a}c=fa.support={},f=fa.isXML=function(a){var b=a&&(a.ownerDocument||a).documentElement;return b?"HTML"!==b.nodeName:!1},m=fa.setDocument=function(a){var b,e,g=a?a.ownerDocument||a:v;return g!==n&&9===g.nodeType&&g.documentElement?(n=g,o=n.documentElement,p=!f(n),(e=n.defaultView)&&e.top!==e&&(e.addEventListener?e.addEventListener("unload",da,!1):e.attachEvent&&e.attachEvent("onunload",da)),c.attributes=ia(function(a){return a.className="i",!a.getAttribute("className")}),c.getElementsByTagName=ia(function(a){return a.appendChild(n.createComment("")),!a.getElementsByTagName("*").length}),c.getElementsByClassName=Z.test(n.getElementsByClassName),c.getById=ia(function(a){return o.appendChild(a).id=u,!n.getElementsByName||!n.getElementsByName(u).length}),c.getById?(d.find.ID=function(a,b){if("undefined"!=typeof b.getElementById&&p){var c=b.getElementById(a);return c?[c]:[]}},d.filter.ID=function(a){var b=a.replace(ba,ca);return function(a){return a.getAttribute("id")===b}}):(delete d.find.ID,d.filter.ID=function(a){var b=a.replace(ba,ca);return function(a){var c="undefined"!=typeof a.getAttributeNode&&a.getAttributeNode("id");return c&&c.value===b}}),d.find.TAG=c.getElementsByTagName?function(a,b){return"undefined"!=typeof b.getElementsByTagName?b.getElementsByTagName(a):c.qsa?b.querySelectorAll(a):void 0}:function(a,b){var c,d=[],e=0,f=b.getElementsByTagName(a);if("*"===a){while(c=f[e++]){1===c.nodeType&&d.push(c)}return d}return f},d.find.CLASS=c.getElementsByClassName&&function(a,b){return"undefined"!=typeof b.getElementsByClassName&&p?b.getElementsByClassName(a):void 0},r=[],q=[],(c.qsa=Z.test(n.querySelectorAll))&&(ia(function(a){o.appendChild(a).innerHTML="<a id='"+u+"'></a><select id='"+u+"-\r\\' msallowcapture=''><option selected=''></option></select>",a.querySelectorAll("[msallowcapture^='']").length&&q.push("[*^$]="+L+"*(?:''|\"\")"),a.querySelectorAll("[selected]").length||q.push("\\["+L+"*(?:value|"+K+")"),a.querySelectorAll("[id~="+u+"-]").length||q.push("~="),a.querySelectorAll(":checked").length||q.push(":checked"),a.querySelectorAll("a#"+u+"+*").length||q.push(".#.+[+~]")}),ia(function(a){var b=n.createElement("input");b.setAttribute("type","hidden"),a.appendChild(b).setAttribute("name","D"),a.querySelectorAll("[name=d]").length&&q.push("name"+L+"*[*^$|!~]?="),a.querySelectorAll(":enabled").length||q.push(":enabled",":disabled"),a.querySelectorAll("*,:x"),q.push(",.*:")})),(c.matchesSelector=Z.test(s=o.matches||o.webkitMatchesSelector||o.mozMatchesSelector||o.oMatchesSelector||o.msMatchesSelector))&&ia(function(a){c.disconnectedMatch=s.call(a,"div"),s.call(a,"[s!='']:x"),r.push("!=",O)}),q=q.length&&new RegExp(q.join("|")),r=r.length&&new RegExp(r.join("|")),b=Z.test(o.compareDocumentPosition),t=b||Z.test(o.contains)?function(a,b){var c=9===a.nodeType?a.documentElement:a,d=b&&b.parentNode;
return a===d||!(!d||1!==d.nodeType||!(c.contains?c.contains(d):a.compareDocumentPosition&&16&a.compareDocumentPosition(d)))}:function(a,b){if(b){while(b=b.parentNode){if(b===a){return !0}}}return !1},B=b?function(a,b){if(a===b){return l=!0,0}var d=!a.compareDocumentPosition-!b.compareDocumentPosition;return d?d:(d=(a.ownerDocument||a)===(b.ownerDocument||b)?a.compareDocumentPosition(b):1,1&d||!c.sortDetached&&b.compareDocumentPosition(a)===d?a===n||a.ownerDocument===v&&t(v,a)?-1:b===n||b.ownerDocument===v&&t(v,b)?1:k?J(k,a)-J(k,b):0:4&d?-1:1)}:function(a,b){if(a===b){return l=!0,0}var c,d=0,e=a.parentNode,f=b.parentNode,g=[a],h=[b];if(!e||!f){return a===n?-1:b===n?1:e?-1:f?1:k?J(k,a)-J(k,b):0}if(e===f){return ka(a,b)}c=a;while(c=c.parentNode){g.unshift(c)}c=b;while(c=c.parentNode){h.unshift(c)}while(g[d]===h[d]){d++}return d?ka(g[d],h[d]):g[d]===v?-1:h[d]===v?1:0},n):n},fa.matches=function(a,b){return fa(a,null,null,b)},fa.matchesSelector=function(a,b){if((a.ownerDocument||a)!==n&&m(a),b=b.replace(T,"='$1']"),c.matchesSelector&&p&&!A[b+" "]&&(!r||!r.test(b))&&(!q||!q.test(b))){try{var d=s.call(a,b);if(d||c.disconnectedMatch||a.document&&11!==a.document.nodeType){return d}}catch(e){}}return fa(b,n,null,[a]).length>0},fa.contains=function(a,b){return(a.ownerDocument||a)!==n&&m(a),t(a,b)},fa.attr=function(a,b){(a.ownerDocument||a)!==n&&m(a);var e=d.attrHandle[b.toLowerCase()],f=e&&D.call(d.attrHandle,b.toLowerCase())?e(a,b,!p):void 0;return void 0!==f?f:c.attributes||!p?a.getAttribute(b):(f=a.getAttributeNode(b))&&f.specified?f.value:null},fa.error=function(a){throw new Error("Syntax error, unrecognized expression: "+a)},fa.uniqueSort=function(a){var b,d=[],e=0,f=0;if(l=!c.detectDuplicates,k=!c.sortStable&&a.slice(0),a.sort(B),l){while(b=a[f++]){b===a[f]&&(e=d.push(f))}while(e--){a.splice(d[e],1)}}return k=null,a},e=fa.getText=function(a){var b,c="",d=0,f=a.nodeType;if(f){if(1===f||9===f||11===f){if("string"==typeof a.textContent){return a.textContent}for(a=a.firstChild;a;a=a.nextSibling){c+=e(a)}}else{if(3===f||4===f){return a.nodeValue}}}else{while(b=a[d++]){c+=e(b)}}return c},d=fa.selectors={cacheLength:50,createPseudo:ha,match:W,attrHandle:{},find:{},relative:{">":{dir:"parentNode",first:!0}," ":{dir:"parentNode"},"+":{dir:"previousSibling",first:!0},"~":{dir:"previousSibling"}},preFilter:{ATTR:function(a){return a[1]=a[1].replace(ba,ca),a[3]=(a[3]||a[4]||a[5]||"").replace(ba,ca),"~="===a[2]&&(a[3]=" "+a[3]+" "),a.slice(0,4)},CHILD:function(a){return a[1]=a[1].toLowerCase(),"nth"===a[1].slice(0,3)?(a[3]||fa.error(a[0]),a[4]=+(a[4]?a[5]+(a[6]||1):2*("even"===a[3]||"odd"===a[3])),a[5]=+(a[7]+a[8]||"odd"===a[3])):a[3]&&fa.error(a[0]),a},PSEUDO:function(a){var b,c=!a[6]&&a[2];return W.CHILD.test(a[0])?null:(a[3]?a[2]=a[4]||a[5]||"":c&&U.test(c)&&(b=g(c,!0))&&(b=c.indexOf(")",c.length-b)-c.length)&&(a[0]=a[0].slice(0,b),a[2]=c.slice(0,b)),a.slice(0,3))}},filter:{TAG:function(a){var b=a.replace(ba,ca).toLowerCase();return"*"===a?function(){return !0}:function(a){return a.nodeName&&a.nodeName.toLowerCase()===b}},CLASS:function(a){var b=y[a+" "];return b||(b=new RegExp("(^|"+L+")"+a+"("+L+"|$)"))&&y(a,function(a){return b.test("string"==typeof a.className&&a.className||"undefined"!=typeof a.getAttribute&&a.getAttribute("class")||"")})},ATTR:function(a,b,c){return function(d){var e=fa.attr(d,a);return null==e?"!="===b:b?(e+="","="===b?e===c:"!="===b?e!==c:"^="===b?c&&0===e.indexOf(c):"*="===b?c&&e.indexOf(c)>-1:"$="===b?c&&e.slice(-c.length)===c:"~="===b?(" "+e.replace(P," ")+" ").indexOf(c)>-1:"|="===b?e===c||e.slice(0,c.length+1)===c+"-":!1):!0}},CHILD:function(a,b,c,d,e){var f="nth"!==a.slice(0,3),g="last"!==a.slice(-4),h="of-type"===b;return 1===d&&0===e?function(a){return !!a.parentNode}:function(b,c,i){var j,k,l,m,n,o,p=f!==g?"nextSibling":"previousSibling",q=b.parentNode,r=h&&b.nodeName.toLowerCase(),s=!i&&!h,t=!1;if(q){if(f){while(p){m=b;while(m=m[p]){if(h?m.nodeName.toLowerCase()===r:1===m.nodeType){return !1}}o=p="only"===a&&!o&&"nextSibling"}return !0}if(o=[g?q.firstChild:q.lastChild],g&&s){m=q,l=m[u]||(m[u]={}),k=l[m.uniqueID]||(l[m.uniqueID]={}),j=k[a]||[],n=j[0]===w&&j[1],t=n&&j[2],m=n&&q.childNodes[n];while(m=++n&&m&&m[p]||(t=n=0)||o.pop()){if(1===m.nodeType&&++t&&m===b){k[a]=[w,n,t];break}}}else{if(s&&(m=b,l=m[u]||(m[u]={}),k=l[m.uniqueID]||(l[m.uniqueID]={}),j=k[a]||[],n=j[0]===w&&j[1],t=n),t===!1){while(m=++n&&m&&m[p]||(t=n=0)||o.pop()){if((h?m.nodeName.toLowerCase()===r:1===m.nodeType)&&++t&&(s&&(l=m[u]||(m[u]={}),k=l[m.uniqueID]||(l[m.uniqueID]={}),k[a]=[w,t]),m===b)){break}}}}return t-=e,t===d||t%d===0&&t/d>=0}}},PSEUDO:function(a,b){var c,e=d.pseudos[a]||d.setFilters[a.toLowerCase()]||fa.error("unsupported pseudo: "+a);return e[u]?e(b):e.length>1?(c=[a,a,"",b],d.setFilters.hasOwnProperty(a.toLowerCase())?ha(function(a,c){var d,f=e(a,b),g=f.length;while(g--){d=J(a,f[g]),a[d]=!(c[d]=f[g])}}):function(a){return e(a,0,c)}):e}},pseudos:{not:ha(function(a){var b=[],c=[],d=h(a.replace(Q,"$1"));return d[u]?ha(function(a,b,c,e){var f,g=d(a,null,e,[]),h=a.length;
while(h--){(f=g[h])&&(a[h]=!(b[h]=f))}}):function(a,e,f){return b[0]=a,d(b,null,f,c),b[0]=null,!c.pop()}}),has:ha(function(a){return function(b){return fa(a,b).length>0}}),contains:ha(function(a){return a=a.replace(ba,ca),function(b){return(b.textContent||b.innerText||e(b)).indexOf(a)>-1}}),lang:ha(function(a){return V.test(a||"")||fa.error("unsupported lang: "+a),a=a.replace(ba,ca).toLowerCase(),function(b){var c;do{if(c=p?b.lang:b.getAttribute("xml:lang")||b.getAttribute("lang")){return c=c.toLowerCase(),c===a||0===c.indexOf(a+"-")}}while((b=b.parentNode)&&1===b.nodeType);return !1}}),target:function(b){var c=a.location&&a.location.hash;return c&&c.slice(1)===b.id},root:function(a){return a===o},focus:function(a){return a===n.activeElement&&(!n.hasFocus||n.hasFocus())&&!!(a.type||a.href||~a.tabIndex)},enabled:function(a){return a.disabled===!1},disabled:function(a){return a.disabled===!0},checked:function(a){var b=a.nodeName.toLowerCase();return"input"===b&&!!a.checked||"option"===b&&!!a.selected},selected:function(a){return a.parentNode&&a.parentNode.selectedIndex,a.selected===!0},empty:function(a){for(a=a.firstChild;a;a=a.nextSibling){if(a.nodeType<6){return !1}}return !0},parent:function(a){return !d.pseudos.empty(a)},header:function(a){return Y.test(a.nodeName)},input:function(a){return X.test(a.nodeName)},button:function(a){var b=a.nodeName.toLowerCase();return"input"===b&&"button"===a.type||"button"===b},text:function(a){var b;return"input"===a.nodeName.toLowerCase()&&"text"===a.type&&(null==(b=a.getAttribute("type"))||"text"===b.toLowerCase())},first:na(function(){return[0]}),last:na(function(a,b){return[b-1]}),eq:na(function(a,b,c){return[0>c?c+b:c]}),even:na(function(a,b){for(var c=0;b>c;c+=2){a.push(c)}return a}),odd:na(function(a,b){for(var c=1;b>c;c+=2){a.push(c)}return a}),lt:na(function(a,b,c){for(var d=0>c?c+b:c;--d>=0;){a.push(d)}return a}),gt:na(function(a,b,c){for(var d=0>c?c+b:c;++d<b;){a.push(d)}return a})}},d.pseudos.nth=d.pseudos.eq;for(b in {radio:!0,checkbox:!0,file:!0,password:!0,image:!0}){d.pseudos[b]=la(b)}for(b in {submit:!0,reset:!0}){d.pseudos[b]=ma(b)}function pa(){}pa.prototype=d.filters=d.pseudos,d.setFilters=new pa,g=fa.tokenize=function(a,b){var c,e,f,g,h,i,j,k=z[a+" "];if(k){return b?0:k.slice(0)}h=a,i=[],j=d.preFilter;while(h){c&&!(e=R.exec(h))||(e&&(h=h.slice(e[0].length)||h),i.push(f=[])),c=!1,(e=S.exec(h))&&(c=e.shift(),f.push({value:c,type:e[0].replace(Q," ")}),h=h.slice(c.length));for(g in d.filter){!(e=W[g].exec(h))||j[g]&&!(e=j[g](e))||(c=e.shift(),f.push({value:c,type:g,matches:e}),h=h.slice(c.length))}if(!c){break}}return b?h.length:h?fa.error(a):z(a,i).slice(0)};function qa(a){for(var b=0,c=a.length,d="";c>b;b++){d+=a[b].value}return d}function ra(a,b,c){var d=b.dir,e=c&&"parentNode"===d,f=x++;return b.first?function(b,c,f){while(b=b[d]){if(1===b.nodeType||e){return a(b,c,f)}}}:function(b,c,g){var h,i,j,k=[w,f];if(g){while(b=b[d]){if((1===b.nodeType||e)&&a(b,c,g)){return !0}}}else{while(b=b[d]){if(1===b.nodeType||e){if(j=b[u]||(b[u]={}),i=j[b.uniqueID]||(j[b.uniqueID]={}),(h=i[d])&&h[0]===w&&h[1]===f){return k[2]=h[2]}if(i[d]=k,k[2]=a(b,c,g)){return !0}}}}}}function sa(a){return a.length>1?function(b,c,d){var e=a.length;while(e--){if(!a[e](b,c,d)){return !1}}return !0}:a[0]}function ta(a,b,c){for(var d=0,e=b.length;e>d;d++){fa(a,b[d],c)}return c}function ua(a,b,c,d,e){for(var f,g=[],h=0,i=a.length,j=null!=b;i>h;h++){(f=a[h])&&(c&&!c(f,d,e)||(g.push(f),j&&b.push(h)))}return g}function va(a,b,c,d,e,f){return d&&!d[u]&&(d=va(d)),e&&!e[u]&&(e=va(e,f)),ha(function(f,g,h,i){var j,k,l,m=[],n=[],o=g.length,p=f||ta(b||"*",h.nodeType?[h]:h,[]),q=!a||!f&&b?p:ua(p,m,a,h,i),r=c?e||(f?a:o||d)?[]:g:q;if(c&&c(q,r,h,i),d){j=ua(r,n),d(j,[],h,i),k=j.length;while(k--){(l=j[k])&&(r[n[k]]=!(q[n[k]]=l))}}if(f){if(e||a){if(e){j=[],k=r.length;while(k--){(l=r[k])&&j.push(q[k]=l)}e(null,r=[],j,i)}k=r.length;while(k--){(l=r[k])&&(j=e?J(f,l):m[k])>-1&&(f[j]=!(g[j]=l))}}}else{r=ua(r===g?r.splice(o,r.length):r),e?e(null,g,r,i):H.apply(g,r)}})}function wa(a){for(var b,c,e,f=a.length,g=d.relative[a[0].type],h=g||d.relative[" "],i=g?1:0,k=ra(function(a){return a===b},h,!0),l=ra(function(a){return J(b,a)>-1},h,!0),m=[function(a,c,d){var e=!g&&(d||c!==j)||((b=c).nodeType?k(a,c,d):l(a,c,d));return b=null,e}];f>i;i++){if(c=d.relative[a[i].type]){m=[ra(sa(m),c)]}else{if(c=d.filter[a[i].type].apply(null,a[i].matches),c[u]){for(e=++i;f>e;e++){if(d.relative[a[e].type]){break}}return va(i>1&&sa(m),i>1&&qa(a.slice(0,i-1).concat({value:" "===a[i-2].type?"*":""})).replace(Q,"$1"),c,e>i&&wa(a.slice(i,e)),f>e&&wa(a=a.slice(e)),f>e&&qa(a))}m.push(c)}}return sa(m)}function xa(a,b){var c=b.length>0,e=a.length>0,f=function(f,g,h,i,k){var l,o,q,r=0,s="0",t=f&&[],u=[],v=j,x=f||e&&d.find.TAG("*",k),y=w+=null==v?1:Math.random()||0.1,z=x.length;for(k&&(j=g===n||g||k);s!==z&&null!=(l=x[s]);s++){if(e&&l){o=0,g||l.ownerDocument===n||(m(l),h=!p);while(q=a[o++]){if(q(l,g||n,h)){i.push(l);break}}k&&(w=y)}c&&((l=!q&&l)&&r--,f&&t.push(l))
}if(r+=s,c&&s!==r){o=0;while(q=b[o++]){q(t,u,g,h)}if(f){if(r>0){while(s--){t[s]||u[s]||(u[s]=F.call(i))}}u=ua(u)}H.apply(i,u),k&&!f&&u.length>0&&r+b.length>1&&fa.uniqueSort(i)}return k&&(w=y,j=v),t};return c?ha(f):f}return h=fa.compile=function(a,b){var c,d=[],e=[],f=A[a+" "];if(!f){b||(b=g(a)),c=b.length;while(c--){f=wa(b[c]),f[u]?d.push(f):e.push(f)}f=A(a,xa(e,d)),f.selector=a}return f},i=fa.select=function(a,b,e,f){var i,j,k,l,m,n="function"==typeof a&&a,o=!f&&g(a=n.selector||a);if(e=e||[],1===o.length){if(j=o[0]=o[0].slice(0),j.length>2&&"ID"===(k=j[0]).type&&c.getById&&9===b.nodeType&&p&&d.relative[j[1].type]){if(b=(d.find.ID(k.matches[0].replace(ba,ca),b)||[])[0],!b){return e}n&&(b=b.parentNode),a=a.slice(j.shift().value.length)}i=W.needsContext.test(a)?0:j.length;while(i--){if(k=j[i],d.relative[l=k.type]){break}if((m=d.find[l])&&(f=m(k.matches[0].replace(ba,ca),_.test(j[0].type)&&oa(b.parentNode)||b))){if(j.splice(i,1),a=f.length&&qa(j),!a){return H.apply(e,f),e}break}}}return(n||h(a,o))(f,b,!p,e,!b||_.test(a)&&oa(b.parentNode)||b),e},c.sortStable=u.split("").sort(B).join("")===u,c.detectDuplicates=!!l,m(),c.sortDetached=ia(function(a){return 1&a.compareDocumentPosition(n.createElement("div"))}),ia(function(a){return a.innerHTML="<a href='#'></a>","#"===a.firstChild.getAttribute("href")})||ja("type|href|height|width",function(a,b,c){return c?void 0:a.getAttribute(b,"type"===b.toLowerCase()?1:2)}),c.attributes&&ia(function(a){return a.innerHTML="<input/>",a.firstChild.setAttribute("value",""),""===a.firstChild.getAttribute("value")})||ja("value",function(a,b,c){return c||"input"!==a.nodeName.toLowerCase()?void 0:a.defaultValue}),ia(function(a){return null==a.getAttribute("disabled")})||ja(K,function(a,b,c){var d;return c?void 0:a[b]===!0?b.toLowerCase():(d=a.getAttributeNode(b))&&d.specified?d.value:null}),fa}(a);n.find=t,n.expr=t.selectors,n.expr[":"]=n.expr.pseudos,n.uniqueSort=n.unique=t.uniqueSort,n.text=t.getText,n.isXMLDoc=t.isXML,n.contains=t.contains;var u=function(a,b,c){var d=[],e=void 0!==c;while((a=a[b])&&9!==a.nodeType){if(1===a.nodeType){if(e&&n(a).is(c)){break}d.push(a)}}return d},v=function(a,b){for(var c=[];a;a=a.nextSibling){1===a.nodeType&&a!==b&&c.push(a)}return c},w=n.expr.match.needsContext,x=/^<([\w-]+)\s*\/?>(?:<\/\1>|)$/,y=/^.[^:#\[\.,]*$/;function z(a,b,c){if(n.isFunction(b)){return n.grep(a,function(a,d){return !!b.call(a,d,a)!==c})}if(b.nodeType){return n.grep(a,function(a){return a===b!==c})}if("string"==typeof b){if(y.test(b)){return n.filter(b,a,c)}b=n.filter(b,a)}return n.grep(a,function(a){return n.inArray(a,b)>-1!==c})}n.filter=function(a,b,c){var d=b[0];return c&&(a=":not("+a+")"),1===b.length&&1===d.nodeType?n.find.matchesSelector(d,a)?[d]:[]:n.find.matches(a,n.grep(b,function(a){return 1===a.nodeType}))},n.fn.extend({find:function(a){var b,c=[],d=this,e=d.length;if("string"!=typeof a){return this.pushStack(n(a).filter(function(){for(b=0;e>b;b++){if(n.contains(d[b],this)){return !0}}}))}for(b=0;e>b;b++){n.find(a,d[b],c)}return c=this.pushStack(e>1?n.unique(c):c),c.selector=this.selector?this.selector+" "+a:a,c},filter:function(a){return this.pushStack(z(this,a||[],!1))},not:function(a){return this.pushStack(z(this,a||[],!0))},is:function(a){return !!z(this,"string"==typeof a&&w.test(a)?n(a):a||[],!1).length}});var A,B=/^(?:\s*(<[\w\W]+>)[^>]*|#([\w-]*))$/,C=n.fn.init=function(a,b,c){var e,f;if(!a){return this}if(c=c||A,"string"==typeof a){if(e="<"===a.charAt(0)&&">"===a.charAt(a.length-1)&&a.length>=3?[null,a,null]:B.exec(a),!e||!e[1]&&b){return !b||b.jquery?(b||c).find(a):this.constructor(b).find(a)}if(e[1]){if(b=b instanceof n?b[0]:b,n.merge(this,n.parseHTML(e[1],b&&b.nodeType?b.ownerDocument||b:d,!0)),x.test(e[1])&&n.isPlainObject(b)){for(e in b){n.isFunction(this[e])?this[e](b[e]):this.attr(e,b[e])}}return this}if(f=d.getElementById(e[2]),f&&f.parentNode){if(f.id!==e[2]){return A.find(a)}this.length=1,this[0]=f}return this.context=d,this.selector=a,this}return a.nodeType?(this.context=this[0]=a,this.length=1,this):n.isFunction(a)?"undefined"!=typeof c.ready?c.ready(a):a(n):(void 0!==a.selector&&(this.selector=a.selector,this.context=a.context),n.makeArray(a,this))};C.prototype=n.fn,A=n(d);var D=/^(?:parents|prev(?:Until|All))/,E={children:!0,contents:!0,next:!0,prev:!0};n.fn.extend({has:function(a){var b,c=n(a,this),d=c.length;return this.filter(function(){for(b=0;d>b;b++){if(n.contains(this,c[b])){return !0}}})},closest:function(a,b){for(var c,d=0,e=this.length,f=[],g=w.test(a)||"string"!=typeof a?n(a,b||this.context):0;e>d;d++){for(c=this[d];c&&c!==b;c=c.parentNode){if(c.nodeType<11&&(g?g.index(c)>-1:1===c.nodeType&&n.find.matchesSelector(c,a))){f.push(c);break}}}return this.pushStack(f.length>1?n.uniqueSort(f):f)},index:function(a){return a?"string"==typeof a?n.inArray(this[0],n(a)):n.inArray(a.jquery?a[0]:a,this):this[0]&&this[0].parentNode?this.first().prevAll().length:-1},add:function(a,b){return this.pushStack(n.uniqueSort(n.merge(this.get(),n(a,b))))},addBack:function(a){return this.add(null==a?this.prevObject:this.prevObject.filter(a))
}});function F(a,b){do{a=a[b]}while(a&&1!==a.nodeType);return a}n.each({parent:function(a){var b=a.parentNode;return b&&11!==b.nodeType?b:null},parents:function(a){return u(a,"parentNode")},parentsUntil:function(a,b,c){return u(a,"parentNode",c)},next:function(a){return F(a,"nextSibling")},prev:function(a){return F(a,"previousSibling")},nextAll:function(a){return u(a,"nextSibling")},prevAll:function(a){return u(a,"previousSibling")},nextUntil:function(a,b,c){return u(a,"nextSibling",c)},prevUntil:function(a,b,c){return u(a,"previousSibling",c)},siblings:function(a){return v((a.parentNode||{}).firstChild,a)},children:function(a){return v(a.firstChild)},contents:function(a){return n.nodeName(a,"iframe")?a.contentDocument||a.contentWindow.document:n.merge([],a.childNodes)}},function(a,b){n.fn[a]=function(c,d){var e=n.map(this,b,c);return"Until"!==a.slice(-5)&&(d=c),d&&"string"==typeof d&&(e=n.filter(d,e)),this.length>1&&(E[a]||(e=n.uniqueSort(e)),D.test(a)&&(e=e.reverse())),this.pushStack(e)}});var G=/\S+/g;function H(a){var b={};return n.each(a.match(G)||[],function(a,c){b[c]=!0}),b}n.Callbacks=function(a){a="string"==typeof a?H(a):n.extend({},a);var b,c,d,e,f=[],g=[],h=-1,i=function(){for(e=a.once,d=b=!0;g.length;h=-1){c=g.shift();while(++h<f.length){f[h].apply(c[0],c[1])===!1&&a.stopOnFalse&&(h=f.length,c=!1)}}a.memory||(c=!1),b=!1,e&&(f=c?[]:"")},j={add:function(){return f&&(c&&!b&&(h=f.length-1,g.push(c)),function d(b){n.each(b,function(b,c){n.isFunction(c)?a.unique&&j.has(c)||f.push(c):c&&c.length&&"string"!==n.type(c)&&d(c)})}(arguments),c&&!b&&i()),this},remove:function(){return n.each(arguments,function(a,b){var c;while((c=n.inArray(b,f,c))>-1){f.splice(c,1),h>=c&&h--}}),this},has:function(a){return a?n.inArray(a,f)>-1:f.length>0},empty:function(){return f&&(f=[]),this},disable:function(){return e=g=[],f=c="",this},disabled:function(){return !f},lock:function(){return e=!0,c||j.disable(),this},locked:function(){return !!e},fireWith:function(a,c){return e||(c=c||[],c=[a,c.slice?c.slice():c],g.push(c),b||i()),this},fire:function(){return j.fireWith(this,arguments),this},fired:function(){return !!d}};return j},n.extend({Deferred:function(a){var b=[["resolve","done",n.Callbacks("once memory"),"resolved"],["reject","fail",n.Callbacks("once memory"),"rejected"],["notify","progress",n.Callbacks("memory")]],c="pending",d={state:function(){return c},always:function(){return e.done(arguments).fail(arguments),this},then:function(){var a=arguments;return n.Deferred(function(c){n.each(b,function(b,f){var g=n.isFunction(a[b])&&a[b];e[f[1]](function(){var a=g&&g.apply(this,arguments);a&&n.isFunction(a.promise)?a.promise().progress(c.notify).done(c.resolve).fail(c.reject):c[f[0]+"With"](this===d?c.promise():this,g?[a]:arguments)})}),a=null}).promise()},promise:function(a){return null!=a?n.extend(a,d):d}},e={};return d.pipe=d.then,n.each(b,function(a,f){var g=f[2],h=f[3];d[f[1]]=g.add,h&&g.add(function(){c=h},b[1^a][2].disable,b[2][2].lock),e[f[0]]=function(){return e[f[0]+"With"](this===e?d:this,arguments),this},e[f[0]+"With"]=g.fireWith}),d.promise(e),a&&a.call(e,e),e},when:function(a){var b=0,c=e.call(arguments),d=c.length,f=1!==d||a&&n.isFunction(a.promise)?d:0,g=1===f?a:n.Deferred(),h=function(a,b,c){return function(d){b[a]=this,c[a]=arguments.length>1?e.call(arguments):d,c===i?g.notifyWith(b,c):--f||g.resolveWith(b,c)}},i,j,k;if(d>1){for(i=new Array(d),j=new Array(d),k=new Array(d);d>b;b++){c[b]&&n.isFunction(c[b].promise)?c[b].promise().progress(h(b,j,i)).done(h(b,k,c)).fail(g.reject):--f}}return f||g.resolveWith(k,c),g.promise()}});var I;n.fn.ready=function(a){return n.ready.promise().done(a),this},n.extend({isReady:!1,readyWait:1,holdReady:function(a){a?n.readyWait++:n.ready(!0)},ready:function(a){(a===!0?--n.readyWait:n.isReady)||(n.isReady=!0,a!==!0&&--n.readyWait>0||(I.resolveWith(d,[n]),n.fn.triggerHandler&&(n(d).triggerHandler("ready"),n(d).off("ready"))))}});function J(){d.addEventListener?(d.removeEventListener("DOMContentLoaded",K),a.removeEventListener("load",K)):(d.detachEvent("onreadystatechange",K),a.detachEvent("onload",K))}function K(){(d.addEventListener||"load"===a.event.type||"complete"===d.readyState)&&(J(),n.ready())}n.ready.promise=function(b){if(!I){if(I=n.Deferred(),"complete"===d.readyState||"loading"!==d.readyState&&!d.documentElement.doScroll){a.setTimeout(n.ready)}else{if(d.addEventListener){d.addEventListener("DOMContentLoaded",K),a.addEventListener("load",K)}else{d.attachEvent("onreadystatechange",K),a.attachEvent("onload",K);var c=!1;try{c=null==a.frameElement&&d.documentElement}catch(e){}c&&c.doScroll&&!function f(){if(!n.isReady){try{c.doScroll("left")}catch(b){return a.setTimeout(f,50)}J(),n.ready()}}()}}}return I.promise(b)},n.ready.promise();var L;for(L in n(l)){break}l.ownFirst="0"===L,l.inlineBlockNeedsLayout=!1,n(function(){var a,b,c,e;c=d.getElementsByTagName("body")[0],c&&c.style&&(b=d.createElement("div"),e=d.createElement("div"),e.style.cssText="position:absolute;border:0;width:0;height:0;top:0;left:-9999px",c.appendChild(e).appendChild(b),"undefined"!=typeof b.style.zoom&&(b.style.cssText="display:inline;margin:0;border:0;padding:1px;width:1px;zoom:1",l.inlineBlockNeedsLayout=a=3===b.offsetWidth,a&&(c.style.zoom=1)),c.removeChild(e))
}),function(){var a=d.createElement("div");l.deleteExpando=!0;try{delete a.test}catch(b){l.deleteExpando=!1}a=null}();var M=function(a){var b=n.noData[(a.nodeName+" ").toLowerCase()],c=+a.nodeType||1;return 1!==c&&9!==c?!1:!b||b!==!0&&a.getAttribute("classid")===b},N=/^(?:\{[\w\W]*\}|\[[\w\W]*\])$/,O=/([A-Z])/g;function P(a,b,c){if(void 0===c&&1===a.nodeType){var d="data-"+b.replace(O,"-$1").toLowerCase();if(c=a.getAttribute(d),"string"==typeof c){try{c="true"===c?!0:"false"===c?!1:"null"===c?null:+c+""===c?+c:N.test(c)?n.parseJSON(c):c}catch(e){}n.data(a,b,c)}else{c=void 0}}return c}function Q(a){var b;for(b in a){if(("data"!==b||!n.isEmptyObject(a[b]))&&"toJSON"!==b){return !1}}return !0}function R(a,b,d,e){if(M(a)){var f,g,h=n.expando,i=a.nodeType,j=i?n.cache:a,k=i?a[h]:a[h]&&h;if(k&&j[k]&&(e||j[k].data)||void 0!==d||"string"!=typeof b){return k||(k=i?a[h]=c.pop()||n.guid++:h),j[k]||(j[k]=i?{}:{toJSON:n.noop}),"object"!=typeof b&&"function"!=typeof b||(e?j[k]=n.extend(j[k],b):j[k].data=n.extend(j[k].data,b)),g=j[k],e||(g.data||(g.data={}),g=g.data),void 0!==d&&(g[n.camelCase(b)]=d),"string"==typeof b?(f=g[b],null==f&&(f=g[n.camelCase(b)])):f=g,f}}}function S(a,b,c){if(M(a)){var d,e,f=a.nodeType,g=f?n.cache:a,h=f?a[n.expando]:n.expando;if(g[h]){if(b&&(d=c?g[h]:g[h].data)){n.isArray(b)?b=b.concat(n.map(b,n.camelCase)):b in d?b=[b]:(b=n.camelCase(b),b=b in d?[b]:b.split(" ")),e=b.length;while(e--){delete d[b[e]]}if(c?!Q(d):!n.isEmptyObject(d)){return}}(c||(delete g[h].data,Q(g[h])))&&(f?n.cleanData([a],!0):l.deleteExpando||g!=g.window?delete g[h]:g[h]=void 0)}}}n.extend({cache:{},noData:{"applet ":!0,"embed ":!0,"object ":"clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"},hasData:function(a){return a=a.nodeType?n.cache[a[n.expando]]:a[n.expando],!!a&&!Q(a)},data:function(a,b,c){return R(a,b,c)},removeData:function(a,b){return S(a,b)},_data:function(a,b,c){return R(a,b,c,!0)},_removeData:function(a,b){return S(a,b,!0)}}),n.fn.extend({data:function(a,b){var c,d,e,f=this[0],g=f&&f.attributes;if(void 0===a){if(this.length&&(e=n.data(f),1===f.nodeType&&!n._data(f,"parsedAttrs"))){c=g.length;while(c--){g[c]&&(d=g[c].name,0===d.indexOf("data-")&&(d=n.camelCase(d.slice(5)),P(f,d,e[d])))}n._data(f,"parsedAttrs",!0)}return e}return"object"==typeof a?this.each(function(){n.data(this,a)}):arguments.length>1?this.each(function(){n.data(this,a,b)}):f?P(f,a,n.data(f,a)):void 0},removeData:function(a){return this.each(function(){n.removeData(this,a)})}}),n.extend({queue:function(a,b,c){var d;return a?(b=(b||"fx")+"queue",d=n._data(a,b),c&&(!d||n.isArray(c)?d=n._data(a,b,n.makeArray(c)):d.push(c)),d||[]):void 0},dequeue:function(a,b){b=b||"fx";var c=n.queue(a,b),d=c.length,e=c.shift(),f=n._queueHooks(a,b),g=function(){n.dequeue(a,b)};"inprogress"===e&&(e=c.shift(),d--),e&&("fx"===b&&c.unshift("inprogress"),delete f.stop,e.call(a,g,f)),!d&&f&&f.empty.fire()},_queueHooks:function(a,b){var c=b+"queueHooks";return n._data(a,c)||n._data(a,c,{empty:n.Callbacks("once memory").add(function(){n._removeData(a,b+"queue"),n._removeData(a,c)})})}}),n.fn.extend({queue:function(a,b){var c=2;return"string"!=typeof a&&(b=a,a="fx",c--),arguments.length<c?n.queue(this[0],a):void 0===b?this:this.each(function(){var c=n.queue(this,a,b);n._queueHooks(this,a),"fx"===a&&"inprogress"!==c[0]&&n.dequeue(this,a)})},dequeue:function(a){return this.each(function(){n.dequeue(this,a)})},clearQueue:function(a){return this.queue(a||"fx",[])},promise:function(a,b){var c,d=1,e=n.Deferred(),f=this,g=this.length,h=function(){--d||e.resolveWith(f,[f])};"string"!=typeof a&&(b=a,a=void 0),a=a||"fx";while(g--){c=n._data(f[g],a+"queueHooks"),c&&c.empty&&(d++,c.empty.add(h))}return h(),e.promise(b)}}),function(){var a;l.shrinkWrapBlocks=function(){if(null!=a){return a}a=!1;var b,c,e;return c=d.getElementsByTagName("body")[0],c&&c.style?(b=d.createElement("div"),e=d.createElement("div"),e.style.cssText="position:absolute;border:0;width:0;height:0;top:0;left:-9999px",c.appendChild(e).appendChild(b),"undefined"!=typeof b.style.zoom&&(b.style.cssText="-webkit-box-sizing:content-box;-moz-box-sizing:content-box;box-sizing:content-box;display:block;margin:0;border:0;padding:1px;width:1px;zoom:1",b.appendChild(d.createElement("div")).style.width="5px",a=3!==b.offsetWidth),c.removeChild(e),a):void 0}}();var T=/[+-]?(?:\d*\.|)\d+(?:[eE][+-]?\d+|)/.source,U=new RegExp("^(?:([+-])=|)("+T+")([a-z%]*)$","i"),V=["Top","Right","Bottom","Left"],W=function(a,b){return a=b||a,"none"===n.css(a,"display")||!n.contains(a.ownerDocument,a)};function X(a,b,c,d){var e,f=1,g=20,h=d?function(){return d.cur()}:function(){return n.css(a,b,"")},i=h(),j=c&&c[3]||(n.cssNumber[b]?"":"px"),k=(n.cssNumber[b]||"px"!==j&&+i)&&U.exec(n.css(a,b));if(k&&k[3]!==j){j=j||k[3],c=c||[],k=+i||1;do{f=f||".5",k/=f,n.style(a,b,k+j)}while(f!==(f=h()/i)&&1!==f&&--g)}return c&&(k=+k||+i||0,e=c[1]?k+(c[1]+1)*c[2]:+c[2],d&&(d.unit=j,d.start=k,d.end=e)),e}var Y=function(a,b,c,d,e,f,g){var h=0,i=a.length,j=null==c;if("object"===n.type(c)){e=!0;
for(h in c){Y(a,b,h,c[h],!0,f,g)}}else{if(void 0!==d&&(e=!0,n.isFunction(d)||(g=!0),j&&(g?(b.call(a,d),b=null):(j=b,b=function(a,b,c){return j.call(n(a),c)})),b)){for(;i>h;h++){b(a[h],c,g?d:d.call(a[h],h,b(a[h],c)))}}}return e?a:j?b.call(a):i?b(a[0],c):f},Z=/^(?:checkbox|radio)$/i,$=/<([\w:-]+)/,_=/^$|\/(?:java|ecma)script/i,aa=/^\s+/,ba="abbr|article|aside|audio|bdi|canvas|data|datalist|details|dialog|figcaption|figure|footer|header|hgroup|main|mark|meter|nav|output|picture|progress|section|summary|template|time|video";function ca(a){var b=ba.split("|"),c=a.createDocumentFragment();if(c.createElement){while(b.length){c.createElement(b.pop())}}return c}!function(){var a=d.createElement("div"),b=d.createDocumentFragment(),c=d.createElement("input");a.innerHTML="  <link/><table></table><a href='/a'>a</a><input type='checkbox'/>",l.leadingWhitespace=3===a.firstChild.nodeType,l.tbody=!a.getElementsByTagName("tbody").length,l.htmlSerialize=!!a.getElementsByTagName("link").length,l.html5Clone="<:nav></:nav>"!==d.createElement("nav").cloneNode(!0).outerHTML,c.type="checkbox",c.checked=!0,b.appendChild(c),l.appendChecked=c.checked,a.innerHTML="<textarea>x</textarea>",l.noCloneChecked=!!a.cloneNode(!0).lastChild.defaultValue,b.appendChild(a),c=d.createElement("input"),c.setAttribute("type","radio"),c.setAttribute("checked","checked"),c.setAttribute("name","t"),a.appendChild(c),l.checkClone=a.cloneNode(!0).cloneNode(!0).lastChild.checked,l.noCloneEvent=!!a.addEventListener,a[n.expando]=1,l.attributes=!a.getAttribute(n.expando)}();var da={option:[1,"<select multiple='multiple'>","</select>"],legend:[1,"<fieldset>","</fieldset>"],area:[1,"<map>","</map>"],param:[1,"<object>","</object>"],thead:[1,"<table>","</table>"],tr:[2,"<table><tbody>","</tbody></table>"],col:[2,"<table><tbody></tbody><colgroup>","</colgroup></table>"],td:[3,"<table><tbody><tr>","</tr></tbody></table>"],_default:l.htmlSerialize?[0,"",""]:[1,"X<div>","</div>"]};da.optgroup=da.option,da.tbody=da.tfoot=da.colgroup=da.caption=da.thead,da.th=da.td;function ea(a,b){var c,d,e=0,f="undefined"!=typeof a.getElementsByTagName?a.getElementsByTagName(b||"*"):"undefined"!=typeof a.querySelectorAll?a.querySelectorAll(b||"*"):void 0;if(!f){for(f=[],c=a.childNodes||a;null!=(d=c[e]);e++){!b||n.nodeName(d,b)?f.push(d):n.merge(f,ea(d,b))}}return void 0===b||b&&n.nodeName(a,b)?n.merge([a],f):f}function fa(a,b){for(var c,d=0;null!=(c=a[d]);d++){n._data(c,"globalEval",!b||n._data(b[d],"globalEval"))}}var ga=/<|&#?\w+;/,ha=/<tbody/i;function ia(a){Z.test(a.type)&&(a.defaultChecked=a.checked)}function ja(a,b,c,d,e){for(var f,g,h,i,j,k,m,o=a.length,p=ca(b),q=[],r=0;o>r;r++){if(g=a[r],g||0===g){if("object"===n.type(g)){n.merge(q,g.nodeType?[g]:g)}else{if(ga.test(g)){i=i||p.appendChild(b.createElement("div")),j=($.exec(g)||["",""])[1].toLowerCase(),m=da[j]||da._default,i.innerHTML=m[1]+n.htmlPrefilter(g)+m[2],f=m[0];while(f--){i=i.lastChild}if(!l.leadingWhitespace&&aa.test(g)&&q.push(b.createTextNode(aa.exec(g)[0])),!l.tbody){g="table"!==j||ha.test(g)?"<table>"!==m[1]||ha.test(g)?0:i:i.firstChild,f=g&&g.childNodes.length;while(f--){n.nodeName(k=g.childNodes[f],"tbody")&&!k.childNodes.length&&g.removeChild(k)}}n.merge(q,i.childNodes),i.textContent="";while(i.firstChild){i.removeChild(i.firstChild)}i=p.lastChild}else{q.push(b.createTextNode(g))}}}}i&&p.removeChild(i),l.appendChecked||n.grep(ea(q,"input"),ia),r=0;while(g=q[r++]){if(d&&n.inArray(g,d)>-1){e&&e.push(g)}else{if(h=n.contains(g.ownerDocument,g),i=ea(p.appendChild(g),"script"),h&&fa(i),c){f=0;while(g=i[f++]){_.test(g.type||"")&&c.push(g)}}}}return i=null,p}!function(){var b,c,e=d.createElement("div");for(b in {submit:!0,change:!0,focusin:!0}){c="on"+b,(l[b]=c in a)||(e.setAttribute(c,"t"),l[b]=e.attributes[c].expando===!1)}e=null}();var ka=/^(?:input|select|textarea)$/i,la=/^key/,ma=/^(?:mouse|pointer|contextmenu|drag|drop)|click/,na=/^(?:focusinfocus|focusoutblur)$/,oa=/^([^.]*)(?:\.(.+)|)/;function pa(){return !0}function qa(){return !1}function ra(){try{return d.activeElement}catch(a){}}function sa(a,b,c,d,e,f){var g,h;if("object"==typeof b){"string"!=typeof c&&(d=d||c,c=void 0);for(h in b){sa(a,h,c,d,b[h],f)}return a}if(null==d&&null==e?(e=c,d=c=void 0):null==e&&("string"==typeof c?(e=d,d=void 0):(e=d,d=c,c=void 0)),e===!1){e=qa}else{if(!e){return a}}return 1===f&&(g=e,e=function(a){return n().off(a),g.apply(this,arguments)},e.guid=g.guid||(g.guid=n.guid++)),a.each(function(){n.event.add(this,b,e,d,c)})}n.event={global:{},add:function(a,b,c,d,e){var f,g,h,i,j,k,l,m,o,p,q,r=n._data(a);if(r){c.handler&&(i=c,c=i.handler,e=i.selector),c.guid||(c.guid=n.guid++),(g=r.events)||(g=r.events={}),(k=r.handle)||(k=r.handle=function(a){return"undefined"==typeof n||a&&n.event.triggered===a.type?void 0:n.event.dispatch.apply(k.elem,arguments)},k.elem=a),b=(b||"").match(G)||[""],h=b.length;while(h--){f=oa.exec(b[h])||[],o=q=f[1],p=(f[2]||"").split(".").sort(),o&&(j=n.event.special[o]||{},o=(e?j.delegateType:j.bindType)||o,j=n.event.special[o]||{},l=n.extend({type:o,origType:q,data:d,handler:c,guid:c.guid,selector:e,needsContext:e&&n.expr.match.needsContext.test(e),namespace:p.join(".")},i),(m=g[o])||(m=g[o]=[],m.delegateCount=0,j.setup&&j.setup.call(a,d,p,k)!==!1||(a.addEventListener?a.addEventListener(o,k,!1):a.attachEvent&&a.attachEvent("on"+o,k))),j.add&&(j.add.call(a,l),l.handler.guid||(l.handler.guid=c.guid)),e?m.splice(m.delegateCount++,0,l):m.push(l),n.event.global[o]=!0)
}a=null}},remove:function(a,b,c,d,e){var f,g,h,i,j,k,l,m,o,p,q,r=n.hasData(a)&&n._data(a);if(r&&(k=r.events)){b=(b||"").match(G)||[""],j=b.length;while(j--){if(h=oa.exec(b[j])||[],o=q=h[1],p=(h[2]||"").split(".").sort(),o){l=n.event.special[o]||{},o=(d?l.delegateType:l.bindType)||o,m=k[o]||[],h=h[2]&&new RegExp("(^|\\.)"+p.join("\\.(?:.*\\.|)")+"(\\.|$)"),i=f=m.length;while(f--){g=m[f],!e&&q!==g.origType||c&&c.guid!==g.guid||h&&!h.test(g.namespace)||d&&d!==g.selector&&("**"!==d||!g.selector)||(m.splice(f,1),g.selector&&m.delegateCount--,l.remove&&l.remove.call(a,g))}i&&!m.length&&(l.teardown&&l.teardown.call(a,p,r.handle)!==!1||n.removeEvent(a,o,r.handle),delete k[o])}else{for(o in k){n.event.remove(a,o+b[j],c,d,!0)}}}n.isEmptyObject(k)&&(delete r.handle,n._removeData(a,"events"))}},trigger:function(b,c,e,f){var g,h,i,j,l,m,o,p=[e||d],q=k.call(b,"type")?b.type:b,r=k.call(b,"namespace")?b.namespace.split("."):[];if(i=m=e=e||d,3!==e.nodeType&&8!==e.nodeType&&!na.test(q+n.event.triggered)&&(q.indexOf(".")>-1&&(r=q.split("."),q=r.shift(),r.sort()),h=q.indexOf(":")<0&&"on"+q,b=b[n.expando]?b:new n.Event(q,"object"==typeof b&&b),b.isTrigger=f?2:3,b.namespace=r.join("."),b.rnamespace=b.namespace?new RegExp("(^|\\.)"+r.join("\\.(?:.*\\.|)")+"(\\.|$)"):null,b.result=void 0,b.target||(b.target=e),c=null==c?[b]:n.makeArray(c,[b]),l=n.event.special[q]||{},f||!l.trigger||l.trigger.apply(e,c)!==!1)){if(!f&&!l.noBubble&&!n.isWindow(e)){for(j=l.delegateType||q,na.test(j+q)||(i=i.parentNode);i;i=i.parentNode){p.push(i),m=i}m===(e.ownerDocument||d)&&p.push(m.defaultView||m.parentWindow||a)}o=0;while((i=p[o++])&&!b.isPropagationStopped()){b.type=o>1?j:l.bindType||q,g=(n._data(i,"events")||{})[b.type]&&n._data(i,"handle"),g&&g.apply(i,c),g=h&&i[h],g&&g.apply&&M(i)&&(b.result=g.apply(i,c),b.result===!1&&b.preventDefault())}if(b.type=q,!f&&!b.isDefaultPrevented()&&(!l._default||l._default.apply(p.pop(),c)===!1)&&M(e)&&h&&e[q]&&!n.isWindow(e)){m=e[h],m&&(e[h]=null),n.event.triggered=q;try{e[q]()}catch(s){}n.event.triggered=void 0,m&&(e[h]=m)}return b.result}},dispatch:function(a){a=n.event.fix(a);var b,c,d,f,g,h=[],i=e.call(arguments),j=(n._data(this,"events")||{})[a.type]||[],k=n.event.special[a.type]||{};if(i[0]=a,a.delegateTarget=this,!k.preDispatch||k.preDispatch.call(this,a)!==!1){h=n.event.handlers.call(this,a,j),b=0;while((f=h[b++])&&!a.isPropagationStopped()){a.currentTarget=f.elem,c=0;while((g=f.handlers[c++])&&!a.isImmediatePropagationStopped()){a.rnamespace&&!a.rnamespace.test(g.namespace)||(a.handleObj=g,a.data=g.data,d=((n.event.special[g.origType]||{}).handle||g.handler).apply(f.elem,i),void 0!==d&&(a.result=d)===!1&&(a.preventDefault(),a.stopPropagation()))}}return k.postDispatch&&k.postDispatch.call(this,a),a.result}},handlers:function(a,b){var c,d,e,f,g=[],h=b.delegateCount,i=a.target;if(h&&i.nodeType&&("click"!==a.type||isNaN(a.button)||a.button<1)){for(;i!=this;i=i.parentNode||this){if(1===i.nodeType&&(i.disabled!==!0||"click"!==a.type)){for(d=[],c=0;h>c;c++){f=b[c],e=f.selector+" ",void 0===d[e]&&(d[e]=f.needsContext?n(e,this).index(i)>-1:n.find(e,this,null,[i]).length),d[e]&&d.push(f)}d.length&&g.push({elem:i,handlers:d})}}}return h<b.length&&g.push({elem:this,handlers:b.slice(h)}),g},fix:function(a){if(a[n.expando]){return a}var b,c,e,f=a.type,g=a,h=this.fixHooks[f];h||(this.fixHooks[f]=h=ma.test(f)?this.mouseHooks:la.test(f)?this.keyHooks:{}),e=h.props?this.props.concat(h.props):this.props,a=new n.Event(g),b=e.length;while(b--){c=e[b],a[c]=g[c]}return a.target||(a.target=g.srcElement||d),3===a.target.nodeType&&(a.target=a.target.parentNode),a.metaKey=!!a.metaKey,h.filter?h.filter(a,g):a},props:"altKey bubbles cancelable ctrlKey currentTarget detail eventPhase metaKey relatedTarget shiftKey target timeStamp view which".split(" "),fixHooks:{},keyHooks:{props:"char charCode key keyCode".split(" "),filter:function(a,b){return null==a.which&&(a.which=null!=b.charCode?b.charCode:b.keyCode),a}},mouseHooks:{props:"button buttons clientX clientY fromElement offsetX offsetY pageX pageY screenX screenY toElement".split(" "),filter:function(a,b){var c,e,f,g=b.button,h=b.fromElement;return null==a.pageX&&null!=b.clientX&&(e=a.target.ownerDocument||d,f=e.documentElement,c=e.body,a.pageX=b.clientX+(f&&f.scrollLeft||c&&c.scrollLeft||0)-(f&&f.clientLeft||c&&c.clientLeft||0),a.pageY=b.clientY+(f&&f.scrollTop||c&&c.scrollTop||0)-(f&&f.clientTop||c&&c.clientTop||0)),!a.relatedTarget&&h&&(a.relatedTarget=h===a.target?b.toElement:h),a.which||void 0===g||(a.which=1&g?1:2&g?3:4&g?2:0),a}},special:{load:{noBubble:!0},focus:{trigger:function(){if(this!==ra()&&this.focus){try{return this.focus(),!1}catch(a){}}},delegateType:"focusin"},blur:{trigger:function(){return this===ra()&&this.blur?(this.blur(),!1):void 0},delegateType:"focusout"},click:{trigger:function(){return n.nodeName(this,"input")&&"checkbox"===this.type&&this.click?(this.click(),!1):void 0},_default:function(a){return n.nodeName(a.target,"a")}},beforeunload:{postDispatch:function(a){void 0!==a.result&&a.originalEvent&&(a.originalEvent.returnValue=a.result)
}}},simulate:function(a,b,c){var d=n.extend(new n.Event,c,{type:a,isSimulated:!0});n.event.trigger(d,null,b),d.isDefaultPrevented()&&c.preventDefault()}},n.removeEvent=d.removeEventListener?function(a,b,c){a.removeEventListener&&a.removeEventListener(b,c)}:function(a,b,c){var d="on"+b;a.detachEvent&&("undefined"==typeof a[d]&&(a[d]=null),a.detachEvent(d,c))},n.Event=function(a,b){return this instanceof n.Event?(a&&a.type?(this.originalEvent=a,this.type=a.type,this.isDefaultPrevented=a.defaultPrevented||void 0===a.defaultPrevented&&a.returnValue===!1?pa:qa):this.type=a,b&&n.extend(this,b),this.timeStamp=a&&a.timeStamp||n.now(),void (this[n.expando]=!0)):new n.Event(a,b)},n.Event.prototype={constructor:n.Event,isDefaultPrevented:qa,isPropagationStopped:qa,isImmediatePropagationStopped:qa,preventDefault:function(){var a=this.originalEvent;this.isDefaultPrevented=pa,a&&(a.preventDefault?a.preventDefault():a.returnValue=!1)},stopPropagation:function(){var a=this.originalEvent;this.isPropagationStopped=pa,a&&!this.isSimulated&&(a.stopPropagation&&a.stopPropagation(),a.cancelBubble=!0)},stopImmediatePropagation:function(){var a=this.originalEvent;this.isImmediatePropagationStopped=pa,a&&a.stopImmediatePropagation&&a.stopImmediatePropagation(),this.stopPropagation()}},n.each({mouseenter:"mouseover",mouseleave:"mouseout",pointerenter:"pointerover",pointerleave:"pointerout"},function(a,b){n.event.special[a]={delegateType:b,bindType:b,handle:function(a){var c,d=this,e=a.relatedTarget,f=a.handleObj;return e&&(e===d||n.contains(d,e))||(a.type=f.origType,c=f.handler.apply(this,arguments),a.type=b),c}}}),l.submit||(n.event.special.submit={setup:function(){return n.nodeName(this,"form")?!1:void n.event.add(this,"click._submit keypress._submit",function(a){var b=a.target,c=n.nodeName(b,"input")||n.nodeName(b,"button")?n.prop(b,"form"):void 0;c&&!n._data(c,"submit")&&(n.event.add(c,"submit._submit",function(a){a._submitBubble=!0}),n._data(c,"submit",!0))})},postDispatch:function(a){a._submitBubble&&(delete a._submitBubble,this.parentNode&&!a.isTrigger&&n.event.simulate("submit",this.parentNode,a))},teardown:function(){return n.nodeName(this,"form")?!1:void n.event.remove(this,"._submit")}}),l.change||(n.event.special.change={setup:function(){return ka.test(this.nodeName)?("checkbox"!==this.type&&"radio"!==this.type||(n.event.add(this,"propertychange._change",function(a){"checked"===a.originalEvent.propertyName&&(this._justChanged=!0)}),n.event.add(this,"click._change",function(a){this._justChanged&&!a.isTrigger&&(this._justChanged=!1),n.event.simulate("change",this,a)})),!1):void n.event.add(this,"beforeactivate._change",function(a){var b=a.target;ka.test(b.nodeName)&&!n._data(b,"change")&&(n.event.add(b,"change._change",function(a){!this.parentNode||a.isSimulated||a.isTrigger||n.event.simulate("change",this.parentNode,a)}),n._data(b,"change",!0))})},handle:function(a){var b=a.target;return this!==b||a.isSimulated||a.isTrigger||"radio"!==b.type&&"checkbox"!==b.type?a.handleObj.handler.apply(this,arguments):void 0},teardown:function(){return n.event.remove(this,"._change"),!ka.test(this.nodeName)}}),l.focusin||n.each({focus:"focusin",blur:"focusout"},function(a,b){var c=function(a){n.event.simulate(b,a.target,n.event.fix(a))};n.event.special[b]={setup:function(){var d=this.ownerDocument||this,e=n._data(d,b);e||d.addEventListener(a,c,!0),n._data(d,b,(e||0)+1)},teardown:function(){var d=this.ownerDocument||this,e=n._data(d,b)-1;e?n._data(d,b,e):(d.removeEventListener(a,c,!0),n._removeData(d,b))}}}),n.fn.extend({on:function(a,b,c,d){return sa(this,a,b,c,d)},one:function(a,b,c,d){return sa(this,a,b,c,d,1)},off:function(a,b,c){var d,e;if(a&&a.preventDefault&&a.handleObj){return d=a.handleObj,n(a.delegateTarget).off(d.namespace?d.origType+"."+d.namespace:d.origType,d.selector,d.handler),this}if("object"==typeof a){for(e in a){this.off(e,b,a[e])}return this}return b!==!1&&"function"!=typeof b||(c=b,b=void 0),c===!1&&(c=qa),this.each(function(){n.event.remove(this,a,c,b)})},trigger:function(a,b){return this.each(function(){n.event.trigger(a,b,this)})},triggerHandler:function(a,b){var c=this[0];return c?n.event.trigger(a,b,c,!0):void 0}});var ta=/ jQuery\d+="(?:null|\d+)"/g,ua=new RegExp("<(?:"+ba+")[\\s/>]","i"),va=/<(?!area|br|col|embed|hr|img|input|link|meta|param)(([\w:-]+)[^>]*)\/>/gi,wa=/<script|<style|<link/i,xa=/checked\s*(?:[^=]|=\s*.checked.)/i,ya=/^true\/(.*)/,za=/^\s*<!(?:\[CDATA\[|--)|(?:\]\]|--)>\s*$/g,Aa=ca(d),Ba=Aa.appendChild(d.createElement("div"));function Ca(a,b){return n.nodeName(a,"table")&&n.nodeName(11!==b.nodeType?b:b.firstChild,"tr")?a.getElementsByTagName("tbody")[0]||a.appendChild(a.ownerDocument.createElement("tbody")):a}function Da(a){return a.type=(null!==n.find.attr(a,"type"))+"/"+a.type,a}function Ea(a){var b=ya.exec(a.type);return b?a.type=b[1]:a.removeAttribute("type"),a}function Fa(a,b){if(1===b.nodeType&&n.hasData(a)){var c,d,e,f=n._data(a),g=n._data(b,f),h=f.events;if(h){delete g.handle,g.events={};
for(c in h){for(d=0,e=h[c].length;e>d;d++){n.event.add(b,c,h[c][d])}}}g.data&&(g.data=n.extend({},g.data))}}function Ga(a,b){var c,d,e;if(1===b.nodeType){if(c=b.nodeName.toLowerCase(),!l.noCloneEvent&&b[n.expando]){e=n._data(b);for(d in e.events){n.removeEvent(b,d,e.handle)}b.removeAttribute(n.expando)}"script"===c&&b.text!==a.text?(Da(b).text=a.text,Ea(b)):"object"===c?(b.parentNode&&(b.outerHTML=a.outerHTML),l.html5Clone&&a.innerHTML&&!n.trim(b.innerHTML)&&(b.innerHTML=a.innerHTML)):"input"===c&&Z.test(a.type)?(b.defaultChecked=b.checked=a.checked,b.value!==a.value&&(b.value=a.value)):"option"===c?b.defaultSelected=b.selected=a.defaultSelected:"input"!==c&&"textarea"!==c||(b.defaultValue=a.defaultValue)}}function Ha(a,b,c,d){b=f.apply([],b);var e,g,h,i,j,k,m=0,o=a.length,p=o-1,q=b[0],r=n.isFunction(q);if(r||o>1&&"string"==typeof q&&!l.checkClone&&xa.test(q)){return a.each(function(e){var f=a.eq(e);r&&(b[0]=q.call(this,e,f.html())),Ha(f,b,c,d)})}if(o&&(k=ja(b,a[0].ownerDocument,!1,a,d),e=k.firstChild,1===k.childNodes.length&&(k=e),e||d)){for(i=n.map(ea(k,"script"),Da),h=i.length;o>m;m++){g=k,m!==p&&(g=n.clone(g,!0,!0),h&&n.merge(i,ea(g,"script"))),c.call(a[m],g,m)}if(h){for(j=i[i.length-1].ownerDocument,n.map(i,Ea),m=0;h>m;m++){g=i[m],_.test(g.type||"")&&!n._data(g,"globalEval")&&n.contains(j,g)&&(g.src?n._evalUrl&&n._evalUrl(g.src):n.globalEval((g.text||g.textContent||g.innerHTML||"").replace(za,"")))}}k=e=null}return a}function Ia(a,b,c){for(var d,e=b?n.filter(b,a):a,f=0;null!=(d=e[f]);f++){c||1!==d.nodeType||n.cleanData(ea(d)),d.parentNode&&(c&&n.contains(d.ownerDocument,d)&&fa(ea(d,"script")),d.parentNode.removeChild(d))}return a}n.extend({htmlPrefilter:function(a){return a.replace(va,"<$1></$2>")},clone:function(a,b,c){var d,e,f,g,h,i=n.contains(a.ownerDocument,a);if(l.html5Clone||n.isXMLDoc(a)||!ua.test("<"+a.nodeName+">")?f=a.cloneNode(!0):(Ba.innerHTML=a.outerHTML,Ba.removeChild(f=Ba.firstChild)),!(l.noCloneEvent&&l.noCloneChecked||1!==a.nodeType&&11!==a.nodeType||n.isXMLDoc(a))){for(d=ea(f),h=ea(a),g=0;null!=(e=h[g]);++g){d[g]&&Ga(e,d[g])}}if(b){if(c){for(h=h||ea(a),d=d||ea(f),g=0;null!=(e=h[g]);g++){Fa(e,d[g])}}else{Fa(a,f)}}return d=ea(f,"script"),d.length>0&&fa(d,!i&&ea(a,"script")),d=h=e=null,f},cleanData:function(a,b){for(var d,e,f,g,h=0,i=n.expando,j=n.cache,k=l.attributes,m=n.event.special;null!=(d=a[h]);h++){if((b||M(d))&&(f=d[i],g=f&&j[f])){if(g.events){for(e in g.events){m[e]?n.event.remove(d,e):n.removeEvent(d,e,g.handle)}}j[f]&&(delete j[f],k||"undefined"==typeof d.removeAttribute?d[i]=void 0:d.removeAttribute(i),c.push(f))}}}}),n.fn.extend({domManip:Ha,detach:function(a){return Ia(this,a,!0)},remove:function(a){return Ia(this,a)},text:function(a){return Y(this,function(a){return void 0===a?n.text(this):this.empty().append((this[0]&&this[0].ownerDocument||d).createTextNode(a))},null,a,arguments.length)},append:function(){return Ha(this,arguments,function(a){if(1===this.nodeType||11===this.nodeType||9===this.nodeType){var b=Ca(this,a);b.appendChild(a)}})},prepend:function(){return Ha(this,arguments,function(a){if(1===this.nodeType||11===this.nodeType||9===this.nodeType){var b=Ca(this,a);b.insertBefore(a,b.firstChild)}})},before:function(){return Ha(this,arguments,function(a){this.parentNode&&this.parentNode.insertBefore(a,this)})},after:function(){return Ha(this,arguments,function(a){this.parentNode&&this.parentNode.insertBefore(a,this.nextSibling)})},empty:function(){for(var a,b=0;null!=(a=this[b]);b++){1===a.nodeType&&n.cleanData(ea(a,!1));while(a.firstChild){a.removeChild(a.firstChild)}a.options&&n.nodeName(a,"select")&&(a.options.length=0)}return this},clone:function(a,b){return a=null==a?!1:a,b=null==b?a:b,this.map(function(){return n.clone(this,a,b)})},html:function(a){return Y(this,function(a){var b=this[0]||{},c=0,d=this.length;if(void 0===a){return 1===b.nodeType?b.innerHTML.replace(ta,""):void 0}if("string"==typeof a&&!wa.test(a)&&(l.htmlSerialize||!ua.test(a))&&(l.leadingWhitespace||!aa.test(a))&&!da[($.exec(a)||["",""])[1].toLowerCase()]){a=n.htmlPrefilter(a);try{for(;d>c;c++){b=this[c]||{},1===b.nodeType&&(n.cleanData(ea(b,!1)),b.innerHTML=a)}b=0}catch(e){}}b&&this.empty().append(a)},null,a,arguments.length)},replaceWith:function(){var a=[];return Ha(this,arguments,function(b){var c=this.parentNode;n.inArray(this,a)<0&&(n.cleanData(ea(this)),c&&c.replaceChild(b,this))},a)}}),n.each({appendTo:"append",prependTo:"prepend",insertBefore:"before",insertAfter:"after",replaceAll:"replaceWith"},function(a,b){n.fn[a]=function(a){for(var c,d=0,e=[],f=n(a),h=f.length-1;h>=d;d++){c=d===h?this:this.clone(!0),n(f[d])[b](c),g.apply(e,c.get())}return this.pushStack(e)}});var Ja,Ka={HTML:"block",BODY:"block"};function La(a,b){var c=n(b.createElement(a)).appendTo(b.body),d=n.css(c[0],"display");return c.detach(),d}function Ma(a){var b=d,c=Ka[a];return c||(c=La(a,b),"none"!==c&&c||(Ja=(Ja||n("<iframe frameborder='0' width='0' height='0'/>")).appendTo(b.documentElement),b=(Ja[0].contentWindow||Ja[0].contentDocument).document,b.write(),b.close(),c=La(a,b),Ja.detach()),Ka[a]=c),c
}var Na=/^margin/,Oa=new RegExp("^("+T+")(?!px)[a-z%]+$","i"),Pa=function(a,b,c,d){var e,f,g={};for(f in b){g[f]=a.style[f],a.style[f]=b[f]}e=c.apply(a,d||[]);for(f in b){a.style[f]=g[f]}return e},Qa=d.documentElement;!function(){var b,c,e,f,g,h,i=d.createElement("div"),j=d.createElement("div");if(j.style){j.style.cssText="float:left;opacity:.5",l.opacity="0.5"===j.style.opacity,l.cssFloat=!!j.style.cssFloat,j.style.backgroundClip="content-box",j.cloneNode(!0).style.backgroundClip="",l.clearCloneStyle="content-box"===j.style.backgroundClip,i=d.createElement("div"),i.style.cssText="border:0;width:8px;height:0;top:0;left:-9999px;padding:0;margin-top:1px;position:absolute",j.innerHTML="",i.appendChild(j),l.boxSizing=""===j.style.boxSizing||""===j.style.MozBoxSizing||""===j.style.WebkitBoxSizing,n.extend(l,{reliableHiddenOffsets:function(){return null==b&&k(),f},boxSizingReliable:function(){return null==b&&k(),e},pixelMarginRight:function(){return null==b&&k(),c},pixelPosition:function(){return null==b&&k(),b},reliableMarginRight:function(){return null==b&&k(),g},reliableMarginLeft:function(){return null==b&&k(),h}});function k(){var k,l,m=d.documentElement;m.appendChild(i),j.style.cssText="-webkit-box-sizing:border-box;box-sizing:border-box;position:relative;display:block;margin:auto;border:1px;padding:1px;top:1%;width:50%",b=e=h=!1,c=g=!0,a.getComputedStyle&&(l=a.getComputedStyle(j),b="1%"!==(l||{}).top,h="2px"===(l||{}).marginLeft,e="4px"===(l||{width:"4px"}).width,j.style.marginRight="50%",c="4px"===(l||{marginRight:"4px"}).marginRight,k=j.appendChild(d.createElement("div")),k.style.cssText=j.style.cssText="-webkit-box-sizing:content-box;-moz-box-sizing:content-box;box-sizing:content-box;display:block;margin:0;border:0;padding:0",k.style.marginRight=k.style.width="0",j.style.width="1px",g=!parseFloat((a.getComputedStyle(k)||{}).marginRight),j.removeChild(k)),j.style.display="none",f=0===j.getClientRects().length,f&&(j.style.display="",j.innerHTML="<table><tr><td></td><td>t</td></tr></table>",j.childNodes[0].style.borderCollapse="separate",k=j.getElementsByTagName("td"),k[0].style.cssText="margin:0;border:0;padding:0;display:none",f=0===k[0].offsetHeight,f&&(k[0].style.display="",k[1].style.display="none",f=0===k[0].offsetHeight)),m.removeChild(i)}}}();var Ra,Sa,Ta=/^(top|right|bottom|left)$/;a.getComputedStyle?(Ra=function(b){var c=b.ownerDocument.defaultView;return c&&c.opener||(c=a),c.getComputedStyle(b)},Sa=function(a,b,c){var d,e,f,g,h=a.style;return c=c||Ra(a),g=c?c.getPropertyValue(b)||c[b]:void 0,""!==g&&void 0!==g||n.contains(a.ownerDocument,a)||(g=n.style(a,b)),c&&!l.pixelMarginRight()&&Oa.test(g)&&Na.test(b)&&(d=h.width,e=h.minWidth,f=h.maxWidth,h.minWidth=h.maxWidth=h.width=g,g=c.width,h.width=d,h.minWidth=e,h.maxWidth=f),void 0===g?g:g+""}):Qa.currentStyle&&(Ra=function(a){return a.currentStyle},Sa=function(a,b,c){var d,e,f,g,h=a.style;return c=c||Ra(a),g=c?c[b]:void 0,null==g&&h&&h[b]&&(g=h[b]),Oa.test(g)&&!Ta.test(b)&&(d=h.left,e=a.runtimeStyle,f=e&&e.left,f&&(e.left=a.currentStyle.left),h.left="fontSize"===b?"1em":g,g=h.pixelLeft+"px",h.left=d,f&&(e.left=f)),void 0===g?g:g+""||"auto"});function Ua(a,b){return{get:function(){return a()?void delete this.get:(this.get=b).apply(this,arguments)}}}var Va=/alpha\([^)]*\)/i,Wa=/opacity\s*=\s*([^)]*)/i,Xa=/^(none|table(?!-c[ea]).+)/,Ya=new RegExp("^("+T+")(.*)$","i"),Za={position:"absolute",visibility:"hidden",display:"block"},$a={letterSpacing:"0",fontWeight:"400"},_a=["Webkit","O","Moz","ms"],ab=d.createElement("div").style;function bb(a){if(a in ab){return a}var b=a.charAt(0).toUpperCase()+a.slice(1),c=_a.length;while(c--){if(a=_a[c]+b,a in ab){return a}}}function cb(a,b){for(var c,d,e,f=[],g=0,h=a.length;h>g;g++){d=a[g],d.style&&(f[g]=n._data(d,"olddisplay"),c=d.style.display,b?(f[g]||"none"!==c||(d.style.display=""),""===d.style.display&&W(d)&&(f[g]=n._data(d,"olddisplay",Ma(d.nodeName)))):(e=W(d),(c&&"none"!==c||!e)&&n._data(d,"olddisplay",e?c:n.css(d,"display"))))}for(g=0;h>g;g++){d=a[g],d.style&&(b&&"none"!==d.style.display&&""!==d.style.display||(d.style.display=b?f[g]||"":"none"))}return a}function db(a,b,c){var d=Ya.exec(b);return d?Math.max(0,d[1]-(c||0))+(d[2]||"px"):b}function eb(a,b,c,d,e){for(var f=c===(d?"border":"content")?4:"width"===b?1:0,g=0;4>f;f+=2){"margin"===c&&(g+=n.css(a,c+V[f],!0,e)),d?("content"===c&&(g-=n.css(a,"padding"+V[f],!0,e)),"margin"!==c&&(g-=n.css(a,"border"+V[f]+"Width",!0,e))):(g+=n.css(a,"padding"+V[f],!0,e),"padding"!==c&&(g+=n.css(a,"border"+V[f]+"Width",!0,e)))}return g}function fb(a,b,c){var d=!0,e="width"===b?a.offsetWidth:a.offsetHeight,f=Ra(a),g=l.boxSizing&&"border-box"===n.css(a,"boxSizing",!1,f);if(0>=e||null==e){if(e=Sa(a,b,f),(0>e||null==e)&&(e=a.style[b]),Oa.test(e)){return e}d=g&&(l.boxSizingReliable()||e===a.style[b]),e=parseFloat(e)||0}return e+eb(a,b,c||(g?"border":"content"),d,f)+"px"}n.extend({cssHooks:{opacity:{get:function(a,b){if(b){var c=Sa(a,"opacity");return""===c?"1":c}}}},cssNumber:{animationIterationCount:!0,columnCount:!0,fillOpacity:!0,flexGrow:!0,flexShrink:!0,fontWeight:!0,lineHeight:!0,opacity:!0,order:!0,orphans:!0,widows:!0,zIndex:!0,zoom:!0},cssProps:{"float":l.cssFloat?"cssFloat":"styleFloat"},style:function(a,b,c,d){if(a&&3!==a.nodeType&&8!==a.nodeType&&a.style){var e,f,g,h=n.camelCase(b),i=a.style;
if(b=n.cssProps[h]||(n.cssProps[h]=bb(h)||h),g=n.cssHooks[b]||n.cssHooks[h],void 0===c){return g&&"get" in g&&void 0!==(e=g.get(a,!1,d))?e:i[b]}if(f=typeof c,"string"===f&&(e=U.exec(c))&&e[1]&&(c=X(a,b,e),f="number"),null!=c&&c===c&&("number"===f&&(c+=e&&e[3]||(n.cssNumber[h]?"":"px")),l.clearCloneStyle||""!==c||0!==b.indexOf("background")||(i[b]="inherit"),!(g&&"set" in g&&void 0===(c=g.set(a,c,d))))){try{i[b]=c}catch(j){}}}},css:function(a,b,c,d){var e,f,g,h=n.camelCase(b);return b=n.cssProps[h]||(n.cssProps[h]=bb(h)||h),g=n.cssHooks[b]||n.cssHooks[h],g&&"get" in g&&(f=g.get(a,!0,c)),void 0===f&&(f=Sa(a,b,d)),"normal"===f&&b in $a&&(f=$a[b]),""===c||c?(e=parseFloat(f),c===!0||isFinite(e)?e||0:f):f}}),n.each(["height","width"],function(a,b){n.cssHooks[b]={get:function(a,c,d){return c?Xa.test(n.css(a,"display"))&&0===a.offsetWidth?Pa(a,Za,function(){return fb(a,b,d)}):fb(a,b,d):void 0},set:function(a,c,d){var e=d&&Ra(a);return db(a,c,d?eb(a,b,d,l.boxSizing&&"border-box"===n.css(a,"boxSizing",!1,e),e):0)}}}),l.opacity||(n.cssHooks.opacity={get:function(a,b){return Wa.test((b&&a.currentStyle?a.currentStyle.filter:a.style.filter)||"")?0.01*parseFloat(RegExp.$1)+"":b?"1":""},set:function(a,b){var c=a.style,d=a.currentStyle,e=n.isNumeric(b)?"alpha(opacity="+100*b+")":"",f=d&&d.filter||c.filter||"";c.zoom=1,(b>=1||""===b)&&""===n.trim(f.replace(Va,""))&&c.removeAttribute&&(c.removeAttribute("filter"),""===b||d&&!d.filter)||(c.filter=Va.test(f)?f.replace(Va,e):f+" "+e)}}),n.cssHooks.marginRight=Ua(l.reliableMarginRight,function(a,b){return b?Pa(a,{display:"inline-block"},Sa,[a,"marginRight"]):void 0}),n.cssHooks.marginLeft=Ua(l.reliableMarginLeft,function(a,b){return b?(parseFloat(Sa(a,"marginLeft"))||(n.contains(a.ownerDocument,a)?a.getBoundingClientRect().left-Pa(a,{marginLeft:0},function(){return a.getBoundingClientRect().left}):0))+"px":void 0}),n.each({margin:"",padding:"",border:"Width"},function(a,b){n.cssHooks[a+b]={expand:function(c){for(var d=0,e={},f="string"==typeof c?c.split(" "):[c];4>d;d++){e[a+V[d]+b]=f[d]||f[d-2]||f[0]}return e}},Na.test(a)||(n.cssHooks[a+b].set=db)}),n.fn.extend({css:function(a,b){return Y(this,function(a,b,c){var d,e,f={},g=0;if(n.isArray(b)){for(d=Ra(a),e=b.length;e>g;g++){f[b[g]]=n.css(a,b[g],!1,d)}return f}return void 0!==c?n.style(a,b,c):n.css(a,b)},a,b,arguments.length>1)},show:function(){return cb(this,!0)},hide:function(){return cb(this)},toggle:function(a){return"boolean"==typeof a?a?this.show():this.hide():this.each(function(){W(this)?n(this).show():n(this).hide()})}});function gb(a,b,c,d,e){return new gb.prototype.init(a,b,c,d,e)}n.Tween=gb,gb.prototype={constructor:gb,init:function(a,b,c,d,e,f){this.elem=a,this.prop=c,this.easing=e||n.easing._default,this.options=b,this.start=this.now=this.cur(),this.end=d,this.unit=f||(n.cssNumber[c]?"":"px")},cur:function(){var a=gb.propHooks[this.prop];return a&&a.get?a.get(this):gb.propHooks._default.get(this)},run:function(a){var b,c=gb.propHooks[this.prop];return this.options.duration?this.pos=b=n.easing[this.easing](a,this.options.duration*a,0,1,this.options.duration):this.pos=b=a,this.now=(this.end-this.start)*b+this.start,this.options.step&&this.options.step.call(this.elem,this.now,this),c&&c.set?c.set(this):gb.propHooks._default.set(this),this}},gb.prototype.init.prototype=gb.prototype,gb.propHooks={_default:{get:function(a){var b;return 1!==a.elem.nodeType||null!=a.elem[a.prop]&&null==a.elem.style[a.prop]?a.elem[a.prop]:(b=n.css(a.elem,a.prop,""),b&&"auto"!==b?b:0)},set:function(a){n.fx.step[a.prop]?n.fx.step[a.prop](a):1!==a.elem.nodeType||null==a.elem.style[n.cssProps[a.prop]]&&!n.cssHooks[a.prop]?a.elem[a.prop]=a.now:n.style(a.elem,a.prop,a.now+a.unit)}}},gb.propHooks.scrollTop=gb.propHooks.scrollLeft={set:function(a){a.elem.nodeType&&a.elem.parentNode&&(a.elem[a.prop]=a.now)}},n.easing={linear:function(a){return a},swing:function(a){return 0.5-Math.cos(a*Math.PI)/2},_default:"swing"},n.fx=gb.prototype.init,n.fx.step={};var hb,ib,jb=/^(?:toggle|show|hide)$/,kb=/queueHooks$/;function lb(){return a.setTimeout(function(){hb=void 0}),hb=n.now()}function mb(a,b){var c,d={height:a},e=0;for(b=b?1:0;4>e;e+=2-b){c=V[e],d["margin"+c]=d["padding"+c]=a}return b&&(d.opacity=d.width=a),d}function nb(a,b,c){for(var d,e=(qb.tweeners[b]||[]).concat(qb.tweeners["*"]),f=0,g=e.length;g>f;f++){if(d=e[f].call(c,b,a)){return d}}}function ob(a,b,c){var d,e,f,g,h,i,j,k,m=this,o={},p=a.style,q=a.nodeType&&W(a),r=n._data(a,"fxshow");c.queue||(h=n._queueHooks(a,"fx"),null==h.unqueued&&(h.unqueued=0,i=h.empty.fire,h.empty.fire=function(){h.unqueued||i()}),h.unqueued++,m.always(function(){m.always(function(){h.unqueued--,n.queue(a,"fx").length||h.empty.fire()})})),1===a.nodeType&&("height" in b||"width" in b)&&(c.overflow=[p.overflow,p.overflowX,p.overflowY],j=n.css(a,"display"),k="none"===j?n._data(a,"olddisplay")||Ma(a.nodeName):j,"inline"===k&&"none"===n.css(a,"float")&&(l.inlineBlockNeedsLayout&&"inline"!==Ma(a.nodeName)?p.zoom=1:p.display="inline-block")),c.overflow&&(p.overflow="hidden",l.shrinkWrapBlocks()||m.always(function(){p.overflow=c.overflow[0],p.overflowX=c.overflow[1],p.overflowY=c.overflow[2]
}));for(d in b){if(e=b[d],jb.exec(e)){if(delete b[d],f=f||"toggle"===e,e===(q?"hide":"show")){if("show"!==e||!r||void 0===r[d]){continue}q=!0}o[d]=r&&r[d]||n.style(a,d)}else{j=void 0}}if(n.isEmptyObject(o)){"inline"===("none"===j?Ma(a.nodeName):j)&&(p.display=j)}else{r?"hidden" in r&&(q=r.hidden):r=n._data(a,"fxshow",{}),f&&(r.hidden=!q),q?n(a).show():m.done(function(){n(a).hide()}),m.done(function(){var b;n._removeData(a,"fxshow");for(b in o){n.style(a,b,o[b])}});for(d in o){g=nb(q?r[d]:0,d,m),d in r||(r[d]=g.start,q&&(g.end=g.start,g.start="width"===d||"height"===d?1:0))}}}function pb(a,b){var c,d,e,f,g;for(c in a){if(d=n.camelCase(c),e=b[d],f=a[c],n.isArray(f)&&(e=f[1],f=a[c]=f[0]),c!==d&&(a[d]=f,delete a[c]),g=n.cssHooks[d],g&&"expand" in g){f=g.expand(f),delete a[d];for(c in f){c in a||(a[c]=f[c],b[c]=e)}}else{b[d]=e}}}function qb(a,b,c){var d,e,f=0,g=qb.prefilters.length,h=n.Deferred().always(function(){delete i.elem}),i=function(){if(e){return !1}for(var b=hb||lb(),c=Math.max(0,j.startTime+j.duration-b),d=c/j.duration||0,f=1-d,g=0,i=j.tweens.length;i>g;g++){j.tweens[g].run(f)}return h.notifyWith(a,[j,f,c]),1>f&&i?c:(h.resolveWith(a,[j]),!1)},j=h.promise({elem:a,props:n.extend({},b),opts:n.extend(!0,{specialEasing:{},easing:n.easing._default},c),originalProperties:b,originalOptions:c,startTime:hb||lb(),duration:c.duration,tweens:[],createTween:function(b,c){var d=n.Tween(a,j.opts,b,c,j.opts.specialEasing[b]||j.opts.easing);return j.tweens.push(d),d},stop:function(b){var c=0,d=b?j.tweens.length:0;if(e){return this}for(e=!0;d>c;c++){j.tweens[c].run(1)}return b?(h.notifyWith(a,[j,1,0]),h.resolveWith(a,[j,b])):h.rejectWith(a,[j,b]),this}}),k=j.props;for(pb(k,j.opts.specialEasing);g>f;f++){if(d=qb.prefilters[f].call(j,a,k,j.opts)){return n.isFunction(d.stop)&&(n._queueHooks(j.elem,j.opts.queue).stop=n.proxy(d.stop,d)),d}}return n.map(k,nb,j),n.isFunction(j.opts.start)&&j.opts.start.call(a,j),n.fx.timer(n.extend(i,{elem:a,anim:j,queue:j.opts.queue})),j.progress(j.opts.progress).done(j.opts.done,j.opts.complete).fail(j.opts.fail).always(j.opts.always)}n.Animation=n.extend(qb,{tweeners:{"*":[function(a,b){var c=this.createTween(a,b);return X(c.elem,a,U.exec(b),c),c}]},tweener:function(a,b){n.isFunction(a)?(b=a,a=["*"]):a=a.match(G);for(var c,d=0,e=a.length;e>d;d++){c=a[d],qb.tweeners[c]=qb.tweeners[c]||[],qb.tweeners[c].unshift(b)}},prefilters:[ob],prefilter:function(a,b){b?qb.prefilters.unshift(a):qb.prefilters.push(a)}}),n.speed=function(a,b,c){var d=a&&"object"==typeof a?n.extend({},a):{complete:c||!c&&b||n.isFunction(a)&&a,duration:a,easing:c&&b||b&&!n.isFunction(b)&&b};return d.duration=n.fx.off?0:"number"==typeof d.duration?d.duration:d.duration in n.fx.speeds?n.fx.speeds[d.duration]:n.fx.speeds._default,null!=d.queue&&d.queue!==!0||(d.queue="fx"),d.old=d.complete,d.complete=function(){n.isFunction(d.old)&&d.old.call(this),d.queue&&n.dequeue(this,d.queue)},d},n.fn.extend({fadeTo:function(a,b,c,d){return this.filter(W).css("opacity",0).show().end().animate({opacity:b},a,c,d)},animate:function(a,b,c,d){var e=n.isEmptyObject(a),f=n.speed(b,c,d),g=function(){var b=qb(this,n.extend({},a),f);(e||n._data(this,"finish"))&&b.stop(!0)};return g.finish=g,e||f.queue===!1?this.each(g):this.queue(f.queue,g)},stop:function(a,b,c){var d=function(a){var b=a.stop;delete a.stop,b(c)};return"string"!=typeof a&&(c=b,b=a,a=void 0),b&&a!==!1&&this.queue(a||"fx",[]),this.each(function(){var b=!0,e=null!=a&&a+"queueHooks",f=n.timers,g=n._data(this);if(e){g[e]&&g[e].stop&&d(g[e])}else{for(e in g){g[e]&&g[e].stop&&kb.test(e)&&d(g[e])}}for(e=f.length;e--;){f[e].elem!==this||null!=a&&f[e].queue!==a||(f[e].anim.stop(c),b=!1,f.splice(e,1))}!b&&c||n.dequeue(this,a)})},finish:function(a){return a!==!1&&(a=a||"fx"),this.each(function(){var b,c=n._data(this),d=c[a+"queue"],e=c[a+"queueHooks"],f=n.timers,g=d?d.length:0;for(c.finish=!0,n.queue(this,a,[]),e&&e.stop&&e.stop.call(this,!0),b=f.length;b--;){f[b].elem===this&&f[b].queue===a&&(f[b].anim.stop(!0),f.splice(b,1))}for(b=0;g>b;b++){d[b]&&d[b].finish&&d[b].finish.call(this)}delete c.finish})}}),n.each(["toggle","show","hide"],function(a,b){var c=n.fn[b];n.fn[b]=function(a,d,e){return null==a||"boolean"==typeof a?c.apply(this,arguments):this.animate(mb(b,!0),a,d,e)}}),n.each({slideDown:mb("show"),slideUp:mb("hide"),slideToggle:mb("toggle"),fadeIn:{opacity:"show"},fadeOut:{opacity:"hide"},fadeToggle:{opacity:"toggle"}},function(a,b){n.fn[a]=function(a,c,d){return this.animate(b,a,c,d)}}),n.timers=[],n.fx.tick=function(){var a,b=n.timers,c=0;for(hb=n.now();c<b.length;c++){a=b[c],a()||b[c]!==a||b.splice(c--,1)}b.length||n.fx.stop(),hb=void 0},n.fx.timer=function(a){n.timers.push(a),a()?n.fx.start():n.timers.pop()},n.fx.interval=13,n.fx.start=function(){ib||(ib=a.setInterval(n.fx.tick,n.fx.interval))},n.fx.stop=function(){a.clearInterval(ib),ib=null},n.fx.speeds={slow:600,fast:200,_default:400},n.fn.delay=function(b,c){return b=n.fx?n.fx.speeds[b]||b:b,c=c||"fx",this.queue(c,function(c,d){var e=a.setTimeout(c,b);
d.stop=function(){a.clearTimeout(e)}})},function(){var a,b=d.createElement("input"),c=d.createElement("div"),e=d.createElement("select"),f=e.appendChild(d.createElement("option"));c=d.createElement("div"),c.setAttribute("className","t"),c.innerHTML="  <link/><table></table><a href='/a'>a</a><input type='checkbox'/>",a=c.getElementsByTagName("a")[0],b.setAttribute("type","checkbox"),c.appendChild(b),a=c.getElementsByTagName("a")[0],a.style.cssText="top:1px",l.getSetAttribute="t"!==c.className,l.style=/top/.test(a.getAttribute("style")),l.hrefNormalized="/a"===a.getAttribute("href"),l.checkOn=!!b.value,l.optSelected=f.selected,l.enctype=!!d.createElement("form").enctype,e.disabled=!0,l.optDisabled=!f.disabled,b=d.createElement("input"),b.setAttribute("value",""),l.input=""===b.getAttribute("value"),b.value="t",b.setAttribute("type","radio"),l.radioValue="t"===b.value}();var rb=/\r/g,sb=/[\x20\t\r\n\f]+/g;n.fn.extend({val:function(a){var b,c,d,e=this[0];if(arguments.length){return d=n.isFunction(a),this.each(function(c){var e;1===this.nodeType&&(e=d?a.call(this,c,n(this).val()):a,null==e?e="":"number"==typeof e?e+="":n.isArray(e)&&(e=n.map(e,function(a){return null==a?"":a+""})),b=n.valHooks[this.type]||n.valHooks[this.nodeName.toLowerCase()],b&&"set" in b&&void 0!==b.set(this,e,"value")||(this.value=e))})}if(e){return b=n.valHooks[e.type]||n.valHooks[e.nodeName.toLowerCase()],b&&"get" in b&&void 0!==(c=b.get(e,"value"))?c:(c=e.value,"string"==typeof c?c.replace(rb,""):null==c?"":c)}}}),n.extend({valHooks:{option:{get:function(a){var b=n.find.attr(a,"value");return null!=b?b:n.trim(n.text(a)).replace(sb," ")}},select:{get:function(a){for(var b,c,d=a.options,e=a.selectedIndex,f="select-one"===a.type||0>e,g=f?null:[],h=f?e+1:d.length,i=0>e?h:f?e:0;h>i;i++){if(c=d[i],(c.selected||i===e)&&(l.optDisabled?!c.disabled:null===c.getAttribute("disabled"))&&(!c.parentNode.disabled||!n.nodeName(c.parentNode,"optgroup"))){if(b=n(c).val(),f){return b}g.push(b)}}return g},set:function(a,b){var c,d,e=a.options,f=n.makeArray(b),g=e.length;while(g--){if(d=e[g],n.inArray(n.valHooks.option.get(d),f)>-1){try{d.selected=c=!0}catch(h){d.scrollHeight}}else{d.selected=!1}}return c||(a.selectedIndex=-1),e}}}}),n.each(["radio","checkbox"],function(){n.valHooks[this]={set:function(a,b){return n.isArray(b)?a.checked=n.inArray(n(a).val(),b)>-1:void 0}},l.checkOn||(n.valHooks[this].get=function(a){return null===a.getAttribute("value")?"on":a.value})});var tb,ub,vb=n.expr.attrHandle,wb=/^(?:checked|selected)$/i,xb=l.getSetAttribute,yb=l.input;n.fn.extend({attr:function(a,b){return Y(this,n.attr,a,b,arguments.length>1)},removeAttr:function(a){return this.each(function(){n.removeAttr(this,a)})}}),n.extend({attr:function(a,b,c){var d,e,f=a.nodeType;if(3!==f&&8!==f&&2!==f){return"undefined"==typeof a.getAttribute?n.prop(a,b,c):(1===f&&n.isXMLDoc(a)||(b=b.toLowerCase(),e=n.attrHooks[b]||(n.expr.match.bool.test(b)?ub:tb)),void 0!==c?null===c?void n.removeAttr(a,b):e&&"set" in e&&void 0!==(d=e.set(a,c,b))?d:(a.setAttribute(b,c+""),c):e&&"get" in e&&null!==(d=e.get(a,b))?d:(d=n.find.attr(a,b),null==d?void 0:d))}},attrHooks:{type:{set:function(a,b){if(!l.radioValue&&"radio"===b&&n.nodeName(a,"input")){var c=a.value;return a.setAttribute("type",b),c&&(a.value=c),b}}}},removeAttr:function(a,b){var c,d,e=0,f=b&&b.match(G);if(f&&1===a.nodeType){while(c=f[e++]){d=n.propFix[c]||c,n.expr.match.bool.test(c)?yb&&xb||!wb.test(c)?a[d]=!1:a[n.camelCase("default-"+c)]=a[d]=!1:n.attr(a,c,""),a.removeAttribute(xb?c:d)}}}}),ub={set:function(a,b,c){return b===!1?n.removeAttr(a,c):yb&&xb||!wb.test(c)?a.setAttribute(!xb&&n.propFix[c]||c,c):a[n.camelCase("default-"+c)]=a[c]=!0,c}},n.each(n.expr.match.bool.source.match(/\w+/g),function(a,b){var c=vb[b]||n.find.attr;yb&&xb||!wb.test(b)?vb[b]=function(a,b,d){var e,f;return d||(f=vb[b],vb[b]=e,e=null!=c(a,b,d)?b.toLowerCase():null,vb[b]=f),e}:vb[b]=function(a,b,c){return c?void 0:a[n.camelCase("default-"+b)]?b.toLowerCase():null}}),yb&&xb||(n.attrHooks.value={set:function(a,b,c){return n.nodeName(a,"input")?void (a.defaultValue=b):tb&&tb.set(a,b,c)}}),xb||(tb={set:function(a,b,c){var d=a.getAttributeNode(c);return d||a.setAttributeNode(d=a.ownerDocument.createAttribute(c)),d.value=b+="","value"===c||b===a.getAttribute(c)?b:void 0}},vb.id=vb.name=vb.coords=function(a,b,c){var d;return c?void 0:(d=a.getAttributeNode(b))&&""!==d.value?d.value:null},n.valHooks.button={get:function(a,b){var c=a.getAttributeNode(b);return c&&c.specified?c.value:void 0},set:tb.set},n.attrHooks.contenteditable={set:function(a,b,c){tb.set(a,""===b?!1:b,c)}},n.each(["width","height"],function(a,b){n.attrHooks[b]={set:function(a,c){return""===c?(a.setAttribute(b,"auto"),c):void 0}}})),l.style||(n.attrHooks.style={get:function(a){return a.style.cssText||void 0},set:function(a,b){return a.style.cssText=b+""}});var zb=/^(?:input|select|textarea|button|object)$/i,Ab=/^(?:a|area)$/i;n.fn.extend({prop:function(a,b){return Y(this,n.prop,a,b,arguments.length>1)
},removeProp:function(a){return a=n.propFix[a]||a,this.each(function(){try{this[a]=void 0,delete this[a]}catch(b){}})}}),n.extend({prop:function(a,b,c){var d,e,f=a.nodeType;if(3!==f&&8!==f&&2!==f){return 1===f&&n.isXMLDoc(a)||(b=n.propFix[b]||b,e=n.propHooks[b]),void 0!==c?e&&"set" in e&&void 0!==(d=e.set(a,c,b))?d:a[b]=c:e&&"get" in e&&null!==(d=e.get(a,b))?d:a[b]}},propHooks:{tabIndex:{get:function(a){var b=n.find.attr(a,"tabindex");return b?parseInt(b,10):zb.test(a.nodeName)||Ab.test(a.nodeName)&&a.href?0:-1}}},propFix:{"for":"htmlFor","class":"className"}}),l.hrefNormalized||n.each(["href","src"],function(a,b){n.propHooks[b]={get:function(a){return a.getAttribute(b,4)}}}),l.optSelected||(n.propHooks.selected={get:function(a){var b=a.parentNode;return b&&(b.selectedIndex,b.parentNode&&b.parentNode.selectedIndex),null},set:function(a){var b=a.parentNode;b&&(b.selectedIndex,b.parentNode&&b.parentNode.selectedIndex)}}),n.each(["tabIndex","readOnly","maxLength","cellSpacing","cellPadding","rowSpan","colSpan","useMap","frameBorder","contentEditable"],function(){n.propFix[this.toLowerCase()]=this}),l.enctype||(n.propFix.enctype="encoding");var Bb=/[\t\r\n\f]/g;function Cb(a){return n.attr(a,"class")||""}n.fn.extend({addClass:function(a){var b,c,d,e,f,g,h,i=0;if(n.isFunction(a)){return this.each(function(b){n(this).addClass(a.call(this,b,Cb(this)))})}if("string"==typeof a&&a){b=a.match(G)||[];while(c=this[i++]){if(e=Cb(c),d=1===c.nodeType&&(" "+e+" ").replace(Bb," ")){g=0;while(f=b[g++]){d.indexOf(" "+f+" ")<0&&(d+=f+" ")}h=n.trim(d),e!==h&&n.attr(c,"class",h)}}}return this},removeClass:function(a){var b,c,d,e,f,g,h,i=0;if(n.isFunction(a)){return this.each(function(b){n(this).removeClass(a.call(this,b,Cb(this)))})}if(!arguments.length){return this.attr("class","")}if("string"==typeof a&&a){b=a.match(G)||[];while(c=this[i++]){if(e=Cb(c),d=1===c.nodeType&&(" "+e+" ").replace(Bb," ")){g=0;while(f=b[g++]){while(d.indexOf(" "+f+" ")>-1){d=d.replace(" "+f+" "," ")}}h=n.trim(d),e!==h&&n.attr(c,"class",h)}}}return this},toggleClass:function(a,b){var c=typeof a;return"boolean"==typeof b&&"string"===c?b?this.addClass(a):this.removeClass(a):n.isFunction(a)?this.each(function(c){n(this).toggleClass(a.call(this,c,Cb(this),b),b)}):this.each(function(){var b,d,e,f;if("string"===c){d=0,e=n(this),f=a.match(G)||[];while(b=f[d++]){e.hasClass(b)?e.removeClass(b):e.addClass(b)}}else{void 0!==a&&"boolean"!==c||(b=Cb(this),b&&n._data(this,"__className__",b),n.attr(this,"class",b||a===!1?"":n._data(this,"__className__")||""))}})},hasClass:function(a){var b,c,d=0;b=" "+a+" ";while(c=this[d++]){if(1===c.nodeType&&(" "+Cb(c)+" ").replace(Bb," ").indexOf(b)>-1){return !0}}return !1}}),n.each("blur focus focusin focusout load resize scroll unload click dblclick mousedown mouseup mousemove mouseover mouseout mouseenter mouseleave change select submit keydown keypress keyup error contextmenu".split(" "),function(a,b){n.fn[b]=function(a,c){return arguments.length>0?this.on(b,null,a,c):this.trigger(b)}}),n.fn.extend({hover:function(a,b){return this.mouseenter(a).mouseleave(b||a)}});var Db=a.location,Eb=n.now(),Fb=/\?/,Gb=/(,)|(\[|{)|(}|])|"(?:[^"\\\r\n]|\\["\\\/bfnrt]|\\u[\da-fA-F]{4})*"\s*:?|true|false|null|-?(?!0\d)\d+(?:\.\d+|)(?:[eE][+-]?\d+|)/g;n.parseJSON=function(b){if(a.JSON&&a.JSON.parse){return a.JSON.parse(b+"")}var c,d=null,e=n.trim(b+"");return e&&!n.trim(e.replace(Gb,function(a,b,e,f){return c&&b&&(d=0),0===d?a:(c=e||b,d+=!f-!e,"")}))?Function("return "+e)():n.error("Invalid JSON: "+b)},n.parseXML=function(b){var c,d;if(!b||"string"!=typeof b){return null}try{a.DOMParser?(d=new a.DOMParser,c=d.parseFromString(b,"text/xml")):(c=new a.ActiveXObject("Microsoft.XMLDOM"),c.async="false",c.loadXML(b))}catch(e){c=void 0}return c&&c.documentElement&&!c.getElementsByTagName("parsererror").length||n.error("Invalid XML: "+b),c};var Hb=/#.*$/,Ib=/([?&])_=[^&]*/,Jb=/^(.*?):[ \t]*([^\r\n]*)\r?$/gm,Kb=/^(?:about|app|app-storage|.+-extension|file|res|widget):$/,Lb=/^(?:GET|HEAD)$/,Mb=/^\/\//,Nb=/^([\w.+-]+:)(?:\/\/(?:[^\/?#]*@|)([^\/?#:]*)(?::(\d+)|)|)/,Ob={},Pb={},Qb="*/".concat("*"),Rb=Db.href,Sb=Nb.exec(Rb.toLowerCase())||[];function Tb(a){return function(b,c){"string"!=typeof b&&(c=b,b="*");var d,e=0,f=b.toLowerCase().match(G)||[];if(n.isFunction(c)){while(d=f[e++]){"+"===d.charAt(0)?(d=d.slice(1)||"*",(a[d]=a[d]||[]).unshift(c)):(a[d]=a[d]||[]).push(c)}}}}function Ub(a,b,c,d){var e={},f=a===Pb;function g(h){var i;return e[h]=!0,n.each(a[h]||[],function(a,h){var j=h(b,c,d);return"string"!=typeof j||f||e[j]?f?!(i=j):void 0:(b.dataTypes.unshift(j),g(j),!1)}),i}return g(b.dataTypes[0])||!e["*"]&&g("*")}function Vb(a,b){var c,d,e=n.ajaxSettings.flatOptions||{};for(d in b){void 0!==b[d]&&((e[d]?a:c||(c={}))[d]=b[d])}return c&&n.extend(!0,a,c),a}function Wb(a,b,c){var d,e,f,g,h=a.contents,i=a.dataTypes;while("*"===i[0]){i.shift(),void 0===e&&(e=a.mimeType||b.getResponseHeader("Content-Type"))}if(e){for(g in h){if(h[g]&&h[g].test(e)){i.unshift(g);break
}}}if(i[0] in c){f=i[0]}else{for(g in c){if(!i[0]||a.converters[g+" "+i[0]]){f=g;break}d||(d=g)}f=f||d}return f?(f!==i[0]&&i.unshift(f),c[f]):void 0}function Xb(a,b,c,d){var e,f,g,h,i,j={},k=a.dataTypes.slice();if(k[1]){for(g in a.converters){j[g.toLowerCase()]=a.converters[g]}}f=k.shift();while(f){if(a.responseFields[f]&&(c[a.responseFields[f]]=b),!i&&d&&a.dataFilter&&(b=a.dataFilter(b,a.dataType)),i=f,f=k.shift()){if("*"===f){f=i}else{if("*"!==i&&i!==f){if(g=j[i+" "+f]||j["* "+f],!g){for(e in j){if(h=e.split(" "),h[1]===f&&(g=j[i+" "+h[0]]||j["* "+h[0]])){g===!0?g=j[e]:j[e]!==!0&&(f=h[0],k.unshift(h[1]));break}}}if(g!==!0){if(g&&a["throws"]){b=g(b)}else{try{b=g(b)}catch(l){return{state:"parsererror",error:g?l:"No conversion from "+i+" to "+f}}}}}}}}return{state:"success",data:b}}n.extend({active:0,lastModified:{},etag:{},ajaxSettings:{url:Rb,type:"GET",isLocal:Kb.test(Sb[1]),global:!0,processData:!0,async:!0,contentType:"application/x-www-form-urlencoded; charset=UTF-8",accepts:{"*":Qb,text:"text/plain",html:"text/html",xml:"application/xml, text/xml",json:"application/json, text/javascript"},contents:{xml:/\bxml\b/,html:/\bhtml/,json:/\bjson\b/},responseFields:{xml:"responseXML",text:"responseText",json:"responseJSON"},converters:{"* text":String,"text html":!0,"text json":n.parseJSON,"text xml":n.parseXML},flatOptions:{url:!0,context:!0}},ajaxSetup:function(a,b){return b?Vb(Vb(a,n.ajaxSettings),b):Vb(n.ajaxSettings,a)},ajaxPrefilter:Tb(Ob),ajaxTransport:Tb(Pb),ajax:function(b,c){"object"==typeof b&&(c=b,b=void 0),c=c||{};var d,e,f,g,h,i,j,k,l=n.ajaxSetup({},c),m=l.context||l,o=l.context&&(m.nodeType||m.jquery)?n(m):n.event,p=n.Deferred(),q=n.Callbacks("once memory"),r=l.statusCode||{},s={},t={},u=0,v="canceled",w={readyState:0,getResponseHeader:function(a){var b;if(2===u){if(!k){k={};while(b=Jb.exec(g)){k[b[1].toLowerCase()]=b[2]}}b=k[a.toLowerCase()]}return null==b?null:b},getAllResponseHeaders:function(){return 2===u?g:null},setRequestHeader:function(a,b){var c=a.toLowerCase();return u||(a=t[c]=t[c]||a,s[a]=b),this},overrideMimeType:function(a){return u||(l.mimeType=a),this},statusCode:function(a){var b;if(a){if(2>u){for(b in a){r[b]=[r[b],a[b]]}}else{w.always(a[w.status])}}return this},abort:function(a){var b=a||v;return j&&j.abort(b),y(0,b),this}};if(p.promise(w).complete=q.add,w.success=w.done,w.error=w.fail,l.url=((b||l.url||Rb)+"").replace(Hb,"").replace(Mb,Sb[1]+"//"),l.type=c.method||c.type||l.method||l.type,l.dataTypes=n.trim(l.dataType||"*").toLowerCase().match(G)||[""],null==l.crossDomain&&(d=Nb.exec(l.url.toLowerCase()),l.crossDomain=!(!d||d[1]===Sb[1]&&d[2]===Sb[2]&&(d[3]||("http:"===d[1]?"80":"443"))===(Sb[3]||("http:"===Sb[1]?"80":"443")))),l.data&&l.processData&&"string"!=typeof l.data&&(l.data=n.param(l.data,l.traditional)),Ub(Ob,l,c,w),2===u){return w}i=n.event&&l.global,i&&0===n.active++&&n.event.trigger("ajaxStart"),l.type=l.type.toUpperCase(),l.hasContent=!Lb.test(l.type),f=l.url,l.hasContent||(l.data&&(f=l.url+=(Fb.test(f)?"&":"?")+l.data,delete l.data),l.cache===!1&&(l.url=Ib.test(f)?f.replace(Ib,"$1_="+Eb++):f+(Fb.test(f)?"&":"?")+"_="+Eb++)),l.ifModified&&(n.lastModified[f]&&w.setRequestHeader("If-Modified-Since",n.lastModified[f]),n.etag[f]&&w.setRequestHeader("If-None-Match",n.etag[f])),(l.data&&l.hasContent&&l.contentType!==!1||c.contentType)&&w.setRequestHeader("Content-Type",l.contentType),w.setRequestHeader("Accept",l.dataTypes[0]&&l.accepts[l.dataTypes[0]]?l.accepts[l.dataTypes[0]]+("*"!==l.dataTypes[0]?", "+Qb+"; q=0.01":""):l.accepts["*"]);for(e in l.headers){w.setRequestHeader(e,l.headers[e])}if(l.beforeSend&&(l.beforeSend.call(m,w,l)===!1||2===u)){return w.abort()}v="abort";for(e in {success:1,error:1,complete:1}){w[e](l[e])}if(j=Ub(Pb,l,c,w)){if(w.readyState=1,i&&o.trigger("ajaxSend",[w,l]),2===u){return w}l.async&&l.timeout>0&&(h=a.setTimeout(function(){w.abort("timeout")},l.timeout));try{u=1,j.send(s,y)}catch(x){if(!(2>u)){throw x}y(-1,x)}}else{y(-1,"No Transport")}function y(b,c,d,e){var k,s,t,v,x,y=c;2!==u&&(u=2,h&&a.clearTimeout(h),j=void 0,g=e||"",w.readyState=b>0?4:0,k=b>=200&&300>b||304===b,d&&(v=Wb(l,w,d)),v=Xb(l,v,w,k),k?(l.ifModified&&(x=w.getResponseHeader("Last-Modified"),x&&(n.lastModified[f]=x),x=w.getResponseHeader("etag"),x&&(n.etag[f]=x)),204===b||"HEAD"===l.type?y="nocontent":304===b?y="notmodified":(y=v.state,s=v.data,t=v.error,k=!t)):(t=y,!b&&y||(y="error",0>b&&(b=0))),w.status=b,w.statusText=(c||y)+"",k?p.resolveWith(m,[s,y,w]):p.rejectWith(m,[w,y,t]),w.statusCode(r),r=void 0,i&&o.trigger(k?"ajaxSuccess":"ajaxError",[w,l,k?s:t]),q.fireWith(m,[w,y]),i&&(o.trigger("ajaxComplete",[w,l]),--n.active||n.event.trigger("ajaxStop")))}return w},getJSON:function(a,b,c){return n.get(a,b,c,"json")},getScript:function(a,b){return n.get(a,void 0,b,"script")}}),n.each(["get","post"],function(a,b){n[b]=function(a,c,d,e){return n.isFunction(c)&&(e=e||d,d=c,c=void 0),n.ajax(n.extend({url:a,type:b,dataType:e,data:c,success:d},n.isPlainObject(a)&&a))}}),n._evalUrl=function(a){return n.ajax({url:a,type:"GET",dataType:"script",cache:!0,async:!1,global:!1,"throws":!0})
},n.fn.extend({wrapAll:function(a){if(n.isFunction(a)){return this.each(function(b){n(this).wrapAll(a.call(this,b))})}if(this[0]){var b=n(a,this[0].ownerDocument).eq(0).clone(!0);this[0].parentNode&&b.insertBefore(this[0]),b.map(function(){var a=this;while(a.firstChild&&1===a.firstChild.nodeType){a=a.firstChild}return a}).append(this)}return this},wrapInner:function(a){return n.isFunction(a)?this.each(function(b){n(this).wrapInner(a.call(this,b))}):this.each(function(){var b=n(this),c=b.contents();c.length?c.wrapAll(a):b.append(a)})},wrap:function(a){var b=n.isFunction(a);return this.each(function(c){n(this).wrapAll(b?a.call(this,c):a)})},unwrap:function(){return this.parent().each(function(){n.nodeName(this,"body")||n(this).replaceWith(this.childNodes)}).end()}});function Yb(a){return a.style&&a.style.display||n.css(a,"display")}function Zb(a){if(!n.contains(a.ownerDocument||d,a)){return !0}while(a&&1===a.nodeType){if("none"===Yb(a)||"hidden"===a.type){return !0}a=a.parentNode}return !1}n.expr.filters.hidden=function(a){return l.reliableHiddenOffsets()?a.offsetWidth<=0&&a.offsetHeight<=0&&!a.getClientRects().length:Zb(a)},n.expr.filters.visible=function(a){return !n.expr.filters.hidden(a)};var $b=/%20/g,_b=/\[\]$/,ac=/\r?\n/g,bc=/^(?:submit|button|image|reset|file)$/i,cc=/^(?:input|select|textarea|keygen)/i;function dc(a,b,c,d){var e;if(n.isArray(b)){n.each(b,function(b,e){c||_b.test(a)?d(a,e):dc(a+"["+("object"==typeof e&&null!=e?b:"")+"]",e,c,d)})}else{if(c||"object"!==n.type(b)){d(a,b)}else{for(e in b){dc(a+"["+e+"]",b[e],c,d)}}}}n.param=function(a,b){var c,d=[],e=function(a,b){b=n.isFunction(b)?b():null==b?"":b,d[d.length]=encodeURIComponent(a)+"="+encodeURIComponent(b)};if(void 0===b&&(b=n.ajaxSettings&&n.ajaxSettings.traditional),n.isArray(a)||a.jquery&&!n.isPlainObject(a)){n.each(a,function(){e(this.name,this.value)})}else{for(c in a){dc(c,a[c],b,e)}}return d.join("&").replace($b,"+")},n.fn.extend({serialize:function(){return n.param(this.serializeArray())},serializeArray:function(){return this.map(function(){var a=n.prop(this,"elements");return a?n.makeArray(a):this}).filter(function(){var a=this.type;return this.name&&!n(this).is(":disabled")&&cc.test(this.nodeName)&&!bc.test(a)&&(this.checked||!Z.test(a))}).map(function(a,b){var c=n(this).val();return null==c?null:n.isArray(c)?n.map(c,function(a){return{name:b.name,value:a.replace(ac,"\r\n")}}):{name:b.name,value:c.replace(ac,"\r\n")}}).get()}}),n.ajaxSettings.xhr=void 0!==a.ActiveXObject?function(){return this.isLocal?ic():d.documentMode>8?hc():/^(get|post|head|put|delete|options)$/i.test(this.type)&&hc()||ic()}:hc;var ec=0,fc={},gc=n.ajaxSettings.xhr();a.attachEvent&&a.attachEvent("onunload",function(){for(var a in fc){fc[a](void 0,!0)}}),l.cors=!!gc&&"withCredentials" in gc,gc=l.ajax=!!gc,gc&&n.ajaxTransport(function(b){if(!b.crossDomain||l.cors){var c;return{send:function(d,e){var f,g=b.xhr(),h=++ec;if(g.open(b.type,b.url,b.async,b.username,b.password),b.xhrFields){for(f in b.xhrFields){g[f]=b.xhrFields[f]}}b.mimeType&&g.overrideMimeType&&g.overrideMimeType(b.mimeType),b.crossDomain||d["X-Requested-With"]||(d["X-Requested-With"]="XMLHttpRequest");for(f in d){void 0!==d[f]&&g.setRequestHeader(f,d[f]+"")}g.send(b.hasContent&&b.data||null),c=function(a,d){var f,i,j;if(c&&(d||4===g.readyState)){if(delete fc[h],c=void 0,g.onreadystatechange=n.noop,d){4!==g.readyState&&g.abort()}else{j={},f=g.status,"string"==typeof g.responseText&&(j.text=g.responseText);try{i=g.statusText}catch(k){i=""}f||!b.isLocal||b.crossDomain?1223===f&&(f=204):f=j.text?200:404}}j&&e(f,i,j,g.getAllResponseHeaders())},b.async?4===g.readyState?a.setTimeout(c):g.onreadystatechange=fc[h]=c:c()},abort:function(){c&&c(void 0,!0)}}}});function hc(){try{return new a.XMLHttpRequest}catch(b){}}function ic(){try{return new a.ActiveXObject("Microsoft.XMLHTTP")}catch(b){}}n.ajaxSetup({accepts:{script:"text/javascript, application/javascript, application/ecmascript, application/x-ecmascript"},contents:{script:/\b(?:java|ecma)script\b/},converters:{"text script":function(a){return n.globalEval(a),a}}}),n.ajaxPrefilter("script",function(a){void 0===a.cache&&(a.cache=!1),a.crossDomain&&(a.type="GET",a.global=!1)}),n.ajaxTransport("script",function(a){if(a.crossDomain){var b,c=d.head||n("head")[0]||d.documentElement;return{send:function(e,f){b=d.createElement("script"),b.async=!0,a.scriptCharset&&(b.charset=a.scriptCharset),b.src=a.url,b.onload=b.onreadystatechange=function(a,c){(c||!b.readyState||/loaded|complete/.test(b.readyState))&&(b.onload=b.onreadystatechange=null,b.parentNode&&b.parentNode.removeChild(b),b=null,c||f(200,"success"))},c.insertBefore(b,c.firstChild)},abort:function(){b&&b.onload(void 0,!0)}}}});var jc=[],kc=/(=)\?(?=&|$)|\?\?/;n.ajaxSetup({jsonp:"callback",jsonpCallback:function(){var a=jc.pop()||n.expando+"_"+Eb++;return this[a]=!0,a}}),n.ajaxPrefilter("json jsonp",function(b,c,d){var e,f,g,h=b.jsonp!==!1&&(kc.test(b.url)?"url":"string"==typeof b.data&&0===(b.contentType||"").indexOf("application/x-www-form-urlencoded")&&kc.test(b.data)&&"data");
return h||"jsonp"===b.dataTypes[0]?(e=b.jsonpCallback=n.isFunction(b.jsonpCallback)?b.jsonpCallback():b.jsonpCallback,h?b[h]=b[h].replace(kc,"$1"+e):b.jsonp!==!1&&(b.url+=(Fb.test(b.url)?"&":"?")+b.jsonp+"="+e),b.converters["script json"]=function(){return g||n.error(e+" was not called"),g[0]},b.dataTypes[0]="json",f=a[e],a[e]=function(){g=arguments},d.always(function(){void 0===f?n(a).removeProp(e):a[e]=f,b[e]&&(b.jsonpCallback=c.jsonpCallback,jc.push(e)),g&&n.isFunction(f)&&f(g[0]),g=f=void 0}),"script"):void 0}),n.parseHTML=function(a,b,c){if(!a||"string"!=typeof a){return null}"boolean"==typeof b&&(c=b,b=!1),b=b||d;var e=x.exec(a),f=!c&&[];return e?[b.createElement(e[1])]:(e=ja([a],b,f),f&&f.length&&n(f).remove(),n.merge([],e.childNodes))};var lc=n.fn.load;n.fn.load=function(a,b,c){if("string"!=typeof a&&lc){return lc.apply(this,arguments)}var d,e,f,g=this,h=a.indexOf(" ");return h>-1&&(d=n.trim(a.slice(h,a.length)),a=a.slice(0,h)),n.isFunction(b)?(c=b,b=void 0):b&&"object"==typeof b&&(e="POST"),g.length>0&&n.ajax({url:a,type:e||"GET",dataType:"html",data:b}).done(function(a){f=arguments,g.html(d?n("<div>").append(n.parseHTML(a)).find(d):a)}).always(c&&function(a,b){g.each(function(){c.apply(this,f||[a.responseText,b,a])})}),this},n.each(["ajaxStart","ajaxStop","ajaxComplete","ajaxError","ajaxSuccess","ajaxSend"],function(a,b){n.fn[b]=function(a){return this.on(b,a)}}),n.expr.filters.animated=function(a){return n.grep(n.timers,function(b){return a===b.elem}).length};function mc(a){return n.isWindow(a)?a:9===a.nodeType?a.defaultView||a.parentWindow:!1}n.offset={setOffset:function(a,b,c){var d,e,f,g,h,i,j,k=n.css(a,"position"),l=n(a),m={};"static"===k&&(a.style.position="relative"),h=l.offset(),f=n.css(a,"top"),i=n.css(a,"left"),j=("absolute"===k||"fixed"===k)&&n.inArray("auto",[f,i])>-1,j?(d=l.position(),g=d.top,e=d.left):(g=parseFloat(f)||0,e=parseFloat(i)||0),n.isFunction(b)&&(b=b.call(a,c,n.extend({},h))),null!=b.top&&(m.top=b.top-h.top+g),null!=b.left&&(m.left=b.left-h.left+e),"using" in b?b.using.call(a,m):l.css(m)}},n.fn.extend({offset:function(a){if(arguments.length){return void 0===a?this:this.each(function(b){n.offset.setOffset(this,a,b)})}var b,c,d={top:0,left:0},e=this[0],f=e&&e.ownerDocument;if(f){return b=f.documentElement,n.contains(b,e)?("undefined"!=typeof e.getBoundingClientRect&&(d=e.getBoundingClientRect()),c=mc(f),{top:d.top+(c.pageYOffset||b.scrollTop)-(b.clientTop||0),left:d.left+(c.pageXOffset||b.scrollLeft)-(b.clientLeft||0)}):d}},position:function(){if(this[0]){var a,b,c={top:0,left:0},d=this[0];return"fixed"===n.css(d,"position")?b=d.getBoundingClientRect():(a=this.offsetParent(),b=this.offset(),n.nodeName(a[0],"html")||(c=a.offset()),c.top+=n.css(a[0],"borderTopWidth",!0),c.left+=n.css(a[0],"borderLeftWidth",!0)),{top:b.top-c.top-n.css(d,"marginTop",!0),left:b.left-c.left-n.css(d,"marginLeft",!0)}}},offsetParent:function(){return this.map(function(){var a=this.offsetParent;while(a&&!n.nodeName(a,"html")&&"static"===n.css(a,"position")){a=a.offsetParent}return a||Qa})}}),n.each({scrollLeft:"pageXOffset",scrollTop:"pageYOffset"},function(a,b){var c=/Y/.test(b);n.fn[a]=function(d){return Y(this,function(a,d,e){var f=mc(a);return void 0===e?f?b in f?f[b]:f.document.documentElement[d]:a[d]:void (f?f.scrollTo(c?n(f).scrollLeft():e,c?e:n(f).scrollTop()):a[d]=e)},a,d,arguments.length,null)}}),n.each(["top","left"],function(a,b){n.cssHooks[b]=Ua(l.pixelPosition,function(a,c){return c?(c=Sa(a,b),Oa.test(c)?n(a).position()[b]+"px":c):void 0})}),n.each({Height:"height",Width:"width"},function(a,b){n.each({padding:"inner"+a,content:b,"":"outer"+a},function(c,d){n.fn[d]=function(d,e){var f=arguments.length&&(c||"boolean"!=typeof d),g=c||(d===!0||e===!0?"margin":"border");return Y(this,function(b,c,d){var e;return n.isWindow(b)?b.document.documentElement["client"+a]:9===b.nodeType?(e=b.documentElement,Math.max(b.body["scroll"+a],e["scroll"+a],b.body["offset"+a],e["offset"+a],e["client"+a])):void 0===d?n.css(b,c,g):n.style(b,c,d,g)},b,f?d:void 0,f,null)}})}),n.fn.extend({bind:function(a,b,c){return this.on(a,null,b,c)},unbind:function(a,b){return this.off(a,null,b)},delegate:function(a,b,c,d){return this.on(b,a,c,d)},undelegate:function(a,b,c){return 1===arguments.length?this.off(a,"**"):this.off(b,a||"**",c)}}),n.fn.size=function(){return this.length},n.fn.andSelf=n.fn.addBack,"function"==typeof define&&define.amd&&define("jquery",[],function(){return n});var nc=a.jQuery,oc=a.$;return n.noConflict=function(b){return a.$===n&&(a.$=oc),b&&a.jQuery===n&&(a.jQuery=nc),n},b||(a.jQuery=a.$=n),n});

(function($){
    //备份jquery的ajax方法
    var _ajax=$.ajax;
     
    //重写jquery的ajax方法
    $.ajax=function(opt){
        //备份opt中error和success方法
        var fn = {
            error:function(XMLHttpRequest, textStatus, errorThrown){},
            success:function(data, textStatus){}
        }
        if(opt.error){
            fn.error=opt.error;
        }
        if(opt.success){
            fn.success=opt.success;
        }
         
        //扩展错误和成功的回调
        var _opt = $.extend(opt,{
            error:function(data, textStatus, errorThrown){
            	ext.loading.hide();
                //错误方法增强处理
                if(data.readyState==0){
            		ext.tip.error(shutdown);
            		return;
            	}
            	fn.error(XMLHttpRequest, textStatus, errorThrown);
            },
            success:function(data, textStatus){
            	ext.loading.hide();
            	//会话过期
            	try {
            		if(data.code==EXPIRED){
            			ext.tip.error(expired);
                		setTimeout(function(){
            				top.location.href=path;
            			}, 1000);
            		}
				} catch (e) {}
								
				try {
					fn.success(data,textStatus);
				} catch (e) {}
				
            },
            beforeSend:function(XHR){
                //提交前回调方法
            	XHR.setRequestHeader("factory:'"+factory+"'");
            	
            },
            headers:{'factory':factory},
            complete:function(XHR, TS){
                //请求完成后回调函数 (请求成功或失败之后均调用)
            }
        });
        _ajax(_opt);
    };
})(jQuery);

/**
 * EasyUI for jQuery 1.6.4
 * 
 * Copyright (c) 2009-2018 www.jeasyui.com. All rights reserved.
 *
 * Licensed under the freeware license: http://www.jeasyui.com/license_freeware.php
 * To use it on other terms please contact us: info@jeasyui.com
 *
 */
(function($){
$.easyui={indexOfArray:function(a,o,id){
for(var i=0,_1=a.length;i<_1;i++){
if(id==undefined){
if(a[i]==o){
return i;
}
}else{
if(a[i][o]==id){
return i;
}
}
}
return -1;
},removeArrayItem:function(a,o,id){
if(typeof o=="string"){
for(var i=0,_2=a.length;i<_2;i++){
if(a[i][o]==id){
a.splice(i,1);
return;
}
}
}else{
var _3=this.indexOfArray(a,o);
if(_3!=-1){
a.splice(_3,1);
}
}
},addArrayItem:function(a,o,r){
var _4=this.indexOfArray(a,o,r?r[o]:undefined);
if(_4==-1){
a.push(r?r:o);
}else{
a[_4]=r?r:o;
}
},getArrayItem:function(a,o,id){
var _5=this.indexOfArray(a,o,id);
return _5==-1?null:a[_5];
},forEach:function(_6,_7,_8){
var _9=[];
for(var i=0;i<_6.length;i++){
_9.push(_6[i]);
}
while(_9.length){
var _a=_9.shift();
if(_8(_a)==false){
return;
}
if(_7&&_a.children){
for(var i=_a.children.length-1;i>=0;i--){
_9.unshift(_a.children[i]);
}
}
}
}};
$.parser={auto:true,onComplete:function(_b){
},plugins:["draggable","droppable","resizable","pagination","tooltip","linkbutton","menu","sidemenu","menubutton","splitbutton","switchbutton","progressbar","radiobutton","checkbox","tree","textbox","passwordbox","maskedbox","filebox","combo","combobox","combotree","combogrid","combotreegrid","tagbox","numberbox","validatebox","searchbox","spinner","numberspinner","timespinner","datetimespinner","calendar","datebox","datetimebox","slider","layout","panel","datagrid","propertygrid","treegrid","datalist","tabs","accordion","window","dialog","form"],parse:function(_c){
var aa=[];
for(var i=0;i<$.parser.plugins.length;i++){
var _d=$.parser.plugins[i];
var r=$(".easyui-"+_d,_c);
if(r.length){
if(r[_d]){
r.each(function(){
$(this)[_d]($.data(this,"options")||{});
});
}else{
aa.push({name:_d,jq:r});
}
}
}
if(aa.length&&window.easyloader){
var _e=[];
for(var i=0;i<aa.length;i++){
_e.push(aa[i].name);
}
easyloader.load(_e,function(){
for(var i=0;i<aa.length;i++){
var _f=aa[i].name;
var jq=aa[i].jq;
jq.each(function(){
$(this)[_f]($.data(this,"options")||{});
});
}
$.parser.onComplete.call($.parser,_c);
});
}else{
$.parser.onComplete.call($.parser,_c);
}
},parseValue:function(_10,_11,_12,_13){
_13=_13||0;
var v=$.trim(String(_11||""));
var _14=v.substr(v.length-1,1);
if(_14=="%"){
v=parseFloat(v.substr(0,v.length-1));
if(_10.toLowerCase().indexOf("width")>=0){
v=Math.floor((_12.width()-_13)*v/100);
}else{
v=Math.floor((_12.height()-_13)*v/100);
}
}else{
v=parseInt(v)||undefined;
}
return v;
},parseOptions:function(_15,_16){
var t=$(_15);
var _17={};
var s=$.trim(t.attr("data-options"));
if(s){
if(s.substring(0,1)!="{"){
s="{"+s+"}";
}
_17=(new Function("return "+s))();
}
$.map(["width","height","left","top","minWidth","maxWidth","minHeight","maxHeight"],function(p){
var pv=$.trim(_15.style[p]||"");
if(pv){
if(pv.indexOf("%")==-1){
pv=parseInt(pv);
if(isNaN(pv)){
pv=undefined;
}
}
_17[p]=pv;
}
});
if(_16){
var _18={};
for(var i=0;i<_16.length;i++){
var pp=_16[i];
if(typeof pp=="string"){
_18[pp]=t.attr(pp);
}else{
for(var _19 in pp){
var _1a=pp[_19];
if(_1a=="boolean"){
_18[_19]=t.attr(_19)?(t.attr(_19)=="true"):undefined;
}else{
if(_1a=="number"){
_18[_19]=t.attr(_19)=="0"?0:parseFloat(t.attr(_19))||undefined;
}
}
}
}
}
$.extend(_17,_18);
}
return _17;
}};
$(function(){
var d=$("<div style=\"position:absolute;top:-1000px;width:100px;height:100px;padding:5px\"></div>").appendTo("body");
$._boxModel=d.outerWidth()!=100;
d.remove();
d=$("<div style=\"position:fixed\"></div>").appendTo("body");
$._positionFixed=(d.css("position")=="fixed");
d.remove();
if(!window.easyloader&&$.parser.auto){
$.parser.parse();
}
});
$.fn._outerWidth=function(_1b){
if(_1b==undefined){
if(this[0]==window){
return this.width()||document.body.clientWidth;
}
return this.outerWidth()||0;
}
return this._size("width",_1b);
};
$.fn._outerHeight=function(_1c){
if(_1c==undefined){
if(this[0]==window){
return this.height()||document.body.clientHeight;
}
return this.outerHeight()||0;
}
return this._size("height",_1c);
};
$.fn._scrollLeft=function(_1d){
if(_1d==undefined){
return this.scrollLeft();
}else{
return this.each(function(){
$(this).scrollLeft(_1d);
});
}
};
$.fn._propAttr=$.fn.prop||$.fn.attr;
$.fn._size=function(_1e,_1f){
if(typeof _1e=="string"){
if(_1e=="clear"){
return this.each(function(){
$(this).css({width:"",minWidth:"",maxWidth:"",height:"",minHeight:"",maxHeight:""});
});
}else{
if(_1e=="fit"){
return this.each(function(){
_20(this,this.tagName=="BODY"?$("body"):$(this).parent(),true);
});
}else{
if(_1e=="unfit"){
return this.each(function(){
_20(this,$(this).parent(),false);
});
}else{
if(_1f==undefined){
return _21(this[0],_1e);
}else{
return this.each(function(){
_21(this,_1e,_1f);
});
}
}
}
}
}else{
return this.each(function(){
_1f=_1f||$(this).parent();
$.extend(_1e,_20(this,_1f,_1e.fit)||{});
var r1=_22(this,"width",_1f,_1e);
var r2=_22(this,"height",_1f,_1e);
if(r1||r2){
$(this).addClass("easyui-fluid");
}else{
$(this).removeClass("easyui-fluid");
}
});
}
function _20(_23,_24,fit){
if(!_24.length){
return false;
}
var t=$(_23)[0];
var p=_24[0];
var _25=p.fcount||0;
if(fit){
if(!t.fitted){
t.fitted=true;
p.fcount=_25+1;
$(p).addClass("panel-noscroll");
if(p.tagName=="BODY"){
$("html").addClass("panel-fit");
}
}
return {width:($(p).width()||1),height:($(p).height()||1)};
}else{
if(t.fitted){
t.fitted=false;
p.fcount=_25-1;
if(p.fcount==0){
$(p).removeClass("panel-noscroll");
if(p.tagName=="BODY"){
$("html").removeClass("panel-fit");
}
}
}
return false;
}
};
function _22(_26,_27,_28,_29){
var t=$(_26);
var p=_27;
var p1=p.substr(0,1).toUpperCase()+p.substr(1);
var min=$.parser.parseValue("min"+p1,_29["min"+p1],_28);
var max=$.parser.parseValue("max"+p1,_29["max"+p1],_28);
var val=$.parser.parseValue(p,_29[p],_28);
var _2a=(String(_29[p]||"").indexOf("%")>=0?true:false);
if(!isNaN(val)){
var v=Math.min(Math.max(val,min||0),max||99999);
if(!_2a){
_29[p]=v;
}
t._size("min"+p1,"");
t._size("max"+p1,"");
t._size(p,v);
}else{
t._size(p,"");
t._size("min"+p1,min);
t._size("max"+p1,max);
}
return _2a||_29.fit;
};
function _21(_2b,_2c,_2d){
var t=$(_2b);
if(_2d==undefined){
_2d=parseInt(_2b.style[_2c]);
if(isNaN(_2d)){
return undefined;
}
if($._boxModel){
_2d+=_2e();
}
return _2d;
}else{
if(_2d===""){
t.css(_2c,"");
}else{
if($._boxModel){
_2d-=_2e();
if(_2d<0){
_2d=0;
}
}
t.css(_2c,_2d+"px");
}
}
function _2e(){
if(_2c.toLowerCase().indexOf("width")>=0){
return t.outerWidth()-t.width();
}else{
return t.outerHeight()-t.height();
}
};
};
};
})(jQuery);
(function($){
var _2f=null;
var _30=null;
var _31=false;
function _32(e){
if(e.touches.length!=1){
return;
}
if(!_31){
_31=true;
dblClickTimer=setTimeout(function(){
_31=false;
},500);
}else{
clearTimeout(dblClickTimer);
_31=false;
_33(e,"dblclick");
}
_2f=setTimeout(function(){
_33(e,"contextmenu",3);
},1000);
_33(e,"mousedown");
if($.fn.draggable.isDragging||$.fn.resizable.isResizing){
e.preventDefault();
}
};
function _34(e){
if(e.touches.length!=1){
return;
}
if(_2f){
clearTimeout(_2f);
}
_33(e,"mousemove");
if($.fn.draggable.isDragging||$.fn.resizable.isResizing){
e.preventDefault();
}
};
function _35(e){
if(_2f){
clearTimeout(_2f);
}
_33(e,"mouseup");
if($.fn.draggable.isDragging||$.fn.resizable.isResizing){
e.preventDefault();
}
};
function _33(e,_36,_37){
var _38=new $.Event(_36);
_38.pageX=e.changedTouches[0].pageX;
_38.pageY=e.changedTouches[0].pageY;
_38.which=_37||1;
$(e.target).trigger(_38);
};
if(document.addEventListener){
document.addEventListener("touchstart",_32,true);
document.addEventListener("touchmove",_34,true);
document.addEventListener("touchend",_35,true);
}
})(jQuery);
(function($){
function _39(e){
var _3a=$.data(e.data.target,"draggable");
var _3b=_3a.options;
var _3c=_3a.proxy;
var _3d=e.data;
var _3e=_3d.startLeft+e.pageX-_3d.startX;
var top=_3d.startTop+e.pageY-_3d.startY;
if(_3c){
if(_3c.parent()[0]==document.body){
if(_3b.deltaX!=null&&_3b.deltaX!=undefined){
_3e=e.pageX+_3b.deltaX;
}else{
_3e=e.pageX-e.data.offsetWidth;
}
if(_3b.deltaY!=null&&_3b.deltaY!=undefined){
top=e.pageY+_3b.deltaY;
}else{
top=e.pageY-e.data.offsetHeight;
}
}else{
if(_3b.deltaX!=null&&_3b.deltaX!=undefined){
_3e+=e.data.offsetWidth+_3b.deltaX;
}
if(_3b.deltaY!=null&&_3b.deltaY!=undefined){
top+=e.data.offsetHeight+_3b.deltaY;
}
}
}
if(e.data.parent!=document.body){
_3e+=$(e.data.parent).scrollLeft();
top+=$(e.data.parent).scrollTop();
}
if(_3b.axis=="h"){
_3d.left=_3e;
}else{
if(_3b.axis=="v"){
_3d.top=top;
}else{
_3d.left=_3e;
_3d.top=top;
}
}
};
function _3f(e){
var _40=$.data(e.data.target,"draggable");
var _41=_40.options;
var _42=_40.proxy;
if(!_42){
_42=$(e.data.target);
}
_42.css({left:e.data.left,top:e.data.top});
$("body").css("cursor",_41.cursor);
};
function _43(e){
if(!$.fn.draggable.isDragging){
return false;
}
var _44=$.data(e.data.target,"draggable");
var _45=_44.options;
var _46=$(".droppable:visible").filter(function(){
return e.data.target!=this;
}).filter(function(){
var _47=$.data(this,"droppable").options.accept;
if(_47){
return $(_47).filter(function(){
return this==e.data.target;
}).length>0;
}else{
return true;
}
});
_44.droppables=_46;
var _48=_44.proxy;
if(!_48){
if(_45.proxy){
if(_45.proxy=="clone"){
_48=$(e.data.target).clone().insertAfter(e.data.target);
}else{
_48=_45.proxy.call(e.data.target,e.data.target);
}
_44.proxy=_48;
}else{
_48=$(e.data.target);
}
}
_48.css("position","absolute");
_39(e);
_3f(e);
_45.onStartDrag.call(e.data.target,e);
return false;
};
function _49(e){
if(!$.fn.draggable.isDragging){
return false;
}
var _4a=$.data(e.data.target,"draggable");
_39(e);
if(_4a.options.onDrag.call(e.data.target,e)!=false){
_3f(e);
}
var _4b=e.data.target;
_4a.droppables.each(function(){
var _4c=$(this);
if(_4c.droppable("options").disabled){
return;
}
var p2=_4c.offset();
if(e.pageX>p2.left&&e.pageX<p2.left+_4c.outerWidth()&&e.pageY>p2.top&&e.pageY<p2.top+_4c.outerHeight()){
if(!this.entered){
$(this).trigger("_dragenter",[_4b]);
this.entered=true;
}
$(this).trigger("_dragover",[_4b]);
}else{
if(this.entered){
$(this).trigger("_dragleave",[_4b]);
this.entered=false;
}
}
});
return false;
};
function _4d(e){
if(!$.fn.draggable.isDragging){
_4e();
return false;
}
_49(e);
var _4f=$.data(e.data.target,"draggable");
var _50=_4f.proxy;
var _51=_4f.options;
_51.onEndDrag.call(e.data.target,e);
if(_51.revert){
if(_52()==true){
$(e.data.target).css({position:e.data.startPosition,left:e.data.startLeft,top:e.data.startTop});
}else{
if(_50){
var _53,top;
if(_50.parent()[0]==document.body){
_53=e.data.startX-e.data.offsetWidth;
top=e.data.startY-e.data.offsetHeight;
}else{
_53=e.data.startLeft;
top=e.data.startTop;
}
_50.animate({left:_53,top:top},function(){
_54();
});
}else{
$(e.data.target).animate({left:e.data.startLeft,top:e.data.startTop},function(){
$(e.data.target).css("position",e.data.startPosition);
});
}
}
}else{
$(e.data.target).css({position:"absolute",left:e.data.left,top:e.data.top});
_52();
}
_51.onStopDrag.call(e.data.target,e);
_4e();
function _54(){
if(_50){
_50.remove();
}
_4f.proxy=null;
};
function _52(){
var _55=false;
_4f.droppables.each(function(){
var _56=$(this);
if(_56.droppable("options").disabled){
return;
}
var p2=_56.offset();
if(e.pageX>p2.left&&e.pageX<p2.left+_56.outerWidth()&&e.pageY>p2.top&&e.pageY<p2.top+_56.outerHeight()){
if(_51.revert){
$(e.data.target).css({position:e.data.startPosition,left:e.data.startLeft,top:e.data.startTop});
}
$(this).triggerHandler("_drop",[e.data.target]);
_54();
_55=true;
this.entered=false;
return false;
}
});
if(!_55&&!_51.revert){
_54();
}
return _55;
};
return false;
};
function _4e(){
if($.fn.draggable.timer){
clearTimeout($.fn.draggable.timer);
$.fn.draggable.timer=undefined;
}
$(document).unbind(".draggable");
$.fn.draggable.isDragging=false;
setTimeout(function(){
$("body").css("cursor","");
},100);
};
$.fn.draggable=function(_57,_58){
if(typeof _57=="string"){
return $.fn.draggable.methods[_57](this,_58);
}
return this.each(function(){
var _59;
var _5a=$.data(this,"draggable");
if(_5a){
_5a.handle.unbind(".draggable");
_59=$.extend(_5a.options,_57);
}else{
_59=$.extend({},$.fn.draggable.defaults,$.fn.draggable.parseOptions(this),_57||{});
}
var _5b=_59.handle?(typeof _59.handle=="string"?$(_59.handle,this):_59.handle):$(this);
$.data(this,"draggable",{options:_59,handle:_5b});
if(_59.disabled){
$(this).css("cursor","");
return;
}
_5b.unbind(".draggable").bind("mousemove.draggable",{target:this},function(e){
if($.fn.draggable.isDragging){
return;
}
var _5c=$.data(e.data.target,"draggable").options;
if(_5d(e)){
$(this).css("cursor",_5c.cursor);
}else{
$(this).css("cursor","");
}
}).bind("mouseleave.draggable",{target:this},function(e){
$(this).css("cursor","");
}).bind("mousedown.draggable",{target:this},function(e){
if(_5d(e)==false){
return;
}
$(this).css("cursor","");
var _5e=$(e.data.target).position();
var _5f=$(e.data.target).offset();
var _60={startPosition:$(e.data.target).css("position"),startLeft:_5e.left,startTop:_5e.top,left:_5e.left,top:_5e.top,startX:e.pageX,startY:e.pageY,width:$(e.data.target).outerWidth(),height:$(e.data.target).outerHeight(),offsetWidth:(e.pageX-_5f.left),offsetHeight:(e.pageY-_5f.top),target:e.data.target,parent:$(e.data.target).parent()[0]};
$.extend(e.data,_60);
var _61=$.data(e.data.target,"draggable").options;
if(_61.onBeforeDrag.call(e.data.target,e)==false){
return;
}
$(document).bind("mousedown.draggable",e.data,_43);
$(document).bind("mousemove.draggable",e.data,_49);
$(document).bind("mouseup.draggable",e.data,_4d);
$.fn.draggable.timer=setTimeout(function(){
$.fn.draggable.isDragging=true;
_43(e);
},_61.delay);
return false;
});
function _5d(e){
var _62=$.data(e.data.target,"draggable");
var _63=_62.handle;
var _64=$(_63).offset();
var _65=$(_63).outerWidth();
var _66=$(_63).outerHeight();
var t=e.pageY-_64.top;
var r=_64.left+_65-e.pageX;
var b=_64.top+_66-e.pageY;
var l=e.pageX-_64.left;
return Math.min(t,r,b,l)>_62.options.edge;
};
});
};
$.fn.draggable.methods={options:function(jq){
return $.data(jq[0],"draggable").options;
},proxy:function(jq){
return $.data(jq[0],"draggable").proxy;
},enable:function(jq){
return jq.each(function(){
$(this).draggable({disabled:false});
});
},disable:function(jq){
return jq.each(function(){
$(this).draggable({disabled:true});
});
}};
$.fn.draggable.parseOptions=function(_67){
var t=$(_67);
return $.extend({},$.parser.parseOptions(_67,["cursor","handle","axis",{"revert":"boolean","deltaX":"number","deltaY":"number","edge":"number","delay":"number"}]),{disabled:(t.attr("disabled")?true:undefined)});
};
$.fn.draggable.defaults={proxy:null,revert:false,cursor:"move",deltaX:null,deltaY:null,handle:null,disabled:false,edge:0,axis:null,delay:100,onBeforeDrag:function(e){
},onStartDrag:function(e){
},onDrag:function(e){
},onEndDrag:function(e){
},onStopDrag:function(e){
}};
$.fn.draggable.isDragging=false;
})(jQuery);
(function($){
function _68(_69){
$(_69).addClass("droppable");
$(_69).bind("_dragenter",function(e,_6a){
$.data(_69,"droppable").options.onDragEnter.apply(_69,[e,_6a]);
});
$(_69).bind("_dragleave",function(e,_6b){
$.data(_69,"droppable").options.onDragLeave.apply(_69,[e,_6b]);
});
$(_69).bind("_dragover",function(e,_6c){
$.data(_69,"droppable").options.onDragOver.apply(_69,[e,_6c]);
});
$(_69).bind("_drop",function(e,_6d){
$.data(_69,"droppable").options.onDrop.apply(_69,[e,_6d]);
});
};
$.fn.droppable=function(_6e,_6f){
if(typeof _6e=="string"){
return $.fn.droppable.methods[_6e](this,_6f);
}
_6e=_6e||{};
return this.each(function(){
var _70=$.data(this,"droppable");
if(_70){
$.extend(_70.options,_6e);
}else{
_68(this);
$.data(this,"droppable",{options:$.extend({},$.fn.droppable.defaults,$.fn.droppable.parseOptions(this),_6e)});
}
});
};
$.fn.droppable.methods={options:function(jq){
return $.data(jq[0],"droppable").options;
},enable:function(jq){
return jq.each(function(){
$(this).droppable({disabled:false});
});
},disable:function(jq){
return jq.each(function(){
$(this).droppable({disabled:true});
});
}};
$.fn.droppable.parseOptions=function(_71){
var t=$(_71);
return $.extend({},$.parser.parseOptions(_71,["accept"]),{disabled:(t.attr("disabled")?true:undefined)});
};
$.fn.droppable.defaults={accept:null,disabled:false,onDragEnter:function(e,_72){
},onDragOver:function(e,_73){
},onDragLeave:function(e,_74){
},onDrop:function(e,_75){
}};
})(jQuery);
(function($){
function _76(e){
var _77=e.data;
var _78=$.data(_77.target,"resizable").options;
if(_77.dir.indexOf("e")!=-1){
var _79=_77.startWidth+e.pageX-_77.startX;
_79=Math.min(Math.max(_79,_78.minWidth),_78.maxWidth);
_77.width=_79;
}
if(_77.dir.indexOf("s")!=-1){
var _7a=_77.startHeight+e.pageY-_77.startY;
_7a=Math.min(Math.max(_7a,_78.minHeight),_78.maxHeight);
_77.height=_7a;
}
if(_77.dir.indexOf("w")!=-1){
var _79=_77.startWidth-e.pageX+_77.startX;
_79=Math.min(Math.max(_79,_78.minWidth),_78.maxWidth);
_77.width=_79;
_77.left=_77.startLeft+_77.startWidth-_77.width;
}
if(_77.dir.indexOf("n")!=-1){
var _7a=_77.startHeight-e.pageY+_77.startY;
_7a=Math.min(Math.max(_7a,_78.minHeight),_78.maxHeight);
_77.height=_7a;
_77.top=_77.startTop+_77.startHeight-_77.height;
}
};
function _7b(e){
var _7c=e.data;
var t=$(_7c.target);
t.css({left:_7c.left,top:_7c.top});
if(t.outerWidth()!=_7c.width){
t._outerWidth(_7c.width);
}
if(t.outerHeight()!=_7c.height){
t._outerHeight(_7c.height);
}
};
function _7d(e){
$.fn.resizable.isResizing=true;
$.data(e.data.target,"resizable").options.onStartResize.call(e.data.target,e);
return false;
};
function _7e(e){
_76(e);
if($.data(e.data.target,"resizable").options.onResize.call(e.data.target,e)!=false){
_7b(e);
}
return false;
};
function _7f(e){
$.fn.resizable.isResizing=false;
_76(e,true);
_7b(e);
$.data(e.data.target,"resizable").options.onStopResize.call(e.data.target,e);
$(document).unbind(".resizable");
$("body").css("cursor","");
return false;
};
function _80(e){
var _81=$(e.data.target).resizable("options");
var tt=$(e.data.target);
var dir="";
var _82=tt.offset();
var _83=tt.outerWidth();
var _84=tt.outerHeight();
var _85=_81.edge;
if(e.pageY>_82.top&&e.pageY<_82.top+_85){
dir+="n";
}else{
if(e.pageY<_82.top+_84&&e.pageY>_82.top+_84-_85){
dir+="s";
}
}
if(e.pageX>_82.left&&e.pageX<_82.left+_85){
dir+="w";
}else{
if(e.pageX<_82.left+_83&&e.pageX>_82.left+_83-_85){
dir+="e";
}
}
var _86=_81.handles.split(",");
_86=$.map(_86,function(h){
return $.trim(h).toLowerCase();
});
if($.inArray("all",_86)>=0||$.inArray(dir,_86)>=0){
return dir;
}
for(var i=0;i<dir.length;i++){
var _87=$.inArray(dir.substr(i,1),_86);
if(_87>=0){
return _86[_87];
}
}
return "";
};
$.fn.resizable=function(_88,_89){
if(typeof _88=="string"){
return $.fn.resizable.methods[_88](this,_89);
}
return this.each(function(){
var _8a=null;
var _8b=$.data(this,"resizable");
if(_8b){
$(this).unbind(".resizable");
_8a=$.extend(_8b.options,_88||{});
}else{
_8a=$.extend({},$.fn.resizable.defaults,$.fn.resizable.parseOptions(this),_88||{});
$.data(this,"resizable",{options:_8a});
}
if(_8a.disabled==true){
return;
}
$(this).bind("mousemove.resizable",{target:this},function(e){
if($.fn.resizable.isResizing){
return;
}
var dir=_80(e);
$(e.data.target).css("cursor",dir?dir+"-resize":"");
}).bind("mouseleave.resizable",{target:this},function(e){
$(e.data.target).css("cursor","");
}).bind("mousedown.resizable",{target:this},function(e){
var dir=_80(e);
if(dir==""){
return;
}
function _8c(css){
var val=parseInt($(e.data.target).css(css));
if(isNaN(val)){
return 0;
}else{
return val;
}
};
var _8d={target:e.data.target,dir:dir,startLeft:_8c("left"),startTop:_8c("top"),left:_8c("left"),top:_8c("top"),startX:e.pageX,startY:e.pageY,startWidth:$(e.data.target).outerWidth(),startHeight:$(e.data.target).outerHeight(),width:$(e.data.target).outerWidth(),height:$(e.data.target).outerHeight(),deltaWidth:$(e.data.target).outerWidth()-$(e.data.target).width(),deltaHeight:$(e.data.target).outerHeight()-$(e.data.target).height()};
$(document).bind("mousedown.resizable",_8d,_7d);
$(document).bind("mousemove.resizable",_8d,_7e);
$(document).bind("mouseup.resizable",_8d,_7f);
$("body").css("cursor",dir+"-resize");
});
});
};
$.fn.resizable.methods={options:function(jq){
return $.data(jq[0],"resizable").options;
},enable:function(jq){
return jq.each(function(){
$(this).resizable({disabled:false});
});
},disable:function(jq){
return jq.each(function(){
$(this).resizable({disabled:true});
});
}};
$.fn.resizable.parseOptions=function(_8e){
var t=$(_8e);
return $.extend({},$.parser.parseOptions(_8e,["handles",{minWidth:"number",minHeight:"number",maxWidth:"number",maxHeight:"number",edge:"number"}]),{disabled:(t.attr("disabled")?true:undefined)});
};
$.fn.resizable.defaults={disabled:false,handles:"n, e, s, w, ne, se, sw, nw, all",minWidth:10,minHeight:10,maxWidth:10000,maxHeight:10000,edge:5,onStartResize:function(e){
},onResize:function(e){
},onStopResize:function(e){
}};
$.fn.resizable.isResizing=false;
})(jQuery);
(function($){
function _8f(_90,_91){
var _92=$.data(_90,"linkbutton").options;
if(_91){
$.extend(_92,_91);
}
if(_92.width||_92.height||_92.fit){
var btn=$(_90);
var _93=btn.parent();
var _94=btn.is(":visible");
if(!_94){
var _95=$("<div style=\"display:none\"></div>").insertBefore(_90);
var _96={position:btn.css("position"),display:btn.css("display"),left:btn.css("left")};
btn.appendTo("body");
btn.css({position:"absolute",display:"inline-block",left:-20000});
}
btn._size(_92,_93);
var _97=btn.find(".l-btn-left");
_97.css("margin-top",0);
_97.css("margin-top",parseInt((btn.height()-_97.height())/2)+"px");
if(!_94){
btn.insertAfter(_95);
btn.css(_96);
_95.remove();
}
}
};
function _98(_99){
var _9a=$.data(_99,"linkbutton").options;
var t=$(_99).empty();
t.addClass("l-btn").removeClass("l-btn-plain l-btn-selected l-btn-plain-selected l-btn-outline");
t.removeClass("l-btn-small l-btn-medium l-btn-large").addClass("l-btn-"+_9a.size);
if(_9a.plain){
t.addClass("l-btn-plain");
}
if(_9a.outline){
t.addClass("l-btn-outline");
}
if(_9a.selected){
t.addClass(_9a.plain?"l-btn-selected l-btn-plain-selected":"l-btn-selected");
}
t.attr("group",_9a.group||"");
t.attr("id",_9a.id||"");
var _9b=$("<span class=\"l-btn-left\"></span>").appendTo(t);
if(_9a.text){
$("<span class=\"l-btn-text\"></span>").html(_9a.text).appendTo(_9b);
}else{
$("<span class=\"l-btn-text l-btn-empty\">&nbsp;</span>").appendTo(_9b);
}
if(_9a.iconCls){
$("<span class=\"l-btn-icon\">&nbsp;</span>").addClass(_9a.iconCls).appendTo(_9b);
_9b.addClass("l-btn-icon-"+_9a.iconAlign);
}
t.unbind(".linkbutton").bind("focus.linkbutton",function(){
if(!_9a.disabled){
$(this).addClass("l-btn-focus");
}
}).bind("blur.linkbutton",function(){
$(this).removeClass("l-btn-focus");
}).bind("click.linkbutton",function(){
if(!_9a.disabled){
if(_9a.toggle){
if(_9a.selected){
$(this).linkbutton("unselect");
}else{
$(this).linkbutton("select");
}
}
_9a.onClick.call(this);
}
});
_9c(_99,_9a.selected);
_9d(_99,_9a.disabled);
};
function _9c(_9e,_9f){
var _a0=$.data(_9e,"linkbutton").options;
if(_9f){
if(_a0.group){
$("a.l-btn[group=\""+_a0.group+"\"]").each(function(){
var o=$(this).linkbutton("options");
if(o.toggle){
$(this).removeClass("l-btn-selected l-btn-plain-selected");
o.selected=false;
}
});
}
$(_9e).addClass(_a0.plain?"l-btn-selected l-btn-plain-selected":"l-btn-selected");
_a0.selected=true;
}else{
if(!_a0.group){
$(_9e).removeClass("l-btn-selected l-btn-plain-selected");
_a0.selected=false;
}
}
};
function _9d(_a1,_a2){
var _a3=$.data(_a1,"linkbutton");
var _a4=_a3.options;
$(_a1).removeClass("l-btn-disabled l-btn-plain-disabled");
if(_a2){
_a4.disabled=true;
var _a5=$(_a1).attr("href");
if(_a5){
_a3.href=_a5;
$(_a1).attr("href","javascript:;");
}
if(_a1.onclick){
_a3.onclick=_a1.onclick;
_a1.onclick=null;
}
_a4.plain?$(_a1).addClass("l-btn-disabled l-btn-plain-disabled"):$(_a1).addClass("l-btn-disabled");
}else{
_a4.disabled=false;
if(_a3.href){
$(_a1).attr("href",_a3.href);
}
if(_a3.onclick){
_a1.onclick=_a3.onclick;
}
}
};
$.fn.linkbutton=function(_a6,_a7){
if(typeof _a6=="string"){
return $.fn.linkbutton.methods[_a6](this,_a7);
}
_a6=_a6||{};
return this.each(function(){
var _a8=$.data(this,"linkbutton");
if(_a8){
$.extend(_a8.options,_a6);
}else{
$.data(this,"linkbutton",{options:$.extend({},$.fn.linkbutton.defaults,$.fn.linkbutton.parseOptions(this),_a6)});
$(this)._propAttr("disabled",false);
$(this).bind("_resize",function(e,_a9){
if($(this).hasClass("easyui-fluid")||_a9){
_8f(this);
}
return false;
});
}
_98(this);
_8f(this);
});
};
$.fn.linkbutton.methods={options:function(jq){
return $.data(jq[0],"linkbutton").options;
},resize:function(jq,_aa){
return jq.each(function(){
_8f(this,_aa);
});
},enable:function(jq){
return jq.each(function(){
_9d(this,false);
});
},disable:function(jq){
return jq.each(function(){
_9d(this,true);
});
},select:function(jq){
return jq.each(function(){
_9c(this,true);
});
},unselect:function(jq){
return jq.each(function(){
_9c(this,false);
});
}};
$.fn.linkbutton.parseOptions=function(_ab){
var t=$(_ab);
return $.extend({},$.parser.parseOptions(_ab,["id","iconCls","iconAlign","group","size","text",{plain:"boolean",toggle:"boolean",selected:"boolean",outline:"boolean"}]),{disabled:(t.attr("disabled")?true:undefined),text:($.trim(t.html())||undefined),iconCls:(t.attr("icon")||t.attr("iconCls"))});
};
$.fn.linkbutton.defaults={id:null,disabled:false,toggle:false,selected:false,outline:false,group:null,plain:false,text:"",iconCls:null,iconAlign:"left",size:"small",onClick:function(){
}};
})(jQuery);
(function($){
function _ac(_ad){
var _ae=$.data(_ad,"pagination");
var _af=_ae.options;
var bb=_ae.bb={};
var _b0=$(_ad).addClass("pagination").html("<table cellspacing=\"0\" cellpadding=\"0\" border=\"0\"><tr></tr></table>");
var tr=_b0.find("tr");
var aa=$.extend([],_af.layout);
if(!_af.showPageList){
_b1(aa,"list");
}
if(!_af.showPageInfo){
_b1(aa,"info");
}
if(!_af.showRefresh){
_b1(aa,"refresh");
}
if(aa[0]=="sep"){
aa.shift();
}
if(aa[aa.length-1]=="sep"){
aa.pop();
}
for(var _b2=0;_b2<aa.length;_b2++){
var _b3=aa[_b2];
if(_b3=="list"){
var ps=$("<select class=\"pagination-page-list\"></select>");
ps.bind("change",function(){
_af.pageSize=parseInt($(this).val());
_af.onChangePageSize.call(_ad,_af.pageSize);
_b9(_ad,_af.pageNumber);
});
for(var i=0;i<_af.pageList.length;i++){
$("<option></option>").text(_af.pageList[i]).appendTo(ps);
}
$("<td></td>").append(ps).appendTo(tr);
}else{
if(_b3=="sep"){
$("<td><div class=\"pagination-btn-separator\"></div></td>").appendTo(tr);
}else{
if(_b3=="first"){
bb.first=_b4("first");
}else{
if(_b3=="prev"){
bb.prev=_b4("prev");
}else{
if(_b3=="next"){
bb.next=_b4("next");
}else{
if(_b3=="last"){
bb.last=_b4("last");
}else{
if(_b3=="manual"){
$("<span style=\"padding-left:6px;\"></span>").html(_af.beforePageText).appendTo(tr).wrap("<td></td>");
bb.num=$("<input class=\"pagination-num\" type=\"text\" value=\"1\" size=\"2\">").appendTo(tr).wrap("<td></td>");
bb.num.unbind(".pagination").bind("keydown.pagination",function(e){
if(e.keyCode==13){
var _b5=parseInt($(this).val())||1;
_b9(_ad,_b5);
return false;
}
});
bb.after=$("<span style=\"padding-right:6px;\"></span>").appendTo(tr).wrap("<td></td>");
}else{
if(_b3=="refresh"){
bb.refresh=_b4("refresh");
}else{
if(_b3=="links"){
$("<td class=\"pagination-links\"></td>").appendTo(tr);
}else{
if(_b3=="info"){
if(_b2==aa.length-1){
$("<div class=\"pagination-info\"></div>").appendTo(_b0);
}else{
$("<td><div class=\"pagination-info\"></div></td>").appendTo(tr);
}
}
}
}
}
}
}
}
}
}
}
}
if(_af.buttons){
$("<td><div class=\"pagination-btn-separator\"></div></td>").appendTo(tr);
if($.isArray(_af.buttons)){
for(var i=0;i<_af.buttons.length;i++){
var btn=_af.buttons[i];
if(btn=="-"){
$("<td><div class=\"pagination-btn-separator\"></div></td>").appendTo(tr);
}else{
var td=$("<td></td>").appendTo(tr);
var a=$("<a href=\"javascript:;\"></a>").appendTo(td);
a[0].onclick=eval(btn.handler||function(){
});
a.linkbutton($.extend({},btn,{plain:true}));
}
}
}else{
var td=$("<td></td>").appendTo(tr);
$(_af.buttons).appendTo(td).show();
}
}
$("<div style=\"clear:both;\"></div>").appendTo(_b0);
function _b4(_b6){
var btn=_af.nav[_b6];
var a=$("<a href=\"javascript:;\"></a>").appendTo(tr);
a.wrap("<td></td>");
a.linkbutton({iconCls:btn.iconCls,plain:true}).unbind(".pagination").bind("click.pagination",function(){
btn.handler.call(_ad);
});
return a;
};
function _b1(aa,_b7){
var _b8=$.inArray(_b7,aa);
if(_b8>=0){
aa.splice(_b8,1);
}
return aa;
};
};
function _b9(_ba,_bb){
var _bc=$.data(_ba,"pagination").options;
_bd(_ba,{pageNumber:_bb});
_bc.onSelectPage.call(_ba,_bc.pageNumber,_bc.pageSize);
};
function _bd(_be,_bf){
var _c0=$.data(_be,"pagination");
var _c1=_c0.options;
var bb=_c0.bb;
$.extend(_c1,_bf||{});
var ps=$(_be).find("select.pagination-page-list");
if(ps.length){
ps.val(_c1.pageSize+"");
_c1.pageSize=parseInt(ps.val());
}
var _c2=Math.ceil(_c1.total/_c1.pageSize)||1;
if(_c1.pageNumber<1){
_c1.pageNumber=1;
}
if(_c1.pageNumber>_c2){
_c1.pageNumber=_c2;
}
if(_c1.total==0){
_c1.pageNumber=0;
_c2=0;
}
if(bb.num){
bb.num.val(_c1.pageNumber);
}
if(bb.after){
bb.after.html(_c1.afterPageText.replace(/{pages}/,_c2));
}
var td=$(_be).find("td.pagination-links");
if(td.length){
td.empty();
var _c3=_c1.pageNumber-Math.floor(_c1.links/2);
if(_c3<1){
_c3=1;
}
var _c4=_c3+_c1.links-1;
if(_c4>_c2){
_c4=_c2;
}
_c3=_c4-_c1.links+1;
if(_c3<1){
_c3=1;
}
for(var i=_c3;i<=_c4;i++){
var a=$("<a class=\"pagination-link\" href=\"javascript:;\"></a>").appendTo(td);
a.linkbutton({plain:true,text:i});
if(i==_c1.pageNumber){
a.linkbutton("select");
}else{
a.unbind(".pagination").bind("click.pagination",{pageNumber:i},function(e){
_b9(_be,e.data.pageNumber);
});
}
}
}
var _c5=_c1.displayMsg;
_c5=_c5.replace(/{from}/,_c1.total==0?0:_c1.pageSize*(_c1.pageNumber-1)+1);
_c5=_c5.replace(/{to}/,Math.min(_c1.pageSize*(_c1.pageNumber),_c1.total));
_c5=_c5.replace(/{total}/,_c1.total);
$(_be).find("div.pagination-info").html(_c5);
if(bb.first){
bb.first.linkbutton({disabled:((!_c1.total)||_c1.pageNumber==1)});
}
if(bb.prev){
bb.prev.linkbutton({disabled:((!_c1.total)||_c1.pageNumber==1)});
}
if(bb.next){
bb.next.linkbutton({disabled:(_c1.pageNumber==_c2)});
}
if(bb.last){
bb.last.linkbutton({disabled:(_c1.pageNumber==_c2)});
}
_c6(_be,_c1.loading);
};
function _c6(_c7,_c8){
var _c9=$.data(_c7,"pagination");
var _ca=_c9.options;
_ca.loading=_c8;
if(_ca.showRefresh&&_c9.bb.refresh){
_c9.bb.refresh.linkbutton({iconCls:(_ca.loading?"pagination-loading":"pagination-load")});
}
};
$.fn.pagination=function(_cb,_cc){
if(typeof _cb=="string"){
return $.fn.pagination.methods[_cb](this,_cc);
}
_cb=_cb||{};
return this.each(function(){
var _cd;
var _ce=$.data(this,"pagination");
if(_ce){
_cd=$.extend(_ce.options,_cb);
}else{
_cd=$.extend({},$.fn.pagination.defaults,$.fn.pagination.parseOptions(this),_cb);
$.data(this,"pagination",{options:_cd});
}
_ac(this);
_bd(this);
});
};
$.fn.pagination.methods={options:function(jq){
return $.data(jq[0],"pagination").options;
},loading:function(jq){
return jq.each(function(){
_c6(this,true);
});
},loaded:function(jq){
return jq.each(function(){
_c6(this,false);
});
},refresh:function(jq,_cf){
return jq.each(function(){
_bd(this,_cf);
});
},select:function(jq,_d0){
return jq.each(function(){
_b9(this,_d0);
});
}};
$.fn.pagination.parseOptions=function(_d1){
var t=$(_d1);
return $.extend({},$.parser.parseOptions(_d1,[{total:"number",pageSize:"number",pageNumber:"number",links:"number"},{loading:"boolean",showPageList:"boolean",showPageInfo:"boolean",showRefresh:"boolean"}]),{pageList:(t.attr("pageList")?eval(t.attr("pageList")):undefined)});
};
$.fn.pagination.defaults={total:1,pageSize:10,pageNumber:1,pageList:[10,20,30,50],loading:false,buttons:null,showPageList:true,showPageInfo:true,showRefresh:true,links:10,layout:["list","sep","first","prev","sep","manual","sep","next","last","sep","refresh","info"],onSelectPage:function(_d2,_d3){
},onBeforeRefresh:function(_d4,_d5){
},onRefresh:function(_d6,_d7){
},onChangePageSize:function(_d8){
},beforePageText:"Page",afterPageText:"of {pages}",displayMsg:"Displaying {from} to {to} of {total} items",nav:{first:{iconCls:"pagination-first",handler:function(){
var _d9=$(this).pagination("options");
if(_d9.pageNumber>1){
$(this).pagination("select",1);
}
}},prev:{iconCls:"pagination-prev",handler:function(){
var _da=$(this).pagination("options");
if(_da.pageNumber>1){
$(this).pagination("select",_da.pageNumber-1);
}
}},next:{iconCls:"pagination-next",handler:function(){
var _db=$(this).pagination("options");
var _dc=Math.ceil(_db.total/_db.pageSize);
if(_db.pageNumber<_dc){
$(this).pagination("select",_db.pageNumber+1);
}
}},last:{iconCls:"pagination-last",handler:function(){
var _dd=$(this).pagination("options");
var _de=Math.ceil(_dd.total/_dd.pageSize);
if(_dd.pageNumber<_de){
$(this).pagination("select",_de);
}
}},refresh:{iconCls:"pagination-refresh",handler:function(){
var _df=$(this).pagination("options");
if(_df.onBeforeRefresh.call(this,_df.pageNumber,_df.pageSize)!=false){
$(this).pagination("select",_df.pageNumber);
_df.onRefresh.call(this,_df.pageNumber,_df.pageSize);
}
}}}};
})(jQuery);
(function($){
function _e0(_e1){
var _e2=$(_e1);
_e2.addClass("tree");
return _e2;
};
function _e3(_e4){
var _e5=$.data(_e4,"tree").options;
$(_e4).unbind().bind("mouseover",function(e){
var tt=$(e.target);
var _e6=tt.closest("div.tree-node");
if(!_e6.length){
return;
}
_e6.addClass("tree-node-hover");
if(tt.hasClass("tree-hit")){
if(tt.hasClass("tree-expanded")){
tt.addClass("tree-expanded-hover");
}else{
tt.addClass("tree-collapsed-hover");
}
}
e.stopPropagation();
}).bind("mouseout",function(e){
var tt=$(e.target);
var _e7=tt.closest("div.tree-node");
if(!_e7.length){
return;
}
_e7.removeClass("tree-node-hover");
if(tt.hasClass("tree-hit")){
if(tt.hasClass("tree-expanded")){
tt.removeClass("tree-expanded-hover");
}else{
tt.removeClass("tree-collapsed-hover");
}
}
e.stopPropagation();
}).bind("click",function(e){
var tt=$(e.target);
var _e8=tt.closest("div.tree-node");
if(!_e8.length){
return;
}
if(tt.hasClass("tree-hit")){
_146(_e4,_e8[0]);
return false;
}else{
if(tt.hasClass("tree-checkbox")){
_10d(_e4,_e8[0]);
return false;
}else{
_189(_e4,_e8[0]);
_e5.onClick.call(_e4,_eb(_e4,_e8[0]));
}
}
e.stopPropagation();
}).bind("dblclick",function(e){
var _e9=$(e.target).closest("div.tree-node");
if(!_e9.length){
return;
}
_189(_e4,_e9[0]);
_e5.onDblClick.call(_e4,_eb(_e4,_e9[0]));
e.stopPropagation();
}).bind("contextmenu",function(e){
var _ea=$(e.target).closest("div.tree-node");
if(!_ea.length){
return;
}
_e5.onContextMenu.call(_e4,e,_eb(_e4,_ea[0]));
e.stopPropagation();
});
};
function _ec(_ed){
var _ee=$.data(_ed,"tree").options;
_ee.dnd=false;
var _ef=$(_ed).find("div.tree-node");
_ef.draggable("disable");
_ef.css("cursor","pointer");
};
function _f0(_f1){
var _f2=$.data(_f1,"tree");
var _f3=_f2.options;
var _f4=_f2.tree;
_f2.disabledNodes=[];
_f3.dnd=true;
_f4.find("div.tree-node").draggable({disabled:false,revert:true,cursor:"pointer",proxy:function(_f5){
var p=$("<div class=\"tree-node-proxy\"></div>").appendTo("body");
p.html("<span class=\"tree-dnd-icon tree-dnd-no\">&nbsp;</span>"+$(_f5).find(".tree-title").html());
p.hide();
return p;
},deltaX:15,deltaY:15,onBeforeDrag:function(e){
if(_f3.onBeforeDrag.call(_f1,_eb(_f1,this))==false){
return false;
}
if($(e.target).hasClass("tree-hit")||$(e.target).hasClass("tree-checkbox")){
return false;
}
if(e.which!=1){
return false;
}
var _f6=$(this).find("span.tree-indent");
if(_f6.length){
e.data.offsetWidth-=_f6.length*_f6.width();
}
},onStartDrag:function(e){
$(this).next("ul").find("div.tree-node").each(function(){
$(this).droppable("disable");
_f2.disabledNodes.push(this);
});
$(this).draggable("proxy").css({left:-10000,top:-10000});
_f3.onStartDrag.call(_f1,_eb(_f1,this));
var _f7=_eb(_f1,this);
if(_f7.id==undefined){
_f7.id="easyui_tree_node_id_temp";
_12d(_f1,_f7);
}
_f2.draggingNodeId=_f7.id;
},onDrag:function(e){
var x1=e.pageX,y1=e.pageY,x2=e.data.startX,y2=e.data.startY;
var d=Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
if(d>3){
$(this).draggable("proxy").show();
}
this.pageY=e.pageY;
},onStopDrag:function(){
for(var i=0;i<_f2.disabledNodes.length;i++){
$(_f2.disabledNodes[i]).droppable("enable");
}
_f2.disabledNodes=[];
var _f8=_183(_f1,_f2.draggingNodeId);
if(_f8&&_f8.id=="easyui_tree_node_id_temp"){
_f8.id="";
_12d(_f1,_f8);
}
_f3.onStopDrag.call(_f1,_f8);
}}).droppable({accept:"div.tree-node",onDragEnter:function(e,_f9){
if(_f3.onDragEnter.call(_f1,this,_fa(_f9))==false){
_fb(_f9,false);
$(this).removeClass("tree-node-append tree-node-top tree-node-bottom");
$(this).droppable("disable");
_f2.disabledNodes.push(this);
}
},onDragOver:function(e,_fc){
if($(this).droppable("options").disabled){
return;
}
var _fd=_fc.pageY;
var top=$(this).offset().top;
var _fe=top+$(this).outerHeight();
_fb(_fc,true);
$(this).removeClass("tree-node-append tree-node-top tree-node-bottom");
if(_fd>top+(_fe-top)/2){
if(_fe-_fd<5){
$(this).addClass("tree-node-bottom");
}else{
$(this).addClass("tree-node-append");
}
}else{
if(_fd-top<5){
$(this).addClass("tree-node-top");
}else{
$(this).addClass("tree-node-append");
}
}
if(_f3.onDragOver.call(_f1,this,_fa(_fc))==false){
_fb(_fc,false);
$(this).removeClass("tree-node-append tree-node-top tree-node-bottom");
$(this).droppable("disable");
_f2.disabledNodes.push(this);
}
},onDragLeave:function(e,_ff){
_fb(_ff,false);
$(this).removeClass("tree-node-append tree-node-top tree-node-bottom");
_f3.onDragLeave.call(_f1,this,_fa(_ff));
},onDrop:function(e,_100){
var dest=this;
var _101,_102;
if($(this).hasClass("tree-node-append")){
_101=_103;
_102="append";
}else{
_101=_104;
_102=$(this).hasClass("tree-node-top")?"top":"bottom";
}
if(_f3.onBeforeDrop.call(_f1,dest,_fa(_100),_102)==false){
$(this).removeClass("tree-node-append tree-node-top tree-node-bottom");
return;
}
_101(_100,dest,_102);
$(this).removeClass("tree-node-append tree-node-top tree-node-bottom");
}});
function _fa(_105,pop){
return $(_105).closest("ul.tree").tree(pop?"pop":"getData",_105);
};
function _fb(_106,_107){
var icon=$(_106).draggable("proxy").find("span.tree-dnd-icon");
icon.removeClass("tree-dnd-yes tree-dnd-no").addClass(_107?"tree-dnd-yes":"tree-dnd-no");
};
function _103(_108,dest){
if(_eb(_f1,dest).state=="closed"){
_13e(_f1,dest,function(){
_109();
});
}else{
_109();
}
function _109(){
var node=_fa(_108,true);
$(_f1).tree("append",{parent:dest,data:[node]});
_f3.onDrop.call(_f1,dest,node,"append");
};
};
function _104(_10a,dest,_10b){
var _10c={};
if(_10b=="top"){
_10c.before=dest;
}else{
_10c.after=dest;
}
var node=_fa(_10a,true);
_10c.data=node;
$(_f1).tree("insert",_10c);
_f3.onDrop.call(_f1,dest,node,_10b);
};
};
function _10d(_10e,_10f,_110,_111){
var _112=$.data(_10e,"tree");
var opts=_112.options;
if(!opts.checkbox){
return;
}
var _113=_eb(_10e,_10f);
if(!_113.checkState){
return;
}
var ck=$(_10f).find(".tree-checkbox");
if(_110==undefined){
if(ck.hasClass("tree-checkbox1")){
_110=false;
}else{
if(ck.hasClass("tree-checkbox0")){
_110=true;
}else{
if(_113._checked==undefined){
_113._checked=$(_10f).find(".tree-checkbox").hasClass("tree-checkbox1");
}
_110=!_113._checked;
}
}
}
_113._checked=_110;
if(_110){
if(ck.hasClass("tree-checkbox1")){
return;
}
}else{
if(ck.hasClass("tree-checkbox0")){
return;
}
}
if(!_111){
if(opts.onBeforeCheck.call(_10e,_113,_110)==false){
return;
}
}
if(opts.cascadeCheck){
_114(_10e,_113,_110);
_115(_10e,_113);
}else{
_116(_10e,_113,_110?"1":"0");
}
if(!_111){
opts.onCheck.call(_10e,_113,_110);
}
};
function _114(_117,_118,_119){
var opts=$.data(_117,"tree").options;
var flag=_119?1:0;
_116(_117,_118,flag);
if(opts.deepCheck){
$.easyui.forEach(_118.children||[],true,function(n){
_116(_117,n,flag);
});
}else{
var _11a=[];
if(_118.children&&_118.children.length){
_11a.push(_118);
}
$.easyui.forEach(_118.children||[],true,function(n){
if(!n.hidden){
_116(_117,n,flag);
if(n.children&&n.children.length){
_11a.push(n);
}
}
});
for(var i=_11a.length-1;i>=0;i--){
var node=_11a[i];
_116(_117,node,_11b(node));
}
}
};
function _116(_11c,_11d,flag){
var opts=$.data(_11c,"tree").options;
if(!_11d.checkState||flag==undefined){
return;
}
if(_11d.hidden&&!opts.deepCheck){
return;
}
var ck=$("#"+_11d.domId).find(".tree-checkbox");
_11d.checkState=["unchecked","checked","indeterminate"][flag];
_11d.checked=(_11d.checkState=="checked");
ck.removeClass("tree-checkbox0 tree-checkbox1 tree-checkbox2");
ck.addClass("tree-checkbox"+flag);
};
function _115(_11e,_11f){
var pd=_120(_11e,$("#"+_11f.domId)[0]);
if(pd){
_116(_11e,pd,_11b(pd));
_115(_11e,pd);
}
};
function _11b(row){
var c0=0;
var c1=0;
var len=0;
$.easyui.forEach(row.children||[],false,function(r){
if(r.checkState){
len++;
if(r.checkState=="checked"){
c1++;
}else{
if(r.checkState=="unchecked"){
c0++;
}
}
}
});
if(len==0){
return undefined;
}
var flag=0;
if(c0==len){
flag=0;
}else{
if(c1==len){
flag=1;
}else{
flag=2;
}
}
return flag;
};
function _121(_122,_123){
var opts=$.data(_122,"tree").options;
if(!opts.checkbox){
return;
}
var node=$(_123);
var ck=node.find(".tree-checkbox");
var _124=_eb(_122,_123);
if(opts.view.hasCheckbox(_122,_124)){
if(!ck.length){
_124.checkState=_124.checkState||"unchecked";
$("<span class=\"tree-checkbox\"></span>").insertBefore(node.find(".tree-title"));
}
if(_124.checkState=="checked"){
_10d(_122,_123,true,true);
}else{
if(_124.checkState=="unchecked"){
_10d(_122,_123,false,true);
}else{
var flag=_11b(_124);
if(flag===0){
_10d(_122,_123,false,true);
}else{
if(flag===1){
_10d(_122,_123,true,true);
}
}
}
}
}else{
ck.remove();
_124.checkState=undefined;
_124.checked=undefined;
_115(_122,_124);
}
};
function _125(_126,ul,data,_127,_128){
var _129=$.data(_126,"tree");
var opts=_129.options;
var _12a=$(ul).prevAll("div.tree-node:first");
data=opts.loadFilter.call(_126,data,_12a[0]);
var _12b=_12c(_126,"domId",_12a.attr("id"));
if(!_127){
_12b?_12b.children=data:_129.data=data;
$(ul).empty();
}else{
if(_12b){
_12b.children?_12b.children=_12b.children.concat(data):_12b.children=data;
}else{
_129.data=_129.data.concat(data);
}
}
opts.view.render.call(opts.view,_126,ul,data);
if(opts.dnd){
_f0(_126);
}
if(_12b){
_12d(_126,_12b);
}
for(var i=0;i<_129.tmpIds.length;i++){
_10d(_126,$("#"+_129.tmpIds[i])[0],true,true);
}
_129.tmpIds=[];
setTimeout(function(){
_12e(_126,_126);
},0);
if(!_128){
opts.onLoadSuccess.call(_126,_12b,data);
}
};
function _12e(_12f,ul,_130){
var opts=$.data(_12f,"tree").options;
if(opts.lines){
$(_12f).addClass("tree-lines");
}else{
$(_12f).removeClass("tree-lines");
return;
}
if(!_130){
_130=true;
$(_12f).find("span.tree-indent").removeClass("tree-line tree-join tree-joinbottom");
$(_12f).find("div.tree-node").removeClass("tree-node-last tree-root-first tree-root-one");
var _131=$(_12f).tree("getRoots");
if(_131.length>1){
$(_131[0].target).addClass("tree-root-first");
}else{
if(_131.length==1){
$(_131[0].target).addClass("tree-root-one");
}
}
}
$(ul).children("li").each(function(){
var node=$(this).children("div.tree-node");
var ul=node.next("ul");
if(ul.length){
if($(this).next().length){
_132(node);
}
_12e(_12f,ul,_130);
}else{
_133(node);
}
});
var _134=$(ul).children("li:last").children("div.tree-node").addClass("tree-node-last");
_134.children("span.tree-join").removeClass("tree-join").addClass("tree-joinbottom");
function _133(node,_135){
var icon=node.find("span.tree-icon");
icon.prev("span.tree-indent").addClass("tree-join");
};
function _132(node){
var _136=node.find("span.tree-indent, span.tree-hit").length;
node.next().find("div.tree-node").each(function(){
$(this).children("span:eq("+(_136-1)+")").addClass("tree-line");
});
};
};
function _137(_138,ul,_139,_13a){
var opts=$.data(_138,"tree").options;
_139=$.extend({},opts.queryParams,_139||{});
var _13b=null;
if(_138!=ul){
var node=$(ul).prev();
_13b=_eb(_138,node[0]);
}
if(opts.onBeforeLoad.call(_138,_13b,_139)==false){
return;
}
var _13c=$(ul).prev().children("span.tree-folder");
_13c.addClass("tree-loading");
var _13d=opts.loader.call(_138,_139,function(data){
_13c.removeClass("tree-loading");
_125(_138,ul,data);
if(_13a){
_13a();
}
},function(){
_13c.removeClass("tree-loading");
opts.onLoadError.apply(_138,arguments);
if(_13a){
_13a();
}
});
if(_13d==false){
_13c.removeClass("tree-loading");
}
};
function _13e(_13f,_140,_141){
var opts=$.data(_13f,"tree").options;
var hit=$(_140).children("span.tree-hit");
if(hit.length==0){
return;
}
if(hit.hasClass("tree-expanded")){
return;
}
var node=_eb(_13f,_140);
if(opts.onBeforeExpand.call(_13f,node)==false){
return;
}
hit.removeClass("tree-collapsed tree-collapsed-hover").addClass("tree-expanded");
hit.next().addClass("tree-folder-open");
var ul=$(_140).next();
if(ul.length){
if(opts.animate){
ul.slideDown("normal",function(){
node.state="open";
opts.onExpand.call(_13f,node);
if(_141){
_141();
}
});
}else{
ul.css("display","block");
node.state="open";
opts.onExpand.call(_13f,node);
if(_141){
_141();
}
}
}else{
var _142=$("<ul style=\"display:none\"></ul>").insertAfter(_140);
_137(_13f,_142[0],{id:node.id},function(){
if(_142.is(":empty")){
_142.remove();
}
if(opts.animate){
_142.slideDown("normal",function(){
node.state="open";
opts.onExpand.call(_13f,node);
if(_141){
_141();
}
});
}else{
_142.css("display","block");
node.state="open";
opts.onExpand.call(_13f,node);
if(_141){
_141();
}
}
});
}
};
function _143(_144,_145){
var opts=$.data(_144,"tree").options;
var hit=$(_145).children("span.tree-hit");
if(hit.length==0){
return;
}
if(hit.hasClass("tree-collapsed")){
return;
}
var node=_eb(_144,_145);
if(opts.onBeforeCollapse.call(_144,node)==false){
return;
}
hit.removeClass("tree-expanded tree-expanded-hover").addClass("tree-collapsed");
hit.next().removeClass("tree-folder-open");
var ul=$(_145).next();
if(opts.animate){
ul.slideUp("normal",function(){
node.state="closed";
opts.onCollapse.call(_144,node);
});
}else{
ul.css("display","none");
node.state="closed";
opts.onCollapse.call(_144,node);
}
};
function _146(_147,_148){
var hit=$(_148).children("span.tree-hit");
if(hit.length==0){
return;
}
if(hit.hasClass("tree-expanded")){
_143(_147,_148);
}else{
_13e(_147,_148);
}
};
function _149(_14a,_14b){
var _14c=_14d(_14a,_14b);
if(_14b){
_14c.unshift(_eb(_14a,_14b));
}
for(var i=0;i<_14c.length;i++){
_13e(_14a,_14c[i].target);
}
};
function _14e(_14f,_150){
var _151=[];
var p=_120(_14f,_150);
while(p){
_151.unshift(p);
p=_120(_14f,p.target);
}
for(var i=0;i<_151.length;i++){
_13e(_14f,_151[i].target);
}
};
function _152(_153,_154){
var c=$(_153).parent();
while(c[0].tagName!="BODY"&&c.css("overflow-y")!="auto"){
c=c.parent();
}
var n=$(_154);
var ntop=n.offset().top;
if(c[0].tagName!="BODY"){
var ctop=c.offset().top;
if(ntop<ctop){
c.scrollTop(c.scrollTop()+ntop-ctop);
}else{
if(ntop+n.outerHeight()>ctop+c.outerHeight()-18){
c.scrollTop(c.scrollTop()+ntop+n.outerHeight()-ctop-c.outerHeight()+18);
}
}
}else{
c.scrollTop(ntop);
}
};
function _155(_156,_157){
var _158=_14d(_156,_157);
if(_157){
_158.unshift(_eb(_156,_157));
}
for(var i=0;i<_158.length;i++){
_143(_156,_158[i].target);
}
};
function _159(_15a,_15b){
var node=$(_15b.parent);
var data=_15b.data;
if(!data){
return;
}
data=$.isArray(data)?data:[data];
if(!data.length){
return;
}
var ul;
if(node.length==0){
ul=$(_15a);
}else{
if(_15c(_15a,node[0])){
var _15d=node.find("span.tree-icon");
_15d.removeClass("tree-file").addClass("tree-folder tree-folder-open");
var hit=$("<span class=\"tree-hit tree-expanded\"></span>").insertBefore(_15d);
if(hit.prev().length){
hit.prev().remove();
}
}
ul=node.next();
if(!ul.length){
ul=$("<ul></ul>").insertAfter(node);
}
}
_125(_15a,ul[0],data,true,true);
};
function _15e(_15f,_160){
var ref=_160.before||_160.after;
var _161=_120(_15f,ref);
var data=_160.data;
if(!data){
return;
}
data=$.isArray(data)?data:[data];
if(!data.length){
return;
}
_159(_15f,{parent:(_161?_161.target:null),data:data});
var _162=_161?_161.children:$(_15f).tree("getRoots");
for(var i=0;i<_162.length;i++){
if(_162[i].domId==$(ref).attr("id")){
for(var j=data.length-1;j>=0;j--){
_162.splice((_160.before?i:(i+1)),0,data[j]);
}
_162.splice(_162.length-data.length,data.length);
break;
}
}
var li=$();
for(var i=0;i<data.length;i++){
li=li.add($("#"+data[i].domId).parent());
}
if(_160.before){
li.insertBefore($(ref).parent());
}else{
li.insertAfter($(ref).parent());
}
};
function _163(_164,_165){
var _166=del(_165);
$(_165).parent().remove();
if(_166){
if(!_166.children||!_166.children.length){
var node=$(_166.target);
node.find(".tree-icon").removeClass("tree-folder").addClass("tree-file");
node.find(".tree-hit").remove();
$("<span class=\"tree-indent\"></span>").prependTo(node);
node.next().remove();
}
_12d(_164,_166);
}
_12e(_164,_164);
function del(_167){
var id=$(_167).attr("id");
var _168=_120(_164,_167);
var cc=_168?_168.children:$.data(_164,"tree").data;
for(var i=0;i<cc.length;i++){
if(cc[i].domId==id){
cc.splice(i,1);
break;
}
}
return _168;
};
};
function _12d(_169,_16a){
var opts=$.data(_169,"tree").options;
var node=$(_16a.target);
var data=_eb(_169,_16a.target);
if(data.iconCls){
node.find(".tree-icon").removeClass(data.iconCls);
}
$.extend(data,_16a);
node.find(".tree-title").html(opts.formatter.call(_169,data));
if(data.iconCls){
node.find(".tree-icon").addClass(data.iconCls);
}
_121(_169,_16a.target);
};
function _16b(_16c,_16d){
if(_16d){
var p=_120(_16c,_16d);
while(p){
_16d=p.target;
p=_120(_16c,_16d);
}
return _eb(_16c,_16d);
}else{
var _16e=_16f(_16c);
return _16e.length?_16e[0]:null;
}
};
function _16f(_170){
var _171=$.data(_170,"tree").data;
for(var i=0;i<_171.length;i++){
_172(_171[i]);
}
return _171;
};
function _14d(_173,_174){
var _175=[];
var n=_eb(_173,_174);
var data=n?(n.children||[]):$.data(_173,"tree").data;
$.easyui.forEach(data,true,function(node){
_175.push(_172(node));
});
return _175;
};
function _120(_176,_177){
var p=$(_177).closest("ul").prevAll("div.tree-node:first");
return _eb(_176,p[0]);
};
function _178(_179,_17a){
_17a=_17a||"checked";
if(!$.isArray(_17a)){
_17a=[_17a];
}
var _17b=[];
$.easyui.forEach($.data(_179,"tree").data,true,function(n){
if(n.checkState&&$.easyui.indexOfArray(_17a,n.checkState)!=-1){
_17b.push(_172(n));
}
});
return _17b;
};
function _17c(_17d){
var node=$(_17d).find("div.tree-node-selected");
return node.length?_eb(_17d,node[0]):null;
};
function _17e(_17f,_180){
var data=_eb(_17f,_180);
if(data&&data.children){
$.easyui.forEach(data.children,true,function(node){
_172(node);
});
}
return data;
};
function _eb(_181,_182){
return _12c(_181,"domId",$(_182).attr("id"));
};
function _183(_184,id){
return _12c(_184,"id",id);
};
function _12c(_185,_186,_187){
var data=$.data(_185,"tree").data;
var _188=null;
$.easyui.forEach(data,true,function(node){
if(node[_186]==_187){
_188=_172(node);
return false;
}
});
return _188;
};
function _172(node){
node.target=$("#"+node.domId)[0];
return node;
};
function _189(_18a,_18b){
var opts=$.data(_18a,"tree").options;
var node=_eb(_18a,_18b);
if(opts.onBeforeSelect.call(_18a,node)==false){
return;
}
$(_18a).find("div.tree-node-selected").removeClass("tree-node-selected");
$(_18b).addClass("tree-node-selected");
opts.onSelect.call(_18a,node);
};
function _15c(_18c,_18d){
return $(_18d).children("span.tree-hit").length==0;
};
function _18e(_18f,_190){
var opts=$.data(_18f,"tree").options;
var node=_eb(_18f,_190);
if(opts.onBeforeEdit.call(_18f,node)==false){
return;
}
$(_190).css("position","relative");
var nt=$(_190).find(".tree-title");
var _191=nt.outerWidth();
nt.empty();
var _192=$("<input class=\"tree-editor\">").appendTo(nt);
_192.val(node.text).focus();
_192.width(_191+20);
_192._outerHeight(opts.editorHeight);
_192.bind("click",function(e){
return false;
}).bind("mousedown",function(e){
e.stopPropagation();
}).bind("mousemove",function(e){
e.stopPropagation();
}).bind("keydown",function(e){
if(e.keyCode==13){
_193(_18f,_190);
return false;
}else{
if(e.keyCode==27){
_197(_18f,_190);
return false;
}
}
}).bind("blur",function(e){
e.stopPropagation();
_193(_18f,_190);
});
};
function _193(_194,_195){
var opts=$.data(_194,"tree").options;
$(_195).css("position","");
var _196=$(_195).find("input.tree-editor");
var val=_196.val();
_196.remove();
var node=_eb(_194,_195);
node.text=val;
_12d(_194,node);
opts.onAfterEdit.call(_194,node);
};
function _197(_198,_199){
var opts=$.data(_198,"tree").options;
$(_199).css("position","");
$(_199).find("input.tree-editor").remove();
var node=_eb(_198,_199);
_12d(_198,node);
opts.onCancelEdit.call(_198,node);
};
function _19a(_19b,q){
var _19c=$.data(_19b,"tree");
var opts=_19c.options;
var ids={};
$.easyui.forEach(_19c.data,true,function(node){
if(opts.filter.call(_19b,q,node)){
$("#"+node.domId).removeClass("tree-node-hidden");
ids[node.domId]=1;
node.hidden=false;
}else{
$("#"+node.domId).addClass("tree-node-hidden");
node.hidden=true;
}
});
for(var id in ids){
_19d(id);
}
function _19d(_19e){
var p=$(_19b).tree("getParent",$("#"+_19e)[0]);
while(p){
$(p.target).removeClass("tree-node-hidden");
p.hidden=false;
p=$(_19b).tree("getParent",p.target);
}
};
};
$.fn.tree=function(_19f,_1a0){
if(typeof _19f=="string"){
return $.fn.tree.methods[_19f](this,_1a0);
}
var _19f=_19f||{};
return this.each(function(){
var _1a1=$.data(this,"tree");
var opts;
if(_1a1){
opts=$.extend(_1a1.options,_19f);
_1a1.options=opts;
}else{
opts=$.extend({},$.fn.tree.defaults,$.fn.tree.parseOptions(this),_19f);
$.data(this,"tree",{options:opts,tree:_e0(this),data:[],tmpIds:[]});
var data=$.fn.tree.parseData(this);
if(data.length){
_125(this,this,data);
}
}
_e3(this);
if(opts.data){
_125(this,this,$.extend(true,[],opts.data));
}
_137(this,this);
});
};
$.fn.tree.methods={options:function(jq){
return $.data(jq[0],"tree").options;
},loadData:function(jq,data){
return jq.each(function(){
_125(this,this,data);
});
},getNode:function(jq,_1a2){
return _eb(jq[0],_1a2);
},getData:function(jq,_1a3){
return _17e(jq[0],_1a3);
},reload:function(jq,_1a4){
return jq.each(function(){
if(_1a4){
var node=$(_1a4);
var hit=node.children("span.tree-hit");
hit.removeClass("tree-expanded tree-expanded-hover").addClass("tree-collapsed");
node.next().remove();
_13e(this,_1a4);
}else{
$(this).empty();
_137(this,this);
}
});
},getRoot:function(jq,_1a5){
return _16b(jq[0],_1a5);
},getRoots:function(jq){
return _16f(jq[0]);
},getParent:function(jq,_1a6){
return _120(jq[0],_1a6);
},getChildren:function(jq,_1a7){
return _14d(jq[0],_1a7);
},getChecked:function(jq,_1a8){
return _178(jq[0],_1a8);
},getSelected:function(jq){
return _17c(jq[0]);
},isLeaf:function(jq,_1a9){
return _15c(jq[0],_1a9);
},find:function(jq,id){
return _183(jq[0],id);
},select:function(jq,_1aa){
return jq.each(function(){
_189(this,_1aa);
});
},check:function(jq,_1ab){
return jq.each(function(){
_10d(this,_1ab,true);
});
},uncheck:function(jq,_1ac){
return jq.each(function(){
_10d(this,_1ac,false);
});
},collapse:function(jq,_1ad){
return jq.each(function(){
_143(this,_1ad);
});
},expand:function(jq,_1ae){
return jq.each(function(){
_13e(this,_1ae);
});
},collapseAll:function(jq,_1af){
return jq.each(function(){
_155(this,_1af);
});
},expandAll:function(jq,_1b0){
return jq.each(function(){
_149(this,_1b0);
});
},expandTo:function(jq,_1b1){
return jq.each(function(){
_14e(this,_1b1);
});
},scrollTo:function(jq,_1b2){
return jq.each(function(){
_152(this,_1b2);
});
},toggle:function(jq,_1b3){
return jq.each(function(){
_146(this,_1b3);
});
},append:function(jq,_1b4){
return jq.each(function(){
_159(this,_1b4);
});
},insert:function(jq,_1b5){
return jq.each(function(){
_15e(this,_1b5);
});
},remove:function(jq,_1b6){
return jq.each(function(){
_163(this,_1b6);
});
},pop:function(jq,_1b7){
var node=jq.tree("getData",_1b7);
jq.tree("remove",_1b7);
return node;
},update:function(jq,_1b8){
return jq.each(function(){
_12d(this,$.extend({},_1b8,{checkState:_1b8.checked?"checked":(_1b8.checked===false?"unchecked":undefined)}));
});
},enableDnd:function(jq){
return jq.each(function(){
_f0(this);
});
},disableDnd:function(jq){
return jq.each(function(){
_ec(this);
});
},beginEdit:function(jq,_1b9){
return jq.each(function(){
_18e(this,_1b9);
});
},endEdit:function(jq,_1ba){
return jq.each(function(){
_193(this,_1ba);
});
},cancelEdit:function(jq,_1bb){
return jq.each(function(){
_197(this,_1bb);
});
},doFilter:function(jq,q){
return jq.each(function(){
_19a(this,q);
});
}};
$.fn.tree.parseOptions=function(_1bc){
var t=$(_1bc);
return $.extend({},$.parser.parseOptions(_1bc,["url","method",{checkbox:"boolean",cascadeCheck:"boolean",onlyLeafCheck:"boolean"},{animate:"boolean",lines:"boolean",dnd:"boolean"}]));
};
$.fn.tree.parseData=function(_1bd){
var data=[];
_1be(data,$(_1bd));
return data;
function _1be(aa,tree){
tree.children("li").each(function(){
var node=$(this);
var item=$.extend({},$.parser.parseOptions(this,["id","iconCls","state"]),{checked:(node.attr("checked")?true:undefined)});
item.text=node.children("span").html();
if(!item.text){
item.text=node.html();
}
var _1bf=node.children("ul");
if(_1bf.length){
item.children=[];
_1be(item.children,_1bf);
}
aa.push(item);
});
};
};
var _1c0=1;
var _1c1={render:function(_1c2,ul,data){
var _1c3=$.data(_1c2,"tree");
var opts=_1c3.options;
var _1c4=$(ul).prev(".tree-node");
var _1c5=_1c4.length?$(_1c2).tree("getNode",_1c4[0]):null;
var _1c6=_1c4.find("span.tree-indent, span.tree-hit").length;
var cc=_1c7.call(this,_1c6,data);
$(ul).append(cc.join(""));
function _1c7(_1c8,_1c9){
var cc=[];
for(var i=0;i<_1c9.length;i++){
var item=_1c9[i];
if(item.state!="open"&&item.state!="closed"){
item.state="open";
}
item.domId="_easyui_tree_"+_1c0++;
cc.push("<li>");
cc.push("<div id=\""+item.domId+"\" class=\"tree-node"+(item.nodeCls?" "+item.nodeCls:"")+"\">");
for(var j=0;j<_1c8;j++){
cc.push("<span class=\"tree-indent\"></span>");
}
if(item.state=="closed"){
cc.push("<span class=\"tree-hit tree-collapsed\"></span>");
cc.push("<span class=\"tree-icon tree-folder "+(item.iconCls?item.iconCls:"")+"\"></span>");
}else{
if(item.children&&item.children.length){
cc.push("<span class=\"tree-hit tree-expanded\"></span>");
cc.push("<span class=\"tree-icon tree-folder tree-folder-open "+(item.iconCls?item.iconCls:"")+"\"></span>");
}else{
cc.push("<span class=\"tree-indent\"></span>");
cc.push("<span class=\"tree-icon tree-file "+(item.iconCls?item.iconCls:"")+"\"></span>");
}
}
if(this.hasCheckbox(_1c2,item)){
var flag=0;
if(_1c5&&_1c5.checkState=="checked"&&opts.cascadeCheck){
flag=1;
item.checked=true;
}else{
if(item.checked){
$.easyui.addArrayItem(_1c3.tmpIds,item.domId);
}
}
item.checkState=flag?"checked":"unchecked";
cc.push("<span class=\"tree-checkbox tree-checkbox"+flag+"\"></span>");
}else{
item.checkState=undefined;
item.checked=undefined;
}
cc.push("<span class=\"tree-title\">"+opts.formatter.call(_1c2,item)+"</span>");
cc.push("</div>");
if(item.children&&item.children.length){
var tmp=_1c7.call(this,_1c8+1,item.children);
cc.push("<ul style=\"display:"+(item.state=="closed"?"none":"block")+"\">");
cc=cc.concat(tmp);
cc.push("</ul>");
}
cc.push("</li>");
}
return cc;
};
},hasCheckbox:function(_1ca,item){
var _1cb=$.data(_1ca,"tree");
var opts=_1cb.options;
if(opts.checkbox){
if($.isFunction(opts.checkbox)){
if(opts.checkbox.call(_1ca,item)){
return true;
}else{
return false;
}
}else{
if(opts.onlyLeafCheck){
if(item.state=="open"&&!(item.children&&item.children.length)){
return true;
}
}else{
return true;
}
}
}
return false;
}};
$.fn.tree.defaults={url:null,method:"post",animate:false,checkbox:false,cascadeCheck:true,onlyLeafCheck:false,lines:false,dnd:false,editorHeight:26,data:null,queryParams:{},formatter:function(node){
return node.text;
},filter:function(q,node){
var qq=[];
$.map($.isArray(q)?q:[q],function(q){
q=$.trim(q);
if(q){
qq.push(q);
}
});
for(var i=0;i<qq.length;i++){
var _1cc=node.text.toLowerCase().indexOf(qq[i].toLowerCase());
if(_1cc>=0){
return true;
}
}
return !qq.length;
},loader:function(_1cd,_1ce,_1cf){
var opts=$(this).tree("options");
if(!opts.url){
return false;
}
$.ajax({type:opts.method,url:opts.url,data:_1cd,dataType:"json",success:function(data){
_1ce(data);
},error:function(){
_1cf.apply(this,arguments);
}});
},loadFilter:function(data,_1d0){
return data;
},view:_1c1,onBeforeLoad:function(node,_1d1){
},onLoadSuccess:function(node,data){
},onLoadError:function(){
},onClick:function(node){
},onDblClick:function(node){
},onBeforeExpand:function(node){
},onExpand:function(node){
},onBeforeCollapse:function(node){
},onCollapse:function(node){
},onBeforeCheck:function(node,_1d2){
},onCheck:function(node,_1d3){
},onBeforeSelect:function(node){
},onSelect:function(node){
},onContextMenu:function(e,node){
},onBeforeDrag:function(node){
},onStartDrag:function(node){
},onStopDrag:function(node){
},onDragEnter:function(_1d4,_1d5){
},onDragOver:function(_1d6,_1d7){
},onDragLeave:function(_1d8,_1d9){
},onBeforeDrop:function(_1da,_1db,_1dc){
},onDrop:function(_1dd,_1de,_1df){
},onBeforeEdit:function(node){
},onAfterEdit:function(node){
},onCancelEdit:function(node){
}};
})(jQuery);
(function($){
function init(_1e0){
$(_1e0).addClass("progressbar");
$(_1e0).html("<div class=\"progressbar-text\"></div><div class=\"progressbar-value\"><div class=\"progressbar-text\"></div></div>");
$(_1e0).bind("_resize",function(e,_1e1){
if($(this).hasClass("easyui-fluid")||_1e1){
_1e2(_1e0);
}
return false;
});
return $(_1e0);
};
function _1e2(_1e3,_1e4){
var opts=$.data(_1e3,"progressbar").options;
var bar=$.data(_1e3,"progressbar").bar;
if(_1e4){
opts.width=_1e4;
}
bar._size(opts);
bar.find("div.progressbar-text").css("width",bar.width());
bar.find("div.progressbar-text,div.progressbar-value").css({height:bar.height()+"px",lineHeight:bar.height()+"px"});
};
$.fn.progressbar=function(_1e5,_1e6){
if(typeof _1e5=="string"){
var _1e7=$.fn.progressbar.methods[_1e5];
if(_1e7){
return _1e7(this,_1e6);
}
}
_1e5=_1e5||{};
return this.each(function(){
var _1e8=$.data(this,"progressbar");
if(_1e8){
$.extend(_1e8.options,_1e5);
}else{
_1e8=$.data(this,"progressbar",{options:$.extend({},$.fn.progressbar.defaults,$.fn.progressbar.parseOptions(this),_1e5),bar:init(this)});
}
$(this).progressbar("setValue",_1e8.options.value);
_1e2(this);
});
};
$.fn.progressbar.methods={options:function(jq){
return $.data(jq[0],"progressbar").options;
},resize:function(jq,_1e9){
return jq.each(function(){
_1e2(this,_1e9);
});
},getValue:function(jq){
return $.data(jq[0],"progressbar").options.value;
},setValue:function(jq,_1ea){
if(_1ea<0){
_1ea=0;
}
if(_1ea>100){
_1ea=100;
}
return jq.each(function(){
var opts=$.data(this,"progressbar").options;
var text=opts.text.replace(/{value}/,_1ea);
var _1eb=opts.value;
opts.value=_1ea;
$(this).find("div.progressbar-value").width(_1ea+"%");
$(this).find("div.progressbar-text").html(text);
if(_1eb!=_1ea){
opts.onChange.call(this,_1ea,_1eb);
}
});
}};
$.fn.progressbar.parseOptions=function(_1ec){
return $.extend({},$.parser.parseOptions(_1ec,["width","height","text",{value:"number"}]));
};
$.fn.progressbar.defaults={width:"auto",height:22,value:0,text:"{value}%",onChange:function(_1ed,_1ee){
}};
})(jQuery);
(function($){
function init(_1ef){
$(_1ef).addClass("tooltip-f");
};
function _1f0(_1f1){
var opts=$.data(_1f1,"tooltip").options;
$(_1f1).unbind(".tooltip").bind(opts.showEvent+".tooltip",function(e){
$(_1f1).tooltip("show",e);
}).bind(opts.hideEvent+".tooltip",function(e){
$(_1f1).tooltip("hide",e);
}).bind("mousemove.tooltip",function(e){
if(opts.trackMouse){
opts.trackMouseX=e.pageX;
opts.trackMouseY=e.pageY;
$(_1f1).tooltip("reposition");
}
});
};
function _1f2(_1f3){
var _1f4=$.data(_1f3,"tooltip");
if(_1f4.showTimer){
clearTimeout(_1f4.showTimer);
_1f4.showTimer=null;
}
if(_1f4.hideTimer){
clearTimeout(_1f4.hideTimer);
_1f4.hideTimer=null;
}
};
function _1f5(_1f6){
var _1f7=$.data(_1f6,"tooltip");
if(!_1f7||!_1f7.tip){
return;
}
var opts=_1f7.options;
var tip=_1f7.tip;
var pos={left:-100000,top:-100000};
if($(_1f6).is(":visible")){
pos=_1f8(opts.position);
if(opts.position=="top"&&pos.top<0){
pos=_1f8("bottom");
}else{
if((opts.position=="bottom")&&(pos.top+tip._outerHeight()>$(window)._outerHeight()+$(document).scrollTop())){
pos=_1f8("top");
}
}
if(pos.left<0){
if(opts.position=="left"){
pos=_1f8("right");
}else{
$(_1f6).tooltip("arrow").css("left",tip._outerWidth()/2+pos.left);
pos.left=0;
}
}else{
if(pos.left+tip._outerWidth()>$(window)._outerWidth()+$(document)._scrollLeft()){
if(opts.position=="right"){
pos=_1f8("left");
}else{
var left=pos.left;
pos.left=$(window)._outerWidth()+$(document)._scrollLeft()-tip._outerWidth();
$(_1f6).tooltip("arrow").css("left",tip._outerWidth()/2-(pos.left-left));
}
}
}
}
tip.css({left:pos.left,top:pos.top,zIndex:(opts.zIndex!=undefined?opts.zIndex:($.fn.window?$.fn.window.defaults.zIndex++:""))});
opts.onPosition.call(_1f6,pos.left,pos.top);
function _1f8(_1f9){
opts.position=_1f9||"bottom";
tip.removeClass("tooltip-top tooltip-bottom tooltip-left tooltip-right").addClass("tooltip-"+opts.position);
var left,top;
var _1fa=$.isFunction(opts.deltaX)?opts.deltaX.call(_1f6,opts.position):opts.deltaX;
var _1fb=$.isFunction(opts.deltaY)?opts.deltaY.call(_1f6,opts.position):opts.deltaY;
if(opts.trackMouse){
t=$();
left=opts.trackMouseX+_1fa;
top=opts.trackMouseY+_1fb;
}else{
var t=$(_1f6);
left=t.offset().left+_1fa;
top=t.offset().top+_1fb;
}
switch(opts.position){
case "right":
left+=t._outerWidth()+12+(opts.trackMouse?12:0);
if(opts.valign=="middle"){
top-=(tip._outerHeight()-t._outerHeight())/2;
}
break;
case "left":
left-=tip._outerWidth()+12+(opts.trackMouse?12:0);
if(opts.valign=="middle"){
top-=(tip._outerHeight()-t._outerHeight())/2;
}
break;
case "top":
left-=(tip._outerWidth()-t._outerWidth())/2;
top-=tip._outerHeight()+12+(opts.trackMouse?12:0);
break;
case "bottom":
left-=(tip._outerWidth()-t._outerWidth())/2;
top+=t._outerHeight()+12+(opts.trackMouse?12:0);
break;
}
return {left:left,top:top};
};
};
function _1fc(_1fd,e){
var _1fe=$.data(_1fd,"tooltip");
var opts=_1fe.options;
var tip=_1fe.tip;
if(!tip){
tip=$("<div tabindex=\"-1\" class=\"tooltip\">"+"<div class=\"tooltip-content\"></div>"+"<div class=\"tooltip-arrow-outer\"></div>"+"<div class=\"tooltip-arrow\"></div>"+"</div>").appendTo("body");
_1fe.tip=tip;
_1ff(_1fd);
}
_1f2(_1fd);
_1fe.showTimer=setTimeout(function(){
$(_1fd).tooltip("reposition");
tip.show();
opts.onShow.call(_1fd,e);
var _200=tip.children(".tooltip-arrow-outer");
var _201=tip.children(".tooltip-arrow");
var bc="border-"+opts.position+"-color";
_200.add(_201).css({borderTopColor:"",borderBottomColor:"",borderLeftColor:"",borderRightColor:""});
_200.css(bc,tip.css(bc));
_201.css(bc,tip.css("backgroundColor"));
},opts.showDelay);
};
function _202(_203,e){
var _204=$.data(_203,"tooltip");
if(_204&&_204.tip){
_1f2(_203);
_204.hideTimer=setTimeout(function(){
_204.tip.hide();
_204.options.onHide.call(_203,e);
},_204.options.hideDelay);
}
};
function _1ff(_205,_206){
var _207=$.data(_205,"tooltip");
var opts=_207.options;
if(_206){
opts.content=_206;
}
if(!_207.tip){
return;
}
var cc=typeof opts.content=="function"?opts.content.call(_205):opts.content;
_207.tip.children(".tooltip-content").html(cc);
opts.onUpdate.call(_205,cc);
};
function _208(_209){
var _20a=$.data(_209,"tooltip");
if(_20a){
_1f2(_209);
var opts=_20a.options;
if(_20a.tip){
_20a.tip.remove();
}
if(opts._title){
$(_209).attr("title",opts._title);
}
$.removeData(_209,"tooltip");
$(_209).unbind(".tooltip").removeClass("tooltip-f");
opts.onDestroy.call(_209);
}
};
$.fn.tooltip=function(_20b,_20c){
if(typeof _20b=="string"){
return $.fn.tooltip.methods[_20b](this,_20c);
}
_20b=_20b||{};
return this.each(function(){
var _20d=$.data(this,"tooltip");
if(_20d){
$.extend(_20d.options,_20b);
}else{
$.data(this,"tooltip",{options:$.extend({},$.fn.tooltip.defaults,$.fn.tooltip.parseOptions(this),_20b)});
init(this);
}
_1f0(this);
_1ff(this);
});
};
$.fn.tooltip.methods={options:function(jq){
return $.data(jq[0],"tooltip").options;
},tip:function(jq){
return $.data(jq[0],"tooltip").tip;
},arrow:function(jq){
return jq.tooltip("tip").children(".tooltip-arrow-outer,.tooltip-arrow");
},show:function(jq,e){
return jq.each(function(){
_1fc(this,e);
});
},hide:function(jq,e){
return jq.each(function(){
_202(this,e);
});
},update:function(jq,_20e){
return jq.each(function(){
_1ff(this,_20e);
});
},reposition:function(jq){
return jq.each(function(){
_1f5(this);
});
},destroy:function(jq){
return jq.each(function(){
_208(this);
});
}};
$.fn.tooltip.parseOptions=function(_20f){
var t=$(_20f);
var opts=$.extend({},$.parser.parseOptions(_20f,["position","showEvent","hideEvent","content",{trackMouse:"boolean",deltaX:"number",deltaY:"number",showDelay:"number",hideDelay:"number"}]),{_title:t.attr("title")});
t.attr("title","");
if(!opts.content){
opts.content=opts._title;
}
return opts;
};
$.fn.tooltip.defaults={position:"bottom",valign:"middle",content:null,trackMouse:false,deltaX:0,deltaY:0,showEvent:"mouseenter",hideEvent:"mouseleave",showDelay:200,hideDelay:100,onShow:function(e){
},onHide:function(e){
},onUpdate:function(_210){
},onPosition:function(left,top){
},onDestroy:function(){
}};
})(jQuery);
(function($){
$.fn._remove=function(){
return this.each(function(){
$(this).remove();
try{
this.outerHTML="";
}
catch(err){
}
});
};
function _211(node){
node._remove();
};
function _212(_213,_214){
var _215=$.data(_213,"panel");
var opts=_215.options;
var _216=_215.panel;
var _217=_216.children(".panel-header");
var _218=_216.children(".panel-body");
var _219=_216.children(".panel-footer");
var _21a=(opts.halign=="left"||opts.halign=="right");
if(_214){
$.extend(opts,{width:_214.width,height:_214.height,minWidth:_214.minWidth,maxWidth:_214.maxWidth,minHeight:_214.minHeight,maxHeight:_214.maxHeight,left:_214.left,top:_214.top});
opts.hasResized=false;
}
var _21b=_216.outerWidth();
var _21c=_216.outerHeight();
_216._size(opts);
var _21d=_216.outerWidth();
var _21e=_216.outerHeight();
if(opts.hasResized&&(_21b==_21d&&_21c==_21e)){
return;
}
opts.hasResized=true;
if(!_21a){
_217._outerWidth(_216.width());
}
_218._outerWidth(_216.width());
if(!isNaN(parseInt(opts.height))){
if(_21a){
if(opts.header){
var _21f=$(opts.header)._outerWidth();
}else{
_217.css("width","");
var _21f=_217._outerWidth();
}
var _220=_217.find(".panel-title");
_21f+=Math.min(_220._outerWidth(),_220._outerHeight());
var _221=_216.height();
_217._outerWidth(_21f)._outerHeight(_221);
_220._outerWidth(_217.height());
_218._outerWidth(_216.width()-_21f-_219._outerWidth())._outerHeight(_221);
_219._outerHeight(_221);
_218.css({left:"",right:""}).css(opts.halign,(_217.position()[opts.halign]+_21f)+"px");
opts.panelCssWidth=_216.css("width");
if(opts.collapsed){
_216._outerWidth(_21f+_219._outerWidth());
}
}else{
_218._outerHeight(_216.height()-_217._outerHeight()-_219._outerHeight());
}
}else{
_218.css("height","");
var min=$.parser.parseValue("minHeight",opts.minHeight,_216.parent());
var max=$.parser.parseValue("maxHeight",opts.maxHeight,_216.parent());
var _222=_217._outerHeight()+_219._outerHeight()+_216._outerHeight()-_216.height();
_218._size("minHeight",min?(min-_222):"");
_218._size("maxHeight",max?(max-_222):"");
}
_216.css({height:(_21a?undefined:""),minHeight:"",maxHeight:"",left:opts.left,top:opts.top});
opts.onResize.apply(_213,[opts.width,opts.height]);
$(_213).panel("doLayout");
};
function _223(_224,_225){
var _226=$.data(_224,"panel");
var opts=_226.options;
var _227=_226.panel;
if(_225){
if(_225.left!=null){
opts.left=_225.left;
}
if(_225.top!=null){
opts.top=_225.top;
}
}
_227.css({left:opts.left,top:opts.top});
_227.find(".tooltip-f").each(function(){
$(this).tooltip("reposition");
});
opts.onMove.apply(_224,[opts.left,opts.top]);
};
function _228(_229){
$(_229).addClass("panel-body")._size("clear");
var _22a=$("<div class=\"panel\"></div>").insertBefore(_229);
_22a[0].appendChild(_229);
_22a.bind("_resize",function(e,_22b){
if($(this).hasClass("easyui-fluid")||_22b){
_212(_229,{});
}
return false;
});
return _22a;
};
function _22c(_22d){
var _22e=$.data(_22d,"panel");
var opts=_22e.options;
var _22f=_22e.panel;
_22f.css(opts.style);
_22f.addClass(opts.cls);
_22f.removeClass("panel-hleft panel-hright").addClass("panel-h"+opts.halign);
_230();
_231();
var _232=$(_22d).panel("header");
var body=$(_22d).panel("body");
var _233=$(_22d).siblings(".panel-footer");
if(opts.border){
_232.removeClass("panel-header-noborder");
body.removeClass("panel-body-noborder");
_233.removeClass("panel-footer-noborder");
}else{
_232.addClass("panel-header-noborder");
body.addClass("panel-body-noborder");
_233.addClass("panel-footer-noborder");
}
_232.addClass(opts.headerCls);
body.addClass(opts.bodyCls);
$(_22d).attr("id",opts.id||"");
if(opts.content){
$(_22d).panel("clear");
$(_22d).html(opts.content);
$.parser.parse($(_22d));
}
function _230(){
if(opts.noheader||(!opts.title&&!opts.header)){
_211(_22f.children(".panel-header"));
_22f.children(".panel-body").addClass("panel-body-noheader");
}else{
if(opts.header){
$(opts.header).addClass("panel-header").prependTo(_22f);
}else{
var _234=_22f.children(".panel-header");
if(!_234.length){
_234=$("<div class=\"panel-header\"></div>").prependTo(_22f);
}
if(!$.isArray(opts.tools)){
_234.find("div.panel-tool .panel-tool-a").appendTo(opts.tools);
}
_234.empty();
var _235=$("<div class=\"panel-title\"></div>").html(opts.title).appendTo(_234);
if(opts.iconCls){
_235.addClass("panel-with-icon");
$("<div class=\"panel-icon\"></div>").addClass(opts.iconCls).appendTo(_234);
}
if(opts.halign=="left"||opts.halign=="right"){
_235.addClass("panel-title-"+opts.titleDirection);
}
var tool=$("<div class=\"panel-tool\"></div>").appendTo(_234);
tool.bind("click",function(e){
e.stopPropagation();
});
if(opts.tools){
if($.isArray(opts.tools)){
$.map(opts.tools,function(t){
_236(tool,t.iconCls,eval(t.handler));
});
}else{
$(opts.tools).children().each(function(){
$(this).addClass($(this).attr("iconCls")).addClass("panel-tool-a").appendTo(tool);
});
}
}
if(opts.collapsible){
_236(tool,"panel-tool-collapse",function(){
if(opts.collapsed==true){
_257(_22d,true);
}else{
_248(_22d,true);
}
});
}
if(opts.minimizable){
_236(tool,"panel-tool-min",function(){
_25d(_22d);
});
}
if(opts.maximizable){
_236(tool,"panel-tool-max",function(){
if(opts.maximized==true){
_260(_22d);
}else{
_247(_22d);
}
});
}
if(opts.closable){
_236(tool,"panel-tool-close",function(){
_249(_22d);
});
}
}
_22f.children("div.panel-body").removeClass("panel-body-noheader");
}
};
function _236(c,icon,_237){
var a=$("<a href=\"javascript:;\"></a>").addClass(icon).appendTo(c);
a.bind("click",_237);
};
function _231(){
if(opts.footer){
$(opts.footer).addClass("panel-footer").appendTo(_22f);
$(_22d).addClass("panel-body-nobottom");
}else{
_22f.children(".panel-footer").remove();
$(_22d).removeClass("panel-body-nobottom");
}
};
};
function _238(_239,_23a){
var _23b=$.data(_239,"panel");
var opts=_23b.options;
if(_23c){
opts.queryParams=_23a;
}
if(!opts.href){
return;
}
if(!_23b.isLoaded||!opts.cache){
var _23c=$.extend({},opts.queryParams);
if(opts.onBeforeLoad.call(_239,_23c)==false){
return;
}
_23b.isLoaded=false;
if(opts.loadingMessage){
$(_239).panel("clear");
$(_239).html($("<div class=\"panel-loading\"></div>").html(opts.loadingMessage));
}
opts.loader.call(_239,_23c,function(data){
var _23d=opts.extractor.call(_239,data);
$(_239).panel("clear");
$(_239).html(_23d);
$.parser.parse($(_239));
opts.onLoad.apply(_239,arguments);
_23b.isLoaded=true;
},function(){
opts.onLoadError.apply(_239,arguments);
});
}
};
function _23e(_23f){
var t=$(_23f);
t.find(".combo-f").each(function(){
$(this).combo("destroy");
});
t.find(".m-btn").each(function(){
$(this).menubutton("destroy");
});
t.find(".s-btn").each(function(){
$(this).splitbutton("destroy");
});
t.find(".tooltip-f").each(function(){
$(this).tooltip("destroy");
});
t.children("div").each(function(){
$(this)._size("unfit");
});
t.empty();
};
function _240(_241){
$(_241).panel("doLayout",true);
};
function _242(_243,_244){
var _245=$.data(_243,"panel");
var opts=_245.options;
var _246=_245.panel;
if(_244!=true){
if(opts.onBeforeOpen.call(_243)==false){
return;
}
}
_246.stop(true,true);
if($.isFunction(opts.openAnimation)){
opts.openAnimation.call(_243,cb);
}else{
switch(opts.openAnimation){
case "slide":
_246.slideDown(opts.openDuration,cb);
break;
case "fade":
_246.fadeIn(opts.openDuration,cb);
break;
case "show":
_246.show(opts.openDuration,cb);
break;
default:
_246.show();
cb();
}
}
function cb(){
opts.closed=false;
opts.minimized=false;
var tool=_246.children(".panel-header").find("a.panel-tool-restore");
if(tool.length){
opts.maximized=true;
}
opts.onOpen.call(_243);
if(opts.maximized==true){
opts.maximized=false;
_247(_243);
}
if(opts.collapsed==true){
opts.collapsed=false;
_248(_243);
}
if(!opts.collapsed){
if(opts.href&&(!_245.isLoaded||!opts.cache)){
_238(_243);
_240(_243);
opts.doneLayout=true;
}
}
if(!opts.doneLayout){
opts.doneLayout=true;
_240(_243);
}
};
};
function _249(_24a,_24b){
var _24c=$.data(_24a,"panel");
var opts=_24c.options;
var _24d=_24c.panel;
if(_24b!=true){
if(opts.onBeforeClose.call(_24a)==false){
return;
}
}
_24d.find(".tooltip-f").each(function(){
$(this).tooltip("hide");
});
_24d.stop(true,true);
_24d._size("unfit");
if($.isFunction(opts.closeAnimation)){
opts.closeAnimation.call(_24a,cb);
}else{
switch(opts.closeAnimation){
case "slide":
_24d.slideUp(opts.closeDuration,cb);
break;
case "fade":
_24d.fadeOut(opts.closeDuration,cb);
break;
case "hide":
_24d.hide(opts.closeDuration,cb);
break;
default:
_24d.hide();
cb();
}
}
function cb(){
opts.closed=true;
opts.onClose.call(_24a);
};
};
function _24e(_24f,_250){
var _251=$.data(_24f,"panel");
var opts=_251.options;
var _252=_251.panel;
if(_250!=true){
if(opts.onBeforeDestroy.call(_24f)==false){
return;
}
}
$(_24f).panel("clear").panel("clear","footer");
_211(_252);
opts.onDestroy.call(_24f);
};
function _248(_253,_254){
var opts=$.data(_253,"panel").options;
var _255=$.data(_253,"panel").panel;
var body=_255.children(".panel-body");
var _256=_255.children(".panel-header");
var tool=_256.find("a.panel-tool-collapse");
if(opts.collapsed==true){
return;
}
body.stop(true,true);
if(opts.onBeforeCollapse.call(_253)==false){
return;
}
tool.addClass("panel-tool-expand");
if(_254==true){
if(opts.halign=="left"||opts.halign=="right"){
_255.animate({width:_256._outerWidth()+_255.children(".panel-footer")._outerWidth()},function(){
cb();
});
}else{
body.slideUp("normal",function(){
cb();
});
}
}else{
if(opts.halign=="left"||opts.halign=="right"){
_255._outerWidth(_256._outerWidth()+_255.children(".panel-footer")._outerWidth());
}
cb();
}
function cb(){
body.hide();
opts.collapsed=true;
opts.onCollapse.call(_253);
};
};
function _257(_258,_259){
var opts=$.data(_258,"panel").options;
var _25a=$.data(_258,"panel").panel;
var body=_25a.children(".panel-body");
var tool=_25a.children(".panel-header").find("a.panel-tool-collapse");
if(opts.collapsed==false){
return;
}
body.stop(true,true);
if(opts.onBeforeExpand.call(_258)==false){
return;
}
tool.removeClass("panel-tool-expand");
if(_259==true){
if(opts.halign=="left"||opts.halign=="right"){
body.show();
_25a.animate({width:opts.panelCssWidth},function(){
cb();
});
}else{
body.slideDown("normal",function(){
cb();
});
}
}else{
if(opts.halign=="left"||opts.halign=="right"){
_25a.css("width",opts.panelCssWidth);
}
cb();
}
function cb(){
body.show();
opts.collapsed=false;
opts.onExpand.call(_258);
_238(_258);
_240(_258);
};
};
function _247(_25b){
var opts=$.data(_25b,"panel").options;
var _25c=$.data(_25b,"panel").panel;
var tool=_25c.children(".panel-header").find("a.panel-tool-max");
if(opts.maximized==true){
return;
}
tool.addClass("panel-tool-restore");
if(!$.data(_25b,"panel").original){
$.data(_25b,"panel").original={width:opts.width,height:opts.height,left:opts.left,top:opts.top,fit:opts.fit};
}
opts.left=0;
opts.top=0;
opts.fit=true;
_212(_25b);
opts.minimized=false;
opts.maximized=true;
opts.onMaximize.call(_25b);
};
function _25d(_25e){
var opts=$.data(_25e,"panel").options;
var _25f=$.data(_25e,"panel").panel;
_25f._size("unfit");
_25f.hide();
opts.minimized=true;
opts.maximized=false;
opts.onMinimize.call(_25e);
};
function _260(_261){
var opts=$.data(_261,"panel").options;
var _262=$.data(_261,"panel").panel;
var tool=_262.children(".panel-header").find("a.panel-tool-max");
if(opts.maximized==false){
return;
}
_262.show();
tool.removeClass("panel-tool-restore");
$.extend(opts,$.data(_261,"panel").original);
_212(_261);
opts.minimized=false;
opts.maximized=false;
$.data(_261,"panel").original=null;
opts.onRestore.call(_261);
};
function _263(_264,_265){
$.data(_264,"panel").options.title=_265;
$(_264).panel("header").find("div.panel-title").html(_265);
};
var _266=null;
$(window).unbind(".panel").bind("resize.panel",function(){
if(_266){
clearTimeout(_266);
}
_266=setTimeout(function(){
var _267=$("body.layout");
if(_267.length){
_267.layout("resize");
$("body").children(".easyui-fluid:visible").each(function(){
$(this).triggerHandler("_resize");
});
}else{
$("body").panel("doLayout");
}
_266=null;
},100);
});
$.fn.panel=function(_268,_269){
if(typeof _268=="string"){
return $.fn.panel.methods[_268](this,_269);
}
_268=_268||{};
return this.each(function(){
var _26a=$.data(this,"panel");
var opts;
if(_26a){
opts=$.extend(_26a.options,_268);
_26a.isLoaded=false;
}else{
opts=$.extend({},$.fn.panel.defaults,$.fn.panel.parseOptions(this),_268);
$(this).attr("title","");
_26a=$.data(this,"panel",{options:opts,panel:_228(this),isLoaded:false});
}
_22c(this);
$(this).show();
if(opts.doSize==true){
_26a.panel.css("display","block");
_212(this);
}
if(opts.closed==true||opts.minimized==true){
_26a.panel.hide();
}else{
_242(this);
}
});
};
$.fn.panel.methods={options:function(jq){
return $.data(jq[0],"panel").options;
},panel:function(jq){
return $.data(jq[0],"panel").panel;
},header:function(jq){
return $.data(jq[0],"panel").panel.children(".panel-header");
},footer:function(jq){
return jq.panel("panel").children(".panel-footer");
},body:function(jq){
return $.data(jq[0],"panel").panel.children(".panel-body");
},setTitle:function(jq,_26b){
return jq.each(function(){
_263(this,_26b);
});
},open:function(jq,_26c){
return jq.each(function(){
_242(this,_26c);
});
},close:function(jq,_26d){
return jq.each(function(){
_249(this,_26d);
});
},destroy:function(jq,_26e){
return jq.each(function(){
_24e(this,_26e);
});
},clear:function(jq,type){
return jq.each(function(){
_23e(type=="footer"?$(this).panel("footer"):this);
});
},refresh:function(jq,href){
return jq.each(function(){
var _26f=$.data(this,"panel");
_26f.isLoaded=false;
if(href){
if(typeof href=="string"){
_26f.options.href=href;
}else{
_26f.options.queryParams=href;
}
}
_238(this);
});
},resize:function(jq,_270){
return jq.each(function(){
_212(this,_270||{});
});
},doLayout:function(jq,all){
return jq.each(function(){
_271(this,"body");
_271($(this).siblings(".panel-footer")[0],"footer");
function _271(_272,type){
if(!_272){
return;
}
var _273=_272==$("body")[0];
var s=$(_272).find("div.panel:visible,div.accordion:visible,div.tabs-container:visible,div.layout:visible,.easyui-fluid:visible").filter(function(_274,el){
var p=$(el).parents(".panel-"+type+":first");
return _273?p.length==0:p[0]==_272;
});
s.each(function(){
$(this).triggerHandler("_resize",[all||false]);
});
};
});
},move:function(jq,_275){
return jq.each(function(){
_223(this,_275);
});
},maximize:function(jq){
return jq.each(function(){
_247(this);
});
},minimize:function(jq){
return jq.each(function(){
_25d(this);
});
},restore:function(jq){
return jq.each(function(){
_260(this);
});
},collapse:function(jq,_276){
return jq.each(function(){
_248(this,_276);
});
},expand:function(jq,_277){
return jq.each(function(){
_257(this,_277);
});
}};
$.fn.panel.parseOptions=function(_278){
var t=$(_278);
var hh=t.children(".panel-header,header");
var ff=t.children(".panel-footer,footer");
return $.extend({},$.parser.parseOptions(_278,["id","width","height","left","top","title","iconCls","cls","headerCls","bodyCls","tools","href","method","header","footer","halign","titleDirection",{cache:"boolean",fit:"boolean",border:"boolean",noheader:"boolean"},{collapsible:"boolean",minimizable:"boolean",maximizable:"boolean"},{closable:"boolean",collapsed:"boolean",minimized:"boolean",maximized:"boolean",closed:"boolean"},"openAnimation","closeAnimation",{openDuration:"number",closeDuration:"number"},]),{loadingMessage:(t.attr("loadingMessage")!=undefined?t.attr("loadingMessage"):undefined),header:(hh.length?hh.removeClass("panel-header"):undefined),footer:(ff.length?ff.removeClass("panel-footer"):undefined)});
};
$.fn.panel.defaults={id:null,title:null,iconCls:null,width:"auto",height:"auto",left:null,top:null,cls:null,headerCls:null,bodyCls:null,style:{},href:null,cache:true,fit:false,border:true,doSize:true,noheader:false,content:null,halign:"top",titleDirection:"down",collapsible:false,minimizable:false,maximizable:false,closable:false,collapsed:false,minimized:false,maximized:false,closed:false,openAnimation:false,openDuration:400,closeAnimation:false,closeDuration:400,tools:null,footer:null,header:null,queryParams:{},method:"get",href:null,loadingMessage:"Loading...",loader:function(_279,_27a,_27b){
var opts=$(this).panel("options");
if(!opts.href){
return false;
}
$.ajax({type:opts.method,url:opts.href,cache:false,data:_279,dataType:"html",success:function(data){
_27a(data);
},error:function(){
_27b.apply(this,arguments);
}});
},extractor:function(data){
var _27c=/<body[^>]*>((.|[\n\r])*)<\/body>/im;
var _27d=_27c.exec(data);
if(_27d){
return _27d[1];
}else{
return data;
}
},onBeforeLoad:function(_27e){
},onLoad:function(){
},onLoadError:function(){
},onBeforeOpen:function(){
},onOpen:function(){
},onBeforeClose:function(){
},onClose:function(){
},onBeforeDestroy:function(){
},onDestroy:function(){
},onResize:function(_27f,_280){
},onMove:function(left,top){
},onMaximize:function(){
},onRestore:function(){
},onMinimize:function(){
},onBeforeCollapse:function(){
},onBeforeExpand:function(){
},onCollapse:function(){
},onExpand:function(){
}};
})(jQuery);
(function($){
function _281(_282,_283){
var _284=$.data(_282,"window");
if(_283){
if(_283.left!=null){
_284.options.left=_283.left;
}
if(_283.top!=null){
_284.options.top=_283.top;
}
}
$(_282).panel("move",_284.options);
if(_284.shadow){
_284.shadow.css({left:_284.options.left,top:_284.options.top});
}
};
function _285(_286,_287){
var opts=$.data(_286,"window").options;
var pp=$(_286).window("panel");
var _288=pp._outerWidth();
if(opts.inline){
var _289=pp.parent();
opts.left=Math.ceil((_289.width()-_288)/2+_289.scrollLeft());
}else{
opts.left=Math.ceil(($(window)._outerWidth()-_288)/2+$(document).scrollLeft());
}
if(_287){
_281(_286);
}
};
function _28a(_28b,_28c){
var opts=$.data(_28b,"window").options;
var pp=$(_28b).window("panel");
var _28d=pp._outerHeight();
if(opts.inline){
var _28e=pp.parent();
opts.top=Math.ceil((_28e.height()-_28d)/2+_28e.scrollTop());
}else{
opts.top=Math.ceil(($(window)._outerHeight()-_28d)/2+$(document).scrollTop());
}
if(_28c){
_281(_28b);
}
};
function _28f(_290){
var _291=$.data(_290,"window");
var opts=_291.options;
var win=$(_290).panel($.extend({},_291.options,{border:false,doSize:true,closed:true,cls:"window "+(!opts.border?"window-thinborder window-noborder ":(opts.border=="thin"?"window-thinborder ":""))+(opts.cls||""),headerCls:"window-header "+(opts.headerCls||""),bodyCls:"window-body "+(opts.noheader?"window-body-noheader ":" ")+(opts.bodyCls||""),onBeforeDestroy:function(){
if(opts.onBeforeDestroy.call(_290)==false){
return false;
}
if(_291.shadow){
_291.shadow.remove();
}
if(_291.mask){
_291.mask.remove();
}
},onClose:function(){
if(_291.shadow){
_291.shadow.hide();
}
if(_291.mask){
_291.mask.hide();
}
opts.onClose.call(_290);
},onOpen:function(){
if(_291.mask){
_291.mask.css($.extend({display:"block",zIndex:$.fn.window.defaults.zIndex++},$.fn.window.getMaskSize(_290)));
}
if(_291.shadow){
_291.shadow.css({display:"block",zIndex:$.fn.window.defaults.zIndex++,left:opts.left,top:opts.top,width:_291.window._outerWidth(),height:_291.window._outerHeight()});
}
_291.window.css("z-index",$.fn.window.defaults.zIndex++);
opts.onOpen.call(_290);
},onResize:function(_292,_293){
var _294=$(this).panel("options");
$.extend(opts,{width:_294.width,height:_294.height,left:_294.left,top:_294.top});
if(_291.shadow){
_291.shadow.css({left:opts.left,top:opts.top,width:_291.window._outerWidth(),height:_291.window._outerHeight()});
}
opts.onResize.call(_290,_292,_293);
},onMinimize:function(){
if(_291.shadow){
_291.shadow.hide();
}
if(_291.mask){
_291.mask.hide();
}
_291.options.onMinimize.call(_290);
},onBeforeCollapse:function(){
if(opts.onBeforeCollapse.call(_290)==false){
return false;
}
if(_291.shadow){
_291.shadow.hide();
}
},onExpand:function(){
if(_291.shadow){
_291.shadow.show();
}
opts.onExpand.call(_290);
}}));
_291.window=win.panel("panel");
if(_291.mask){
_291.mask.remove();
}
if(opts.modal){
_291.mask=$("<div class=\"window-mask\" style=\"display:none\"></div>").insertAfter(_291.window);
}
if(_291.shadow){
_291.shadow.remove();
}
if(opts.shadow){
_291.shadow=$("<div class=\"window-shadow\" style=\"display:none\"></div>").insertAfter(_291.window);
}
var _295=opts.closed;
if(opts.left==null){
_285(_290);
}
if(opts.top==null){
_28a(_290);
}
_281(_290);
if(!_295){
win.window("open");
}
};
function _296(left,top,_297,_298){
var _299=this;
var _29a=$.data(_299,"window");
var opts=_29a.options;
if(!opts.constrain){
return {};
}
if($.isFunction(opts.constrain)){
return opts.constrain.call(_299,left,top,_297,_298);
}
var win=$(_299).window("window");
var _29b=opts.inline?win.parent():$(window);
if(left<0){
left=0;
}
if(top<_29b.scrollTop()){
top=_29b.scrollTop();
}
if(left+_297>_29b.width()){
if(_297==win.outerWidth()){
left=_29b.width()-_297;
}else{
_297=_29b.width()-left;
}
}
if(top-_29b.scrollTop()+_298>_29b.height()){
if(_298==win.outerHeight()){
top=_29b.height()-_298+_29b.scrollTop();
}else{
_298=_29b.height()-top+_29b.scrollTop();
}
}
return {left:left,top:top,width:_297,height:_298};
};
function _29c(_29d){
var _29e=$.data(_29d,"window");
_29e.window.draggable({handle:">div.panel-header>div.panel-title",disabled:_29e.options.draggable==false,onBeforeDrag:function(e){
if(_29e.mask){
_29e.mask.css("z-index",$.fn.window.defaults.zIndex++);
}
if(_29e.shadow){
_29e.shadow.css("z-index",$.fn.window.defaults.zIndex++);
}
_29e.window.css("z-index",$.fn.window.defaults.zIndex++);
},onStartDrag:function(e){
_29f(e);
},onDrag:function(e){
_2a0(e);
return false;
},onStopDrag:function(e){
_2a1(e,"move");
}});
_29e.window.resizable({disabled:_29e.options.resizable==false,onStartResize:function(e){
_29f(e);
},onResize:function(e){
_2a0(e);
return false;
},onStopResize:function(e){
_2a1(e,"resize");
}});
function _29f(e){
if(_29e.pmask){
_29e.pmask.remove();
}
_29e.pmask=$("<div class=\"window-proxy-mask\"></div>").insertAfter(_29e.window);
_29e.pmask.css({display:"none",zIndex:$.fn.window.defaults.zIndex++,left:e.data.left,top:e.data.top,width:_29e.window._outerWidth(),height:_29e.window._outerHeight()});
if(_29e.proxy){
_29e.proxy.remove();
}
_29e.proxy=$("<div class=\"window-proxy\"></div>").insertAfter(_29e.window);
_29e.proxy.css({display:"none",zIndex:$.fn.window.defaults.zIndex++,left:e.data.left,top:e.data.top});
_29e.proxy._outerWidth(e.data.width)._outerHeight(e.data.height);
_29e.proxy.hide();
setTimeout(function(){
if(_29e.pmask){
_29e.pmask.show();
}
if(_29e.proxy){
_29e.proxy.show();
}
},500);
};
function _2a0(e){
$.extend(e.data,_296.call(_29d,e.data.left,e.data.top,e.data.width,e.data.height));
_29e.pmask.show();
_29e.proxy.css({display:"block",left:e.data.left,top:e.data.top});
_29e.proxy._outerWidth(e.data.width);
_29e.proxy._outerHeight(e.data.height);
};
function _2a1(e,_2a2){
$.extend(e.data,_296.call(_29d,e.data.left,e.data.top,e.data.width+0.1,e.data.height+0.1));
$(_29d).window(_2a2,e.data);
_29e.pmask.remove();
_29e.pmask=null;
_29e.proxy.remove();
_29e.proxy=null;
};
};
$(function(){
if(!$._positionFixed){
$(window).resize(function(){
$("body>div.window-mask:visible").css({width:"",height:""});
setTimeout(function(){
$("body>div.window-mask:visible").css($.fn.window.getMaskSize());
},50);
});
}
});
$.fn.window=function(_2a3,_2a4){
if(typeof _2a3=="string"){
var _2a5=$.fn.window.methods[_2a3];
if(_2a5){
return _2a5(this,_2a4);
}else{
return this.panel(_2a3,_2a4);
}
}
_2a3=_2a3||{};
return this.each(function(){
var _2a6=$.data(this,"window");
if(_2a6){
$.extend(_2a6.options,_2a3);
}else{
_2a6=$.data(this,"window",{options:$.extend({},$.fn.window.defaults,$.fn.window.parseOptions(this),_2a3)});
if(!_2a6.options.inline){
document.body.appendChild(this);
}
}
_28f(this);
_29c(this);
});
};
$.fn.window.methods={options:function(jq){
var _2a7=jq.panel("options");
var _2a8=$.data(jq[0],"window").options;
return $.extend(_2a8,{closed:_2a7.closed,collapsed:_2a7.collapsed,minimized:_2a7.minimized,maximized:_2a7.maximized});
},window:function(jq){
return $.data(jq[0],"window").window;
},move:function(jq,_2a9){
return jq.each(function(){
_281(this,_2a9);
});
},hcenter:function(jq){
return jq.each(function(){
_285(this,true);
});
},vcenter:function(jq){
return jq.each(function(){
_28a(this,true);
});
},center:function(jq){
return jq.each(function(){
_285(this);
_28a(this);
_281(this);
});
}};
$.fn.window.getMaskSize=function(_2aa){
var _2ab=$(_2aa).data("window");
if(_2ab&&_2ab.options.inline){
return {};
}else{
if($._positionFixed){
return {position:"fixed"};
}else{
return {width:$(document).width(),height:$(document).height()};
}
}
};
$.fn.window.parseOptions=function(_2ac){
return $.extend({},$.fn.panel.parseOptions(_2ac),$.parser.parseOptions(_2ac,[{draggable:"boolean",resizable:"boolean",shadow:"boolean",modal:"boolean",inline:"boolean"}]));
};
$.fn.window.defaults=$.extend({},$.fn.panel.defaults,{zIndex:9000,draggable:true,resizable:true,shadow:true,modal:false,border:true,inline:false,title:"New Window",collapsible:true,minimizable:true,maximizable:true,closable:true,closed:false,constrain:false});
})(jQuery);
(function($){
function _2ad(_2ae){
var opts=$.data(_2ae,"dialog").options;
opts.inited=false;
$(_2ae).window($.extend({},opts,{onResize:function(w,h){
if(opts.inited){
_2b3(this);
opts.onResize.call(this,w,h);
}
}}));
var win=$(_2ae).window("window");
if(opts.toolbar){
if($.isArray(opts.toolbar)){
$(_2ae).siblings("div.dialog-toolbar").remove();
var _2af=$("<div class=\"dialog-toolbar\"><table cellspacing=\"0\" cellpadding=\"0\"><tr></tr></table></div>").appendTo(win);
var tr=_2af.find("tr");
for(var i=0;i<opts.toolbar.length;i++){
var btn=opts.toolbar[i];
if(btn=="-"){
$("<td><div class=\"dialog-tool-separator\"></div></td>").appendTo(tr);
}else{
var td=$("<td></td>").appendTo(tr);
var tool=$("<a href=\"javascript:;\"></a>").appendTo(td);
tool[0].onclick=eval(btn.handler||function(){
});
tool.linkbutton($.extend({},btn,{plain:true}));
}
}
}else{
$(opts.toolbar).addClass("dialog-toolbar").appendTo(win);
$(opts.toolbar).show();
}
}else{
$(_2ae).siblings("div.dialog-toolbar").remove();
}
if(opts.buttons){
if($.isArray(opts.buttons)){
$(_2ae).siblings("div.dialog-button").remove();
var _2b0=$("<div class=\"dialog-button\"></div>").appendTo(win);
for(var i=0;i<opts.buttons.length;i++){
var p=opts.buttons[i];
var _2b1=$("<a href=\"javascript:;\"></a>").appendTo(_2b0);
if(p.handler){
_2b1[0].onclick=p.handler;
}
_2b1.linkbutton(p);
}
}else{
$(opts.buttons).addClass("dialog-button").appendTo(win);
$(opts.buttons).show();
}
}else{
$(_2ae).siblings("div.dialog-button").remove();
}
opts.inited=true;
var _2b2=opts.closed;
win.show();
$(_2ae).window("resize",{});
if(_2b2){
win.hide();
}
};
function _2b3(_2b4,_2b5){
var t=$(_2b4);
var opts=t.dialog("options");
var _2b6=opts.noheader;
var tb=t.siblings(".dialog-toolbar");
var bb=t.siblings(".dialog-button");
tb.insertBefore(_2b4).css({borderTopWidth:(_2b6?1:0),top:(_2b6?tb.length:0)});
bb.insertAfter(_2b4);
tb.add(bb)._outerWidth(t._outerWidth()).find(".easyui-fluid:visible").each(function(){
$(this).triggerHandler("_resize");
});
var _2b7=tb._outerHeight()+bb._outerHeight();
if(!isNaN(parseInt(opts.height))){
t._outerHeight(t._outerHeight()-_2b7);
}else{
var _2b8=t._size("min-height");
if(_2b8){
t._size("min-height",_2b8-_2b7);
}
var _2b9=t._size("max-height");
if(_2b9){
t._size("max-height",_2b9-_2b7);
}
}
var _2ba=$.data(_2b4,"window").shadow;
if(_2ba){
var cc=t.panel("panel");
_2ba.css({width:cc._outerWidth(),height:cc._outerHeight()});
}
};
$.fn.dialog=function(_2bb,_2bc){
if(typeof _2bb=="string"){
var _2bd=$.fn.dialog.methods[_2bb];
if(_2bd){
return _2bd(this,_2bc);
}else{
return this.window(_2bb,_2bc);
}
}
_2bb=_2bb||{};
return this.each(function(){
var _2be=$.data(this,"dialog");
if(_2be){
$.extend(_2be.options,_2bb);
}else{
$.data(this,"dialog",{options:$.extend({},$.fn.dialog.defaults,$.fn.dialog.parseOptions(this),_2bb)});
}
_2ad(this);
});
};
$.fn.dialog.methods={options:function(jq){
var _2bf=$.data(jq[0],"dialog").options;
var _2c0=jq.panel("options");
$.extend(_2bf,{width:_2c0.width,height:_2c0.height,left:_2c0.left,top:_2c0.top,closed:_2c0.closed,collapsed:_2c0.collapsed,minimized:_2c0.minimized,maximized:_2c0.maximized});
return _2bf;
},dialog:function(jq){
return jq.window("window");
}};
$.fn.dialog.parseOptions=function(_2c1){
var t=$(_2c1);
return $.extend({},$.fn.window.parseOptions(_2c1),$.parser.parseOptions(_2c1,["toolbar","buttons"]),{toolbar:(t.children(".dialog-toolbar").length?t.children(".dialog-toolbar").removeClass("dialog-toolbar"):undefined),buttons:(t.children(".dialog-button").length?t.children(".dialog-button").removeClass("dialog-button"):undefined)});
};
$.fn.dialog.defaults=$.extend({},$.fn.window.defaults,{title:"New Dialog",collapsible:false,minimizable:false,maximizable:false,resizable:false,toolbar:null,buttons:null});
})(jQuery);
(function($){
function _2c2(){
$(document).unbind(".messager").bind("keydown.messager",function(e){
if(e.keyCode==27){
$("body").children("div.messager-window").children("div.messager-body").each(function(){
$(this).dialog("close");
});
}else{
if(e.keyCode==9){
var win=$("body").children("div.messager-window");
if(!win.length){
return;
}
var _2c3=win.find(".messager-input,.messager-button .l-btn");
for(var i=0;i<_2c3.length;i++){
if($(_2c3[i]).is(":focus")){
$(_2c3[i>=_2c3.length-1?0:i+1]).focus();
return false;
}
}
}else{
if(e.keyCode==13){
var _2c4=$(e.target).closest("input.messager-input");
if(_2c4.length){
var dlg=_2c4.closest(".messager-body");
_2c5(dlg,_2c4.val());
}
}
}
}
});
};
function _2c6(){
$(document).unbind(".messager");
};
function _2c7(_2c8){
var opts=$.extend({},$.messager.defaults,{modal:false,shadow:false,draggable:false,resizable:false,closed:true,style:{left:"",top:"",right:0,zIndex:$.fn.window.defaults.zIndex++,bottom:-document.body.scrollTop-document.documentElement.scrollTop},title:"",width:300,height:150,minHeight:0,showType:"slide",showSpeed:600,content:_2c8.msg,timeout:4000},_2c8);
var dlg=$("<div class=\"messager-body\"></div>").appendTo("body");
dlg.dialog($.extend({},opts,{noheader:(opts.title?false:true),openAnimation:(opts.showType),closeAnimation:(opts.showType=="show"?"hide":opts.showType),openDuration:opts.showSpeed,closeDuration:opts.showSpeed,onOpen:function(){
dlg.dialog("dialog").hover(function(){
if(opts.timer){
clearTimeout(opts.timer);
}
},function(){
_2c9();
});
_2c9();
function _2c9(){
if(opts.timeout>0){
opts.timer=setTimeout(function(){
if(dlg.length&&dlg.data("dialog")){
dlg.dialog("close");
}
},opts.timeout);
}
};
if(_2c8.onOpen){
_2c8.onOpen.call(this);
}else{
opts.onOpen.call(this);
}
},onClose:function(){
if(opts.timer){
clearTimeout(opts.timer);
}
if(_2c8.onClose){
_2c8.onClose.call(this);
}else{
opts.onClose.call(this);
}
dlg.dialog("destroy");
}}));
dlg.dialog("dialog").css(opts.style);
dlg.dialog("open");
return dlg;
};
function _2ca(_2cb){
_2c2();
var dlg=$("<div class=\"messager-body\"></div>").appendTo("body");
dlg.dialog($.extend({},_2cb,{noheader:(_2cb.title?false:true),onClose:function(){
_2c6();
if(_2cb.onClose){
_2cb.onClose.call(this);
}
dlg.dialog("destroy");
}}));
var win=dlg.dialog("dialog").addClass("messager-window");
win.find(".dialog-button").addClass("messager-button").find("a:first").focus();
return dlg;
};
function _2c5(dlg,_2cc){
var opts=dlg.dialog("options");
dlg.dialog("close");
opts.fn(_2cc);
};
$.messager={show:function(_2cd){
return _2c7(_2cd);
},alert:function(_2ce,msg,icon,fn){
var opts=typeof _2ce=="object"?_2ce:{title:_2ce,msg:msg,icon:icon,fn:fn};
var cls=opts.icon?"messager-icon messager-"+opts.icon:"";
opts=$.extend({},$.messager.defaults,{content:"<div class=\""+cls+"\"></div>"+"<div>"+opts.msg+"</div>"+"<div style=\"clear:both;\"/>"},opts);
if(!opts.buttons){
opts.buttons=[{text:opts.ok,onClick:function(){
_2c5(dlg);
}}];
}
var dlg=_2ca(opts);
return dlg;
},confirm:function(_2cf,msg,fn){
var opts=typeof _2cf=="object"?_2cf:{title:_2cf,msg:msg,fn:fn};
opts=$.extend({},$.messager.defaults,{content:"<div class=\"messager-icon messager-question\"></div>"+"<div>"+opts.msg+"</div>"+"<div style=\"clear:both;\"/>"},opts);
if(!opts.buttons){
opts.buttons=[{text:opts.ok,onClick:function(){
_2c5(dlg,true);
}},{text:opts.cancel,onClick:function(){
_2c5(dlg,false);
}}];
}
var dlg=_2ca(opts);
return dlg;
},prompt:function(_2d0,msg,fn){
var opts=typeof _2d0=="object"?_2d0:{title:_2d0,msg:msg,fn:fn};
opts=$.extend({},$.messager.defaults,{content:"<div class=\"messager-icon messager-question\"></div>"+"<div>"+opts.msg+"</div>"+"<br/>"+"<div style=\"clear:both;\"/>"+"<div><input class=\"messager-input\" type=\"text\"/></div>"},opts);
if(!opts.buttons){
opts.buttons=[{text:opts.ok,onClick:function(){
_2c5(dlg,dlg.find(".messager-input").val());
}},{text:opts.cancel,onClick:function(){
_2c5(dlg);
}}];
}
var dlg=_2ca(opts);
dlg.find(".messager-input").focus();
return dlg;
},progress:function(_2d1){
var _2d2={bar:function(){
return $("body>div.messager-window").find("div.messager-p-bar");
},close:function(){
var dlg=$("body>div.messager-window>div.messager-body:has(div.messager-progress)");
if(dlg.length){
dlg.dialog("close");
}
}};
if(typeof _2d1=="string"){
var _2d3=_2d2[_2d1];
return _2d3();
}
_2d1=_2d1||{};
var opts=$.extend({},{title:"",minHeight:0,content:undefined,msg:"",text:undefined,interval:300},_2d1);
var dlg=_2ca($.extend({},$.messager.defaults,{content:"<div class=\"messager-progress\"><div class=\"messager-p-msg\">"+opts.msg+"</div><div class=\"messager-p-bar\"></div></div>",closable:false,doSize:false},opts,{onClose:function(){
if(this.timer){
clearInterval(this.timer);
}
if(_2d1.onClose){
_2d1.onClose.call(this);
}else{
$.messager.defaults.onClose.call(this);
}
}}));
var bar=dlg.find("div.messager-p-bar");
bar.progressbar({text:opts.text});
dlg.dialog("resize");
if(opts.interval){
dlg[0].timer=setInterval(function(){
var v=bar.progressbar("getValue");
v+=10;
if(v>100){
v=0;
}
bar.progressbar("setValue",v);
},opts.interval);
}
return dlg;
}};
$.messager.defaults=$.extend({},$.fn.dialog.defaults,{ok:"Ok",cancel:"Cancel",width:300,height:"auto",minHeight:150,modal:true,collapsible:false,minimizable:false,maximizable:false,resizable:false,fn:function(){
}});
})(jQuery);
(function($){
function _2d4(_2d5,_2d6){
var _2d7=$.data(_2d5,"accordion");
var opts=_2d7.options;
var _2d8=_2d7.panels;
var cc=$(_2d5);
var _2d9=(opts.halign=="left"||opts.halign=="right");
cc.children(".panel-last").removeClass("panel-last");
cc.children(".panel:last").addClass("panel-last");
if(_2d6){
$.extend(opts,{width:_2d6.width,height:_2d6.height});
}
cc._size(opts);
var _2da=0;
var _2db="auto";
var _2dc=cc.find(">.panel>.accordion-header");
if(_2dc.length){
if(_2d9){
$(_2d8[0]).panel("resize",{width:cc.width(),height:cc.height()});
_2da=$(_2dc[0])._outerWidth();
}else{
_2da=$(_2dc[0]).css("height","")._outerHeight();
}
}
if(!isNaN(parseInt(opts.height))){
if(_2d9){
_2db=cc.width()-_2da*_2dc.length;
}else{
_2db=cc.height()-_2da*_2dc.length;
}
}
_2dd(true,_2db-_2dd(false));
function _2dd(_2de,_2df){
var _2e0=0;
for(var i=0;i<_2d8.length;i++){
var p=_2d8[i];
if(_2d9){
var h=p.panel("header")._outerWidth(_2da);
}else{
var h=p.panel("header")._outerHeight(_2da);
}
if(p.panel("options").collapsible==_2de){
var _2e1=isNaN(_2df)?undefined:(_2df+_2da*h.length);
if(_2d9){
p.panel("resize",{height:cc.height(),width:(_2de?_2e1:undefined)});
_2e0+=p.panel("panel")._outerWidth()-_2da*h.length;
}else{
p.panel("resize",{width:cc.width(),height:(_2de?_2e1:undefined)});
_2e0+=p.panel("panel").outerHeight()-_2da*h.length;
}
}
}
return _2e0;
};
};
function _2e2(_2e3,_2e4,_2e5,all){
var _2e6=$.data(_2e3,"accordion").panels;
var pp=[];
for(var i=0;i<_2e6.length;i++){
var p=_2e6[i];
if(_2e4){
if(p.panel("options")[_2e4]==_2e5){
pp.push(p);
}
}else{
if(p[0]==$(_2e5)[0]){
return i;
}
}
}
if(_2e4){
return all?pp:(pp.length?pp[0]:null);
}else{
return -1;
}
};
function _2e7(_2e8){
return _2e2(_2e8,"collapsed",false,true);
};
function _2e9(_2ea){
var pp=_2e7(_2ea);
return pp.length?pp[0]:null;
};
function _2eb(_2ec,_2ed){
return _2e2(_2ec,null,_2ed);
};
function _2ee(_2ef,_2f0){
var _2f1=$.data(_2ef,"accordion").panels;
if(typeof _2f0=="number"){
if(_2f0<0||_2f0>=_2f1.length){
return null;
}else{
return _2f1[_2f0];
}
}
return _2e2(_2ef,"title",_2f0);
};
function _2f2(_2f3){
var opts=$.data(_2f3,"accordion").options;
var cc=$(_2f3);
if(opts.border){
cc.removeClass("accordion-noborder");
}else{
cc.addClass("accordion-noborder");
}
};
function init(_2f4){
var _2f5=$.data(_2f4,"accordion");
var cc=$(_2f4);
cc.addClass("accordion");
_2f5.panels=[];
cc.children("div").each(function(){
var opts=$.extend({},$.parser.parseOptions(this),{selected:($(this).attr("selected")?true:undefined)});
var pp=$(this);
_2f5.panels.push(pp);
_2f7(_2f4,pp,opts);
});
cc.bind("_resize",function(e,_2f6){
if($(this).hasClass("easyui-fluid")||_2f6){
_2d4(_2f4);
}
return false;
});
};
function _2f7(_2f8,pp,_2f9){
var opts=$.data(_2f8,"accordion").options;
pp.panel($.extend({},{collapsible:true,minimizable:false,maximizable:false,closable:false,doSize:false,collapsed:true,headerCls:"accordion-header",bodyCls:"accordion-body",halign:opts.halign},_2f9,{onBeforeExpand:function(){
if(_2f9.onBeforeExpand){
if(_2f9.onBeforeExpand.call(this)==false){
return false;
}
}
if(!opts.multiple){
var all=$.grep(_2e7(_2f8),function(p){
return p.panel("options").collapsible;
});
for(var i=0;i<all.length;i++){
_301(_2f8,_2eb(_2f8,all[i]));
}
}
var _2fa=$(this).panel("header");
_2fa.addClass("accordion-header-selected");
_2fa.find(".accordion-collapse").removeClass("accordion-expand");
},onExpand:function(){
$(_2f8).find(">.panel-last>.accordion-header").removeClass("accordion-header-border");
if(_2f9.onExpand){
_2f9.onExpand.call(this);
}
opts.onSelect.call(_2f8,$(this).panel("options").title,_2eb(_2f8,this));
},onBeforeCollapse:function(){
if(_2f9.onBeforeCollapse){
if(_2f9.onBeforeCollapse.call(this)==false){
return false;
}
}
$(_2f8).find(">.panel-last>.accordion-header").addClass("accordion-header-border");
var _2fb=$(this).panel("header");
_2fb.removeClass("accordion-header-selected");
_2fb.find(".accordion-collapse").addClass("accordion-expand");
},onCollapse:function(){
if(isNaN(parseInt(opts.height))){
$(_2f8).find(">.panel-last>.accordion-header").removeClass("accordion-header-border");
}
if(_2f9.onCollapse){
_2f9.onCollapse.call(this);
}
opts.onUnselect.call(_2f8,$(this).panel("options").title,_2eb(_2f8,this));
}}));
var _2fc=pp.panel("header");
var tool=_2fc.children("div.panel-tool");
tool.children("a.panel-tool-collapse").hide();
var t=$("<a href=\"javascript:;\"></a>").addClass("accordion-collapse accordion-expand").appendTo(tool);
t.bind("click",function(){
_2fd(pp);
return false;
});
pp.panel("options").collapsible?t.show():t.hide();
if(opts.halign=="left"||opts.halign=="right"){
t.hide();
}
_2fc.click(function(){
_2fd(pp);
return false;
});
function _2fd(p){
var _2fe=p.panel("options");
if(_2fe.collapsible){
var _2ff=_2eb(_2f8,p);
if(_2fe.collapsed){
_300(_2f8,_2ff);
}else{
_301(_2f8,_2ff);
}
}
};
};
function _300(_302,_303){
var p=_2ee(_302,_303);
if(!p){
return;
}
_304(_302);
var opts=$.data(_302,"accordion").options;
p.panel("expand",opts.animate);
};
function _301(_305,_306){
var p=_2ee(_305,_306);
if(!p){
return;
}
_304(_305);
var opts=$.data(_305,"accordion").options;
p.panel("collapse",opts.animate);
};
function _307(_308){
var opts=$.data(_308,"accordion").options;
$(_308).find(">.panel-last>.accordion-header").addClass("accordion-header-border");
var p=_2e2(_308,"selected",true);
if(p){
_309(_2eb(_308,p));
}else{
_309(opts.selected);
}
function _309(_30a){
var _30b=opts.animate;
opts.animate=false;
_300(_308,_30a);
opts.animate=_30b;
};
};
function _304(_30c){
var _30d=$.data(_30c,"accordion").panels;
for(var i=0;i<_30d.length;i++){
_30d[i].stop(true,true);
}
};
function add(_30e,_30f){
var _310=$.data(_30e,"accordion");
var opts=_310.options;
var _311=_310.panels;
if(_30f.selected==undefined){
_30f.selected=true;
}
_304(_30e);
var pp=$("<div></div>").appendTo(_30e);
_311.push(pp);
_2f7(_30e,pp,_30f);
_2d4(_30e);
opts.onAdd.call(_30e,_30f.title,_311.length-1);
if(_30f.selected){
_300(_30e,_311.length-1);
}
};
function _312(_313,_314){
var _315=$.data(_313,"accordion");
var opts=_315.options;
var _316=_315.panels;
_304(_313);
var _317=_2ee(_313,_314);
var _318=_317.panel("options").title;
var _319=_2eb(_313,_317);
if(!_317){
return;
}
if(opts.onBeforeRemove.call(_313,_318,_319)==false){
return;
}
_316.splice(_319,1);
_317.panel("destroy");
if(_316.length){
_2d4(_313);
var curr=_2e9(_313);
if(!curr){
_300(_313,0);
}
}
opts.onRemove.call(_313,_318,_319);
};
$.fn.accordion=function(_31a,_31b){
if(typeof _31a=="string"){
return $.fn.accordion.methods[_31a](this,_31b);
}
_31a=_31a||{};
return this.each(function(){
var _31c=$.data(this,"accordion");
if(_31c){
$.extend(_31c.options,_31a);
}else{
$.data(this,"accordion",{options:$.extend({},$.fn.accordion.defaults,$.fn.accordion.parseOptions(this),_31a),accordion:$(this).addClass("accordion"),panels:[]});
init(this);
}
_2f2(this);
_2d4(this);
_307(this);
});
};
$.fn.accordion.methods={options:function(jq){
return $.data(jq[0],"accordion").options;
},panels:function(jq){
return $.data(jq[0],"accordion").panels;
},resize:function(jq,_31d){
return jq.each(function(){
_2d4(this,_31d);
});
},getSelections:function(jq){
return _2e7(jq[0]);
},getSelected:function(jq){
return _2e9(jq[0]);
},getPanel:function(jq,_31e){
return _2ee(jq[0],_31e);
},getPanelIndex:function(jq,_31f){
return _2eb(jq[0],_31f);
},select:function(jq,_320){
return jq.each(function(){
_300(this,_320);
});
},unselect:function(jq,_321){
return jq.each(function(){
_301(this,_321);
});
},add:function(jq,_322){
return jq.each(function(){
add(this,_322);
});
},remove:function(jq,_323){
return jq.each(function(){
_312(this,_323);
});
}};
$.fn.accordion.parseOptions=function(_324){
var t=$(_324);
return $.extend({},$.parser.parseOptions(_324,["width","height","halign",{fit:"boolean",border:"boolean",animate:"boolean",multiple:"boolean",selected:"number"}]));
};
$.fn.accordion.defaults={width:"auto",height:"auto",fit:false,border:true,animate:true,multiple:false,selected:0,halign:"top",onSelect:function(_325,_326){
},onUnselect:function(_327,_328){
},onAdd:function(_329,_32a){
},onBeforeRemove:function(_32b,_32c){
},onRemove:function(_32d,_32e){
}};
})(jQuery);
(function($){
function _32f(c){
var w=0;
$(c).children().each(function(){
w+=$(this).outerWidth(true);
});
return w;
};
function _330(_331){
var opts=$.data(_331,"tabs").options;
if(!opts.showHeader){
return;
}
var _332=$(_331).children("div.tabs-header");
var tool=_332.children("div.tabs-tool:not(.tabs-tool-hidden)");
var _333=_332.children("div.tabs-scroller-left");
var _334=_332.children("div.tabs-scroller-right");
var wrap=_332.children("div.tabs-wrap");
if(opts.tabPosition=="left"||opts.tabPosition=="right"){
if(!tool.length){
return;
}
tool._outerWidth(_332.width());
var _335={left:opts.tabPosition=="left"?"auto":0,right:opts.tabPosition=="left"?0:"auto",top:opts.toolPosition=="top"?0:"auto",bottom:opts.toolPosition=="top"?"auto":0};
var _336={marginTop:opts.toolPosition=="top"?tool.outerHeight():0};
tool.css(_335);
wrap.css(_336);
return;
}
var _337=_332.outerHeight();
if(opts.plain){
_337-=_337-_332.height();
}
tool._outerHeight(_337);
var _338=_32f(_332.find("ul.tabs"));
var _339=_332.width()-tool._outerWidth();
if(_338>_339){
_333.add(_334).show()._outerHeight(_337);
if(opts.toolPosition=="left"){
tool.css({left:_333.outerWidth(),right:""});
wrap.css({marginLeft:_333.outerWidth()+tool._outerWidth(),marginRight:_334._outerWidth(),width:_339-_333.outerWidth()-_334.outerWidth()});
}else{
tool.css({left:"",right:_334.outerWidth()});
wrap.css({marginLeft:_333.outerWidth(),marginRight:_334.outerWidth()+tool._outerWidth(),width:_339-_333.outerWidth()-_334.outerWidth()});
}
}else{
_333.add(_334).hide();
if(opts.toolPosition=="left"){
tool.css({left:0,right:""});
wrap.css({marginLeft:tool._outerWidth(),marginRight:0,width:_339});
}else{
tool.css({left:"",right:0});
wrap.css({marginLeft:0,marginRight:tool._outerWidth(),width:_339});
}
}
};
function _33a(_33b){
var opts=$.data(_33b,"tabs").options;
var _33c=$(_33b).children("div.tabs-header");
if(opts.tools){
if(typeof opts.tools=="string"){
$(opts.tools).addClass("tabs-tool").appendTo(_33c);
$(opts.tools).show();
}else{
_33c.children("div.tabs-tool").remove();
var _33d=$("<div class=\"tabs-tool\"><table cellspacing=\"0\" cellpadding=\"0\" style=\"height:100%\"><tr></tr></table></div>").appendTo(_33c);
var tr=_33d.find("tr");
for(var i=0;i<opts.tools.length;i++){
var td=$("<td></td>").appendTo(tr);
var tool=$("<a href=\"javascript:;\"></a>").appendTo(td);
tool[0].onclick=eval(opts.tools[i].handler||function(){
});
tool.linkbutton($.extend({},opts.tools[i],{plain:true}));
}
}
}else{
_33c.children("div.tabs-tool").remove();
}
};
function _33e(_33f,_340){
var _341=$.data(_33f,"tabs");
var opts=_341.options;
var cc=$(_33f);
if(!opts.doSize){
return;
}
if(_340){
$.extend(opts,{width:_340.width,height:_340.height});
}
cc._size(opts);
var _342=cc.children("div.tabs-header");
var _343=cc.children("div.tabs-panels");
var wrap=_342.find("div.tabs-wrap");
var ul=wrap.find(".tabs");
ul.children("li").removeClass("tabs-first tabs-last");
ul.children("li:first").addClass("tabs-first");
ul.children("li:last").addClass("tabs-last");
if(opts.tabPosition=="left"||opts.tabPosition=="right"){
_342._outerWidth(opts.showHeader?opts.headerWidth:0);
_343._outerWidth(cc.width()-_342.outerWidth());
_342.add(_343)._size("height",isNaN(parseInt(opts.height))?"":cc.height());
wrap._outerWidth(_342.width());
ul._outerWidth(wrap.width()).css("height","");
}else{
_342.children("div.tabs-scroller-left,div.tabs-scroller-right,div.tabs-tool:not(.tabs-tool-hidden)").css("display",opts.showHeader?"block":"none");
_342._outerWidth(cc.width()).css("height","");
if(opts.showHeader){
_342.css("background-color","");
wrap.css("height","");
}else{
_342.css("background-color","transparent");
_342._outerHeight(0);
wrap._outerHeight(0);
}
ul._outerHeight(opts.tabHeight).css("width","");
ul._outerHeight(ul.outerHeight()-ul.height()-1+opts.tabHeight).css("width","");
_343._size("height",isNaN(parseInt(opts.height))?"":(cc.height()-_342.outerHeight()));
_343._size("width",cc.width());
}
if(_341.tabs.length){
var d1=ul.outerWidth(true)-ul.width();
var li=ul.children("li:first");
var d2=li.outerWidth(true)-li.width();
var _344=_342.width()-_342.children(".tabs-tool:not(.tabs-tool-hidden)")._outerWidth();
var _345=Math.floor((_344-d1-d2*_341.tabs.length)/_341.tabs.length);
$.map(_341.tabs,function(p){
_346(p,(opts.justified&&$.inArray(opts.tabPosition,["top","bottom"])>=0)?_345:undefined);
});
if(opts.justified&&$.inArray(opts.tabPosition,["top","bottom"])>=0){
var _347=_344-d1-_32f(ul);
_346(_341.tabs[_341.tabs.length-1],_345+_347);
}
}
_330(_33f);
function _346(p,_348){
var _349=p.panel("options");
var p_t=_349.tab.find("a.tabs-inner");
var _348=_348?_348:(parseInt(_349.tabWidth||opts.tabWidth||undefined));
if(_348){
p_t._outerWidth(_348);
}else{
p_t.css("width","");
}
p_t._outerHeight(opts.tabHeight);
p_t.css("lineHeight",p_t.height()+"px");
p_t.find(".easyui-fluid:visible").triggerHandler("_resize");
};
};
function _34a(_34b){
var opts=$.data(_34b,"tabs").options;
var tab=_34c(_34b);
if(tab){
var _34d=$(_34b).children("div.tabs-panels");
var _34e=opts.width=="auto"?"auto":_34d.width();
var _34f=opts.height=="auto"?"auto":_34d.height();
tab.panel("resize",{width:_34e,height:_34f});
}
};
function _350(_351){
var tabs=$.data(_351,"tabs").tabs;
var cc=$(_351).addClass("tabs-container");
var _352=$("<div class=\"tabs-panels\"></div>").insertBefore(cc);
cc.children("div").each(function(){
_352[0].appendChild(this);
});
cc[0].appendChild(_352[0]);
$("<div class=\"tabs-header\">"+"<div class=\"tabs-scroller-left\"></div>"+"<div class=\"tabs-scroller-right\"></div>"+"<div class=\"tabs-wrap\">"+"<ul class=\"tabs\"></ul>"+"</div>"+"</div>").prependTo(_351);
cc.children("div.tabs-panels").children("div").each(function(i){
var opts=$.extend({},$.parser.parseOptions(this),{disabled:($(this).attr("disabled")?true:undefined),selected:($(this).attr("selected")?true:undefined)});
_35f(_351,opts,$(this));
});
cc.children("div.tabs-header").find(".tabs-scroller-left, .tabs-scroller-right").hover(function(){
$(this).addClass("tabs-scroller-over");
},function(){
$(this).removeClass("tabs-scroller-over");
});
cc.bind("_resize",function(e,_353){
if($(this).hasClass("easyui-fluid")||_353){
_33e(_351);
_34a(_351);
}
return false;
});
};
function _354(_355){
var _356=$.data(_355,"tabs");
var opts=_356.options;
$(_355).children("div.tabs-header").unbind().bind("click",function(e){
if($(e.target).hasClass("tabs-scroller-left")){
$(_355).tabs("scrollBy",-opts.scrollIncrement);
}else{
if($(e.target).hasClass("tabs-scroller-right")){
$(_355).tabs("scrollBy",opts.scrollIncrement);
}else{
var li=$(e.target).closest("li");
if(li.hasClass("tabs-disabled")){
return false;
}
var a=$(e.target).closest("a.tabs-close");
if(a.length){
_379(_355,_357(li));
}else{
if(li.length){
var _358=_357(li);
var _359=_356.tabs[_358].panel("options");
if(_359.collapsible){
_359.closed?_370(_355,_358):_390(_355,_358);
}else{
_370(_355,_358);
}
}
}
return false;
}
}
}).bind("contextmenu",function(e){
var li=$(e.target).closest("li");
if(li.hasClass("tabs-disabled")){
return;
}
if(li.length){
opts.onContextMenu.call(_355,e,li.find("span.tabs-title").html(),_357(li));
}
});
function _357(li){
var _35a=0;
li.parent().children("li").each(function(i){
if(li[0]==this){
_35a=i;
return false;
}
});
return _35a;
};
};
function _35b(_35c){
var opts=$.data(_35c,"tabs").options;
var _35d=$(_35c).children("div.tabs-header");
var _35e=$(_35c).children("div.tabs-panels");
_35d.removeClass("tabs-header-top tabs-header-bottom tabs-header-left tabs-header-right");
_35e.removeClass("tabs-panels-top tabs-panels-bottom tabs-panels-left tabs-panels-right");
if(opts.tabPosition=="top"){
_35d.insertBefore(_35e);
}else{
if(opts.tabPosition=="bottom"){
_35d.insertAfter(_35e);
_35d.addClass("tabs-header-bottom");
_35e.addClass("tabs-panels-top");
}else{
if(opts.tabPosition=="left"){
_35d.addClass("tabs-header-left");
_35e.addClass("tabs-panels-right");
}else{
if(opts.tabPosition=="right"){
_35d.addClass("tabs-header-right");
_35e.addClass("tabs-panels-left");
}
}
}
}
if(opts.plain==true){
_35d.addClass("tabs-header-plain");
}else{
_35d.removeClass("tabs-header-plain");
}
_35d.removeClass("tabs-header-narrow").addClass(opts.narrow?"tabs-header-narrow":"");
var tabs=_35d.find(".tabs");
tabs.removeClass("tabs-pill").addClass(opts.pill?"tabs-pill":"");
tabs.removeClass("tabs-narrow").addClass(opts.narrow?"tabs-narrow":"");
tabs.removeClass("tabs-justified").addClass(opts.justified?"tabs-justified":"");
if(opts.border==true){
_35d.removeClass("tabs-header-noborder");
_35e.removeClass("tabs-panels-noborder");
}else{
_35d.addClass("tabs-header-noborder");
_35e.addClass("tabs-panels-noborder");
}
opts.doSize=true;
};
function _35f(_360,_361,pp){
_361=_361||{};
var _362=$.data(_360,"tabs");
var tabs=_362.tabs;
if(_361.index==undefined||_361.index>tabs.length){
_361.index=tabs.length;
}
if(_361.index<0){
_361.index=0;
}
var ul=$(_360).children("div.tabs-header").find("ul.tabs");
var _363=$(_360).children("div.tabs-panels");
var tab=$("<li>"+"<a href=\"javascript:;\" class=\"tabs-inner\">"+"<span class=\"tabs-title\"></span>"+"<span class=\"tabs-icon\"></span>"+"</a>"+"</li>");
if(!pp){
pp=$("<div></div>");
}
if(_361.index>=tabs.length){
tab.appendTo(ul);
pp.appendTo(_363);
tabs.push(pp);
}else{
tab.insertBefore(ul.children("li:eq("+_361.index+")"));
pp.insertBefore(_363.children("div.panel:eq("+_361.index+")"));
tabs.splice(_361.index,0,pp);
}
pp.panel($.extend({},_361,{tab:tab,border:false,noheader:true,closed:true,doSize:false,iconCls:(_361.icon?_361.icon:undefined),onLoad:function(){
if(_361.onLoad){
_361.onLoad.apply(this,arguments);
}
_362.options.onLoad.call(_360,$(this));
},onBeforeOpen:function(){
if(_361.onBeforeOpen){
if(_361.onBeforeOpen.call(this)==false){
return false;
}
}
var p=$(_360).tabs("getSelected");
if(p){
if(p[0]!=this){
$(_360).tabs("unselect",_36b(_360,p));
p=$(_360).tabs("getSelected");
if(p){
return false;
}
}else{
_34a(_360);
return false;
}
}
var _364=$(this).panel("options");
_364.tab.addClass("tabs-selected");
var wrap=$(_360).find(">div.tabs-header>div.tabs-wrap");
var left=_364.tab.position().left;
var _365=left+_364.tab.outerWidth();
if(left<0||_365>wrap.width()){
var _366=left-(wrap.width()-_364.tab.width())/2;
$(_360).tabs("scrollBy",_366);
}else{
$(_360).tabs("scrollBy",0);
}
var _367=$(this).panel("panel");
_367.css("display","block");
_34a(_360);
_367.css("display","none");
},onOpen:function(){
if(_361.onOpen){
_361.onOpen.call(this);
}
var _368=$(this).panel("options");
var _369=_36b(_360,this);
_362.selectHis.push(_369);
_362.options.onSelect.call(_360,_368.title,_369);
},onBeforeClose:function(){
if(_361.onBeforeClose){
if(_361.onBeforeClose.call(this)==false){
return false;
}
}
$(this).panel("options").tab.removeClass("tabs-selected");
},onClose:function(){
if(_361.onClose){
_361.onClose.call(this);
}
var _36a=$(this).panel("options");
_362.options.onUnselect.call(_360,_36a.title,_36b(_360,this));
}}));
$(_360).tabs("update",{tab:pp,options:pp.panel("options"),type:"header"});
};
function _36c(_36d,_36e){
var _36f=$.data(_36d,"tabs");
var opts=_36f.options;
if(_36e.selected==undefined){
_36e.selected=true;
}
_35f(_36d,_36e);
opts.onAdd.call(_36d,_36e.title,_36e.index);
if(_36e.selected){
_370(_36d,_36e.index);
}
};
function _371(_372,_373){
_373.type=_373.type||"all";
var _374=$.data(_372,"tabs").selectHis;
var pp=_373.tab;
var opts=pp.panel("options");
var _375=opts.title;
$.extend(opts,_373.options,{iconCls:(_373.options.icon?_373.options.icon:undefined)});
if(_373.type=="all"||_373.type=="body"){
pp.panel();
}
if(_373.type=="all"||_373.type=="header"){
var tab=opts.tab;
if(opts.header){
tab.find(".tabs-inner").html($(opts.header));
}else{
var _376=tab.find("span.tabs-title");
var _377=tab.find("span.tabs-icon");
_376.html(opts.title);
_377.attr("class","tabs-icon");
tab.find("a.tabs-close").remove();
if(opts.closable){
_376.addClass("tabs-closable");
$("<a href=\"javascript:;\" class=\"tabs-close\"></a>").appendTo(tab);
}else{
_376.removeClass("tabs-closable");
}
if(opts.iconCls){
_376.addClass("tabs-with-icon");
_377.addClass(opts.iconCls);
}else{
_376.removeClass("tabs-with-icon");
}
if(opts.tools){
var _378=tab.find("span.tabs-p-tool");
if(!_378.length){
var _378=$("<span class=\"tabs-p-tool\"></span>").insertAfter(tab.find("a.tabs-inner"));
}
if($.isArray(opts.tools)){
_378.empty();
for(var i=0;i<opts.tools.length;i++){
var t=$("<a href=\"javascript:;\"></a>").appendTo(_378);
t.addClass(opts.tools[i].iconCls);
if(opts.tools[i].handler){
t.bind("click",{handler:opts.tools[i].handler},function(e){
if($(this).parents("li").hasClass("tabs-disabled")){
return;
}
e.data.handler.call(this);
});
}
}
}else{
$(opts.tools).children().appendTo(_378);
}
var pr=_378.children().length*12;
if(opts.closable){
pr+=8;
_378.css("right","");
}else{
pr-=3;
_378.css("right","5px");
}
_376.css("padding-right",pr+"px");
}else{
tab.find("span.tabs-p-tool").remove();
_376.css("padding-right","");
}
}
}
if(opts.disabled){
opts.tab.addClass("tabs-disabled");
}else{
opts.tab.removeClass("tabs-disabled");
}
_33e(_372);
$.data(_372,"tabs").options.onUpdate.call(_372,opts.title,_36b(_372,pp));
};
function _379(_37a,_37b){
var _37c=$.data(_37a,"tabs");
var opts=_37c.options;
var tabs=_37c.tabs;
var _37d=_37c.selectHis;
if(!_37e(_37a,_37b)){
return;
}
var tab=_37f(_37a,_37b);
var _380=tab.panel("options").title;
var _381=_36b(_37a,tab);
if(opts.onBeforeClose.call(_37a,_380,_381)==false){
return;
}
var tab=_37f(_37a,_37b,true);
tab.panel("options").tab.remove();
tab.panel("destroy");
opts.onClose.call(_37a,_380,_381);
_33e(_37a);
var his=[];
for(var i=0;i<_37d.length;i++){
var _382=_37d[i];
if(_382!=_381){
his.push(_382>_381?_382-1:_382);
}
}
_37c.selectHis=his;
var _383=$(_37a).tabs("getSelected");
if(!_383&&his.length){
_381=_37c.selectHis.pop();
$(_37a).tabs("select",_381);
}
};
function _37f(_384,_385,_386){
var tabs=$.data(_384,"tabs").tabs;
var tab=null;
if(typeof _385=="number"){
if(_385>=0&&_385<tabs.length){
tab=tabs[_385];
if(_386){
tabs.splice(_385,1);
}
}
}else{
var tmp=$("<span></span>");
for(var i=0;i<tabs.length;i++){
var p=tabs[i];
tmp.html(p.panel("options").title);
var _387=tmp.text();
tmp.html(_385);
_385=tmp.text();
if(_387==_385){
tab=p;
if(_386){
tabs.splice(i,1);
}
break;
}
}
tmp.remove();
}
return tab;
};
function _36b(_388,tab){
var tabs=$.data(_388,"tabs").tabs;
for(var i=0;i<tabs.length;i++){
if(tabs[i][0]==$(tab)[0]){
return i;
}
}
return -1;
};
function _34c(_389){
var tabs=$.data(_389,"tabs").tabs;
for(var i=0;i<tabs.length;i++){
var tab=tabs[i];
if(tab.panel("options").tab.hasClass("tabs-selected")){
return tab;
}
}
return null;
};
function _38a(_38b){
var _38c=$.data(_38b,"tabs");
var tabs=_38c.tabs;
for(var i=0;i<tabs.length;i++){
var opts=tabs[i].panel("options");
if(opts.selected&&!opts.disabled){
_370(_38b,i);
return;
}
}
_370(_38b,_38c.options.selected);
};
function _370(_38d,_38e){
var p=_37f(_38d,_38e);
if(p&&!p.is(":visible")){
_38f(_38d);
if(!p.panel("options").disabled){
p.panel("open");
}
}
};
function _390(_391,_392){
var p=_37f(_391,_392);
if(p&&p.is(":visible")){
_38f(_391);
p.panel("close");
}
};
function _38f(_393){
$(_393).children("div.tabs-panels").each(function(){
$(this).stop(true,true);
});
};
function _37e(_394,_395){
return _37f(_394,_395)!=null;
};
function _396(_397,_398){
var opts=$.data(_397,"tabs").options;
opts.showHeader=_398;
$(_397).tabs("resize");
};
function _399(_39a,_39b){
var tool=$(_39a).find(">.tabs-header>.tabs-tool");
if(_39b){
tool.removeClass("tabs-tool-hidden").show();
}else{
tool.addClass("tabs-tool-hidden").hide();
}
$(_39a).tabs("resize").tabs("scrollBy",0);
};
$.fn.tabs=function(_39c,_39d){
if(typeof _39c=="string"){
return $.fn.tabs.methods[_39c](this,_39d);
}
_39c=_39c||{};
return this.each(function(){
var _39e=$.data(this,"tabs");
if(_39e){
$.extend(_39e.options,_39c);
}else{
$.data(this,"tabs",{options:$.extend({},$.fn.tabs.defaults,$.fn.tabs.parseOptions(this),_39c),tabs:[],selectHis:[]});
_350(this);
}
_33a(this);
_35b(this);
_33e(this);
_354(this);
_38a(this);
});
};
$.fn.tabs.methods={options:function(jq){
var cc=jq[0];
var opts=$.data(cc,"tabs").options;
var s=_34c(cc);
opts.selected=s?_36b(cc,s):-1;
return opts;
},tabs:function(jq){
return $.data(jq[0],"tabs").tabs;
},resize:function(jq,_39f){
return jq.each(function(){
_33e(this,_39f);
_34a(this);
});
},add:function(jq,_3a0){
return jq.each(function(){
_36c(this,_3a0);
});
},close:function(jq,_3a1){
return jq.each(function(){
_379(this,_3a1);
});
},getTab:function(jq,_3a2){
return _37f(jq[0],_3a2);
},getTabIndex:function(jq,tab){
return _36b(jq[0],tab);
},getSelected:function(jq){
return _34c(jq[0]);
},select:function(jq,_3a3){
return jq.each(function(){
_370(this,_3a3);
});
},unselect:function(jq,_3a4){
return jq.each(function(){
_390(this,_3a4);
});
},exists:function(jq,_3a5){
return _37e(jq[0],_3a5);
},update:function(jq,_3a6){
return jq.each(function(){
_371(this,_3a6);
});
},enableTab:function(jq,_3a7){
return jq.each(function(){
var opts=$(this).tabs("getTab",_3a7).panel("options");
opts.tab.removeClass("tabs-disabled");
opts.disabled=false;
});
},disableTab:function(jq,_3a8){
return jq.each(function(){
var opts=$(this).tabs("getTab",_3a8).panel("options");
opts.tab.addClass("tabs-disabled");
opts.disabled=true;
});
},showHeader:function(jq){
return jq.each(function(){
_396(this,true);
});
},hideHeader:function(jq){
return jq.each(function(){
_396(this,false);
});
},showTool:function(jq){
return jq.each(function(){
_399(this,true);
});
},hideTool:function(jq){
return jq.each(function(){
_399(this,false);
});
},scrollBy:function(jq,_3a9){
return jq.each(function(){
var opts=$(this).tabs("options");
var wrap=$(this).find(">div.tabs-header>div.tabs-wrap");
var pos=Math.min(wrap._scrollLeft()+_3a9,_3aa());
wrap.animate({scrollLeft:pos},opts.scrollDuration);
function _3aa(){
var w=0;
var ul=wrap.children("ul");
ul.children("li").each(function(){
w+=$(this).outerWidth(true);
});
return w-wrap.width()+(ul.outerWidth()-ul.width());
};
});
}};
$.fn.tabs.parseOptions=function(_3ab){
return $.extend({},$.parser.parseOptions(_3ab,["tools","toolPosition","tabPosition",{fit:"boolean",border:"boolean",plain:"boolean"},{headerWidth:"number",tabWidth:"number",tabHeight:"number",selected:"number"},{showHeader:"boolean",justified:"boolean",narrow:"boolean",pill:"boolean"}]));
};
$.fn.tabs.defaults={width:"auto",height:"auto",headerWidth:150,tabWidth:"auto",tabHeight:32,selected:0,showHeader:true,plain:false,fit:false,border:true,justified:false,narrow:false,pill:false,tools:null,toolPosition:"right",tabPosition:"top",scrollIncrement:100,scrollDuration:400,onLoad:function(_3ac){
},onSelect:function(_3ad,_3ae){
},onUnselect:function(_3af,_3b0){
},onBeforeClose:function(_3b1,_3b2){
},onClose:function(_3b3,_3b4){
},onAdd:function(_3b5,_3b6){
},onUpdate:function(_3b7,_3b8){
},onContextMenu:function(e,_3b9,_3ba){
}};
})(jQuery);
(function($){
var _3bb=false;
function _3bc(_3bd,_3be){
var _3bf=$.data(_3bd,"layout");
var opts=_3bf.options;
var _3c0=_3bf.panels;
var cc=$(_3bd);
if(_3be){
$.extend(opts,{width:_3be.width,height:_3be.height});
}
if(_3bd.tagName.toLowerCase()=="body"){
cc._size("fit");
}else{
cc._size(opts);
}
var cpos={top:0,left:0,width:cc.width(),height:cc.height()};
_3c1(_3c2(_3c0.expandNorth)?_3c0.expandNorth:_3c0.north,"n");
_3c1(_3c2(_3c0.expandSouth)?_3c0.expandSouth:_3c0.south,"s");
_3c3(_3c2(_3c0.expandEast)?_3c0.expandEast:_3c0.east,"e");
_3c3(_3c2(_3c0.expandWest)?_3c0.expandWest:_3c0.west,"w");
_3c0.center.panel("resize",cpos);
function _3c1(pp,type){
if(!pp.length||!_3c2(pp)){
return;
}
var opts=pp.panel("options");
pp.panel("resize",{width:cc.width(),height:opts.height});
var _3c4=pp.panel("panel").outerHeight();
pp.panel("move",{left:0,top:(type=="n"?0:cc.height()-_3c4)});
cpos.height-=_3c4;
if(type=="n"){
cpos.top+=_3c4;
if(!opts.split&&opts.border){
cpos.top--;
}
}
if(!opts.split&&opts.border){
cpos.height++;
}
};
function _3c3(pp,type){
if(!pp.length||!_3c2(pp)){
return;
}
var opts=pp.panel("options");
pp.panel("resize",{width:opts.width,height:cpos.height});
var _3c5=pp.panel("panel").outerWidth();
pp.panel("move",{left:(type=="e"?cc.width()-_3c5:0),top:cpos.top});
cpos.width-=_3c5;
if(type=="w"){
cpos.left+=_3c5;
if(!opts.split&&opts.border){
cpos.left--;
}
}
if(!opts.split&&opts.border){
cpos.width++;
}
};
};
function init(_3c6){
var cc=$(_3c6);
cc.addClass("layout");
function _3c7(el){
var _3c8=$.fn.layout.parsePanelOptions(el);
if("north,south,east,west,center".indexOf(_3c8.region)>=0){
_3cb(_3c6,_3c8,el);
}
};
var opts=cc.layout("options");
var _3c9=opts.onAdd;
opts.onAdd=function(){
};
cc.find(">div,>form>div").each(function(){
_3c7(this);
});
opts.onAdd=_3c9;
cc.append("<div class=\"layout-split-proxy-h\"></div><div class=\"layout-split-proxy-v\"></div>");
cc.bind("_resize",function(e,_3ca){
if($(this).hasClass("easyui-fluid")||_3ca){
_3bc(_3c6);
}
return false;
});
};
function _3cb(_3cc,_3cd,el){
_3cd.region=_3cd.region||"center";
var _3ce=$.data(_3cc,"layout").panels;
var cc=$(_3cc);
var dir=_3cd.region;
if(_3ce[dir].length){
return;
}
var pp=$(el);
if(!pp.length){
pp=$("<div></div>").appendTo(cc);
}
var _3cf=$.extend({},$.fn.layout.paneldefaults,{width:(pp.length?parseInt(pp[0].style.width)||pp.outerWidth():"auto"),height:(pp.length?parseInt(pp[0].style.height)||pp.outerHeight():"auto"),doSize:false,collapsible:true,onOpen:function(){
var tool=$(this).panel("header").children("div.panel-tool");
tool.children("a.panel-tool-collapse").hide();
var _3d0={north:"up",south:"down",east:"right",west:"left"};
if(!_3d0[dir]){
return;
}
var _3d1="layout-button-"+_3d0[dir];
var t=tool.children("a."+_3d1);
if(!t.length){
t=$("<a href=\"javascript:;\"></a>").addClass(_3d1).appendTo(tool);
t.bind("click",{dir:dir},function(e){
_3e8(_3cc,e.data.dir);
return false;
});
}
$(this).panel("options").collapsible?t.show():t.hide();
}},_3cd,{cls:((_3cd.cls||"")+" layout-panel layout-panel-"+dir),bodyCls:((_3cd.bodyCls||"")+" layout-body")});
pp.panel(_3cf);
_3ce[dir]=pp;
var _3d2={north:"s",south:"n",east:"w",west:"e"};
var _3d3=pp.panel("panel");
if(pp.panel("options").split){
_3d3.addClass("layout-split-"+dir);
}
_3d3.resizable($.extend({},{handles:(_3d2[dir]||""),disabled:(!pp.panel("options").split),onStartResize:function(e){
_3bb=true;
if(dir=="north"||dir=="south"){
var _3d4=$(">div.layout-split-proxy-v",_3cc);
}else{
var _3d4=$(">div.layout-split-proxy-h",_3cc);
}
var top=0,left=0,_3d5=0,_3d6=0;
var pos={display:"block"};
if(dir=="north"){
pos.top=parseInt(_3d3.css("top"))+_3d3.outerHeight()-_3d4.height();
pos.left=parseInt(_3d3.css("left"));
pos.width=_3d3.outerWidth();
pos.height=_3d4.height();
}else{
if(dir=="south"){
pos.top=parseInt(_3d3.css("top"));
pos.left=parseInt(_3d3.css("left"));
pos.width=_3d3.outerWidth();
pos.height=_3d4.height();
}else{
if(dir=="east"){
pos.top=parseInt(_3d3.css("top"))||0;
pos.left=parseInt(_3d3.css("left"))||0;
pos.width=_3d4.width();
pos.height=_3d3.outerHeight();
}else{
if(dir=="west"){
pos.top=parseInt(_3d3.css("top"))||0;
pos.left=_3d3.outerWidth()-_3d4.width();
pos.width=_3d4.width();
pos.height=_3d3.outerHeight();
}
}
}
}
_3d4.css(pos);
$("<div class=\"layout-mask\"></div>").css({left:0,top:0,width:cc.width(),height:cc.height()}).appendTo(cc);
},onResize:function(e){
if(dir=="north"||dir=="south"){
var _3d7=_3d8(this);
$(this).resizable("options").maxHeight=_3d7;
var _3d9=$(">div.layout-split-proxy-v",_3cc);
var top=dir=="north"?e.data.height-_3d9.height():$(_3cc).height()-e.data.height;
_3d9.css("top",top);
}else{
var _3da=_3d8(this);
$(this).resizable("options").maxWidth=_3da;
var _3d9=$(">div.layout-split-proxy-h",_3cc);
var left=dir=="west"?e.data.width-_3d9.width():$(_3cc).width()-e.data.width;
_3d9.css("left",left);
}
return false;
},onStopResize:function(e){
cc.children("div.layout-split-proxy-v,div.layout-split-proxy-h").hide();
pp.panel("resize",e.data);
_3bc(_3cc);
_3bb=false;
cc.find(">div.layout-mask").remove();
}},_3cd));
cc.layout("options").onAdd.call(_3cc,dir);
function _3d8(p){
var _3db="expand"+dir.substring(0,1).toUpperCase()+dir.substring(1);
var _3dc=_3ce["center"];
var _3dd=(dir=="north"||dir=="south")?"minHeight":"minWidth";
var _3de=(dir=="north"||dir=="south")?"maxHeight":"maxWidth";
var _3df=(dir=="north"||dir=="south")?"_outerHeight":"_outerWidth";
var _3e0=$.parser.parseValue(_3de,_3ce[dir].panel("options")[_3de],$(_3cc));
var _3e1=$.parser.parseValue(_3dd,_3dc.panel("options")[_3dd],$(_3cc));
var _3e2=_3dc.panel("panel")[_3df]()-_3e1;
if(_3c2(_3ce[_3db])){
_3e2+=_3ce[_3db][_3df]()-1;
}else{
_3e2+=$(p)[_3df]();
}
if(_3e2>_3e0){
_3e2=_3e0;
}
return _3e2;
};
};
function _3e3(_3e4,_3e5){
var _3e6=$.data(_3e4,"layout").panels;
if(_3e6[_3e5].length){
_3e6[_3e5].panel("destroy");
_3e6[_3e5]=$();
var _3e7="expand"+_3e5.substring(0,1).toUpperCase()+_3e5.substring(1);
if(_3e6[_3e7]){
_3e6[_3e7].panel("destroy");
_3e6[_3e7]=undefined;
}
$(_3e4).layout("options").onRemove.call(_3e4,_3e5);
}
};
function _3e8(_3e9,_3ea,_3eb){
if(_3eb==undefined){
_3eb="normal";
}
var _3ec=$.data(_3e9,"layout").panels;
var p=_3ec[_3ea];
var _3ed=p.panel("options");
if(_3ed.onBeforeCollapse.call(p)==false){
return;
}
var _3ee="expand"+_3ea.substring(0,1).toUpperCase()+_3ea.substring(1);
if(!_3ec[_3ee]){
_3ec[_3ee]=_3ef(_3ea);
var ep=_3ec[_3ee].panel("panel");
if(!_3ed.expandMode){
ep.css("cursor","default");
}else{
ep.bind("click",function(){
if(_3ed.expandMode=="dock"){
_3fb(_3e9,_3ea);
}else{
p.panel("expand",false).panel("open");
var _3f0=_3f1();
p.panel("resize",_3f0.collapse);
p.panel("panel").unbind(".layout").bind("mouseleave.layout",{region:_3ea},function(e){
$(this).stop(true,true);
if(_3bb==true){
return;
}
if($("body>div.combo-p>div.combo-panel:visible").length){
return;
}
_3e8(_3e9,e.data.region);
});
p.panel("panel").animate(_3f0.expand,function(){
$(_3e9).layout("options").onExpand.call(_3e9,_3ea);
});
}
return false;
});
}
}
var _3f2=_3f1();
if(!_3c2(_3ec[_3ee])){
_3ec.center.panel("resize",_3f2.resizeC);
}
p.panel("panel").animate(_3f2.collapse,_3eb,function(){
p.panel("collapse",false).panel("close");
_3ec[_3ee].panel("open").panel("resize",_3f2.expandP);
$(this).unbind(".layout");
$(_3e9).layout("options").onCollapse.call(_3e9,_3ea);
});
function _3ef(dir){
var _3f3={"east":"left","west":"right","north":"down","south":"up"};
var isns=(_3ed.region=="north"||_3ed.region=="south");
var icon="layout-button-"+_3f3[dir];
var p=$("<div></div>").appendTo(_3e9);
p.panel($.extend({},$.fn.layout.paneldefaults,{cls:("layout-expand layout-expand-"+dir),title:"&nbsp;",titleDirection:_3ed.titleDirection,iconCls:(_3ed.hideCollapsedContent?null:_3ed.iconCls),closed:true,minWidth:0,minHeight:0,doSize:false,region:_3ed.region,collapsedSize:_3ed.collapsedSize,noheader:(!isns&&_3ed.hideExpandTool),tools:((isns&&_3ed.hideExpandTool)?null:[{iconCls:icon,handler:function(){
_3fb(_3e9,_3ea);
return false;
}}]),onResize:function(){
var _3f4=$(this).children(".layout-expand-title");
if(_3f4.length){
_3f4._outerWidth($(this).height());
var left=($(this).width()-Math.min(_3f4._outerWidth(),_3f4._outerHeight()))/2;
var top=Math.max(_3f4._outerWidth(),_3f4._outerHeight());
if(_3f4.hasClass("layout-expand-title-down")){
left+=Math.min(_3f4._outerWidth(),_3f4._outerHeight());
top=0;
}
_3f4.css({left:(left+"px"),top:(top+"px")});
}
}}));
if(!_3ed.hideCollapsedContent){
var _3f5=typeof _3ed.collapsedContent=="function"?_3ed.collapsedContent.call(p[0],_3ed.title):_3ed.collapsedContent;
isns?p.panel("setTitle",_3f5):p.html(_3f5);
}
p.panel("panel").hover(function(){
$(this).addClass("layout-expand-over");
},function(){
$(this).removeClass("layout-expand-over");
});
return p;
};
function _3f1(){
var cc=$(_3e9);
var _3f6=_3ec.center.panel("options");
var _3f7=_3ed.collapsedSize;
if(_3ea=="east"){
var _3f8=p.panel("panel")._outerWidth();
var _3f9=_3f6.width+_3f8-_3f7;
if(_3ed.split||!_3ed.border){
_3f9++;
}
return {resizeC:{width:_3f9},expand:{left:cc.width()-_3f8},expandP:{top:_3f6.top,left:cc.width()-_3f7,width:_3f7,height:_3f6.height},collapse:{left:cc.width(),top:_3f6.top,height:_3f6.height}};
}else{
if(_3ea=="west"){
var _3f8=p.panel("panel")._outerWidth();
var _3f9=_3f6.width+_3f8-_3f7;
if(_3ed.split||!_3ed.border){
_3f9++;
}
return {resizeC:{width:_3f9,left:_3f7-1},expand:{left:0},expandP:{left:0,top:_3f6.top,width:_3f7,height:_3f6.height},collapse:{left:-_3f8,top:_3f6.top,height:_3f6.height}};
}else{
if(_3ea=="north"){
var _3fa=p.panel("panel")._outerHeight();
var hh=_3f6.height;
if(!_3c2(_3ec.expandNorth)){
hh+=_3fa-_3f7+((_3ed.split||!_3ed.border)?1:0);
}
_3ec.east.add(_3ec.west).add(_3ec.expandEast).add(_3ec.expandWest).panel("resize",{top:_3f7-1,height:hh});
return {resizeC:{top:_3f7-1,height:hh},expand:{top:0},expandP:{top:0,left:0,width:cc.width(),height:_3f7},collapse:{top:-_3fa,width:cc.width()}};
}else{
if(_3ea=="south"){
var _3fa=p.panel("panel")._outerHeight();
var hh=_3f6.height;
if(!_3c2(_3ec.expandSouth)){
hh+=_3fa-_3f7+((_3ed.split||!_3ed.border)?1:0);
}
_3ec.east.add(_3ec.west).add(_3ec.expandEast).add(_3ec.expandWest).panel("resize",{height:hh});
return {resizeC:{height:hh},expand:{top:cc.height()-_3fa},expandP:{top:cc.height()-_3f7,left:0,width:cc.width(),height:_3f7},collapse:{top:cc.height(),width:cc.width()}};
}
}
}
}
};
};
function _3fb(_3fc,_3fd){
var _3fe=$.data(_3fc,"layout").panels;
var p=_3fe[_3fd];
var _3ff=p.panel("options");
if(_3ff.onBeforeExpand.call(p)==false){
return;
}
var _400="expand"+_3fd.substring(0,1).toUpperCase()+_3fd.substring(1);
if(_3fe[_400]){
_3fe[_400].panel("close");
p.panel("panel").stop(true,true);
p.panel("expand",false).panel("open");
var _401=_402();
p.panel("resize",_401.collapse);
p.panel("panel").animate(_401.expand,function(){
_3bc(_3fc);
$(_3fc).layout("options").onExpand.call(_3fc,_3fd);
});
}
function _402(){
var cc=$(_3fc);
var _403=_3fe.center.panel("options");
if(_3fd=="east"&&_3fe.expandEast){
return {collapse:{left:cc.width(),top:_403.top,height:_403.height},expand:{left:cc.width()-p.panel("panel")._outerWidth()}};
}else{
if(_3fd=="west"&&_3fe.expandWest){
return {collapse:{left:-p.panel("panel")._outerWidth(),top:_403.top,height:_403.height},expand:{left:0}};
}else{
if(_3fd=="north"&&_3fe.expandNorth){
return {collapse:{top:-p.panel("panel")._outerHeight(),width:cc.width()},expand:{top:0}};
}else{
if(_3fd=="south"&&_3fe.expandSouth){
return {collapse:{top:cc.height(),width:cc.width()},expand:{top:cc.height()-p.panel("panel")._outerHeight()}};
}
}
}
}
};
};
function _3c2(pp){
if(!pp){
return false;
}
if(pp.length){
return pp.panel("panel").is(":visible");
}else{
return false;
}
};
function _404(_405){
var _406=$.data(_405,"layout");
var opts=_406.options;
var _407=_406.panels;
var _408=opts.onCollapse;
opts.onCollapse=function(){
};
_409("east");
_409("west");
_409("north");
_409("south");
opts.onCollapse=_408;
function _409(_40a){
var p=_407[_40a];
if(p.length&&p.panel("options").collapsed){
_3e8(_405,_40a,0);
}
};
};
function _40b(_40c,_40d,_40e){
var p=$(_40c).layout("panel",_40d);
p.panel("options").split=_40e;
var cls="layout-split-"+_40d;
var _40f=p.panel("panel").removeClass(cls);
if(_40e){
_40f.addClass(cls);
}
_40f.resizable({disabled:(!_40e)});
_3bc(_40c);
};
$.fn.layout=function(_410,_411){
if(typeof _410=="string"){
return $.fn.layout.methods[_410](this,_411);
}
_410=_410||{};
return this.each(function(){
var _412=$.data(this,"layout");
if(_412){
$.extend(_412.options,_410);
}else{
var opts=$.extend({},$.fn.layout.defaults,$.fn.layout.parseOptions(this),_410);
$.data(this,"layout",{options:opts,panels:{center:$(),north:$(),south:$(),east:$(),west:$()}});
init(this);
}
_3bc(this);
_404(this);
});
};
$.fn.layout.methods={options:function(jq){
return $.data(jq[0],"layout").options;
},resize:function(jq,_413){
return jq.each(function(){
_3bc(this,_413);
});
},panel:function(jq,_414){
return $.data(jq[0],"layout").panels[_414];
},collapse:function(jq,_415){
return jq.each(function(){
_3e8(this,_415);
});
},expand:function(jq,_416){
return jq.each(function(){
_3fb(this,_416);
});
},add:function(jq,_417){
return jq.each(function(){
_3cb(this,_417);
_3bc(this);
if($(this).layout("panel",_417.region).panel("options").collapsed){
_3e8(this,_417.region,0);
}
});
},remove:function(jq,_418){
return jq.each(function(){
_3e3(this,_418);
_3bc(this);
});
},split:function(jq,_419){
return jq.each(function(){
_40b(this,_419,true);
});
},unsplit:function(jq,_41a){
return jq.each(function(){
_40b(this,_41a,false);
});
}};
$.fn.layout.parseOptions=function(_41b){
return $.extend({},$.parser.parseOptions(_41b,[{fit:"boolean"}]));
};
$.fn.layout.defaults={fit:false,onExpand:function(_41c){
},onCollapse:function(_41d){
},onAdd:function(_41e){
},onRemove:function(_41f){
}};
$.fn.layout.parsePanelOptions=function(_420){
var t=$(_420);
return $.extend({},$.fn.panel.parseOptions(_420),$.parser.parseOptions(_420,["region",{split:"boolean",collpasedSize:"number",minWidth:"number",minHeight:"number",maxWidth:"number",maxHeight:"number"}]));
};
$.fn.layout.paneldefaults=$.extend({},$.fn.panel.defaults,{region:null,split:false,collapsedSize:32,expandMode:"float",hideExpandTool:false,hideCollapsedContent:true,collapsedContent:function(_421){
var p=$(this);
var opts=p.panel("options");
if(opts.region=="north"||opts.region=="south"){
return _421;
}
var cc=[];
if(opts.iconCls){
cc.push("<div class=\"panel-icon "+opts.iconCls+"\"></div>");
}
cc.push("<div class=\"panel-title layout-expand-title");
cc.push(" layout-expand-title-"+opts.titleDirection);
cc.push(opts.iconCls?" layout-expand-with-icon":"");
cc.push("\">");
cc.push(_421);
cc.push("</div>");
return cc.join("");
},minWidth:10,minHeight:10,maxWidth:10000,maxHeight:10000});
})(jQuery);
(function($){
$(function(){
$(document).unbind(".menu").bind("mousedown.menu",function(e){
var m=$(e.target).closest("div.menu,div.combo-p");
if(m.length){
return;
}
$("body>div.menu-top:visible").not(".menu-inline").menu("hide");
_422($("body>div.menu:visible").not(".menu-inline"));
});
});
function init(_423){
var opts=$.data(_423,"menu").options;
$(_423).addClass("menu-top");
opts.inline?$(_423).addClass("menu-inline"):$(_423).appendTo("body");
$(_423).bind("_resize",function(e,_424){
if($(this).hasClass("easyui-fluid")||_424){
$(_423).menu("resize",_423);
}
return false;
});
var _425=_426($(_423));
for(var i=0;i<_425.length;i++){
_429(_423,_425[i]);
}
function _426(menu){
var _427=[];
menu.addClass("menu");
_427.push(menu);
if(!menu.hasClass("menu-content")){
menu.children("div").each(function(){
var _428=$(this).children("div");
if(_428.length){
_428.appendTo("body");
this.submenu=_428;
var mm=_426(_428);
_427=_427.concat(mm);
}
});
}
return _427;
};
};
function _429(_42a,div){
var menu=$(div).addClass("menu");
if(!menu.data("menu")){
menu.data("menu",{options:$.parser.parseOptions(menu[0],["width","height"])});
}
if(!menu.hasClass("menu-content")){
menu.children("div").each(function(){
_42b(_42a,this);
});
$("<div class=\"menu-line\"></div>").prependTo(menu);
}
_42c(_42a,menu);
if(!menu.hasClass("menu-inline")){
menu.hide();
}
_42d(_42a,menu);
};
function _42b(_42e,div,_42f){
var item=$(div);
var _430=$.extend({},$.parser.parseOptions(item[0],["id","name","iconCls","href",{separator:"boolean"}]),{disabled:(item.attr("disabled")?true:undefined),text:$.trim(item.html()),onclick:item[0].onclick},_42f||{});
_430.onclick=_430.onclick||_430.handler||null;
item.data("menuitem",{options:_430});
if(_430.separator){
item.addClass("menu-sep");
}
if(!item.hasClass("menu-sep")){
item.addClass("menu-item");
item.empty().append($("<div class=\"menu-text\"></div>").html(_430.text));
if(_430.iconCls){
$("<div class=\"menu-icon\"></div>").addClass(_430.iconCls).appendTo(item);
}
if(_430.id){
item.attr("id",_430.id);
}
if(_430.onclick){
if(typeof _430.onclick=="string"){
item.attr("onclick",_430.onclick);
}else{
item[0].onclick=eval(_430.onclick);
}
}
if(_430.disabled){
_431(_42e,item[0],true);
}
if(item[0].submenu){
$("<div class=\"menu-rightarrow\"></div>").appendTo(item);
}
}
};
function _42c(_432,menu){
var opts=$.data(_432,"menu").options;
var _433=menu.attr("style")||"";
var _434=menu.is(":visible");
menu.css({display:"block",left:-10000,height:"auto",overflow:"hidden"});
menu.find(".menu-item").each(function(){
$(this)._outerHeight(opts.itemHeight);
$(this).find(".menu-text").css({height:(opts.itemHeight-2)+"px",lineHeight:(opts.itemHeight-2)+"px"});
});
menu.removeClass("menu-noline").addClass(opts.noline?"menu-noline":"");
var _435=menu.data("menu").options;
var _436=_435.width;
var _437=_435.height;
if(isNaN(parseInt(_436))){
_436=0;
menu.find("div.menu-text").each(function(){
if(_436<$(this).outerWidth()){
_436=$(this).outerWidth();
}
});
_436=_436?_436+40:"";
}
var _438=menu.outerHeight();
if(isNaN(parseInt(_437))){
_437=_438;
if(menu.hasClass("menu-top")&&opts.alignTo){
var at=$(opts.alignTo);
var h1=at.offset().top-$(document).scrollTop();
var h2=$(window)._outerHeight()+$(document).scrollTop()-at.offset().top-at._outerHeight();
_437=Math.min(_437,Math.max(h1,h2));
}else{
if(_437>$(window)._outerHeight()){
_437=$(window).height();
}
}
}
menu.attr("style",_433);
menu.show();
menu._size($.extend({},_435,{width:_436,height:_437,minWidth:_435.minWidth||opts.minWidth,maxWidth:_435.maxWidth||opts.maxWidth}));
menu.find(".easyui-fluid").triggerHandler("_resize",[true]);
menu.css("overflow",menu.outerHeight()<_438?"auto":"hidden");
menu.children("div.menu-line")._outerHeight(_438-2);
if(!_434){
menu.hide();
}
};
function _42d(_439,menu){
var _43a=$.data(_439,"menu");
var opts=_43a.options;
menu.unbind(".menu");
for(var _43b in opts.events){
menu.bind(_43b+".menu",{target:_439},opts.events[_43b]);
}
};
function _43c(e){
var _43d=e.data.target;
var _43e=$.data(_43d,"menu");
if(_43e.timer){
clearTimeout(_43e.timer);
_43e.timer=null;
}
};
function _43f(e){
var _440=e.data.target;
var _441=$.data(_440,"menu");
if(_441.options.hideOnUnhover){
_441.timer=setTimeout(function(){
_442(_440,$(_440).hasClass("menu-inline"));
},_441.options.duration);
}
};
function _443(e){
var _444=e.data.target;
var item=$(e.target).closest(".menu-item");
if(item.length){
item.siblings().each(function(){
if(this.submenu){
_422(this.submenu);
}
$(this).removeClass("menu-active");
});
item.addClass("menu-active");
if(item.hasClass("menu-item-disabled")){
item.addClass("menu-active-disabled");
return;
}
var _445=item[0].submenu;
if(_445){
$(_444).menu("show",{menu:_445,parent:item});
}
}
};
function _446(e){
var item=$(e.target).closest(".menu-item");
if(item.length){
item.removeClass("menu-active menu-active-disabled");
var _447=item[0].submenu;
if(_447){
if(e.pageX>=parseInt(_447.css("left"))){
item.addClass("menu-active");
}else{
_422(_447);
}
}else{
item.removeClass("menu-active");
}
}
};
function _448(e){
var _449=e.data.target;
var item=$(e.target).closest(".menu-item");
if(item.length){
var opts=$(_449).data("menu").options;
var _44a=item.data("menuitem").options;
if(_44a.disabled){
return;
}
if(!item[0].submenu){
_442(_449,opts.inline);
if(_44a.href){
location.href=_44a.href;
}
}
item.trigger("mouseenter");
opts.onClick.call(_449,$(_449).menu("getItem",item[0]));
}
};
function _442(_44b,_44c){
var _44d=$.data(_44b,"menu");
if(_44d){
if($(_44b).is(":visible")){
_422($(_44b));
if(_44c){
$(_44b).show();
}else{
_44d.options.onHide.call(_44b);
}
}
}
return false;
};
function _44e(_44f,_450){
_450=_450||{};
var left,top;
var opts=$.data(_44f,"menu").options;
var menu=$(_450.menu||_44f);
$(_44f).menu("resize",menu[0]);
if(menu.hasClass("menu-top")){
$.extend(opts,_450);
left=opts.left;
top=opts.top;
if(opts.alignTo){
var at=$(opts.alignTo);
left=at.offset().left;
top=at.offset().top+at._outerHeight();
if(opts.align=="right"){
left+=at.outerWidth()-menu.outerWidth();
}
}
if(left+menu.outerWidth()>$(window)._outerWidth()+$(document)._scrollLeft()){
left=$(window)._outerWidth()+$(document).scrollLeft()-menu.outerWidth()-5;
}
if(left<0){
left=0;
}
top=_451(top,opts.alignTo);
}else{
var _452=_450.parent;
left=_452.offset().left+_452.outerWidth()-2;
if(left+menu.outerWidth()+5>$(window)._outerWidth()+$(document).scrollLeft()){
left=_452.offset().left-menu.outerWidth()+2;
}
top=_451(_452.offset().top-3);
}
function _451(top,_453){
if(top+menu.outerHeight()>$(window)._outerHeight()+$(document).scrollTop()){
if(_453){
top=$(_453).offset().top-menu._outerHeight();
}else{
top=$(window)._outerHeight()+$(document).scrollTop()-menu.outerHeight();
}
}
if(top<0){
top=0;
}
return top;
};
menu.css(opts.position.call(_44f,menu[0],left,top));
menu.show(0,function(){
if(!menu[0].shadow){
menu[0].shadow=$("<div class=\"menu-shadow\"></div>").insertAfter(menu);
}
menu[0].shadow.css({display:(menu.hasClass("menu-inline")?"none":"block"),zIndex:$.fn.menu.defaults.zIndex++,left:menu.css("left"),top:menu.css("top"),width:menu.outerWidth(),height:menu.outerHeight()});
menu.css("z-index",$.fn.menu.defaults.zIndex++);
if(menu.hasClass("menu-top")){
opts.onShow.call(_44f);
}
});
};
function _422(menu){
if(menu&&menu.length){
_454(menu);
menu.find("div.menu-item").each(function(){
if(this.submenu){
_422(this.submenu);
}
$(this).removeClass("menu-active");
});
}
function _454(m){
m.stop(true,true);
if(m[0].shadow){
m[0].shadow.hide();
}
m.hide();
};
};
function _455(_456,_457){
var _458=null;
var fn=$.isFunction(_457)?_457:function(item){
for(var p in _457){
if(item[p]!=_457[p]){
return false;
}
}
return true;
};
function find(menu){
menu.children("div.menu-item").each(function(){
var opts=$(this).data("menuitem").options;
if(fn.call(_456,opts)==true){
_458=$(_456).menu("getItem",this);
}else{
if(this.submenu&&!_458){
find(this.submenu);
}
}
});
};
find($(_456));
return _458;
};
function _431(_459,_45a,_45b){
var t=$(_45a);
if(t.hasClass("menu-item")){
var opts=t.data("menuitem").options;
opts.disabled=_45b;
if(_45b){
t.addClass("menu-item-disabled");
t[0].onclick=null;
}else{
t.removeClass("menu-item-disabled");
t[0].onclick=opts.onclick;
}
}
};
function _45c(_45d,_45e){
var opts=$.data(_45d,"menu").options;
var menu=$(_45d);
if(_45e.parent){
if(!_45e.parent.submenu){
var _45f=$("<div></div>").appendTo("body");
_45e.parent.submenu=_45f;
$("<div class=\"menu-rightarrow\"></div>").appendTo(_45e.parent);
_429(_45d,_45f);
}
menu=_45e.parent.submenu;
}
var div=$("<div></div>").appendTo(menu);
_42b(_45d,div,_45e);
};
function _460(_461,_462){
function _463(el){
if(el.submenu){
el.submenu.children("div.menu-item").each(function(){
_463(this);
});
var _464=el.submenu[0].shadow;
if(_464){
_464.remove();
}
el.submenu.remove();
}
$(el).remove();
};
_463(_462);
};
function _465(_466,_467,_468){
var menu=$(_467).parent();
if(_468){
$(_467).show();
}else{
$(_467).hide();
}
_42c(_466,menu);
};
function _469(_46a){
$(_46a).children("div.menu-item").each(function(){
_460(_46a,this);
});
if(_46a.shadow){
_46a.shadow.remove();
}
$(_46a).remove();
};
$.fn.menu=function(_46b,_46c){
if(typeof _46b=="string"){
return $.fn.menu.methods[_46b](this,_46c);
}
_46b=_46b||{};
return this.each(function(){
var _46d=$.data(this,"menu");
if(_46d){
$.extend(_46d.options,_46b);
}else{
_46d=$.data(this,"menu",{options:$.extend({},$.fn.menu.defaults,$.fn.menu.parseOptions(this),_46b)});
init(this);
}
$(this).css({left:_46d.options.left,top:_46d.options.top});
});
};
$.fn.menu.methods={options:function(jq){
return $.data(jq[0],"menu").options;
},show:function(jq,pos){
return jq.each(function(){
_44e(this,pos);
});
},hide:function(jq){
return jq.each(function(){
_442(this);
});
},destroy:function(jq){
return jq.each(function(){
_469(this);
});
},setText:function(jq,_46e){
return jq.each(function(){
var item=$(_46e.target).data("menuitem").options;
item.text=_46e.text;
$(_46e.target).children("div.menu-text").html(_46e.text);
});
},setIcon:function(jq,_46f){
return jq.each(function(){
var item=$(_46f.target).data("menuitem").options;
item.iconCls=_46f.iconCls;
$(_46f.target).children("div.menu-icon").remove();
if(_46f.iconCls){
$("<div class=\"menu-icon\"></div>").addClass(_46f.iconCls).appendTo(_46f.target);
}
});
},getItem:function(jq,_470){
var item=$(_470).data("menuitem").options;
return $.extend({},item,{target:$(_470)[0]});
},findItem:function(jq,text){
if(typeof text=="string"){
return _455(jq[0],function(item){
return $("<div>"+item.text+"</div>").text()==text;
});
}else{
return _455(jq[0],text);
}
},appendItem:function(jq,_471){
return jq.each(function(){
_45c(this,_471);
});
},removeItem:function(jq,_472){
return jq.each(function(){
_460(this,_472);
});
},enableItem:function(jq,_473){
return jq.each(function(){
_431(this,_473,false);
});
},disableItem:function(jq,_474){
return jq.each(function(){
_431(this,_474,true);
});
},showItem:function(jq,_475){
return jq.each(function(){
_465(this,_475,true);
});
},hideItem:function(jq,_476){
return jq.each(function(){
_465(this,_476,false);
});
},resize:function(jq,_477){
return jq.each(function(){
_42c(this,_477?$(_477):$(this));
});
}};
$.fn.menu.parseOptions=function(_478){
return $.extend({},$.parser.parseOptions(_478,[{minWidth:"number",itemHeight:"number",duration:"number",hideOnUnhover:"boolean"},{fit:"boolean",inline:"boolean",noline:"boolean"}]));
};
$.fn.menu.defaults={zIndex:110000,left:0,top:0,alignTo:null,align:"left",minWidth:150,itemHeight:32,duration:100,hideOnUnhover:true,inline:false,fit:false,noline:false,events:{mouseenter:_43c,mouseleave:_43f,mouseover:_443,mouseout:_446,click:_448},position:function(_479,left,top){
return {left:left,top:top};
},onShow:function(){
},onHide:function(){
},onClick:function(item){
}};
})(jQuery);
(function($){
var _47a=1;
function init(_47b){
$(_47b).addClass("sidemenu");
};
function _47c(_47d,_47e){
var opts=$(_47d).sidemenu("options");
if(_47e){
$.extend(opts,{width:_47e.width,height:_47e.height});
}
$(_47d)._size(opts);
$(_47d).find(".accordion").accordion("resize");
};
function _47f(_480,_481,data){
var opts=$(_480).sidemenu("options");
var tt=$("<ul class=\"sidemenu-tree\"></ul>").appendTo(_481);
tt.tree({data:data,animate:opts.animate,onBeforeSelect:function(node){
if(node.children){
return false;
}
},onSelect:function(node){
_482(_480,node.id);
},onExpand:function(node){
_48d(_480,node);
},onCollapse:function(node){
_48d(_480,node);
},onClick:function(node){
if(node.children){
if(node.state=="open"){
$(node.target).addClass("tree-node-nonleaf-collapsed");
}else{
$(node.target).removeClass("tree-node-nonleaf-collapsed");
}
$(this).tree("toggle",node.target);
}
}});
tt.unbind(".sidemenu").bind("mouseleave.sidemenu",function(){
$(_481).trigger("mouseleave");
});
_482(_480,opts.selectedItemId);
};
function _483(_484,_485,data){
var opts=$(_484).sidemenu("options");
$(_485).tooltip({content:$("<div></div>"),position:opts.floatMenuPosition,valign:"top",data:data,onUpdate:function(_486){
var _487=$(this).tooltip("options");
var data=_487.data;
_486.accordion({width:opts.floatMenuWidth,multiple:false}).accordion("add",{title:data.text,collapsed:false,collapsible:false});
_47f(_484,_486.accordion("panels")[0],data.children);
},onShow:function(){
var t=$(this);
var tip=t.tooltip("tip").addClass("sidemenu-tooltip");
tip.children(".tooltip-content").addClass("sidemenu");
tip.find(".accordion").accordion("resize");
tip.add(tip.find("ul.tree")).unbind(".sidemenu").bind("mouseover.sidemenu",function(){
t.tooltip("show");
}).bind("mouseleave.sidemenu",function(){
t.tooltip("hide");
});
t.tooltip("reposition");
},onPosition:function(left,top){
var tip=$(this).tooltip("tip");
if(!opts.collapsed){
tip.css({left:-999999});
}else{
if(top+tip.outerHeight()>$(window)._outerHeight()+$(document).scrollTop()){
top=$(window)._outerHeight()+$(document).scrollTop()-tip.outerHeight();
tip.css("top",top);
}
}
}});
};
function _488(_489,_48a){
$(_489).find(".sidemenu-tree").each(function(){
_48a($(this));
});
$(_489).find(".tooltip-f").each(function(){
var tip=$(this).tooltip("tip");
if(tip){
tip.find(".sidemenu-tree").each(function(){
_48a($(this));
});
$(this).tooltip("reposition");
}
});
};
function _482(_48b,_48c){
var opts=$(_48b).sidemenu("options");
_488(_48b,function(t){
t.find("div.tree-node-selected").removeClass("tree-node-selected");
var node=t.tree("find",_48c);
if(node){
$(node.target).addClass("tree-node-selected");
opts.selectedItemId=node.id;
t.trigger("mouseleave.sidemenu");
opts.onSelect.call(_48b,node);
}
});
};
function _48d(_48e,item){
_488(_48e,function(t){
var node=t.tree("find",item.id);
if(node){
var _48f=t.tree("options");
var _490=_48f.animate;
_48f.animate=false;
t.tree(item.state=="open"?"expand":"collapse",node.target);
_48f.animate=_490;
}
});
};
function _491(_492){
var opts=$(_492).sidemenu("options");
$(_492).empty();
if(opts.data){
$.easyui.forEach(opts.data,true,function(node){
if(!node.id){
node.id="_easyui_sidemenu_"+(_47a++);
}
if(!node.iconCls){
node.iconCls="sidemenu-default-icon";
}
if(node.children){
node.nodeCls="tree-node-nonleaf";
if(!node.state){
node.state="closed";
}
if(node.state=="open"){
node.nodeCls="tree-node-nonleaf";
}else{
node.nodeCls="tree-node-nonleaf tree-node-nonleaf-collapsed";
}
}
});
var acc=$("<div></div>").appendTo(_492);
acc.accordion({fit:opts.height=="auto"?false:true,border:opts.border,multiple:opts.multiple});
var data=opts.data;
for(var i=0;i<data.length;i++){
acc.accordion("add",{title:data[i].text,selected:data[i].state=="open",iconCls:data[i].iconCls,onBeforeExpand:function(){
return !opts.collapsed;
}});
var ap=acc.accordion("panels")[i];
_47f(_492,ap,data[i].children);
_483(_492,ap.panel("header"),data[i]);
}
}
};
function _493(_494,_495){
var opts=$(_494).sidemenu("options");
opts.collapsed=_495;
var acc=$(_494).find(".accordion");
var _496=acc.accordion("panels");
acc.accordion("options").animate=false;
if(opts.collapsed){
$(_494).addClass("sidemenu-collapsed");
for(var i=0;i<_496.length;i++){
var _497=_496[i];
if(_497.panel("options").collapsed){
opts.data[i].state="closed";
}else{
opts.data[i].state="open";
acc.accordion("unselect",i);
}
var _498=_497.panel("header");
_498.find(".panel-title").html("");
_498.find(".panel-tool").hide();
}
}else{
$(_494).removeClass("sidemenu-collapsed");
for(var i=0;i<_496.length;i++){
var _497=_496[i];
if(opts.data[i].state=="open"){
acc.accordion("select",i);
}
var _498=_497.panel("header");
_498.find(".panel-title").html(_497.panel("options").title);
_498.find(".panel-tool").show();
}
}
acc.accordion("options").animate=opts.animate;
};
function _499(_49a){
$(_49a).find(".tooltip-f").each(function(){
$(this).tooltip("destroy");
});
$(_49a).remove();
};
$.fn.sidemenu=function(_49b,_49c){
if(typeof _49b=="string"){
var _49d=$.fn.sidemenu.methods[_49b];
return _49d(this,_49c);
}
_49b=_49b||{};
return this.each(function(){
var _49e=$.data(this,"sidemenu");
if(_49e){
$.extend(_49e.options,_49b);
}else{
_49e=$.data(this,"sidemenu",{options:$.extend({},$.fn.sidemenu.defaults,$.fn.sidemenu.parseOptions(this),_49b)});
init(this);
}
_47c(this);
_491(this);
_493(this,_49e.options.collapsed);
});
};
$.fn.sidemenu.methods={options:function(jq){
return jq.data("sidemenu").options;
},resize:function(jq,_49f){
return jq.each(function(){
_47c(this,_49f);
});
},collapse:function(jq){
return jq.each(function(){
_493(this,true);
});
},expand:function(jq){
return jq.each(function(){
_493(this,false);
});
},destroy:function(jq){
return jq.each(function(){
_499(this);
});
}};
$.fn.sidemenu.parseOptions=function(_4a0){
var t=$(_4a0);
return $.extend({},$.parser.parseOptions(_4a0,["width","height"]));
};
$.fn.sidemenu.defaults={width:200,height:"auto",border:true,animate:true,multiple:true,collapsed:false,data:null,floatMenuWidth:200,floatMenuPosition:"right",onSelect:function(item){
}};
})(jQuery);
(function($){
function init(_4a1){
var opts=$.data(_4a1,"menubutton").options;
var btn=$(_4a1);
btn.linkbutton(opts);
if(opts.hasDownArrow){
btn.removeClass(opts.cls.btn1+" "+opts.cls.btn2).addClass("m-btn");
btn.removeClass("m-btn-small m-btn-medium m-btn-large").addClass("m-btn-"+opts.size);
var _4a2=btn.find(".l-btn-left");
$("<span></span>").addClass(opts.cls.arrow).appendTo(_4a2);
$("<span></span>").addClass("m-btn-line").appendTo(_4a2);
}
$(_4a1).menubutton("resize");
if(opts.menu){
$(opts.menu).menu({duration:opts.duration});
var _4a3=$(opts.menu).menu("options");
var _4a4=_4a3.onShow;
var _4a5=_4a3.onHide;
$.extend(_4a3,{onShow:function(){
var _4a6=$(this).menu("options");
var btn=$(_4a6.alignTo);
var opts=btn.menubutton("options");
btn.addClass((opts.plain==true)?opts.cls.btn2:opts.cls.btn1);
_4a4.call(this);
},onHide:function(){
var _4a7=$(this).menu("options");
var btn=$(_4a7.alignTo);
var opts=btn.menubutton("options");
btn.removeClass((opts.plain==true)?opts.cls.btn2:opts.cls.btn1);
_4a5.call(this);
}});
}
};
function _4a8(_4a9){
var opts=$.data(_4a9,"menubutton").options;
var btn=$(_4a9);
var t=btn.find("."+opts.cls.trigger);
if(!t.length){
t=btn;
}
t.unbind(".menubutton");
var _4aa=null;
t.bind(opts.showEvent+".menubutton",function(){
if(!_4ab()){
_4aa=setTimeout(function(){
_4ac(_4a9);
},opts.duration);
return false;
}
}).bind(opts.hideEvent+".menubutton",function(){
if(_4aa){
clearTimeout(_4aa);
}
$(opts.menu).triggerHandler("mouseleave");
});
function _4ab(){
return $(_4a9).linkbutton("options").disabled;
};
};
function _4ac(_4ad){
var opts=$(_4ad).menubutton("options");
if(opts.disabled||!opts.menu){
return;
}
$("body>div.menu-top").menu("hide");
var btn=$(_4ad);
var mm=$(opts.menu);
if(mm.length){
mm.menu("options").alignTo=btn;
mm.menu("show",{alignTo:btn,align:opts.menuAlign});
}
btn.blur();
};
$.fn.menubutton=function(_4ae,_4af){
if(typeof _4ae=="string"){
var _4b0=$.fn.menubutton.methods[_4ae];
if(_4b0){
return _4b0(this,_4af);
}else{
return this.linkbutton(_4ae,_4af);
}
}
_4ae=_4ae||{};
return this.each(function(){
var _4b1=$.data(this,"menubutton");
if(_4b1){
$.extend(_4b1.options,_4ae);
}else{
$.data(this,"menubutton",{options:$.extend({},$.fn.menubutton.defaults,$.fn.menubutton.parseOptions(this),_4ae)});
$(this)._propAttr("disabled",false);
}
init(this);
_4a8(this);
});
};
$.fn.menubutton.methods={options:function(jq){
var _4b2=jq.linkbutton("options");
return $.extend($.data(jq[0],"menubutton").options,{toggle:_4b2.toggle,selected:_4b2.selected,disabled:_4b2.disabled});
},destroy:function(jq){
return jq.each(function(){
var opts=$(this).menubutton("options");
if(opts.menu){
$(opts.menu).menu("destroy");
}
$(this).remove();
});
}};
$.fn.menubutton.parseOptions=function(_4b3){
var t=$(_4b3);
return $.extend({},$.fn.linkbutton.parseOptions(_4b3),$.parser.parseOptions(_4b3,["menu",{plain:"boolean",hasDownArrow:"boolean",duration:"number"}]));
};
$.fn.menubutton.defaults=$.extend({},$.fn.linkbutton.defaults,{plain:true,hasDownArrow:true,menu:null,menuAlign:"left",duration:100,showEvent:"mouseenter",hideEvent:"mouseleave",cls:{btn1:"m-btn-active",btn2:"m-btn-plain-active",arrow:"m-btn-downarrow",trigger:"m-btn"}});
})(jQuery);
(function($){
function init(_4b4){
var opts=$.data(_4b4,"splitbutton").options;
$(_4b4).menubutton(opts);
$(_4b4).addClass("s-btn");
};
$.fn.splitbutton=function(_4b5,_4b6){
if(typeof _4b5=="string"){
var _4b7=$.fn.splitbutton.methods[_4b5];
if(_4b7){
return _4b7(this,_4b6);
}else{
return this.menubutton(_4b5,_4b6);
}
}
_4b5=_4b5||{};
return this.each(function(){
var _4b8=$.data(this,"splitbutton");
if(_4b8){
$.extend(_4b8.options,_4b5);
}else{
$.data(this,"splitbutton",{options:$.extend({},$.fn.splitbutton.defaults,$.fn.splitbutton.parseOptions(this),_4b5)});
$(this)._propAttr("disabled",false);
}
init(this);
});
};
$.fn.splitbutton.methods={options:function(jq){
var _4b9=jq.menubutton("options");
var _4ba=$.data(jq[0],"splitbutton").options;
$.extend(_4ba,{disabled:_4b9.disabled,toggle:_4b9.toggle,selected:_4b9.selected});
return _4ba;
}};
$.fn.splitbutton.parseOptions=function(_4bb){
var t=$(_4bb);
return $.extend({},$.fn.linkbutton.parseOptions(_4bb),$.parser.parseOptions(_4bb,["menu",{plain:"boolean",duration:"number"}]));
};
$.fn.splitbutton.defaults=$.extend({},$.fn.linkbutton.defaults,{plain:true,menu:null,duration:100,cls:{btn1:"m-btn-active s-btn-active",btn2:"m-btn-plain-active s-btn-plain-active",arrow:"m-btn-downarrow",trigger:"m-btn-line"}});
})(jQuery);
(function($){
function init(_4bc){
var _4bd=$("<span class=\"switchbutton\">"+"<span class=\"switchbutton-inner\">"+"<span class=\"switchbutton-on\"></span>"+"<span class=\"switchbutton-handle\"></span>"+"<span class=\"switchbutton-off\"></span>"+"<input class=\"switchbutton-value\" type=\"checkbox\">"+"</span>"+"</span>").insertAfter(_4bc);
var t=$(_4bc);
t.addClass("switchbutton-f").hide();
var name=t.attr("name");
if(name){
t.removeAttr("name").attr("switchbuttonName",name);
_4bd.find(".switchbutton-value").attr("name",name);
}
_4bd.bind("_resize",function(e,_4be){
if($(this).hasClass("easyui-fluid")||_4be){
_4bf(_4bc);
}
return false;
});
return _4bd;
};
function _4bf(_4c0,_4c1){
var _4c2=$.data(_4c0,"switchbutton");
var opts=_4c2.options;
var _4c3=_4c2.switchbutton;
if(_4c1){
$.extend(opts,_4c1);
}
var _4c4=_4c3.is(":visible");
if(!_4c4){
_4c3.appendTo("body");
}
_4c3._size(opts);
var w=_4c3.width();
var h=_4c3.height();
var w=_4c3.outerWidth();
var h=_4c3.outerHeight();
var _4c5=parseInt(opts.handleWidth)||_4c3.height();
var _4c6=w*2-_4c5;
_4c3.find(".switchbutton-inner").css({width:_4c6+"px",height:h+"px",lineHeight:h+"px"});
_4c3.find(".switchbutton-handle")._outerWidth(_4c5)._outerHeight(h).css({marginLeft:-_4c5/2+"px"});
_4c3.find(".switchbutton-on").css({width:(w-_4c5/2)+"px",textIndent:(opts.reversed?"":"-")+_4c5/2+"px"});
_4c3.find(".switchbutton-off").css({width:(w-_4c5/2)+"px",textIndent:(opts.reversed?"-":"")+_4c5/2+"px"});
opts.marginWidth=w-_4c5;
_4c7(_4c0,opts.checked,false);
if(!_4c4){
_4c3.insertAfter(_4c0);
}
};
function _4c8(_4c9){
var _4ca=$.data(_4c9,"switchbutton");
var opts=_4ca.options;
var _4cb=_4ca.switchbutton;
var _4cc=_4cb.find(".switchbutton-inner");
var on=_4cc.find(".switchbutton-on").html(opts.onText);
var off=_4cc.find(".switchbutton-off").html(opts.offText);
var _4cd=_4cc.find(".switchbutton-handle").html(opts.handleText);
if(opts.reversed){
off.prependTo(_4cc);
on.insertAfter(_4cd);
}else{
on.prependTo(_4cc);
off.insertAfter(_4cd);
}
_4cb.find(".switchbutton-value")._propAttr("checked",opts.checked);
_4cb.removeClass("switchbutton-disabled").addClass(opts.disabled?"switchbutton-disabled":"");
_4cb.removeClass("switchbutton-reversed").addClass(opts.reversed?"switchbutton-reversed":"");
_4c7(_4c9,opts.checked);
_4ce(_4c9,opts.readonly);
$(_4c9).switchbutton("setValue",opts.value);
};
function _4c7(_4cf,_4d0,_4d1){
var _4d2=$.data(_4cf,"switchbutton");
var opts=_4d2.options;
opts.checked=_4d0;
var _4d3=_4d2.switchbutton.find(".switchbutton-inner");
var _4d4=_4d3.find(".switchbutton-on");
var _4d5=opts.reversed?(opts.checked?opts.marginWidth:0):(opts.checked?0:opts.marginWidth);
var dir=_4d4.css("float").toLowerCase();
var css={};
css["margin-"+dir]=-_4d5+"px";
_4d1?_4d3.animate(css,200):_4d3.css(css);
var _4d6=_4d3.find(".switchbutton-value");
var ck=_4d6.is(":checked");
$(_4cf).add(_4d6)._propAttr("checked",opts.checked);
if(ck!=opts.checked){
opts.onChange.call(_4cf,opts.checked);
}
};
function _4d7(_4d8,_4d9){
var _4da=$.data(_4d8,"switchbutton");
var opts=_4da.options;
var _4db=_4da.switchbutton;
var _4dc=_4db.find(".switchbutton-value");
if(_4d9){
opts.disabled=true;
$(_4d8).add(_4dc)._propAttr("disabled",true);
_4db.addClass("switchbutton-disabled");
}else{
opts.disabled=false;
$(_4d8).add(_4dc)._propAttr("disabled",false);
_4db.removeClass("switchbutton-disabled");
}
};
function _4ce(_4dd,mode){
var _4de=$.data(_4dd,"switchbutton");
var opts=_4de.options;
opts.readonly=mode==undefined?true:mode;
_4de.switchbutton.removeClass("switchbutton-readonly").addClass(opts.readonly?"switchbutton-readonly":"");
};
function _4df(_4e0){
var _4e1=$.data(_4e0,"switchbutton");
var opts=_4e1.options;
_4e1.switchbutton.unbind(".switchbutton").bind("click.switchbutton",function(){
if(!opts.disabled&&!opts.readonly){
_4c7(_4e0,opts.checked?false:true,true);
}
});
};
$.fn.switchbutton=function(_4e2,_4e3){
if(typeof _4e2=="string"){
return $.fn.switchbutton.methods[_4e2](this,_4e3);
}
_4e2=_4e2||{};
return this.each(function(){
var _4e4=$.data(this,"switchbutton");
if(_4e4){
$.extend(_4e4.options,_4e2);
}else{
_4e4=$.data(this,"switchbutton",{options:$.extend({},$.fn.switchbutton.defaults,$.fn.switchbutton.parseOptions(this),_4e2),switchbutton:init(this)});
}
_4e4.options.originalChecked=_4e4.options.checked;
_4c8(this);
_4bf(this);
_4df(this);
});
};
$.fn.switchbutton.methods={options:function(jq){
var _4e5=jq.data("switchbutton");
return $.extend(_4e5.options,{value:_4e5.switchbutton.find(".switchbutton-value").val()});
},resize:function(jq,_4e6){
return jq.each(function(){
_4bf(this,_4e6);
});
},enable:function(jq){
return jq.each(function(){
_4d7(this,false);
});
},disable:function(jq){
return jq.each(function(){
_4d7(this,true);
});
},readonly:function(jq,mode){
return jq.each(function(){
_4ce(this,mode);
});
},check:function(jq){
return jq.each(function(){
_4c7(this,true);
});
},uncheck:function(jq){
return jq.each(function(){
_4c7(this,false);
});
},clear:function(jq){
return jq.each(function(){
_4c7(this,false);
});
},reset:function(jq){
return jq.each(function(){
var opts=$(this).switchbutton("options");
_4c7(this,opts.originalChecked);
});
},setValue:function(jq,_4e7){
return jq.each(function(){
$(this).val(_4e7);
$.data(this,"switchbutton").switchbutton.find(".switchbutton-value").val(_4e7);
});
}};
$.fn.switchbutton.parseOptions=function(_4e8){
var t=$(_4e8);
return $.extend({},$.parser.parseOptions(_4e8,["onText","offText","handleText",{handleWidth:"number",reversed:"boolean"}]),{value:(t.val()||undefined),checked:(t.attr("checked")?true:undefined),disabled:(t.attr("disabled")?true:undefined),readonly:(t.attr("readonly")?true:undefined)});
};
$.fn.switchbutton.defaults={handleWidth:"auto",width:60,height:30,checked:false,disabled:false,readonly:false,reversed:false,onText:"ON",offText:"OFF",handleText:"",value:"on",onChange:function(_4e9){
}};
})(jQuery);
(function($){
var _4ea=1;
function init(_4eb){
var _4ec=$("<span class=\"radiobutton inputbox\">"+"<span class=\"radiobutton-inner\" style=\"display:none\"></span>"+"<input type=\"radio\" class=\"radiobutton-value\">"+"</span>").insertAfter(_4eb);
var t=$(_4eb);
t.addClass("radiobutton-f").hide();
var name=t.attr("name");
if(name){
t.removeAttr("name").attr("radiobuttonName",name);
_4ec.find(".radiobutton-value").attr("name",name);
}
return _4ec;
};
function _4ed(_4ee){
var _4ef=$.data(_4ee,"radiobutton");
var opts=_4ef.options;
var _4f0=_4ef.radiobutton;
var _4f1="_easyui_radiobutton_"+(++_4ea);
_4f0.find(".radiobutton-value").attr("id",_4f1);
if(opts.label){
if(typeof opts.label=="object"){
_4ef.label=$(opts.label);
_4ef.label.attr("for",_4f1);
}else{
$(_4ef.label).remove();
_4ef.label=$("<label class=\"textbox-label\"></label>").html(opts.label);
_4ef.label.css("textAlign",opts.labelAlign).attr("for",_4f1);
if(opts.labelPosition=="after"){
_4ef.label.insertAfter(_4f0);
}else{
_4ef.label.insertBefore(_4ee);
}
_4ef.label.removeClass("textbox-label-left textbox-label-right textbox-label-top");
_4ef.label.addClass("textbox-label-"+opts.labelPosition);
}
}else{
$(_4ef.label).remove();
}
$(_4ee).radiobutton("setValue",opts.value);
_4f2(_4ee,opts.checked);
_4f3(_4ee,opts.disabled);
};
function _4f4(_4f5){
var _4f6=$.data(_4f5,"radiobutton");
var opts=_4f6.options;
var _4f7=_4f6.radiobutton;
_4f7.unbind(".radiobutton").bind("click.radiobutton",function(){
if(!opts.disabled){
_4f2(_4f5,true);
}
});
};
function _4f8(_4f9){
var _4fa=$.data(_4f9,"radiobutton");
var opts=_4fa.options;
var _4fb=_4fa.radiobutton;
_4fb._size(opts,_4fb.parent());
if(opts.label&&opts.labelPosition){
if(opts.labelPosition=="top"){
_4fa.label._size({width:opts.labelWidth},_4fb);
}else{
_4fa.label._size({width:opts.labelWidth,height:_4fb.outerHeight()},_4fb);
_4fa.label.css("lineHeight",_4fb.outerHeight()+"px");
}
}
};
function _4f2(_4fc,_4fd){
if(_4fd){
var f=$(_4fc).closest("form");
var name=$(_4fc).attr("radiobuttonName");
f.find(".radiobutton-f[radiobuttonName=\""+name+"\"]").each(function(){
if(this!=_4fc){
_4fe(this,false);
}
});
_4fe(_4fc,true);
}else{
_4fe(_4fc,false);
}
function _4fe(b,c){
var opts=$(b).radiobutton("options");
var _4ff=$(b).data("radiobutton").radiobutton;
_4ff.find(".radiobutton-inner").css("display",c?"":"none");
_4ff.find(".radiobutton-value")._propAttr("checked",c);
if(opts.checked!=c){
opts.checked=c;
opts.onChange.call($(b)[0],c);
}
};
};
function _4f3(_500,_501){
var _502=$.data(_500,"radiobutton");
var opts=_502.options;
var _503=_502.radiobutton;
var rv=_503.find(".radiobutton-value");
opts.disabled=_501;
if(_501){
$(_500).add(rv)._propAttr("disabled",true);
_503.addClass("radiobutton-disabled");
}else{
$(_500).add(rv)._propAttr("disabled",false);
_503.removeClass("radiobutton-disabled");
}
};
$.fn.radiobutton=function(_504,_505){
if(typeof _504=="string"){
return $.fn.radiobutton.methods[_504](this,_505);
}
_504=_504||{};
return this.each(function(){
var _506=$.data(this,"radiobutton");
if(_506){
$.extend(_506.options,_504);
}else{
_506=$.data(this,"radiobutton",{options:$.extend({},$.fn.radiobutton.defaults,$.fn.radiobutton.parseOptions(this),_504),radiobutton:init(this)});
}
_506.options.originalChecked=_506.options.checked;
_4ed(this);
_4f4(this);
_4f8(this);
});
};
$.fn.radiobutton.methods={options:function(jq){
var _507=jq.data("radiobutton");
return $.extend(_507.options,{value:_507.radiobutton.find(".radiobutton-value").val()});
},setValue:function(jq,_508){
return jq.each(function(){
$(this).val(_508);
$.data(this,"radiobutton").radiobutton.find(".radiobutton-value").val(_508);
});
},enable:function(jq){
return jq.each(function(){
_4f3(this,false);
});
},disable:function(jq){
return jq.each(function(){
_4f3(this,true);
});
},check:function(jq){
return jq.each(function(){
_4f2(this,true);
});
},uncheck:function(jq){
return jq.each(function(){
_4f2(this,false);
});
},clear:function(jq){
return jq.each(function(){
_4f2(this,false);
});
},reset:function(jq){
return jq.each(function(){
var opts=$(this).radiobutton("options");
_4f2(this,opts.originalChecked);
});
}};
$.fn.radiobutton.parseOptions=function(_509){
var t=$(_509);
return $.extend({},$.parser.parseOptions(_509,["label","labelPosition","labelAlign",{labelWidth:"number"}]),{value:(t.val()||undefined),checked:(t.attr("checked")?true:undefined),disabled:(t.attr("disabled")?true:undefined)});
};
$.fn.radiobutton.defaults={width:20,height:20,value:null,disabled:false,checked:false,label:null,labelWidth:"auto",labelPosition:"before",labelAlign:"left",onChange:function(_50a){
}};
})(jQuery);
(function($){
var _50b=1;
function init(_50c){
var _50d=$("<span class=\"checkbox inputbox\">"+"<span class=\"checkbox-inner\">"+"<svg xml:space=\"preserve\" focusable=\"false\" version=\"1.1\" viewBox=\"0 0 24 24\"><path d=\"M4.1,12.7 9,17.6 20.3,6.3\" fill=\"none\" stroke=\"white\"></path></svg>"+"</span>"+"<input type=\"checkbox\" class=\"checkbox-value\">"+"</span>").insertAfter(_50c);
var t=$(_50c);
t.addClass("checkbox-f").hide();
var name=t.attr("name");
if(name){
t.removeAttr("name").attr("checkboxName",name);
_50d.find(".checkbox-value").attr("name",name);
}
return _50d;
};
function _50e(_50f){
var _510=$.data(_50f,"checkbox");
var opts=_510.options;
var _511=_510.checkbox;
var _512="_easyui_checkbox_"+(++_50b);
_511.find(".checkbox-value").attr("id",_512);
if(opts.label){
if(typeof opts.label=="object"){
_510.label=$(opts.label);
_510.label.attr("for",_512);
}else{
$(_510.label).remove();
_510.label=$("<label class=\"textbox-label\"></label>").html(opts.label);
_510.label.css("textAlign",opts.labelAlign).attr("for",_512);
if(opts.labelPosition=="after"){
_510.label.insertAfter(_511);
}else{
_510.label.insertBefore(_50f);
}
_510.label.removeClass("textbox-label-left textbox-label-right textbox-label-top");
_510.label.addClass("textbox-label-"+opts.labelPosition);
}
}else{
$(_510.label).remove();
}
$(_50f).checkbox("setValue",opts.value);
_513(_50f,opts.checked);
_514(_50f,opts.disabled);
};
function _515(_516){
var _517=$.data(_516,"checkbox");
var opts=_517.options;
var _518=_517.checkbox;
_518.unbind(".checkbox").bind("click.checkbox",function(){
if(!opts.disabled){
_513(_516,!opts.checked);
}
});
};
function _519(_51a){
var _51b=$.data(_51a,"checkbox");
var opts=_51b.options;
var _51c=_51b.checkbox;
_51c._size(opts,_51c.parent());
if(opts.label&&opts.labelPosition){
if(opts.labelPosition=="top"){
_51b.label._size({width:opts.labelWidth},_51c);
}else{
_51b.label._size({width:opts.labelWidth,height:_51c.outerHeight()},_51c);
_51b.label.css("lineHeight",_51c.outerHeight()+"px");
}
}
};
function _513(_51d,_51e){
var _51f=$.data(_51d,"checkbox");
var opts=_51f.options;
var _520=_51f.checkbox;
_520.find(".checkbox-value")._propAttr("checked",_51e);
var _521=_520.find(".checkbox-inner").css("display",_51e?"":"none");
if(_51e){
_521.addClass("checkbox-checked");
}else{
_521.removeClass("checkbox-checked");
}
if(opts.checked!=_51e){
opts.checked=_51e;
opts.onChange.call(_51d,_51e);
}
};
function _514(_522,_523){
var _524=$.data(_522,"checkbox");
var opts=_524.options;
var _525=_524.checkbox;
var rv=_525.find(".checkbox-value");
opts.disabled=_523;
if(_523){
$(_522).add(rv)._propAttr("disabled",true);
_525.addClass("checkbox-disabled");
}else{
$(_522).add(rv)._propAttr("disabled",false);
_525.removeClass("checkbox-disabled");
}
};
$.fn.checkbox=function(_526,_527){
if(typeof _526=="string"){
return $.fn.checkbox.methods[_526](this,_527);
}
_526=_526||{};
return this.each(function(){
var _528=$.data(this,"checkbox");
if(_528){
$.extend(_528.options,_526);
}else{
_528=$.data(this,"checkbox",{options:$.extend({},$.fn.checkbox.defaults,$.fn.checkbox.parseOptions(this),_526),checkbox:init(this)});
}
_528.options.originalChecked=_528.options.checked;
_50e(this);
_515(this);
_519(this);
});
};
$.fn.checkbox.methods={options:function(jq){
var _529=jq.data("checkbox");
return $.extend(_529.options,{value:_529.checkbox.find(".checkbox-value").val()});
},setValue:function(jq,_52a){
return jq.each(function(){
$(this).val(_52a);
$.data(this,"checkbox").checkbox.find(".checkbox-value").val(_52a);
});
},enable:function(jq){
return jq.each(function(){
_514(this,false);
});
},disable:function(jq){
return jq.each(function(){
_514(this,true);
});
},check:function(jq){
return jq.each(function(){
_513(this,true);
});
},uncheck:function(jq){
return jq.each(function(){
_513(this,false);
});
},clear:function(jq){
return jq.each(function(){
_513(this,false);
});
},reset:function(jq){
return jq.each(function(){
var opts=$(this).checkbox("options");
_513(this,opts.originalChecked);
});
}};
$.fn.checkbox.parseOptions=function(_52b){
var t=$(_52b);
return $.extend({},$.parser.parseOptions(_52b,["label","labelPosition","labelAlign",{labelWidth:"number"}]),{value:(t.val()||undefined),checked:(t.attr("checked")?true:undefined),disabled:(t.attr("disabled")?true:undefined)});
};
$.fn.checkbox.defaults={width:20,height:20,value:null,disabled:false,checked:false,label:null,labelWidth:"auto",labelPosition:"before",labelAlign:"left",onChange:function(_52c){
}};
})(jQuery);
(function($){
function init(_52d){
$(_52d).addClass("validatebox-text");
};
function _52e(_52f){
var _530=$.data(_52f,"validatebox");
_530.validating=false;
if(_530.vtimer){
clearTimeout(_530.vtimer);
}
if(_530.ftimer){
clearTimeout(_530.ftimer);
}
$(_52f).tooltip("destroy");
$(_52f).unbind();
$(_52f).remove();
};
function _531(_532){
var opts=$.data(_532,"validatebox").options;
$(_532).unbind(".validatebox");
if(opts.novalidate||opts.disabled){
return;
}
for(var _533 in opts.events){
$(_532).bind(_533+".validatebox",{target:_532},opts.events[_533]);
}
};
function _534(e){
var _535=e.data.target;
var _536=$.data(_535,"validatebox");
var opts=_536.options;
if($(_535).attr("readonly")){
return;
}
_536.validating=true;
_536.value=opts.val(_535);
(function(){
if(!$(_535).is(":visible")){
_536.validating=false;
}
if(_536.validating){
var _537=opts.val(_535);
if(_536.value!=_537){
_536.value=_537;
if(_536.vtimer){
clearTimeout(_536.vtimer);
}
_536.vtimer=setTimeout(function(){
$(_535).validatebox("validate");
},opts.delay);
}else{
if(_536.message){
opts.err(_535,_536.message);
}
}
_536.ftimer=setTimeout(arguments.callee,opts.interval);
}
})();
};
function _538(e){
var _539=e.data.target;
var _53a=$.data(_539,"validatebox");
var opts=_53a.options;
_53a.validating=false;
if(_53a.vtimer){
clearTimeout(_53a.vtimer);
_53a.vtimer=undefined;
}
if(_53a.ftimer){
clearTimeout(_53a.ftimer);
_53a.ftimer=undefined;
}
if(opts.validateOnBlur){
setTimeout(function(){
$(_539).validatebox("validate");
},0);
}
opts.err(_539,_53a.message,"hide");
};
function _53b(e){
var _53c=e.data.target;
var _53d=$.data(_53c,"validatebox");
_53d.options.err(_53c,_53d.message,"show");
};
function _53e(e){
var _53f=e.data.target;
var _540=$.data(_53f,"validatebox");
if(!_540.validating){
_540.options.err(_53f,_540.message,"hide");
}
};
function _541(_542,_543,_544){
var _545=$.data(_542,"validatebox");
var opts=_545.options;
var t=$(_542);
if(_544=="hide"||!_543){
t.tooltip("hide");
}else{
if((t.is(":focus")&&_545.validating)||_544=="show"){
t.tooltip($.extend({},opts.tipOptions,{content:_543,position:opts.tipPosition,deltaX:opts.deltaX,deltaY:opts.deltaY})).tooltip("show");
}
}
};
function _546(_547){
var _548=$.data(_547,"validatebox");
var opts=_548.options;
var box=$(_547);
opts.onBeforeValidate.call(_547);
var _549=_54a();
_549?box.removeClass("validatebox-invalid"):box.addClass("validatebox-invalid");
opts.err(_547,_548.message);
opts.onValidate.call(_547,_549);
return _549;
function _54b(msg){
_548.message=msg;
};
function _54c(_54d,_54e){
var _54f=opts.val(_547);
var _550=/([a-zA-Z_]+)(.*)/.exec(_54d);
var rule=opts.rules[_550[1]];
if(rule&&_54f){
var _551=_54e||opts.validParams||eval(_550[2]);
if(!rule["validator"].call(_547,_54f,_551)){
var _552=rule["message"];
if(_551){
for(var i=0;i<_551.length;i++){
_552=_552.replace(new RegExp("\\{"+i+"\\}","g"),_551[i]);
}
}
_54b(opts.invalidMessage||_552);
return false;
}
}
return true;
};
function _54a(){
_54b("");
if(!opts._validateOnCreate){
setTimeout(function(){
opts._validateOnCreate=true;
},0);
return true;
}
if(opts.novalidate||opts.disabled){
return true;
}
if(opts.required){
if(opts.val(_547)==""){
_54b(opts.missingMessage);
return false;
}
}
if(opts.validType){
if($.isArray(opts.validType)){
for(var i=0;i<opts.validType.length;i++){
if(!_54c(opts.validType[i])){
return false;
}
}
}else{
if(typeof opts.validType=="string"){
if(!_54c(opts.validType)){
return false;
}
}else{
for(var _553 in opts.validType){
var _554=opts.validType[_553];
if(!_54c(_553,_554)){
return false;
}
}
}
}
}
return true;
};
};
function _555(_556,_557){
var opts=$.data(_556,"validatebox").options;
if(_557!=undefined){
opts.disabled=_557;
}
if(opts.disabled){
$(_556).addClass("validatebox-disabled")._propAttr("disabled",true);
}else{
$(_556).removeClass("validatebox-disabled")._propAttr("disabled",false);
}
};
function _558(_559,mode){
var opts=$.data(_559,"validatebox").options;
opts.readonly=mode==undefined?true:mode;
if(opts.readonly||!opts.editable){
$(_559).triggerHandler("blur.validatebox");
$(_559).addClass("validatebox-readonly")._propAttr("readonly",true);
}else{
$(_559).removeClass("validatebox-readonly")._propAttr("readonly",false);
}
};
$.fn.validatebox=function(_55a,_55b){
if(typeof _55a=="string"){
return $.fn.validatebox.methods[_55a](this,_55b);
}
_55a=_55a||{};
return this.each(function(){
var _55c=$.data(this,"validatebox");
if(_55c){
$.extend(_55c.options,_55a);
}else{
init(this);
_55c=$.data(this,"validatebox",{options:$.extend({},$.fn.validatebox.defaults,$.fn.validatebox.parseOptions(this),_55a)});
}
_55c.options._validateOnCreate=_55c.options.validateOnCreate;
_555(this,_55c.options.disabled);
_558(this,_55c.options.readonly);
_531(this);
_546(this);
});
};
$.fn.validatebox.methods={options:function(jq){
return $.data(jq[0],"validatebox").options;
},destroy:function(jq){
return jq.each(function(){
_52e(this);
});
},validate:function(jq){
return jq.each(function(){
_546(this);
});
},isValid:function(jq){
return _546(jq[0]);
},enableValidation:function(jq){
return jq.each(function(){
$(this).validatebox("options").novalidate=false;
_531(this);
_546(this);
});
},disableValidation:function(jq){
return jq.each(function(){
$(this).validatebox("options").novalidate=true;
_531(this);
_546(this);
});
},resetValidation:function(jq){
return jq.each(function(){
var opts=$(this).validatebox("options");
opts._validateOnCreate=opts.validateOnCreate;
_546(this);
});
},enable:function(jq){
return jq.each(function(){
_555(this,false);
_531(this);
_546(this);
});
},disable:function(jq){
return jq.each(function(){
_555(this,true);
_531(this);
_546(this);
});
},readonly:function(jq,mode){
return jq.each(function(){
_558(this,mode);
_531(this);
_546(this);
});
}};
$.fn.validatebox.parseOptions=function(_55d){
var t=$(_55d);
return $.extend({},$.parser.parseOptions(_55d,["validType","missingMessage","invalidMessage","tipPosition",{delay:"number",interval:"number",deltaX:"number"},{editable:"boolean",validateOnCreate:"boolean",validateOnBlur:"boolean"}]),{required:(t.attr("required")?true:undefined),disabled:(t.attr("disabled")?true:undefined),readonly:(t.attr("readonly")?true:undefined),novalidate:(t.attr("novalidate")!=undefined?true:undefined)});
};
$.fn.validatebox.defaults={required:false,validType:null,validParams:null,delay:200,interval:200,missingMessage:"This field is required.",invalidMessage:null,tipPosition:"right",deltaX:0,deltaY:0,novalidate:false,editable:true,disabled:false,readonly:false,validateOnCreate:true,validateOnBlur:false,events:{focus:_534,blur:_538,mouseenter:_53b,mouseleave:_53e,click:function(e){
var t=$(e.data.target);
if(t.attr("type")=="checkbox"||t.attr("type")=="radio"){
t.focus().validatebox("validate");
}
}},val:function(_55e){
return $(_55e).val();
},err:function(_55f,_560,_561){
_541(_55f,_560,_561);
},tipOptions:{showEvent:"none",hideEvent:"none",showDelay:0,hideDelay:0,zIndex:"",onShow:function(){
$(this).tooltip("tip").css({color:"#000",borderColor:"#CC9933",backgroundColor:"#FFFFCC"});
},onHide:function(){
$(this).tooltip("destroy");
}},rules:{email:{validator:function(_562){
return /^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/i.test(_562);
},message:"Please enter a valid email address."},url:{validator:function(_563){
return /^(https?|ftp):\/\/(((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:)*@)?(((\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5]))|((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?)(:\d*)?)(\/((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)+(\/(([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)*)*)?)?(\?((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|[\uE000-\uF8FF]|\/|\?)*)?(\#((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|\/|\?)*)?$/i.test(_563);
},message:"Please enter a valid URL."},length:{validator:function(_564,_565){
var len=$.trim(_564).length;
return len>=_565[0]&&len<=_565[1];
},message:"Please enter a value between {0} and {1}."},remote:{validator:function(_566,_567){
var data={};
data[_567[1]]=_566;
var _568=$.ajax({url:_567[0],dataType:"json",data:data,async:false,cache:false,type:"post"}).responseText;
return _568=="true";
},message:"Please fix this field."}},onBeforeValidate:function(){
},onValidate:function(_569){
}};
})(jQuery);
(function($){
var _56a=0;
function init(_56b){
$(_56b).addClass("textbox-f").hide();
var span=$("<span class=\"textbox\">"+"<input class=\"textbox-text\" autocomplete=\"off\">"+"<input type=\"hidden\" class=\"textbox-value\">"+"</span>").insertAfter(_56b);
var name=$(_56b).attr("name");
if(name){
span.find("input.textbox-value").attr("name",name);
$(_56b).removeAttr("name").attr("textboxName",name);
}
return span;
};
function _56c(_56d){
var _56e=$.data(_56d,"textbox");
var opts=_56e.options;
var tb=_56e.textbox;
var _56f="_easyui_textbox_input"+(++_56a);
tb.addClass(opts.cls);
tb.find(".textbox-text").remove();
if(opts.multiline){
$("<textarea id=\""+_56f+"\" class=\"textbox-text\" autocomplete=\"off\"></textarea>").prependTo(tb);
}else{
$("<input id=\""+_56f+"\" type=\""+opts.type+"\" class=\"textbox-text\" autocomplete=\"off\">").prependTo(tb);
}
$("#"+_56f).attr("tabindex",$(_56d).attr("tabindex")||"").css("text-align",_56d.style.textAlign||"");
tb.find(".textbox-addon").remove();
var bb=opts.icons?$.extend(true,[],opts.icons):[];
if(opts.iconCls){
bb.push({iconCls:opts.iconCls,disabled:true});
}
if(bb.length){
var bc=$("<span class=\"textbox-addon\"></span>").prependTo(tb);
bc.addClass("textbox-addon-"+opts.iconAlign);
for(var i=0;i<bb.length;i++){
bc.append("<a href=\"javascript:;\" class=\"textbox-icon "+bb[i].iconCls+"\" icon-index=\""+i+"\" tabindex=\"-1\"></a>");
}
}
tb.find(".textbox-button").remove();
if(opts.buttonText||opts.buttonIcon){
var btn=$("<a href=\"javascript:;\" class=\"textbox-button\"></a>").prependTo(tb);
btn.addClass("textbox-button-"+opts.buttonAlign).linkbutton({text:opts.buttonText,iconCls:opts.buttonIcon,onClick:function(){
var t=$(this).parent().prev();
t.textbox("options").onClickButton.call(t[0]);
}});
}
if(opts.label){
if(typeof opts.label=="object"){
_56e.label=$(opts.label);
_56e.label.attr("for",_56f);
}else{
$(_56e.label).remove();
_56e.label=$("<label class=\"textbox-label\"></label>").html(opts.label);
_56e.label.css("textAlign",opts.labelAlign).attr("for",_56f);
if(opts.labelPosition=="after"){
_56e.label.insertAfter(tb);
}else{
_56e.label.insertBefore(_56d);
}
_56e.label.removeClass("textbox-label-left textbox-label-right textbox-label-top");
_56e.label.addClass("textbox-label-"+opts.labelPosition);
}
}else{
$(_56e.label).remove();
}
_570(_56d);
_571(_56d,opts.disabled);
_572(_56d,opts.readonly);
};
function _573(_574){
var _575=$.data(_574,"textbox");
var tb=_575.textbox;
tb.find(".textbox-text").validatebox("destroy");
tb.remove();
$(_575.label).remove();
$(_574).remove();
};
function _576(_577,_578){
var _579=$.data(_577,"textbox");
var opts=_579.options;
var tb=_579.textbox;
var _57a=tb.parent();
if(_578){
if(typeof _578=="object"){
$.extend(opts,_578);
}else{
opts.width=_578;
}
}
if(isNaN(parseInt(opts.width))){
var c=$(_577).clone();
c.css("visibility","hidden");
c.insertAfter(_577);
opts.width=c.outerWidth();
c.remove();
}
var _57b=tb.is(":visible");
if(!_57b){
tb.appendTo("body");
}
var _57c=tb.find(".textbox-text");
var btn=tb.find(".textbox-button");
var _57d=tb.find(".textbox-addon");
var _57e=_57d.find(".textbox-icon");
if(opts.height=="auto"){
_57c.css({margin:"",paddingTop:"",paddingBottom:"",height:"",lineHeight:""});
}
tb._size(opts,_57a);
if(opts.label&&opts.labelPosition){
if(opts.labelPosition=="top"){
_579.label._size({width:opts.labelWidth=="auto"?tb.outerWidth():opts.labelWidth},tb);
if(opts.height!="auto"){
tb._size("height",tb.outerHeight()-_579.label.outerHeight());
}
}else{
_579.label._size({width:opts.labelWidth,height:tb.outerHeight()},tb);
if(!opts.multiline){
_579.label.css("lineHeight",_579.label.height()+"px");
}
tb._size("width",tb.outerWidth()-_579.label.outerWidth());
}
}
if(opts.buttonAlign=="left"||opts.buttonAlign=="right"){
btn.linkbutton("resize",{height:tb.height()});
}else{
btn.linkbutton("resize",{width:"100%"});
}
var _57f=tb.width()-_57e.length*opts.iconWidth-_580("left")-_580("right");
var _581=opts.height=="auto"?_57c.outerHeight():(tb.height()-_580("top")-_580("bottom"));
_57d.css(opts.iconAlign,_580(opts.iconAlign)+"px");
_57d.css("top",_580("top")+"px");
_57e.css({width:opts.iconWidth+"px",height:_581+"px"});
_57c.css({paddingLeft:(_577.style.paddingLeft||""),paddingRight:(_577.style.paddingRight||""),marginLeft:_582("left"),marginRight:_582("right"),marginTop:_580("top"),marginBottom:_580("bottom")});
if(opts.multiline){
_57c.css({paddingTop:(_577.style.paddingTop||""),paddingBottom:(_577.style.paddingBottom||"")});
_57c._outerHeight(_581);
}else{
_57c.css({paddingTop:0,paddingBottom:0,height:_581+"px",lineHeight:_581+"px"});
}
_57c._outerWidth(_57f);
opts.onResizing.call(_577,opts.width,opts.height);
if(!_57b){
tb.insertAfter(_577);
}
opts.onResize.call(_577,opts.width,opts.height);
function _582(_583){
return (opts.iconAlign==_583?_57d._outerWidth():0)+_580(_583);
};
function _580(_584){
var w=0;
btn.filter(".textbox-button-"+_584).each(function(){
if(_584=="left"||_584=="right"){
w+=$(this).outerWidth();
}else{
w+=$(this).outerHeight();
}
});
return w;
};
};
function _570(_585){
var opts=$(_585).textbox("options");
var _586=$(_585).textbox("textbox");
_586.validatebox($.extend({},opts,{deltaX:function(_587){
return $(_585).textbox("getTipX",_587);
},deltaY:function(_588){
return $(_585).textbox("getTipY",_588);
},onBeforeValidate:function(){
opts.onBeforeValidate.call(_585);
var box=$(this);
if(!box.is(":focus")){
if(box.val()!==opts.value){
opts.oldInputValue=box.val();
box.val(opts.value);
}
}
},onValidate:function(_589){
var box=$(this);
if(opts.oldInputValue!=undefined){
box.val(opts.oldInputValue);
opts.oldInputValue=undefined;
}
var tb=box.parent();
if(_589){
tb.removeClass("textbox-invalid");
}else{
tb.addClass("textbox-invalid");
}
opts.onValidate.call(_585,_589);
}}));
};
function _58a(_58b){
var _58c=$.data(_58b,"textbox");
var opts=_58c.options;
var tb=_58c.textbox;
var _58d=tb.find(".textbox-text");
_58d.attr("placeholder",opts.prompt);
_58d.unbind(".textbox");
$(_58c.label).unbind(".textbox");
if(!opts.disabled&&!opts.readonly){
if(_58c.label){
$(_58c.label).bind("click.textbox",function(e){
if(!opts.hasFocusMe){
_58d.focus();
$(_58b).textbox("setSelectionRange",{start:0,end:_58d.val().length});
}
});
}
_58d.bind("blur.textbox",function(e){
if(!tb.hasClass("textbox-focused")){
return;
}
opts.value=$(this).val();
if(opts.value==""){
$(this).val(opts.prompt).addClass("textbox-prompt");
}else{
$(this).removeClass("textbox-prompt");
}
tb.removeClass("textbox-focused");
tb.closest(".form-field").removeClass("form-field-focused");
}).bind("focus.textbox",function(e){
opts.hasFocusMe=true;
if(tb.hasClass("textbox-focused")){
return;
}
if($(this).val()!=opts.value){
$(this).val(opts.value);
}
$(this).removeClass("textbox-prompt");
tb.addClass("textbox-focused");
tb.closest(".form-field").addClass("form-field-focused");
});
for(var _58e in opts.inputEvents){
_58d.bind(_58e+".textbox",{target:_58b},opts.inputEvents[_58e]);
}
}
var _58f=tb.find(".textbox-addon");
_58f.unbind().bind("click",{target:_58b},function(e){
var icon=$(e.target).closest("a.textbox-icon:not(.textbox-icon-disabled)");
if(icon.length){
var _590=parseInt(icon.attr("icon-index"));
var conf=opts.icons[_590];
if(conf&&conf.handler){
conf.handler.call(icon[0],e);
}
opts.onClickIcon.call(_58b,_590);
}
});
_58f.find(".textbox-icon").each(function(_591){
var conf=opts.icons[_591];
var icon=$(this);
if(!conf||conf.disabled||opts.disabled||opts.readonly){
icon.addClass("textbox-icon-disabled");
}else{
icon.removeClass("textbox-icon-disabled");
}
});
var btn=tb.find(".textbox-button");
btn.linkbutton((opts.disabled||opts.readonly)?"disable":"enable");
tb.unbind(".textbox").bind("_resize.textbox",function(e,_592){
if($(this).hasClass("easyui-fluid")||_592){
_576(_58b);
}
return false;
});
};
function _571(_593,_594){
var _595=$.data(_593,"textbox");
var opts=_595.options;
var tb=_595.textbox;
var _596=tb.find(".textbox-text");
var ss=$(_593).add(tb.find(".textbox-value"));
opts.disabled=_594;
if(opts.disabled){
_596.blur();
_596.validatebox("disable");
tb.addClass("textbox-disabled");
ss._propAttr("disabled",true);
$(_595.label).addClass("textbox-label-disabled");
}else{
_596.validatebox("enable");
tb.removeClass("textbox-disabled");
ss._propAttr("disabled",false);
$(_595.label).removeClass("textbox-label-disabled");
}
};
function _572(_597,mode){
var _598=$.data(_597,"textbox");
var opts=_598.options;
var tb=_598.textbox;
var _599=tb.find(".textbox-text");
opts.readonly=mode==undefined?true:mode;
if(opts.readonly){
_599.triggerHandler("blur.textbox");
}
_599.validatebox("readonly",opts.readonly);
tb.removeClass("textbox-readonly").addClass(opts.readonly?"textbox-readonly":"");
};
$.fn.textbox=function(_59a,_59b){
if(typeof _59a=="string"){
var _59c=$.fn.textbox.methods[_59a];
if(_59c){
return _59c(this,_59b);
}else{
return this.each(function(){
var _59d=$(this).textbox("textbox");
_59d.validatebox(_59a,_59b);
});
}
}
_59a=_59a||{};
return this.each(function(){
var _59e=$.data(this,"textbox");
if(_59e){
$.extend(_59e.options,_59a);
if(_59a.value!=undefined){
_59e.options.originalValue=_59a.value;
}
}else{
_59e=$.data(this,"textbox",{options:$.extend({},$.fn.textbox.defaults,$.fn.textbox.parseOptions(this),_59a),textbox:init(this)});
_59e.options.originalValue=_59e.options.value;
}
_56c(this);
_58a(this);
if(_59e.options.doSize){
_576(this);
}
var _59f=_59e.options.value;
_59e.options.value="";
$(this).textbox("initValue",_59f);
});
};
$.fn.textbox.methods={options:function(jq){
return $.data(jq[0],"textbox").options;
},cloneFrom:function(jq,from){
return jq.each(function(){
var t=$(this);
if(t.data("textbox")){
return;
}
if(!$(from).data("textbox")){
$(from).textbox();
}
var opts=$.extend(true,{},$(from).textbox("options"));
var name=t.attr("name")||"";
t.addClass("textbox-f").hide();
t.removeAttr("name").attr("textboxName",name);
var span=$(from).next().clone().insertAfter(t);
var _5a0="_easyui_textbox_input"+(++_56a);
span.find(".textbox-value").attr("name",name);
span.find(".textbox-text").attr("id",_5a0);
var _5a1=$($(from).textbox("label")).clone();
if(_5a1.length){
_5a1.attr("for",_5a0);
if(opts.labelPosition=="after"){
_5a1.insertAfter(t.next());
}else{
_5a1.insertBefore(t);
}
}
$.data(this,"textbox",{options:opts,textbox:span,label:(_5a1.length?_5a1:undefined)});
var _5a2=$(from).textbox("button");
if(_5a2.length){
t.textbox("button").linkbutton($.extend(true,{},_5a2.linkbutton("options")));
}
_58a(this);
_570(this);
});
},textbox:function(jq){
return $.data(jq[0],"textbox").textbox.find(".textbox-text");
},button:function(jq){
return $.data(jq[0],"textbox").textbox.find(".textbox-button");
},label:function(jq){
return $.data(jq[0],"textbox").label;
},destroy:function(jq){
return jq.each(function(){
_573(this);
});
},resize:function(jq,_5a3){
return jq.each(function(){
_576(this,_5a3);
});
},disable:function(jq){
return jq.each(function(){
_571(this,true);
_58a(this);
});
},enable:function(jq){
return jq.each(function(){
_571(this,false);
_58a(this);
});
},readonly:function(jq,mode){
return jq.each(function(){
_572(this,mode);
_58a(this);
});
},isValid:function(jq){
return jq.textbox("textbox").validatebox("isValid");
},clear:function(jq){
return jq.each(function(){
$(this).textbox("setValue","");
});
},setText:function(jq,_5a4){
return jq.each(function(){
var opts=$(this).textbox("options");
var _5a5=$(this).textbox("textbox");
_5a4=_5a4==undefined?"":String(_5a4);
if($(this).textbox("getText")!=_5a4){
_5a5.val(_5a4);
}
opts.value=_5a4;
if(!_5a5.is(":focus")){
if(_5a4){
_5a5.removeClass("textbox-prompt");
}else{
_5a5.val(opts.prompt).addClass("textbox-prompt");
}
}
if(opts.value){
$(this).closest(".form-field").removeClass("form-field-empty");
}else{
$(this).closest(".form-field").addClass("form-field-empty");
}
$(this).textbox("validate");
});
},initValue:function(jq,_5a6){
return jq.each(function(){
var _5a7=$.data(this,"textbox");
$(this).textbox("setText",_5a6);
_5a7.textbox.find(".textbox-value").val(_5a6);
$(this).val(_5a6);
});
},setValue:function(jq,_5a8){
return jq.each(function(){
var opts=$.data(this,"textbox").options;
var _5a9=$(this).textbox("getValue");
$(this).textbox("initValue",_5a8);
if(_5a9!=_5a8){
opts.onChange.call(this,_5a8,_5a9);
$(this).closest("form").trigger("_change",[this]);
}
});
},getText:function(jq){
var _5aa=jq.textbox("textbox");
if(_5aa.is(":focus")){
return _5aa.val();
}else{
return jq.textbox("options").value;
}
},getValue:function(jq){
return jq.data("textbox").textbox.find(".textbox-value").val();
},reset:function(jq){
return jq.each(function(){
var opts=$(this).textbox("options");
$(this).textbox("textbox").val(opts.originalValue);
$(this).textbox("setValue",opts.originalValue);
});
},getIcon:function(jq,_5ab){
return jq.data("textbox").textbox.find(".textbox-icon:eq("+_5ab+")");
},getTipX:function(jq,_5ac){
var _5ad=jq.data("textbox");
var opts=_5ad.options;
var tb=_5ad.textbox;
var _5ae=tb.find(".textbox-text");
var _5ac=_5ac||opts.tipPosition;
var p1=tb.offset();
var p2=_5ae.offset();
var w1=tb.outerWidth();
var w2=_5ae.outerWidth();
if(_5ac=="right"){
return w1-w2-p2.left+p1.left;
}else{
if(_5ac=="left"){
return p1.left-p2.left;
}else{
return (w1-w2-p2.left+p1.left)/2-(p2.left-p1.left)/2;
}
}
},getTipY:function(jq,_5af){
var _5b0=jq.data("textbox");
var opts=_5b0.options;
var tb=_5b0.textbox;
var _5b1=tb.find(".textbox-text");
var _5af=_5af||opts.tipPosition;
var p1=tb.offset();
var p2=_5b1.offset();
var h1=tb.outerHeight();
var h2=_5b1.outerHeight();
if(_5af=="left"||_5af=="right"){
return (h1-h2-p2.top+p1.top)/2-(p2.top-p1.top)/2;
}else{
if(_5af=="bottom"){
return (h1-h2-p2.top+p1.top);
}else{
return (p1.top-p2.top);
}
}
},getSelectionStart:function(jq){
return jq.textbox("getSelectionRange").start;
},getSelectionRange:function(jq){
var _5b2=jq.textbox("textbox")[0];
var _5b3=0;
var end=0;
if(typeof _5b2.selectionStart=="number"){
_5b3=_5b2.selectionStart;
end=_5b2.selectionEnd;
}else{
if(_5b2.createTextRange){
var s=document.selection.createRange();
var _5b4=_5b2.createTextRange();
_5b4.setEndPoint("EndToStart",s);
_5b3=_5b4.text.length;
end=_5b3+s.text.length;
}
}
return {start:_5b3,end:end};
},setSelectionRange:function(jq,_5b5){
return jq.each(function(){
var _5b6=$(this).textbox("textbox")[0];
var _5b7=_5b5.start;
var end=_5b5.end;
if(_5b6.setSelectionRange){
_5b6.setSelectionRange(_5b7,end);
}else{
if(_5b6.createTextRange){
var _5b8=_5b6.createTextRange();
_5b8.collapse();
_5b8.moveEnd("character",end);
_5b8.moveStart("character",_5b7);
_5b8.select();
}
}
});
}};
$.fn.textbox.parseOptions=function(_5b9){
var t=$(_5b9);
return $.extend({},$.fn.validatebox.parseOptions(_5b9),$.parser.parseOptions(_5b9,["prompt","iconCls","iconAlign","buttonText","buttonIcon","buttonAlign","label","labelPosition","labelAlign",{multiline:"boolean",iconWidth:"number",labelWidth:"number"}]),{value:(t.val()||undefined),type:(t.attr("type")?t.attr("type"):undefined)});
};
$.fn.textbox.defaults=$.extend({},$.fn.validatebox.defaults,{doSize:true,width:"auto",height:"auto",cls:null,prompt:"",value:"",type:"text",multiline:false,icons:[],iconCls:null,iconAlign:"right",iconWidth:26,buttonText:"",buttonIcon:null,buttonAlign:"right",label:null,labelWidth:"auto",labelPosition:"before",labelAlign:"left",inputEvents:{blur:function(e){
var t=$(e.data.target);
var opts=t.textbox("options");
if(t.textbox("getValue")!=opts.value){
t.textbox("setValue",opts.value);
}
},keydown:function(e){
if(e.keyCode==13){
var t=$(e.data.target);
t.textbox("setValue",t.textbox("getText"));
}
}},onChange:function(_5ba,_5bb){
},onResizing:function(_5bc,_5bd){
},onResize:function(_5be,_5bf){
},onClickButton:function(){
},onClickIcon:function(_5c0){
}});
})(jQuery);
(function($){
function _5c1(_5c2){
var _5c3=$.data(_5c2,"passwordbox");
var opts=_5c3.options;
var _5c4=$.extend(true,[],opts.icons);
if(opts.showEye){
_5c4.push({iconCls:"passwordbox-open",handler:function(e){
opts.revealed=!opts.revealed;
_5c5(_5c2);
}});
}
$(_5c2).addClass("passwordbox-f").textbox($.extend({},opts,{icons:_5c4}));
_5c5(_5c2);
};
function _5c6(_5c7,_5c8,all){
var t=$(_5c7);
var opts=t.passwordbox("options");
if(opts.revealed){
t.textbox("setValue",_5c8);
return;
}
var _5c9=unescape(opts.passwordChar);
var cc=_5c8.split("");
var vv=t.passwordbox("getValue").split("");
for(var i=0;i<cc.length;i++){
var c=cc[i];
if(c!=vv[i]){
if(c!=_5c9){
vv.splice(i,0,c);
}
}
}
var pos=t.passwordbox("getSelectionStart");
if(cc.length<vv.length){
vv.splice(pos,vv.length-cc.length,"");
}
for(var i=0;i<cc.length;i++){
if(all||i!=pos-1){
cc[i]=_5c9;
}
}
t.textbox("setValue",vv.join(""));
t.textbox("setText",cc.join(""));
t.textbox("setSelectionRange",{start:pos,end:pos});
};
function _5c5(_5ca,_5cb){
var t=$(_5ca);
var opts=t.passwordbox("options");
var icon=t.next().find(".passwordbox-open");
var _5cc=unescape(opts.passwordChar);
_5cb=_5cb==undefined?t.textbox("getValue"):_5cb;
t.textbox("setValue",_5cb);
t.textbox("setText",opts.revealed?_5cb:_5cb.replace(/./ig,_5cc));
opts.revealed?icon.addClass("passwordbox-close"):icon.removeClass("passwordbox-close");
};
function _5cd(e){
var _5ce=e.data.target;
var t=$(e.data.target);
var _5cf=t.data("passwordbox");
var opts=t.data("passwordbox").options;
_5cf.checking=true;
_5cf.value=t.passwordbox("getText");
(function(){
if(_5cf.checking){
var _5d0=t.passwordbox("getText");
if(_5cf.value!=_5d0){
_5cf.value=_5d0;
if(_5cf.lastTimer){
clearTimeout(_5cf.lastTimer);
_5cf.lastTimer=undefined;
}
_5c6(_5ce,_5d0);
_5cf.lastTimer=setTimeout(function(){
_5c6(_5ce,t.passwordbox("getText"),true);
_5cf.lastTimer=undefined;
},opts.lastDelay);
}
setTimeout(arguments.callee,opts.checkInterval);
}
})();
};
function _5d1(e){
var _5d2=e.data.target;
var _5d3=$(_5d2).data("passwordbox");
_5d3.checking=false;
if(_5d3.lastTimer){
clearTimeout(_5d3.lastTimer);
_5d3.lastTimer=undefined;
}
_5c5(_5d2);
};
$.fn.passwordbox=function(_5d4,_5d5){
if(typeof _5d4=="string"){
var _5d6=$.fn.passwordbox.methods[_5d4];
if(_5d6){
return _5d6(this,_5d5);
}else{
return this.textbox(_5d4,_5d5);
}
}
_5d4=_5d4||{};
return this.each(function(){
var _5d7=$.data(this,"passwordbox");
if(_5d7){
$.extend(_5d7.options,_5d4);
}else{
_5d7=$.data(this,"passwordbox",{options:$.extend({},$.fn.passwordbox.defaults,$.fn.passwordbox.parseOptions(this),_5d4)});
}
_5c1(this);
});
};
$.fn.passwordbox.methods={options:function(jq){
return $.data(jq[0],"passwordbox").options;
},setValue:function(jq,_5d8){
return jq.each(function(){
_5c5(this,_5d8);
});
},clear:function(jq){
return jq.each(function(){
_5c5(this,"");
});
},reset:function(jq){
return jq.each(function(){
$(this).textbox("reset");
_5c5(this);
});
},showPassword:function(jq){
return jq.each(function(){
var opts=$(this).passwordbox("options");
opts.revealed=true;
_5c5(this);
});
},hidePassword:function(jq){
return jq.each(function(){
var opts=$(this).passwordbox("options");
opts.revealed=false;
_5c5(this);
});
}};
$.fn.passwordbox.parseOptions=function(_5d9){
return $.extend({},$.fn.textbox.parseOptions(_5d9),$.parser.parseOptions(_5d9,["passwordChar",{checkInterval:"number",lastDelay:"number",revealed:"boolean",showEye:"boolean"}]));
};
$.fn.passwordbox.defaults=$.extend({},$.fn.textbox.defaults,{passwordChar:"%u25CF",checkInterval:200,lastDelay:500,revealed:false,showEye:true,inputEvents:{focus:_5cd,blur:_5d1},val:function(_5da){
return $(_5da).parent().prev().passwordbox("getValue");
}});
})(jQuery);
(function($){
function _5db(_5dc){
var _5dd=$(_5dc).data("maskedbox");
var opts=_5dd.options;
$(_5dc).textbox(opts);
$(_5dc).maskedbox("initValue",opts.value);
};
function _5de(_5df,_5e0){
var opts=$(_5df).maskedbox("options");
var tt=(_5e0||$(_5df).maskedbox("getText")||"").split("");
var vv=[];
for(var i=0;i<opts.mask.length;i++){
if(opts.masks[opts.mask[i]]){
var t=tt[i];
vv.push(t!=opts.promptChar?t:" ");
}
}
return vv.join("");
};
function _5e1(_5e2,_5e3){
var opts=$(_5e2).maskedbox("options");
var cc=_5e3.split("");
var tt=[];
for(var i=0;i<opts.mask.length;i++){
var m=opts.mask[i];
var r=opts.masks[m];
if(r){
var c=cc.shift();
if(c!=undefined){
var d=new RegExp(r,"i");
if(d.test(c)){
tt.push(c);
continue;
}
}
tt.push(opts.promptChar);
}else{
tt.push(m);
}
}
return tt.join("");
};
function _5e4(_5e5,c){
var opts=$(_5e5).maskedbox("options");
var _5e6=$(_5e5).maskedbox("getSelectionRange");
var _5e7=_5e8(_5e5,_5e6.start);
var end=_5e8(_5e5,_5e6.end);
if(_5e7!=-1){
var r=new RegExp(opts.masks[opts.mask[_5e7]],"i");
if(r.test(c)){
var vv=_5de(_5e5).split("");
var _5e9=_5e7-_5ea(_5e5,_5e7);
var _5eb=end-_5ea(_5e5,end);
vv.splice(_5e9,_5eb-_5e9,c);
$(_5e5).maskedbox("setValue",_5e1(_5e5,vv.join("")));
_5e7=_5e8(_5e5,++_5e7);
$(_5e5).maskedbox("setSelectionRange",{start:_5e7,end:_5e7});
}
}
};
function _5ec(_5ed,_5ee){
var opts=$(_5ed).maskedbox("options");
var vv=_5de(_5ed).split("");
var _5ef=$(_5ed).maskedbox("getSelectionRange");
if(_5ef.start==_5ef.end){
if(_5ee){
var _5f0=_5f1(_5ed,_5ef.start);
}else{
var _5f0=_5e8(_5ed,_5ef.start);
}
var _5f2=_5f0-_5ea(_5ed,_5f0);
if(_5f2>=0){
vv.splice(_5f2,1);
}
}else{
var _5f0=_5e8(_5ed,_5ef.start);
var end=_5f1(_5ed,_5ef.end);
var _5f2=_5f0-_5ea(_5ed,_5f0);
var _5f3=end-_5ea(_5ed,end);
vv.splice(_5f2,_5f3-_5f2+1);
}
$(_5ed).maskedbox("setValue",_5e1(_5ed,vv.join("")));
$(_5ed).maskedbox("setSelectionRange",{start:_5f0,end:_5f0});
};
function _5ea(_5f4,pos){
var opts=$(_5f4).maskedbox("options");
var _5f5=0;
if(pos>=opts.mask.length){
pos--;
}
for(var i=pos;i>=0;i--){
if(opts.masks[opts.mask[i]]==undefined){
_5f5++;
}
}
return _5f5;
};
function _5e8(_5f6,pos){
var opts=$(_5f6).maskedbox("options");
var m=opts.mask[pos];
var r=opts.masks[m];
while(pos<opts.mask.length&&!r){
pos++;
m=opts.mask[pos];
r=opts.masks[m];
}
return pos;
};
function _5f1(_5f7,pos){
var opts=$(_5f7).maskedbox("options");
var m=opts.mask[--pos];
var r=opts.masks[m];
while(pos>=0&&!r){
pos--;
m=opts.mask[pos];
r=opts.masks[m];
}
return pos<0?0:pos;
};
function _5f8(e){
if(e.metaKey||e.ctrlKey){
return;
}
var _5f9=e.data.target;
var opts=$(_5f9).maskedbox("options");
var _5fa=[9,13,35,36,37,39];
if($.inArray(e.keyCode,_5fa)!=-1){
return true;
}
if(e.keyCode>=96&&e.keyCode<=105){
e.keyCode-=48;
}
var c=String.fromCharCode(e.keyCode);
if(e.keyCode>=65&&e.keyCode<=90&&!e.shiftKey){
c=c.toLowerCase();
}else{
if(e.keyCode==189){
c="-";
}else{
if(e.keyCode==187){
c="+";
}else{
if(e.keyCode==190){
c=".";
}
}
}
}
if(e.keyCode==8){
_5ec(_5f9,true);
}else{
if(e.keyCode==46){
_5ec(_5f9,false);
}else{
_5e4(_5f9,c);
}
}
return false;
};
$.extend($.fn.textbox.methods,{inputMask:function(jq,_5fb){
return jq.each(function(){
var _5fc=this;
var opts=$.extend({},$.fn.maskedbox.defaults,_5fb);
$.data(_5fc,"maskedbox",{options:opts});
var _5fd=$(_5fc).textbox("textbox");
_5fd.unbind(".maskedbox");
for(var _5fe in opts.inputEvents){
_5fd.bind(_5fe+".maskedbox",{target:_5fc},opts.inputEvents[_5fe]);
}
});
}});
$.fn.maskedbox=function(_5ff,_600){
if(typeof _5ff=="string"){
var _601=$.fn.maskedbox.methods[_5ff];
if(_601){
return _601(this,_600);
}else{
return this.textbox(_5ff,_600);
}
}
_5ff=_5ff||{};
return this.each(function(){
var _602=$.data(this,"maskedbox");
if(_602){
$.extend(_602.options,_5ff);
}else{
$.data(this,"maskedbox",{options:$.extend({},$.fn.maskedbox.defaults,$.fn.maskedbox.parseOptions(this),_5ff)});
}
_5db(this);
});
};
$.fn.maskedbox.methods={options:function(jq){
var opts=jq.textbox("options");
return $.extend($.data(jq[0],"maskedbox").options,{width:opts.width,value:opts.value,originalValue:opts.originalValue,disabled:opts.disabled,readonly:opts.readonly});
},initValue:function(jq,_603){
return jq.each(function(){
_603=_5e1(this,_5de(this,_603));
$(this).textbox("initValue",_603);
});
},setValue:function(jq,_604){
return jq.each(function(){
_604=_5e1(this,_5de(this,_604));
$(this).textbox("setValue",_604);
});
}};
$.fn.maskedbox.parseOptions=function(_605){
var t=$(_605);
return $.extend({},$.fn.textbox.parseOptions(_605),$.parser.parseOptions(_605,["mask","promptChar"]),{});
};
$.fn.maskedbox.defaults=$.extend({},$.fn.textbox.defaults,{mask:"",promptChar:"_",masks:{"9":"[0-9]","a":"[a-zA-Z]","*":"[0-9a-zA-Z]"},inputEvents:{keydown:_5f8}});
})(jQuery);
(function($){
var _606=0;
function _607(_608){
var _609=$.data(_608,"filebox");
var opts=_609.options;
opts.fileboxId="filebox_file_id_"+(++_606);
$(_608).addClass("filebox-f").textbox(opts);
$(_608).textbox("textbox").attr("readonly","readonly");
_609.filebox=$(_608).next().addClass("filebox");
var file=_60a(_608);
var btn=$(_608).filebox("button");
if(btn.length){
$("<label class=\"filebox-label\" for=\""+opts.fileboxId+"\"></label>").appendTo(btn);
if(btn.linkbutton("options").disabled){
file._propAttr("disabled",true);
}else{
file._propAttr("disabled",false);
}
}
};
function _60a(_60b){
var _60c=$.data(_60b,"filebox");
var opts=_60c.options;
_60c.filebox.find(".textbox-value").remove();
opts.oldValue="";
var file=$("<input type=\"file\" class=\"textbox-value\">").appendTo(_60c.filebox);
file.attr("id",opts.fileboxId).attr("name",$(_60b).attr("textboxName")||"");
file.attr("accept",opts.accept);
file.attr("capture",opts.capture);
if(opts.multiple){
file.attr("multiple","multiple");
}
file.change(function(){
var _60d=this.value;
if(this.files){
_60d=$.map(this.files,function(file){
return file.name;
}).join(opts.separator);
}
$(_60b).filebox("setText",_60d);
opts.onChange.call(_60b,_60d,opts.oldValue);
opts.oldValue=_60d;
});
return file;
};
$.fn.filebox=function(_60e,_60f){
if(typeof _60e=="string"){
var _610=$.fn.filebox.methods[_60e];
if(_610){
return _610(this,_60f);
}else{
return this.textbox(_60e,_60f);
}
}
_60e=_60e||{};
return this.each(function(){
var _611=$.data(this,"filebox");
if(_611){
$.extend(_611.options,_60e);
}else{
$.data(this,"filebox",{options:$.extend({},$.fn.filebox.defaults,$.fn.filebox.parseOptions(this),_60e)});
}
_607(this);
});
};
$.fn.filebox.methods={options:function(jq){
var opts=jq.textbox("options");
return $.extend($.data(jq[0],"filebox").options,{width:opts.width,value:opts.value,originalValue:opts.originalValue,disabled:opts.disabled,readonly:opts.readonly});
},clear:function(jq){
return jq.each(function(){
$(this).textbox("clear");
_60a(this);
});
},reset:function(jq){
return jq.each(function(){
$(this).filebox("clear");
});
},setValue:function(jq){
return jq;
},setValues:function(jq){
return jq;
},files:function(jq){
return jq.next().find(".textbox-value")[0].files;
}};
$.fn.filebox.parseOptions=function(_612){
var t=$(_612);
return $.extend({},$.fn.textbox.parseOptions(_612),$.parser.parseOptions(_612,["accept","capture","separator"]),{multiple:(t.attr("multiple")?true:undefined)});
};
$.fn.filebox.defaults=$.extend({},$.fn.textbox.defaults,{buttonIcon:null,buttonText:"Choose File",buttonAlign:"right",inputEvents:{},accept:"",capture:"",separator:",",multiple:false});
})(jQuery);
(function($){
function _613(_614){
var _615=$.data(_614,"searchbox");
var opts=_615.options;
var _616=$.extend(true,[],opts.icons);
_616.push({iconCls:"searchbox-button",handler:function(e){
var t=$(e.data.target);
var opts=t.searchbox("options");
opts.searcher.call(e.data.target,t.searchbox("getValue"),t.searchbox("getName"));
}});
_617();
var _618=_619();
$(_614).addClass("searchbox-f").textbox($.extend({},opts,{icons:_616,buttonText:(_618?_618.text:"")}));
$(_614).attr("searchboxName",$(_614).attr("textboxName"));
_615.searchbox=$(_614).next();
_615.searchbox.addClass("searchbox");
_61a(_618);
function _617(){
if(opts.menu){
_615.menu=$(opts.menu).menu();
var _61b=_615.menu.menu("options");
var _61c=_61b.onClick;
_61b.onClick=function(item){
_61a(item);
_61c.call(this,item);
};
}else{
if(_615.menu){
_615.menu.menu("destroy");
}
_615.menu=null;
}
};
function _619(){
if(_615.menu){
var item=_615.menu.children("div.menu-item:first");
_615.menu.children("div.menu-item").each(function(){
var _61d=$.extend({},$.parser.parseOptions(this),{selected:($(this).attr("selected")?true:undefined)});
if(_61d.selected){
item=$(this);
return false;
}
});
return _615.menu.menu("getItem",item[0]);
}else{
return null;
}
};
function _61a(item){
if(!item){
return;
}
$(_614).textbox("button").menubutton({text:item.text,iconCls:(item.iconCls||null),menu:_615.menu,menuAlign:opts.buttonAlign,plain:false});
_615.searchbox.find("input.textbox-value").attr("name",item.name||item.text);
$(_614).searchbox("resize");
};
};
$.fn.searchbox=function(_61e,_61f){
if(typeof _61e=="string"){
var _620=$.fn.searchbox.methods[_61e];
if(_620){
return _620(this,_61f);
}else{
return this.textbox(_61e,_61f);
}
}
_61e=_61e||{};
return this.each(function(){
var _621=$.data(this,"searchbox");
if(_621){
$.extend(_621.options,_61e);
}else{
$.data(this,"searchbox",{options:$.extend({},$.fn.searchbox.defaults,$.fn.searchbox.parseOptions(this),_61e)});
}
_613(this);
});
};
$.fn.searchbox.methods={options:function(jq){
var opts=jq.textbox("options");
return $.extend($.data(jq[0],"searchbox").options,{width:opts.width,value:opts.value,originalValue:opts.originalValue,disabled:opts.disabled,readonly:opts.readonly});
},menu:function(jq){
return $.data(jq[0],"searchbox").menu;
},getName:function(jq){
return $.data(jq[0],"searchbox").searchbox.find("input.textbox-value").attr("name");
},selectName:function(jq,name){
return jq.each(function(){
var menu=$.data(this,"searchbox").menu;
if(menu){
menu.children("div.menu-item").each(function(){
var item=menu.menu("getItem",this);
if(item.name==name){
$(this).trigger("click");
return false;
}
});
}
});
},destroy:function(jq){
return jq.each(function(){
var menu=$(this).searchbox("menu");
if(menu){
menu.menu("destroy");
}
$(this).textbox("destroy");
});
}};
$.fn.searchbox.parseOptions=function(_622){
var t=$(_622);
return $.extend({},$.fn.textbox.parseOptions(_622),$.parser.parseOptions(_622,["menu"]),{searcher:(t.attr("searcher")?eval(t.attr("searcher")):undefined)});
};
$.fn.searchbox.defaults=$.extend({},$.fn.textbox.defaults,{inputEvents:$.extend({},$.fn.textbox.defaults.inputEvents,{keydown:function(e){
if(e.keyCode==13){
e.preventDefault();
var t=$(e.data.target);
var opts=t.searchbox("options");
t.searchbox("setValue",$(this).val());
opts.searcher.call(e.data.target,t.searchbox("getValue"),t.searchbox("getName"));
return false;
}
}}),buttonAlign:"left",menu:null,searcher:function(_623,name){
}});
})(jQuery);
(function($){
function _624(_625,_626){
var opts=$.data(_625,"form").options;
$.extend(opts,_626||{});
var _627=$.extend({},opts.queryParams);
if(opts.onSubmit.call(_625,_627)==false){
return;
}
var _628=$(_625).find(".textbox-text:focus");
_628.triggerHandler("blur");
_628.focus();
var _629=null;
if(opts.dirty){
var ff=[];
$.map(opts.dirtyFields,function(f){
if($(f).hasClass("textbox-f")){
$(f).next().find(".textbox-value").each(function(){
ff.push(this);
});
}else{
ff.push(f);
}
});
_629=$(_625).find("input[name]:enabled,textarea[name]:enabled,select[name]:enabled").filter(function(){
return $.inArray(this,ff)==-1;
});
_629._propAttr("disabled",true);
}
if(opts.ajax){
if(opts.iframe){
_62a(_625,_627);
}else{
if(window.FormData!==undefined){
_62b(_625,_627);
}else{
_62a(_625,_627);
}
}
}else{
$(_625).submit();
}
if(opts.dirty){
_629._propAttr("disabled",false);
}
};
function _62a(_62c,_62d){
var opts=$.data(_62c,"form").options;
var _62e="easyui_frame_"+(new Date().getTime());
var _62f=$("<iframe id="+_62e+" name="+_62e+"></iframe>").appendTo("body");
_62f.attr("src",window.ActiveXObject?"javascript:false":"about:blank");
_62f.css({position:"absolute",top:-1000,left:-1000});
_62f.bind("load",cb);
_630(_62d);
function _630(_631){
var form=$(_62c);
if(opts.url){
form.attr("action",opts.url);
}
var t=form.attr("target"),a=form.attr("action");
form.attr("target",_62e);
var _632=$();
try{
for(var n in _631){
var _633=$("<input type=\"hidden\" name=\""+n+"\">").val(_631[n]).appendTo(form);
_632=_632.add(_633);
}
_634();
form[0].submit();
}
finally{
form.attr("action",a);
t?form.attr("target",t):form.removeAttr("target");
_632.remove();
}
};
function _634(){
var f=$("#"+_62e);
if(!f.length){
return;
}
try{
var s=f.contents()[0].readyState;
if(s&&s.toLowerCase()=="uninitialized"){
setTimeout(_634,100);
}
}
catch(e){
cb();
}
};
var _635=10;
function cb(){
var f=$("#"+_62e);
if(!f.length){
return;
}
f.unbind();
var data="";
try{
var body=f.contents().find("body");
data=body.html();
if(data==""){
if(--_635){
setTimeout(cb,100);
return;
}
}
var ta=body.find(">textarea");
if(ta.length){
data=ta.val();
}else{
var pre=body.find(">pre");
if(pre.length){
data=pre.html();
}
}
}
catch(e){
}
opts.success.call(_62c,data);
setTimeout(function(){
f.unbind();
f.remove();
},100);
};
};
function _62b(_636,_637){
var opts=$.data(_636,"form").options;
var _638=new FormData($(_636)[0]);
for(var name in _637){
_638.append(name,_637[name]);
}
$.ajax({url:opts.url,type:"post",xhr:function(){
var xhr=$.ajaxSettings.xhr();
if(xhr.upload){
xhr.upload.addEventListener("progress",function(e){
if(e.lengthComputable){
var _639=e.total;
var _63a=e.loaded||e.position;
var _63b=Math.ceil(_63a*100/_639);
opts.onProgress.call(_636,_63b);
}
},false);
}
return xhr;
},data:_638,dataType:"html",cache:false,contentType:false,processData:false,complete:function(res){
opts.success.call(_636,res.responseText);
}});
};
function load(_63c,data){
var opts=$.data(_63c,"form").options;
if(typeof data=="string"){
var _63d={};
if(opts.onBeforeLoad.call(_63c,_63d)==false){
return;
}
$.ajax({url:data,data:_63d,dataType:"json",success:function(data){
_63e(data);
},error:function(){
opts.onLoadError.apply(_63c,arguments);
}});
}else{
_63e(data);
}
function _63e(data){
var form=$(_63c);
for(var name in data){
var val=data[name];
if(!_63f(name,val)){
if(!_640(name,val)){
form.find("input[name=\""+name+"\"]").val(val);
form.find("textarea[name=\""+name+"\"]").val(val);
form.find("select[name=\""+name+"\"]").val(val);
}
}
}
opts.onLoadSuccess.call(_63c,data);
form.form("validate");
};
function _63f(name,val){
var _641=["switchbutton","radiobutton","checkbox"];
for(var i=0;i<_641.length;i++){
var _642=_641[i];
var cc=$(_63c).find("["+_642+"Name=\""+name+"\"]");
if(cc.length){
cc[_642]("uncheck");
cc.each(function(){
if(_643($(this)[_642]("options").value,val)){
$(this)[_642]("check");
}
});
return true;
}
}
var cc=$(_63c).find("input[name=\""+name+"\"][type=radio], input[name=\""+name+"\"][type=checkbox]");
if(cc.length){
cc._propAttr("checked",false);
cc.each(function(){
if(_643($(this).val(),val)){
$(this)._propAttr("checked",true);
}
});
return true;
}
return false;
};
function _643(v,val){
if(v==String(val)||$.inArray(v,$.isArray(val)?val:[val])>=0){
return true;
}else{
return false;
}
};
function _640(name,val){
var _644=$(_63c).find("[textboxName=\""+name+"\"],[sliderName=\""+name+"\"]");
if(_644.length){
for(var i=0;i<opts.fieldTypes.length;i++){
var type=opts.fieldTypes[i];
var _645=_644.data(type);
if(_645){
if(_645.options.multiple||_645.options.range){
_644[type]("setValues",val);
}else{
_644[type]("setValue",val);
}
return true;
}
}
}
return false;
};
};
function _646(_647){
$("input,select,textarea",_647).each(function(){
if($(this).hasClass("textbox-value")){
return;
}
var t=this.type,tag=this.tagName.toLowerCase();
if(t=="text"||t=="hidden"||t=="password"||tag=="textarea"){
this.value="";
}else{
if(t=="file"){
var file=$(this);
if(!file.hasClass("textbox-value")){
var _648=file.clone().val("");
_648.insertAfter(file);
if(file.data("validatebox")){
file.validatebox("destroy");
_648.validatebox();
}else{
file.remove();
}
}
}else{
if(t=="checkbox"||t=="radio"){
this.checked=false;
}else{
if(tag=="select"){
this.selectedIndex=-1;
}
}
}
}
});
var tmp=$();
var form=$(_647);
var opts=$.data(_647,"form").options;
for(var i=0;i<opts.fieldTypes.length;i++){
var type=opts.fieldTypes[i];
var _649=form.find("."+type+"-f").not(tmp);
if(_649.length&&_649[type]){
_649[type]("clear");
tmp=tmp.add(_649);
}
}
form.form("validate");
};
function _64a(_64b){
_64b.reset();
var form=$(_64b);
var opts=$.data(_64b,"form").options;
for(var i=opts.fieldTypes.length-1;i>=0;i--){
var type=opts.fieldTypes[i];
var _64c=form.find("."+type+"-f");
if(_64c.length&&_64c[type]){
_64c[type]("reset");
}
}
form.form("validate");
};
function _64d(_64e){
var _64f=$.data(_64e,"form").options;
$(_64e).unbind(".form");
if(_64f.ajax){
$(_64e).bind("submit.form",function(){
setTimeout(function(){
_624(_64e,_64f);
},0);
return false;
});
}
$(_64e).bind("_change.form",function(e,t){
if($.inArray(t,_64f.dirtyFields)==-1){
_64f.dirtyFields.push(t);
}
_64f.onChange.call(this,t);
}).bind("change.form",function(e){
var t=e.target;
if(!$(t).hasClass("textbox-text")){
if($.inArray(t,_64f.dirtyFields)==-1){
_64f.dirtyFields.push(t);
}
_64f.onChange.call(this,t);
}
});
_650(_64e,_64f.novalidate);
};
function _651(_652,_653){
_653=_653||{};
var _654=$.data(_652,"form");
if(_654){
$.extend(_654.options,_653);
}else{
$.data(_652,"form",{options:$.extend({},$.fn.form.defaults,$.fn.form.parseOptions(_652),_653)});
}
};
function _655(_656){
if($.fn.validatebox){
var t=$(_656);
t.find(".validatebox-text:not(:disabled)").validatebox("validate");
var _657=t.find(".validatebox-invalid");
_657.filter(":not(:disabled):first").focus();
return _657.length==0;
}
return true;
};
function _650(_658,_659){
var opts=$.data(_658,"form").options;
opts.novalidate=_659;
$(_658).find(".validatebox-text:not(:disabled)").validatebox(_659?"disableValidation":"enableValidation");
};
$.fn.form=function(_65a,_65b){
if(typeof _65a=="string"){
this.each(function(){
_651(this);
});
return $.fn.form.methods[_65a](this,_65b);
}
return this.each(function(){
_651(this,_65a);
_64d(this);
});
};
$.fn.form.methods={options:function(jq){
return $.data(jq[0],"form").options;
},submit:function(jq,_65c){
return jq.each(function(){
_624(this,_65c);
});
},load:function(jq,data){
return jq.each(function(){
load(this,data);
});
},clear:function(jq){
return jq.each(function(){
_646(this);
});
},reset:function(jq){
return jq.each(function(){
_64a(this);
});
},validate:function(jq){
return _655(jq[0]);
},disableValidation:function(jq){
return jq.each(function(){
_650(this,true);
});
},enableValidation:function(jq){
return jq.each(function(){
_650(this,false);
});
},resetValidation:function(jq){
return jq.each(function(){
$(this).find(".validatebox-text:not(:disabled)").validatebox("resetValidation");
});
},resetDirty:function(jq){
return jq.each(function(){
$(this).form("options").dirtyFields=[];
});
}};
$.fn.form.parseOptions=function(_65d){
var t=$(_65d);
return $.extend({},$.parser.parseOptions(_65d,[{ajax:"boolean",dirty:"boolean"}]),{url:(t.attr("action")?t.attr("action"):undefined)});
};
$.fn.form.defaults={fieldTypes:["tagbox","combobox","combotree","combogrid","combotreegrid","datetimebox","datebox","combo","datetimespinner","timespinner","numberspinner","spinner","slider","searchbox","numberbox","passwordbox","filebox","textbox","switchbutton","radiobutton","checkbox"],novalidate:false,ajax:true,iframe:true,dirty:false,dirtyFields:[],url:null,queryParams:{},onSubmit:function(_65e){
return $(this).form("validate");
},onProgress:function(_65f){
},success:function(data){
},onBeforeLoad:function(_660){
},onLoadSuccess:function(data){
},onLoadError:function(){
},onChange:function(_661){
}};
})(jQuery);
(function($){
function _662(_663){
var _664=$.data(_663,"numberbox");
var opts=_664.options;
$(_663).addClass("numberbox-f").textbox(opts);
$(_663).textbox("textbox").css({imeMode:"disabled"});
$(_663).attr("numberboxName",$(_663).attr("textboxName"));
_664.numberbox=$(_663).next();
_664.numberbox.addClass("numberbox");
var _665=opts.parser.call(_663,opts.value);
var _666=opts.formatter.call(_663,_665);
$(_663).numberbox("initValue",_665).numberbox("setText",_666);
};
function _667(_668,_669){
var _66a=$.data(_668,"numberbox");
var opts=_66a.options;
opts.value=parseFloat(_669);
var _669=opts.parser.call(_668,_669);
var text=opts.formatter.call(_668,_669);
opts.value=_669;
$(_668).textbox("setText",text).textbox("setValue",_669);
text=opts.formatter.call(_668,$(_668).textbox("getValue"));
$(_668).textbox("setText",text);
};
$.fn.numberbox=function(_66b,_66c){
if(typeof _66b=="string"){
var _66d=$.fn.numberbox.methods[_66b];
if(_66d){
return _66d(this,_66c);
}else{
return this.textbox(_66b,_66c);
}
}
_66b=_66b||{};
return this.each(function(){
var _66e=$.data(this,"numberbox");
if(_66e){
$.extend(_66e.options,_66b);
}else{
_66e=$.data(this,"numberbox",{options:$.extend({},$.fn.numberbox.defaults,$.fn.numberbox.parseOptions(this),_66b)});
}
_662(this);
});
};
$.fn.numberbox.methods={options:function(jq){
var opts=jq.data("textbox")?jq.textbox("options"):{};
return $.extend($.data(jq[0],"numberbox").options,{width:opts.width,originalValue:opts.originalValue,disabled:opts.disabled,readonly:opts.readonly});
},cloneFrom:function(jq,from){
return jq.each(function(){
$(this).textbox("cloneFrom",from);
$.data(this,"numberbox",{options:$.extend(true,{},$(from).numberbox("options"))});
$(this).addClass("numberbox-f");
});
},fix:function(jq){
return jq.each(function(){
var opts=$(this).numberbox("options");
opts.value=null;
var _66f=opts.parser.call(this,$(this).numberbox("getText"));
$(this).numberbox("setValue",_66f);
});
},setValue:function(jq,_670){
return jq.each(function(){
_667(this,_670);
});
},clear:function(jq){
return jq.each(function(){
$(this).textbox("clear");
$(this).numberbox("options").value="";
});
},reset:function(jq){
return jq.each(function(){
$(this).textbox("reset");
$(this).numberbox("setValue",$(this).numberbox("getValue"));
});
}};
$.fn.numberbox.parseOptions=function(_671){
var t=$(_671);
return $.extend({},$.fn.textbox.parseOptions(_671),$.parser.parseOptions(_671,["decimalSeparator","groupSeparator","suffix",{min:"number",max:"number",precision:"number"}]),{prefix:(t.attr("prefix")?t.attr("prefix"):undefined)});
};
$.fn.numberbox.defaults=$.extend({},$.fn.textbox.defaults,{inputEvents:{keypress:function(e){
var _672=e.data.target;
var opts=$(_672).numberbox("options");
return opts.filter.call(_672,e);
},blur:function(e){
$(e.data.target).numberbox("fix");
},keydown:function(e){
if(e.keyCode==13){
$(e.data.target).numberbox("fix");
}
}},min:null,max:null,precision:0,decimalSeparator:".",groupSeparator:"",prefix:"",suffix:"",filter:function(e){
var opts=$(this).numberbox("options");
var s=$(this).numberbox("getText");
if(e.metaKey||e.ctrlKey){
return true;
}
if($.inArray(String(e.which),["46","8","13","0"])>=0){
return true;
}
var tmp=$("<span></span>");
tmp.html(String.fromCharCode(e.which));
var c=tmp.text();
tmp.remove();
if(!c){
return true;
}
if(c=="-"||c==opts.decimalSeparator){
return (s.indexOf(c)==-1)?true:false;
}else{
if(c==opts.groupSeparator){
return true;
}else{
if("0123456789".indexOf(c)>=0){
return true;
}else{
return false;
}
}
}
},formatter:function(_673){
if(!_673){
return _673;
}
_673=_673+"";
var opts=$(this).numberbox("options");
var s1=_673,s2="";
var dpos=_673.indexOf(".");
if(dpos>=0){
s1=_673.substring(0,dpos);
s2=_673.substring(dpos+1,_673.length);
}
if(opts.groupSeparator){
var p=/(\d+)(\d{3})/;
while(p.test(s1)){
s1=s1.replace(p,"$1"+opts.groupSeparator+"$2");
}
}
if(s2){
return opts.prefix+s1+opts.decimalSeparator+s2+opts.suffix;
}else{
return opts.prefix+s1+opts.suffix;
}
},parser:function(s){
s=s+"";
var opts=$(this).numberbox("options");
if(opts.prefix){
s=$.trim(s.replace(new RegExp("\\"+$.trim(opts.prefix),"g"),""));
}
if(opts.suffix){
s=$.trim(s.replace(new RegExp("\\"+$.trim(opts.suffix),"g"),""));
}
if(parseFloat(s)!=opts.value){
if(opts.groupSeparator){
s=$.trim(s.replace(new RegExp("\\"+opts.groupSeparator,"g"),""));
}
if(opts.decimalSeparator){
s=$.trim(s.replace(new RegExp("\\"+opts.decimalSeparator,"g"),"."));
}
s=s.replace(/\s/g,"");
}
var val=parseFloat(s).toFixed(opts.precision);
if(isNaN(val)){
val="";
}else{
if(typeof (opts.min)=="number"&&val<opts.min){
val=opts.min.toFixed(opts.precision);
}else{
if(typeof (opts.max)=="number"&&val>opts.max){
val=opts.max.toFixed(opts.precision);
}
}
}
return val;
}});
})(jQuery);
(function($){
function _674(_675,_676){
var opts=$.data(_675,"calendar").options;
var t=$(_675);
if(_676){
$.extend(opts,{width:_676.width,height:_676.height});
}
t._size(opts,t.parent());
t.find(".calendar-body")._outerHeight(t.height()-t.find(".calendar-header")._outerHeight());
if(t.find(".calendar-menu").is(":visible")){
_677(_675);
}
};
function init(_678){
$(_678).addClass("calendar").html("<div class=\"calendar-header\">"+"<div class=\"calendar-nav calendar-prevmonth\"></div>"+"<div class=\"calendar-nav calendar-nextmonth\"></div>"+"<div class=\"calendar-nav calendar-prevyear\"></div>"+"<div class=\"calendar-nav calendar-nextyear\"></div>"+"<div class=\"calendar-title\">"+"<span class=\"calendar-text\"></span>"+"</div>"+"</div>"+"<div class=\"calendar-body\">"+"<div class=\"calendar-menu\">"+"<div class=\"calendar-menu-year-inner\">"+"<span class=\"calendar-nav calendar-menu-prev\"></span>"+"<span><input class=\"calendar-menu-year\" type=\"text\"></input></span>"+"<span class=\"calendar-nav calendar-menu-next\"></span>"+"</div>"+"<div class=\"calendar-menu-month-inner\">"+"</div>"+"</div>"+"</div>");
$(_678).bind("_resize",function(e,_679){
if($(this).hasClass("easyui-fluid")||_679){
_674(_678);
}
return false;
});
};
function _67a(_67b){
var opts=$.data(_67b,"calendar").options;
var menu=$(_67b).find(".calendar-menu");
menu.find(".calendar-menu-year").unbind(".calendar").bind("keypress.calendar",function(e){
if(e.keyCode==13){
_67c(true);
}
});
$(_67b).unbind(".calendar").bind("mouseover.calendar",function(e){
var t=_67d(e.target);
if(t.hasClass("calendar-nav")||t.hasClass("calendar-text")||(t.hasClass("calendar-day")&&!t.hasClass("calendar-disabled"))){
t.addClass("calendar-nav-hover");
}
}).bind("mouseout.calendar",function(e){
var t=_67d(e.target);
if(t.hasClass("calendar-nav")||t.hasClass("calendar-text")||(t.hasClass("calendar-day")&&!t.hasClass("calendar-disabled"))){
t.removeClass("calendar-nav-hover");
}
}).bind("click.calendar",function(e){
var t=_67d(e.target);
if(t.hasClass("calendar-menu-next")||t.hasClass("calendar-nextyear")){
_67e(1);
}else{
if(t.hasClass("calendar-menu-prev")||t.hasClass("calendar-prevyear")){
_67e(-1);
}else{
if(t.hasClass("calendar-menu-month")){
menu.find(".calendar-selected").removeClass("calendar-selected");
t.addClass("calendar-selected");
_67c(true);
}else{
if(t.hasClass("calendar-prevmonth")){
_67f(-1);
}else{
if(t.hasClass("calendar-nextmonth")){
_67f(1);
}else{
if(t.hasClass("calendar-text")){
if(menu.is(":visible")){
menu.hide();
}else{
_677(_67b);
}
}else{
if(t.hasClass("calendar-day")){
if(t.hasClass("calendar-disabled")){
return;
}
var _680=opts.current;
t.closest("div.calendar-body").find(".calendar-selected").removeClass("calendar-selected");
t.addClass("calendar-selected");
var _681=t.attr("abbr").split(",");
var y=parseInt(_681[0]);
var m=parseInt(_681[1]);
var d=parseInt(_681[2]);
opts.current=new Date(y,m-1,d);
opts.onSelect.call(_67b,opts.current);
if(!_680||_680.getTime()!=opts.current.getTime()){
opts.onChange.call(_67b,opts.current,_680);
}
if(opts.year!=y||opts.month!=m){
opts.year=y;
opts.month=m;
show(_67b);
}
}
}
}
}
}
}
}
});
function _67d(t){
var day=$(t).closest(".calendar-day");
if(day.length){
return day;
}else{
return $(t);
}
};
function _67c(_682){
var menu=$(_67b).find(".calendar-menu");
var year=menu.find(".calendar-menu-year").val();
var _683=menu.find(".calendar-selected").attr("abbr");
if(!isNaN(year)){
opts.year=parseInt(year);
opts.month=parseInt(_683);
show(_67b);
}
if(_682){
menu.hide();
}
};
function _67e(_684){
opts.year+=_684;
show(_67b);
menu.find(".calendar-menu-year").val(opts.year);
};
function _67f(_685){
opts.month+=_685;
if(opts.month>12){
opts.year++;
opts.month=1;
}else{
if(opts.month<1){
opts.year--;
opts.month=12;
}
}
show(_67b);
menu.find("td.calendar-selected").removeClass("calendar-selected");
menu.find("td:eq("+(opts.month-1)+")").addClass("calendar-selected");
};
};
function _677(_686){
var opts=$.data(_686,"calendar").options;
$(_686).find(".calendar-menu").show();
if($(_686).find(".calendar-menu-month-inner").is(":empty")){
$(_686).find(".calendar-menu-month-inner").empty();
var t=$("<table class=\"calendar-mtable\"></table>").appendTo($(_686).find(".calendar-menu-month-inner"));
var idx=0;
for(var i=0;i<3;i++){
var tr=$("<tr></tr>").appendTo(t);
for(var j=0;j<4;j++){
$("<td class=\"calendar-nav calendar-menu-month\"></td>").html(opts.months[idx++]).attr("abbr",idx).appendTo(tr);
}
}
}
var body=$(_686).find(".calendar-body");
var sele=$(_686).find(".calendar-menu");
var _687=sele.find(".calendar-menu-year-inner");
var _688=sele.find(".calendar-menu-month-inner");
_687.find("input").val(opts.year).focus();
_688.find("td.calendar-selected").removeClass("calendar-selected");
_688.find("td:eq("+(opts.month-1)+")").addClass("calendar-selected");
sele._outerWidth(body._outerWidth());
sele._outerHeight(body._outerHeight());
_688._outerHeight(sele.height()-_687._outerHeight());
};
function _689(_68a,year,_68b){
var opts=$.data(_68a,"calendar").options;
var _68c=[];
var _68d=new Date(year,_68b,0).getDate();
for(var i=1;i<=_68d;i++){
_68c.push([year,_68b,i]);
}
var _68e=[],week=[];
var _68f=-1;
while(_68c.length>0){
var date=_68c.shift();
week.push(date);
var day=new Date(date[0],date[1]-1,date[2]).getDay();
if(_68f==day){
day=0;
}else{
if(day==(opts.firstDay==0?7:opts.firstDay)-1){
_68e.push(week);
week=[];
}
}
_68f=day;
}
if(week.length){
_68e.push(week);
}
var _690=_68e[0];
if(_690.length<7){
while(_690.length<7){
var _691=_690[0];
var date=new Date(_691[0],_691[1]-1,_691[2]-1);
_690.unshift([date.getFullYear(),date.getMonth()+1,date.getDate()]);
}
}else{
var _691=_690[0];
var week=[];
for(var i=1;i<=7;i++){
var date=new Date(_691[0],_691[1]-1,_691[2]-i);
week.unshift([date.getFullYear(),date.getMonth()+1,date.getDate()]);
}
_68e.unshift(week);
}
var _692=_68e[_68e.length-1];
while(_692.length<7){
var _693=_692[_692.length-1];
var date=new Date(_693[0],_693[1]-1,_693[2]+1);
_692.push([date.getFullYear(),date.getMonth()+1,date.getDate()]);
}
if(_68e.length<6){
var _693=_692[_692.length-1];
var week=[];
for(var i=1;i<=7;i++){
var date=new Date(_693[0],_693[1]-1,_693[2]+i);
week.push([date.getFullYear(),date.getMonth()+1,date.getDate()]);
}
_68e.push(week);
}
return _68e;
};
function show(_694){
var opts=$.data(_694,"calendar").options;
if(opts.current&&!opts.validator.call(_694,opts.current)){
opts.current=null;
}
var now=new Date();
var _695=now.getFullYear()+","+(now.getMonth()+1)+","+now.getDate();
var _696=opts.current?(opts.current.getFullYear()+","+(opts.current.getMonth()+1)+","+opts.current.getDate()):"";
var _697=6-opts.firstDay;
var _698=_697+1;
if(_697>=7){
_697-=7;
}
if(_698>=7){
_698-=7;
}
$(_694).find(".calendar-title span").html(opts.months[opts.month-1]+" "+opts.year);
var body=$(_694).find("div.calendar-body");
body.children("table").remove();
var data=["<table class=\"calendar-dtable\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\">"];
data.push("<thead><tr>");
if(opts.showWeek){
data.push("<th class=\"calendar-week\">"+opts.weekNumberHeader+"</th>");
}
for(var i=opts.firstDay;i<opts.weeks.length;i++){
data.push("<th>"+opts.weeks[i]+"</th>");
}
for(var i=0;i<opts.firstDay;i++){
data.push("<th>"+opts.weeks[i]+"</th>");
}
data.push("</tr></thead>");
data.push("<tbody>");
var _699=_689(_694,opts.year,opts.month);
for(var i=0;i<_699.length;i++){
var week=_699[i];
var cls="";
if(i==0){
cls="calendar-first";
}else{
if(i==_699.length-1){
cls="calendar-last";
}
}
data.push("<tr class=\""+cls+"\">");
if(opts.showWeek){
var _69a=opts.getWeekNumber(new Date(week[0][0],parseInt(week[0][1])-1,week[0][2]));
data.push("<td class=\"calendar-week\">"+_69a+"</td>");
}
for(var j=0;j<week.length;j++){
var day=week[j];
var s=day[0]+","+day[1]+","+day[2];
var _69b=new Date(day[0],parseInt(day[1])-1,day[2]);
var d=opts.formatter.call(_694,_69b);
var css=opts.styler.call(_694,_69b);
var _69c="";
var _69d="";
if(typeof css=="string"){
_69d=css;
}else{
if(css){
_69c=css["class"]||"";
_69d=css["style"]||"";
}
}
var cls="calendar-day";
if(!(opts.year==day[0]&&opts.month==day[1])){
cls+=" calendar-other-month";
}
if(s==_695){
cls+=" calendar-today";
}
if(s==_696){
cls+=" calendar-selected";
}
if(j==_697){
cls+=" calendar-saturday";
}else{
if(j==_698){
cls+=" calendar-sunday";
}
}
if(j==0){
cls+=" calendar-first";
}else{
if(j==week.length-1){
cls+=" calendar-last";
}
}
cls+=" "+_69c;
if(!opts.validator.call(_694,_69b)){
cls+=" calendar-disabled";
}
data.push("<td class=\""+cls+"\" abbr=\""+s+"\" style=\""+_69d+"\">"+d+"</td>");
}
data.push("</tr>");
}
data.push("</tbody>");
data.push("</table>");
body.append(data.join(""));
body.children("table.calendar-dtable").prependTo(body);
opts.onNavigate.call(_694,opts.year,opts.month);
};
$.fn.calendar=function(_69e,_69f){
if(typeof _69e=="string"){
return $.fn.calendar.methods[_69e](this,_69f);
}
_69e=_69e||{};
return this.each(function(){
var _6a0=$.data(this,"calendar");
if(_6a0){
$.extend(_6a0.options,_69e);
}else{
_6a0=$.data(this,"calendar",{options:$.extend({},$.fn.calendar.defaults,$.fn.calendar.parseOptions(this),_69e)});
init(this);
}
if(_6a0.options.border==false){
$(this).addClass("calendar-noborder");
}
_674(this);
_67a(this);
show(this);
$(this).find("div.calendar-menu").hide();
});
};
$.fn.calendar.methods={options:function(jq){
return $.data(jq[0],"calendar").options;
},resize:function(jq,_6a1){
return jq.each(function(){
_674(this,_6a1);
});
},moveTo:function(jq,date){
return jq.each(function(){
if(!date){
var now=new Date();
$(this).calendar({year:now.getFullYear(),month:now.getMonth()+1,current:date});
return;
}
var opts=$(this).calendar("options");
if(opts.validator.call(this,date)){
var _6a2=opts.current;
$(this).calendar({year:date.getFullYear(),month:date.getMonth()+1,current:date});
if(!_6a2||_6a2.getTime()!=date.getTime()){
opts.onChange.call(this,opts.current,_6a2);
}
}
});
}};
$.fn.calendar.parseOptions=function(_6a3){
var t=$(_6a3);
return $.extend({},$.parser.parseOptions(_6a3,["weekNumberHeader",{firstDay:"number",fit:"boolean",border:"boolean",showWeek:"boolean"}]));
};
$.fn.calendar.defaults={width:180,height:180,fit:false,border:true,showWeek:false,firstDay:0,weeks:["S","M","T","W","T","F","S"],months:["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"],year:new Date().getFullYear(),month:new Date().getMonth()+1,current:(function(){
var d=new Date();
return new Date(d.getFullYear(),d.getMonth(),d.getDate());
})(),weekNumberHeader:"",getWeekNumber:function(date){
var _6a4=new Date(date.getTime());
_6a4.setDate(_6a4.getDate()+4-(_6a4.getDay()||7));
var time=_6a4.getTime();
_6a4.setMonth(0);
_6a4.setDate(1);
return Math.floor(Math.round((time-_6a4)/86400000)/7)+1;
},formatter:function(date){
return date.getDate();
},styler:function(date){
return "";
},validator:function(date){
return true;
},onSelect:function(date){
},onChange:function(_6a5,_6a6){
},onNavigate:function(year,_6a7){
}};
})(jQuery);
(function($){
function _6a8(_6a9){
var _6aa=$.data(_6a9,"spinner");
var opts=_6aa.options;
var _6ab=$.extend(true,[],opts.icons);
if(opts.spinAlign=="left"||opts.spinAlign=="right"){
opts.spinArrow=true;
opts.iconAlign=opts.spinAlign;
var _6ac={iconCls:"spinner-button-updown",handler:function(e){
var spin=$(e.target).closest(".spinner-arrow-up,.spinner-arrow-down");
_6b6(e.data.target,spin.hasClass("spinner-arrow-down"));
}};
if(opts.spinAlign=="left"){
_6ab.unshift(_6ac);
}else{
_6ab.push(_6ac);
}
}else{
opts.spinArrow=false;
if(opts.spinAlign=="vertical"){
if(opts.buttonAlign!="top"){
opts.buttonAlign="bottom";
}
opts.clsLeft="textbox-button-bottom";
opts.clsRight="textbox-button-top";
}else{
opts.clsLeft="textbox-button-left";
opts.clsRight="textbox-button-right";
}
}
$(_6a9).addClass("spinner-f").textbox($.extend({},opts,{icons:_6ab,doSize:false,onResize:function(_6ad,_6ae){
if(!opts.spinArrow){
var span=$(this).next();
var btn=span.find(".textbox-button:not(.spinner-button)");
if(btn.length){
var _6af=btn.outerWidth();
var _6b0=btn.outerHeight();
var _6b1=span.find(".spinner-button."+opts.clsLeft);
var _6b2=span.find(".spinner-button."+opts.clsRight);
if(opts.buttonAlign=="right"){
_6b2.css("marginRight",_6af+"px");
}else{
if(opts.buttonAlign=="left"){
_6b1.css("marginLeft",_6af+"px");
}else{
if(opts.buttonAlign=="top"){
_6b2.css("marginTop",_6b0+"px");
}else{
_6b1.css("marginBottom",_6b0+"px");
}
}
}
}
}
opts.onResize.call(this,_6ad,_6ae);
}}));
$(_6a9).attr("spinnerName",$(_6a9).attr("textboxName"));
_6aa.spinner=$(_6a9).next();
_6aa.spinner.addClass("spinner");
if(opts.spinArrow){
var _6b3=_6aa.spinner.find(".spinner-button-updown");
_6b3.append("<span class=\"spinner-arrow spinner-button-top\">"+"<span class=\"spinner-arrow-up\"></span>"+"</span>"+"<span class=\"spinner-arrow spinner-button-bottom\">"+"<span class=\"spinner-arrow-down\"></span>"+"</span>");
}else{
var _6b4=$("<a href=\"javascript:;\" class=\"textbox-button spinner-button\"></a>").addClass(opts.clsLeft).appendTo(_6aa.spinner);
var _6b5=$("<a href=\"javascript:;\" class=\"textbox-button spinner-button\"></a>").addClass(opts.clsRight).appendTo(_6aa.spinner);
_6b4.linkbutton({iconCls:opts.reversed?"spinner-button-up":"spinner-button-down",onClick:function(){
_6b6(_6a9,!opts.reversed);
}});
_6b5.linkbutton({iconCls:opts.reversed?"spinner-button-down":"spinner-button-up",onClick:function(){
_6b6(_6a9,opts.reversed);
}});
if(opts.disabled){
$(_6a9).spinner("disable");
}
if(opts.readonly){
$(_6a9).spinner("readonly");
}
}
$(_6a9).spinner("resize");
};
function _6b6(_6b7,down){
var opts=$(_6b7).spinner("options");
opts.spin.call(_6b7,down);
opts[down?"onSpinDown":"onSpinUp"].call(_6b7);
$(_6b7).spinner("validate");
};
$.fn.spinner=function(_6b8,_6b9){
if(typeof _6b8=="string"){
var _6ba=$.fn.spinner.methods[_6b8];
if(_6ba){
return _6ba(this,_6b9);
}else{
return this.textbox(_6b8,_6b9);
}
}
_6b8=_6b8||{};
return this.each(function(){
var _6bb=$.data(this,"spinner");
if(_6bb){
$.extend(_6bb.options,_6b8);
}else{
_6bb=$.data(this,"spinner",{options:$.extend({},$.fn.spinner.defaults,$.fn.spinner.parseOptions(this),_6b8)});
}
_6a8(this);
});
};
$.fn.spinner.methods={options:function(jq){
var opts=jq.textbox("options");
return $.extend($.data(jq[0],"spinner").options,{width:opts.width,value:opts.value,originalValue:opts.originalValue,disabled:opts.disabled,readonly:opts.readonly});
}};
$.fn.spinner.parseOptions=function(_6bc){
return $.extend({},$.fn.textbox.parseOptions(_6bc),$.parser.parseOptions(_6bc,["min","max","spinAlign",{increment:"number",reversed:"boolean"}]));
};
$.fn.spinner.defaults=$.extend({},$.fn.textbox.defaults,{min:null,max:null,increment:1,spinAlign:"right",reversed:false,spin:function(down){
},onSpinUp:function(){
},onSpinDown:function(){
}});
})(jQuery);
(function($){
function _6bd(_6be){
$(_6be).addClass("numberspinner-f");
var opts=$.data(_6be,"numberspinner").options;
$(_6be).numberbox($.extend({},opts,{doSize:false})).spinner(opts);
$(_6be).numberbox("setValue",opts.value);
};
function _6bf(_6c0,down){
var opts=$.data(_6c0,"numberspinner").options;
var v=parseFloat($(_6c0).numberbox("getValue")||opts.value)||0;
if(down){
v-=opts.increment;
}else{
v+=opts.increment;
}
$(_6c0).numberbox("setValue",v);
};
$.fn.numberspinner=function(_6c1,_6c2){
if(typeof _6c1=="string"){
var _6c3=$.fn.numberspinner.methods[_6c1];
if(_6c3){
return _6c3(this,_6c2);
}else{
return this.numberbox(_6c1,_6c2);
}
}
_6c1=_6c1||{};
return this.each(function(){
var _6c4=$.data(this,"numberspinner");
if(_6c4){
$.extend(_6c4.options,_6c1);
}else{
$.data(this,"numberspinner",{options:$.extend({},$.fn.numberspinner.defaults,$.fn.numberspinner.parseOptions(this),_6c1)});
}
_6bd(this);
});
};
$.fn.numberspinner.methods={options:function(jq){
var opts=jq.numberbox("options");
return $.extend($.data(jq[0],"numberspinner").options,{width:opts.width,value:opts.value,originalValue:opts.originalValue,disabled:opts.disabled,readonly:opts.readonly});
}};
$.fn.numberspinner.parseOptions=function(_6c5){
return $.extend({},$.fn.spinner.parseOptions(_6c5),$.fn.numberbox.parseOptions(_6c5),{});
};
$.fn.numberspinner.defaults=$.extend({},$.fn.spinner.defaults,$.fn.numberbox.defaults,{spin:function(down){
_6bf(this,down);
}});
})(jQuery);
(function($){
function _6c6(_6c7){
var opts=$.data(_6c7,"timespinner").options;
$(_6c7).addClass("timespinner-f").spinner(opts);
var _6c8=opts.formatter.call(_6c7,opts.parser.call(_6c7,opts.value));
$(_6c7).timespinner("initValue",_6c8);
};
function _6c9(e){
var _6ca=e.data.target;
var opts=$.data(_6ca,"timespinner").options;
var _6cb=$(_6ca).timespinner("getSelectionStart");
for(var i=0;i<opts.selections.length;i++){
var _6cc=opts.selections[i];
if(_6cb>=_6cc[0]&&_6cb<=_6cc[1]){
_6cd(_6ca,i);
return;
}
}
};
function _6cd(_6ce,_6cf){
var opts=$.data(_6ce,"timespinner").options;
if(_6cf!=undefined){
opts.highlight=_6cf;
}
var _6d0=opts.selections[opts.highlight];
if(_6d0){
var tb=$(_6ce).timespinner("textbox");
$(_6ce).timespinner("setSelectionRange",{start:_6d0[0],end:_6d0[1]});
tb.focus();
}
};
function _6d1(_6d2,_6d3){
var opts=$.data(_6d2,"timespinner").options;
var _6d3=opts.parser.call(_6d2,_6d3);
var text=opts.formatter.call(_6d2,_6d3);
$(_6d2).spinner("setValue",text);
};
function _6d4(_6d5,down){
var opts=$.data(_6d5,"timespinner").options;
var s=$(_6d5).timespinner("getValue");
var _6d6=opts.selections[opts.highlight];
var s1=s.substring(0,_6d6[0]);
var s2=s.substring(_6d6[0],_6d6[1]);
var s3=s.substring(_6d6[1]);
var v=s1+((parseInt(s2,10)||0)+opts.increment*(down?-1:1))+s3;
$(_6d5).timespinner("setValue",v);
_6cd(_6d5);
};
$.fn.timespinner=function(_6d7,_6d8){
if(typeof _6d7=="string"){
var _6d9=$.fn.timespinner.methods[_6d7];
if(_6d9){
return _6d9(this,_6d8);
}else{
return this.spinner(_6d7,_6d8);
}
}
_6d7=_6d7||{};
return this.each(function(){
var _6da=$.data(this,"timespinner");
if(_6da){
$.extend(_6da.options,_6d7);
}else{
$.data(this,"timespinner",{options:$.extend({},$.fn.timespinner.defaults,$.fn.timespinner.parseOptions(this),_6d7)});
}
_6c6(this);
});
};
$.fn.timespinner.methods={options:function(jq){
var opts=jq.data("spinner")?jq.spinner("options"):{};
return $.extend($.data(jq[0],"timespinner").options,{width:opts.width,value:opts.value,originalValue:opts.originalValue,disabled:opts.disabled,readonly:opts.readonly});
},setValue:function(jq,_6db){
return jq.each(function(){
_6d1(this,_6db);
});
},getHours:function(jq){
var opts=$.data(jq[0],"timespinner").options;
var vv=jq.timespinner("getValue").split(opts.separator);
return parseInt(vv[0],10);
},getMinutes:function(jq){
var opts=$.data(jq[0],"timespinner").options;
var vv=jq.timespinner("getValue").split(opts.separator);
return parseInt(vv[1],10);
},getSeconds:function(jq){
var opts=$.data(jq[0],"timespinner").options;
var vv=jq.timespinner("getValue").split(opts.separator);
return parseInt(vv[2],10)||0;
}};
$.fn.timespinner.parseOptions=function(_6dc){
return $.extend({},$.fn.spinner.parseOptions(_6dc),$.parser.parseOptions(_6dc,["separator",{showSeconds:"boolean",highlight:"number"}]));
};
$.fn.timespinner.defaults=$.extend({},$.fn.spinner.defaults,{inputEvents:$.extend({},$.fn.spinner.defaults.inputEvents,{click:function(e){
_6c9.call(this,e);
},blur:function(e){
var t=$(e.data.target);
t.timespinner("setValue",t.timespinner("getText"));
},keydown:function(e){
if(e.keyCode==13){
var t=$(e.data.target);
t.timespinner("setValue",t.timespinner("getText"));
}
}}),formatter:function(date){
if(!date){
return "";
}
var opts=$(this).timespinner("options");
var tt=[_6dd(date.getHours()),_6dd(date.getMinutes())];
if(opts.showSeconds){
tt.push(_6dd(date.getSeconds()));
}
return tt.join(opts.separator);
function _6dd(_6de){
return (_6de<10?"0":"")+_6de;
};
},parser:function(s){
var opts=$(this).timespinner("options");
var date=_6df(s);
if(date){
var min=_6df(opts.min);
var max=_6df(opts.max);
if(min&&min>date){
date=min;
}
if(max&&max<date){
date=max;
}
}
return date;
function _6df(s){
if(!s){
return null;
}
var tt=s.split(opts.separator);
return new Date(1900,0,0,parseInt(tt[0],10)||0,parseInt(tt[1],10)||0,parseInt(tt[2],10)||0);
};
},selections:[[0,2],[3,5],[6,8]],separator:":",showSeconds:false,highlight:0,spin:function(down){
_6d4(this,down);
}});
})(jQuery);
(function($){
function _6e0(_6e1){
var opts=$.data(_6e1,"datetimespinner").options;
$(_6e1).addClass("datetimespinner-f").timespinner(opts);
};
$.fn.datetimespinner=function(_6e2,_6e3){
if(typeof _6e2=="string"){
var _6e4=$.fn.datetimespinner.methods[_6e2];
if(_6e4){
return _6e4(this,_6e3);
}else{
return this.timespinner(_6e2,_6e3);
}
}
_6e2=_6e2||{};
return this.each(function(){
var _6e5=$.data(this,"datetimespinner");
if(_6e5){
$.extend(_6e5.options,_6e2);
}else{
$.data(this,"datetimespinner",{options:$.extend({},$.fn.datetimespinner.defaults,$.fn.datetimespinner.parseOptions(this),_6e2)});
}
_6e0(this);
});
};
$.fn.datetimespinner.methods={options:function(jq){
var opts=jq.timespinner("options");
return $.extend($.data(jq[0],"datetimespinner").options,{width:opts.width,value:opts.value,originalValue:opts.originalValue,disabled:opts.disabled,readonly:opts.readonly});
}};
$.fn.datetimespinner.parseOptions=function(_6e6){
return $.extend({},$.fn.timespinner.parseOptions(_6e6),$.parser.parseOptions(_6e6,[]));
};
$.fn.datetimespinner.defaults=$.extend({},$.fn.timespinner.defaults,{formatter:function(date){
if(!date){
return "";
}
return $.fn.datebox.defaults.formatter.call(this,date)+" "+$.fn.timespinner.defaults.formatter.call(this,date);
},parser:function(s){
s=$.trim(s);
if(!s){
return null;
}
var dt=s.split(" ");
var _6e7=$.fn.datebox.defaults.parser.call(this,dt[0]);
if(dt.length<2){
return _6e7;
}
var _6e8=$.fn.timespinner.defaults.parser.call(this,dt[1]);
return new Date(_6e7.getFullYear(),_6e7.getMonth(),_6e7.getDate(),_6e8.getHours(),_6e8.getMinutes(),_6e8.getSeconds());
},selections:[[0,2],[3,5],[6,10],[11,13],[14,16],[17,19]]});
})(jQuery);
(function($){
var _6e9=0;
function _6ea(a,o){
return $.easyui.indexOfArray(a,o);
};
function _6eb(a,o,id){
$.easyui.removeArrayItem(a,o,id);
};
function _6ec(a,o,r){
$.easyui.addArrayItem(a,o,r);
};
function _6ed(_6ee,aa){
return $.data(_6ee,"treegrid")?aa.slice(1):aa;
};
function _6ef(_6f0){
var _6f1=$.data(_6f0,"datagrid");
var opts=_6f1.options;
var _6f2=_6f1.panel;
var dc=_6f1.dc;
var ss=null;
if(opts.sharedStyleSheet){
ss=typeof opts.sharedStyleSheet=="boolean"?"head":opts.sharedStyleSheet;
}else{
ss=_6f2.closest("div.datagrid-view");
if(!ss.length){
ss=dc.view;
}
}
var cc=$(ss);
var _6f3=$.data(cc[0],"ss");
if(!_6f3){
_6f3=$.data(cc[0],"ss",{cache:{},dirty:[]});
}
return {add:function(_6f4){
var ss=["<style type=\"text/css\" easyui=\"true\">"];
for(var i=0;i<_6f4.length;i++){
_6f3.cache[_6f4[i][0]]={width:_6f4[i][1]};
}
var _6f5=0;
for(var s in _6f3.cache){
var item=_6f3.cache[s];
item.index=_6f5++;
ss.push(s+"{width:"+item.width+"}");
}
ss.push("</style>");
$(ss.join("\n")).appendTo(cc);
cc.children("style[easyui]:not(:last)").remove();
},getRule:function(_6f6){
var _6f7=cc.children("style[easyui]:last")[0];
var _6f8=_6f7.styleSheet?_6f7.styleSheet:(_6f7.sheet||document.styleSheets[document.styleSheets.length-1]);
var _6f9=_6f8.cssRules||_6f8.rules;
return _6f9[_6f6];
},set:function(_6fa,_6fb){
var item=_6f3.cache[_6fa];
if(item){
item.width=_6fb;
var rule=this.getRule(item.index);
if(rule){
rule.style["width"]=_6fb;
}
}
},remove:function(_6fc){
var tmp=[];
for(var s in _6f3.cache){
if(s.indexOf(_6fc)==-1){
tmp.push([s,_6f3.cache[s].width]);
}
}
_6f3.cache={};
this.add(tmp);
},dirty:function(_6fd){
if(_6fd){
_6f3.dirty.push(_6fd);
}
},clean:function(){
for(var i=0;i<_6f3.dirty.length;i++){
this.remove(_6f3.dirty[i]);
}
_6f3.dirty=[];
}};
};
function _6fe(_6ff,_700){
var _701=$.data(_6ff,"datagrid");
var opts=_701.options;
var _702=_701.panel;
if(_700){
$.extend(opts,_700);
}
if(opts.fit==true){
var p=_702.panel("panel").parent();
opts.width=p.width();
opts.height=p.height();
}
_702.panel("resize",opts);
};
function _703(_704){
var _705=$.data(_704,"datagrid");
var opts=_705.options;
var dc=_705.dc;
var wrap=_705.panel;
var _706=wrap.width();
var _707=wrap.height();
var view=dc.view;
var _708=dc.view1;
var _709=dc.view2;
var _70a=_708.children("div.datagrid-header");
var _70b=_709.children("div.datagrid-header");
var _70c=_70a.find("table");
var _70d=_70b.find("table");
view.width(_706);
var _70e=_70a.children("div.datagrid-header-inner").show();
_708.width(_70e.find("table").width());
if(!opts.showHeader){
_70e.hide();
}
_709.width(_706-_708._outerWidth());
_708.children()._outerWidth(_708.width());
_709.children()._outerWidth(_709.width());
var all=_70a.add(_70b).add(_70c).add(_70d);
all.css("height","");
var hh=Math.max(_70c.height(),_70d.height());
all._outerHeight(hh);
view.children(".datagrid-empty").css("top",hh+"px");
dc.body1.add(dc.body2).children("table.datagrid-btable-frozen").css({position:"absolute",top:dc.header2._outerHeight()});
var _70f=dc.body2.children("table.datagrid-btable-frozen")._outerHeight();
var _710=_70f+_70b._outerHeight()+_709.children(".datagrid-footer")._outerHeight();
wrap.children(":not(.datagrid-view,.datagrid-mask,.datagrid-mask-msg)").each(function(){
_710+=$(this)._outerHeight();
});
var _711=wrap.outerHeight()-wrap.height();
var _712=wrap._size("minHeight")||"";
var _713=wrap._size("maxHeight")||"";
_708.add(_709).children("div.datagrid-body").css({marginTop:_70f,height:(isNaN(parseInt(opts.height))?"":(_707-_710)),minHeight:(_712?_712-_711-_710:""),maxHeight:(_713?_713-_711-_710:"")});
view.height(_709.height());
};
function _714(_715,_716,_717){
var rows=$.data(_715,"datagrid").data.rows;
var opts=$.data(_715,"datagrid").options;
var dc=$.data(_715,"datagrid").dc;
var tmp=$("<tr class=\"datagrid-row\" style=\"position:absolute;left:-999999px\"></tr>").appendTo("body");
var _718=tmp.outerHeight();
tmp.remove();
if(!dc.body1.is(":empty")&&(!opts.nowrap||opts.autoRowHeight||_717)){
if(_716!=undefined){
var tr1=opts.finder.getTr(_715,_716,"body",1);
var tr2=opts.finder.getTr(_715,_716,"body",2);
_719(tr1,tr2);
}else{
var tr1=opts.finder.getTr(_715,0,"allbody",1);
var tr2=opts.finder.getTr(_715,0,"allbody",2);
_719(tr1,tr2);
if(opts.showFooter){
var tr1=opts.finder.getTr(_715,0,"allfooter",1);
var tr2=opts.finder.getTr(_715,0,"allfooter",2);
_719(tr1,tr2);
}
}
}
_703(_715);
if(opts.height=="auto"){
var _71a=dc.body1.parent();
var _71b=dc.body2;
var _71c=_71d(_71b);
var _71e=_71c.height;
if(_71c.width>_71b.width()){
_71e+=18;
}
_71e-=parseInt(_71b.css("marginTop"))||0;
_71a.height(_71e);
_71b.height(_71e);
dc.view.height(dc.view2.height());
}
dc.body2.triggerHandler("scroll");
function _719(trs1,trs2){
for(var i=0;i<trs2.length;i++){
var tr1=$(trs1[i]);
var tr2=$(trs2[i]);
tr1.css("height","");
tr2.css("height","");
var _71f=Math.max(tr1.outerHeight(),tr2.outerHeight());
if(_71f!=_718){
_71f=Math.max(_71f,_718)+1;
tr1.css("height",_71f);
tr2.css("height",_71f);
}
}
};
function _71d(cc){
var _720=0;
var _721=0;
$(cc).children().each(function(){
var c=$(this);
if(c.is(":visible")){
_721+=c._outerHeight();
if(_720<c._outerWidth()){
_720=c._outerWidth();
}
}
});
return {width:_720,height:_721};
};
};
function _722(_723,_724){
var _725=$.data(_723,"datagrid");
var opts=_725.options;
var dc=_725.dc;
if(!dc.body2.children("table.datagrid-btable-frozen").length){
dc.body1.add(dc.body2).prepend("<table class=\"datagrid-btable datagrid-btable-frozen\" cellspacing=\"0\" cellpadding=\"0\"></table>");
}
_726(true);
_726(false);
_703(_723);
function _726(_727){
var _728=_727?1:2;
var tr=opts.finder.getTr(_723,_724,"body",_728);
(_727?dc.body1:dc.body2).children("table.datagrid-btable-frozen").append(tr);
};
};
function _729(_72a,_72b){
function _72c(){
var _72d=[];
var _72e=[];
$(_72a).children("thead").each(function(){
var opt=$.parser.parseOptions(this,[{frozen:"boolean"}]);
$(this).find("tr").each(function(){
var cols=[];
$(this).find("th").each(function(){
var th=$(this);
var col=$.extend({},$.parser.parseOptions(this,["id","field","align","halign","order","width",{sortable:"boolean",checkbox:"boolean",resizable:"boolean",fixed:"boolean"},{rowspan:"number",colspan:"number"}]),{title:(th.html()||undefined),hidden:(th.attr("hidden")?true:undefined),formatter:(th.attr("formatter")?eval(th.attr("formatter")):undefined),styler:(th.attr("styler")?eval(th.attr("styler")):undefined),sorter:(th.attr("sorter")?eval(th.attr("sorter")):undefined)});
if(col.width&&String(col.width).indexOf("%")==-1){
col.width=parseInt(col.width);
}
if(th.attr("editor")){
var s=$.trim(th.attr("editor"));
if(s.substr(0,1)=="{"){
col.editor=eval("("+s+")");
}else{
col.editor=s;
}
}
cols.push(col);
});
opt.frozen?_72d.push(cols):_72e.push(cols);
});
});
return [_72d,_72e];
};
var _72f=$("<div class=\"datagrid-wrap\">"+"<div class=\"datagrid-view\">"+"<div class=\"datagrid-view1\">"+"<div class=\"datagrid-header\">"+"<div class=\"datagrid-header-inner\"></div>"+"</div>"+"<div class=\"datagrid-body\">"+"<div class=\"datagrid-body-inner\"></div>"+"</div>"+"<div class=\"datagrid-footer\">"+"<div class=\"datagrid-footer-inner\"></div>"+"</div>"+"</div>"+"<div class=\"datagrid-view2\">"+"<div class=\"datagrid-header\">"+"<div class=\"datagrid-header-inner\"></div>"+"</div>"+"<div class=\"datagrid-body\"></div>"+"<div class=\"datagrid-footer\">"+"<div class=\"datagrid-footer-inner\"></div>"+"</div>"+"</div>"+"</div>"+"</div>").insertAfter(_72a);
_72f.panel({doSize:false,cls:"datagrid"});
$(_72a).addClass("datagrid-f").hide().appendTo(_72f.children("div.datagrid-view"));
var cc=_72c();
var view=_72f.children("div.datagrid-view");
var _730=view.children("div.datagrid-view1");
var _731=view.children("div.datagrid-view2");
return {panel:_72f,frozenColumns:cc[0],columns:cc[1],dc:{view:view,view1:_730,view2:_731,header1:_730.children("div.datagrid-header").children("div.datagrid-header-inner"),header2:_731.children("div.datagrid-header").children("div.datagrid-header-inner"),body1:_730.children("div.datagrid-body").children("div.datagrid-body-inner"),body2:_731.children("div.datagrid-body"),footer1:_730.children("div.datagrid-footer").children("div.datagrid-footer-inner"),footer2:_731.children("div.datagrid-footer").children("div.datagrid-footer-inner")}};
};
function _732(_733){
var _734=$.data(_733,"datagrid");
var opts=_734.options;
var dc=_734.dc;
var _735=_734.panel;
_734.ss=$(_733).datagrid("createStyleSheet");
_735.panel($.extend({},opts,{id:null,doSize:false,onResize:function(_736,_737){
if($.data(_733,"datagrid")){
_703(_733);
$(_733).datagrid("fitColumns");
opts.onResize.call(_735,_736,_737);
}
},onExpand:function(){
if($.data(_733,"datagrid")){
$(_733).datagrid("fixRowHeight").datagrid("fitColumns");
opts.onExpand.call(_735);
}
}}));
_734.rowIdPrefix="datagrid-row-r"+(++_6e9);
_734.cellClassPrefix="datagrid-cell-c"+_6e9;
_738(dc.header1,opts.frozenColumns,true);
_738(dc.header2,opts.columns,false);
_739();
dc.header1.add(dc.header2).css("display",opts.showHeader?"block":"none");
dc.footer1.add(dc.footer2).css("display",opts.showFooter?"block":"none");
if(opts.toolbar){
if($.isArray(opts.toolbar)){
$("div.datagrid-toolbar",_735).remove();
var tb=$("<div class=\"datagrid-toolbar\"><table cellspacing=\"0\" cellpadding=\"0\"><tr></tr></table></div>").prependTo(_735);
var tr=tb.find("tr");
for(var i=0;i<opts.toolbar.length;i++){
var btn=opts.toolbar[i];
if(btn=="-"){
$("<td><div class=\"datagrid-btn-separator\"></div></td>").appendTo(tr);
}else{
var td=$("<td></td>").appendTo(tr);
var tool=$("<a href=\"javascript:;\"></a>").appendTo(td);
tool[0].onclick=eval(btn.handler||function(){
});
tool.linkbutton($.extend({},btn,{plain:true}));
}
}
}else{
$(opts.toolbar).addClass("datagrid-toolbar").prependTo(_735);
$(opts.toolbar).show();
}
}else{
$("div.datagrid-toolbar",_735).remove();
}
$("div.datagrid-pager",_735).remove();
if(opts.pagination){
var _73a=$("<div class=\"datagrid-pager\"></div>");
if(opts.pagePosition=="bottom"){
_73a.appendTo(_735);
}else{
if(opts.pagePosition=="top"){
_73a.addClass("datagrid-pager-top").prependTo(_735);
}else{
var ptop=$("<div class=\"datagrid-pager datagrid-pager-top\"></div>").prependTo(_735);
_73a.appendTo(_735);
_73a=_73a.add(ptop);
}
}
_73a.pagination({total:0,pageNumber:opts.pageNumber,pageSize:opts.pageSize,pageList:opts.pageList,onSelectPage:function(_73b,_73c){
opts.pageNumber=_73b||1;
opts.pageSize=_73c;
_73a.pagination("refresh",{pageNumber:_73b,pageSize:_73c});
_784(_733);
}});
opts.pageSize=_73a.pagination("options").pageSize;
}
function _738(_73d,_73e,_73f){
if(!_73e){
return;
}
$(_73d).show();
$(_73d).empty();
var tmp=$("<div class=\"datagrid-cell\" style=\"position:absolute;left:-99999px\"></div>").appendTo("body");
tmp._outerWidth(99);
var _740=100-parseInt(tmp[0].style.width);
tmp.remove();
var _741=[];
var _742=[];
var _743=[];
if(opts.sortName){
_741=opts.sortName.split(",");
_742=opts.sortOrder.split(",");
}
var t=$("<table class=\"datagrid-htable\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\"><tbody></tbody></table>").appendTo(_73d);
for(var i=0;i<_73e.length;i++){
var tr=$("<tr class=\"datagrid-header-row\"></tr>").appendTo($("tbody",t));
var cols=_73e[i];
for(var j=0;j<cols.length;j++){
var col=cols[j];
var attr="";
if(col.rowspan){
attr+="rowspan=\""+col.rowspan+"\" ";
}
if(col.colspan){
attr+="colspan=\""+col.colspan+"\" ";
if(!col.id){
col.id=["datagrid-td-group"+_6e9,i,j].join("-");
}
}
if(col.id){
attr+="id=\""+col.id+"\"";
}
var td=$("<td "+attr+"></td>").appendTo(tr);
if(col.checkbox){
td.attr("field",col.field);
$("<div class=\"datagrid-header-check\"></div>").html("<input type=\"checkbox\"/>").appendTo(td);
}else{
if(col.field){
td.attr("field",col.field);
td.append("<div class=\"datagrid-cell\"><span></span><span class=\"datagrid-sort-icon\"></span></div>");
td.find("span:first").html(col.title);
var cell=td.find("div.datagrid-cell");
var pos=_6ea(_741,col.field);
if(pos>=0){
cell.addClass("datagrid-sort-"+_742[pos]);
}
if(col.sortable){
cell.addClass("datagrid-sort");
}
if(col.resizable==false){
cell.attr("resizable","false");
}
if(col.width){
var _744=$.parser.parseValue("width",col.width,dc.view,opts.scrollbarSize+(opts.rownumbers?opts.rownumberWidth:0));
col.deltaWidth=_740;
col.boxWidth=_744-_740;
}else{
col.auto=true;
}
cell.css("text-align",(col.halign||col.align||""));
col.cellClass=_734.cellClassPrefix+"-"+col.field.replace(/[\.|\s]/g,"-");
cell.addClass(col.cellClass);
}else{
$("<div class=\"datagrid-cell-group\"></div>").html(col.title).appendTo(td);
}
}
if(col.hidden){
td.hide();
_743.push(col.field);
}
}
}
if(_73f&&opts.rownumbers){
var td=$("<td rowspan=\""+opts.frozenColumns.length+"\"><div class=\"datagrid-header-rownumber\"></div></td>");
if($("tr",t).length==0){
td.wrap("<tr class=\"datagrid-header-row\"></tr>").parent().appendTo($("tbody",t));
}else{
td.prependTo($("tr:first",t));
}
}
for(var i=0;i<_743.length;i++){
_786(_733,_743[i],-1);
}
};
function _739(){
var _745=[[".datagrid-header-rownumber",(opts.rownumberWidth-1)+"px"],[".datagrid-cell-rownumber",(opts.rownumberWidth-1)+"px"]];
var _746=_747(_733,true).concat(_747(_733));
for(var i=0;i<_746.length;i++){
var col=_748(_733,_746[i]);
if(col&&!col.checkbox){
_745.push(["."+col.cellClass,col.boxWidth?col.boxWidth+"px":"auto"]);
}
}
_734.ss.add(_745);
_734.ss.dirty(_734.cellSelectorPrefix);
_734.cellSelectorPrefix="."+_734.cellClassPrefix;
};
};
function _749(_74a){
var _74b=$.data(_74a,"datagrid");
var _74c=_74b.panel;
var opts=_74b.options;
var dc=_74b.dc;
var _74d=dc.header1.add(dc.header2);
_74d.unbind(".datagrid");
for(var _74e in opts.headerEvents){
_74d.bind(_74e+".datagrid",opts.headerEvents[_74e]);
}
var _74f=_74d.find("div.datagrid-cell");
var _750=opts.resizeHandle=="right"?"e":(opts.resizeHandle=="left"?"w":"e,w");
_74f.each(function(){
$(this).resizable({handles:_750,edge:opts.resizeEdge,disabled:($(this).attr("resizable")?$(this).attr("resizable")=="false":false),minWidth:25,onStartResize:function(e){
_74b.resizing=true;
_74d.css("cursor",$("body").css("cursor"));
if(!_74b.proxy){
_74b.proxy=$("<div class=\"datagrid-resize-proxy\"></div>").appendTo(dc.view);
}
if(e.data.dir=="e"){
e.data.deltaEdge=$(this)._outerWidth()-(e.pageX-$(this).offset().left);
}else{
e.data.deltaEdge=$(this).offset().left-e.pageX-1;
}
_74b.proxy.css({left:e.pageX-$(_74c).offset().left-1+e.data.deltaEdge,display:"none"});
setTimeout(function(){
if(_74b.proxy){
_74b.proxy.show();
}
},500);
},onResize:function(e){
_74b.proxy.css({left:e.pageX-$(_74c).offset().left-1+e.data.deltaEdge,display:"block"});
return false;
},onStopResize:function(e){
_74d.css("cursor","");
$(this).css("height","");
var _751=$(this).parent().attr("field");
var col=_748(_74a,_751);
col.width=$(this)._outerWidth()+1;
col.boxWidth=col.width-col.deltaWidth;
col.auto=undefined;
$(this).css("width","");
$(_74a).datagrid("fixColumnSize",_751);
_74b.proxy.remove();
_74b.proxy=null;
if($(this).parents("div:first.datagrid-header").parent().hasClass("datagrid-view1")){
_703(_74a);
}
$(_74a).datagrid("fitColumns");
opts.onResizeColumn.call(_74a,_751,col.width);
setTimeout(function(){
_74b.resizing=false;
},0);
}});
});
var bb=dc.body1.add(dc.body2);
bb.unbind();
for(var _74e in opts.rowEvents){
bb.bind(_74e,opts.rowEvents[_74e]);
}
dc.body1.bind("mousewheel DOMMouseScroll",function(e){
e.preventDefault();
var e1=e.originalEvent||window.event;
var _752=e1.wheelDelta||e1.detail*(-1);
if("deltaY" in e1){
_752=e1.deltaY*-1;
}
var dg=$(e.target).closest("div.datagrid-view").children(".datagrid-f");
var dc=dg.data("datagrid").dc;
dc.body2.scrollTop(dc.body2.scrollTop()-_752);
});
dc.body2.bind("scroll",function(){
var b1=dc.view1.children("div.datagrid-body");
var stv=$(this).scrollTop();
$(this).scrollTop(stv);
b1.scrollTop(stv);
var c1=dc.body1.children(":first");
var c2=dc.body2.children(":first");
if(c1.length&&c2.length){
var top1=c1.offset().top;
var top2=c2.offset().top;
if(top1!=top2){
b1.scrollTop(b1.scrollTop()+top1-top2);
}
}
dc.view2.children("div.datagrid-header,div.datagrid-footer")._scrollLeft($(this)._scrollLeft());
dc.body2.children("table.datagrid-btable-frozen").css("left",-$(this)._scrollLeft());
});
};
function _753(_754){
return function(e){
var td=$(e.target).closest("td[field]");
if(td.length){
var _755=_756(td);
if(!$(_755).data("datagrid").resizing&&_754){
td.addClass("datagrid-header-over");
}else{
td.removeClass("datagrid-header-over");
}
}
};
};
function _757(e){
var _758=_756(e.target);
var opts=$(_758).datagrid("options");
var ck=$(e.target).closest("input[type=checkbox]");
if(ck.length){
if(opts.singleSelect&&opts.selectOnCheck){
return false;
}
if(ck.is(":checked")){
_759(_758);
}else{
_75a(_758);
}
e.stopPropagation();
}else{
var cell=$(e.target).closest(".datagrid-cell");
if(cell.length){
var p1=cell.offset().left+5;
var p2=cell.offset().left+cell._outerWidth()-5;
if(e.pageX<p2&&e.pageX>p1){
_75b(_758,cell.parent().attr("field"));
}
}
}
};
function _75c(e){
var _75d=_756(e.target);
var opts=$(_75d).datagrid("options");
var cell=$(e.target).closest(".datagrid-cell");
if(cell.length){
var p1=cell.offset().left+5;
var p2=cell.offset().left+cell._outerWidth()-5;
var cond=opts.resizeHandle=="right"?(e.pageX>p2):(opts.resizeHandle=="left"?(e.pageX<p1):(e.pageX<p1||e.pageX>p2));
if(cond){
var _75e=cell.parent().attr("field");
var col=_748(_75d,_75e);
if(col.resizable==false){
return;
}
$(_75d).datagrid("autoSizeColumn",_75e);
col.auto=false;
}
}
};
function _75f(e){
var _760=_756(e.target);
var opts=$(_760).datagrid("options");
var td=$(e.target).closest("td[field]");
opts.onHeaderContextMenu.call(_760,e,td.attr("field"));
};
function _761(_762){
return function(e){
var tr=_763(e.target);
if(!tr){
return;
}
var _764=_756(tr);
if($.data(_764,"datagrid").resizing){
return;
}
var _765=_766(tr);
if(_762){
_767(_764,_765);
}else{
var opts=$.data(_764,"datagrid").options;
opts.finder.getTr(_764,_765).removeClass("datagrid-row-over");
}
};
};
function _768(e){
var tr=_763(e.target);
if(!tr){
return;
}
var _769=_756(tr);
var opts=$.data(_769,"datagrid").options;
var _76a=_766(tr);
var tt=$(e.target);
if(tt.parent().hasClass("datagrid-cell-check")){
if(opts.singleSelect&&opts.selectOnCheck){
tt._propAttr("checked",!tt.is(":checked"));
_76b(_769,_76a);
}else{
if(tt.is(":checked")){
tt._propAttr("checked",false);
_76b(_769,_76a);
}else{
tt._propAttr("checked",true);
_76c(_769,_76a);
}
}
}else{
var row=opts.finder.getRow(_769,_76a);
var td=tt.closest("td[field]",tr);
if(td.length){
var _76d=td.attr("field");
opts.onClickCell.call(_769,_76a,_76d,row[_76d]);
}
if(opts.singleSelect==true){
_76e(_769,_76a);
}else{
if(opts.ctrlSelect){
if(e.metaKey||e.ctrlKey){
if(tr.hasClass("datagrid-row-selected")){
_76f(_769,_76a);
}else{
_76e(_769,_76a);
}
}else{
if(e.shiftKey){
$(_769).datagrid("clearSelections");
var _770=Math.min(opts.lastSelectedIndex||0,_76a);
var _771=Math.max(opts.lastSelectedIndex||0,_76a);
for(var i=_770;i<=_771;i++){
_76e(_769,i);
}
}else{
$(_769).datagrid("clearSelections");
_76e(_769,_76a);
opts.lastSelectedIndex=_76a;
}
}
}else{
if(tr.hasClass("datagrid-row-selected")){
_76f(_769,_76a);
}else{
_76e(_769,_76a);
}
}
}
opts.onClickRow.apply(_769,_6ed(_769,[_76a,row]));
}
};
function _772(e){
var tr=_763(e.target);
if(!tr){
return;
}
var _773=_756(tr);
var opts=$.data(_773,"datagrid").options;
var _774=_766(tr);
var row=opts.finder.getRow(_773,_774);
var td=$(e.target).closest("td[field]",tr);
if(td.length){
var _775=td.attr("field");
opts.onDblClickCell.call(_773,_774,_775,row[_775]);
}
opts.onDblClickRow.apply(_773,_6ed(_773,[_774,row]));
};
function _776(e){
var tr=_763(e.target);
if(tr){
var _777=_756(tr);
var opts=$.data(_777,"datagrid").options;
var _778=_766(tr);
var row=opts.finder.getRow(_777,_778);
opts.onRowContextMenu.call(_777,e,_778,row);
}else{
var body=_763(e.target,".datagrid-body");
if(body){
var _777=_756(body);
var opts=$.data(_777,"datagrid").options;
opts.onRowContextMenu.call(_777,e,-1,null);
}
}
};
function _756(t){
return $(t).closest("div.datagrid-view").children(".datagrid-f")[0];
};
function _763(t,_779){
var tr=$(t).closest(_779||"tr.datagrid-row");
if(tr.length&&tr.parent().length){
return tr;
}else{
return undefined;
}
};
function _766(tr){
if(tr.attr("datagrid-row-index")){
return parseInt(tr.attr("datagrid-row-index"));
}else{
return tr.attr("node-id");
}
};
function _75b(_77a,_77b){
var _77c=$.data(_77a,"datagrid");
var opts=_77c.options;
_77b=_77b||{};
var _77d={sortName:opts.sortName,sortOrder:opts.sortOrder};
if(typeof _77b=="object"){
$.extend(_77d,_77b);
}
var _77e=[];
var _77f=[];
if(_77d.sortName){
_77e=_77d.sortName.split(",");
_77f=_77d.sortOrder.split(",");
}
if(typeof _77b=="string"){
var _780=_77b;
var col=_748(_77a,_780);
if(!col.sortable||_77c.resizing){
return;
}
var _781=col.order||"asc";
var pos=_6ea(_77e,_780);
if(pos>=0){
var _782=_77f[pos]=="asc"?"desc":"asc";
if(opts.multiSort&&_782==_781){
_77e.splice(pos,1);
_77f.splice(pos,1);
}else{
_77f[pos]=_782;
}
}else{
if(opts.multiSort){
_77e.push(_780);
_77f.push(_781);
}else{
_77e=[_780];
_77f=[_781];
}
}
_77d.sortName=_77e.join(",");
_77d.sortOrder=_77f.join(",");
}
if(opts.onBeforeSortColumn.call(_77a,_77d.sortName,_77d.sortOrder)==false){
return;
}
$.extend(opts,_77d);
var dc=_77c.dc;
var _783=dc.header1.add(dc.header2);
_783.find("div.datagrid-cell").removeClass("datagrid-sort-asc datagrid-sort-desc");
for(var i=0;i<_77e.length;i++){
var col=_748(_77a,_77e[i]);
_783.find("div."+col.cellClass).addClass("datagrid-sort-"+_77f[i]);
}
if(opts.remoteSort){
_784(_77a);
}else{
_785(_77a,$(_77a).datagrid("getData"));
}
opts.onSortColumn.call(_77a,opts.sortName,opts.sortOrder);
};
function _786(_787,_788,_789){
_78a(true);
_78a(false);
function _78a(_78b){
var aa=_78c(_787,_78b);
if(aa.length){
var _78d=aa[aa.length-1];
var _78e=_6ea(_78d,_788);
if(_78e>=0){
for(var _78f=0;_78f<aa.length-1;_78f++){
var td=$("#"+aa[_78f][_78e]);
var _790=parseInt(td.attr("colspan")||1)+(_789||0);
td.attr("colspan",_790);
if(_790){
td.show();
}else{
td.hide();
}
}
}
}
};
};
function _791(_792){
var _793=$.data(_792,"datagrid");
var opts=_793.options;
var dc=_793.dc;
var _794=dc.view2.children("div.datagrid-header");
dc.body2.css("overflow-x","");
_795();
_796();
_797();
_795(true);
if(_794.width()>=_794.find("table").width()){
dc.body2.css("overflow-x","hidden");
}
function _797(){
if(!opts.fitColumns){
return;
}
if(!_793.leftWidth){
_793.leftWidth=0;
}
var _798=0;
var cc=[];
var _799=_747(_792,false);
for(var i=0;i<_799.length;i++){
var col=_748(_792,_799[i]);
if(_79a(col)){
_798+=col.width;
cc.push({field:col.field,col:col,addingWidth:0});
}
}
if(!_798){
return;
}
cc[cc.length-1].addingWidth-=_793.leftWidth;
var _79b=_794.children("div.datagrid-header-inner").show();
var _79c=_794.width()-_794.find("table").width()-opts.scrollbarSize+_793.leftWidth;
var rate=_79c/_798;
if(!opts.showHeader){
_79b.hide();
}
for(var i=0;i<cc.length;i++){
var c=cc[i];
var _79d=parseInt(c.col.width*rate);
c.addingWidth+=_79d;
_79c-=_79d;
}
cc[cc.length-1].addingWidth+=_79c;
for(var i=0;i<cc.length;i++){
var c=cc[i];
if(c.col.boxWidth+c.addingWidth>0){
c.col.boxWidth+=c.addingWidth;
c.col.width+=c.addingWidth;
}
}
_793.leftWidth=_79c;
$(_792).datagrid("fixColumnSize");
};
function _796(){
var _79e=false;
var _79f=_747(_792,true).concat(_747(_792,false));
$.map(_79f,function(_7a0){
var col=_748(_792,_7a0);
if(String(col.width||"").indexOf("%")>=0){
var _7a1=$.parser.parseValue("width",col.width,dc.view,opts.scrollbarSize+(opts.rownumbers?opts.rownumberWidth:0))-col.deltaWidth;
if(_7a1>0){
col.boxWidth=_7a1;
_79e=true;
}
}
});
if(_79e){
$(_792).datagrid("fixColumnSize");
}
};
function _795(fit){
var _7a2=dc.header1.add(dc.header2).find(".datagrid-cell-group");
if(_7a2.length){
_7a2.each(function(){
$(this)._outerWidth(fit?$(this).parent().width():10);
});
if(fit){
_703(_792);
}
}
};
function _79a(col){
if(String(col.width||"").indexOf("%")>=0){
return false;
}
if(!col.hidden&&!col.checkbox&&!col.auto&&!col.fixed){
return true;
}
};
};
function _7a3(_7a4,_7a5){
var _7a6=$.data(_7a4,"datagrid");
var opts=_7a6.options;
var dc=_7a6.dc;
var tmp=$("<div class=\"datagrid-cell\" style=\"position:absolute;left:-9999px\"></div>").appendTo("body");
if(_7a5){
_6fe(_7a5);
$(_7a4).datagrid("fitColumns");
}else{
var _7a7=false;
var _7a8=_747(_7a4,true).concat(_747(_7a4,false));
for(var i=0;i<_7a8.length;i++){
var _7a5=_7a8[i];
var col=_748(_7a4,_7a5);
if(col.auto){
_6fe(_7a5);
_7a7=true;
}
}
if(_7a7){
$(_7a4).datagrid("fitColumns");
}
}
tmp.remove();
function _6fe(_7a9){
var _7aa=dc.view.find("div.datagrid-header td[field=\""+_7a9+"\"] div.datagrid-cell");
_7aa.css("width","");
var col=$(_7a4).datagrid("getColumnOption",_7a9);
col.width=undefined;
col.boxWidth=undefined;
col.auto=true;
$(_7a4).datagrid("fixColumnSize",_7a9);
var _7ab=Math.max(_7ac("header"),_7ac("allbody"),_7ac("allfooter"))+1;
_7aa._outerWidth(_7ab-1);
col.width=_7ab;
col.boxWidth=parseInt(_7aa[0].style.width);
col.deltaWidth=_7ab-col.boxWidth;
_7aa.css("width","");
$(_7a4).datagrid("fixColumnSize",_7a9);
opts.onResizeColumn.call(_7a4,_7a9,col.width);
function _7ac(type){
var _7ad=0;
if(type=="header"){
_7ad=_7ae(_7aa);
}else{
opts.finder.getTr(_7a4,0,type).find("td[field=\""+_7a9+"\"] div.datagrid-cell").each(function(){
var w=_7ae($(this));
if(_7ad<w){
_7ad=w;
}
});
}
return _7ad;
function _7ae(cell){
return cell.is(":visible")?cell._outerWidth():tmp.html(cell.html())._outerWidth();
};
};
};
};
function _7af(_7b0,_7b1){
var _7b2=$.data(_7b0,"datagrid");
var opts=_7b2.options;
var dc=_7b2.dc;
var _7b3=dc.view.find("table.datagrid-btable,table.datagrid-ftable");
_7b3.css("table-layout","fixed");
if(_7b1){
fix(_7b1);
}else{
var ff=_747(_7b0,true).concat(_747(_7b0,false));
for(var i=0;i<ff.length;i++){
fix(ff[i]);
}
}
_7b3.css("table-layout","");
_7b4(_7b0);
_714(_7b0);
_7b5(_7b0);
function fix(_7b6){
var col=_748(_7b0,_7b6);
if(col.cellClass){
_7b2.ss.set("."+col.cellClass,col.boxWidth?col.boxWidth+"px":"auto");
}
};
};
function _7b4(_7b7,tds){
var dc=$.data(_7b7,"datagrid").dc;
tds=tds||dc.view.find("td.datagrid-td-merged");
tds.each(function(){
var td=$(this);
var _7b8=td.attr("colspan")||1;
if(_7b8>1){
var col=_748(_7b7,td.attr("field"));
var _7b9=col.boxWidth+col.deltaWidth-1;
for(var i=1;i<_7b8;i++){
td=td.next();
col=_748(_7b7,td.attr("field"));
_7b9+=col.boxWidth+col.deltaWidth;
}
$(this).children("div.datagrid-cell")._outerWidth(_7b9);
}
});
};
function _7b5(_7ba){
var dc=$.data(_7ba,"datagrid").dc;
dc.view.find("div.datagrid-editable").each(function(){
var cell=$(this);
var _7bb=cell.parent().attr("field");
var col=$(_7ba).datagrid("getColumnOption",_7bb);
cell._outerWidth(col.boxWidth+col.deltaWidth-1);
var ed=$.data(this,"datagrid.editor");
if(ed.actions.resize){
ed.actions.resize(ed.target,cell.width());
}
});
};
function _748(_7bc,_7bd){
function find(_7be){
if(_7be){
for(var i=0;i<_7be.length;i++){
var cc=_7be[i];
for(var j=0;j<cc.length;j++){
var c=cc[j];
if(c.field==_7bd){
return c;
}
}
}
}
return null;
};
var opts=$.data(_7bc,"datagrid").options;
var col=find(opts.columns);
if(!col){
col=find(opts.frozenColumns);
}
return col;
};
function _78c(_7bf,_7c0){
var opts=$.data(_7bf,"datagrid").options;
var _7c1=_7c0?opts.frozenColumns:opts.columns;
var aa=[];
var _7c2=_7c3();
for(var i=0;i<_7c1.length;i++){
aa[i]=new Array(_7c2);
}
for(var _7c4=0;_7c4<_7c1.length;_7c4++){
$.map(_7c1[_7c4],function(col){
var _7c5=_7c6(aa[_7c4]);
if(_7c5>=0){
var _7c7=col.field||col.id||"";
for(var c=0;c<(col.colspan||1);c++){
for(var r=0;r<(col.rowspan||1);r++){
aa[_7c4+r][_7c5]=_7c7;
}
_7c5++;
}
}
});
}
return aa;
function _7c3(){
var _7c8=0;
$.map(_7c1[0]||[],function(col){
_7c8+=col.colspan||1;
});
return _7c8;
};
function _7c6(a){
for(var i=0;i<a.length;i++){
if(a[i]==undefined){
return i;
}
}
return -1;
};
};
function _747(_7c9,_7ca){
var aa=_78c(_7c9,_7ca);
return aa.length?aa[aa.length-1]:aa;
};
function _785(_7cb,data){
var _7cc=$.data(_7cb,"datagrid");
var opts=_7cc.options;
var dc=_7cc.dc;
data=opts.loadFilter.call(_7cb,data);
if($.isArray(data)){
data={total:data.length,rows:data};
}
data.total=parseInt(data.total);
_7cc.data=data;
if(data.footer){
_7cc.footer=data.footer;
}
if(!opts.remoteSort&&opts.sortName){
var _7cd=opts.sortName.split(",");
var _7ce=opts.sortOrder.split(",");
data.rows.sort(function(r1,r2){
var r=0;
for(var i=0;i<_7cd.length;i++){
var sn=_7cd[i];
var so=_7ce[i];
var col=_748(_7cb,sn);
var _7cf=col.sorter||function(a,b){
return a==b?0:(a>b?1:-1);
};
r=_7cf(r1[sn],r2[sn])*(so=="asc"?1:-1);
if(r!=0){
return r;
}
}
return r;
});
}
if(opts.view.onBeforeRender){
opts.view.onBeforeRender.call(opts.view,_7cb,data.rows);
}
opts.view.render.call(opts.view,_7cb,dc.body2,false);
opts.view.render.call(opts.view,_7cb,dc.body1,true);
if(opts.showFooter){
opts.view.renderFooter.call(opts.view,_7cb,dc.footer2,false);
opts.view.renderFooter.call(opts.view,_7cb,dc.footer1,true);
}
if(opts.view.onAfterRender){
opts.view.onAfterRender.call(opts.view,_7cb);
}
_7cc.ss.clean();
var _7d0=$(_7cb).datagrid("getPager");
if(_7d0.length){
var _7d1=_7d0.pagination("options");
if(_7d1.total!=data.total){
_7d0.pagination("refresh",{pageNumber:opts.pageNumber,total:data.total});
if(opts.pageNumber!=_7d1.pageNumber&&_7d1.pageNumber>0){
opts.pageNumber=_7d1.pageNumber;
_784(_7cb);
}
}
}
_714(_7cb);
dc.body2.triggerHandler("scroll");
$(_7cb).datagrid("setSelectionState");
$(_7cb).datagrid("autoSizeColumn");
opts.onLoadSuccess.call(_7cb,data);
};
function _7d2(_7d3){
var _7d4=$.data(_7d3,"datagrid");
var opts=_7d4.options;
var dc=_7d4.dc;
dc.header1.add(dc.header2).find("input[type=checkbox]")._propAttr("checked",false);
if(opts.idField){
var _7d5=$.data(_7d3,"treegrid")?true:false;
var _7d6=opts.onSelect;
var _7d7=opts.onCheck;
opts.onSelect=opts.onCheck=function(){
};
var rows=opts.finder.getRows(_7d3);
for(var i=0;i<rows.length;i++){
var row=rows[i];
var _7d8=_7d5?row[opts.idField]:$(_7d3).datagrid("getRowIndex",row[opts.idField]);
if(_7d9(_7d4.selectedRows,row)){
_76e(_7d3,_7d8,true,true);
}
if(_7d9(_7d4.checkedRows,row)){
_76b(_7d3,_7d8,true);
}
}
opts.onSelect=_7d6;
opts.onCheck=_7d7;
}
function _7d9(a,r){
for(var i=0;i<a.length;i++){
if(a[i][opts.idField]==r[opts.idField]){
a[i]=r;
return true;
}
}
return false;
};
};
function _7da(_7db,row){
var _7dc=$.data(_7db,"datagrid");
var opts=_7dc.options;
var rows=_7dc.data.rows;
if(typeof row=="object"){
return _6ea(rows,row);
}else{
for(var i=0;i<rows.length;i++){
if(rows[i][opts.idField]==row){
return i;
}
}
return -1;
}
};
function _7dd(_7de){
var _7df=$.data(_7de,"datagrid");
var opts=_7df.options;
var data=_7df.data;
if(opts.idField){
return _7df.selectedRows;
}else{
var rows=[];
opts.finder.getTr(_7de,"","selected",2).each(function(){
rows.push(opts.finder.getRow(_7de,$(this)));
});
return rows;
}
};
function _7e0(_7e1){
var _7e2=$.data(_7e1,"datagrid");
var opts=_7e2.options;
if(opts.idField){
return _7e2.checkedRows;
}else{
var rows=[];
opts.finder.getTr(_7e1,"","checked",2).each(function(){
rows.push(opts.finder.getRow(_7e1,$(this)));
});
return rows;
}
};
function _7e3(_7e4,_7e5){
var _7e6=$.data(_7e4,"datagrid");
var dc=_7e6.dc;
var opts=_7e6.options;
var tr=opts.finder.getTr(_7e4,_7e5);
if(tr.length){
if(tr.closest("table").hasClass("datagrid-btable-frozen")){
return;
}
var _7e7=dc.view2.children("div.datagrid-header")._outerHeight();
var _7e8=dc.body2;
var _7e9=opts.scrollbarSize;
if(_7e8[0].offsetHeight&&_7e8[0].clientHeight&&_7e8[0].offsetHeight<=_7e8[0].clientHeight){
_7e9=0;
}
var _7ea=_7e8.outerHeight(true)-_7e8.outerHeight();
var top=tr.offset().top-dc.view2.offset().top-_7e7-_7ea;
if(top<0){
_7e8.scrollTop(_7e8.scrollTop()+top);
}else{
if(top+tr._outerHeight()>_7e8.height()-_7e9){
_7e8.scrollTop(_7e8.scrollTop()+top+tr._outerHeight()-_7e8.height()+_7e9);
}
}
}
};
function _767(_7eb,_7ec){
var _7ed=$.data(_7eb,"datagrid");
var opts=_7ed.options;
opts.finder.getTr(_7eb,_7ed.highlightIndex).removeClass("datagrid-row-over");
opts.finder.getTr(_7eb,_7ec).addClass("datagrid-row-over");
_7ed.highlightIndex=_7ec;
};
function _76e(_7ee,_7ef,_7f0,_7f1){
var _7f2=$.data(_7ee,"datagrid");
var opts=_7f2.options;
var row=opts.finder.getRow(_7ee,_7ef);
if(!row){
return;
}
if(opts.onBeforeSelect.apply(_7ee,_6ed(_7ee,[_7ef,row]))==false){
return;
}
if(opts.singleSelect){
_7f3(_7ee,true);
_7f2.selectedRows=[];
}
if(!_7f0&&opts.checkOnSelect){
_76b(_7ee,_7ef,true);
}
if(opts.idField){
_6ec(_7f2.selectedRows,opts.idField,row);
}
opts.finder.getTr(_7ee,_7ef).addClass("datagrid-row-selected");
opts.onSelect.apply(_7ee,_6ed(_7ee,[_7ef,row]));
if(!_7f1&&opts.scrollOnSelect){
_7e3(_7ee,_7ef);
}
};
function _76f(_7f4,_7f5,_7f6){
var _7f7=$.data(_7f4,"datagrid");
var dc=_7f7.dc;
var opts=_7f7.options;
var row=opts.finder.getRow(_7f4,_7f5);
if(!row){
return;
}
if(opts.onBeforeUnselect.apply(_7f4,_6ed(_7f4,[_7f5,row]))==false){
return;
}
if(!_7f6&&opts.checkOnSelect){
_76c(_7f4,_7f5,true);
}
opts.finder.getTr(_7f4,_7f5).removeClass("datagrid-row-selected");
if(opts.idField){
_6eb(_7f7.selectedRows,opts.idField,row[opts.idField]);
}
opts.onUnselect.apply(_7f4,_6ed(_7f4,[_7f5,row]));
};
function _7f8(_7f9,_7fa){
var _7fb=$.data(_7f9,"datagrid");
var opts=_7fb.options;
var rows=opts.finder.getRows(_7f9);
var _7fc=$.data(_7f9,"datagrid").selectedRows;
if(!_7fa&&opts.checkOnSelect){
_759(_7f9,true);
}
opts.finder.getTr(_7f9,"","allbody").addClass("datagrid-row-selected");
if(opts.idField){
for(var _7fd=0;_7fd<rows.length;_7fd++){
_6ec(_7fc,opts.idField,rows[_7fd]);
}
}
opts.onSelectAll.call(_7f9,rows);
};
function _7f3(_7fe,_7ff){
var _800=$.data(_7fe,"datagrid");
var opts=_800.options;
var rows=opts.finder.getRows(_7fe);
var _801=$.data(_7fe,"datagrid").selectedRows;
if(!_7ff&&opts.checkOnSelect){
_75a(_7fe,true);
}
opts.finder.getTr(_7fe,"","selected").removeClass("datagrid-row-selected");
if(opts.idField){
for(var _802=0;_802<rows.length;_802++){
_6eb(_801,opts.idField,rows[_802][opts.idField]);
}
}
opts.onUnselectAll.call(_7fe,rows);
};
function _76b(_803,_804,_805){
var _806=$.data(_803,"datagrid");
var opts=_806.options;
var row=opts.finder.getRow(_803,_804);
if(!row){
return;
}
if(opts.onBeforeCheck.apply(_803,_6ed(_803,[_804,row]))==false){
return;
}
if(opts.singleSelect&&opts.selectOnCheck){
_75a(_803,true);
_806.checkedRows=[];
}
if(!_805&&opts.selectOnCheck){
_76e(_803,_804,true);
}
var tr=opts.finder.getTr(_803,_804).addClass("datagrid-row-checked");
tr.find("div.datagrid-cell-check input[type=checkbox]")._propAttr("checked",true);
tr=opts.finder.getTr(_803,"","checked",2);
if(tr.length==opts.finder.getRows(_803).length){
var dc=_806.dc;
dc.header1.add(dc.header2).find("input[type=checkbox]")._propAttr("checked",true);
}
if(opts.idField){
_6ec(_806.checkedRows,opts.idField,row);
}
opts.onCheck.apply(_803,_6ed(_803,[_804,row]));
};
function _76c(_807,_808,_809){
var _80a=$.data(_807,"datagrid");
var opts=_80a.options;
var row=opts.finder.getRow(_807,_808);
if(!row){
return;
}
if(opts.onBeforeUncheck.apply(_807,_6ed(_807,[_808,row]))==false){
return;
}
if(!_809&&opts.selectOnCheck){
_76f(_807,_808,true);
}
var tr=opts.finder.getTr(_807,_808).removeClass("datagrid-row-checked");
tr.find("div.datagrid-cell-check input[type=checkbox]")._propAttr("checked",false);
var dc=_80a.dc;
var _80b=dc.header1.add(dc.header2);
_80b.find("input[type=checkbox]")._propAttr("checked",false);
if(opts.idField){
_6eb(_80a.checkedRows,opts.idField,row[opts.idField]);
}
opts.onUncheck.apply(_807,_6ed(_807,[_808,row]));
};
function _759(_80c,_80d){
var _80e=$.data(_80c,"datagrid");
var opts=_80e.options;
var rows=opts.finder.getRows(_80c);
if(!_80d&&opts.selectOnCheck){
_7f8(_80c,true);
}
var dc=_80e.dc;
var hck=dc.header1.add(dc.header2).find("input[type=checkbox]");
var bck=opts.finder.getTr(_80c,"","allbody").addClass("datagrid-row-checked").find("div.datagrid-cell-check input[type=checkbox]");
hck.add(bck)._propAttr("checked",true);
if(opts.idField){
for(var i=0;i<rows.length;i++){
_6ec(_80e.checkedRows,opts.idField,rows[i]);
}
}
opts.onCheckAll.call(_80c,rows);
};
function _75a(_80f,_810){
var _811=$.data(_80f,"datagrid");
var opts=_811.options;
var rows=opts.finder.getRows(_80f);
if(!_810&&opts.selectOnCheck){
_7f3(_80f,true);
}
var dc=_811.dc;
var hck=dc.header1.add(dc.header2).find("input[type=checkbox]");
var bck=opts.finder.getTr(_80f,"","checked").removeClass("datagrid-row-checked").find("div.datagrid-cell-check input[type=checkbox]");
hck.add(bck)._propAttr("checked",false);
if(opts.idField){
for(var i=0;i<rows.length;i++){
_6eb(_811.checkedRows,opts.idField,rows[i][opts.idField]);
}
}
opts.onUncheckAll.call(_80f,rows);
};
function _812(_813,_814){
var opts=$.data(_813,"datagrid").options;
var tr=opts.finder.getTr(_813,_814);
var row=opts.finder.getRow(_813,_814);
if(tr.hasClass("datagrid-row-editing")){
return;
}
if(opts.onBeforeEdit.apply(_813,_6ed(_813,[_814,row]))==false){
return;
}
tr.addClass("datagrid-row-editing");
_815(_813,_814);
_7b5(_813);
tr.find("div.datagrid-editable").each(function(){
var _816=$(this).parent().attr("field");
var ed=$.data(this,"datagrid.editor");
ed.actions.setValue(ed.target,row[_816]);
});
_817(_813,_814);
opts.onBeginEdit.apply(_813,_6ed(_813,[_814,row]));
};
function _818(_819,_81a,_81b){
var _81c=$.data(_819,"datagrid");
var opts=_81c.options;
var _81d=_81c.updatedRows;
var _81e=_81c.insertedRows;
var tr=opts.finder.getTr(_819,_81a);
var row=opts.finder.getRow(_819,_81a);
if(!tr.hasClass("datagrid-row-editing")){
return;
}
if(!_81b){
if(!_817(_819,_81a)){
return;
}
var _81f=false;
var _820={};
tr.find("div.datagrid-editable").each(function(){
var _821=$(this).parent().attr("field");
var ed=$.data(this,"datagrid.editor");
var t=$(ed.target);
var _822=t.data("textbox")?t.textbox("textbox"):t;
if(_822.is(":focus")){
_822.triggerHandler("blur");
}
var _823=ed.actions.getValue(ed.target);
if(row[_821]!==_823){
row[_821]=_823;
_81f=true;
_820[_821]=_823;
}
});
if(_81f){
if(_6ea(_81e,row)==-1){
if(_6ea(_81d,row)==-1){
_81d.push(row);
}
}
}
opts.onEndEdit.apply(_819,_6ed(_819,[_81a,row,_820]));
}
tr.removeClass("datagrid-row-editing");
_824(_819,_81a);
$(_819).datagrid("refreshRow",_81a);
if(!_81b){
opts.onAfterEdit.apply(_819,_6ed(_819,[_81a,row,_820]));
}else{
opts.onCancelEdit.apply(_819,_6ed(_819,[_81a,row]));
}
};
function _825(_826,_827){
var opts=$.data(_826,"datagrid").options;
var tr=opts.finder.getTr(_826,_827);
var _828=[];
tr.children("td").each(function(){
var cell=$(this).find("div.datagrid-editable");
if(cell.length){
var ed=$.data(cell[0],"datagrid.editor");
_828.push(ed);
}
});
return _828;
};
function _829(_82a,_82b){
var _82c=_825(_82a,_82b.index!=undefined?_82b.index:_82b.id);
for(var i=0;i<_82c.length;i++){
if(_82c[i].field==_82b.field){
return _82c[i];
}
}
return null;
};
function _815(_82d,_82e){
var opts=$.data(_82d,"datagrid").options;
var tr=opts.finder.getTr(_82d,_82e);
tr.children("td").each(function(){
var cell=$(this).find("div.datagrid-cell");
var _82f=$(this).attr("field");
var col=_748(_82d,_82f);
if(col&&col.editor){
var _830,_831;
if(typeof col.editor=="string"){
_830=col.editor;
}else{
_830=col.editor.type;
_831=col.editor.options;
}
var _832=opts.editors[_830];
if(_832){
var _833=cell.html();
var _834=cell._outerWidth();
cell.addClass("datagrid-editable");
cell._outerWidth(_834);
cell.html("<table border=\"0\" cellspacing=\"0\" cellpadding=\"1\"><tr><td></td></tr></table>");
cell.children("table").bind("click dblclick contextmenu",function(e){
e.stopPropagation();
});
$.data(cell[0],"datagrid.editor",{actions:_832,target:_832.init(cell.find("td"),$.extend({height:opts.editorHeight},_831)),field:_82f,type:_830,oldHtml:_833});
}
}
});
_714(_82d,_82e,true);
};
function _824(_835,_836){
var opts=$.data(_835,"datagrid").options;
var tr=opts.finder.getTr(_835,_836);
tr.children("td").each(function(){
var cell=$(this).find("div.datagrid-editable");
if(cell.length){
var ed=$.data(cell[0],"datagrid.editor");
if(ed.actions.destroy){
ed.actions.destroy(ed.target);
}
cell.html(ed.oldHtml);
$.removeData(cell[0],"datagrid.editor");
cell.removeClass("datagrid-editable");
cell.css("width","");
}
});
};
function _817(_837,_838){
var tr=$.data(_837,"datagrid").options.finder.getTr(_837,_838);
if(!tr.hasClass("datagrid-row-editing")){
return true;
}
var vbox=tr.find(".validatebox-text");
vbox.validatebox("validate");
vbox.trigger("mouseleave");
var _839=tr.find(".validatebox-invalid");
return _839.length==0;
};
function _83a(_83b,_83c){
var _83d=$.data(_83b,"datagrid").insertedRows;
var _83e=$.data(_83b,"datagrid").deletedRows;
var _83f=$.data(_83b,"datagrid").updatedRows;
if(!_83c){
var rows=[];
rows=rows.concat(_83d);
rows=rows.concat(_83e);
rows=rows.concat(_83f);
return rows;
}else{
if(_83c=="inserted"){
return _83d;
}else{
if(_83c=="deleted"){
return _83e;
}else{
if(_83c=="updated"){
return _83f;
}
}
}
}
return [];
};
function _840(_841,_842){
var _843=$.data(_841,"datagrid");
var opts=_843.options;
var data=_843.data;
var _844=_843.insertedRows;
var _845=_843.deletedRows;
$(_841).datagrid("cancelEdit",_842);
var row=opts.finder.getRow(_841,_842);
if(_6ea(_844,row)>=0){
_6eb(_844,row);
}else{
_845.push(row);
}
_6eb(_843.selectedRows,opts.idField,row[opts.idField]);
_6eb(_843.checkedRows,opts.idField,row[opts.idField]);
opts.view.deleteRow.call(opts.view,_841,_842);
if(opts.height=="auto"){
_714(_841);
}
$(_841).datagrid("getPager").pagination("refresh",{total:data.total});
};
function _846(_847,_848){
var data=$.data(_847,"datagrid").data;
var view=$.data(_847,"datagrid").options.view;
var _849=$.data(_847,"datagrid").insertedRows;
view.insertRow.call(view,_847,_848.index,_848.row);
_849.push(_848.row);
$(_847).datagrid("getPager").pagination("refresh",{total:data.total});
};
function _84a(_84b,row){
var data=$.data(_84b,"datagrid").data;
var view=$.data(_84b,"datagrid").options.view;
var _84c=$.data(_84b,"datagrid").insertedRows;
view.insertRow.call(view,_84b,null,row);
_84c.push(row);
$(_84b).datagrid("getPager").pagination("refresh",{total:data.total});
};
function _84d(_84e,_84f){
var _850=$.data(_84e,"datagrid");
var opts=_850.options;
var row=opts.finder.getRow(_84e,_84f.index);
var _851=false;
_84f.row=_84f.row||{};
for(var _852 in _84f.row){
if(row[_852]!==_84f.row[_852]){
_851=true;
break;
}
}
if(_851){
if(_6ea(_850.insertedRows,row)==-1){
if(_6ea(_850.updatedRows,row)==-1){
_850.updatedRows.push(row);
}
}
opts.view.updateRow.call(opts.view,_84e,_84f.index,_84f.row);
}
};
function _853(_854){
var _855=$.data(_854,"datagrid");
var data=_855.data;
var rows=data.rows;
var _856=[];
for(var i=0;i<rows.length;i++){
_856.push($.extend({},rows[i]));
}
_855.originalRows=_856;
_855.updatedRows=[];
_855.insertedRows=[];
_855.deletedRows=[];
};
function _857(_858){
var data=$.data(_858,"datagrid").data;
var ok=true;
for(var i=0,len=data.rows.length;i<len;i++){
if(_817(_858,i)){
$(_858).datagrid("endEdit",i);
}else{
ok=false;
}
}
if(ok){
_853(_858);
}
};
function _859(_85a){
var _85b=$.data(_85a,"datagrid");
var opts=_85b.options;
var _85c=_85b.originalRows;
var _85d=_85b.insertedRows;
var _85e=_85b.deletedRows;
var _85f=_85b.selectedRows;
var _860=_85b.checkedRows;
var data=_85b.data;
function _861(a){
var ids=[];
for(var i=0;i<a.length;i++){
ids.push(a[i][opts.idField]);
}
return ids;
};
function _862(ids,_863){
for(var i=0;i<ids.length;i++){
var _864=_7da(_85a,ids[i]);
if(_864>=0){
(_863=="s"?_76e:_76b)(_85a,_864,true);
}
}
};
for(var i=0;i<data.rows.length;i++){
$(_85a).datagrid("cancelEdit",i);
}
var _865=_861(_85f);
var _866=_861(_860);
_85f.splice(0,_85f.length);
_860.splice(0,_860.length);
data.total+=_85e.length-_85d.length;
data.rows=_85c;
_785(_85a,data);
_862(_865,"s");
_862(_866,"c");
_853(_85a);
};
function _784(_867,_868,cb){
var opts=$.data(_867,"datagrid").options;
if(_868){
opts.queryParams=_868;
}
var _869=$.extend({},opts.queryParams);
if(opts.pagination){
$.extend(_869,{page:opts.pageNumber||1,rows:opts.pageSize});
}
if(opts.sortName){
$.extend(_869,{sort:opts.sortName,order:opts.sortOrder});
}
if(opts.onBeforeLoad.call(_867,_869)==false){
opts.view.setEmptyMsg(_867);
return;
}
$(_867).datagrid("loading");
var _86a=opts.loader.call(_867,_869,function(data){
$(_867).datagrid("loaded");
$(_867).datagrid("loadData",data);
if(cb){
cb();
}
},function(){
$(_867).datagrid("loaded");
opts.onLoadError.apply(_867,arguments);
});
if(_86a==false){
$(_867).datagrid("loaded");
opts.view.setEmptyMsg(_867);
}
};
function _86b(_86c,_86d){
var opts=$.data(_86c,"datagrid").options;
_86d.type=_86d.type||"body";
_86d.rowspan=_86d.rowspan||1;
_86d.colspan=_86d.colspan||1;
if(_86d.rowspan==1&&_86d.colspan==1){
return;
}
var tr=opts.finder.getTr(_86c,(_86d.index!=undefined?_86d.index:_86d.id),_86d.type);
if(!tr.length){
return;
}
var td=tr.find("td[field=\""+_86d.field+"\"]");
td.attr("rowspan",_86d.rowspan).attr("colspan",_86d.colspan);
td.addClass("datagrid-td-merged");
_86e(td.next(),_86d.colspan-1);
for(var i=1;i<_86d.rowspan;i++){
tr=tr.next();
if(!tr.length){
break;
}
_86e(tr.find("td[field=\""+_86d.field+"\"]"),_86d.colspan);
}
_7b4(_86c,td);
function _86e(td,_86f){
for(var i=0;i<_86f;i++){
td.hide();
td=td.next();
}
};
};
$.fn.datagrid=function(_870,_871){
if(typeof _870=="string"){
return $.fn.datagrid.methods[_870](this,_871);
}
_870=_870||{};
return this.each(function(){
var _872=$.data(this,"datagrid");
var opts;
if(_872){
opts=$.extend(_872.options,_870);
_872.options=opts;
}else{
opts=$.extend({},$.extend({},$.fn.datagrid.defaults,{queryParams:{}}),$.fn.datagrid.parseOptions(this),_870);
$(this).css("width","").css("height","");
var _873=_729(this,opts.rownumbers);
if(!opts.columns){
opts.columns=_873.columns;
}
if(!opts.frozenColumns){
opts.frozenColumns=_873.frozenColumns;
}
opts.columns=$.extend(true,[],opts.columns);
opts.frozenColumns=$.extend(true,[],opts.frozenColumns);
opts.view=$.extend({},opts.view);
$.data(this,"datagrid",{options:opts,panel:_873.panel,dc:_873.dc,ss:null,selectedRows:[],checkedRows:[],data:{total:0,rows:[]},originalRows:[],updatedRows:[],insertedRows:[],deletedRows:[]});
}
_732(this);
_749(this);
_6fe(this);
if(opts.data){
$(this).datagrid("loadData",opts.data);
}else{
var data=$.fn.datagrid.parseData(this);
if(data.total>0){
$(this).datagrid("loadData",data);
}else{
$(this).datagrid("autoSizeColumn");
}
}
_784(this);
});
};
function _874(_875){
var _876={};
$.map(_875,function(name){
_876[name]=_877(name);
});
return _876;
function _877(name){
function isA(_878){
return $.data($(_878)[0],name)!=undefined;
};
return {init:function(_879,_87a){
var _87b=$("<input type=\"text\" class=\"datagrid-editable-input\">").appendTo(_879);
if(_87b[name]&&name!="text"){
return _87b[name](_87a);
}else{
return _87b;
}
},destroy:function(_87c){
if(isA(_87c,name)){
$(_87c)[name]("destroy");
}
},getValue:function(_87d){
if(isA(_87d,name)){
var opts=$(_87d)[name]("options");
if(opts.multiple){
return $(_87d)[name]("getValues").join(opts.separator);
}else{
return $(_87d)[name]("getValue");
}
}else{
return $(_87d).val();
}
},setValue:function(_87e,_87f){
if(isA(_87e,name)){
var opts=$(_87e)[name]("options");
if(opts.multiple){
if(_87f){
$(_87e)[name]("setValues",_87f.split(opts.separator));
}else{
$(_87e)[name]("clear");
}
}else{
$(_87e)[name]("setValue",_87f);
}
}else{
$(_87e).val(_87f);
}
},resize:function(_880,_881){
if(isA(_880,name)){
$(_880)[name]("resize",_881);
}else{
$(_880)._size({width:_881,height:$.fn.datagrid.defaults.editorHeight});
}
}};
};
};
var _882=$.extend({},_874(["text","textbox","passwordbox","filebox","numberbox","numberspinner","combobox","combotree","combogrid","combotreegrid","datebox","datetimebox","timespinner","datetimespinner"]),{textarea:{init:function(_883,_884){
var _885=$("<textarea class=\"datagrid-editable-input\"></textarea>").appendTo(_883);
_885.css("vertical-align","middle")._outerHeight(_884.height);
return _885;
},getValue:function(_886){
return $(_886).val();
},setValue:function(_887,_888){
$(_887).val(_888);
},resize:function(_889,_88a){
$(_889)._outerWidth(_88a);
}},checkbox:{init:function(_88b,_88c){
var _88d=$("<input type=\"checkbox\">").appendTo(_88b);
_88d.val(_88c.on);
_88d.attr("offval",_88c.off);
return _88d;
},getValue:function(_88e){
if($(_88e).is(":checked")){
return $(_88e).val();
}else{
return $(_88e).attr("offval");
}
},setValue:function(_88f,_890){
var _891=false;
if($(_88f).val()==_890){
_891=true;
}
$(_88f)._propAttr("checked",_891);
}},validatebox:{init:function(_892,_893){
var _894=$("<input type=\"text\" class=\"datagrid-editable-input\">").appendTo(_892);
_894.validatebox(_893);
return _894;
},destroy:function(_895){
$(_895).validatebox("destroy");
},getValue:function(_896){
return $(_896).val();
},setValue:function(_897,_898){
$(_897).val(_898);
},resize:function(_899,_89a){
$(_899)._outerWidth(_89a)._outerHeight($.fn.datagrid.defaults.editorHeight);
}}});
$.fn.datagrid.methods={options:function(jq){
var _89b=$.data(jq[0],"datagrid").options;
var _89c=$.data(jq[0],"datagrid").panel.panel("options");
var opts=$.extend(_89b,{width:_89c.width,height:_89c.height,closed:_89c.closed,collapsed:_89c.collapsed,minimized:_89c.minimized,maximized:_89c.maximized});
return opts;
},setSelectionState:function(jq){
return jq.each(function(){
_7d2(this);
});
},createStyleSheet:function(jq){
return _6ef(jq[0]);
},getPanel:function(jq){
return $.data(jq[0],"datagrid").panel;
},getPager:function(jq){
return $.data(jq[0],"datagrid").panel.children("div.datagrid-pager");
},getColumnFields:function(jq,_89d){
return _747(jq[0],_89d);
},getColumnOption:function(jq,_89e){
return _748(jq[0],_89e);
},resize:function(jq,_89f){
return jq.each(function(){
_6fe(this,_89f);
});
},load:function(jq,_8a0){
return jq.each(function(){
var opts=$(this).datagrid("options");
if(typeof _8a0=="string"){
opts.url=_8a0;
_8a0=null;
}
opts.pageNumber=1;
var _8a1=$(this).datagrid("getPager");
_8a1.pagination("refresh",{pageNumber:1});
_784(this,_8a0);
});
},reload:function(jq,_8a2){
return jq.each(function(){
var opts=$(this).datagrid("options");
if(typeof _8a2=="string"){
opts.url=_8a2;
_8a2=null;
}
_784(this,_8a2);
});
},reloadFooter:function(jq,_8a3){
return jq.each(function(){
var opts=$.data(this,"datagrid").options;
var dc=$.data(this,"datagrid").dc;
if(_8a3){
$.data(this,"datagrid").footer=_8a3;
}
if(opts.showFooter){
opts.view.renderFooter.call(opts.view,this,dc.footer2,false);
opts.view.renderFooter.call(opts.view,this,dc.footer1,true);
if(opts.view.onAfterRender){
opts.view.onAfterRender.call(opts.view,this);
}
$(this).datagrid("fixRowHeight");
}
});
},loading:function(jq){
return jq.each(function(){
var opts=$.data(this,"datagrid").options;
$(this).datagrid("getPager").pagination("loading");
if(opts.loadMsg){
var _8a4=$(this).datagrid("getPanel");
if(!_8a4.children("div.datagrid-mask").length){
$("<div class=\"datagrid-mask\" style=\"display:block\"></div>").appendTo(_8a4);
var msg=$("<div class=\"datagrid-mask-msg\" style=\"display:block;left:50%\"></div>").html(opts.loadMsg).appendTo(_8a4);
msg._outerHeight(40);
msg.css({marginLeft:(-msg.outerWidth()/2),lineHeight:(msg.height()+"px")});
}
}
});
},loaded:function(jq){
return jq.each(function(){
$(this).datagrid("getPager").pagination("loaded");
var _8a5=$(this).datagrid("getPanel");
_8a5.children("div.datagrid-mask-msg").remove();
_8a5.children("div.datagrid-mask").remove();
});
},fitColumns:function(jq){
return jq.each(function(){
_791(this);
});
},fixColumnSize:function(jq,_8a6){
return jq.each(function(){
_7af(this,_8a6);
});
},fixRowHeight:function(jq,_8a7){
return jq.each(function(){
_714(this,_8a7);
});
},freezeRow:function(jq,_8a8){
return jq.each(function(){
_722(this,_8a8);
});
},autoSizeColumn:function(jq,_8a9){
return jq.each(function(){
_7a3(this,_8a9);
});
},loadData:function(jq,data){
return jq.each(function(){
_785(this,data);
_853(this);
});
},getData:function(jq){
return $.data(jq[0],"datagrid").data;
},getRows:function(jq){
return $.data(jq[0],"datagrid").data.rows;
},getFooterRows:function(jq){
return $.data(jq[0],"datagrid").footer;
},getRowIndex:function(jq,id){
return _7da(jq[0],id);
},getChecked:function(jq){
return _7e0(jq[0]);
},getSelected:function(jq){
var rows=_7dd(jq[0]);
return rows.length>0?rows[0]:null;
},getSelections:function(jq){
return _7dd(jq[0]);
},clearSelections:function(jq){
return jq.each(function(){
var _8aa=$.data(this,"datagrid");
var _8ab=_8aa.selectedRows;
var _8ac=_8aa.checkedRows;
_8ab.splice(0,_8ab.length);
_7f3(this);
if(_8aa.options.checkOnSelect){
_8ac.splice(0,_8ac.length);
}
});
},clearChecked:function(jq){
return jq.each(function(){
var _8ad=$.data(this,"datagrid");
var _8ae=_8ad.selectedRows;
var _8af=_8ad.checkedRows;
_8af.splice(0,_8af.length);
_75a(this);
if(_8ad.options.selectOnCheck){
_8ae.splice(0,_8ae.length);
}
});
},scrollTo:function(jq,_8b0){
return jq.each(function(){
_7e3(this,_8b0);
});
},highlightRow:function(jq,_8b1){
return jq.each(function(){
_767(this,_8b1);
_7e3(this,_8b1);
});
},selectAll:function(jq){
return jq.each(function(){
_7f8(this);
});
},unselectAll:function(jq){
return jq.each(function(){
_7f3(this);
});
},selectRow:function(jq,_8b2){
return jq.each(function(){
_76e(this,_8b2);
});
},selectRecord:function(jq,id){
return jq.each(function(){
var opts=$.data(this,"datagrid").options;
if(opts.idField){
var _8b3=_7da(this,id);
if(_8b3>=0){
$(this).datagrid("selectRow",_8b3);
}
}
});
},unselectRow:function(jq,_8b4){
return jq.each(function(){
_76f(this,_8b4);
});
},checkRow:function(jq,_8b5){
return jq.each(function(){
_76b(this,_8b5);
});
},uncheckRow:function(jq,_8b6){
return jq.each(function(){
_76c(this,_8b6);
});
},checkAll:function(jq){
return jq.each(function(){
_759(this);
});
},uncheckAll:function(jq){
return jq.each(function(){
_75a(this);
});
},beginEdit:function(jq,_8b7){
return jq.each(function(){
_812(this,_8b7);
});
},endEdit:function(jq,_8b8){
return jq.each(function(){
_818(this,_8b8,false);
});
},cancelEdit:function(jq,_8b9){
return jq.each(function(){
_818(this,_8b9,true);
});
},getEditors:function(jq,_8ba){
return _825(jq[0],_8ba);
},getEditor:function(jq,_8bb){
return _829(jq[0],_8bb);
},refreshRow:function(jq,_8bc){
return jq.each(function(){
var opts=$.data(this,"datagrid").options;
opts.view.refreshRow.call(opts.view,this,_8bc);
});
},validateRow:function(jq,_8bd){
return _817(jq[0],_8bd);
},updateRow:function(jq,_8be){
return jq.each(function(){
_84d(this,_8be);
});
},appendRow:function(jq,row){
return jq.each(function(){
_84a(this,row);
});
},insertRow:function(jq,_8bf){
return jq.each(function(){
_846(this,_8bf);
});
},deleteRow:function(jq,_8c0){
return jq.each(function(){
_840(this,_8c0);
});
},getChanges:function(jq,_8c1){
return _83a(jq[0],_8c1);
},acceptChanges:function(jq){
return jq.each(function(){
_857(this);
});
},rejectChanges:function(jq){
return jq.each(function(){
_859(this);
});
},mergeCells:function(jq,_8c2){
return jq.each(function(){
_86b(this,_8c2);
});
},showColumn:function(jq,_8c3){
return jq.each(function(){
var col=$(this).datagrid("getColumnOption",_8c3);
if(col.hidden){
col.hidden=false;
$(this).datagrid("getPanel").find("td[field=\""+_8c3+"\"]").show();
_786(this,_8c3,1);
$(this).datagrid("fitColumns");
}
});
},hideColumn:function(jq,_8c4){
return jq.each(function(){
var col=$(this).datagrid("getColumnOption",_8c4);
if(!col.hidden){
col.hidden=true;
$(this).datagrid("getPanel").find("td[field=\""+_8c4+"\"]").hide();
_786(this,_8c4,-1);
$(this).datagrid("fitColumns");
}
});
},sort:function(jq,_8c5){
return jq.each(function(){
_75b(this,_8c5);
});
},gotoPage:function(jq,_8c6){
return jq.each(function(){
var _8c7=this;
var page,cb;
if(typeof _8c6=="object"){
page=_8c6.page;
cb=_8c6.callback;
}else{
page=_8c6;
}
$(_8c7).datagrid("options").pageNumber=page;
$(_8c7).datagrid("getPager").pagination("refresh",{pageNumber:page});
_784(_8c7,null,function(){
if(cb){
cb.call(_8c7,page);
}
});
});
}};
$.fn.datagrid.parseOptions=function(_8c8){
var t=$(_8c8);
return $.extend({},$.fn.panel.parseOptions(_8c8),$.parser.parseOptions(_8c8,["url","toolbar","idField","sortName","sortOrder","pagePosition","resizeHandle",{sharedStyleSheet:"boolean",fitColumns:"boolean",autoRowHeight:"boolean",striped:"boolean",nowrap:"boolean"},{rownumbers:"boolean",singleSelect:"boolean",ctrlSelect:"boolean",checkOnSelect:"boolean",selectOnCheck:"boolean"},{pagination:"boolean",pageSize:"number",pageNumber:"number"},{multiSort:"boolean",remoteSort:"boolean",showHeader:"boolean",showFooter:"boolean"},{scrollbarSize:"number",scrollOnSelect:"boolean"}]),{pageList:(t.attr("pageList")?eval(t.attr("pageList")):undefined),loadMsg:(t.attr("loadMsg")!=undefined?t.attr("loadMsg"):undefined),rowStyler:(t.attr("rowStyler")?eval(t.attr("rowStyler")):undefined)});
};
$.fn.datagrid.parseData=function(_8c9){
var t=$(_8c9);
var data={total:0,rows:[]};
var _8ca=t.datagrid("getColumnFields",true).concat(t.datagrid("getColumnFields",false));
t.find("tbody tr").each(function(){
data.total++;
var row={};
$.extend(row,$.parser.parseOptions(this,["iconCls","state"]));
for(var i=0;i<_8ca.length;i++){
row[_8ca[i]]=$(this).find("td:eq("+i+")").html();
}
data.rows.push(row);
});
return data;
};
var _8cb={render:function(_8cc,_8cd,_8ce){
var rows=$(_8cc).datagrid("getRows");
$(_8cd).empty().html(this.renderTable(_8cc,0,rows,_8ce));
},renderFooter:function(_8cf,_8d0,_8d1){
var opts=$.data(_8cf,"datagrid").options;
var rows=$.data(_8cf,"datagrid").footer||[];
var _8d2=$(_8cf).datagrid("getColumnFields",_8d1);
var _8d3=["<table class=\"datagrid-ftable\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\"><tbody>"];
for(var i=0;i<rows.length;i++){
_8d3.push("<tr class=\"datagrid-row\" datagrid-row-index=\""+i+"\">");
_8d3.push(this.renderRow.call(this,_8cf,_8d2,_8d1,i,rows[i]));
_8d3.push("</tr>");
}
_8d3.push("</tbody></table>");
$(_8d0).html(_8d3.join(""));
},renderTable:function(_8d4,_8d5,rows,_8d6){
var _8d7=$.data(_8d4,"datagrid");
var opts=_8d7.options;
if(_8d6){
if(!(opts.rownumbers||(opts.frozenColumns&&opts.frozenColumns.length))){
return "";
}
}
var _8d8=$(_8d4).datagrid("getColumnFields",_8d6);
var _8d9=["<table class=\"datagrid-btable\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\"><tbody>"];
for(var i=0;i<rows.length;i++){
var row=rows[i];
var css=opts.rowStyler?opts.rowStyler.call(_8d4,_8d5,row):"";
var cs=this.getStyleValue(css);
var cls="class=\"datagrid-row "+(_8d5%2&&opts.striped?"datagrid-row-alt ":" ")+cs.c+"\"";
var _8da=cs.s?"style=\""+cs.s+"\"":"";
var _8db=_8d7.rowIdPrefix+"-"+(_8d6?1:2)+"-"+_8d5;
_8d9.push("<tr id=\""+_8db+"\" datagrid-row-index=\""+_8d5+"\" "+cls+" "+_8da+">");
_8d9.push(this.renderRow.call(this,_8d4,_8d8,_8d6,_8d5,row));
_8d9.push("</tr>");
_8d5++;
}
_8d9.push("</tbody></table>");
return _8d9.join("");
},renderRow:function(_8dc,_8dd,_8de,_8df,_8e0){
var opts=$.data(_8dc,"datagrid").options;
var cc=[];
if(_8de&&opts.rownumbers){
var _8e1=_8df+1;
if(opts.pagination){
_8e1+=(opts.pageNumber-1)*opts.pageSize;
}
cc.push("<td class=\"datagrid-td-rownumber\"><div class=\"datagrid-cell-rownumber\">"+_8e1+"</div></td>");
}
for(var i=0;i<_8dd.length;i++){
var _8e2=_8dd[i];
var col=$(_8dc).datagrid("getColumnOption",_8e2);
if(col){
var _8e3=_8e0[_8e2];
var css=col.styler?(col.styler.call(_8dc,_8e3,_8e0,_8df)||""):"";
var cs=this.getStyleValue(css);
var cls=cs.c?"class=\""+cs.c+"\"":"";
var _8e4=col.hidden?"style=\"display:none;"+cs.s+"\"":(cs.s?"style=\""+cs.s+"\"":"");
cc.push("<td field=\""+_8e2+"\" "+cls+" "+_8e4+">");
var _8e4="";
if(!col.checkbox){
if(col.align){
_8e4+="text-align:"+col.align+";";
}
if(!opts.nowrap){
_8e4+="white-space:normal;height:auto;";
}else{
if(opts.autoRowHeight){
_8e4+="height:auto;";
}
}
}
cc.push("<div style=\""+_8e4+"\" ");
cc.push(col.checkbox?"class=\"datagrid-cell-check\"":"class=\"datagrid-cell "+col.cellClass+"\"");
cc.push(">");
if(col.checkbox){
cc.push("<input type=\"checkbox\" "+(_8e0.checked?"checked=\"checked\"":""));
cc.push(" name=\""+_8e2+"\" value=\""+(_8e3!=undefined?_8e3:"")+"\">");
}else{
if(col.formatter){
cc.push(col.formatter(_8e3,_8e0,_8df));
}else{
cc.push(_8e3);
}
}
cc.push("</div>");
cc.push("</td>");
}
}
return cc.join("");
},getStyleValue:function(css){
var _8e5="";
var _8e6="";
if(typeof css=="string"){
_8e6=css;
}else{
if(css){
_8e5=css["class"]||"";
_8e6=css["style"]||"";
}
}
return {c:_8e5,s:_8e6};
},refreshRow:function(_8e7,_8e8){
this.updateRow.call(this,_8e7,_8e8,{});
},updateRow:function(_8e9,_8ea,row){
var opts=$.data(_8e9,"datagrid").options;
var _8eb=opts.finder.getRow(_8e9,_8ea);
$.extend(_8eb,row);
var cs=_8ec.call(this,_8ea);
var _8ed=cs.s;
var cls="datagrid-row "+(_8ea%2&&opts.striped?"datagrid-row-alt ":" ")+cs.c;
function _8ec(_8ee){
var css=opts.rowStyler?opts.rowStyler.call(_8e9,_8ee,_8eb):"";
return this.getStyleValue(css);
};
function _8ef(_8f0){
var tr=opts.finder.getTr(_8e9,_8ea,"body",(_8f0?1:2));
if(!tr.length){
return;
}
var _8f1=$(_8e9).datagrid("getColumnFields",_8f0);
var _8f2=tr.find("div.datagrid-cell-check input[type=checkbox]").is(":checked");
tr.html(this.renderRow.call(this,_8e9,_8f1,_8f0,_8ea,_8eb));
var _8f3=(tr.hasClass("datagrid-row-checked")?" datagrid-row-checked":"")+(tr.hasClass("datagrid-row-selected")?" datagrid-row-selected":"");
tr.attr("style",_8ed).attr("class",cls+_8f3);
if(_8f2){
tr.find("div.datagrid-cell-check input[type=checkbox]")._propAttr("checked",true);
}
};
_8ef.call(this,true);
_8ef.call(this,false);
$(_8e9).datagrid("fixRowHeight",_8ea);
},insertRow:function(_8f4,_8f5,row){
var _8f6=$.data(_8f4,"datagrid");
var opts=_8f6.options;
var dc=_8f6.dc;
var data=_8f6.data;
if(_8f5==undefined||_8f5==null){
_8f5=data.rows.length;
}
if(_8f5>data.rows.length){
_8f5=data.rows.length;
}
function _8f7(_8f8){
var _8f9=_8f8?1:2;
for(var i=data.rows.length-1;i>=_8f5;i--){
var tr=opts.finder.getTr(_8f4,i,"body",_8f9);
tr.attr("datagrid-row-index",i+1);
tr.attr("id",_8f6.rowIdPrefix+"-"+_8f9+"-"+(i+1));
if(_8f8&&opts.rownumbers){
var _8fa=i+2;
if(opts.pagination){
_8fa+=(opts.pageNumber-1)*opts.pageSize;
}
tr.find("div.datagrid-cell-rownumber").html(_8fa);
}
if(opts.striped){
tr.removeClass("datagrid-row-alt").addClass((i+1)%2?"datagrid-row-alt":"");
}
}
};
function _8fb(_8fc){
var _8fd=_8fc?1:2;
var _8fe=$(_8f4).datagrid("getColumnFields",_8fc);
var _8ff=_8f6.rowIdPrefix+"-"+_8fd+"-"+_8f5;
var tr="<tr id=\""+_8ff+"\" class=\"datagrid-row\" datagrid-row-index=\""+_8f5+"\"></tr>";
if(_8f5>=data.rows.length){
if(data.rows.length){
opts.finder.getTr(_8f4,"","last",_8fd).after(tr);
}else{
var cc=_8fc?dc.body1:dc.body2;
cc.html("<table class=\"datagrid-btable\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\"><tbody>"+tr+"</tbody></table>");
}
}else{
opts.finder.getTr(_8f4,_8f5+1,"body",_8fd).before(tr);
}
};
_8f7.call(this,true);
_8f7.call(this,false);
_8fb.call(this,true);
_8fb.call(this,false);
data.total+=1;
data.rows.splice(_8f5,0,row);
this.setEmptyMsg(_8f4);
this.refreshRow.call(this,_8f4,_8f5);
},deleteRow:function(_900,_901){
var _902=$.data(_900,"datagrid");
var opts=_902.options;
var data=_902.data;
function _903(_904){
var _905=_904?1:2;
for(var i=_901+1;i<data.rows.length;i++){
var tr=opts.finder.getTr(_900,i,"body",_905);
tr.attr("datagrid-row-index",i-1);
tr.attr("id",_902.rowIdPrefix+"-"+_905+"-"+(i-1));
if(_904&&opts.rownumbers){
var _906=i;
if(opts.pagination){
_906+=(opts.pageNumber-1)*opts.pageSize;
}
tr.find("div.datagrid-cell-rownumber").html(_906);
}
if(opts.striped){
tr.removeClass("datagrid-row-alt").addClass((i-1)%2?"datagrid-row-alt":"");
}
}
};
opts.finder.getTr(_900,_901).remove();
_903.call(this,true);
_903.call(this,false);
data.total-=1;
data.rows.splice(_901,1);
this.setEmptyMsg(_900);
},onBeforeRender:function(_907,rows){
},onAfterRender:function(_908){
var _909=$.data(_908,"datagrid");
var opts=_909.options;
if(opts.showFooter){
var _90a=$(_908).datagrid("getPanel").find("div.datagrid-footer");
_90a.find("div.datagrid-cell-rownumber,div.datagrid-cell-check").css("visibility","hidden");
}
this.setEmptyMsg(_908);
},setEmptyMsg:function(_90b){
var _90c=$.data(_90b,"datagrid");
var opts=_90c.options;
var _90d=opts.finder.getRows(_90b).length==0;
if(_90d){
this.renderEmptyRow(_90b);
}
if(opts.emptyMsg){
_90c.dc.view.children(".datagrid-empty").remove();
if(_90d){
var h=_90c.dc.header2.parent().outerHeight();
var d=$("<div class=\"datagrid-empty\"></div>").appendTo(_90c.dc.view);
d.html(opts.emptyMsg).css("top",h+"px");
}
}
},renderEmptyRow:function(_90e){
var cols=$.map($(_90e).datagrid("getColumnFields"),function(_90f){
return $(_90e).datagrid("getColumnOption",_90f);
});
$.map(cols,function(col){
col.formatter1=col.formatter;
col.styler1=col.styler;
col.formatter=col.styler=undefined;
});
var _910=$.data(_90e,"datagrid").dc.body2;
_910.html(this.renderTable(_90e,0,[{}],false));
_910.find("tbody *").css({height:1,borderColor:"transparent",background:"transparent"});
var tr=_910.find(".datagrid-row");
tr.removeClass("datagrid-row").removeAttr("datagrid-row-index");
tr.find(".datagrid-cell,.datagrid-cell-check").empty();
$.map(cols,function(col){
col.formatter=col.formatter1;
col.styler=col.styler1;
col.formatter1=col.styler1=undefined;
});
}};
$.fn.datagrid.defaults=$.extend({},$.fn.panel.defaults,{sharedStyleSheet:false,frozenColumns:undefined,columns:undefined,fitColumns:false,resizeHandle:"right",resizeEdge:5,autoRowHeight:true,toolbar:null,striped:false,method:"post",nowrap:true,idField:null,url:null,data:null,loadMsg:"Processing, please wait ...",emptyMsg:"",rownumbers:false,singleSelect:false,ctrlSelect:false,selectOnCheck:true,checkOnSelect:true,pagination:false,pagePosition:"bottom",pageNumber:1,pageSize:10,pageList:[10,20,30,40,50],queryParams:{},sortName:null,sortOrder:"asc",multiSort:false,remoteSort:true,showHeader:true,showFooter:false,scrollOnSelect:true,scrollbarSize:18,rownumberWidth:30,editorHeight:31,headerEvents:{mouseover:_753(true),mouseout:_753(false),click:_757,dblclick:_75c,contextmenu:_75f},rowEvents:{mouseover:_761(true),mouseout:_761(false),click:_768,dblclick:_772,contextmenu:_776},rowStyler:function(_911,_912){
},loader:function(_913,_914,_915){
var opts=$(this).datagrid("options");
if(!opts.url){
return false;
}
$.ajax({type:opts.method,url:opts.url,data:_913,dataType:"json",success:function(data){
_914(data);
},error:function(){
_915.apply(this,arguments);
}});
},loadFilter:function(data){
return data;
},editors:_882,finder:{getTr:function(_916,_917,type,_918){
type=type||"body";
_918=_918||0;
var _919=$.data(_916,"datagrid");
var dc=_919.dc;
var opts=_919.options;
if(_918==0){
var tr1=opts.finder.getTr(_916,_917,type,1);
var tr2=opts.finder.getTr(_916,_917,type,2);
return tr1.add(tr2);
}else{
if(type=="body"){
var tr=$("#"+_919.rowIdPrefix+"-"+_918+"-"+_917);
if(!tr.length){
tr=(_918==1?dc.body1:dc.body2).find(">table>tbody>tr[datagrid-row-index="+_917+"]");
}
return tr;
}else{
if(type=="footer"){
return (_918==1?dc.footer1:dc.footer2).find(">table>tbody>tr[datagrid-row-index="+_917+"]");
}else{
if(type=="selected"){
return (_918==1?dc.body1:dc.body2).find(">table>tbody>tr.datagrid-row-selected");
}else{
if(type=="highlight"){
return (_918==1?dc.body1:dc.body2).find(">table>tbody>tr.datagrid-row-over");
}else{
if(type=="checked"){
return (_918==1?dc.body1:dc.body2).find(">table>tbody>tr.datagrid-row-checked");
}else{
if(type=="editing"){
return (_918==1?dc.body1:dc.body2).find(">table>tbody>tr.datagrid-row-editing");
}else{
if(type=="last"){
return (_918==1?dc.body1:dc.body2).find(">table>tbody>tr[datagrid-row-index]:last");
}else{
if(type=="allbody"){
return (_918==1?dc.body1:dc.body2).find(">table>tbody>tr[datagrid-row-index]");
}else{
if(type=="allfooter"){
return (_918==1?dc.footer1:dc.footer2).find(">table>tbody>tr[datagrid-row-index]");
}
}
}
}
}
}
}
}
}
}
},getRow:function(_91a,p){
var _91b=(typeof p=="object")?p.attr("datagrid-row-index"):p;
return $.data(_91a,"datagrid").data.rows[parseInt(_91b)];
},getRows:function(_91c){
return $(_91c).datagrid("getRows");
}},view:_8cb,onBeforeLoad:function(_91d){
},onLoadSuccess:function(){
},onLoadError:function(){
},onClickRow:function(_91e,_91f){
},onDblClickRow:function(_920,_921){
},onClickCell:function(_922,_923,_924){
},onDblClickCell:function(_925,_926,_927){
},onBeforeSortColumn:function(sort,_928){
},onSortColumn:function(sort,_929){
},onResizeColumn:function(_92a,_92b){
},onBeforeSelect:function(_92c,_92d){
},onSelect:function(_92e,_92f){
},onBeforeUnselect:function(_930,_931){
},onUnselect:function(_932,_933){
},onSelectAll:function(rows){
},onUnselectAll:function(rows){
},onBeforeCheck:function(_934,_935){
},onCheck:function(_936,_937){
},onBeforeUncheck:function(_938,_939){
},onUncheck:function(_93a,_93b){
},onCheckAll:function(rows){
},onUncheckAll:function(rows){
},onBeforeEdit:function(_93c,_93d){
},onBeginEdit:function(_93e,_93f){
},onEndEdit:function(_940,_941,_942){
},onAfterEdit:function(_943,_944,_945){
},onCancelEdit:function(_946,_947){
},onHeaderContextMenu:function(e,_948){
},onRowContextMenu:function(e,_949,_94a){
}});
})(jQuery);
(function($){
var _94b;
$(document).unbind(".propertygrid").bind("mousedown.propertygrid",function(e){
var p=$(e.target).closest("div.datagrid-view,div.combo-panel");
if(p.length){
return;
}
_94c(_94b);
_94b=undefined;
});
function _94d(_94e){
var _94f=$.data(_94e,"propertygrid");
var opts=$.data(_94e,"propertygrid").options;
$(_94e).datagrid($.extend({},opts,{cls:"propertygrid",view:(opts.showGroup?opts.groupView:opts.view),onBeforeEdit:function(_950,row){
if(opts.onBeforeEdit.call(_94e,_950,row)==false){
return false;
}
var dg=$(this);
var row=dg.datagrid("getRows")[_950];
var col=dg.datagrid("getColumnOption","value");
col.editor=row.editor;
},onClickCell:function(_951,_952,_953){
if(_94b!=this){
_94c(_94b);
_94b=this;
}
if(opts.editIndex!=_951){
_94c(_94b);
$(this).datagrid("beginEdit",_951);
var ed=$(this).datagrid("getEditor",{index:_951,field:_952});
if(!ed){
ed=$(this).datagrid("getEditor",{index:_951,field:"value"});
}
if(ed){
var t=$(ed.target);
var _954=t.data("textbox")?t.textbox("textbox"):t;
_954.focus();
opts.editIndex=_951;
}
}
opts.onClickCell.call(_94e,_951,_952,_953);
},loadFilter:function(data){
_94c(this);
return opts.loadFilter.call(this,data);
}}));
};
function _94c(_955){
var t=$(_955);
if(!t.length){
return;
}
var opts=$.data(_955,"propertygrid").options;
opts.finder.getTr(_955,null,"editing").each(function(){
var _956=parseInt($(this).attr("datagrid-row-index"));
if(t.datagrid("validateRow",_956)){
t.datagrid("endEdit",_956);
}else{
t.datagrid("cancelEdit",_956);
}
});
opts.editIndex=undefined;
};
$.fn.propertygrid=function(_957,_958){
if(typeof _957=="string"){
var _959=$.fn.propertygrid.methods[_957];
if(_959){
return _959(this,_958);
}else{
return this.datagrid(_957,_958);
}
}
_957=_957||{};
return this.each(function(){
var _95a=$.data(this,"propertygrid");
if(_95a){
$.extend(_95a.options,_957);
}else{
var opts=$.extend({},$.fn.propertygrid.defaults,$.fn.propertygrid.parseOptions(this),_957);
opts.frozenColumns=$.extend(true,[],opts.frozenColumns);
opts.columns=$.extend(true,[],opts.columns);
$.data(this,"propertygrid",{options:opts});
}
_94d(this);
});
};
$.fn.propertygrid.methods={options:function(jq){
return $.data(jq[0],"propertygrid").options;
}};
$.fn.propertygrid.parseOptions=function(_95b){
return $.extend({},$.fn.datagrid.parseOptions(_95b),$.parser.parseOptions(_95b,[{showGroup:"boolean"}]));
};
var _95c=$.extend({},$.fn.datagrid.defaults.view,{render:function(_95d,_95e,_95f){
var _960=[];
var _961=this.groups;
for(var i=0;i<_961.length;i++){
_960.push(this.renderGroup.call(this,_95d,i,_961[i],_95f));
}
$(_95e).html(_960.join(""));
},renderGroup:function(_962,_963,_964,_965){
var _966=$.data(_962,"datagrid");
var opts=_966.options;
var _967=$(_962).datagrid("getColumnFields",_965);
var _968=opts.frozenColumns&&opts.frozenColumns.length;
if(_965){
if(!(opts.rownumbers||_968)){
return "";
}
}
var _969=[];
var css=opts.groupStyler.call(_962,_964.value,_964.rows);
var cs=_96a(css,"datagrid-group");
_969.push("<div group-index="+_963+" "+cs+">");
if((_965&&(opts.rownumbers||opts.frozenColumns.length))||(!_965&&!(opts.rownumbers||opts.frozenColumns.length))){
_969.push("<span class=\"datagrid-group-expander\">");
_969.push("<span class=\"datagrid-row-expander datagrid-row-collapse\">&nbsp;</span>");
_969.push("</span>");
}
if((_965&&_968)||(!_965)){
_969.push("<span class=\"datagrid-group-title\">");
_969.push(opts.groupFormatter.call(_962,_964.value,_964.rows));
_969.push("</span>");
}
_969.push("</div>");
_969.push("<table class=\"datagrid-btable\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\"><tbody>");
var _96b=_964.startIndex;
for(var j=0;j<_964.rows.length;j++){
var css=opts.rowStyler?opts.rowStyler.call(_962,_96b,_964.rows[j]):"";
var _96c="";
var _96d="";
if(typeof css=="string"){
_96d=css;
}else{
if(css){
_96c=css["class"]||"";
_96d=css["style"]||"";
}
}
var cls="class=\"datagrid-row "+(_96b%2&&opts.striped?"datagrid-row-alt ":" ")+_96c+"\"";
var _96e=_96d?"style=\""+_96d+"\"":"";
var _96f=_966.rowIdPrefix+"-"+(_965?1:2)+"-"+_96b;
_969.push("<tr id=\""+_96f+"\" datagrid-row-index=\""+_96b+"\" "+cls+" "+_96e+">");
_969.push(this.renderRow.call(this,_962,_967,_965,_96b,_964.rows[j]));
_969.push("</tr>");
_96b++;
}
_969.push("</tbody></table>");
return _969.join("");
function _96a(css,cls){
var _970="";
var _971="";
if(typeof css=="string"){
_971=css;
}else{
if(css){
_970=css["class"]||"";
_971=css["style"]||"";
}
}
return "class=\""+cls+(_970?" "+_970:"")+"\" "+"style=\""+_971+"\"";
};
},bindEvents:function(_972){
var _973=$.data(_972,"datagrid");
var dc=_973.dc;
var body=dc.body1.add(dc.body2);
var _974=($.data(body[0],"events")||$._data(body[0],"events")).click[0].handler;
body.unbind("click").bind("click",function(e){
var tt=$(e.target);
var _975=tt.closest("span.datagrid-row-expander");
if(_975.length){
var _976=_975.closest("div.datagrid-group").attr("group-index");
if(_975.hasClass("datagrid-row-collapse")){
$(_972).datagrid("collapseGroup",_976);
}else{
$(_972).datagrid("expandGroup",_976);
}
}else{
_974(e);
}
e.stopPropagation();
});
},onBeforeRender:function(_977,rows){
var _978=$.data(_977,"datagrid");
var opts=_978.options;
_979();
var _97a=[];
for(var i=0;i<rows.length;i++){
var row=rows[i];
var _97b=_97c(row[opts.groupField]);
if(!_97b){
_97b={value:row[opts.groupField],rows:[row]};
_97a.push(_97b);
}else{
_97b.rows.push(row);
}
}
var _97d=0;
var _97e=[];
for(var i=0;i<_97a.length;i++){
var _97b=_97a[i];
_97b.startIndex=_97d;
_97d+=_97b.rows.length;
_97e=_97e.concat(_97b.rows);
}
_978.data.rows=_97e;
this.groups=_97a;
var that=this;
setTimeout(function(){
that.bindEvents(_977);
},0);
function _97c(_97f){
for(var i=0;i<_97a.length;i++){
var _980=_97a[i];
if(_980.value==_97f){
return _980;
}
}
return null;
};
function _979(){
if(!$("#datagrid-group-style").length){
$("head").append("<style id=\"datagrid-group-style\">"+".datagrid-group{height:"+opts.groupHeight+"px;overflow:hidden;font-weight:bold;border-bottom:1px solid #ccc;white-space:nowrap;word-break:normal;}"+".datagrid-group-title,.datagrid-group-expander{display:inline-block;vertical-align:bottom;height:100%;line-height:"+opts.groupHeight+"px;padding:0 4px;}"+".datagrid-group-title{position:relative;}"+".datagrid-group-expander{width:"+opts.expanderWidth+"px;text-align:center;padding:0}"+".datagrid-row-expander{margin:"+Math.floor((opts.groupHeight-16)/2)+"px 0;display:inline-block;width:16px;height:16px;cursor:pointer}"+"</style>");
}
};
},onAfterRender:function(_981){
$.fn.datagrid.defaults.view.onAfterRender.call(this,_981);
var view=this;
var _982=$.data(_981,"datagrid");
var opts=_982.options;
if(!_982.onResizeColumn){
_982.onResizeColumn=opts.onResizeColumn;
}
if(!_982.onResize){
_982.onResize=opts.onResize;
}
opts.onResizeColumn=function(_983,_984){
view.resizeGroup(_981);
_982.onResizeColumn.call(_981,_983,_984);
};
opts.onResize=function(_985,_986){
view.resizeGroup(_981);
_982.onResize.call($(_981).datagrid("getPanel")[0],_985,_986);
};
view.resizeGroup(_981);
}});
$.extend($.fn.datagrid.methods,{groups:function(jq){
return jq.datagrid("options").view.groups;
},expandGroup:function(jq,_987){
return jq.each(function(){
var opts=$(this).datagrid("options");
var view=$.data(this,"datagrid").dc.view;
var _988=view.find(_987!=undefined?"div.datagrid-group[group-index=\""+_987+"\"]":"div.datagrid-group");
var _989=_988.find("span.datagrid-row-expander");
if(_989.hasClass("datagrid-row-expand")){
_989.removeClass("datagrid-row-expand").addClass("datagrid-row-collapse");
_988.next("table").show();
}
$(this).datagrid("fixRowHeight");
if(opts.onExpandGroup){
opts.onExpandGroup.call(this,_987);
}
});
},collapseGroup:function(jq,_98a){
return jq.each(function(){
var opts=$(this).datagrid("options");
var view=$.data(this,"datagrid").dc.view;
var _98b=view.find(_98a!=undefined?"div.datagrid-group[group-index=\""+_98a+"\"]":"div.datagrid-group");
var _98c=_98b.find("span.datagrid-row-expander");
if(_98c.hasClass("datagrid-row-collapse")){
_98c.removeClass("datagrid-row-collapse").addClass("datagrid-row-expand");
_98b.next("table").hide();
}
$(this).datagrid("fixRowHeight");
if(opts.onCollapseGroup){
opts.onCollapseGroup.call(this,_98a);
}
});
},scrollToGroup:function(jq,_98d){
return jq.each(function(){
var _98e=$.data(this,"datagrid");
var dc=_98e.dc;
var grow=dc.body2.children("div.datagrid-group[group-index=\""+_98d+"\"]");
if(grow.length){
var _98f=grow.outerHeight();
var _990=dc.view2.children("div.datagrid-header")._outerHeight();
var _991=dc.body2.outerHeight(true)-dc.body2.outerHeight();
var top=grow.position().top-_990-_991;
if(top<0){
dc.body2.scrollTop(dc.body2.scrollTop()+top);
}else{
if(top+_98f>dc.body2.height()-18){
dc.body2.scrollTop(dc.body2.scrollTop()+top+_98f-dc.body2.height()+18);
}
}
}
});
}});
$.extend(_95c,{refreshGroupTitle:function(_992,_993){
var _994=$.data(_992,"datagrid");
var opts=_994.options;
var dc=_994.dc;
var _995=this.groups[_993];
var span=dc.body1.add(dc.body2).children("div.datagrid-group[group-index="+_993+"]").find("span.datagrid-group-title");
span.html(opts.groupFormatter.call(_992,_995.value,_995.rows));
},resizeGroup:function(_996,_997){
var _998=$.data(_996,"datagrid");
var dc=_998.dc;
var ht=dc.header2.find("table");
var fr=ht.find("tr.datagrid-filter-row").hide();
var ww=dc.body2.children("table.datagrid-btable:first").width();
if(_997==undefined){
var _999=dc.body2.children("div.datagrid-group");
}else{
var _999=dc.body2.children("div.datagrid-group[group-index="+_997+"]");
}
_999._outerWidth(ww);
var opts=_998.options;
if(opts.frozenColumns&&opts.frozenColumns.length){
var _99a=dc.view1.width()-opts.expanderWidth;
var _99b=dc.view1.css("direction").toLowerCase()=="rtl";
_999.find(".datagrid-group-title").css(_99b?"right":"left",-_99a+"px");
}
if(fr.length){
if(opts.showFilterBar){
fr.show();
}
}
},insertRow:function(_99c,_99d,row){
var _99e=$.data(_99c,"datagrid");
var opts=_99e.options;
var dc=_99e.dc;
var _99f=null;
var _9a0;
if(!_99e.data.rows.length){
$(_99c).datagrid("loadData",[row]);
return;
}
for(var i=0;i<this.groups.length;i++){
if(this.groups[i].value==row[opts.groupField]){
_99f=this.groups[i];
_9a0=i;
break;
}
}
if(_99f){
if(_99d==undefined||_99d==null){
_99d=_99e.data.rows.length;
}
if(_99d<_99f.startIndex){
_99d=_99f.startIndex;
}else{
if(_99d>_99f.startIndex+_99f.rows.length){
_99d=_99f.startIndex+_99f.rows.length;
}
}
$.fn.datagrid.defaults.view.insertRow.call(this,_99c,_99d,row);
if(_99d>=_99f.startIndex+_99f.rows.length){
_9a1(_99d,true);
_9a1(_99d,false);
}
_99f.rows.splice(_99d-_99f.startIndex,0,row);
}else{
_99f={value:row[opts.groupField],rows:[row],startIndex:_99e.data.rows.length};
_9a0=this.groups.length;
dc.body1.append(this.renderGroup.call(this,_99c,_9a0,_99f,true));
dc.body2.append(this.renderGroup.call(this,_99c,_9a0,_99f,false));
this.groups.push(_99f);
_99e.data.rows.push(row);
}
this.setGroupIndex(_99c);
this.refreshGroupTitle(_99c,_9a0);
this.resizeGroup(_99c);
function _9a1(_9a2,_9a3){
var _9a4=_9a3?1:2;
var _9a5=opts.finder.getTr(_99c,_9a2-1,"body",_9a4);
var tr=opts.finder.getTr(_99c,_9a2,"body",_9a4);
tr.insertAfter(_9a5);
};
},updateRow:function(_9a6,_9a7,row){
var opts=$.data(_9a6,"datagrid").options;
$.fn.datagrid.defaults.view.updateRow.call(this,_9a6,_9a7,row);
var tb=opts.finder.getTr(_9a6,_9a7,"body",2).closest("table.datagrid-btable");
var _9a8=parseInt(tb.prev().attr("group-index"));
this.refreshGroupTitle(_9a6,_9a8);
},deleteRow:function(_9a9,_9aa){
var _9ab=$.data(_9a9,"datagrid");
var opts=_9ab.options;
var dc=_9ab.dc;
var body=dc.body1.add(dc.body2);
var tb=opts.finder.getTr(_9a9,_9aa,"body",2).closest("table.datagrid-btable");
var _9ac=parseInt(tb.prev().attr("group-index"));
$.fn.datagrid.defaults.view.deleteRow.call(this,_9a9,_9aa);
var _9ad=this.groups[_9ac];
if(_9ad.rows.length>1){
_9ad.rows.splice(_9aa-_9ad.startIndex,1);
this.refreshGroupTitle(_9a9,_9ac);
}else{
body.children("div.datagrid-group[group-index="+_9ac+"]").remove();
for(var i=_9ac+1;i<this.groups.length;i++){
body.children("div.datagrid-group[group-index="+i+"]").attr("group-index",i-1);
}
this.groups.splice(_9ac,1);
}
this.setGroupIndex(_9a9);
},setGroupIndex:function(_9ae){
var _9af=0;
for(var i=0;i<this.groups.length;i++){
var _9b0=this.groups[i];
_9b0.startIndex=_9af;
_9af+=_9b0.rows.length;
}
}});
$.fn.propertygrid.defaults=$.extend({},$.fn.datagrid.defaults,{groupHeight:28,expanderWidth:20,singleSelect:true,remoteSort:false,fitColumns:true,loadMsg:"",frozenColumns:[[{field:"f",width:20,resizable:false}]],columns:[[{field:"name",title:"Name",width:100,sortable:true},{field:"value",title:"Value",width:100,resizable:false}]],showGroup:false,groupView:_95c,groupField:"group",groupStyler:function(_9b1,rows){
return "";
},groupFormatter:function(_9b2,rows){
return _9b2;
}});
})(jQuery);
(function($){
function _9b3(_9b4){
var _9b5=$.data(_9b4,"treegrid");
var opts=_9b5.options;
$(_9b4).datagrid($.extend({},opts,{url:null,data:null,loader:function(){
return false;
},onBeforeLoad:function(){
return false;
},onLoadSuccess:function(){
},onResizeColumn:function(_9b6,_9b7){
_9c4(_9b4);
opts.onResizeColumn.call(_9b4,_9b6,_9b7);
},onBeforeSortColumn:function(sort,_9b8){
if(opts.onBeforeSortColumn.call(_9b4,sort,_9b8)==false){
return false;
}
},onSortColumn:function(sort,_9b9){
opts.sortName=sort;
opts.sortOrder=_9b9;
if(opts.remoteSort){
_9c3(_9b4);
}else{
var data=$(_9b4).treegrid("getData");
_9f2(_9b4,null,data);
}
opts.onSortColumn.call(_9b4,sort,_9b9);
},onClickCell:function(_9ba,_9bb){
opts.onClickCell.call(_9b4,_9bb,find(_9b4,_9ba));
},onDblClickCell:function(_9bc,_9bd){
opts.onDblClickCell.call(_9b4,_9bd,find(_9b4,_9bc));
},onRowContextMenu:function(e,_9be){
opts.onContextMenu.call(_9b4,e,find(_9b4,_9be));
}}));
var _9bf=$.data(_9b4,"datagrid").options;
opts.columns=_9bf.columns;
opts.frozenColumns=_9bf.frozenColumns;
_9b5.dc=$.data(_9b4,"datagrid").dc;
if(opts.pagination){
var _9c0=$(_9b4).datagrid("getPager");
_9c0.pagination({pageNumber:opts.pageNumber,pageSize:opts.pageSize,pageList:opts.pageList,onSelectPage:function(_9c1,_9c2){
opts.pageNumber=_9c1;
opts.pageSize=_9c2;
_9c3(_9b4);
}});
opts.pageSize=_9c0.pagination("options").pageSize;
}
};
function _9c4(_9c5,_9c6){
var opts=$.data(_9c5,"datagrid").options;
var dc=$.data(_9c5,"datagrid").dc;
if(!dc.body1.is(":empty")&&(!opts.nowrap||opts.autoRowHeight)){
if(_9c6!=undefined){
var _9c7=_9c8(_9c5,_9c6);
for(var i=0;i<_9c7.length;i++){
_9c9(_9c7[i][opts.idField]);
}
}
}
$(_9c5).datagrid("fixRowHeight",_9c6);
function _9c9(_9ca){
var tr1=opts.finder.getTr(_9c5,_9ca,"body",1);
var tr2=opts.finder.getTr(_9c5,_9ca,"body",2);
tr1.css("height","");
tr2.css("height","");
var _9cb=Math.max(tr1.height(),tr2.height());
tr1.css("height",_9cb);
tr2.css("height",_9cb);
};
};
function _9cc(_9cd){
var dc=$.data(_9cd,"datagrid").dc;
var opts=$.data(_9cd,"treegrid").options;
if(!opts.rownumbers){
return;
}
dc.body1.find("div.datagrid-cell-rownumber").each(function(i){
$(this).html(i+1);
});
};
function _9ce(_9cf){
return function(e){
$.fn.datagrid.defaults.rowEvents[_9cf?"mouseover":"mouseout"](e);
var tt=$(e.target);
var fn=_9cf?"addClass":"removeClass";
if(tt.hasClass("tree-hit")){
tt.hasClass("tree-expanded")?tt[fn]("tree-expanded-hover"):tt[fn]("tree-collapsed-hover");
}
};
};
function _9d0(e){
var tt=$(e.target);
var tr=tt.closest("tr.datagrid-row");
if(!tr.length||!tr.parent().length){
return;
}
var _9d1=tr.attr("node-id");
var _9d2=_9d3(tr);
if(tt.hasClass("tree-hit")){
_9d4(_9d2,_9d1);
}else{
if(tt.hasClass("tree-checkbox")){
_9d5(_9d2,_9d1);
}else{
var opts=$(_9d2).datagrid("options");
if(!tt.parent().hasClass("datagrid-cell-check")&&!opts.singleSelect&&e.shiftKey){
var rows=$(_9d2).treegrid("getChildren");
var idx1=$.easyui.indexOfArray(rows,opts.idField,opts.lastSelectedIndex);
var idx2=$.easyui.indexOfArray(rows,opts.idField,_9d1);
var from=Math.min(Math.max(idx1,0),idx2);
var to=Math.max(idx1,idx2);
var row=rows[idx2];
var td=tt.closest("td[field]",tr);
if(td.length){
var _9d6=td.attr("field");
opts.onClickCell.call(_9d2,_9d1,_9d6,row[_9d6]);
}
$(_9d2).treegrid("clearSelections");
for(var i=from;i<=to;i++){
$(_9d2).treegrid("selectRow",rows[i][opts.idField]);
}
opts.onClickRow.call(_9d2,row);
}else{
$.fn.datagrid.defaults.rowEvents.click(e);
}
}
}
};
function _9d3(t){
return $(t).closest("div.datagrid-view").children(".datagrid-f")[0];
};
function _9d5(_9d7,_9d8,_9d9,_9da){
var _9db=$.data(_9d7,"treegrid");
var _9dc=_9db.checkedRows;
var opts=_9db.options;
if(!opts.checkbox){
return;
}
var row=find(_9d7,_9d8);
if(!row.checkState){
return;
}
var tr=opts.finder.getTr(_9d7,_9d8);
var ck=tr.find(".tree-checkbox");
if(_9d9==undefined){
if(ck.hasClass("tree-checkbox1")){
_9d9=false;
}else{
if(ck.hasClass("tree-checkbox0")){
_9d9=true;
}else{
if(row._checked==undefined){
row._checked=ck.hasClass("tree-checkbox1");
}
_9d9=!row._checked;
}
}
}
row._checked=_9d9;
if(_9d9){
if(ck.hasClass("tree-checkbox1")){
return;
}
}else{
if(ck.hasClass("tree-checkbox0")){
return;
}
}
if(!_9da){
if(opts.onBeforeCheckNode.call(_9d7,row,_9d9)==false){
return;
}
}
if(opts.cascadeCheck){
_9dd(_9d7,row,_9d9);
_9de(_9d7,row);
}else{
_9df(_9d7,row,_9d9?"1":"0");
}
if(!_9da){
opts.onCheckNode.call(_9d7,row,_9d9);
}
};
function _9df(_9e0,row,flag){
var _9e1=$.data(_9e0,"treegrid");
var _9e2=_9e1.checkedRows;
var opts=_9e1.options;
if(!row.checkState||flag==undefined){
return;
}
var tr=opts.finder.getTr(_9e0,row[opts.idField]);
var ck=tr.find(".tree-checkbox");
if(!ck.length){
return;
}
row.checkState=["unchecked","checked","indeterminate"][flag];
row.checked=(row.checkState=="checked");
ck.removeClass("tree-checkbox0 tree-checkbox1 tree-checkbox2");
ck.addClass("tree-checkbox"+flag);
if(flag==0){
$.easyui.removeArrayItem(_9e2,opts.idField,row[opts.idField]);
}else{
$.easyui.addArrayItem(_9e2,opts.idField,row);
}
};
function _9dd(_9e3,row,_9e4){
var flag=_9e4?1:0;
_9df(_9e3,row,flag);
$.easyui.forEach(row.children||[],true,function(r){
_9df(_9e3,r,flag);
});
};
function _9de(_9e5,row){
var opts=$.data(_9e5,"treegrid").options;
var prow=_9e6(_9e5,row[opts.idField]);
if(prow){
_9df(_9e5,prow,_9e7(prow));
_9de(_9e5,prow);
}
};
function _9e7(row){
var len=0;
var c0=0;
var c1=0;
$.easyui.forEach(row.children||[],false,function(r){
if(r.checkState){
len++;
if(r.checkState=="checked"){
c1++;
}else{
if(r.checkState=="unchecked"){
c0++;
}
}
}
});
if(len==0){
return undefined;
}
var flag=0;
if(c0==len){
flag=0;
}else{
if(c1==len){
flag=1;
}else{
flag=2;
}
}
return flag;
};
function _9e8(_9e9,_9ea){
var opts=$.data(_9e9,"treegrid").options;
if(!opts.checkbox){
return;
}
var row=find(_9e9,_9ea);
var tr=opts.finder.getTr(_9e9,_9ea);
var ck=tr.find(".tree-checkbox");
if(opts.view.hasCheckbox(_9e9,row)){
if(!ck.length){
row.checkState=row.checkState||"unchecked";
$("<span class=\"tree-checkbox\"></span>").insertBefore(tr.find(".tree-title"));
}
if(row.checkState=="checked"){
_9d5(_9e9,_9ea,true,true);
}else{
if(row.checkState=="unchecked"){
_9d5(_9e9,_9ea,false,true);
}else{
var flag=_9e7(row);
if(flag===0){
_9d5(_9e9,_9ea,false,true);
}else{
if(flag===1){
_9d5(_9e9,_9ea,true,true);
}
}
}
}
}else{
ck.remove();
row.checkState=undefined;
row.checked=undefined;
_9de(_9e9,row);
}
};
function _9eb(_9ec,_9ed){
var opts=$.data(_9ec,"treegrid").options;
var tr1=opts.finder.getTr(_9ec,_9ed,"body",1);
var tr2=opts.finder.getTr(_9ec,_9ed,"body",2);
var _9ee=$(_9ec).datagrid("getColumnFields",true).length+(opts.rownumbers?1:0);
var _9ef=$(_9ec).datagrid("getColumnFields",false).length;
_9f0(tr1,_9ee);
_9f0(tr2,_9ef);
function _9f0(tr,_9f1){
$("<tr class=\"treegrid-tr-tree\">"+"<td style=\"border:0px\" colspan=\""+_9f1+"\">"+"<div></div>"+"</td>"+"</tr>").insertAfter(tr);
};
};
function _9f2(_9f3,_9f4,data,_9f5,_9f6){
var _9f7=$.data(_9f3,"treegrid");
var opts=_9f7.options;
var dc=_9f7.dc;
data=opts.loadFilter.call(_9f3,data,_9f4);
var node=find(_9f3,_9f4);
if(node){
var _9f8=opts.finder.getTr(_9f3,_9f4,"body",1);
var _9f9=opts.finder.getTr(_9f3,_9f4,"body",2);
var cc1=_9f8.next("tr.treegrid-tr-tree").children("td").children("div");
var cc2=_9f9.next("tr.treegrid-tr-tree").children("td").children("div");
if(!_9f5){
node.children=[];
}
}else{
var cc1=dc.body1;
var cc2=dc.body2;
if(!_9f5){
_9f7.data=[];
}
}
if(!_9f5){
cc1.empty();
cc2.empty();
}
if(opts.view.onBeforeRender){
opts.view.onBeforeRender.call(opts.view,_9f3,_9f4,data);
}
opts.view.render.call(opts.view,_9f3,cc1,true);
opts.view.render.call(opts.view,_9f3,cc2,false);
if(opts.showFooter){
opts.view.renderFooter.call(opts.view,_9f3,dc.footer1,true);
opts.view.renderFooter.call(opts.view,_9f3,dc.footer2,false);
}
if(opts.view.onAfterRender){
opts.view.onAfterRender.call(opts.view,_9f3);
}
if(!_9f4&&opts.pagination){
var _9fa=$.data(_9f3,"treegrid").total;
var _9fb=$(_9f3).datagrid("getPager");
if(_9fb.pagination("options").total!=_9fa){
_9fb.pagination({total:_9fa});
}
}
_9c4(_9f3);
_9cc(_9f3);
$(_9f3).treegrid("showLines");
$(_9f3).treegrid("setSelectionState");
$(_9f3).treegrid("autoSizeColumn");
if(!_9f6){
opts.onLoadSuccess.call(_9f3,node,data);
}
};
function _9c3(_9fc,_9fd,_9fe,_9ff,_a00){
var opts=$.data(_9fc,"treegrid").options;
var body=$(_9fc).datagrid("getPanel").find("div.datagrid-body");
if(_9fd==undefined&&opts.queryParams){
opts.queryParams.id=undefined;
}
if(_9fe){
opts.queryParams=_9fe;
}
var _a01=$.extend({},opts.queryParams);
if(opts.pagination){
$.extend(_a01,{page:opts.pageNumber,rows:opts.pageSize});
}
if(opts.sortName){
$.extend(_a01,{sort:opts.sortName,order:opts.sortOrder});
}
var row=find(_9fc,_9fd);
if(opts.onBeforeLoad.call(_9fc,row,_a01)==false){
return;
}
var _a02=body.find("tr[node-id=\""+_9fd+"\"] span.tree-folder");
_a02.addClass("tree-loading");
$(_9fc).treegrid("loading");
var _a03=opts.loader.call(_9fc,_a01,function(data){
_a02.removeClass("tree-loading");
$(_9fc).treegrid("loaded");
_9f2(_9fc,_9fd,data,_9ff);
if(_a00){
_a00();
}
},function(){
_a02.removeClass("tree-loading");
$(_9fc).treegrid("loaded");
opts.onLoadError.apply(_9fc,arguments);
if(_a00){
_a00();
}
});
if(_a03==false){
_a02.removeClass("tree-loading");
$(_9fc).treegrid("loaded");
}
};
function _a04(_a05){
var _a06=_a07(_a05);
return _a06.length?_a06[0]:null;
};
function _a07(_a08){
return $.data(_a08,"treegrid").data;
};
function _9e6(_a09,_a0a){
var row=find(_a09,_a0a);
if(row._parentId){
return find(_a09,row._parentId);
}else{
return null;
}
};
function _9c8(_a0b,_a0c){
var data=$.data(_a0b,"treegrid").data;
if(_a0c){
var _a0d=find(_a0b,_a0c);
data=_a0d?(_a0d.children||[]):[];
}
var _a0e=[];
$.easyui.forEach(data,true,function(node){
_a0e.push(node);
});
return _a0e;
};
function _a0f(_a10,_a11){
var opts=$.data(_a10,"treegrid").options;
var tr=opts.finder.getTr(_a10,_a11);
var node=tr.children("td[field=\""+opts.treeField+"\"]");
return node.find("span.tree-indent,span.tree-hit").length;
};
function find(_a12,_a13){
var _a14=$.data(_a12,"treegrid");
var opts=_a14.options;
var _a15=null;
$.easyui.forEach(_a14.data,true,function(node){
if(node[opts.idField]==_a13){
_a15=node;
return false;
}
});
return _a15;
};
function _a16(_a17,_a18){
var opts=$.data(_a17,"treegrid").options;
var row=find(_a17,_a18);
var tr=opts.finder.getTr(_a17,_a18);
var hit=tr.find("span.tree-hit");
if(hit.length==0){
return;
}
if(hit.hasClass("tree-collapsed")){
return;
}
if(opts.onBeforeCollapse.call(_a17,row)==false){
return;
}
hit.removeClass("tree-expanded tree-expanded-hover").addClass("tree-collapsed");
hit.next().removeClass("tree-folder-open");
row.state="closed";
tr=tr.next("tr.treegrid-tr-tree");
var cc=tr.children("td").children("div");
if(opts.animate){
cc.slideUp("normal",function(){
$(_a17).treegrid("autoSizeColumn");
_9c4(_a17,_a18);
opts.onCollapse.call(_a17,row);
});
}else{
cc.hide();
$(_a17).treegrid("autoSizeColumn");
_9c4(_a17,_a18);
opts.onCollapse.call(_a17,row);
}
};
function _a19(_a1a,_a1b){
var opts=$.data(_a1a,"treegrid").options;
var tr=opts.finder.getTr(_a1a,_a1b);
var hit=tr.find("span.tree-hit");
var row=find(_a1a,_a1b);
if(hit.length==0){
return;
}
if(hit.hasClass("tree-expanded")){
return;
}
if(opts.onBeforeExpand.call(_a1a,row)==false){
return;
}
hit.removeClass("tree-collapsed tree-collapsed-hover").addClass("tree-expanded");
hit.next().addClass("tree-folder-open");
var _a1c=tr.next("tr.treegrid-tr-tree");
if(_a1c.length){
var cc=_a1c.children("td").children("div");
_a1d(cc);
}else{
_9eb(_a1a,row[opts.idField]);
var _a1c=tr.next("tr.treegrid-tr-tree");
var cc=_a1c.children("td").children("div");
cc.hide();
var _a1e=$.extend({},opts.queryParams||{});
_a1e.id=row[opts.idField];
_9c3(_a1a,row[opts.idField],_a1e,true,function(){
if(cc.is(":empty")){
_a1c.remove();
}else{
_a1d(cc);
}
});
}
function _a1d(cc){
row.state="open";
if(opts.animate){
cc.slideDown("normal",function(){
$(_a1a).treegrid("autoSizeColumn");
_9c4(_a1a,_a1b);
opts.onExpand.call(_a1a,row);
});
}else{
cc.show();
$(_a1a).treegrid("autoSizeColumn");
_9c4(_a1a,_a1b);
opts.onExpand.call(_a1a,row);
}
};
};
function _9d4(_a1f,_a20){
var opts=$.data(_a1f,"treegrid").options;
var tr=opts.finder.getTr(_a1f,_a20);
var hit=tr.find("span.tree-hit");
if(hit.hasClass("tree-expanded")){
_a16(_a1f,_a20);
}else{
_a19(_a1f,_a20);
}
};
function _a21(_a22,_a23){
var opts=$.data(_a22,"treegrid").options;
var _a24=_9c8(_a22,_a23);
if(_a23){
_a24.unshift(find(_a22,_a23));
}
for(var i=0;i<_a24.length;i++){
_a16(_a22,_a24[i][opts.idField]);
}
};
function _a25(_a26,_a27){
var opts=$.data(_a26,"treegrid").options;
var _a28=_9c8(_a26,_a27);
if(_a27){
_a28.unshift(find(_a26,_a27));
}
for(var i=0;i<_a28.length;i++){
_a19(_a26,_a28[i][opts.idField]);
}
};
function _a29(_a2a,_a2b){
var opts=$.data(_a2a,"treegrid").options;
var ids=[];
var p=_9e6(_a2a,_a2b);
while(p){
var id=p[opts.idField];
ids.unshift(id);
p=_9e6(_a2a,id);
}
for(var i=0;i<ids.length;i++){
_a19(_a2a,ids[i]);
}
};
function _a2c(_a2d,_a2e){
var _a2f=$.data(_a2d,"treegrid");
var opts=_a2f.options;
if(_a2e.parent){
var tr=opts.finder.getTr(_a2d,_a2e.parent);
if(tr.next("tr.treegrid-tr-tree").length==0){
_9eb(_a2d,_a2e.parent);
}
var cell=tr.children("td[field=\""+opts.treeField+"\"]").children("div.datagrid-cell");
var _a30=cell.children("span.tree-icon");
if(_a30.hasClass("tree-file")){
_a30.removeClass("tree-file").addClass("tree-folder tree-folder-open");
var hit=$("<span class=\"tree-hit tree-expanded\"></span>").insertBefore(_a30);
if(hit.prev().length){
hit.prev().remove();
}
}
}
_9f2(_a2d,_a2e.parent,_a2e.data,_a2f.data.length>0,true);
};
function _a31(_a32,_a33){
var ref=_a33.before||_a33.after;
var opts=$.data(_a32,"treegrid").options;
var _a34=_9e6(_a32,ref);
_a2c(_a32,{parent:(_a34?_a34[opts.idField]:null),data:[_a33.data]});
var _a35=_a34?_a34.children:$(_a32).treegrid("getRoots");
for(var i=0;i<_a35.length;i++){
if(_a35[i][opts.idField]==ref){
var _a36=_a35[_a35.length-1];
_a35.splice(_a33.before?i:(i+1),0,_a36);
_a35.splice(_a35.length-1,1);
break;
}
}
_a37(true);
_a37(false);
_9cc(_a32);
$(_a32).treegrid("showLines");
function _a37(_a38){
var _a39=_a38?1:2;
var tr=opts.finder.getTr(_a32,_a33.data[opts.idField],"body",_a39);
var _a3a=tr.closest("table.datagrid-btable");
tr=tr.parent().children();
var dest=opts.finder.getTr(_a32,ref,"body",_a39);
if(_a33.before){
tr.insertBefore(dest);
}else{
var sub=dest.next("tr.treegrid-tr-tree");
tr.insertAfter(sub.length?sub:dest);
}
_a3a.remove();
};
};
function _a3b(_a3c,_a3d){
var _a3e=$.data(_a3c,"treegrid");
var opts=_a3e.options;
var prow=_9e6(_a3c,_a3d);
$(_a3c).datagrid("deleteRow",_a3d);
$.easyui.removeArrayItem(_a3e.checkedRows,opts.idField,_a3d);
_9cc(_a3c);
if(prow){
_9e8(_a3c,prow[opts.idField]);
}
_a3e.total-=1;
$(_a3c).datagrid("getPager").pagination("refresh",{total:_a3e.total});
$(_a3c).treegrid("showLines");
};
function _a3f(_a40){
var t=$(_a40);
var opts=t.treegrid("options");
if(opts.lines){
t.treegrid("getPanel").addClass("tree-lines");
}else{
t.treegrid("getPanel").removeClass("tree-lines");
return;
}
t.treegrid("getPanel").find("span.tree-indent").removeClass("tree-line tree-join tree-joinbottom");
t.treegrid("getPanel").find("div.datagrid-cell").removeClass("tree-node-last tree-root-first tree-root-one");
var _a41=t.treegrid("getRoots");
if(_a41.length>1){
_a42(_a41[0]).addClass("tree-root-first");
}else{
if(_a41.length==1){
_a42(_a41[0]).addClass("tree-root-one");
}
}
_a43(_a41);
_a44(_a41);
function _a43(_a45){
$.map(_a45,function(node){
if(node.children&&node.children.length){
_a43(node.children);
}else{
var cell=_a42(node);
cell.find(".tree-icon").prev().addClass("tree-join");
}
});
if(_a45.length){
var cell=_a42(_a45[_a45.length-1]);
cell.addClass("tree-node-last");
cell.find(".tree-join").removeClass("tree-join").addClass("tree-joinbottom");
}
};
function _a44(_a46){
$.map(_a46,function(node){
if(node.children&&node.children.length){
_a44(node.children);
}
});
for(var i=0;i<_a46.length-1;i++){
var node=_a46[i];
var _a47=t.treegrid("getLevel",node[opts.idField]);
var tr=opts.finder.getTr(_a40,node[opts.idField]);
var cc=tr.next().find("tr.datagrid-row td[field=\""+opts.treeField+"\"] div.datagrid-cell");
cc.find("span:eq("+(_a47-1)+")").addClass("tree-line");
}
};
function _a42(node){
var tr=opts.finder.getTr(_a40,node[opts.idField]);
var cell=tr.find("td[field=\""+opts.treeField+"\"] div.datagrid-cell");
return cell;
};
};
$.fn.treegrid=function(_a48,_a49){
if(typeof _a48=="string"){
var _a4a=$.fn.treegrid.methods[_a48];
if(_a4a){
return _a4a(this,_a49);
}else{
return this.datagrid(_a48,_a49);
}
}
_a48=_a48||{};
return this.each(function(){
var _a4b=$.data(this,"treegrid");
if(_a4b){
$.extend(_a4b.options,_a48);
}else{
_a4b=$.data(this,"treegrid",{options:$.extend({},$.fn.treegrid.defaults,$.fn.treegrid.parseOptions(this),_a48),data:[],checkedRows:[],tmpIds:[]});
}
_9b3(this);
if(_a4b.options.data){
$(this).treegrid("loadData",_a4b.options.data);
}
_9c3(this);
});
};
$.fn.treegrid.methods={options:function(jq){
return $.data(jq[0],"treegrid").options;
},resize:function(jq,_a4c){
return jq.each(function(){
$(this).datagrid("resize",_a4c);
});
},fixRowHeight:function(jq,_a4d){
return jq.each(function(){
_9c4(this,_a4d);
});
},loadData:function(jq,data){
return jq.each(function(){
_9f2(this,data.parent,data);
});
},load:function(jq,_a4e){
return jq.each(function(){
$(this).treegrid("options").pageNumber=1;
$(this).treegrid("getPager").pagination({pageNumber:1});
$(this).treegrid("reload",_a4e);
});
},reload:function(jq,id){
return jq.each(function(){
var opts=$(this).treegrid("options");
var _a4f={};
if(typeof id=="object"){
_a4f=id;
}else{
_a4f=$.extend({},opts.queryParams);
_a4f.id=id;
}
if(_a4f.id){
var node=$(this).treegrid("find",_a4f.id);
if(node.children){
node.children.splice(0,node.children.length);
}
opts.queryParams=_a4f;
var tr=opts.finder.getTr(this,_a4f.id);
tr.next("tr.treegrid-tr-tree").remove();
tr.find("span.tree-hit").removeClass("tree-expanded tree-expanded-hover").addClass("tree-collapsed");
_a19(this,_a4f.id);
}else{
_9c3(this,null,_a4f);
}
});
},reloadFooter:function(jq,_a50){
return jq.each(function(){
var opts=$.data(this,"treegrid").options;
var dc=$.data(this,"datagrid").dc;
if(_a50){
$.data(this,"treegrid").footer=_a50;
}
if(opts.showFooter){
opts.view.renderFooter.call(opts.view,this,dc.footer1,true);
opts.view.renderFooter.call(opts.view,this,dc.footer2,false);
if(opts.view.onAfterRender){
opts.view.onAfterRender.call(opts.view,this);
}
$(this).treegrid("fixRowHeight");
}
});
},getData:function(jq){
return $.data(jq[0],"treegrid").data;
},getFooterRows:function(jq){
return $.data(jq[0],"treegrid").footer;
},getRoot:function(jq){
return _a04(jq[0]);
},getRoots:function(jq){
return _a07(jq[0]);
},getParent:function(jq,id){
return _9e6(jq[0],id);
},getChildren:function(jq,id){
return _9c8(jq[0],id);
},getLevel:function(jq,id){
return _a0f(jq[0],id);
},find:function(jq,id){
return find(jq[0],id);
},isLeaf:function(jq,id){
var opts=$.data(jq[0],"treegrid").options;
var tr=opts.finder.getTr(jq[0],id);
var hit=tr.find("span.tree-hit");
return hit.length==0;
},select:function(jq,id){
return jq.each(function(){
$(this).datagrid("selectRow",id);
});
},unselect:function(jq,id){
return jq.each(function(){
$(this).datagrid("unselectRow",id);
});
},collapse:function(jq,id){
return jq.each(function(){
_a16(this,id);
});
},expand:function(jq,id){
return jq.each(function(){
_a19(this,id);
});
},toggle:function(jq,id){
return jq.each(function(){
_9d4(this,id);
});
},collapseAll:function(jq,id){
return jq.each(function(){
_a21(this,id);
});
},expandAll:function(jq,id){
return jq.each(function(){
_a25(this,id);
});
},expandTo:function(jq,id){
return jq.each(function(){
_a29(this,id);
});
},append:function(jq,_a51){
return jq.each(function(){
_a2c(this,_a51);
});
},insert:function(jq,_a52){
return jq.each(function(){
_a31(this,_a52);
});
},remove:function(jq,id){
return jq.each(function(){
_a3b(this,id);
});
},pop:function(jq,id){
var row=jq.treegrid("find",id);
jq.treegrid("remove",id);
return row;
},refresh:function(jq,id){
return jq.each(function(){
var opts=$.data(this,"treegrid").options;
opts.view.refreshRow.call(opts.view,this,id);
});
},update:function(jq,_a53){
return jq.each(function(){
var opts=$.data(this,"treegrid").options;
var row=_a53.row;
opts.view.updateRow.call(opts.view,this,_a53.id,row);
if(row.checked!=undefined){
row=find(this,_a53.id);
$.extend(row,{checkState:row.checked?"checked":(row.checked===false?"unchecked":undefined)});
_9e8(this,_a53.id);
}
});
},beginEdit:function(jq,id){
return jq.each(function(){
$(this).datagrid("beginEdit",id);
$(this).treegrid("fixRowHeight",id);
});
},endEdit:function(jq,id){
return jq.each(function(){
$(this).datagrid("endEdit",id);
});
},cancelEdit:function(jq,id){
return jq.each(function(){
$(this).datagrid("cancelEdit",id);
});
},showLines:function(jq){
return jq.each(function(){
_a3f(this);
});
},setSelectionState:function(jq){
return jq.each(function(){
$(this).datagrid("setSelectionState");
var _a54=$(this).data("treegrid");
for(var i=0;i<_a54.tmpIds.length;i++){
_9d5(this,_a54.tmpIds[i],true,true);
}
_a54.tmpIds=[];
});
},getCheckedNodes:function(jq,_a55){
_a55=_a55||"checked";
var rows=[];
$.easyui.forEach(jq.data("treegrid").checkedRows,false,function(row){
if(row.checkState==_a55){
rows.push(row);
}
});
return rows;
},checkNode:function(jq,id){
return jq.each(function(){
_9d5(this,id,true);
});
},uncheckNode:function(jq,id){
return jq.each(function(){
_9d5(this,id,false);
});
},clearChecked:function(jq){
return jq.each(function(){
var _a56=this;
var opts=$(_a56).treegrid("options");
$(_a56).datagrid("clearChecked");
$.map($(_a56).treegrid("getCheckedNodes"),function(row){
_9d5(_a56,row[opts.idField],false,true);
});
});
}};
$.fn.treegrid.parseOptions=function(_a57){
return $.extend({},$.fn.datagrid.parseOptions(_a57),$.parser.parseOptions(_a57,["treeField",{checkbox:"boolean",cascadeCheck:"boolean",onlyLeafCheck:"boolean"},{animate:"boolean"}]));
};
var _a58=$.extend({},$.fn.datagrid.defaults.view,{render:function(_a59,_a5a,_a5b){
var opts=$.data(_a59,"treegrid").options;
var _a5c=$(_a59).datagrid("getColumnFields",_a5b);
var _a5d=$.data(_a59,"datagrid").rowIdPrefix;
if(_a5b){
if(!(opts.rownumbers||(opts.frozenColumns&&opts.frozenColumns.length))){
return;
}
}
var view=this;
if(this.treeNodes&&this.treeNodes.length){
var _a5e=_a5f.call(this,_a5b,this.treeLevel,this.treeNodes);
$(_a5a).append(_a5e.join(""));
}
function _a5f(_a60,_a61,_a62){
var _a63=$(_a59).treegrid("getParent",_a62[0][opts.idField]);
var _a64=(_a63?_a63.children.length:$(_a59).treegrid("getRoots").length)-_a62.length;
var _a65=["<table class=\"datagrid-btable\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\"><tbody>"];
for(var i=0;i<_a62.length;i++){
var row=_a62[i];
if(row.state!="open"&&row.state!="closed"){
row.state="open";
}
var css=opts.rowStyler?opts.rowStyler.call(_a59,row):"";
var cs=this.getStyleValue(css);
var cls="class=\"datagrid-row "+(_a64++%2&&opts.striped?"datagrid-row-alt ":" ")+cs.c+"\"";
var _a66=cs.s?"style=\""+cs.s+"\"":"";
var _a67=_a5d+"-"+(_a60?1:2)+"-"+row[opts.idField];
_a65.push("<tr id=\""+_a67+"\" node-id=\""+row[opts.idField]+"\" "+cls+" "+_a66+">");
_a65=_a65.concat(view.renderRow.call(view,_a59,_a5c,_a60,_a61,row));
_a65.push("</tr>");
if(row.children&&row.children.length){
var tt=_a5f.call(this,_a60,_a61+1,row.children);
var v=row.state=="closed"?"none":"block";
_a65.push("<tr class=\"treegrid-tr-tree\"><td style=\"border:0px\" colspan="+(_a5c.length+(opts.rownumbers?1:0))+"><div style=\"display:"+v+"\">");
_a65=_a65.concat(tt);
_a65.push("</div></td></tr>");
}
}
_a65.push("</tbody></table>");
return _a65;
};
},renderFooter:function(_a68,_a69,_a6a){
var opts=$.data(_a68,"treegrid").options;
var rows=$.data(_a68,"treegrid").footer||[];
var _a6b=$(_a68).datagrid("getColumnFields",_a6a);
var _a6c=["<table class=\"datagrid-ftable\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\"><tbody>"];
for(var i=0;i<rows.length;i++){
var row=rows[i];
row[opts.idField]=row[opts.idField]||("foot-row-id"+i);
_a6c.push("<tr class=\"datagrid-row\" node-id=\""+row[opts.idField]+"\">");
_a6c.push(this.renderRow.call(this,_a68,_a6b,_a6a,0,row));
_a6c.push("</tr>");
}
_a6c.push("</tbody></table>");
$(_a69).html(_a6c.join(""));
},renderRow:function(_a6d,_a6e,_a6f,_a70,row){
var _a71=$.data(_a6d,"treegrid");
var opts=_a71.options;
var cc=[];
if(_a6f&&opts.rownumbers){
cc.push("<td class=\"datagrid-td-rownumber\"><div class=\"datagrid-cell-rownumber\">0</div></td>");
}
for(var i=0;i<_a6e.length;i++){
var _a72=_a6e[i];
var col=$(_a6d).datagrid("getColumnOption",_a72);
if(col){
var css=col.styler?(col.styler(row[_a72],row)||""):"";
var cs=this.getStyleValue(css);
var cls=cs.c?"class=\""+cs.c+"\"":"";
var _a73=col.hidden?"style=\"display:none;"+cs.s+"\"":(cs.s?"style=\""+cs.s+"\"":"");
cc.push("<td field=\""+_a72+"\" "+cls+" "+_a73+">");
var _a73="";
if(!col.checkbox){
if(col.align){
_a73+="text-align:"+col.align+";";
}
if(!opts.nowrap){
_a73+="white-space:normal;height:auto;";
}else{
if(opts.autoRowHeight){
_a73+="height:auto;";
}
}
}
cc.push("<div style=\""+_a73+"\" ");
if(col.checkbox){
cc.push("class=\"datagrid-cell-check ");
}else{
cc.push("class=\"datagrid-cell "+col.cellClass);
}
if(_a72==opts.treeField){
cc.push(" tree-node");
}
cc.push("\">");
if(col.checkbox){
if(row.checked){
cc.push("<input type=\"checkbox\" checked=\"checked\"");
}else{
cc.push("<input type=\"checkbox\"");
}
cc.push(" name=\""+_a72+"\" value=\""+(row[_a72]!=undefined?row[_a72]:"")+"\">");
}else{
var val=null;
if(col.formatter){
val=col.formatter(row[_a72],row);
}else{
val=row[_a72];
}
if(_a72==opts.treeField){
for(var j=0;j<_a70;j++){
cc.push("<span class=\"tree-indent\"></span>");
}
if(row.state=="closed"){
cc.push("<span class=\"tree-hit tree-collapsed\"></span>");
cc.push("<span class=\"tree-icon tree-folder "+(row.iconCls?row.iconCls:"")+"\"></span>");
}else{
if(row.children&&row.children.length){
cc.push("<span class=\"tree-hit tree-expanded\"></span>");
cc.push("<span class=\"tree-icon tree-folder tree-folder-open "+(row.iconCls?row.iconCls:"")+"\"></span>");
}else{
cc.push("<span class=\"tree-indent\"></span>");
cc.push("<span class=\"tree-icon tree-file "+(row.iconCls?row.iconCls:"")+"\"></span>");
}
}
if(this.hasCheckbox(_a6d,row)){
var flag=0;
var crow=$.easyui.getArrayItem(_a71.checkedRows,opts.idField,row[opts.idField]);
if(crow){
flag=crow.checkState=="checked"?1:2;
row.checkState=crow.checkState;
row.checked=crow.checked;
$.easyui.addArrayItem(_a71.checkedRows,opts.idField,row);
}else{
var prow=$.easyui.getArrayItem(_a71.checkedRows,opts.idField,row._parentId);
if(prow&&prow.checkState=="checked"&&opts.cascadeCheck){
flag=1;
row.checked=true;
$.easyui.addArrayItem(_a71.checkedRows,opts.idField,row);
}else{
if(row.checked){
$.easyui.addArrayItem(_a71.tmpIds,row[opts.idField]);
}
}
row.checkState=flag?"checked":"unchecked";
}
cc.push("<span class=\"tree-checkbox tree-checkbox"+flag+"\"></span>");
}else{
row.checkState=undefined;
row.checked=undefined;
}
cc.push("<span class=\"tree-title\">"+val+"</span>");
}else{
cc.push(val);
}
}
cc.push("</div>");
cc.push("</td>");
}
}
return cc.join("");
},hasCheckbox:function(_a74,row){
var opts=$.data(_a74,"treegrid").options;
if(opts.checkbox){
if($.isFunction(opts.checkbox)){
if(opts.checkbox.call(_a74,row)){
return true;
}else{
return false;
}
}else{
if(opts.onlyLeafCheck){
if(row.state=="open"&&!(row.children&&row.children.length)){
return true;
}
}else{
return true;
}
}
}
return false;
},refreshRow:function(_a75,id){
this.updateRow.call(this,_a75,id,{});
},updateRow:function(_a76,id,row){
var opts=$.data(_a76,"treegrid").options;
var _a77=$(_a76).treegrid("find",id);
$.extend(_a77,row);
var _a78=$(_a76).treegrid("getLevel",id)-1;
var _a79=opts.rowStyler?opts.rowStyler.call(_a76,_a77):"";
var _a7a=$.data(_a76,"datagrid").rowIdPrefix;
var _a7b=_a77[opts.idField];
function _a7c(_a7d){
var _a7e=$(_a76).treegrid("getColumnFields",_a7d);
var tr=opts.finder.getTr(_a76,id,"body",(_a7d?1:2));
var _a7f=tr.find("div.datagrid-cell-rownumber").html();
var _a80=tr.find("div.datagrid-cell-check input[type=checkbox]").is(":checked");
tr.html(this.renderRow(_a76,_a7e,_a7d,_a78,_a77));
tr.attr("style",_a79||"");
tr.find("div.datagrid-cell-rownumber").html(_a7f);
if(_a80){
tr.find("div.datagrid-cell-check input[type=checkbox]")._propAttr("checked",true);
}
if(_a7b!=id){
tr.attr("id",_a7a+"-"+(_a7d?1:2)+"-"+_a7b);
tr.attr("node-id",_a7b);
}
};
_a7c.call(this,true);
_a7c.call(this,false);
$(_a76).treegrid("fixRowHeight",id);
},deleteRow:function(_a81,id){
var opts=$.data(_a81,"treegrid").options;
var tr=opts.finder.getTr(_a81,id);
tr.next("tr.treegrid-tr-tree").remove();
tr.remove();
var _a82=del(id);
if(_a82){
if(_a82.children.length==0){
tr=opts.finder.getTr(_a81,_a82[opts.idField]);
tr.next("tr.treegrid-tr-tree").remove();
var cell=tr.children("td[field=\""+opts.treeField+"\"]").children("div.datagrid-cell");
cell.find(".tree-icon").removeClass("tree-folder").addClass("tree-file");
cell.find(".tree-hit").remove();
$("<span class=\"tree-indent\"></span>").prependTo(cell);
}
}
this.setEmptyMsg(_a81);
function del(id){
var cc;
var _a83=$(_a81).treegrid("getParent",id);
if(_a83){
cc=_a83.children;
}else{
cc=$(_a81).treegrid("getData");
}
for(var i=0;i<cc.length;i++){
if(cc[i][opts.idField]==id){
cc.splice(i,1);
break;
}
}
return _a83;
};
},onBeforeRender:function(_a84,_a85,data){
if($.isArray(_a85)){
data={total:_a85.length,rows:_a85};
_a85=null;
}
if(!data){
return false;
}
var _a86=$.data(_a84,"treegrid");
var opts=_a86.options;
if(data.length==undefined){
if(data.footer){
_a86.footer=data.footer;
}
if(data.total){
_a86.total=data.total;
}
data=this.transfer(_a84,_a85,data.rows);
}else{
function _a87(_a88,_a89){
for(var i=0;i<_a88.length;i++){
var row=_a88[i];
row._parentId=_a89;
if(row.children&&row.children.length){
_a87(row.children,row[opts.idField]);
}
}
};
_a87(data,_a85);
}
this.sort(_a84,data);
this.treeNodes=data;
this.treeLevel=$(_a84).treegrid("getLevel",_a85);
var node=find(_a84,_a85);
if(node){
if(node.children){
node.children=node.children.concat(data);
}else{
node.children=data;
}
}else{
_a86.data=_a86.data.concat(data);
}
},sort:function(_a8a,data){
var opts=$.data(_a8a,"treegrid").options;
if(!opts.remoteSort&&opts.sortName){
var _a8b=opts.sortName.split(",");
var _a8c=opts.sortOrder.split(",");
_a8d(data);
}
function _a8d(rows){
rows.sort(function(r1,r2){
var r=0;
for(var i=0;i<_a8b.length;i++){
var sn=_a8b[i];
var so=_a8c[i];
var col=$(_a8a).treegrid("getColumnOption",sn);
var _a8e=col.sorter||function(a,b){
return a==b?0:(a>b?1:-1);
};
r=_a8e(r1[sn],r2[sn])*(so=="asc"?1:-1);
if(r!=0){
return r;
}
}
return r;
});
for(var i=0;i<rows.length;i++){
var _a8f=rows[i].children;
if(_a8f&&_a8f.length){
_a8d(_a8f);
}
}
};
},transfer:function(_a90,_a91,data){
var opts=$.data(_a90,"treegrid").options;
var rows=$.extend([],data);
var _a92=_a93(_a91,rows);
var toDo=$.extend([],_a92);
while(toDo.length){
var node=toDo.shift();
var _a94=_a93(node[opts.idField],rows);
if(_a94.length){
if(node.children){
node.children=node.children.concat(_a94);
}else{
node.children=_a94;
}
toDo=toDo.concat(_a94);
}
}
return _a92;
function _a93(_a95,rows){
var rr=[];
for(var i=0;i<rows.length;i++){
var row=rows[i];
if(row._parentId==_a95){
rr.push(row);
rows.splice(i,1);
i--;
}
}
return rr;
};
}});
$.fn.treegrid.defaults=$.extend({},$.fn.datagrid.defaults,{treeField:null,checkbox:false,cascadeCheck:true,onlyLeafCheck:false,lines:false,animate:false,singleSelect:true,view:_a58,rowEvents:$.extend({},$.fn.datagrid.defaults.rowEvents,{mouseover:_9ce(true),mouseout:_9ce(false),click:_9d0}),loader:function(_a96,_a97,_a98){
var opts=$(this).treegrid("options");
if(!opts.url){
return false;
}
$.ajax({type:opts.method,url:opts.url,data:_a96,dataType:"json",success:function(data){
_a97(data);
},error:function(){
_a98.apply(this,arguments);
}});
},loadFilter:function(data,_a99){
return data;
},finder:{getTr:function(_a9a,id,type,_a9b){
type=type||"body";
_a9b=_a9b||0;
var dc=$.data(_a9a,"datagrid").dc;
if(_a9b==0){
var opts=$.data(_a9a,"treegrid").options;
var tr1=opts.finder.getTr(_a9a,id,type,1);
var tr2=opts.finder.getTr(_a9a,id,type,2);
return tr1.add(tr2);
}else{
if(type=="body"){
var tr=$("#"+$.data(_a9a,"datagrid").rowIdPrefix+"-"+_a9b+"-"+id);
if(!tr.length){
tr=(_a9b==1?dc.body1:dc.body2).find("tr[node-id=\""+id+"\"]");
}
return tr;
}else{
if(type=="footer"){
return (_a9b==1?dc.footer1:dc.footer2).find("tr[node-id=\""+id+"\"]");
}else{
if(type=="selected"){
return (_a9b==1?dc.body1:dc.body2).find("tr.datagrid-row-selected");
}else{
if(type=="highlight"){
return (_a9b==1?dc.body1:dc.body2).find("tr.datagrid-row-over");
}else{
if(type=="checked"){
return (_a9b==1?dc.body1:dc.body2).find("tr.datagrid-row-checked");
}else{
if(type=="last"){
return (_a9b==1?dc.body1:dc.body2).find("tr:last[node-id]");
}else{
if(type=="allbody"){
return (_a9b==1?dc.body1:dc.body2).find("tr[node-id]");
}else{
if(type=="allfooter"){
return (_a9b==1?dc.footer1:dc.footer2).find("tr[node-id]");
}
}
}
}
}
}
}
}
}
},getRow:function(_a9c,p){
var id=(typeof p=="object")?p.attr("node-id"):p;
return $(_a9c).treegrid("find",id);
},getRows:function(_a9d){
return $(_a9d).treegrid("getChildren");
}},onBeforeLoad:function(row,_a9e){
},onLoadSuccess:function(row,data){
},onLoadError:function(){
},onBeforeCollapse:function(row){
},onCollapse:function(row){
},onBeforeExpand:function(row){
},onExpand:function(row){
},onClickRow:function(row){
},onDblClickRow:function(row){
},onClickCell:function(_a9f,row){
},onDblClickCell:function(_aa0,row){
},onContextMenu:function(e,row){
},onBeforeEdit:function(row){
},onAfterEdit:function(row,_aa1){
},onCancelEdit:function(row){
},onBeforeCheckNode:function(row,_aa2){
},onCheckNode:function(row,_aa3){
}});
})(jQuery);
(function($){
function _aa4(_aa5){
var opts=$.data(_aa5,"datalist").options;
$(_aa5).datagrid($.extend({},opts,{cls:"datalist"+(opts.lines?" datalist-lines":""),frozenColumns:(opts.frozenColumns&&opts.frozenColumns.length)?opts.frozenColumns:(opts.checkbox?[[{field:"_ck",checkbox:true}]]:undefined),columns:(opts.columns&&opts.columns.length)?opts.columns:[[{field:opts.textField,width:"100%",formatter:function(_aa6,row,_aa7){
return opts.textFormatter?opts.textFormatter(_aa6,row,_aa7):_aa6;
}}]]}));
};
var _aa8=$.extend({},$.fn.datagrid.defaults.view,{render:function(_aa9,_aaa,_aab){
var _aac=$.data(_aa9,"datagrid");
var opts=_aac.options;
if(opts.groupField){
var g=this.groupRows(_aa9,_aac.data.rows);
this.groups=g.groups;
_aac.data.rows=g.rows;
var _aad=[];
for(var i=0;i<g.groups.length;i++){
_aad.push(this.renderGroup.call(this,_aa9,i,g.groups[i],_aab));
}
$(_aaa).html(_aad.join(""));
}else{
$(_aaa).html(this.renderTable(_aa9,0,_aac.data.rows,_aab));
}
},renderGroup:function(_aae,_aaf,_ab0,_ab1){
var _ab2=$.data(_aae,"datagrid");
var opts=_ab2.options;
var _ab3=$(_aae).datagrid("getColumnFields",_ab1);
var _ab4=[];
_ab4.push("<div class=\"datagrid-group\" group-index="+_aaf+">");
if(!_ab1){
_ab4.push("<span class=\"datagrid-group-title\">");
_ab4.push(opts.groupFormatter.call(_aae,_ab0.value,_ab0.rows));
_ab4.push("</span>");
}
_ab4.push("</div>");
_ab4.push(this.renderTable(_aae,_ab0.startIndex,_ab0.rows,_ab1));
return _ab4.join("");
},groupRows:function(_ab5,rows){
var _ab6=$.data(_ab5,"datagrid");
var opts=_ab6.options;
var _ab7=[];
for(var i=0;i<rows.length;i++){
var row=rows[i];
var _ab8=_ab9(row[opts.groupField]);
if(!_ab8){
_ab8={value:row[opts.groupField],rows:[row]};
_ab7.push(_ab8);
}else{
_ab8.rows.push(row);
}
}
var _aba=0;
var rows=[];
for(var i=0;i<_ab7.length;i++){
var _ab8=_ab7[i];
_ab8.startIndex=_aba;
_aba+=_ab8.rows.length;
rows=rows.concat(_ab8.rows);
}
return {groups:_ab7,rows:rows};
function _ab9(_abb){
for(var i=0;i<_ab7.length;i++){
var _abc=_ab7[i];
if(_abc.value==_abb){
return _abc;
}
}
return null;
};
}});
$.fn.datalist=function(_abd,_abe){
if(typeof _abd=="string"){
var _abf=$.fn.datalist.methods[_abd];
if(_abf){
return _abf(this,_abe);
}else{
return this.datagrid(_abd,_abe);
}
}
_abd=_abd||{};
return this.each(function(){
var _ac0=$.data(this,"datalist");
if(_ac0){
$.extend(_ac0.options,_abd);
}else{
var opts=$.extend({},$.fn.datalist.defaults,$.fn.datalist.parseOptions(this),_abd);
opts.columns=$.extend(true,[],opts.columns);
_ac0=$.data(this,"datalist",{options:opts});
}
_aa4(this);
if(!_ac0.options.data){
var data=$.fn.datalist.parseData(this);
if(data.total){
$(this).datalist("loadData",data);
}
}
});
};
$.fn.datalist.methods={options:function(jq){
return $.data(jq[0],"datalist").options;
}};
$.fn.datalist.parseOptions=function(_ac1){
return $.extend({},$.fn.datagrid.parseOptions(_ac1),$.parser.parseOptions(_ac1,["valueField","textField","groupField",{checkbox:"boolean",lines:"boolean"}]));
};
$.fn.datalist.parseData=function(_ac2){
var opts=$.data(_ac2,"datalist").options;
var data={total:0,rows:[]};
$(_ac2).children().each(function(){
var _ac3=$.parser.parseOptions(this,["value","group"]);
var row={};
var html=$(this).html();
row[opts.valueField]=_ac3.value!=undefined?_ac3.value:html;
row[opts.textField]=html;
if(opts.groupField){
row[opts.groupField]=_ac3.group;
}
data.total++;
data.rows.push(row);
});
return data;
};
$.fn.datalist.defaults=$.extend({},$.fn.datagrid.defaults,{fitColumns:true,singleSelect:true,showHeader:false,checkbox:false,lines:false,valueField:"value",textField:"text",groupField:"",view:_aa8,textFormatter:function(_ac4,row){
return _ac4;
},groupFormatter:function(_ac5,rows){
return _ac5;
}});
})(jQuery);
(function($){
$(function(){
$(document).unbind(".combo").bind("mousedown.combo mousewheel.combo",function(e){
var p=$(e.target).closest("span.combo,div.combo-p,div.menu");
if(p.length){
_ac6(p);
return;
}
$("body>div.combo-p>div.combo-panel:visible").panel("close");
});
});
function _ac7(_ac8){
var _ac9=$.data(_ac8,"combo");
var opts=_ac9.options;
if(!_ac9.panel){
_ac9.panel=$("<div class=\"combo-panel\"></div>").appendTo("body");
_ac9.panel.panel({minWidth:opts.panelMinWidth,maxWidth:opts.panelMaxWidth,minHeight:opts.panelMinHeight,maxHeight:opts.panelMaxHeight,doSize:false,closed:true,cls:"combo-p",style:{position:"absolute",zIndex:10},onOpen:function(){
var _aca=$(this).panel("options").comboTarget;
var _acb=$.data(_aca,"combo");
if(_acb){
_acb.options.onShowPanel.call(_aca);
}
},onBeforeClose:function(){
_ac6($(this).parent());
},onClose:function(){
var _acc=$(this).panel("options").comboTarget;
var _acd=$(_acc).data("combo");
if(_acd){
_acd.options.onHidePanel.call(_acc);
}
}});
}
var _ace=$.extend(true,[],opts.icons);
if(opts.hasDownArrow){
_ace.push({iconCls:"combo-arrow",handler:function(e){
_ad3(e.data.target);
}});
}
$(_ac8).addClass("combo-f").textbox($.extend({},opts,{icons:_ace,onChange:function(){
}}));
$(_ac8).attr("comboName",$(_ac8).attr("textboxName"));
_ac9.combo=$(_ac8).next();
_ac9.combo.addClass("combo");
_ac9.panel.unbind(".combo");
for(var _acf in opts.panelEvents){
_ac9.panel.bind(_acf+".combo",{target:_ac8},opts.panelEvents[_acf]);
}
};
function _ad0(_ad1){
var _ad2=$.data(_ad1,"combo");
var opts=_ad2.options;
var p=_ad2.panel;
if(p.is(":visible")){
p.panel("close");
}
if(!opts.cloned){
p.panel("destroy");
}
$(_ad1).textbox("destroy");
};
function _ad3(_ad4){
var _ad5=$.data(_ad4,"combo").panel;
if(_ad5.is(":visible")){
var _ad6=_ad5.combo("combo");
_ad7(_ad6);
if(_ad6!=_ad4){
$(_ad4).combo("showPanel");
}
}else{
var p=$(_ad4).closest("div.combo-p").children(".combo-panel");
$("div.combo-panel:visible").not(_ad5).not(p).panel("close");
$(_ad4).combo("showPanel");
}
$(_ad4).combo("textbox").focus();
};
function _ac6(_ad8){
$(_ad8).find(".combo-f").each(function(){
var p=$(this).combo("panel");
if(p.is(":visible")){
p.panel("close");
}
});
};
function _ad9(e){
var _ada=e.data.target;
var _adb=$.data(_ada,"combo");
var opts=_adb.options;
if(!opts.editable){
_ad3(_ada);
}else{
var p=$(_ada).closest("div.combo-p").children(".combo-panel");
$("div.combo-panel:visible").not(p).each(function(){
var _adc=$(this).combo("combo");
if(_adc!=_ada){
_ad7(_adc);
}
});
}
};
function _add(e){
var _ade=e.data.target;
var t=$(_ade);
var _adf=t.data("combo");
var opts=t.combo("options");
_adf.panel.panel("options").comboTarget=_ade;
switch(e.keyCode){
case 38:
opts.keyHandler.up.call(_ade,e);
break;
case 40:
opts.keyHandler.down.call(_ade,e);
break;
case 37:
opts.keyHandler.left.call(_ade,e);
break;
case 39:
opts.keyHandler.right.call(_ade,e);
break;
case 13:
e.preventDefault();
opts.keyHandler.enter.call(_ade,e);
return false;
case 9:
case 27:
_ad7(_ade);
break;
default:
if(opts.editable){
if(_adf.timer){
clearTimeout(_adf.timer);
}
_adf.timer=setTimeout(function(){
var q=t.combo("getText");
if(_adf.previousText!=q){
_adf.previousText=q;
t.combo("showPanel");
opts.keyHandler.query.call(_ade,q,e);
t.combo("validate");
}
},opts.delay);
}
}
};
function _ae0(e){
var _ae1=e.data.target;
var _ae2=$(_ae1).data("combo");
if(_ae2.timer){
clearTimeout(_ae2.timer);
}
};
function _ae3(_ae4){
var _ae5=$.data(_ae4,"combo");
var _ae6=_ae5.combo;
var _ae7=_ae5.panel;
var opts=$(_ae4).combo("options");
var _ae8=_ae7.panel("options");
_ae8.comboTarget=_ae4;
if(_ae8.closed){
_ae7.panel("panel").show().css({zIndex:($.fn.menu?$.fn.menu.defaults.zIndex++:($.fn.window?$.fn.window.defaults.zIndex++:99)),left:-999999});
_ae7.panel("resize",{width:(opts.panelWidth?opts.panelWidth:_ae6._outerWidth()),height:opts.panelHeight});
_ae7.panel("panel").hide();
_ae7.panel("open");
}
(function(){
if(_ae8.comboTarget==_ae4&&_ae7.is(":visible")){
_ae7.panel("move",{left:_ae9(),top:_aea()});
setTimeout(arguments.callee,200);
}
})();
function _ae9(){
var left=_ae6.offset().left;
if(opts.panelAlign=="right"){
left+=_ae6._outerWidth()-_ae7._outerWidth();
}
if(left+_ae7._outerWidth()>$(window)._outerWidth()+$(document).scrollLeft()){
left=$(window)._outerWidth()+$(document).scrollLeft()-_ae7._outerWidth();
}
if(left<0){
left=0;
}
return left;
};
function _aea(){
var top=_ae6.offset().top+_ae6._outerHeight();
if(top+_ae7._outerHeight()>$(window)._outerHeight()+$(document).scrollTop()){
top=_ae6.offset().top-_ae7._outerHeight();
}
if(top<$(document).scrollTop()){
top=_ae6.offset().top+_ae6._outerHeight();
}
return top;
};
};
function _ad7(_aeb){
var _aec=$.data(_aeb,"combo").panel;
_aec.panel("close");
};
function _aed(_aee,text){
var _aef=$.data(_aee,"combo");
var _af0=$(_aee).textbox("getText");
if(_af0!=text){
$(_aee).textbox("setText",text);
}
_aef.previousText=text;
};
function _af1(_af2){
var _af3=$.data(_af2,"combo");
var opts=_af3.options;
var _af4=$(_af2).next();
var _af5=[];
_af4.find(".textbox-value").each(function(){
_af5.push($(this).val());
});
if(opts.multivalue){
return _af5;
}else{
return _af5.length?_af5[0].split(opts.separator):_af5;
}
};
function _af6(_af7,_af8){
var _af9=$.data(_af7,"combo");
var _afa=_af9.combo;
var opts=$(_af7).combo("options");
if(!$.isArray(_af8)){
_af8=_af8.split(opts.separator);
}
var _afb=_af1(_af7);
_afa.find(".textbox-value").remove();
if(_af8.length){
if(opts.multivalue){
for(var i=0;i<_af8.length;i++){
_afc(_af8[i]);
}
}else{
_afc(_af8.join(opts.separator));
}
}
function _afc(_afd){
var name=$(_af7).attr("textboxName")||"";
var _afe=$("<input type=\"hidden\" class=\"textbox-value\">").appendTo(_afa);
_afe.attr("name",name);
if(opts.disabled){
_afe.attr("disabled","disabled");
}
_afe.val(_afd);
};
var _aff=(function(){
if(_afb.length!=_af8.length){
return true;
}
for(var i=0;i<_af8.length;i++){
if(_af8[i]!=_afb[i]){
return true;
}
}
return false;
})();
if(_aff){
$(_af7).val(_af8.join(opts.separator));
if(opts.multiple){
opts.onChange.call(_af7,_af8,_afb);
}else{
opts.onChange.call(_af7,_af8[0],_afb[0]);
}
$(_af7).closest("form").trigger("_change",[_af7]);
}
};
function _b00(_b01){
var _b02=_af1(_b01);
return _b02[0];
};
function _b03(_b04,_b05){
_af6(_b04,[_b05]);
};
function _b06(_b07){
var opts=$.data(_b07,"combo").options;
var _b08=opts.onChange;
opts.onChange=function(){
};
if(opts.multiple){
_af6(_b07,opts.value?opts.value:[]);
}else{
_b03(_b07,opts.value);
}
opts.onChange=_b08;
};
$.fn.combo=function(_b09,_b0a){
if(typeof _b09=="string"){
var _b0b=$.fn.combo.methods[_b09];
if(_b0b){
return _b0b(this,_b0a);
}else{
return this.textbox(_b09,_b0a);
}
}
_b09=_b09||{};
return this.each(function(){
var _b0c=$.data(this,"combo");
if(_b0c){
$.extend(_b0c.options,_b09);
if(_b09.value!=undefined){
_b0c.options.originalValue=_b09.value;
}
}else{
_b0c=$.data(this,"combo",{options:$.extend({},$.fn.combo.defaults,$.fn.combo.parseOptions(this),_b09),previousText:""});
if(_b0c.options.multiple&&_b0c.options.value==""){
_b0c.options.originalValue=[];
}else{
_b0c.options.originalValue=_b0c.options.value;
}
}
_ac7(this);
_b06(this);
});
};
$.fn.combo.methods={options:function(jq){
var opts=jq.textbox("options");
return $.extend($.data(jq[0],"combo").options,{width:opts.width,height:opts.height,disabled:opts.disabled,readonly:opts.readonly});
},cloneFrom:function(jq,from){
return jq.each(function(){
$(this).textbox("cloneFrom",from);
$.data(this,"combo",{options:$.extend(true,{cloned:true},$(from).combo("options")),combo:$(this).next(),panel:$(from).combo("panel")});
$(this).addClass("combo-f").attr("comboName",$(this).attr("textboxName"));
});
},combo:function(jq){
return jq.closest(".combo-panel").panel("options").comboTarget;
},panel:function(jq){
return $.data(jq[0],"combo").panel;
},destroy:function(jq){
return jq.each(function(){
_ad0(this);
});
},showPanel:function(jq){
return jq.each(function(){
_ae3(this);
});
},hidePanel:function(jq){
return jq.each(function(){
_ad7(this);
});
},clear:function(jq){
return jq.each(function(){
$(this).textbox("setText","");
var opts=$.data(this,"combo").options;
if(opts.multiple){
$(this).combo("setValues",[]);
}else{
$(this).combo("setValue","");
}
});
},reset:function(jq){
return jq.each(function(){
var opts=$.data(this,"combo").options;
if(opts.multiple){
$(this).combo("setValues",opts.originalValue);
}else{
$(this).combo("setValue",opts.originalValue);
}
});
},setText:function(jq,text){
return jq.each(function(){
_aed(this,text);
});
},getValues:function(jq){
return _af1(jq[0]);
},setValues:function(jq,_b0d){
return jq.each(function(){
_af6(this,_b0d);
});
},getValue:function(jq){
return _b00(jq[0]);
},setValue:function(jq,_b0e){
return jq.each(function(){
_b03(this,_b0e);
});
}};
$.fn.combo.parseOptions=function(_b0f){
var t=$(_b0f);
return $.extend({},$.fn.textbox.parseOptions(_b0f),$.parser.parseOptions(_b0f,["separator","panelAlign",{panelWidth:"number",hasDownArrow:"boolean",delay:"number",reversed:"boolean",multivalue:"boolean",selectOnNavigation:"boolean"},{panelMinWidth:"number",panelMaxWidth:"number",panelMinHeight:"number",panelMaxHeight:"number"}]),{panelHeight:(t.attr("panelHeight")=="auto"?"auto":parseInt(t.attr("panelHeight"))||undefined),multiple:(t.attr("multiple")?true:undefined)});
};
$.fn.combo.defaults=$.extend({},$.fn.textbox.defaults,{inputEvents:{click:_ad9,keydown:_add,paste:_add,drop:_add,blur:_ae0},panelEvents:{mousedown:function(e){
e.preventDefault();
e.stopPropagation();
}},panelWidth:null,panelHeight:300,panelMinWidth:null,panelMaxWidth:null,panelMinHeight:null,panelMaxHeight:null,panelAlign:"left",reversed:false,multiple:false,multivalue:true,selectOnNavigation:true,separator:",",hasDownArrow:true,delay:200,keyHandler:{up:function(e){
},down:function(e){
},left:function(e){
},right:function(e){
},enter:function(e){
},query:function(q,e){
}},onShowPanel:function(){
},onHidePanel:function(){
},onChange:function(_b10,_b11){
}});
})(jQuery);
(function($){
function _b12(_b13,_b14){
var _b15=$.data(_b13,"combobox");
return $.easyui.indexOfArray(_b15.data,_b15.options.valueField,_b14);
};
function _b16(_b17,_b18){
var opts=$.data(_b17,"combobox").options;
var _b19=$(_b17).combo("panel");
var item=opts.finder.getEl(_b17,_b18);
if(item.length){
if(item.position().top<=0){
var h=_b19.scrollTop()+item.position().top;
_b19.scrollTop(h);
}else{
if(item.position().top+item.outerHeight()>_b19.height()){
var h=_b19.scrollTop()+item.position().top+item.outerHeight()-_b19.height();
_b19.scrollTop(h);
}
}
}
_b19.triggerHandler("scroll");
};
function nav(_b1a,dir){
var opts=$.data(_b1a,"combobox").options;
var _b1b=$(_b1a).combobox("panel");
var item=_b1b.children("div.combobox-item-hover");
if(!item.length){
item=_b1b.children("div.combobox-item-selected");
}
item.removeClass("combobox-item-hover");
var _b1c="div.combobox-item:visible:not(.combobox-item-disabled):first";
var _b1d="div.combobox-item:visible:not(.combobox-item-disabled):last";
if(!item.length){
item=_b1b.children(dir=="next"?_b1c:_b1d);
}else{
if(dir=="next"){
item=item.nextAll(_b1c);
if(!item.length){
item=_b1b.children(_b1c);
}
}else{
item=item.prevAll(_b1c);
if(!item.length){
item=_b1b.children(_b1d);
}
}
}
if(item.length){
item.addClass("combobox-item-hover");
var row=opts.finder.getRow(_b1a,item);
if(row){
$(_b1a).combobox("scrollTo",row[opts.valueField]);
if(opts.selectOnNavigation){
_b1e(_b1a,row[opts.valueField]);
}
}
}
};
function _b1e(_b1f,_b20,_b21){
var opts=$.data(_b1f,"combobox").options;
var _b22=$(_b1f).combo("getValues");
if($.inArray(_b20+"",_b22)==-1){
if(opts.multiple){
_b22.push(_b20);
}else{
_b22=[_b20];
}
_b23(_b1f,_b22,_b21);
}
};
function _b24(_b25,_b26){
var opts=$.data(_b25,"combobox").options;
var _b27=$(_b25).combo("getValues");
var _b28=$.inArray(_b26+"",_b27);
if(_b28>=0){
_b27.splice(_b28,1);
_b23(_b25,_b27);
}
};
function _b23(_b29,_b2a,_b2b){
var opts=$.data(_b29,"combobox").options;
var _b2c=$(_b29).combo("panel");
if(!$.isArray(_b2a)){
_b2a=_b2a.split(opts.separator);
}
if(!opts.multiple){
_b2a=_b2a.length?[_b2a[0]]:[""];
}
var _b2d=$(_b29).combo("getValues");
if(_b2c.is(":visible")){
_b2c.find(".combobox-item-selected").each(function(){
var row=opts.finder.getRow(_b29,$(this));
if(row){
if($.easyui.indexOfArray(_b2d,row[opts.valueField])==-1){
$(this).removeClass("combobox-item-selected");
}
}
});
}
$.map(_b2d,function(v){
if($.easyui.indexOfArray(_b2a,v)==-1){
var el=opts.finder.getEl(_b29,v);
if(el.hasClass("combobox-item-selected")){
el.removeClass("combobox-item-selected");
opts.onUnselect.call(_b29,opts.finder.getRow(_b29,v));
}
}
});
var _b2e=null;
var vv=[],ss=[];
for(var i=0;i<_b2a.length;i++){
var v=_b2a[i];
var s=v;
var row=opts.finder.getRow(_b29,v);
if(row){
s=row[opts.textField];
_b2e=row;
var el=opts.finder.getEl(_b29,v);
if(!el.hasClass("combobox-item-selected")){
el.addClass("combobox-item-selected");
opts.onSelect.call(_b29,row);
}
}else{
s=_b2f(v,opts.mappingRows)||v;
}
vv.push(v);
ss.push(s);
}
if(!_b2b){
$(_b29).combo("setText",ss.join(opts.separator));
}
if(opts.showItemIcon){
var tb=$(_b29).combobox("textbox");
tb.removeClass("textbox-bgicon "+opts.textboxIconCls);
if(_b2e&&_b2e.iconCls){
tb.addClass("textbox-bgicon "+_b2e.iconCls);
opts.textboxIconCls=_b2e.iconCls;
}
}
$(_b29).combo("setValues",vv);
_b2c.triggerHandler("scroll");
function _b2f(_b30,a){
var item=$.easyui.getArrayItem(a,opts.valueField,_b30);
return item?item[opts.textField]:undefined;
};
};
function _b31(_b32,data,_b33){
var _b34=$.data(_b32,"combobox");
var opts=_b34.options;
_b34.data=opts.loadFilter.call(_b32,data);
opts.view.render.call(opts.view,_b32,$(_b32).combo("panel"),_b34.data);
var vv=$(_b32).combobox("getValues");
$.easyui.forEach(_b34.data,false,function(row){
if(row["selected"]){
$.easyui.addArrayItem(vv,row[opts.valueField]+"");
}
});
if(opts.multiple){
_b23(_b32,vv,_b33);
}else{
_b23(_b32,vv.length?[vv[vv.length-1]]:[],_b33);
}
opts.onLoadSuccess.call(_b32,data);
};
function _b35(_b36,url,_b37,_b38){
var opts=$.data(_b36,"combobox").options;
if(url){
opts.url=url;
}
_b37=$.extend({},opts.queryParams,_b37||{});
if(opts.onBeforeLoad.call(_b36,_b37)==false){
return;
}
opts.loader.call(_b36,_b37,function(data){
_b31(_b36,data,_b38);
},function(){
opts.onLoadError.apply(this,arguments);
});
};
function _b39(_b3a,q){
var _b3b=$.data(_b3a,"combobox");
var opts=_b3b.options;
var _b3c=$();
var qq=opts.multiple?q.split(opts.separator):[q];
if(opts.mode=="remote"){
_b3d(qq);
_b35(_b3a,null,{q:q},true);
}else{
var _b3e=$(_b3a).combo("panel");
_b3e.find(".combobox-item-hover").removeClass("combobox-item-hover");
_b3e.find(".combobox-item,.combobox-group").hide();
var data=_b3b.data;
var vv=[];
$.map(qq,function(q){
q=$.trim(q);
var _b3f=q;
var _b40=undefined;
_b3c=$();
for(var i=0;i<data.length;i++){
var row=data[i];
if(opts.filter.call(_b3a,q,row)){
var v=row[opts.valueField];
var s=row[opts.textField];
var g=row[opts.groupField];
var item=opts.finder.getEl(_b3a,v).show();
if(s.toLowerCase()==q.toLowerCase()){
_b3f=v;
if(opts.reversed){
_b3c=item;
}else{
_b1e(_b3a,v,true);
}
}
if(opts.groupField&&_b40!=g){
opts.finder.getGroupEl(_b3a,g).show();
_b40=g;
}
}
}
vv.push(_b3f);
});
_b3d(vv);
}
function _b3d(vv){
if(opts.reversed){
_b3c.addClass("combobox-item-hover");
}else{
_b23(_b3a,opts.multiple?(q?vv:[]):vv,true);
}
};
};
function _b41(_b42){
var t=$(_b42);
var opts=t.combobox("options");
var _b43=t.combobox("panel");
var item=_b43.children("div.combobox-item-hover");
if(item.length){
item.removeClass("combobox-item-hover");
var row=opts.finder.getRow(_b42,item);
var _b44=row[opts.valueField];
if(opts.multiple){
if(item.hasClass("combobox-item-selected")){
t.combobox("unselect",_b44);
}else{
t.combobox("select",_b44);
}
}else{
t.combobox("select",_b44);
}
}
var vv=[];
$.map(t.combobox("getValues"),function(v){
if(_b12(_b42,v)>=0){
vv.push(v);
}
});
t.combobox("setValues",vv);
if(!opts.multiple){
t.combobox("hidePanel");
}
};
function _b45(_b46){
var _b47=$.data(_b46,"combobox");
var opts=_b47.options;
$(_b46).addClass("combobox-f");
$(_b46).combo($.extend({},opts,{onShowPanel:function(){
$(this).combo("panel").find("div.combobox-item:hidden,div.combobox-group:hidden").show();
_b23(this,$(this).combobox("getValues"),true);
$(this).combobox("scrollTo",$(this).combobox("getValue"));
opts.onShowPanel.call(this);
}}));
};
function _b48(e){
$(this).children("div.combobox-item-hover").removeClass("combobox-item-hover");
var item=$(e.target).closest("div.combobox-item");
if(!item.hasClass("combobox-item-disabled")){
item.addClass("combobox-item-hover");
}
e.stopPropagation();
};
function _b49(e){
$(e.target).closest("div.combobox-item").removeClass("combobox-item-hover");
e.stopPropagation();
};
function _b4a(e){
var _b4b=$(this).panel("options").comboTarget;
if(!_b4b){
return;
}
var opts=$(_b4b).combobox("options");
var item=$(e.target).closest("div.combobox-item");
if(!item.length||item.hasClass("combobox-item-disabled")){
return;
}
var row=opts.finder.getRow(_b4b,item);
if(!row){
return;
}
if(opts.blurTimer){
clearTimeout(opts.blurTimer);
opts.blurTimer=null;
}
opts.onClick.call(_b4b,row);
var _b4c=row[opts.valueField];
if(opts.multiple){
if(item.hasClass("combobox-item-selected")){
_b24(_b4b,_b4c);
}else{
_b1e(_b4b,_b4c);
}
}else{
$(_b4b).combobox("setValue",_b4c).combobox("hidePanel");
}
e.stopPropagation();
};
function _b4d(e){
var _b4e=$(this).panel("options").comboTarget;
if(!_b4e){
return;
}
var opts=$(_b4e).combobox("options");
if(opts.groupPosition=="sticky"){
var _b4f=$(this).children(".combobox-stick");
if(!_b4f.length){
_b4f=$("<div class=\"combobox-stick\"></div>").appendTo(this);
}
_b4f.hide();
var _b50=$(_b4e).data("combobox");
$(this).children(".combobox-group:visible").each(function(){
var g=$(this);
var _b51=opts.finder.getGroup(_b4e,g);
var _b52=_b50.data[_b51.startIndex+_b51.count-1];
var last=opts.finder.getEl(_b4e,_b52[opts.valueField]);
if(g.position().top<0&&last.position().top>0){
_b4f.show().html(g.html());
return false;
}
});
}
};
$.fn.combobox=function(_b53,_b54){
if(typeof _b53=="string"){
var _b55=$.fn.combobox.methods[_b53];
if(_b55){
return _b55(this,_b54);
}else{
return this.combo(_b53,_b54);
}
}
_b53=_b53||{};
return this.each(function(){
var _b56=$.data(this,"combobox");
if(_b56){
$.extend(_b56.options,_b53);
}else{
_b56=$.data(this,"combobox",{options:$.extend({},$.fn.combobox.defaults,$.fn.combobox.parseOptions(this),_b53),data:[]});
}
_b45(this);
if(_b56.options.data){
_b31(this,_b56.options.data);
}else{
var data=$.fn.combobox.parseData(this);
if(data.length){
_b31(this,data);
}
}
_b35(this);
});
};
$.fn.combobox.methods={options:function(jq){
var _b57=jq.combo("options");
return $.extend($.data(jq[0],"combobox").options,{width:_b57.width,height:_b57.height,originalValue:_b57.originalValue,disabled:_b57.disabled,readonly:_b57.readonly});
},cloneFrom:function(jq,from){
return jq.each(function(){
$(this).combo("cloneFrom",from);
$.data(this,"combobox",$(from).data("combobox"));
$(this).addClass("combobox-f").attr("comboboxName",$(this).attr("textboxName"));
});
},getData:function(jq){
return $.data(jq[0],"combobox").data;
},setValues:function(jq,_b58){
return jq.each(function(){
var opts=$(this).combobox("options");
if($.isArray(_b58)){
_b58=$.map(_b58,function(_b59){
if(_b59&&typeof _b59=="object"){
$.easyui.addArrayItem(opts.mappingRows,opts.valueField,_b59);
return _b59[opts.valueField];
}else{
return _b59;
}
});
}
_b23(this,_b58);
});
},setValue:function(jq,_b5a){
return jq.each(function(){
$(this).combobox("setValues",$.isArray(_b5a)?_b5a:[_b5a]);
});
},clear:function(jq){
return jq.each(function(){
_b23(this,[]);
});
},reset:function(jq){
return jq.each(function(){
var opts=$(this).combobox("options");
if(opts.multiple){
$(this).combobox("setValues",opts.originalValue);
}else{
$(this).combobox("setValue",opts.originalValue);
}
});
},loadData:function(jq,data){
return jq.each(function(){
_b31(this,data);
});
},reload:function(jq,url){
return jq.each(function(){
if(typeof url=="string"){
_b35(this,url);
}else{
if(url){
var opts=$(this).combobox("options");
opts.queryParams=url;
}
_b35(this);
}
});
},select:function(jq,_b5b){
return jq.each(function(){
_b1e(this,_b5b);
});
},unselect:function(jq,_b5c){
return jq.each(function(){
_b24(this,_b5c);
});
},scrollTo:function(jq,_b5d){
return jq.each(function(){
_b16(this,_b5d);
});
}};
$.fn.combobox.parseOptions=function(_b5e){
var t=$(_b5e);
return $.extend({},$.fn.combo.parseOptions(_b5e),$.parser.parseOptions(_b5e,["valueField","textField","groupField","groupPosition","mode","method","url",{showItemIcon:"boolean",limitToList:"boolean"}]));
};
$.fn.combobox.parseData=function(_b5f){
var data=[];
var opts=$(_b5f).combobox("options");
$(_b5f).children().each(function(){
if(this.tagName.toLowerCase()=="optgroup"){
var _b60=$(this).attr("label");
$(this).children().each(function(){
_b61(this,_b60);
});
}else{
_b61(this);
}
});
return data;
function _b61(el,_b62){
var t=$(el);
var row={};
row[opts.valueField]=t.attr("value")!=undefined?t.attr("value"):t.text();
row[opts.textField]=t.text();
row["iconCls"]=$.parser.parseOptions(el,["iconCls"]).iconCls;
row["selected"]=t.is(":selected");
row["disabled"]=t.is(":disabled");
if(_b62){
opts.groupField=opts.groupField||"group";
row[opts.groupField]=_b62;
}
data.push(row);
};
};
var _b63=0;
var _b64={render:function(_b65,_b66,data){
var _b67=$.data(_b65,"combobox");
var opts=_b67.options;
_b63++;
_b67.itemIdPrefix="_easyui_combobox_i"+_b63;
_b67.groupIdPrefix="_easyui_combobox_g"+_b63;
_b67.groups=[];
var dd=[];
var _b68=undefined;
for(var i=0;i<data.length;i++){
var row=data[i];
var v=row[opts.valueField]+"";
var s=row[opts.textField];
var g=row[opts.groupField];
if(g){
if(_b68!=g){
_b68=g;
_b67.groups.push({value:g,startIndex:i,count:1});
dd.push("<div id=\""+(_b67.groupIdPrefix+"_"+(_b67.groups.length-1))+"\" class=\"combobox-group\">");
dd.push(opts.groupFormatter?opts.groupFormatter.call(_b65,g):g);
dd.push("</div>");
}else{
_b67.groups[_b67.groups.length-1].count++;
}
}else{
_b68=undefined;
}
var cls="combobox-item"+(row.disabled?" combobox-item-disabled":"")+(g?" combobox-gitem":"");
dd.push("<div id=\""+(_b67.itemIdPrefix+"_"+i)+"\" class=\""+cls+"\">");
if(opts.showItemIcon&&row.iconCls){
dd.push("<span class=\"combobox-icon "+row.iconCls+"\"></span>");
}
dd.push(opts.formatter?opts.formatter.call(_b65,row):s);
dd.push("</div>");
}
$(_b66).html(dd.join(""));
}};
$.fn.combobox.defaults=$.extend({},$.fn.combo.defaults,{valueField:"value",textField:"text",groupPosition:"static",groupField:null,groupFormatter:function(_b69){
return _b69;
},mode:"local",method:"post",url:null,data:null,queryParams:{},showItemIcon:false,limitToList:false,unselectedValues:[],mappingRows:[],view:_b64,keyHandler:{up:function(e){
nav(this,"prev");
e.preventDefault();
},down:function(e){
nav(this,"next");
e.preventDefault();
},left:function(e){
},right:function(e){
},enter:function(e){
_b41(this);
},query:function(q,e){
_b39(this,q);
}},inputEvents:$.extend({},$.fn.combo.defaults.inputEvents,{blur:function(e){
$.fn.combo.defaults.inputEvents.blur(e);
var _b6a=e.data.target;
var opts=$(_b6a).combobox("options");
if(opts.reversed||opts.limitToList){
if(opts.blurTimer){
clearTimeout(opts.blurTimer);
}
opts.blurTimer=setTimeout(function(){
var _b6b=$(_b6a).parent().length;
if(_b6b){
if(opts.reversed){
$(_b6a).combobox("setValues",$(_b6a).combobox("getValues"));
}else{
if(opts.limitToList){
var vv=[];
$.map($(_b6a).combobox("getValues"),function(v){
var _b6c=$.easyui.indexOfArray($(_b6a).combobox("getData"),opts.valueField,v);
if(_b6c>=0){
vv.push(v);
}
});
$(_b6a).combobox("setValues",vv);
}
}
opts.blurTimer=null;
}
},50);
}
}}),panelEvents:{mouseover:_b48,mouseout:_b49,mousedown:function(e){
e.preventDefault();
e.stopPropagation();
},click:_b4a,scroll:_b4d},filter:function(q,row){
var opts=$(this).combobox("options");
return row[opts.textField].toLowerCase().indexOf(q.toLowerCase())>=0;
},formatter:function(row){
var opts=$(this).combobox("options");
return row[opts.textField];
},loader:function(_b6d,_b6e,_b6f){
var opts=$(this).combobox("options");
if(!opts.url){
return false;
}
$.ajax({type:opts.method,url:opts.url,data:_b6d,dataType:"json",success:function(data){
_b6e(data);
},error:function(){
_b6f.apply(this,arguments);
}});
},loadFilter:function(data){
return data;
},finder:{getEl:function(_b70,_b71){
var _b72=_b12(_b70,_b71);
var id=$.data(_b70,"combobox").itemIdPrefix+"_"+_b72;
return $("#"+id);
},getGroupEl:function(_b73,_b74){
var _b75=$.data(_b73,"combobox");
var _b76=$.easyui.indexOfArray(_b75.groups,"value",_b74);
var id=_b75.groupIdPrefix+"_"+_b76;
return $("#"+id);
},getGroup:function(_b77,p){
var _b78=$.data(_b77,"combobox");
var _b79=p.attr("id").substr(_b78.groupIdPrefix.length+1);
return _b78.groups[parseInt(_b79)];
},getRow:function(_b7a,p){
var _b7b=$.data(_b7a,"combobox");
var _b7c=(p instanceof $)?p.attr("id").substr(_b7b.itemIdPrefix.length+1):_b12(_b7a,p);
return _b7b.data[parseInt(_b7c)];
}},onBeforeLoad:function(_b7d){
},onLoadSuccess:function(data){
},onLoadError:function(){
},onSelect:function(_b7e){
},onUnselect:function(_b7f){
},onClick:function(_b80){
}});
})(jQuery);
(function($){
function _b81(_b82){
var _b83=$.data(_b82,"combotree");
var opts=_b83.options;
var tree=_b83.tree;
$(_b82).addClass("combotree-f");
$(_b82).combo($.extend({},opts,{onShowPanel:function(){
if(opts.editable){
tree.tree("doFilter","");
}
opts.onShowPanel.call(this);
}}));
var _b84=$(_b82).combo("panel");
if(!tree){
tree=$("<ul></ul>").appendTo(_b84);
_b83.tree=tree;
}
tree.tree($.extend({},opts,{checkbox:opts.multiple,onLoadSuccess:function(node,data){
var _b85=$(_b82).combotree("getValues");
if(opts.multiple){
$.map(tree.tree("getChecked"),function(node){
$.easyui.addArrayItem(_b85,node.id);
});
}
_b8a(_b82,_b85,_b83.remainText);
opts.onLoadSuccess.call(this,node,data);
},onClick:function(node){
if(opts.multiple){
$(this).tree(node.checked?"uncheck":"check",node.target);
}else{
$(_b82).combo("hidePanel");
}
_b83.remainText=false;
_b87(_b82);
opts.onClick.call(this,node);
},onCheck:function(node,_b86){
_b83.remainText=false;
_b87(_b82);
opts.onCheck.call(this,node,_b86);
}}));
};
function _b87(_b88){
var _b89=$.data(_b88,"combotree");
var opts=_b89.options;
var tree=_b89.tree;
var vv=[];
if(opts.multiple){
vv=$.map(tree.tree("getChecked"),function(node){
return node.id;
});
}else{
var node=tree.tree("getSelected");
if(node){
vv.push(node.id);
}
}
vv=vv.concat(opts.unselectedValues);
_b8a(_b88,vv,_b89.remainText);
};
function _b8a(_b8b,_b8c,_b8d){
var _b8e=$.data(_b8b,"combotree");
var opts=_b8e.options;
var tree=_b8e.tree;
var _b8f=tree.tree("options");
var _b90=_b8f.onBeforeCheck;
var _b91=_b8f.onCheck;
var _b92=_b8f.onSelect;
_b8f.onBeforeCheck=_b8f.onCheck=_b8f.onSelect=function(){
};
if(!$.isArray(_b8c)){
_b8c=_b8c.split(opts.separator);
}
if(!opts.multiple){
_b8c=_b8c.length?[_b8c[0]]:[""];
}
var vv=$.map(_b8c,function(_b93){
return String(_b93);
});
tree.find("div.tree-node-selected").removeClass("tree-node-selected");
$.map(tree.tree("getChecked"),function(node){
if($.inArray(String(node.id),vv)==-1){
tree.tree("uncheck",node.target);
}
});
var ss=[];
opts.unselectedValues=[];
$.map(vv,function(v){
var node=tree.tree("find",v);
if(node){
tree.tree("check",node.target).tree("select",node.target);
ss.push(_b94(node));
}else{
ss.push(_b95(v,opts.mappingRows)||v);
opts.unselectedValues.push(v);
}
});
if(opts.multiple){
$.map(tree.tree("getChecked"),function(node){
var id=String(node.id);
if($.inArray(id,vv)==-1){
vv.push(id);
ss.push(_b94(node));
}
});
}
_b8f.onBeforeCheck=_b90;
_b8f.onCheck=_b91;
_b8f.onSelect=_b92;
if(!_b8d){
var s=ss.join(opts.separator);
if($(_b8b).combo("getText")!=s){
$(_b8b).combo("setText",s);
}
}
$(_b8b).combo("setValues",vv);
function _b95(_b96,a){
var item=$.easyui.getArrayItem(a,"id",_b96);
return item?_b94(item):undefined;
};
function _b94(node){
return node[opts.textField||""]||node.text;
};
};
function _b97(_b98,q){
var _b99=$.data(_b98,"combotree");
var opts=_b99.options;
var tree=_b99.tree;
_b99.remainText=true;
tree.tree("doFilter",opts.multiple?q.split(opts.separator):q);
};
function _b9a(_b9b){
var _b9c=$.data(_b9b,"combotree");
_b9c.remainText=false;
$(_b9b).combotree("setValues",$(_b9b).combotree("getValues"));
$(_b9b).combotree("hidePanel");
};
$.fn.combotree=function(_b9d,_b9e){
if(typeof _b9d=="string"){
var _b9f=$.fn.combotree.methods[_b9d];
if(_b9f){
return _b9f(this,_b9e);
}else{
return this.combo(_b9d,_b9e);
}
}
_b9d=_b9d||{};
return this.each(function(){
var _ba0=$.data(this,"combotree");
if(_ba0){
$.extend(_ba0.options,_b9d);
}else{
$.data(this,"combotree",{options:$.extend({},$.fn.combotree.defaults,$.fn.combotree.parseOptions(this),_b9d)});
}
_b81(this);
});
};
$.fn.combotree.methods={options:function(jq){
var _ba1=jq.combo("options");
return $.extend($.data(jq[0],"combotree").options,{width:_ba1.width,height:_ba1.height,originalValue:_ba1.originalValue,disabled:_ba1.disabled,readonly:_ba1.readonly});
},clone:function(jq,_ba2){
var t=jq.combo("clone",_ba2);
t.data("combotree",{options:$.extend(true,{},jq.combotree("options")),tree:jq.combotree("tree")});
return t;
},tree:function(jq){
return $.data(jq[0],"combotree").tree;
},loadData:function(jq,data){
return jq.each(function(){
var opts=$.data(this,"combotree").options;
opts.data=data;
var tree=$.data(this,"combotree").tree;
tree.tree("loadData",data);
});
},reload:function(jq,url){
return jq.each(function(){
var opts=$.data(this,"combotree").options;
var tree=$.data(this,"combotree").tree;
if(url){
opts.url=url;
}
tree.tree({url:opts.url});
});
},setValues:function(jq,_ba3){
return jq.each(function(){
var opts=$(this).combotree("options");
if($.isArray(_ba3)){
_ba3=$.map(_ba3,function(_ba4){
if(_ba4&&typeof _ba4=="object"){
$.easyui.addArrayItem(opts.mappingRows,"id",_ba4);
return _ba4.id;
}else{
return _ba4;
}
});
}
_b8a(this,_ba3);
});
},setValue:function(jq,_ba5){
return jq.each(function(){
$(this).combotree("setValues",$.isArray(_ba5)?_ba5:[_ba5]);
});
},clear:function(jq){
return jq.each(function(){
$(this).combotree("setValues",[]);
});
},reset:function(jq){
return jq.each(function(){
var opts=$(this).combotree("options");
if(opts.multiple){
$(this).combotree("setValues",opts.originalValue);
}else{
$(this).combotree("setValue",opts.originalValue);
}
});
}};
$.fn.combotree.parseOptions=function(_ba6){
return $.extend({},$.fn.combo.parseOptions(_ba6),$.fn.tree.parseOptions(_ba6));
};
$.fn.combotree.defaults=$.extend({},$.fn.combo.defaults,$.fn.tree.defaults,{editable:false,textField:null,unselectedValues:[],mappingRows:[],keyHandler:{up:function(e){
},down:function(e){
},left:function(e){
},right:function(e){
},enter:function(e){
_b9a(this);
},query:function(q,e){
_b97(this,q);
}}});
})(jQuery);
(function($){
function _ba7(_ba8){
var _ba9=$.data(_ba8,"combogrid");
var opts=_ba9.options;
var grid=_ba9.grid;
$(_ba8).addClass("combogrid-f").combo($.extend({},opts,{onShowPanel:function(){
_bc0(this,$(this).combogrid("getValues"),true);
var p=$(this).combogrid("panel");
var _baa=p.outerHeight()-p.height();
var _bab=p._size("minHeight");
var _bac=p._size("maxHeight");
var dg=$(this).combogrid("grid");
dg.datagrid("resize",{width:"100%",height:(isNaN(parseInt(opts.panelHeight))?"auto":"100%"),minHeight:(_bab?_bab-_baa:""),maxHeight:(_bac?_bac-_baa:"")});
var row=dg.datagrid("getSelected");
if(row){
dg.datagrid("scrollTo",dg.datagrid("getRowIndex",row));
}
opts.onShowPanel.call(this);
}}));
var _bad=$(_ba8).combo("panel");
if(!grid){
grid=$("<table></table>").appendTo(_bad);
_ba9.grid=grid;
}
grid.datagrid($.extend({},opts,{border:false,singleSelect:(!opts.multiple),onLoadSuccess:_bae,onClickRow:_baf,onSelect:_bb0("onSelect"),onUnselect:_bb0("onUnselect"),onSelectAll:_bb0("onSelectAll"),onUnselectAll:_bb0("onUnselectAll")}));
function _bb1(dg){
return $(dg).closest(".combo-panel").panel("options").comboTarget||_ba8;
};
function _bae(data){
var _bb2=_bb1(this);
var _bb3=$(_bb2).data("combogrid");
var opts=_bb3.options;
var _bb4=$(_bb2).combo("getValues");
_bc0(_bb2,_bb4,_bb3.remainText);
opts.onLoadSuccess.call(this,data);
};
function _baf(_bb5,row){
var _bb6=_bb1(this);
var _bb7=$(_bb6).data("combogrid");
var opts=_bb7.options;
_bb7.remainText=false;
_bb8.call(this);
if(!opts.multiple){
$(_bb6).combo("hidePanel");
}
opts.onClickRow.call(this,_bb5,row);
};
function _bb0(_bb9){
return function(_bba,row){
var _bbb=_bb1(this);
var opts=$(_bbb).combogrid("options");
if(_bb9=="onUnselectAll"){
if(opts.multiple){
_bb8.call(this);
}
}else{
_bb8.call(this);
}
opts[_bb9].call(this,_bba,row);
};
};
function _bb8(){
var dg=$(this);
var _bbc=_bb1(dg);
var _bbd=$(_bbc).data("combogrid");
var opts=_bbd.options;
var vv=$.map(dg.datagrid("getSelections"),function(row){
return row[opts.idField];
});
vv=vv.concat(opts.unselectedValues);
var _bbe=dg.data("datagrid").dc.body2;
var _bbf=_bbe.scrollTop();
_bc0(_bbc,vv,_bbd.remainText);
_bbe.scrollTop(_bbf);
};
};
function nav(_bc1,dir){
var _bc2=$.data(_bc1,"combogrid");
var opts=_bc2.options;
var grid=_bc2.grid;
var _bc3=grid.datagrid("getRows").length;
if(!_bc3){
return;
}
var tr=opts.finder.getTr(grid[0],null,"highlight");
if(!tr.length){
tr=opts.finder.getTr(grid[0],null,"selected");
}
var _bc4;
if(!tr.length){
_bc4=(dir=="next"?0:_bc3-1);
}else{
var _bc4=parseInt(tr.attr("datagrid-row-index"));
_bc4+=(dir=="next"?1:-1);
if(_bc4<0){
_bc4=_bc3-1;
}
if(_bc4>=_bc3){
_bc4=0;
}
}
grid.datagrid("highlightRow",_bc4);
if(opts.selectOnNavigation){
_bc2.remainText=false;
grid.datagrid("selectRow",_bc4);
}
};
function _bc0(_bc5,_bc6,_bc7){
var _bc8=$.data(_bc5,"combogrid");
var opts=_bc8.options;
var grid=_bc8.grid;
var _bc9=$(_bc5).combo("getValues");
var _bca=$(_bc5).combo("options");
var _bcb=_bca.onChange;
_bca.onChange=function(){
};
var _bcc=grid.datagrid("options");
var _bcd=_bcc.onSelect;
var _bce=_bcc.onUnselectAll;
_bcc.onSelect=_bcc.onUnselectAll=function(){
};
if(!$.isArray(_bc6)){
_bc6=_bc6.split(opts.separator);
}
if(!opts.multiple){
_bc6=_bc6.length?[_bc6[0]]:[""];
}
var vv=$.map(_bc6,function(_bcf){
return String(_bcf);
});
vv=$.grep(vv,function(v,_bd0){
return _bd0===$.inArray(v,vv);
});
var _bd1=$.grep(grid.datagrid("getSelections"),function(row,_bd2){
return $.inArray(String(row[opts.idField]),vv)>=0;
});
grid.datagrid("clearSelections");
grid.data("datagrid").selectedRows=_bd1;
var ss=[];
opts.unselectedValues=[];
$.map(vv,function(v){
var _bd3=grid.datagrid("getRowIndex",v);
if(_bd3>=0){
grid.datagrid("selectRow",_bd3);
}else{
opts.unselectedValues.push(v);
}
ss.push(_bd4(v,grid.datagrid("getRows"))||_bd4(v,_bd1)||_bd4(v,opts.mappingRows)||v);
});
$(_bc5).combo("setValues",_bc9);
_bca.onChange=_bcb;
_bcc.onSelect=_bcd;
_bcc.onUnselectAll=_bce;
if(!_bc7){
var s=ss.join(opts.separator);
if($(_bc5).combo("getText")!=s){
$(_bc5).combo("setText",s);
}
}
$(_bc5).combo("setValues",_bc6);
function _bd4(_bd5,a){
var item=$.easyui.getArrayItem(a,opts.idField,_bd5);
return item?item[opts.textField]:undefined;
};
};
function _bd6(_bd7,q){
var _bd8=$.data(_bd7,"combogrid");
var opts=_bd8.options;
var grid=_bd8.grid;
_bd8.remainText=true;
var qq=opts.multiple?q.split(opts.separator):[q];
qq=$.grep(qq,function(q){
return $.trim(q)!="";
});
if(opts.mode=="remote"){
_bd9(qq);
grid.datagrid("load",$.extend({},opts.queryParams,{q:q}));
}else{
grid.datagrid("highlightRow",-1);
var rows=grid.datagrid("getRows");
var vv=[];
$.map(qq,function(q){
q=$.trim(q);
var _bda=q;
_bdb(opts.mappingRows,q);
_bdb(grid.datagrid("getSelections"),q);
var _bdc=_bdb(rows,q);
if(_bdc>=0){
if(opts.reversed){
grid.datagrid("highlightRow",_bdc);
}
}else{
$.map(rows,function(row,i){
if(opts.filter.call(_bd7,q,row)){
grid.datagrid("highlightRow",i);
}
});
}
});
_bd9(vv);
}
function _bdb(rows,q){
for(var i=0;i<rows.length;i++){
var row=rows[i];
if((row[opts.textField]||"").toLowerCase()==q.toLowerCase()){
vv.push(row[opts.idField]);
return i;
}
}
return -1;
};
function _bd9(vv){
if(!opts.reversed){
_bc0(_bd7,vv,true);
}
};
};
function _bdd(_bde){
var _bdf=$.data(_bde,"combogrid");
var opts=_bdf.options;
var grid=_bdf.grid;
var tr=opts.finder.getTr(grid[0],null,"highlight");
_bdf.remainText=false;
if(tr.length){
var _be0=parseInt(tr.attr("datagrid-row-index"));
if(opts.multiple){
if(tr.hasClass("datagrid-row-selected")){
grid.datagrid("unselectRow",_be0);
}else{
grid.datagrid("selectRow",_be0);
}
}else{
grid.datagrid("selectRow",_be0);
}
}
var vv=[];
$.map(grid.datagrid("getSelections"),function(row){
vv.push(row[opts.idField]);
});
$.map(opts.unselectedValues,function(v){
if($.easyui.indexOfArray(opts.mappingRows,opts.idField,v)>=0){
$.easyui.addArrayItem(vv,v);
}
});
$(_bde).combogrid("setValues",vv);
if(!opts.multiple){
$(_bde).combogrid("hidePanel");
}
};
$.fn.combogrid=function(_be1,_be2){
if(typeof _be1=="string"){
var _be3=$.fn.combogrid.methods[_be1];
if(_be3){
return _be3(this,_be2);
}else{
return this.combo(_be1,_be2);
}
}
_be1=_be1||{};
return this.each(function(){
var _be4=$.data(this,"combogrid");
if(_be4){
$.extend(_be4.options,_be1);
}else{
_be4=$.data(this,"combogrid",{options:$.extend({},$.fn.combogrid.defaults,$.fn.combogrid.parseOptions(this),_be1)});
}
_ba7(this);
});
};
$.fn.combogrid.methods={options:function(jq){
var _be5=jq.combo("options");
return $.extend($.data(jq[0],"combogrid").options,{width:_be5.width,height:_be5.height,originalValue:_be5.originalValue,disabled:_be5.disabled,readonly:_be5.readonly});
},cloneFrom:function(jq,from){
return jq.each(function(){
$(this).combo("cloneFrom",from);
$.data(this,"combogrid",{options:$.extend(true,{cloned:true},$(from).combogrid("options")),combo:$(this).next(),panel:$(from).combo("panel"),grid:$(from).combogrid("grid")});
});
},grid:function(jq){
return $.data(jq[0],"combogrid").grid;
},setValues:function(jq,_be6){
return jq.each(function(){
var opts=$(this).combogrid("options");
if($.isArray(_be6)){
_be6=$.map(_be6,function(_be7){
if(_be7&&typeof _be7=="object"){
$.easyui.addArrayItem(opts.mappingRows,opts.idField,_be7);
return _be7[opts.idField];
}else{
return _be7;
}
});
}
_bc0(this,_be6);
});
},setValue:function(jq,_be8){
return jq.each(function(){
$(this).combogrid("setValues",$.isArray(_be8)?_be8:[_be8]);
});
},clear:function(jq){
return jq.each(function(){
$(this).combogrid("setValues",[]);
});
},reset:function(jq){
return jq.each(function(){
var opts=$(this).combogrid("options");
if(opts.multiple){
$(this).combogrid("setValues",opts.originalValue);
}else{
$(this).combogrid("setValue",opts.originalValue);
}
});
}};
$.fn.combogrid.parseOptions=function(_be9){
var t=$(_be9);
return $.extend({},$.fn.combo.parseOptions(_be9),$.fn.datagrid.parseOptions(_be9),$.parser.parseOptions(_be9,["idField","textField","mode"]));
};
$.fn.combogrid.defaults=$.extend({},$.fn.combo.defaults,$.fn.datagrid.defaults,{loadMsg:null,idField:null,textField:null,unselectedValues:[],mappingRows:[],mode:"local",keyHandler:{up:function(e){
nav(this,"prev");
e.preventDefault();
},down:function(e){
nav(this,"next");
e.preventDefault();
},left:function(e){
},right:function(e){
},enter:function(e){
_bdd(this);
},query:function(q,e){
_bd6(this,q);
}},inputEvents:$.extend({},$.fn.combo.defaults.inputEvents,{blur:function(e){
$.fn.combo.defaults.inputEvents.blur(e);
var _bea=e.data.target;
var opts=$(_bea).combogrid("options");
if(opts.reversed){
$(_bea).combogrid("setValues",$(_bea).combogrid("getValues"));
}
}}),panelEvents:{mousedown:function(e){
}},filter:function(q,row){
var opts=$(this).combogrid("options");
return (row[opts.textField]||"").toLowerCase().indexOf(q.toLowerCase())>=0;
}});
})(jQuery);
(function($){
function _beb(_bec){
var _bed=$.data(_bec,"combotreegrid");
var opts=_bed.options;
$(_bec).addClass("combotreegrid-f").combo($.extend({},opts,{onShowPanel:function(){
var p=$(this).combotreegrid("panel");
var _bee=p.outerHeight()-p.height();
var _bef=p._size("minHeight");
var _bf0=p._size("maxHeight");
var dg=$(this).combotreegrid("grid");
dg.treegrid("resize",{width:"100%",height:(isNaN(parseInt(opts.panelHeight))?"auto":"100%"),minHeight:(_bef?_bef-_bee:""),maxHeight:(_bf0?_bf0-_bee:"")});
var row=dg.treegrid("getSelected");
if(row){
dg.treegrid("scrollTo",row[opts.idField]);
}
opts.onShowPanel.call(this);
}}));
if(!_bed.grid){
var _bf1=$(_bec).combo("panel");
_bed.grid=$("<table></table>").appendTo(_bf1);
}
_bed.grid.treegrid($.extend({},opts,{border:false,checkbox:opts.multiple,onLoadSuccess:function(row,data){
var _bf2=$(_bec).combotreegrid("getValues");
if(opts.multiple){
$.map($(this).treegrid("getCheckedNodes"),function(row){
$.easyui.addArrayItem(_bf2,row[opts.idField]);
});
}
_bf7(_bec,_bf2);
opts.onLoadSuccess.call(this,row,data);
_bed.remainText=false;
},onClickRow:function(row){
if(opts.multiple){
$(this).treegrid(row.checked?"uncheckNode":"checkNode",row[opts.idField]);
$(this).treegrid("unselect",row[opts.idField]);
}else{
$(_bec).combo("hidePanel");
}
_bf4(_bec);
opts.onClickRow.call(this,row);
},onCheckNode:function(row,_bf3){
_bf4(_bec);
opts.onCheckNode.call(this,row,_bf3);
}}));
};
function _bf4(_bf5){
var _bf6=$.data(_bf5,"combotreegrid");
var opts=_bf6.options;
var grid=_bf6.grid;
var vv=[];
if(opts.multiple){
vv=$.map(grid.treegrid("getCheckedNodes"),function(row){
return row[opts.idField];
});
}else{
var row=grid.treegrid("getSelected");
if(row){
vv.push(row[opts.idField]);
}
}
vv=vv.concat(opts.unselectedValues);
_bf7(_bf5,vv);
};
function _bf7(_bf8,_bf9){
var _bfa=$.data(_bf8,"combotreegrid");
var opts=_bfa.options;
var grid=_bfa.grid;
if(!$.isArray(_bf9)){
_bf9=_bf9.split(opts.separator);
}
if(!opts.multiple){
_bf9=_bf9.length?[_bf9[0]]:[""];
}
var vv=$.map(_bf9,function(_bfb){
return String(_bfb);
});
vv=$.grep(vv,function(v,_bfc){
return _bfc===$.inArray(v,vv);
});
var _bfd=grid.treegrid("getSelected");
if(_bfd){
grid.treegrid("unselect",_bfd[opts.idField]);
}
$.map(grid.treegrid("getCheckedNodes"),function(row){
if($.inArray(String(row[opts.idField]),vv)==-1){
grid.treegrid("uncheckNode",row[opts.idField]);
}
});
var ss=[];
opts.unselectedValues=[];
$.map(vv,function(v){
var row=grid.treegrid("find",v);
if(row){
if(opts.multiple){
grid.treegrid("checkNode",v);
}else{
grid.treegrid("select",v);
}
ss.push(_bfe(row));
}else{
ss.push(_bff(v,opts.mappingRows)||v);
opts.unselectedValues.push(v);
}
});
if(opts.multiple){
$.map(grid.treegrid("getCheckedNodes"),function(row){
var id=String(row[opts.idField]);
if($.inArray(id,vv)==-1){
vv.push(id);
ss.push(_bfe(row));
}
});
}
if(!_bfa.remainText){
var s=ss.join(opts.separator);
if($(_bf8).combo("getText")!=s){
$(_bf8).combo("setText",s);
}
}
$(_bf8).combo("setValues",vv);
function _bff(_c00,a){
var item=$.easyui.getArrayItem(a,opts.idField,_c00);
return item?_bfe(item):undefined;
};
function _bfe(row){
return row[opts.textField||""]||row[opts.treeField];
};
};
function _c01(_c02,q){
var _c03=$.data(_c02,"combotreegrid");
var opts=_c03.options;
var grid=_c03.grid;
_c03.remainText=true;
var qq=opts.multiple?q.split(opts.separator):[q];
qq=$.grep(qq,function(q){
return $.trim(q)!="";
});
grid.treegrid("clearSelections").treegrid("clearChecked").treegrid("highlightRow",-1);
if(opts.mode=="remote"){
_c04(qq);
grid.treegrid("load",$.extend({},opts.queryParams,{q:q}));
}else{
if(q){
var data=grid.treegrid("getData");
var vv=[];
$.map(qq,function(q){
q=$.trim(q);
if(q){
var v=undefined;
$.easyui.forEach(data,true,function(row){
if(q.toLowerCase()==String(row[opts.treeField]).toLowerCase()){
v=row[opts.idField];
return false;
}else{
if(opts.filter.call(_c02,q,row)){
grid.treegrid("expandTo",row[opts.idField]);
grid.treegrid("highlightRow",row[opts.idField]);
return false;
}
}
});
if(v==undefined){
$.easyui.forEach(opts.mappingRows,false,function(row){
if(q.toLowerCase()==String(row[opts.treeField])){
v=row[opts.idField];
return false;
}
});
}
if(v!=undefined){
vv.push(v);
}else{
vv.push(q);
}
}
});
_c04(vv);
_c03.remainText=false;
}
}
function _c04(vv){
if(!opts.reversed){
$(_c02).combotreegrid("setValues",vv);
}
};
};
function _c05(_c06){
var _c07=$.data(_c06,"combotreegrid");
var opts=_c07.options;
var grid=_c07.grid;
var tr=opts.finder.getTr(grid[0],null,"highlight");
_c07.remainText=false;
if(tr.length){
var id=tr.attr("node-id");
if(opts.multiple){
if(tr.hasClass("datagrid-row-selected")){
grid.treegrid("uncheckNode",id);
}else{
grid.treegrid("checkNode",id);
}
}else{
grid.treegrid("selectRow",id);
}
}
var vv=[];
if(opts.multiple){
$.map(grid.treegrid("getCheckedNodes"),function(row){
vv.push(row[opts.idField]);
});
}else{
var row=grid.treegrid("getSelected");
if(row){
vv.push(row[opts.idField]);
}
}
$.map(opts.unselectedValues,function(v){
if($.easyui.indexOfArray(opts.mappingRows,opts.idField,v)>=0){
$.easyui.addArrayItem(vv,v);
}
});
$(_c06).combotreegrid("setValues",vv);
if(!opts.multiple){
$(_c06).combotreegrid("hidePanel");
}
};
$.fn.combotreegrid=function(_c08,_c09){
if(typeof _c08=="string"){
var _c0a=$.fn.combotreegrid.methods[_c08];
if(_c0a){
return _c0a(this,_c09);
}else{
return this.combo(_c08,_c09);
}
}
_c08=_c08||{};
return this.each(function(){
var _c0b=$.data(this,"combotreegrid");
if(_c0b){
$.extend(_c0b.options,_c08);
}else{
_c0b=$.data(this,"combotreegrid",{options:$.extend({},$.fn.combotreegrid.defaults,$.fn.combotreegrid.parseOptions(this),_c08)});
}
_beb(this);
});
};
$.fn.combotreegrid.methods={options:function(jq){
var _c0c=jq.combo("options");
return $.extend($.data(jq[0],"combotreegrid").options,{width:_c0c.width,height:_c0c.height,originalValue:_c0c.originalValue,disabled:_c0c.disabled,readonly:_c0c.readonly});
},grid:function(jq){
return $.data(jq[0],"combotreegrid").grid;
},setValues:function(jq,_c0d){
return jq.each(function(){
var opts=$(this).combotreegrid("options");
if($.isArray(_c0d)){
_c0d=$.map(_c0d,function(_c0e){
if(_c0e&&typeof _c0e=="object"){
$.easyui.addArrayItem(opts.mappingRows,opts.idField,_c0e);
return _c0e[opts.idField];
}else{
return _c0e;
}
});
}
_bf7(this,_c0d);
});
},setValue:function(jq,_c0f){
return jq.each(function(){
$(this).combotreegrid("setValues",$.isArray(_c0f)?_c0f:[_c0f]);
});
},clear:function(jq){
return jq.each(function(){
$(this).combotreegrid("setValues",[]);
});
},reset:function(jq){
return jq.each(function(){
var opts=$(this).combotreegrid("options");
if(opts.multiple){
$(this).combotreegrid("setValues",opts.originalValue);
}else{
$(this).combotreegrid("setValue",opts.originalValue);
}
});
}};
$.fn.combotreegrid.parseOptions=function(_c10){
var t=$(_c10);
return $.extend({},$.fn.combo.parseOptions(_c10),$.fn.treegrid.parseOptions(_c10),$.parser.parseOptions(_c10,["mode",{limitToGrid:"boolean"}]));
};
$.fn.combotreegrid.defaults=$.extend({},$.fn.combo.defaults,$.fn.treegrid.defaults,{editable:false,singleSelect:true,limitToGrid:false,unselectedValues:[],mappingRows:[],mode:"local",textField:null,keyHandler:{up:function(e){
},down:function(e){
},left:function(e){
},right:function(e){
},enter:function(e){
_c05(this);
},query:function(q,e){
_c01(this,q);
}},inputEvents:$.extend({},$.fn.combo.defaults.inputEvents,{blur:function(e){
$.fn.combo.defaults.inputEvents.blur(e);
var _c11=e.data.target;
var opts=$(_c11).combotreegrid("options");
if(opts.limitToGrid){
_c05(_c11);
}
}}),filter:function(q,row){
var opts=$(this).combotreegrid("options");
return (row[opts.treeField]||"").toLowerCase().indexOf(q.toLowerCase())>=0;
}});
})(jQuery);
(function($){
function _c12(_c13){
var _c14=$.data(_c13,"tagbox");
var opts=_c14.options;
$(_c13).addClass("tagbox-f").combobox($.extend({},opts,{cls:"tagbox",reversed:true,onChange:function(_c15,_c16){
_c17();
$(this).combobox("hidePanel");
opts.onChange.call(_c13,_c15,_c16);
},onResizing:function(_c18,_c19){
var _c1a=$(this).combobox("textbox");
var tb=$(this).data("textbox").textbox;
var _c1b=tb.outerWidth();
tb.css({height:"",paddingLeft:_c1a.css("marginLeft"),paddingRight:_c1a.css("marginRight")});
_c1a.css("margin",0);
tb._outerWidth(_c1b);
_c2e(_c13);
_c20(this);
opts.onResizing.call(_c13,_c18,_c19);
},onLoadSuccess:function(data){
_c17();
opts.onLoadSuccess.call(_c13,data);
}}));
_c17();
_c2e(_c13);
function _c17(){
$(_c13).next().find(".tagbox-label").remove();
var _c1c=$(_c13).tagbox("textbox");
var ss=[];
$.map($(_c13).tagbox("getValues"),function(_c1d,_c1e){
var row=opts.finder.getRow(_c13,_c1d);
var text=opts.tagFormatter.call(_c13,_c1d,row);
var cs={};
var css=opts.tagStyler.call(_c13,_c1d,row)||"";
if(typeof css=="string"){
cs={s:css};
}else{
cs={c:css["class"]||"",s:css["style"]||""};
}
var _c1f=$("<span class=\"tagbox-label\"></span>").insertBefore(_c1c).html(text);
_c1f.attr("tagbox-index",_c1e);
_c1f.attr("style",cs.s).addClass(cs.c);
$("<a href=\"javascript:;\" class=\"tagbox-remove\"></a>").appendTo(_c1f);
});
_c20(_c13);
$(_c13).combobox("setText","");
};
};
function _c20(_c21,_c22){
var span=$(_c21).next();
var _c23=_c22?$(_c22):span.find(".tagbox-label");
if(_c23.length){
var _c24=$(_c21).tagbox("textbox");
var _c25=$(_c23[0]);
var _c26=_c25.outerHeight(true)-_c25.outerHeight();
var _c27=_c24.outerHeight()-_c26*2;
_c23.css({height:_c27+"px",lineHeight:_c27+"px"});
var _c28=span.find(".textbox-addon").css("height","100%");
_c28.find(".textbox-icon").css("height","100%");
span.find(".textbox-button").linkbutton("resize",{height:"100%"});
}
};
function _c29(_c2a){
var span=$(_c2a).next();
span.unbind(".tagbox").bind("click.tagbox",function(e){
var opts=$(_c2a).tagbox("options");
if(opts.disabled||opts.readonly){
return;
}
if($(e.target).hasClass("tagbox-remove")){
var _c2b=parseInt($(e.target).parent().attr("tagbox-index"));
var _c2c=$(_c2a).tagbox("getValues");
if(opts.onBeforeRemoveTag.call(_c2a,_c2c[_c2b])==false){
return;
}
opts.onRemoveTag.call(_c2a,_c2c[_c2b]);
_c2c.splice(_c2b,1);
$(_c2a).tagbox("setValues",_c2c);
}else{
var _c2d=$(e.target).closest(".tagbox-label");
if(_c2d.length){
var _c2b=parseInt(_c2d.attr("tagbox-index"));
var _c2c=$(_c2a).tagbox("getValues");
opts.onClickTag.call(_c2a,_c2c[_c2b]);
}
}
$(this).find(".textbox-text").focus();
}).bind("keyup.tagbox",function(e){
_c2e(_c2a);
}).bind("mouseover.tagbox",function(e){
if($(e.target).closest(".textbox-button,.textbox-addon,.tagbox-label").length){
$(this).triggerHandler("mouseleave");
}else{
$(this).find(".textbox-text").triggerHandler("mouseenter");
}
}).bind("mouseleave.tagbox",function(e){
$(this).find(".textbox-text").triggerHandler("mouseleave");
});
};
function _c2e(_c2f){
var opts=$(_c2f).tagbox("options");
var _c30=$(_c2f).tagbox("textbox");
var span=$(_c2f).next();
var tmp=$("<span></span>").appendTo("body");
tmp.attr("style",_c30.attr("style"));
tmp.css({position:"absolute",top:-9999,left:-9999,width:"auto",fontFamily:_c30.css("fontFamily"),fontSize:_c30.css("fontSize"),fontWeight:_c30.css("fontWeight"),whiteSpace:"nowrap"});
var _c31=_c32(_c30.val());
var _c33=_c32(opts.prompt||"");
tmp.remove();
var _c34=Math.min(Math.max(_c31,_c33)+20,span.width());
_c30._outerWidth(_c34);
span.find(".textbox-button").linkbutton("resize",{height:"100%"});
function _c32(val){
var s=val.replace(/&/g,"&amp;").replace(/\s/g," ").replace(/</g,"&lt;").replace(/>/g,"&gt;");
tmp.html(s);
return tmp.outerWidth();
};
};
function _c35(_c36){
var t=$(_c36);
var opts=t.tagbox("options");
if(opts.limitToList){
var _c37=t.tagbox("panel");
var item=_c37.children("div.combobox-item-hover");
if(item.length){
item.removeClass("combobox-item-hover");
var row=opts.finder.getRow(_c36,item);
var _c38=row[opts.valueField];
$(_c36).tagbox(item.hasClass("combobox-item-selected")?"unselect":"select",_c38);
}
$(_c36).tagbox("hidePanel");
}else{
var v=$.trim($(_c36).tagbox("getText"));
if(v!==""){
var _c39=$(_c36).tagbox("getValues");
_c39.push(v);
$(_c36).tagbox("setValues",_c39);
}
}
};
function _c3a(_c3b,_c3c){
$(_c3b).combobox("setText","");
_c2e(_c3b);
$(_c3b).combobox("setValues",_c3c);
$(_c3b).combobox("setText","");
$(_c3b).tagbox("validate");
};
$.fn.tagbox=function(_c3d,_c3e){
if(typeof _c3d=="string"){
var _c3f=$.fn.tagbox.methods[_c3d];
if(_c3f){
return _c3f(this,_c3e);
}else{
return this.combobox(_c3d,_c3e);
}
}
_c3d=_c3d||{};
return this.each(function(){
var _c40=$.data(this,"tagbox");
if(_c40){
$.extend(_c40.options,_c3d);
}else{
$.data(this,"tagbox",{options:$.extend({},$.fn.tagbox.defaults,$.fn.tagbox.parseOptions(this),_c3d)});
}
_c12(this);
_c29(this);
});
};
$.fn.tagbox.methods={options:function(jq){
var _c41=jq.combobox("options");
return $.extend($.data(jq[0],"tagbox").options,{width:_c41.width,height:_c41.height,originalValue:_c41.originalValue,disabled:_c41.disabled,readonly:_c41.readonly});
},setValues:function(jq,_c42){
return jq.each(function(){
_c3a(this,_c42);
});
},reset:function(jq){
return jq.each(function(){
$(this).combobox("reset").combobox("setText","");
});
}};
$.fn.tagbox.parseOptions=function(_c43){
return $.extend({},$.fn.combobox.parseOptions(_c43),$.parser.parseOptions(_c43,[]));
};
$.fn.tagbox.defaults=$.extend({},$.fn.combobox.defaults,{hasDownArrow:false,multiple:true,reversed:true,selectOnNavigation:false,tipOptions:$.extend({},$.fn.textbox.defaults.tipOptions,{showDelay:200}),val:function(_c44){
var vv=$(_c44).parent().prev().tagbox("getValues");
if($(_c44).is(":focus")){
vv.push($(_c44).val());
}
return vv.join(",");
},inputEvents:$.extend({},$.fn.combo.defaults.inputEvents,{blur:function(e){
var _c45=e.data.target;
var opts=$(_c45).tagbox("options");
if(opts.limitToList){
_c35(_c45);
}
}}),keyHandler:$.extend({},$.fn.combobox.defaults.keyHandler,{enter:function(e){
_c35(this);
},query:function(q,e){
var opts=$(this).tagbox("options");
if(opts.limitToList){
$.fn.combobox.defaults.keyHandler.query.call(this,q,e);
}else{
$(this).combobox("hidePanel");
}
}}),tagFormatter:function(_c46,row){
var opts=$(this).tagbox("options");
return row?row[opts.textField]:_c46;
},tagStyler:function(_c47,row){
return "";
},onClickTag:function(_c48){
},onBeforeRemoveTag:function(_c49){
},onRemoveTag:function(_c4a){
}});
})(jQuery);
(function($){
function _c4b(_c4c){
var _c4d=$.data(_c4c,"datebox");
var opts=_c4d.options;
$(_c4c).addClass("datebox-f").combo($.extend({},opts,{onShowPanel:function(){
_c4e(this);
_c4f(this);
_c50(this);
_c5e(this,$(this).datebox("getText"),true);
opts.onShowPanel.call(this);
}}));
if(!_c4d.calendar){
var _c51=$(_c4c).combo("panel").css("overflow","hidden");
_c51.panel("options").onBeforeDestroy=function(){
var c=$(this).find(".calendar-shared");
if(c.length){
c.insertBefore(c[0].pholder);
}
};
var cc=$("<div class=\"datebox-calendar-inner\"></div>").prependTo(_c51);
if(opts.sharedCalendar){
var c=$(opts.sharedCalendar);
if(!c[0].pholder){
c[0].pholder=$("<div class=\"calendar-pholder\" style=\"display:none\"></div>").insertAfter(c);
}
c.addClass("calendar-shared").appendTo(cc);
if(!c.hasClass("calendar")){
c.calendar();
}
_c4d.calendar=c;
}else{
_c4d.calendar=$("<div></div>").appendTo(cc).calendar();
}
$.extend(_c4d.calendar.calendar("options"),{fit:true,border:false,onSelect:function(date){
var _c52=this.target;
var opts=$(_c52).datebox("options");
opts.onSelect.call(_c52,date);
_c5e(_c52,opts.formatter.call(_c52,date));
$(_c52).combo("hidePanel");
}});
}
$(_c4c).combo("textbox").parent().addClass("datebox");
$(_c4c).datebox("initValue",opts.value);
function _c4e(_c53){
var opts=$(_c53).datebox("options");
var _c54=$(_c53).combo("panel");
_c54.unbind(".datebox").bind("click.datebox",function(e){
if($(e.target).hasClass("datebox-button-a")){
var _c55=parseInt($(e.target).attr("datebox-button-index"));
opts.buttons[_c55].handler.call(e.target,_c53);
}
});
};
function _c4f(_c56){
var _c57=$(_c56).combo("panel");
if(_c57.children("div.datebox-button").length){
return;
}
var _c58=$("<div class=\"datebox-button\"><table cellspacing=\"0\" cellpadding=\"0\" style=\"width:100%\"><tr></tr></table></div>").appendTo(_c57);
var tr=_c58.find("tr");
for(var i=0;i<opts.buttons.length;i++){
var td=$("<td></td>").appendTo(tr);
var btn=opts.buttons[i];
var t=$("<a class=\"datebox-button-a\" href=\"javascript:;\"></a>").html($.isFunction(btn.text)?btn.text(_c56):btn.text).appendTo(td);
t.attr("datebox-button-index",i);
}
tr.find("td").css("width",(100/opts.buttons.length)+"%");
};
function _c50(_c59){
var _c5a=$(_c59).combo("panel");
var cc=_c5a.children("div.datebox-calendar-inner");
_c5a.children()._outerWidth(_c5a.width());
_c4d.calendar.appendTo(cc);
_c4d.calendar[0].target=_c59;
if(opts.panelHeight!="auto"){
var _c5b=_c5a.height();
_c5a.children().not(cc).each(function(){
_c5b-=$(this).outerHeight();
});
cc._outerHeight(_c5b);
}
_c4d.calendar.calendar("resize");
};
};
function _c5c(_c5d,q){
_c5e(_c5d,q,true);
};
function _c5f(_c60){
var _c61=$.data(_c60,"datebox");
var opts=_c61.options;
var _c62=_c61.calendar.calendar("options").current;
if(_c62){
_c5e(_c60,opts.formatter.call(_c60,_c62));
$(_c60).combo("hidePanel");
}
};
function _c5e(_c63,_c64,_c65){
var _c66=$.data(_c63,"datebox");
var opts=_c66.options;
var _c67=_c66.calendar;
_c67.calendar("moveTo",opts.parser.call(_c63,_c64));
if(_c65){
$(_c63).combo("setValue",_c64);
}else{
if(_c64){
_c64=opts.formatter.call(_c63,_c67.calendar("options").current);
}
$(_c63).combo("setText",_c64).combo("setValue",_c64);
}
};
$.fn.datebox=function(_c68,_c69){
if(typeof _c68=="string"){
var _c6a=$.fn.datebox.methods[_c68];
if(_c6a){
return _c6a(this,_c69);
}else{
return this.combo(_c68,_c69);
}
}
_c68=_c68||{};
return this.each(function(){
var _c6b=$.data(this,"datebox");
if(_c6b){
$.extend(_c6b.options,_c68);
}else{
$.data(this,"datebox",{options:$.extend({},$.fn.datebox.defaults,$.fn.datebox.parseOptions(this),_c68)});
}
_c4b(this);
});
};
$.fn.datebox.methods={options:function(jq){
var _c6c=jq.combo("options");
return $.extend($.data(jq[0],"datebox").options,{width:_c6c.width,height:_c6c.height,originalValue:_c6c.originalValue,disabled:_c6c.disabled,readonly:_c6c.readonly});
},cloneFrom:function(jq,from){
return jq.each(function(){
$(this).combo("cloneFrom",from);
$.data(this,"datebox",{options:$.extend(true,{},$(from).datebox("options")),calendar:$(from).datebox("calendar")});
$(this).addClass("datebox-f");
});
},calendar:function(jq){
return $.data(jq[0],"datebox").calendar;
},initValue:function(jq,_c6d){
return jq.each(function(){
var opts=$(this).datebox("options");
var _c6e=opts.value;
if(_c6e){
_c6e=opts.formatter.call(this,opts.parser.call(this,_c6e));
}
$(this).combo("initValue",_c6e).combo("setText",_c6e);
});
},setValue:function(jq,_c6f){
return jq.each(function(){
_c5e(this,_c6f);
});
},reset:function(jq){
return jq.each(function(){
var opts=$(this).datebox("options");
$(this).datebox("setValue",opts.originalValue);
});
}};
$.fn.datebox.parseOptions=function(_c70){
return $.extend({},$.fn.combo.parseOptions(_c70),$.parser.parseOptions(_c70,["sharedCalendar"]));
};
$.fn.datebox.defaults=$.extend({},$.fn.combo.defaults,{panelWidth:250,panelHeight:"auto",sharedCalendar:null,keyHandler:{up:function(e){
},down:function(e){
},left:function(e){
},right:function(e){
},enter:function(e){
_c5f(this);
},query:function(q,e){
_c5c(this,q);
}},currentText:"Today",closeText:"Close",okText:"Ok",buttons:[{text:function(_c71){
return $(_c71).datebox("options").currentText;
},handler:function(_c72){
var opts=$(_c72).datebox("options");
var now=new Date();
var _c73=new Date(now.getFullYear(),now.getMonth(),now.getDate());
$(_c72).datebox("calendar").calendar({year:_c73.getFullYear(),month:_c73.getMonth()+1,current:_c73});
opts.onSelect.call(_c72,_c73);
_c5f(_c72);
}},{text:function(_c74){
return $(_c74).datebox("options").closeText;
},handler:function(_c75){
$(this).closest("div.combo-panel").panel("close");
}}],formatter:function(date){
var y=date.getFullYear();
var m=date.getMonth()+1;
var d=date.getDate();
return (m<10?("0"+m):m)+"/"+(d<10?("0"+d):d)+"/"+y;
},parser:function(s){
if(!s){
return new Date();
}
var ss=s.split("/");
var m=parseInt(ss[0],10);
var d=parseInt(ss[1],10);
var y=parseInt(ss[2],10);
if(!isNaN(y)&&!isNaN(m)&&!isNaN(d)){
return new Date(y,m-1,d);
}else{
return new Date();
}
},onSelect:function(date){
}});
})(jQuery);
(function($){
function _c76(_c77){
var _c78=$.data(_c77,"datetimebox");
var opts=_c78.options;
$(_c77).datebox($.extend({},opts,{onShowPanel:function(){
var _c79=$(this).datetimebox("getValue");
_c7f(this,_c79,true);
opts.onShowPanel.call(this);
},formatter:$.fn.datebox.defaults.formatter,parser:$.fn.datebox.defaults.parser}));
$(_c77).removeClass("datebox-f").addClass("datetimebox-f");
$(_c77).datebox("calendar").calendar({onSelect:function(date){
opts.onSelect.call(this.target,date);
}});
if(!_c78.spinner){
var _c7a=$(_c77).datebox("panel");
var p=$("<div style=\"padding:2px\"><input></div>").insertAfter(_c7a.children("div.datebox-calendar-inner"));
_c78.spinner=p.children("input");
}
_c78.spinner.timespinner({width:opts.spinnerWidth,showSeconds:opts.showSeconds,separator:opts.timeSeparator});
$(_c77).datetimebox("initValue",opts.value);
};
function _c7b(_c7c){
var c=$(_c7c).datetimebox("calendar");
var t=$(_c7c).datetimebox("spinner");
var date=c.calendar("options").current;
return new Date(date.getFullYear(),date.getMonth(),date.getDate(),t.timespinner("getHours"),t.timespinner("getMinutes"),t.timespinner("getSeconds"));
};
function _c7d(_c7e,q){
_c7f(_c7e,q,true);
};
function _c80(_c81){
var opts=$.data(_c81,"datetimebox").options;
var date=_c7b(_c81);
_c7f(_c81,opts.formatter.call(_c81,date));
$(_c81).combo("hidePanel");
};
function _c7f(_c82,_c83,_c84){
var opts=$.data(_c82,"datetimebox").options;
$(_c82).combo("setValue",_c83);
if(!_c84){
if(_c83){
var date=opts.parser.call(_c82,_c83);
$(_c82).combo("setText",opts.formatter.call(_c82,date));
$(_c82).combo("setValue",opts.formatter.call(_c82,date));
}else{
$(_c82).combo("setText",_c83);
}
}
var date=opts.parser.call(_c82,_c83);
$(_c82).datetimebox("calendar").calendar("moveTo",date);
$(_c82).datetimebox("spinner").timespinner("setValue",_c85(date));
function _c85(date){
function _c86(_c87){
return (_c87<10?"0":"")+_c87;
};
var tt=[_c86(date.getHours()),_c86(date.getMinutes())];
if(opts.showSeconds){
tt.push(_c86(date.getSeconds()));
}
return tt.join($(_c82).datetimebox("spinner").timespinner("options").separator);
};
};
$.fn.datetimebox=function(_c88,_c89){
if(typeof _c88=="string"){
var _c8a=$.fn.datetimebox.methods[_c88];
if(_c8a){
return _c8a(this,_c89);
}else{
return this.datebox(_c88,_c89);
}
}
_c88=_c88||{};
return this.each(function(){
var _c8b=$.data(this,"datetimebox");
if(_c8b){
$.extend(_c8b.options,_c88);
}else{
$.data(this,"datetimebox",{options:$.extend({},$.fn.datetimebox.defaults,$.fn.datetimebox.parseOptions(this),_c88)});
}
_c76(this);
});
};
$.fn.datetimebox.methods={options:function(jq){
var _c8c=jq.datebox("options");
return $.extend($.data(jq[0],"datetimebox").options,{originalValue:_c8c.originalValue,disabled:_c8c.disabled,readonly:_c8c.readonly});
},cloneFrom:function(jq,from){
return jq.each(function(){
$(this).datebox("cloneFrom",from);
$.data(this,"datetimebox",{options:$.extend(true,{},$(from).datetimebox("options")),spinner:$(from).datetimebox("spinner")});
$(this).removeClass("datebox-f").addClass("datetimebox-f");
});
},spinner:function(jq){
return $.data(jq[0],"datetimebox").spinner;
},initValue:function(jq,_c8d){
return jq.each(function(){
var opts=$(this).datetimebox("options");
var _c8e=opts.value;
if(_c8e){
_c8e=opts.formatter.call(this,opts.parser.call(this,_c8e));
}
$(this).combo("initValue",_c8e).combo("setText",_c8e);
});
},setValue:function(jq,_c8f){
return jq.each(function(){
_c7f(this,_c8f);
});
},reset:function(jq){
return jq.each(function(){
var opts=$(this).datetimebox("options");
$(this).datetimebox("setValue",opts.originalValue);
});
}};
$.fn.datetimebox.parseOptions=function(_c90){
var t=$(_c90);
return $.extend({},$.fn.datebox.parseOptions(_c90),$.parser.parseOptions(_c90,["timeSeparator","spinnerWidth",{showSeconds:"boolean"}]));
};
$.fn.datetimebox.defaults=$.extend({},$.fn.datebox.defaults,{spinnerWidth:"100%",showSeconds:true,timeSeparator:":",panelEvents:{mousedown:function(e){
}},keyHandler:{up:function(e){
},down:function(e){
},left:function(e){
},right:function(e){
},enter:function(e){
_c80(this);
},query:function(q,e){
_c7d(this,q);
}},buttons:[{text:function(_c91){
return $(_c91).datetimebox("options").currentText;
},handler:function(_c92){
var opts=$(_c92).datetimebox("options");
_c7f(_c92,opts.formatter.call(_c92,new Date()));
$(_c92).datetimebox("hidePanel");
}},{text:function(_c93){
return $(_c93).datetimebox("options").okText;
},handler:function(_c94){
_c80(_c94);
}},{text:function(_c95){
return $(_c95).datetimebox("options").closeText;
},handler:function(_c96){
$(_c96).datetimebox("hidePanel");
}}],formatter:function(date){
var h=date.getHours();
var M=date.getMinutes();
var s=date.getSeconds();
function _c97(_c98){
return (_c98<10?"0":"")+_c98;
};
var _c99=$(this).datetimebox("spinner").timespinner("options").separator;
var r=$.fn.datebox.defaults.formatter(date)+" "+_c97(h)+_c99+_c97(M);
if($(this).datetimebox("options").showSeconds){
r+=_c99+_c97(s);
}
return r;
},parser:function(s){
if($.trim(s)==""){
return new Date();
}
var dt=s.split(" ");
var d=$.fn.datebox.defaults.parser(dt[0]);
if(dt.length<2){
return d;
}
var _c9a=$(this).datetimebox("spinner").timespinner("options").separator;
var tt=dt[1].split(_c9a);
var hour=parseInt(tt[0],10)||0;
var _c9b=parseInt(tt[1],10)||0;
var _c9c=parseInt(tt[2],10)||0;
return new Date(d.getFullYear(),d.getMonth(),d.getDate(),hour,_c9b,_c9c);
}});
})(jQuery);
(function($){
function init(_c9d){
var _c9e=$("<div class=\"slider\">"+"<div class=\"slider-inner\">"+"<a href=\"javascript:;\" class=\"slider-handle\"></a>"+"<span class=\"slider-tip\"></span>"+"</div>"+"<div class=\"slider-rule\"></div>"+"<div class=\"slider-rulelabel\"></div>"+"<div style=\"clear:both\"></div>"+"<input type=\"hidden\" class=\"slider-value\">"+"</div>").insertAfter(_c9d);
var t=$(_c9d);
t.addClass("slider-f").hide();
var name=t.attr("name");
if(name){
_c9e.find("input.slider-value").attr("name",name);
t.removeAttr("name").attr("sliderName",name);
}
_c9e.bind("_resize",function(e,_c9f){
if($(this).hasClass("easyui-fluid")||_c9f){
_ca0(_c9d);
}
return false;
});
return _c9e;
};
function _ca0(_ca1,_ca2){
var _ca3=$.data(_ca1,"slider");
var opts=_ca3.options;
var _ca4=_ca3.slider;
if(_ca2){
if(_ca2.width){
opts.width=_ca2.width;
}
if(_ca2.height){
opts.height=_ca2.height;
}
}
_ca4._size(opts);
if(opts.mode=="h"){
_ca4.css("height","");
_ca4.children("div").css("height","");
}else{
_ca4.css("width","");
_ca4.children("div").css("width","");
_ca4.children("div.slider-rule,div.slider-rulelabel,div.slider-inner")._outerHeight(_ca4._outerHeight());
}
_ca5(_ca1);
};
function _ca6(_ca7){
var _ca8=$.data(_ca7,"slider");
var opts=_ca8.options;
var _ca9=_ca8.slider;
var aa=opts.mode=="h"?opts.rule:opts.rule.slice(0).reverse();
if(opts.reversed){
aa=aa.slice(0).reverse();
}
_caa(aa);
function _caa(aa){
var rule=_ca9.find("div.slider-rule");
var _cab=_ca9.find("div.slider-rulelabel");
rule.empty();
_cab.empty();
for(var i=0;i<aa.length;i++){
var _cac=i*100/(aa.length-1)+"%";
var span=$("<span></span>").appendTo(rule);
span.css((opts.mode=="h"?"left":"top"),_cac);
if(aa[i]!="|"){
span=$("<span></span>").appendTo(_cab);
span.html(aa[i]);
if(opts.mode=="h"){
span.css({left:_cac,marginLeft:-Math.round(span.outerWidth()/2)});
}else{
span.css({top:_cac,marginTop:-Math.round(span.outerHeight()/2)});
}
}
}
};
};
function _cad(_cae){
var _caf=$.data(_cae,"slider");
var opts=_caf.options;
var _cb0=_caf.slider;
_cb0.removeClass("slider-h slider-v slider-disabled");
_cb0.addClass(opts.mode=="h"?"slider-h":"slider-v");
_cb0.addClass(opts.disabled?"slider-disabled":"");
var _cb1=_cb0.find(".slider-inner");
_cb1.html("<a href=\"javascript:;\" class=\"slider-handle\"></a>"+"<span class=\"slider-tip\"></span>");
if(opts.range){
_cb1.append("<a href=\"javascript:;\" class=\"slider-handle\"></a>"+"<span class=\"slider-tip\"></span>");
}
_cb0.find("a.slider-handle").draggable({axis:opts.mode,cursor:"pointer",disabled:opts.disabled,onDrag:function(e){
var left=e.data.left;
var _cb2=_cb0.width();
if(opts.mode!="h"){
left=e.data.top;
_cb2=_cb0.height();
}
if(left<0||left>_cb2){
return false;
}else{
_cb3(left,this);
return false;
}
},onStartDrag:function(){
_caf.isDragging=true;
opts.onSlideStart.call(_cae,opts.value);
},onStopDrag:function(e){
_cb3(opts.mode=="h"?e.data.left:e.data.top,this);
opts.onSlideEnd.call(_cae,opts.value);
opts.onComplete.call(_cae,opts.value);
_caf.isDragging=false;
}});
_cb0.find("div.slider-inner").unbind(".slider").bind("mousedown.slider",function(e){
if(_caf.isDragging||opts.disabled){
return;
}
var pos=$(this).offset();
_cb3(opts.mode=="h"?(e.pageX-pos.left):(e.pageY-pos.top));
opts.onComplete.call(_cae,opts.value);
});
function _cb4(_cb5){
var dd=String(opts.step).split(".");
var dlen=dd.length>1?dd[1].length:0;
return parseFloat(_cb5.toFixed(dlen));
};
function _cb3(pos,_cb6){
var _cb7=_cb8(_cae,pos);
var s=Math.abs(_cb7%opts.step);
if(s<opts.step/2){
_cb7-=s;
}else{
_cb7=_cb7-s+opts.step;
}
_cb7=_cb4(_cb7);
if(opts.range){
var v1=opts.value[0];
var v2=opts.value[1];
var m=parseFloat((v1+v2)/2);
if(_cb6){
var _cb9=$(_cb6).nextAll(".slider-handle").length>0;
if(_cb7<=v2&&_cb9){
v1=_cb7;
}else{
if(_cb7>=v1&&(!_cb9)){
v2=_cb7;
}
}
}else{
if(_cb7<v1){
v1=_cb7;
}else{
if(_cb7>v2){
v2=_cb7;
}else{
_cb7<m?v1=_cb7:v2=_cb7;
}
}
}
$(_cae).slider("setValues",[v1,v2]);
}else{
$(_cae).slider("setValue",_cb7);
}
};
};
function _cba(_cbb,_cbc){
var _cbd=$.data(_cbb,"slider");
var opts=_cbd.options;
var _cbe=_cbd.slider;
var _cbf=$.isArray(opts.value)?opts.value:[opts.value];
var _cc0=[];
if(!$.isArray(_cbc)){
_cbc=$.map(String(_cbc).split(opts.separator),function(v){
return parseFloat(v);
});
}
_cbe.find(".slider-value").remove();
var name=$(_cbb).attr("sliderName")||"";
for(var i=0;i<_cbc.length;i++){
var _cc1=_cbc[i];
if(_cc1<opts.min){
_cc1=opts.min;
}
if(_cc1>opts.max){
_cc1=opts.max;
}
var _cc2=$("<input type=\"hidden\" class=\"slider-value\">").appendTo(_cbe);
_cc2.attr("name",name);
_cc2.val(_cc1);
_cc0.push(_cc1);
var _cc3=_cbe.find(".slider-handle:eq("+i+")");
var tip=_cc3.next();
var pos=_cc4(_cbb,_cc1);
if(opts.showTip){
tip.show();
tip.html(opts.tipFormatter.call(_cbb,_cc1));
}else{
tip.hide();
}
if(opts.mode=="h"){
var _cc5="left:"+pos+"px;";
_cc3.attr("style",_cc5);
tip.attr("style",_cc5+"margin-left:"+(-Math.round(tip.outerWidth()/2))+"px");
}else{
var _cc5="top:"+pos+"px;";
_cc3.attr("style",_cc5);
tip.attr("style",_cc5+"margin-left:"+(-Math.round(tip.outerWidth()))+"px");
}
}
opts.value=opts.range?_cc0:_cc0[0];
$(_cbb).val(opts.range?_cc0.join(opts.separator):_cc0[0]);
if(_cbf.join(",")!=_cc0.join(",")){
opts.onChange.call(_cbb,opts.value,(opts.range?_cbf:_cbf[0]));
}
};
function _ca5(_cc6){
var opts=$.data(_cc6,"slider").options;
var fn=opts.onChange;
opts.onChange=function(){
};
_cba(_cc6,opts.value);
opts.onChange=fn;
};
function _cc4(_cc7,_cc8){
var _cc9=$.data(_cc7,"slider");
var opts=_cc9.options;
var _cca=_cc9.slider;
var size=opts.mode=="h"?_cca.width():_cca.height();
var pos=opts.converter.toPosition.call(_cc7,_cc8,size);
if(opts.mode=="v"){
pos=_cca.height()-pos;
}
if(opts.reversed){
pos=size-pos;
}
return pos;
};
function _cb8(_ccb,pos){
var _ccc=$.data(_ccb,"slider");
var opts=_ccc.options;
var _ccd=_ccc.slider;
var size=opts.mode=="h"?_ccd.width():_ccd.height();
var pos=opts.mode=="h"?(opts.reversed?(size-pos):pos):(opts.reversed?pos:(size-pos));
var _cce=opts.converter.toValue.call(_ccb,pos,size);
return _cce;
};
$.fn.slider=function(_ccf,_cd0){
if(typeof _ccf=="string"){
return $.fn.slider.methods[_ccf](this,_cd0);
}
_ccf=_ccf||{};
return this.each(function(){
var _cd1=$.data(this,"slider");
if(_cd1){
$.extend(_cd1.options,_ccf);
}else{
_cd1=$.data(this,"slider",{options:$.extend({},$.fn.slider.defaults,$.fn.slider.parseOptions(this),_ccf),slider:init(this)});
$(this)._propAttr("disabled",false);
}
var opts=_cd1.options;
opts.min=parseFloat(opts.min);
opts.max=parseFloat(opts.max);
if(opts.range){
if(!$.isArray(opts.value)){
opts.value=$.map(String(opts.value).split(opts.separator),function(v){
return parseFloat(v);
});
}
if(opts.value.length<2){
opts.value.push(opts.max);
}
}else{
opts.value=parseFloat(opts.value);
}
opts.step=parseFloat(opts.step);
opts.originalValue=opts.value;
_cad(this);
_ca6(this);
_ca0(this);
});
};
$.fn.slider.methods={options:function(jq){
return $.data(jq[0],"slider").options;
},destroy:function(jq){
return jq.each(function(){
$.data(this,"slider").slider.remove();
$(this).remove();
});
},resize:function(jq,_cd2){
return jq.each(function(){
_ca0(this,_cd2);
});
},getValue:function(jq){
return jq.slider("options").value;
},getValues:function(jq){
return jq.slider("options").value;
},setValue:function(jq,_cd3){
return jq.each(function(){
_cba(this,[_cd3]);
});
},setValues:function(jq,_cd4){
return jq.each(function(){
_cba(this,_cd4);
});
},clear:function(jq){
return jq.each(function(){
var opts=$(this).slider("options");
_cba(this,opts.range?[opts.min,opts.max]:[opts.min]);
});
},reset:function(jq){
return jq.each(function(){
var opts=$(this).slider("options");
$(this).slider(opts.range?"setValues":"setValue",opts.originalValue);
});
},enable:function(jq){
return jq.each(function(){
$.data(this,"slider").options.disabled=false;
_cad(this);
});
},disable:function(jq){
return jq.each(function(){
$.data(this,"slider").options.disabled=true;
_cad(this);
});
}};
$.fn.slider.parseOptions=function(_cd5){
var t=$(_cd5);
return $.extend({},$.parser.parseOptions(_cd5,["width","height","mode",{reversed:"boolean",showTip:"boolean",range:"boolean",min:"number",max:"number",step:"number"}]),{value:(t.val()||undefined),disabled:(t.attr("disabled")?true:undefined),rule:(t.attr("rule")?eval(t.attr("rule")):undefined)});
};
$.fn.slider.defaults={width:"auto",height:"auto",mode:"h",reversed:false,showTip:false,disabled:false,range:false,value:0,separator:",",min:0,max:100,step:1,rule:[],tipFormatter:function(_cd6){
return _cd6;
},converter:{toPosition:function(_cd7,size){
var opts=$(this).slider("options");
var p=(_cd7-opts.min)/(opts.max-opts.min)*size;
return p;
},toValue:function(pos,size){
var opts=$(this).slider("options");
var v=opts.min+(opts.max-opts.min)*(pos/size);
return v;
}},onChange:function(_cd8,_cd9){
},onSlideStart:function(_cda){
},onSlideEnd:function(_cdb){
},onComplete:function(_cdc){
}};
})(jQuery);


/** **********************************************EASYUI默认属性设置*********************************************** */
$.extend($.fn.textbox.defaults, {
	"icons" : [ {
		"iconCls" : "icon-clear",
		handler : function(e) {
			$(e.data.target).textbox('clear').textbox('textbox').focus();
		}
	} ]
});
$.extend($.fn.combo.defaults, {
	"panelHeight" : "auto",
	"editable" : false,
	"icons" : [ {
		"iconCls" : "icon-clear",
		handler : function(e) {
			$(e.data.target).combobox('clear');
		}
	} ]
});
$.extend($.fn.combobox.defaults, {
	"panelHeight" : "auto",
	"editable" : false,
	"icons" : [ {
		"iconCls" : "icon-clear",
		handler : function(e) {
			$(e.data.target).combobox('clear');
		}
	} ]
});
$.extend($.fn.combotree.defaults, {
	"icons" : [ {
		"iconCls" : "icon-clear",
		handler : function(e) {
			$(e.data.target).combotree('clear');
		}
	} ]
});
$.extend($.fn.numberbox.defaults, {
	"icons" : [ {
		"iconCls" : "icon-clear",
		handler : function(e) {
			$(e.data.target).numberbox('clear');
		}
	} ]
});

$.extend($.fn.searchbox.defaults, {
	"icons" : [ {
		"iconCls" : "icon-clear",
		handler : function(e) {
			$(e.data.target).numberbox('clear');
		}
	} ]
});

// 定义日期默认的按钮
var datebox_buttons = $.fn.datebox.defaults.buttons;
datebox_buttons.splice(1, 0, {
	"text" : "清空",
	"handler" : function(target) {
		$(target).datebox("setText", "");
		$(target).datebox("setValue", "");
		$(target).datebox("hidePanel");
	}
});

var datetimebox_buttons = $.fn.datetimebox.defaults.buttons;
datetimebox_buttons.push({
	"text" : "清空",
	"handler" : function(target) {
		$(target).datetimebox("setText", "");
		$(target).datebox("setValue", "");
		$(target).datetimebox("hidePanel");
	}
});

$.extend($.fn.combo.defaults, {
	"panelHeight" : "auto",
	"editable" : false,
	"width" : 150
});
$.extend($.fn.combogrid.defaults, {
	"panelHeight" : "auto",
	"editable" : false
});
$.extend($.fn.combotree.defaults, {
	"panelHeight" : "auto",
	"editable" : false
});
$.extend($.fn.numberbox.defaults, {
	"min" : 0,
	"max" : 99999999999,
	"precision" : 4
});
$.extend($.fn.searchbox.defaults, {
	"editable" : false
});

$.extend($.fn.datagrid.defaults, {
	"rownumbers" : true,
	"fitColumns" : true,
	/*"selectOnCheck":false,*/
	"pageSize" : 15,
	"pageList" : [ 15, 30, 50, 100 ]/*,
	"onSelect" :function(index,row){
		$(this).datagrid("clearSelections");
		$(this).datagrid("clearChecked");
		$(this).datagrid("checkRow",index);
	}*/,
	onHeaderContextMenu:function(e,field){
		e.preventDefault();
		
		if($("[customcolumns]").length>0){
			return;
		}
		
		var _this=this;
		
		var wid=new Date().getTime();
		
		$("body").append("<div customcolumns id='"+wid+"' style='padding:5px;'></div>")
		
		$("#"+wid).dialog({
			    title: '自定义列',
			    iconCls:'icon-customize',
			    width: 500,
			    height: '80%',
			    closed: false,
			    cache: false,
			    href: 'view?page=common/fragment/columns',
			    modal: true,
			    onClose:function(){
			    	$('#'+wid).dialog('destroy',true);
			    },
			    buttons: [{
                    iconCls:'icon-ok',
                    handler:function(){
                       var lis=$("#_custom_columns_hidden_columns li");
                       var fields=[];
                       Utils.each(lis,function(i,d){
                    	   fields.push($(d).attr("field"));
                       });
                       /*if(fields.length==0){
                    	   ext.tip.warn(tipSelectAtLeastOne);
                    	   return;
                       }*/
                       
                       if($("#_custom_columns_display_columns li").length==0){
                    	   ext.tip.warn("至少显示一列");
                    	   return;
                       }
                       
                       var setting={
                    		   settingType:"HIDDEN_COLUMNS",
                               settingKey:location.search+"#"+$(_this).datagrid("options").id,
                               settingValue:fields.toString()
                       }
                       
                       ext.ajax.post(path+"user/settings/columns",setting,function(data){
                    	   if(data.code==OK){
                    		   ext.tip.suc();
                    		   $("#"+wid).dialog("close");
                    		   return;
                    	   }
                    	   ext.tip.error();
                       })
                    }
                },{
                   iconCls:'icon-cancel',
                   handler:function(){
                	   $('#'+wid).dialog('close');
                    }
                }],
                onLoad:function(data){
            		
            		var key=location.search+"#"+$(_this).datagrid("options").id;
            		
            		var cs=$(_this).datagrid('getColumnFields');
    				var fcs=$(_this).datagrid('getColumnFields', true);
    				
    				var columns=[];
    				
    				Utils.each(cs,function(i,c){
    					columns.push({field:c,title:$(_this).datagrid("getColumnOption",c).title});
    				});
    				
    				Utils.each(fcs,function(i,c){
    					columns.push({field:c,title:$(_this).datagrid("getColumnOption",c).title});
    				});
    				
    				
    				Utils.each(columns,function(i,d){
    					$("#_custom_columns_display_columns").append("<li class='items' onclick='_custom_columns_click(this)' field='"+d.field+"'>"+d.title+"</li>");
    				})
    				
    				ext.ajax.post("user/settings/code",{type:"HIDDEN_COLUMNS",code:key},function(data){
    					if(data.code==OK&&data.data){
    						var fields=data.data.settingValue.split(",");
        					Utils.each(fields,function(i,d){
        				        $("#_custom_columns_hidden_columns").append($("li[field="+d+"]"));
        				    });
    					}
    					
    				});
    				
                }
		});
	}
});

function _custom_columns_click(e){
	if($($(e).parent()).attr("id")=="_custom_columns_display_columns"){
		$("#_custom_columns_hidden_columns").append($(e));
	}else{
		$("#_custom_columns_display_columns").append($(e));
	}
}

$.extend($.fn.datebox.defaults, {
	"editable" : false
});
$.extend($.fn.datetimebox.defaults, {
	"editable" : false
});
$.extend($.fn.dialog.defaults, {
	"modal" : true
});
$.extend($.fn.window.defaults, {
	"modal" : true
});

/** **********************************************EASYUI默认属性设置*********************************************** */

/**
 * JS日历封装，操作时间
 * 解决JS Date的各种奇葩问题
 * @author 高飞  252878950@qq.com 
 * 主页:http://www.xdemo.org/calendar-js/
 */
(function(target) {


	/**
	 * Calendar构造方法
	 * 无参:默认new Date()
	 * 一个参数:数字类型，等于new Date(数字);
	 * 2-6个参数:必须都是数字类型，分别对应 年、月、日、时、分、秒
	 */
	var Calendar = function() {
		switch (arguments.length) {
			case 0:
				this._date_ = new Date()
				return this;
			case 1:
				if (typeof arguments[0] == 'number') {
					try{
						//以此支持字符串的时间戳
						this._date_ = new Date(parseInt(arguments[0]));
					}catch(e){
						this._date_ = new Date(Date.parse(arguments[0]));
					}
					return this;
				}
				if (typeof arguments[0] == 'string') {
					this._date_ = new Date(arguments[0]);
				}
				if(arguments[0] instanceof Date){
					this._date_=arguments[0];
				}
				return this;
			default:
				this._date_ = new Date(arguments[0] || 1970, (arguments[1] - 1) || 0, arguments[2] || 1, arguments[3] || 0, arguments[4] || 0, arguments[5] || 0);
				return this;
		}
	}

	Calendar.field = {
		/**
		 * 年
		 */
		YEAR : 1,
		/**
		 * 月 
		 */
		MONTH : 2,
		/**
		 * 日 
		 */
		DAY_OF_MONTH : 3,
		/**
		 * 时 
		 */
		HOUR : 4,
		/**
		 * 分 
		 */
		MINUTE : 5,
		/**
		 * 秒 
		 */
		SECOND : 6,
		
		/**
		 * 天数 
		 */
		DAY:7,
		/**
		 * 周数
		 */
		WEEK:8
	};
	
	
	/**
	 * 判断是否是闰年
	 * @param {Object} year
	 */
	Calendar.isLeapYear=function(year){
		return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
	}
	
	/**
	 * 判断Date1是否在Date2之前 
	 * @param {Object} date1
	 * @param {Object} date2
	 */
	Calendar.isBefore=function(date1,date2){
		return date1.getTime()>date2.getTime();
	}
	
	/**
	 * 获取指定年份，月份的最后一天 
	 * @param {Object} year
	 * @param {Object} month
	 */
	Calendar.lastDayOfMonth=function(year,month){
		return [31, null, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31][month-1] || (((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) ? 29 : 28);
	}
	
	/**
	 * 获取两个日期时间差 
	 * @param {Object} date1
	 * @param {Object} date2
	 * @param {Object} field Calendar.field
	 */
	Calendar.diff=function(date1,date2,field){
		if(date1.getTime()>date2.getTime()){
			throw new Error("第一个日期参数必须在第二个日期之前");
			return;
		}
		switch (field) {
				case 1://年
					var year=date2.getFullYear()-date1.getFullYear();
					if(date1.getMonth()>date2.getMonth()){
						year-=1;
					}else{
						if(date1.getDate()>date2.getDate()){
							year-=1;
						}else{
							if(date1.getHours()>date2.getHours()){
								year-=1;
							}else{
								if(date1.getMinutes()>date2.getMinutes()){
									year-=1;
								}else{
									if(date1.getSeconds()>date2.getSeconds()){
										year-=1;
									}
								}
							}
						}
					}
					return year;
				case 2://月
					var year=this.diff(date1,date2,Calendar.field.YEAR);
					var month=date2.getMonth()-date1.getMonth();
					if(date1.getDate()>date2.getDate()){
							month-=1;
						}else{
							if(date1.getHours()>date2.getHours()){
								month-=1;
							}else{
								if(date1.getMinutes()>date2.getMinutes()){
									month-=1;
								}else{
									if(date1.getSeconds()>date2.getSeconds()){
										month-=1;
									}
								}
							}
						}
					return year*12+month;
				case 4://时
					return Math.floor((date2.getTime()-date1.getTime())/(60*60*1000));
				case 5://分
					return Math.floor((date2.getTime()-date1.getTime())/(60*1000));
				case 6://秒
					return Math.floor((date2.getTime()-date1.getTime())/(1000));
				case 7://天
					return Math.floor((date2.getTime()-date1.getTime())/(24*60*60*1000));
				case 8://周数
					return Math.floor(Math.floor((date2.getTime()-date1.getTime())/(24*60*60*1000))/7);
				default:
					throw new Error("unknown Calendar field");
			}
	}

	Calendar.prototype = {

		/**
		 * 当前时间
		 */
		now: function() {
			this._date_=new Date();
			return this;
		},
		/**
		 * 时间操作，在时间的某个字段上加上一定的数字（正负数）
		 * @param {Object} field
		 * @param {Object} number
		 */
		add: function(field, number) {
			switch (field) {
				case 1:
					this._date_ = new Date(this._date_.getFullYear() + number, this._date_.getMonth(), this._date_.getDate(), this._date_.getHours(), this._date_.getMinutes(), this._date_.getSeconds());
					return this;
				case 2:
					this._date_ = new Date(this._date_.getFullYear(), this._date_.getMonth() + number, this._date_.getDate(), this._date_.getHours(), this._date_.getMinutes(), this._date_.getSeconds());
					return this;
				case 3:
					this._date_ = new Date(this._date_.getFullYear(), this._date_.getMonth(), this._date_.getDate() + number, this._date_.getHours(), this._date_.getMinutes(), this._date_.getSeconds());
					return this;
				case 4:
					this._date_ = new Date(this._date_.getTime() + (3600000 * number));
					return this;
				case 5:
					this._date_ = new Date(this._date_.getTime() + (60000 * number));
					return this;
				case 6:
					this._date_ = new Date(this._date_.getTime() + (1000 * number));
					return this;
				default:
					throw new Error("unknown Calendar field");
			}
		},
		/**
		 * 设置时间 第一个参数 年|月|日|时|分|秒 之一
		 * @param {Object} field 
		 * 		Calendar.field.YEAR
		 * 		Calendar.field.MONTH
		 *  	Calendar.field.DAY_OF_MONTH
		 *  	Calendar.field.HOUR
		 *  	Calendar.field.MINUTE
		 *  	Calendar.field.SECOND
		 * @param {Object} number
		 */
		set: function(field, number) {
			switch (field) {
				case 1:
					this._date_ = new Date(number, this._date_.getMonth(), this._date_.getDate(), this._date_.getHours(), this._date_.getMinutes(), this._date_.getSeconds());
					return this;
				case 2:
					this._date_ = new Date(this._date_.getFullYear(), number-1, this._date_.getDate(), this._date_.getHours(), this._date_.getMinutes(), this._date_.getSeconds());
					return this;
				case 3:
					this._date_ = new Date(this._date_.getFullYear(), this._date_.getMonth(), number, this._date_.getHours(), this._date_.getMinutes(), this._date_.getSeconds());
					return this;
				case 4:
					this._date_ = new Date(this._date_.getFullYear(), this._date_.getMonth(), this._date_.getDate(), number, this._date_.getMinutes(), this._date_.getSeconds());
					return this;
				case 5:
					this._date_ = new Date(this._date_.getFullYear(), this._date_.getMonth(), this._date_.getDate(), this._date_.getHours(), number, this._date_.getSeconds());
					return this;
				case 6:
					this._date_ = new Date(this._date_.getFullYear(), this._date_.getMonth(), this._date_.getDate(), this._date_.getHours(), this._date_.getMinutes(), number);
					return this;
				default:
					throw new Error("unknown Calendar field");
			}
		},
		/**
		 * GET
		 * @param {Object} field
		 */
		get: function(field) {
			switch (field) {
				case 1:
					return this._date_.getFullYear();
				case 2:
					return this._date_.getMonth()+1;
				case 3:
					return this._date_.getDate();
				case 4:
					return this._date_.getHours();
				case 5:
					return this._date_.getMinutes();
				case 6:
					return this._date_.getSeconds();
				default:
					throw new Error("unknown Calendar field");
			}
		},
		/**
		 * 是否是闰年
		 */
		isLeapYear: function() {
			var year = this._date_.getFullYear();
			return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
		},
		/**
		 * 获取一年的第多少周
		 */
		weekOfYear: function() {
			var now = this._date_,
				year = now.getFullYear(),
				month = now.getMonth(),
				days = now.getDate();

			//那一天是那一年中的第多少天
			for (var i = 0; i < month; i++) {
				days += this.getDaysOfMonth(year, i);
			}

			//那一年第一天是星期几
			var yearFirstDay = new Date(year, 0, 1).getDay() || 7;

			var week = null;
			if (yearFirstDay == 1) {
				week = Math.ceil(days / yearFirstDay);
			} else {
				days -= (7 - yearFirstDay + 1);
				week = Math.ceil(days / 7) + 1;
			}

			return week;
		},
		/**
		 * 格式化日期
		 * @param {Object} format y{年} M{月} d{日} H{24时} h{12时} m{分} s{秒} S{毫秒数} q{季度}
		 */
		format: function(format) {
			var o = {
				"M+": this._date_.getMonth() + 1, //月份 
				"d+": this._date_.getDate(), //日 
				"H+": this._date_.getHours(), //24小时 
				"h+": this._date_.getHours() % 12 == 0 ? 12 : this._date_.getHours() % 12, //12小时
				"m+": this._date_.getMinutes(), //分 
				"s+": this._date_.getSeconds(), //秒 
				"q+": Math.floor((this.getMonth() + 3) / 3), //季度 
				"S": this._date_.getMilliseconds() //毫秒 
			};
			if (/(y+)/.test(format)) format = format.replace(RegExp.$1, (this._date_.getFullYear() + "").substr(4 - RegExp.$1.length));
			for (var k in o)
				if (new RegExp("(" + k + ")").test(format)) format = format.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
			return format;
		},
		/**
		 * 设置时间
		 * @param {Object} date JS Date类型或者数字类型
		 */
		setTime: function(date) {
			if (date instanceof Date) {
				this._date_ = date;;
			}
			if (typeof date == 'number') {
				this._date_ = new Date(date);
			}
			return this;
		},
		/**
		 * 获取时间，返回Date类型
		 */
		getTime: function() {
			return this._date_;
		},
		/**
		 * 获取时间，返回Long类型
		 */
		getTimeLong: function() {
			return this._date_.getTime();
		},
		/**
		 * 获取对应月份的天数
		 * @param {Object} year
		 * @param {Object} month
		 */
		getDaysOfMonth: function() {
			var year = this._date_.getFullYear();
			var month = this._date_.getMonth();
			return [31, null, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31][month] || (this.isLeapYear(year) ? 29 : 28);
		},
		/**
		 * 获取年份
		 */
		getYear: function() {
			return this._date_.getFullYear();
		},
		/**
		 * 获取月份
		 */
		getMonth: function() {
			return this._date_.getMonth() + 1;
		},
		/**
		 * 获取日期
		 */
		getDayOfMonth: function() {
			return this._date_.getDate();
		},
		/**
		 * 获取小时数
		 */
		getHours: function() {
			return this._date_.getHours();
		},
		/**
		 * 获取分钟数 
		 */
		getMinutes: function() {
			return this._date_.getMinutes();
		},
		/**
		 * 获取秒数
		 */
		getSeconds: function() {
			return this._date_.getSeconds();
		},
		/**
		 * 获取毫秒数
		 */
		getMilliseconds: function() {
			return this._date_.getTime();
		},
		/**
		 * 转字符串
		 */
		toString: function() {
			return this.format("yyyy-MM-dd HH:mm:ss");
		}
	};
	target.Calendar = Calendar;
})(window);

var Utils = Utils = Utils || {};

/**
 * 判断字符串是否为空
 * 
 * @param str
 * @returns {Boolean}
 */
Utils.isEmpty = function(str) {
	if (str == null || str == "" || str == undefined)
		return true;
	return false;
};

/**
 * 判断对象是否为空，undefined也是为空
 */
Utils.isNull=function(obj){
	if(obj==undefined||obj==null)return true;
	return false;
};


/**
 * 随机数-整数
 * @param {Object} min 最小值
 * @param {Object} max 最大值
 */
Utils.randomInt=function(min,max){
	//因为floor是向下取整，所以max+1才能取到Max的最大值
	return Math.floor(min+Math.random()*((max+1)-min));
};

/**
 * 随机数-浮点数
 * @param {Object} min 最小值
 * @param {Object} max 最大值
 * @param {Object} precision 精度
 */
Utils.randomFloat=function(min,max,precision){
	return new Number(min+Math.random()*(max-min)).toFixed(precision);
};

/**
 * 生成随机字符串
 * @param {Object} length 长度
 * @param {Object} containNumber 是否包含数字
 * @param {Object} upperCase 转大写？
 */
Utils.randomString=function(length,containNumber,upperCase){
	var chars=['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'];
	var target=[];
	var min=0,max=61;
	
	if(!containNumber)min=10;
	for(var i=0;i<length;i++){
		target[i]=chars[Math.floor(min+Math.random()*((max+1)-min))];
	}
	
	return upperCase?target.join("").toUpperCase():target.join("");
};

/**
 * 判断是否是数字,数字类型或者数字字符串
 * @param {Object} str
 */
Utils.isNumber=function(val){
	if(+val===val)return true;
	if(typeof val=='string'){
		if(val.indexOf("-")==0)val=val.replace("-","");
		return val.match(/\d*/i)==val;
	}
	return false;
};

/**
 * 判断是否是数字,数字类型或者数字字符串
 * @param {Object} str
 */
Utils.isFloat=function(val){
	if(+val===val)return true;
	if(typeof val=='string'){
		if(val.indexOf("-")==0)val=val.replace("-","");
		return /^\d+(\.\d+)?$/.test(val);
	}
	return false;
};

/**
 * 判断对象是否是数组
 */
Utils.isArray=function(value){
	return value&&value.constructor == Array;
};

/**
 * 判断对象是否是某个类型
 * @param {Object} value
 * @param {Object} type
 */
Utils.isTypeOf=function(value,type){
	return (typeof value==type);
};

/**
 * 判断对象是否是某个类型的实例
 * @param {Object} value
 * @param {Object} type
 */
Utils.isInstanceOf=function(value,type){
	return value instanceof type;
};

/**
 * 去除字符串两端空格
 * @param {Object} str
 */
Utils.trim=function(str){
	return str.replace(/(^\s*)|(\s*$)/g,"");
};

/**
 * 去除字符串左边的空格
 * @param {String}  str 进行处理的字符串
 * @return          处理过的字符串
 * @type String
 * @version 1.0 
 */
Utils.lTrim=function(str){
    return str.replace(/(^[\s]*)/g, "");
};
/**
 * 去除字符串右边的空格
 * @param {String}  str 进行处理的字符串
 * @return          处理过的字符串
 * @type String
 * @version 1.0 
 */
Utils.rTrim=function(str){
    return str.replace(/([\s]*$)/g, "");
};

/**
 * 字符串替换
 * @param {Object} src 源字符串
 * @param {Object} str1 替换前的字符串
 * @param {Object} str2  替换后的字符串
 */
Utils.replaceAll=function(src,str1,str2){
	return src.replace(new RegExp(str1,"gm"),str2);
};

/**
 * 长度限制
 * @param {string} str
 */
Utils.length=function(str){
	 return str.replace(/[^\x00-\xff]/g,"**").length;
};

/**
 * 加法
 */
Utils.add = function(n1, n2, precision) {
	var baseNum, baseNum1, baseNum2;
	try {
		baseNum1 = n1.toString().split(".")[1].length;
	} catch (e) {
		baseNum1 = 0;
	}
	try {
		baseNum2 = n2.toString().split(".")[1].length;
	} catch (e) {
		baseNum2 = 0;
	}
	baseNum = Math.pow(10, Math.max(baseNum1, baseNum2));
	var n = (n1 * baseNum + n2 * baseNum) / baseNum;
	if (precision == undefined)
		return n;
	return new Number(n).toFixed(precision);
};

/**
 * 减法
 */
Utils.sub = function(n1, n2, precision) {
	var baseNum, baseNum1, baseNum2;
	var _precision;// 精度
	try {
		baseNum1 = n1.toString().split(".")[1].length;
	} catch (e) {
		baseNum1 = 0;
	}
	try {
		baseNum2 = n2.toString().split(".")[1].length;
	} catch (e) {
		baseNum2 = 0;
	}
	baseNum = Math.pow(10, Math.max(baseNum1, baseNum2));
	_precision = (baseNum1 >= baseNum2) ? baseNum1 : baseNum2;
	var n = ((n1 * baseNum - n2 * baseNum) / baseNum).toFixed(_precision);
	if (precision == undefined)
		return n;
	return new Number(n).toFixed(precision);
};
/**
 * 乘法
 */
Utils.mul = function(n1, n2, precision) {
	var baseNum = 0;
	try {
		baseNum += n1.toString().split(".")[1].length;
	} catch (e) {
		baseNum+= 0;
	}
	try {
		baseNum += n2.toString().split(".")[1].length;
	} catch (e) {
		baseNum+=0;
	}
	var n = Number(n1.toString().replace(".", "")) * Number(n2.toString().replace(".", "")) / Math.pow(10, baseNum);
	if (precision == undefined)
		return n;
	return new Number(n).toFixed(precision);

};
/**
 * 除法
 */
Utils.div = function(n1, n2, precision) {

	var baseNum1 = 0, baseNum2 = 0;
	var baseNum3, baseNum4;
	try {
		baseNum1 = n1.toString().split(".")[1].length;
	} catch (e) {
		baseNum1 = 0;
	}
	try {
		baseNum2 = n2.toString().split(".")[1].length;
	} catch (e) {
		baseNum2 = 0;
	}
	with (Math) {
		baseNum3 = Number(n1.toString().replace(".", ""));
		baseNum4 = Number(n2.toString().replace(".", ""));
		var n = (baseNum3 / baseNum4) * pow(10, baseNum2 - baseNum1);
		if (precision == undefined)
			return n;
		return new Number(n).toFixed(precision);
	}
};

/**
 * 数组遍历器
 */
Utils.each=function(array,callback){
	for(var i=0;i<array.length;i++){
		callback(i,array[i]);
	}
};

Utils.toTree=function(array,idKey,textKey,parentKey,state){
	
	function getChildren(data, idValue) {
		var children = [];
		for (var i = 0; i < data.length; i++) {
			if (data[i][parentKey] == idValue) {
				data[i].text = data[i][textKey];
				data[i].id = data[i][idKey];
				data[i].state =state;
				data[i].children = getChildren(data, data[i][idKey]);
				children.push(data[i]);
			}
		}
		return children;
	};
	
	return getChildren(array, null);
};

var ext = ext = ext || {};
ext.easyui={};
ext.ajax={};
ext.loading={};
ext.tip={};
ext.form={};
ext.alert={};

//表格
ext.easyui.grid = {
	append:function(gridId,row){
		$('#' + gridId).datagrid("insertRow",{index:0,row:row});
	},
	appendAndEdit:function(gridId,row){
		$('#' + gridId).datagrid("insertRow",{index:0,row:row});
		$('#' + gridId).datagrid("beginEdit",0);
	},
	/**
	 * 搜索
	 * @param gridId 表格ID
	 * @param searchFormId 搜索表单的ID
	 */
	search : function(gridId, searchFormId) {
		$('#' + gridId).datagrid("reload", ext.form.getFormAsJson(searchFormId));
	},
	/**
	 * 搜索2 自定义搜索
	 * @param gridId 表格ID
	 * @param jsonFilter JSON对象
	 */
	search2 : function(gridId, jsonFilter) {
		$('#' + gridId).datagrid("reload", filter);
	},
	//获取选中行
	getSelections : function(gridId) {
		return $("#" + gridId).datagrid("getSelections");
	},
	//获取唯一的选中的行
	getSelected : function(gridId) {
		var rows = ext.easyui.grid.getSelections(gridId);
		if (rows.length > 1) {
			ext.tip.warn(tipSelectOnlyOne);
			return null;
		}
		if (rows.length == 0) {
			ext.tip.warn(tipSelectAtLeastOne);
			return null;
		}
		return rows[0];
	},
	/**
	 * 检查表格是否包含了新增的行数据
	 * @param grid
	 * @param rowData
	 * @returns {Boolean}
	 */
	contains:function(grid,rowData){
		var data=$("#"+grid).datagrid("getData");
		if(data.total==0){
			return false;
		}else{
			for(var i=0;i<data.rows.length;i++){
				if(data.rows[i]["ID"]==rowData["ID"]){
					return true
				}
			}
			return false;
		}
	},
	contains2:function(grid,rowData,idField){
		var data=$("#"+grid).datagrid("getData");
		if(data.total==0){
			return false;
		}else{
			for(var i=0;i<data.rows.length;i++){
				if(data.rows[i][idField]==rowData[idField]){
					return true
				}
			}
			return false;
		}
	},
	/**
	 * 获取表格的数据数
	 * @param gridId
	 * @returns
	 */
	size:function(gridId){
		var data=$("#"+gridId).datagrid("getData");
		return data.total;
	},
	/**
	 * 通过Index获取行
	 * @param gridId
	 * @param index
	 * @returns
	 */
	getRowByIndex:function(gridId,index){
		var datas=$("#"+gridId).datagrid("getData");
		for(var i=0;i<datas.rows.length;i++){
			if(i==index){
				return datas.rows[i];
			}
		}
	},
	/**
	 * 获取行索引号
	 * @param gridId
	 * @param rowData
	 * @returns
	 */
	getRowIndex:function(gridId,rowData){
		return $("#"+gridId).datagrid("getRowIndex",rowData);
	},
	/**
	 * 删除行
	 * @param gridId
	 * @param index
	 */
	removeRow:function(gridId,index){
		$("#"+gridId).datagrid("deleteRow",index);
	},
	/**
	 * 清空DataGrid
	 * @param gridId
	 */
	empty:function(gridId){
		var rows=$("#"+gridId).datagrid("getRows");
		for(var i=rows.length-1;i>=0;i--){
			$("#"+gridId).datagrid("deleteRow",$("#"+gridId).datagrid("getRowIndex",rows[i]));
		}
	}
};
/**
 * ext表单操作
 */
ext.easyui.form={
		/**
		 * 表单验证
		 */
		valid:function(id){
			var isValid = $("#"+id).form('validate');
			return isValid;
		},
		/**
		 * 表单提交
		 * @param id 表单ID
		 * @param url 表单提交地址
		 * @param success 成功回调函数
		 * @param error 失败回调函数
		 */
		submit:function(id,url,success,error){
			if(!ext.form.valid(id))return;
			Loading.show(tipSubmiting);
			$.ajax({
				url:url,
				type:"post",
				data:$("#"+id).serialize(),
				dataType:"json",
				success:function(data){
					Loading.hide();
					if(!Utils.isNull(success)&&success instanceof Function){
						success(data);
					}
				},error:function(data){
					Loading.hide();
					if(!Utils.isNull(error)&&error instanceof Function){
						error(data);
					}
				}
			});
		},
		clear:function(id){
			$("#"+id).form("clear");
		}
};

ext.easyui.window={
		//获取按钮
		button:function(icon,text,handler){
			var b={};
			b["iconCls"]=icon==undefined?null:icon;
			b["text"]=text==undefined?"&nbsp;":text;
			b["handler"]=handler==undefined?null:handler;
			return b;
		},
		/**
		 * 打开一个窗口,无需绑定到具体元素上，这里的元素都是临时生产的
		 * @param title 窗口标题
		 * @param width 宽度
		 * @param height 高度
		 * @param url 内容地址
		 * @param buttons 按钮，数组通过ext.window.button("图标","按钮文字","回调函数");
		 * @param onLoadCallback 加载时回调
		 * @param onCloseCallback 关闭时执行的回调方法
		 * @returns 返回当前窗口的ID，调用close方法的时候要用
		 */
		open:function(title,width,height,url,buttons,onLoadCallback,onCloseCallback){
			//当前的时间戳作为新增的div的ID，这个ID要返回，关闭的时候要用
			var wid=new Date().getTime();
			$("body").append("<div id='"+wid+"'></div>");
			$("#"+wid).dialog({
				id:wid,
				title:title,
				width:width,
				height:height,
				href:url,
				modal:true,
				maximizable:true,
				minimizable:false,
				resizable:true,
				buttons:buttons,
				onClose:function(){
					$("#"+wid).dialog("destroy");
					$("#"+wid).remove();
					if( typeof onCloseCallback === 'function' ){
						onCloseCallback();
					}
				},onLoad:function(){
					if( typeof onLoadCallback === 'function' ){
						onLoadCallback();
					}
				}
			});
			return wid;
		},
		close:function(wid){
			$("#"+wid).dialog("destroy");
			$("#"+wid).remove();
		}
};

ext.easyui.combobox=function(id,url,idFiled,textFiled){
	
};

ext.easyui.datebox={
			formatter:function(date){
				return date.format("yyyy-MM-dd");
			}
};

ext.easyui.datetimebox={
		formatter:function(date){
			return date.format("yyyy-MM-dd HH:mm:ss");
		}
};

ext.easyui.tree={
			getTreeData:function(arrayData,valueField,textField,pid){
				function getChildren(parent){
					var children=[];
					for(var i=0;i<arrayData.length;i++){
						if(arrayData[i][pid]==parent.id){
							children.push({id:arrayData[i][valueField],text:arrayData[i][textField]});
						}
					}
					for(var i=0;i<children.length;i++){
						children[i].children=getChildren(children[i]);
					}
					return children;
				}
				
				var top=[];
				for(var i=0;i<arrayData.length;i++){
					if(arrayData[i][pid]==null){
						top.push({id:arrayData[i][valueField],text:arrayData[i][textField]});
					}
				}
				for(var i=0;i<top.length;i++){
					top[i].children=getChildren(top[i]);
				}
			return top;
		},
		select:function(treeId,nodeId){
			var node = $('#'+treeId).tree('find',nodeId);
            $('#'+treeId).tree("expandTo",node.target).tree('select', node.target);
		}
};

/**
 * 调用Ajax的GET方法
 * @param url
 * @param successCallback
 * @param errorCallback
 */
ext.ajax.get=function(url,successCallback,errorCallback){
	ajax(url,null,'GET',successCallback,errorCallback);
};
/**
 * 调用Ajax的POST方法
 * @param url
 * @param params
 * @param successCallback
 * @param errorCallback
 */
ext.ajax.post=function(url,params,successCallback,errorCallback){
	ajax(url,params,'POST',successCallback,errorCallback);
};

ext.ajax.file=function(fileInputId,dir,single,sucFunc,errFunc){
	$.ajaxFileUpload({
	    type:'POST',
	    url : path+'attachment/upload',
	    secureuri : false,
	    data : {dir:dir,single:single},
	    fileElementId :fileInputId,
	    dataType : 'json',
	    success : function(data) { //上传成功后的回调。
	        if(typeof(sucFunc)==="function"){
	        	sucFunc(data);
	        }
	    },
	    error : function(responseText) {
	    	if(typeof(errFunc)==="function"){
	    		errFunc(responseText);
	        }
	    }
	});
};

ext.ajax.sendJson=function(url,params,successCallback,errorCallback){
	ext.loading.show();
	$.ajax({
		url : url,
		type : "POST",
		dataType : 'json',
		data : JSON.stringify(params),
		contentType:'application/json',
		success : function(data,textStatus) {
			ext.loading.hide();
			if(successCallback==undefined||successCallback==null)return;
			successCallback(data);
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			ext.loading.hide();
			if(errorCallback==undefined||errorCallback==null)return;
			var rs = JSON.parse(XMLHttpRequest.responseText);
			errorCallback(rs);
		}
	});
};

function ajax(url,params,type,successCallback,errorCallback){
	ext.loading.show();
	$.ajax({
		url : url,
		type : type,
		dataType : 'json',
		data : params||null,
		success : function(data,textStatus) {
			ext.loading.hide();
			if(successCallback==undefined||successCallback==null)return;
			successCallback(data);
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			ext.loading.hide();
			if(errorCallback==undefined||errorCallback==null)return;
			var rs = JSON.parse(XMLHttpRequest.responseText);
			errorCallback(rs);
		}
	});
};



ext.loading.show=function(text) {
	ext.loading.hide();
	$("<div id='_uiloading' class=\"window-mask\" style='z-index:9998'></div>").css({
		display : "block",
		width : "100%",
		height : $(window).height()
	}).appendTo("body");
	
	$("<div id='_uiloading_text' class=\"datagrid-mask-msg\" style='z-index:9999;height:10px;line-height:10px;font-size:10px;'></div>").html(text||"请稍等(Loading)...").appendTo("body").css({
		display : "block",
		left : ($(document.body).outerWidth(true) - 190) / 2,
		top : ($(window).height() - 45) / 2
	});
};

ext.loading.hide=function() {
	$("#_uiloading").remove();
	$("#_uiloading_text").remove();
};



ext.alert.suc=function(msg,title){
	$.messager.alert(title,msg,'info');
};

ext.alert.warn=function(msg,title){
	$.messager.alert(title||"",msg,'warning');
};

ext.alert.error=function(msg,title){
	$.messager.alert(title||"",msg,'error');
};

ext.alert.question=function(msg,title){
	$.messager.alert(title||"",msg,'question');
};

ext.alert.confirm=function(title,msg,callback){
	$.messager.confirm(title, msg, function(r){
        if (r){
           callback();
        }
    });
};

ext.alert.prompt=function(title,msg,callback){
	$.messager.prompt(title, msg, function(r){
		if(r!=undefined){
			if(r==""){
				ext.alert.prompt(title,msg,callback);
			}else{
				callback(r);
			}
		}
    });
};
ext.tip.suc=function(msg,title){
	
	parent.$.toast({ 
		  heading:title,
		  text : msg||successTip, 
		  showHideTransition : 'fade',  // It can be plain, fade or slide
		  bgColor : 'rgba(76, 175, 80, 0.85)',              // Background color for toast
		  textColor : 'white',            // text color
		  allowToastClose : true,       // Show the close button or not
		  hideAfter : 3000,              // `false` to make it sticky or time in miliseconds to hide after
		  stack : false,                     // `fakse` to show one stack at a time count showing the number of toasts that can be shown at once
		  textAlign : 'center',            // Alignment of text i.e. left, right, center
		  position : 'top-center'       // bottom-left or bottom-right or bottom-center or top-left or top-right or top-center or mid-center or an object representing the left, right, top, bottom values to position the toast on page
	});
};
ext.tip.error=function(msg,title){
	parent.$.toast({ 
		  heading:title,
		  text : msg||errorTip, 
		  showHideTransition : 'fade',  // It can be plain, fade or slide
		  bgColor : 'rgba(244, 67, 54, 0.85)',              // Background color for toast
		  textColor : 'white',            // text color
		  allowToastClose : true,       // Show the close button or not
		  hideAfter : 3000,              // `false` to make it sticky or time in miliseconds to hide after
		  stack : false,                     // `fakse` to show one stack at a time count showing the number of toasts that can be shown at once
		  textAlign : 'center',            // Alignment of text i.e. left, right, center
		  position : 'top-center'       // bottom-left or bottom-right or bottom-center or top-left or top-right or top-center or mid-center or an object representing the left, right, top, bottom values to position the toast on page
	});
};
ext.tip.warn=function(msg,title){
	$.toast({ 
		  heading:title,
		  text : msg||errorTip, 
		  showHideTransition : 'fade',  // It can be plain, fade or slide
		  bgColor : 'rgba(255, 152, 0, 0.85)',              // Background color for toast
		  textColor : 'white',            // text color
		  allowToastClose : true,       // Show the close button or not
		  hideAfter : 3000,              // `false` to make it sticky or time in miliseconds to hide after
		  stack : false,                     // `fakse` to show one stack at a time count showing the number of toasts that can be shown at once
		  textAlign : 'center',            // Alignment of text i.e. left, right, center
		  position : 'top-center'       // bottom-left or bottom-right or bottom-center or top-left or top-right or top-center or mid-center or an object representing the left, right, top, bottom values to position the toast on page
	});
};
/**
 * 将FORM表单内容，转换成功JSON格式的数据
 */
ext.form.getFormAsJson=function(formId){
	
	if($("#"+formId).length==0){
        return {};
    }
	
    var formJsonArray=$("#"+formId).serializeArray();
    
    var likes=$("#"+formId+" [like=true]");
    var ins=$("#"+formId+" [in=true]");
    var beginWith=$("#"+formId+" [beginWith=true]");
    var endWith=$("#"+formId+" [endWith=true]");
    
    var operators={};
    $.each(likes,function(index,e){
    	eleName=Utils.isEmpty($(e).attr("textboxname"))?$(e).attr("name"):$(e).attr("textboxname");
    	operators[eleName]="contains:";
    });
    $.each(ins,function(index,e){
    	eleName=Utils.isEmpty($(e).attr("textboxname"))?$(e).attr("name"):$(e).attr("textboxname");
    	operators[eleName]="in:";
    });
    
    $.each(beginWith,function(index,e){
    	eleName=Utils.isEmpty($(e).attr("textboxname"))?$(e).attr("name"):$(e).attr("textboxname");
    	operators[eleName]="beginWith:";
    });
    
    $.each(endWith,function(index,e){
    	eleName=Utils.isEmpty($(e).attr("textboxname"))?$(e).attr("name"):$(e).attr("textboxname");
    	operators[eleName]="endWith:";
    });
    
    
    var formJson={};
    
    Utils.each(formJsonArray,function(i,e){
        if(Utils.trim(e.value)!=""){
        	formJson[e.name]=(operators[e.name]==undefined?"":operators[e.name])+Utils.trim(e.value);
        }
    });
    
    return formJson;
};


jQuery.extend({
	

    createUploadIframe: function(id, uri)
	{
			//create frame
            var frameId = 'jUploadFrame' + id;
            var iframeHtml = '<iframe id="' + frameId + '" name="' + frameId + '" style="position:absolute; top:-9999px; left:-9999px"';
			if(window.ActiveXObject)
			{
                if(typeof uri== 'boolean'){
					iframeHtml += ' src="' + 'javascript:false' + '"';

                }
                else if(typeof uri== 'string'){
					iframeHtml += ' src="' + uri + '"';

                }	
			}
			iframeHtml += ' />';
			jQuery(iframeHtml).appendTo(document.body);

            return jQuery('#' + frameId).get(0);			
    },
    createUploadForm: function(id, fileElementId, data)
	{
		//create form	
		var formId = 'jUploadForm' + id;
		var fileId = 'jUploadFile' + id;
		var form = jQuery('<form  action="" method="POST" name="' + formId + '" id="' + formId + '" enctype="multipart/form-data"></form>');	
		if(data)
		{
			for(var i in data)
			{
				jQuery('<input type="hidden" name="' + i + '" value="' + data[i] + '" />').appendTo(form);
			}			
		}		
		var oldElement = jQuery('#' + fileElementId);
		var newElement = jQuery(oldElement).clone();
		jQuery(newElement).attr("name","_mvc_upload_file_");
		jQuery(newElement).attr('id', fileId);
		jQuery(oldElement).before(newElement);
		jQuery(newElement).appendTo(form);


		
		//set attributes
		jQuery(form).css('position', 'absolute');
		jQuery(form).css('top', '-1200px');
		jQuery(form).css('left', '-1200px');
		jQuery(form).appendTo('body');		
		return form;
    },

    ajaxFileUpload: function(s) {
        // TODO introduce global settings, allowing the client to modify them for all requests, not only timeout		
        s = jQuery.extend({}, jQuery.ajaxSettings, s);
        var id = new Date().getTime()        
		var form = jQuery.createUploadForm(id, s.fileElementId, (typeof(s.data)=='undefined'?false:s.data));
		var io = jQuery.createUploadIframe(id, s.secureuri);
		var frameId = 'jUploadFrame' + id;
		var formId = 'jUploadForm' + id;		
        // Watch for a new set of requests
        if ( s.global && ! jQuery.active++ )
		{
			jQuery.event.trigger( "ajaxStart" );
		}            
        var requestDone = false;
        // Create the request object
        var xml = {}   
        if ( s.global )
            jQuery.event.trigger("ajaxSend", [xml, s]);
        // Wait for a response to come back
        var uploadCallback = function(isTimeout)
		{			
			var io = document.getElementById(frameId);
            try 
			{				
				if(io.contentWindow)
				{
					 xml.responseText = io.contentWindow.document.body?io.contentWindow.document.body.innerHTML:null;
                	 xml.responseXML = io.contentWindow.document.XMLDocument?io.contentWindow.document.XMLDocument:io.contentWindow.document;
					 
				}else if(io.contentDocument)
				{
					 xml.responseText = io.contentDocument.document.body?io.contentDocument.document.body.innerHTML:null;
                	xml.responseXML = io.contentDocument.document.XMLDocument?io.contentDocument.document.XMLDocument:io.contentDocument.document;
				}						
            }catch(e)
			{
				jQuery.handleError(s, xml, null, e);
			}
            if ( xml || isTimeout == "timeout") 
			{				
                requestDone = true;
                var status;
                try {
                    status = isTimeout != "timeout" ? "success" : "error";
                    // Make sure that the request was successful or notmodified
                    if ( status != "error" )
					{
                        // process the data (runs the xml through httpData regardless of callback)
                        var data = jQuery.uploadHttpData( xml, s.dataType );
                        // If a local callback was specified, fire it and pass it the data

                        if ( s.success ) {
                            s.success( data, status );
                        }

                        // Fire the global callback
                        if( s.global )
                            jQuery.event.trigger( "ajaxSuccess", [xml, s] );
                    } else
                        jQuery.handleError(s, xml, status);
                } catch(e)
				{
                    status = "error";
                    jQuery.handleError(s, xml, status, e);
                }

                // The request was completed
                if( s.global )
                    jQuery.event.trigger( "ajaxComplete", [xml, s] );

                // Handle the global AJAX counter
                if ( s.global && ! --jQuery.active )
                    jQuery.event.trigger( "ajaxStop" );

                // Process result
                if ( s.complete )
                    s.complete(xml, status);

                jQuery(io).unbind()

                setTimeout(function()
									{	try 
										{
											jQuery(io).remove();
											jQuery(form).remove();	
											
										} catch(e) 
										{
											jQuery.handleError(s, xml, null, e);
										}									

									}, 100)

                xml = null

            }
        }
        // Timeout checker
        if ( s.timeout > 0 ) 
		{
            setTimeout(function(){
                // Check to see if the request is still happening
                if( !requestDone ) uploadCallback( "timeout" );
            }, s.timeout);
        }
        try 
		{

			var form = jQuery('#' + formId);
			jQuery(form).attr('action', s.url);
			jQuery(form).attr('method', 'POST');
			jQuery(form).attr('target', frameId);
            if(form.encoding)
			{
				jQuery(form).attr('encoding', 'multipart/form-data');      			
            }
            else
			{	
				jQuery(form).attr('enctype', 'multipart/form-data');			
            }			
            jQuery(form).submit();

        } catch(e) 
		{			
            jQuery.handleError(s, xml, null, e);
        }
		
		jQuery('#' + frameId).load(uploadCallback	);
        return {abort: function () {}};	

    },

    uploadHttpData: function( r, type ) {
        var data = !type;
        data = type == "xml" || data ? r.responseXML : r.responseText;
        // If the type is "script", eval it in global context
        if ( type == "script" )
            jQuery.globalEval( data );
        // Get the JavaScript object, if JSON is used.
        if ( type == "json" ) {
            //chrome含style,firefox不含
            data = data.replace('<pre style="word-wrap: break-word; white-space: pre-wrap;">', '').replace('<pre>', '').replace('</pre>', '').replace(/\\/g, '/');

            eval( "data = " + data );
        }
        // evaluate scripts within html
        if ( type == "html" )
            jQuery("<div>").html(data).evalScripts();

        return data;
    }
});

var file = file = file || {};

/**
 * 文件上传
 * @param fileInputId 文本输入框的ID ，如果是easyui的filebox，fileInputId获取方式为：$("input[name='filebox的id']").attr("id")
 * @param dir		上传路径
 * @param single	单文件上传
 * @param sucFunc 	成功回调
 * @param errFunc 	错误回调
 */
file.upload=function(fileInputId,dir,single,sucFunc,errFunc){
	$.ajaxFileUpload({
	    type:'POST',
	    url : path+'attachment/upload',
	    secureuri : false,
	    data : {dir:dir,single:single},
	    fileElementId :fileInputId,
	    dataType : 'json',
	    success : function(data) { //上传成功后的回调。
	        if(typeof(sucFunc)==="function"){
	        	sucFunc(data);
	        }
	    },
	    error : function(responseText) {
	    	if(typeof(errFunc)==="function"){
	    		errFunc(responseText);
	        }
	    }
	});
};

/**
 * 获取目录中的文件列表
 * @param dir	上传路径
 * @param callback 成功回调
 */
file.list=function(dir,callback){
	ext.ajax.get(path+"attachment/"+dir,function(data){
		callback(data);
	});
};

/**
 * 删除目录
 */
file.deleteDir=function(dir,callback){
	ext.ajax.get(path+"attachment/"+dir,function(data){
		callback(data);
	});
};

/**
 * 删除文件,fileUUIDName
 */
file.deleteFile=function(file,callback){
	ext.ajax.get(path+"attachment/"+file,function(data){
		callback(data);
	});
};

/**
 * 下载文件，fileUUIDName
 */
file.downloadFile=function(file){
	location.href=path+"attachment/download/file/"+file;
};

/**
 * 下载目录,目录名称
 */
file.downloadDir=function(dir){
	location.href=path+"attachment/download/dir/"+dir;
};

$.extend($.fn.textbox.defaults.rules, {
    number : {
        validator : function(value, param) {
            return /^[0-9]*$/.test(value);
        },
        message : "请输入数字"
    },
    chinese : {
        validator : function(value, param) {
            var reg = /^[\u4e00-\u9fa5]+$/i;
            return reg.test(value);
        },
        message : "请输入中文"
    },
    checkLength: {
        validator: function(value, param){
            return param[0] >= get_length(value);
        },
        message: '请输入最大{0}位字符'
    },
    specialChar: {
        validator: function(value, param){
            var reg = new RegExp("[`~!@#$^&*()=|{}':;'\\[\\]<>~！@#￥……&*（）——|{}【】‘；：”“'、？]");
            return !reg.test(value);
        },
        message: '不允许输入特殊字符'
    },
    englishLowerCase  : {// 验证英语小写
        validator : function(value) {
            return /^[a-z]+$/.test(value);
        },
        message : '请输入小写字母'
    },
    ip:{
    	validator:function(value){
    		var reg = /^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])(\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])){3}$/;
    		return reg.test(value);
    	},
    	message:'请输入有效的IP地址'
    }
});

/*
 * JQuery zTree core v3.5.36
 * http://treejs.cn/
 *
 * Copyright (c) 2010 Hunter.z
 *
 * Licensed same as jquery - MIT License
 * http://www.opensource.org/licenses/mit-license.php
 *
 * email: hunter.z@263.net
 * Date: 2018-06-26
 */
(function(q) {
    var H, I, J, K, L, M, u, s = {}, v = {}, w = {}, N = {
        treeId: "",
        treeObj: null,
        view: {
            addDiyDom: null,
            autoCancelSelected: !0,
            dblClickExpand: !0,
            expandSpeed: "fast",
            fontCss: {},
            nameIsHTML: !1,
            selectedMulti: !0,
            showIcon: !0,
            showLine: !0,
            showTitle: !0,
            txtSelectedEnable: !1
        },
        data: {
            key: {
                isParent: "isParent",
                children: "children",
                name: "name",
                title: "",
                url: "url",
                icon: "icon"
            },
            simpleData: {
                enable: !1,
                idKey: "id",
                pIdKey: "pId",
                rootPId: null
            },
            keep: {
                parent: !1,
                leaf: !1
            }
        },
        async: {
            enable: !1,
            contentType: "application/x-www-form-urlencoded",
            type: "post",
            dataType: "text",
            headers: {},
            xhrFields: {},
            url: "",
            autoParam: [],
            otherParam: [],
            dataFilter: null
        },
        callback: {
            beforeAsync: null,
            beforeClick: null,
            beforeDblClick: null,
            beforeRightClick: null,
            beforeMouseDown: null,
            beforeMouseUp: null,
            beforeExpand: null,
            beforeCollapse: null,
            beforeRemove: null,
            onAsyncError: null,
            onAsyncSuccess: null,
            onNodeCreated: null,
            onClick: null,
            onDblClick: null,
            onRightClick: null,
            onMouseDown: null,
            onMouseUp: null,
            onExpand: null,
            onCollapse: null,
            onRemove: null
        }
    }, x = [function(a) {
        var b = a.treeObj
          , c = f.event;
        b.bind(c.NODECREATED, function(b, c, h) {
            j.apply(a.callback.onNodeCreated, [b, c, h])
        });
        b.bind(c.CLICK, function(b, c, h, e, m) {
            j.apply(a.callback.onClick, [c, h, e, m])
        });
        b.bind(c.EXPAND, function(b, c, h) {
            j.apply(a.callback.onExpand, [b, c, h])
        });
        b.bind(c.COLLAPSE, function(b, c, h) {
            j.apply(a.callback.onCollapse, [b, c, h])
        });
        b.bind(c.ASYNC_SUCCESS, function(b, c, h, e) {
            j.apply(a.callback.onAsyncSuccess, [b, c, h, e])
        });
        b.bind(c.ASYNC_ERROR, function(b, c, h, e, m, f) {
            j.apply(a.callback.onAsyncError, [b, c, h, e, m, f])
        });
        b.bind(c.REMOVE, function(b, c, h) {
            j.apply(a.callback.onRemove, [b, c, h])
        });
        b.bind(c.SELECTED, function(b, c, h) {
            j.apply(a.callback.onSelected, [c, h])
        });
        b.bind(c.UNSELECTED, function(b, c, h) {
            j.apply(a.callback.onUnSelected, [c, h])
        })
    }
    ], y = [function(a) {
        var b = f.event;
        a.treeObj.unbind(b.NODECREATED).unbind(b.CLICK).unbind(b.EXPAND).unbind(b.COLLAPSE).unbind(b.ASYNC_SUCCESS).unbind(b.ASYNC_ERROR).unbind(b.REMOVE).unbind(b.SELECTED).unbind(b.UNSELECTED)
    }
    ], z = [function(a) {
        var b = e.getCache(a);
        b || (b = {},
        e.setCache(a, b));
        b.nodes = [];
        b.doms = []
    }
    ], A = [function(a, b, c, d, g, h) {
        if (c) {
            var k = e.getRoot(a)
              , m = e.nodeChildren(a, c);
            c.level = b;
            c.tId = a.treeId + "_" + ++k.zId;
            c.parentTId = d ? d.tId : null;
            c.open = typeof c.open == "string" ? j.eqs(c.open, "true") : !!c.open;
            b = e.nodeIsParent(a, c);
            j.isArray(m) && !(b === !1 || typeof b == "string" && j.eqs(b, "false")) ? (e.nodeIsParent(a, c, !0),
            c.zAsync = !0) : (b = e.nodeIsParent(a, c, b),
            c.open = b && !a.async.enable ? c.open : !1,
            c.zAsync = !b);
            c.isFirstNode = g;
            c.isLastNode = h;
            c.getParentNode = function() {
                return e.getNodeCache(a, c.parentTId)
            }
            ;
            c.getPreNode = function() {
                return e.getPreNode(a, c)
            }
            ;
            c.getNextNode = function() {
                return e.getNextNode(a, c)
            }
            ;
            c.getIndex = function() {
                return e.getNodeIndex(a, c)
            }
            ;
            c.getPath = function() {
                return e.getNodePath(a, c)
            }
            ;
            c.isAjaxing = !1;
            e.fixPIdKeyValue(a, c)
        }
    }
    ], t = [function(a) {
        var b = a.target
          , c = e.getSetting(a.data.treeId)
          , d = ""
          , g = null
          , h = ""
          , k = ""
          , m = null
          , i = null
          , o = null;
        if (j.eqs(a.type, "mousedown"))
            k = "mousedown";
        else if (j.eqs(a.type, "mouseup"))
            k = "mouseup";
        else if (j.eqs(a.type, "contextmenu"))
            k = "contextmenu";
        else if (j.eqs(a.type, "click"))
            if (j.eqs(b.tagName, "span") && b.getAttribute("treeNode" + f.id.SWITCH) !== null)
                d = j.getNodeMainDom(b).id,
                h = "switchNode";
            else {
                if (o = j.getMDom(c, b, [{
                    tagName: "a",
                    attrName: "treeNode" + f.id.A
                }]))
                    d = j.getNodeMainDom(o).id,
                    h = "clickNode"
            }
        else if (j.eqs(a.type, "dblclick") && (k = "dblclick",
        o = j.getMDom(c, b, [{
            tagName: "a",
            attrName: "treeNode" + f.id.A
        }])))
            d = j.getNodeMainDom(o).id,
            h = "switchNode";
        if (k.length > 0 && d.length == 0 && (o = j.getMDom(c, b, [{
            tagName: "a",
            attrName: "treeNode" + f.id.A
        }])))
            d = j.getNodeMainDom(o).id;
        if (d.length > 0)
            switch (g = e.getNodeCache(c, d),
            h) {
            case "switchNode":
                e.nodeIsParent(c, g) ? j.eqs(a.type, "click") || j.eqs(a.type, "dblclick") && j.apply(c.view.dblClickExpand, [c.treeId, g], c.view.dblClickExpand) ? m = H : h = "" : h = "";
                break;
            case "clickNode":
                m = I
            }
        switch (k) {
        case "mousedown":
            i = J;
            break;
        case "mouseup":
            i = K;
            break;
        case "dblclick":
            i = L;
            break;
        case "contextmenu":
            i = M
        }
        return {
            stop: !1,
            node: g,
            nodeEventType: h,
            nodeEventCallback: m,
            treeEventType: k,
            treeEventCallback: i
        }
    }
    ], B = [function(a) {
        var b = e.getRoot(a);
        b || (b = {},
        e.setRoot(a, b));
        e.nodeChildren(a, b, []);
        b.expandTriggerFlag = !1;
        b.curSelectedList = [];
        b.noSelection = !0;
        b.createdNodes = [];
        b.zId = 0;
        b._ver = (new Date).getTime()
    }
    ], C = [], D = [], E = [], F = [], G = [], e = {
        addNodeCache: function(a, b) {
            e.getCache(a).nodes[e.getNodeCacheId(b.tId)] = b
        },
        getNodeCacheId: function(a) {
            return a.substring(a.lastIndexOf("_") + 1)
        },
        addAfterA: function(a) {
            D.push(a)
        },
        addBeforeA: function(a) {
            C.push(a)
        },
        addInnerAfterA: function(a) {
            F.push(a)
        },
        addInnerBeforeA: function(a) {
            E.push(a)
        },
        addInitBind: function(a) {
            x.push(a)
        },
        addInitUnBind: function(a) {
            y.push(a)
        },
        addInitCache: function(a) {
            z.push(a)
        },
        addInitNode: function(a) {
            A.push(a)
        },
        addInitProxy: function(a, b) {
            b ? t.splice(0, 0, a) : t.push(a)
        },
        addInitRoot: function(a) {
            B.push(a)
        },
        addNodesData: function(a, b, c, d) {
            var g = e.nodeChildren(a, b);
            g ? c >= g.length && (c = -1) : (g = e.nodeChildren(a, b, []),
            c = -1);
            if (g.length > 0 && c === 0)
                g[0].isFirstNode = !1,
                i.setNodeLineIcos(a, g[0]);
            else if (g.length > 0 && c < 0)
                g[g.length - 1].isLastNode = !1,
                i.setNodeLineIcos(a, g[g.length - 1]);
            e.nodeIsParent(a, b, !0);
            c < 0 ? e.nodeChildren(a, b, g.concat(d)) : (a = [c, 0].concat(d),
            g.splice.apply(g, a))
        },
        addSelectedNode: function(a, b) {
            var c = e.getRoot(a);
            e.isSelectedNode(a, b) || c.curSelectedList.push(b)
        },
        addCreatedNode: function(a, b) {
            (a.callback.onNodeCreated || a.view.addDiyDom) && e.getRoot(a).createdNodes.push(b)
        },
        addZTreeTools: function(a) {
            G.push(a)
        },
        exSetting: function(a) {
            q.extend(!0, N, a)
        },
        fixPIdKeyValue: function(a, b) {
            a.data.simpleData.enable && (b[a.data.simpleData.pIdKey] = b.parentTId ? b.getParentNode()[a.data.simpleData.idKey] : a.data.simpleData.rootPId)
        },
        getAfterA: function(a, b, c) {
            for (var d = 0, e = D.length; d < e; d++)
                D[d].apply(this, arguments)
        },
        getBeforeA: function(a, b, c) {
            for (var d = 0, e = C.length; d < e; d++)
                C[d].apply(this, arguments)
        },
        getInnerAfterA: function(a, b, c) {
            for (var d = 0, e = F.length; d < e; d++)
                F[d].apply(this, arguments)
        },
        getInnerBeforeA: function(a, b, c) {
            for (var d = 0, e = E.length; d < e; d++)
                E[d].apply(this, arguments)
        },
        getCache: function(a) {
            return w[a.treeId]
        },
        getNodeIndex: function(a, b) {
            if (!b)
                return null;
            for (var c = b.parentTId ? b.getParentNode() : e.getRoot(a), c = e.nodeChildren(a, c), d = 0, g = c.length - 1; d <= g; d++)
                if (c[d] === b)
                    return d;
            return -1
        },
        getNextNode: function(a, b) {
            if (!b)
                return null;
            for (var c = b.parentTId ? b.getParentNode() : e.getRoot(a), c = e.nodeChildren(a, c), d = 0, g = c.length - 1; d <= g; d++)
                if (c[d] === b)
                    return d == g ? null : c[d + 1];
            return null
        },
        getNodeByParam: function(a, b, c, d) {
            if (!b || !c)
                return null;
            for (var g = 0, h = b.length; g < h; g++) {
                var k = b[g];
                if (k[c] == d)
                    return b[g];
                k = e.nodeChildren(a, k);
                if (k = e.getNodeByParam(a, k, c, d))
                    return k
            }
            return null
        },
        getNodeCache: function(a, b) {
            if (!b)
                return null;
            var c = w[a.treeId].nodes[e.getNodeCacheId(b)];
            return c ? c : null
        },
        getNodePath: function(a, b) {
            if (!b)
                return null;
            var c;
            (c = b.parentTId ? b.getParentNode().getPath() : []) && c.push(b);
            return c
        },
        getNodes: function(a) {
            return e.nodeChildren(a, e.getRoot(a))
        },
        getNodesByParam: function(a, b, c, d) {
            if (!b || !c)
                return [];
            for (var g = [], h = 0, k = b.length; h < k; h++) {
                var m = b[h];
                m[c] == d && g.push(m);
                m = e.nodeChildren(a, m);
                g = g.concat(e.getNodesByParam(a, m, c, d))
            }
            return g
        },
        getNodesByParamFuzzy: function(a, b, c, d) {
            if (!b || !c)
                return [];
            for (var g = [], d = d.toLowerCase(), h = 0, k = b.length; h < k; h++) {
                var m = b[h];
                typeof m[c] == "string" && b[h][c].toLowerCase().indexOf(d) > -1 && g.push(m);
                m = e.nodeChildren(a, m);
                g = g.concat(e.getNodesByParamFuzzy(a, m, c, d))
            }
            return g
        },
        getNodesByFilter: function(a, b, c, d, g) {
            if (!b)
                return d ? null : [];
            for (var h = d ? null : [], k = 0, m = b.length; k < m; k++) {
                var f = b[k];
                if (j.apply(c, [f, g], !1)) {
                    if (d)
                        return f;
                    h.push(f)
                }
                f = e.nodeChildren(a, f);
                f = e.getNodesByFilter(a, f, c, d, g);
                if (d && f)
                    return f;
                h = d ? f : h.concat(f)
            }
            return h
        },
        getPreNode: function(a, b) {
            if (!b)
                return null;
            for (var c = b.parentTId ? b.getParentNode() : e.getRoot(a), c = e.nodeChildren(a, c), d = 0, g = c.length; d < g; d++)
                if (c[d] === b)
                    return d == 0 ? null : c[d - 1];
            return null
        },
        getRoot: function(a) {
            return a ? v[a.treeId] : null
        },
        getRoots: function() {
            return v
        },
        getSetting: function(a) {
            return s[a]
        },
        getSettings: function() {
            return s
        },
        getZTreeTools: function(a) {
            return (a = this.getRoot(this.getSetting(a))) ? a.treeTools : null
        },
        initCache: function(a) {
            for (var b = 0, c = z.length; b < c; b++)
                z[b].apply(this, arguments)
        },
        initNode: function(a, b, c, d, e, h) {
            for (var k = 0, f = A.length; k < f; k++)
                A[k].apply(this, arguments)
        },
        initRoot: function(a) {
            for (var b = 0, c = B.length; b < c; b++)
                B[b].apply(this, arguments)
        },
        isSelectedNode: function(a, b) {
            for (var c = e.getRoot(a), d = 0, g = c.curSelectedList.length; d < g; d++)
                if (b === c.curSelectedList[d])
                    return !0;
            return !1
        },
        nodeChildren: function(a, b, c) {
            if (!b)
                return null;
            a = a.data.key.children;
            typeof c !== "undefined" && (b[a] = c);
            return b[a]
        },
        nodeIsParent: function(a, b, c) {
            if (!b)
                return !1;
            a = a.data.key.isParent;
            typeof c !== "undefined" && (typeof c === "string" && (c = j.eqs(c, "true")),
            b[a] = !!c);
            return b[a]
        },
        nodeName: function(a, b, c) {
            a = a.data.key.name;
            typeof c !== "undefined" && (b[a] = c);
            return "" + b[a]
        },
        nodeTitle: function(a, b) {
            return "" + b[a.data.key.title === "" ? a.data.key.name : a.data.key.title]
        },
        removeNodeCache: function(a, b) {
            var c = e.nodeChildren(a, b);
            if (c)
                for (var d = 0, g = c.length; d < g; d++)
                    e.removeNodeCache(a, c[d]);
            e.getCache(a).nodes[e.getNodeCacheId(b.tId)] = null
        },
        removeSelectedNode: function(a, b) {
            for (var c = e.getRoot(a), d = 0, g = c.curSelectedList.length; d < g; d++)
                if (b === c.curSelectedList[d] || !e.getNodeCache(a, c.curSelectedList[d].tId))
                    c.curSelectedList.splice(d, 1),
                    a.treeObj.trigger(f.event.UNSELECTED, [a.treeId, b]),
                    d--,
                    g--
        },
        setCache: function(a, b) {
            w[a.treeId] = b
        },
        setRoot: function(a, b) {
            v[a.treeId] = b
        },
        setZTreeTools: function(a, b) {
            for (var c = 0, d = G.length; c < d; c++)
                G[c].apply(this, arguments)
        },
        transformToArrayFormat: function(a, b) {
            function c(b) {
                d.push(b);
                (b = e.nodeChildren(a, b)) && (d = d.concat(e.transformToArrayFormat(a, b)))
            }
            if (!b)
                return [];
            var d = [];
            if (j.isArray(b))
                for (var g = 0, h = b.length; g < h; g++)
                    c(b[g]);
            else
                c(b);
            return d
        },
        transformTozTreeFormat: function(a, b) {
            var c, d, g = a.data.simpleData.idKey, h = a.data.simpleData.pIdKey;
            if (!g || g == "" || !b)
                return [];
            if (j.isArray(b)) {
                var k = []
                  , f = {};
                for (c = 0,
                d = b.length; c < d; c++)
                    f[b[c][g]] = b[c];
                for (c = 0,
                d = b.length; c < d; c++) {
                    var i = f[b[c][h]];
                    if (i && b[c][g] != b[c][h]) {
                        var o = e.nodeChildren(a, i);
                        o || (o = e.nodeChildren(a, i, []));
                        o.push(b[c])
                    } else
                        k.push(b[c])
                }
                return k
            } else
                return [b]
        }
    }, n = {
        bindEvent: function(a) {
            for (var b = 0, c = x.length; b < c; b++)
                x[b].apply(this, arguments)
        },
        unbindEvent: function(a) {
            for (var b = 0, c = y.length; b < c; b++)
                y[b].apply(this, arguments)
        },
        bindTree: function(a) {
            var b = {
                treeId: a.treeId
            }
              , c = a.treeObj;
            a.view.txtSelectedEnable || c.bind("selectstart", u).css({
                "-moz-user-select": "-moz-none"
            });
            c.bind("click", b, n.proxy);
            c.bind("dblclick", b, n.proxy);
            c.bind("mouseover", b, n.proxy);
            c.bind("mouseout", b, n.proxy);
            c.bind("mousedown", b, n.proxy);
            c.bind("mouseup", b, n.proxy);
            c.bind("contextmenu", b, n.proxy)
        },
        unbindTree: function(a) {
            a.treeObj.unbind("selectstart", u).unbind("click", n.proxy).unbind("dblclick", n.proxy).unbind("mouseover", n.proxy).unbind("mouseout", n.proxy).unbind("mousedown", n.proxy).unbind("mouseup", n.proxy).unbind("contextmenu", n.proxy)
        },
        doProxy: function(a) {
            for (var b = [], c = 0, d = t.length; c < d; c++) {
                var e = t[c].apply(this, arguments);
                b.push(e);
                if (e.stop)
                    break
            }
            return b
        },
        proxy: function(a) {
            var b = e.getSetting(a.data.treeId);
            if (!j.uCanDo(b, a))
                return !0;
            for (var b = n.doProxy(a), c = !0, d = 0, g = b.length; d < g; d++) {
                var h = b[d];
                h.nodeEventCallback && (c = h.nodeEventCallback.apply(h, [a, h.node]) && c);
                h.treeEventCallback && (c = h.treeEventCallback.apply(h, [a, h.node]) && c)
            }
            return c
        }
    };
    H = function(a, b) {
        var c = e.getSetting(a.data.treeId);
        if (b.open) {
            if (j.apply(c.callback.beforeCollapse, [c.treeId, b], !0) == !1)
                return !0
        } else if (j.apply(c.callback.beforeExpand, [c.treeId, b], !0) == !1)
            return !0;
        e.getRoot(c).expandTriggerFlag = !0;
        i.switchNode(c, b);
        return !0
    }
    ;
    I = function(a, b) {
        var c = e.getSetting(a.data.treeId)
          , d = c.view.autoCancelSelected && (a.ctrlKey || a.metaKey) && e.isSelectedNode(c, b) ? 0 : c.view.autoCancelSelected && (a.ctrlKey || a.metaKey) && c.view.selectedMulti ? 2 : 1;
        if (j.apply(c.callback.beforeClick, [c.treeId, b, d], !0) == !1)
            return !0;
        d === 0 ? i.cancelPreSelectedNode(c, b) : i.selectNode(c, b, d === 2);
        c.treeObj.trigger(f.event.CLICK, [a, c.treeId, b, d]);
        return !0
    }
    ;
    J = function(a, b) {
        var c = e.getSetting(a.data.treeId);
        j.apply(c.callback.beforeMouseDown, [c.treeId, b], !0) && j.apply(c.callback.onMouseDown, [a, c.treeId, b]);
        return !0
    }
    ;
    K = function(a, b) {
        var c = e.getSetting(a.data.treeId);
        j.apply(c.callback.beforeMouseUp, [c.treeId, b], !0) && j.apply(c.callback.onMouseUp, [a, c.treeId, b]);
        return !0
    }
    ;
    L = function(a, b) {
        var c = e.getSetting(a.data.treeId);
        j.apply(c.callback.beforeDblClick, [c.treeId, b], !0) && j.apply(c.callback.onDblClick, [a, c.treeId, b]);
        return !0
    }
    ;
    M = function(a, b) {
        var c = e.getSetting(a.data.treeId);
        j.apply(c.callback.beforeRightClick, [c.treeId, b], !0) && j.apply(c.callback.onRightClick, [a, c.treeId, b]);
        return typeof c.callback.onRightClick != "function"
    }
    ;
    u = function(a) {
        a = a.originalEvent.srcElement.nodeName.toLowerCase();
        return a === "input" || a === "textarea"
    }
    ;
    var j = {
        apply: function(a, b, c) {
            return typeof a == "function" ? a.apply(O, b ? b : []) : c
        },
        canAsync: function(a, b) {
            var c = e.nodeChildren(a, b)
              , d = e.nodeIsParent(a, b);
            return a.async.enable && b && d && !(b.zAsync || c && c.length > 0)
        },
        clone: function(a) {
            if (a === null)
                return null;
            var b = j.isArray(a) ? [] : {}, c;
            for (c in a)
                b[c] = a[c]instanceof Date ? new Date(a[c].getTime()) : typeof a[c] === "object" ? j.clone(a[c]) : a[c];
            return b
        },
        eqs: function(a, b) {
            return a.toLowerCase() === b.toLowerCase()
        },
        isArray: function(a) {
            return Object.prototype.toString.apply(a) === "[object Array]"
        },
        isElement: function(a) {
            return typeof HTMLElement === "object" ? a instanceof HTMLElement : a && typeof a === "object" && a !== null && a.nodeType === 1 && typeof a.nodeName === "string"
        },
        $: function(a, b, c) {
            b && typeof b != "string" && (c = b,
            b = "");
            return typeof a == "string" ? q(a, c ? c.treeObj.get(0).ownerDocument : null) : q("#" + a.tId + b, c ? c.treeObj : null)
        },
        getMDom: function(a, b, c) {
            if (!b)
                return null;
            for (; b && b.id !== a.treeId; ) {
                for (var d = 0, e = c.length; b.tagName && d < e; d++)
                    if (j.eqs(b.tagName, c[d].tagName) && b.getAttribute(c[d].attrName) !== null)
                        return b;
                b = b.parentNode
            }
            return null
        },
        getNodeMainDom: function(a) {
            return q(a).parent("li").get(0) || q(a).parentsUntil("li").parent().get(0)
        },
        isChildOrSelf: function(a, b) {
            return q(a).closest("#" + b).length > 0
        },
        uCanDo: function() {
            return !0
        }
    }
      , i = {
        addNodes: function(a, b, c, d, g) {
            var h = e.nodeIsParent(a, b);
            if (!a.data.keep.leaf || !b || h)
                if (j.isArray(d) || (d = [d]),
                a.data.simpleData.enable && (d = e.transformTozTreeFormat(a, d)),
                b) {
                    var h = l(b, f.id.SWITCH, a)
                      , k = l(b, f.id.ICON, a)
                      , m = l(b, f.id.UL, a);
                    if (!b.open)
                        i.replaceSwitchClass(b, h, f.folder.CLOSE),
                        i.replaceIcoClass(b, k, f.folder.CLOSE),
                        b.open = !1,
                        m.css({
                            display: "none"
                        });
                    e.addNodesData(a, b, c, d);
                    i.createNodes(a, b.level + 1, d, b, c);
                    g || i.expandCollapseParentNode(a, b, !0)
                } else
                    e.addNodesData(a, e.getRoot(a), c, d),
                    i.createNodes(a, 0, d, null, c)
        },
        appendNodes: function(a, b, c, d, g, h, k) {
            if (!c)
                return [];
            var f = [], j = d ? d : e.getRoot(a), j = e.nodeChildren(a, j), o, l;
            if (!j || g >= j.length - c.length)
                g = -1;
            for (var n = 0, Q = c.length; n < Q; n++) {
                var p = c[n];
                h && (o = (g === 0 || j.length == c.length) && n == 0,
                l = g < 0 && n == c.length - 1,
                e.initNode(a, b, p, d, o, l, k),
                e.addNodeCache(a, p));
                o = e.nodeIsParent(a, p);
                l = [];
                var q = e.nodeChildren(a, p);
                q && q.length > 0 && (l = i.appendNodes(a, b + 1, q, p, -1, h, k && p.open));
                k && (i.makeDOMNodeMainBefore(f, a, p),
                i.makeDOMNodeLine(f, a, p),
                e.getBeforeA(a, p, f),
                i.makeDOMNodeNameBefore(f, a, p),
                e.getInnerBeforeA(a, p, f),
                i.makeDOMNodeIcon(f, a, p),
                e.getInnerAfterA(a, p, f),
                i.makeDOMNodeNameAfter(f, a, p),
                e.getAfterA(a, p, f),
                o && p.open && i.makeUlHtml(a, p, f, l.join("")),
                i.makeDOMNodeMainAfter(f, a, p),
                e.addCreatedNode(a, p))
            }
            return f
        },
        appendParentULDom: function(a, b) {
            var c = []
              , d = l(b, a);
            !d.get(0) && b.parentTId && (i.appendParentULDom(a, b.getParentNode()),
            d = l(b, a));
            var g = l(b, f.id.UL, a);
            g.get(0) && g.remove();
            g = e.nodeChildren(a, b);
            g = i.appendNodes(a, b.level + 1, g, b, -1, !1, !0);
            i.makeUlHtml(a, b, c, g.join(""));
            d.append(c.join(""))
        },
        asyncNode: function(a, b, c, d) {
            var g, h;
            g = e.nodeIsParent(a, b);
            if (b && !g)
                return j.apply(d),
                !1;
            else if (b && b.isAjaxing)
                return !1;
            else if (j.apply(a.callback.beforeAsync, [a.treeId, b], !0) == !1)
                return j.apply(d),
                !1;
            if (b)
                b.isAjaxing = !0,
                l(b, f.id.ICON, a).attr({
                    style: "",
                    "class": f.className.BUTTON + " " + f.className.ICO_LOADING
                });
            var k = {}
              , m = j.apply(a.async.autoParam, [a.treeId, b], a.async.autoParam);
            for (g = 0,
            h = m.length; b && g < h; g++) {
                var r = m[g].split("=")
                  , o = r;
                r.length > 1 && (o = r[1],
                r = r[0]);
                k[o] = b[r]
            }
            m = j.apply(a.async.otherParam, [a.treeId, b], a.async.otherParam);
            if (j.isArray(m))
                for (g = 0,
                h = m.length; g < h; g += 2)
                    k[m[g]] = m[g + 1];
            else
                for (var n in m)
                    k[n] = m[n];
            var P = e.getRoot(a)._ver;
            q.ajax({
                contentType: a.async.contentType,
                cache: !1,
                type: a.async.type,
                url: j.apply(a.async.url, [a.treeId, b], a.async.url),
                data: a.async.contentType.indexOf("application/json") > -1 ? JSON.stringify(k) : k,
                dataType: a.async.dataType,
                headers: a.async.headers,
                xhrFields: a.async.xhrFields,
                success: function(h) {
                    if (P == e.getRoot(a)._ver) {
                        var k = [];
                        try {
                            k = !h || h.length == 0 ? [] : typeof h == "string" ? eval("(" + h + ")") : h
                        } catch (g) {
                            k = h
                        }
                        if (b)
                            b.isAjaxing = null,
                            b.zAsync = !0;
                        i.setNodeLineIcos(a, b);
                        k && k !== "" ? (k = j.apply(a.async.dataFilter, [a.treeId, b, k], k),
                        i.addNodes(a, b, -1, k ? j.clone(k) : [], !!c)) : i.addNodes(a, b, -1, [], !!c);
                        a.treeObj.trigger(f.event.ASYNC_SUCCESS, [a.treeId, b, h]);
                        j.apply(d)
                    }
                },
                error: function(c, d, h) {
                    if (P == e.getRoot(a)._ver) {
                        if (b)
                            b.isAjaxing = null;
                        i.setNodeLineIcos(a, b);
                        a.treeObj.trigger(f.event.ASYNC_ERROR, [a.treeId, b, c, d, h])
                    }
                }
            });
            return !0
        },
        cancelPreSelectedNode: function(a, b, c) {
            var d = e.getRoot(a).curSelectedList, g, h;
            for (g = d.length - 1; g >= 0; g--)
                if (h = d[g],
                b === h || !b && (!c || c !== h))
                    if (l(h, f.id.A, a).removeClass(f.node.CURSELECTED),
                    b) {
                        e.removeSelectedNode(a, b);
                        break
                    } else
                        d.splice(g, 1),
                        a.treeObj.trigger(f.event.UNSELECTED, [a.treeId, h])
        },
        createNodeCallback: function(a) {
            if (a.callback.onNodeCreated || a.view.addDiyDom)
                for (var b = e.getRoot(a); b.createdNodes.length > 0; ) {
                    var c = b.createdNodes.shift();
                    j.apply(a.view.addDiyDom, [a.treeId, c]);
                    a.callback.onNodeCreated && a.treeObj.trigger(f.event.NODECREATED, [a.treeId, c])
                }
        },
        createNodes: function(a, b, c, d, g) {
            if (c && c.length != 0) {
                var h = e.getRoot(a)
                  , k = !d || d.open || !!l(e.nodeChildren(a, d)[0], a).get(0);
                h.createdNodes = [];
                var b = i.appendNodes(a, b, c, d, g, !0, k), m, j;
                d ? (d = l(d, f.id.UL, a),
                d.get(0) && (m = d)) : m = a.treeObj;
                m && (g >= 0 && (j = m.children()[g]),
                g >= 0 && j ? q(j).before(b.join("")) : m.append(b.join("")));
                i.createNodeCallback(a)
            }
        },
        destroy: function(a) {
            a && (e.initCache(a),
            e.initRoot(a),
            n.unbindTree(a),
            n.unbindEvent(a),
            a.treeObj.empty(),
            delete s[a.treeId])
        },
        expandCollapseNode: function(a, b, c, d, g) {
            var h = e.getRoot(a), k;
            if (b) {
                var m = e.nodeChildren(a, b)
                  , r = e.nodeIsParent(a, b);
                if (h.expandTriggerFlag)
                    k = g,
                    g = function() {
                        k && k();
                        b.open ? a.treeObj.trigger(f.event.EXPAND, [a.treeId, b]) : a.treeObj.trigger(f.event.COLLAPSE, [a.treeId, b])
                    }
                    ,
                    h.expandTriggerFlag = !1;
                if (!b.open && r && (!l(b, f.id.UL, a).get(0) || m && m.length > 0 && !l(m[0], a).get(0)))
                    i.appendParentULDom(a, b),
                    i.createNodeCallback(a);
                if (b.open == c)
                    j.apply(g, []);
                else {
                    var c = l(b, f.id.UL, a)
                      , h = l(b, f.id.SWITCH, a)
                      , o = l(b, f.id.ICON, a);
                    r ? (b.open = !b.open,
                    b.iconOpen && b.iconClose && o.attr("style", i.makeNodeIcoStyle(a, b)),
                    b.open ? (i.replaceSwitchClass(b, h, f.folder.OPEN),
                    i.replaceIcoClass(b, o, f.folder.OPEN),
                    d == !1 || a.view.expandSpeed == "" ? (c.show(),
                    j.apply(g, [])) : m && m.length > 0 ? c.slideDown(a.view.expandSpeed, g) : (c.show(),
                    j.apply(g, []))) : (i.replaceSwitchClass(b, h, f.folder.CLOSE),
                    i.replaceIcoClass(b, o, f.folder.CLOSE),
                    d == !1 || a.view.expandSpeed == "" || !(m && m.length > 0) ? (c.hide(),
                    j.apply(g, [])) : c.slideUp(a.view.expandSpeed, g))) : j.apply(g, [])
                }
            } else
                j.apply(g, [])
        },
        expandCollapseParentNode: function(a, b, c, d, e) {
            b && (b.parentTId ? (i.expandCollapseNode(a, b, c, d),
            b.parentTId && i.expandCollapseParentNode(a, b.getParentNode(), c, d, e)) : i.expandCollapseNode(a, b, c, d, e))
        },
        expandCollapseSonNode: function(a, b, c, d, g) {
            var h = e.getRoot(a)
              , h = b ? e.nodeChildren(a, b) : e.nodeChildren(a, h)
              , k = b ? !1 : d
              , f = e.getRoot(a).expandTriggerFlag;
            e.getRoot(a).expandTriggerFlag = !1;
            if (h)
                for (var j = 0, l = h.length; j < l; j++)
                    h[j] && i.expandCollapseSonNode(a, h[j], c, k);
            e.getRoot(a).expandTriggerFlag = f;
            i.expandCollapseNode(a, b, c, d, g)
        },
        isSelectedNode: function(a, b) {
            if (!b)
                return !1;
            var c = e.getRoot(a).curSelectedList, d;
            for (d = c.length - 1; d >= 0; d--)
                if (b === c[d])
                    return !0;
            return !1
        },
        makeDOMNodeIcon: function(a, b, c) {
            var d = e.nodeName(b, c)
              , d = b.view.nameIsHTML ? d : d.replace(/&/g, "&amp;").replace(/</g, "&lt;").replace(/>/g, "&gt;");
            a.push("<span id='", c.tId, f.id.ICON, "' title='' treeNode", f.id.ICON, " class='", i.makeNodeIcoClass(b, c), "' style='", i.makeNodeIcoStyle(b, c), "'></span><span id='", c.tId, f.id.SPAN, "' class='", f.className.NAME, "'>", d, "</span>")
        },
        makeDOMNodeLine: function(a, b, c) {
            a.push("<span id='", c.tId, f.id.SWITCH, "' title='' class='", i.makeNodeLineClass(b, c), "' treeNode", f.id.SWITCH, "></span>")
        },
        makeDOMNodeMainAfter: function(a) {
            a.push("</li>")
        },
        makeDOMNodeMainBefore: function(a, b, c) {
            a.push("<li id='", c.tId, "' class='", f.className.LEVEL, c.level, "' tabindex='0' hidefocus='true' treenode>")
        },
        makeDOMNodeNameAfter: function(a) {
            a.push("</a>")
        },
        makeDOMNodeNameBefore: function(a, b, c) {
            var d = e.nodeTitle(b, c), g = i.makeNodeUrl(b, c), h = i.makeNodeFontCss(b, c), k = [], m;
            for (m in h)
                k.push(m, ":", h[m], ";");
            a.push("<a id='", c.tId, f.id.A, "' class='", f.className.LEVEL, c.level, "' treeNode", f.id.A, ' onclick="', c.click || "", '" ', g != null && g.length > 0 ? "href='" + g + "'" : "", " target='", i.makeNodeTarget(c), "' style='", k.join(""), "'");
            j.apply(b.view.showTitle, [b.treeId, c], b.view.showTitle) && d && a.push("title='", d.replace(/'/g, "&#39;").replace(/</g, "&lt;").replace(/>/g, "&gt;"), "'");
            a.push(">")
        },
        makeNodeFontCss: function(a, b) {
            var c = j.apply(a.view.fontCss, [a.treeId, b], a.view.fontCss);
            return c && typeof c != "function" ? c : {}
        },
        makeNodeIcoClass: function(a, b) {
            var c = ["ico"];
            if (!b.isAjaxing) {
                var d = e.nodeIsParent(a, b);
                c[0] = (b.iconSkin ? b.iconSkin + "_" : "") + c[0];
                d ? c.push(b.open ? f.folder.OPEN : f.folder.CLOSE) : c.push(f.folder.DOCU)
            }
            return f.className.BUTTON + " " + c.join("_")
        },
        makeNodeIcoStyle: function(a, b) {
            var c = [];
            if (!b.isAjaxing) {
                var d = e.nodeIsParent(a, b) && b.iconOpen && b.iconClose ? b.open ? b.iconOpen : b.iconClose : b[a.data.key.icon];
                d && c.push("background:url(", d, ") 0 0 no-repeat;");
                (a.view.showIcon == !1 || !j.apply(a.view.showIcon, [a.treeId, b], !0)) && c.push("width:0px;height:0px;")
            }
            return c.join("")
        },
        makeNodeLineClass: function(a, b) {
            var c = [];
            a.view.showLine ? b.level == 0 && b.isFirstNode && b.isLastNode ? c.push(f.line.ROOT) : b.level == 0 && b.isFirstNode ? c.push(f.line.ROOTS) : b.isLastNode ? c.push(f.line.BOTTOM) : c.push(f.line.CENTER) : c.push(f.line.NOLINE);
            e.nodeIsParent(a, b) ? c.push(b.open ? f.folder.OPEN : f.folder.CLOSE) : c.push(f.folder.DOCU);
            return i.makeNodeLineClassEx(b) + c.join("_")
        },
        makeNodeLineClassEx: function(a) {
            return f.className.BUTTON + " " + f.className.LEVEL + a.level + " " + f.className.SWITCH + " "
        },
        makeNodeTarget: function(a) {
            return a.target || "_blank"
        },
        makeNodeUrl: function(a, b) {
            var c = a.data.key.url;
            return b[c] ? b[c] : null
        },
        makeUlHtml: function(a, b, c, d) {
            c.push("<ul id='", b.tId, f.id.UL, "' class='", f.className.LEVEL, b.level, " ", i.makeUlLineClass(a, b), "' style='display:", b.open ? "block" : "none", "'>");
            c.push(d);
            c.push("</ul>")
        },
        makeUlLineClass: function(a, b) {
            return a.view.showLine && !b.isLastNode ? f.line.LINE : ""
        },
        removeChildNodes: function(a, b) {
            if (b) {
                var c = e.nodeChildren(a, b);
                if (c) {
                    for (var d = 0, g = c.length; d < g; d++)
                        e.removeNodeCache(a, c[d]);
                    e.removeSelectedNode(a);
                    delete b[a.data.key.children];
                    a.data.keep.parent ? l(b, f.id.UL, a).empty() : (e.nodeIsParent(a, b, !1),
                    b.open = !1,
                    c = l(b, f.id.SWITCH, a),
                    d = l(b, f.id.ICON, a),
                    i.replaceSwitchClass(b, c, f.folder.DOCU),
                    i.replaceIcoClass(b, d, f.folder.DOCU),
                    l(b, f.id.UL, a).remove())
                }
            }
        },
        scrollIntoView: function(a, b) {
            if (b)
                if (typeof Element === "undefined") {
                    var c = a.treeObj.get(0).getBoundingClientRect()
                      , d = b.getBoundingClientRect();
                    (d.top < c.top || d.bottom > c.bottom || d.right > c.right || d.left < c.left) && b.scrollIntoView()
                } else {
                    if (!Element.prototype.scrollIntoViewIfNeeded)
                        Element.prototype.scrollIntoViewIfNeeded = function(a) {
                            function b(a, c, d, f) {
                                return {
                                    left: a,
                                    top: c,
                                    width: d,
                                    height: f,
                                    right: a + d,
                                    bottom: c + f,
                                    translate: function(e, g) {
                                        return b(e + a, g + c, d, f)
                                    },
                                    relativeFromTo: function(g, k) {
                                        var i = a
                                          , j = c
                                          , g = g.offsetParent
                                          , k = k.offsetParent;
                                        if (g === k)
                                            return e;
                                        for (; g; g = g.offsetParent)
                                            i += g.offsetLeft + g.clientLeft,
                                            j += g.offsetTop + g.clientTop;
                                        for (; k; k = k.offsetParent)
                                            i -= k.offsetLeft + k.clientLeft,
                                            j -= k.offsetTop + k.clientTop;
                                        return b(i, j, d, f)
                                    }
                                }
                            }
                            for (var c, d = this, e = b(this.offsetLeft, this.offsetTop, this.offsetWidth, this.offsetHeight); j.isElement(c = d.parentNode); ) {
                                var f = c.offsetLeft + c.clientLeft
                                  , i = c.offsetTop + c.clientTop
                                  , e = e.relativeFromTo(d, c).translate(-f, -i);
                                c.scrollLeft = !1 === a || e.left <= c.scrollLeft + c.clientWidth && c.scrollLeft <= e.right - c.clientWidth + c.clientWidth ? Math.min(e.left, Math.max(e.right - c.clientWidth, c.scrollLeft)) : (e.right - c.clientWidth + e.left) / 2;
                                c.scrollTop = !1 === a || e.top <= c.scrollTop + c.clientHeight && c.scrollTop <= e.bottom - c.clientHeight + c.clientHeight ? Math.min(e.top, Math.max(e.bottom - c.clientHeight, c.scrollTop)) : (e.bottom - c.clientHeight + e.top) / 2;
                                e = e.translate(f - c.scrollLeft, i - c.scrollTop);
                                d = c
                            }
                        }
                        ;
                    b.scrollIntoViewIfNeeded()
                }
        },
        setFirstNode: function(a, b) {
            var c = e.nodeChildren(a, b);
            if (c.length > 0)
                c[0].isFirstNode = !0
        },
        setLastNode: function(a, b) {
            var c = e.nodeChildren(a, b);
            if (c.length > 0)
                c[c.length - 1].isLastNode = !0
        },
        removeNode: function(a, b) {
            var c = e.getRoot(a)
              , d = b.parentTId ? b.getParentNode() : c;
            b.isFirstNode = !1;
            b.isLastNode = !1;
            b.getPreNode = function() {
                return null
            }
            ;
            b.getNextNode = function() {
                return null
            }
            ;
            if (e.getNodeCache(a, b.tId)) {
                l(b, a).remove();
                e.removeNodeCache(a, b);
                e.removeSelectedNode(a, b);
                for (var g = e.nodeChildren(a, d), h = 0, k = g.length; h < k; h++)
                    if (g[h].tId == b.tId) {
                        g.splice(h, 1);
                        break
                    }
                i.setFirstNode(a, d);
                i.setLastNode(a, d);
                var j, h = g.length;
                if (!a.data.keep.parent && h == 0)
                    e.nodeIsParent(a, d, !1),
                    d.open = !1,
                    delete d[a.data.key.children],
                    h = l(d, f.id.UL, a),
                    k = l(d, f.id.SWITCH, a),
                    j = l(d, f.id.ICON, a),
                    i.replaceSwitchClass(d, k, f.folder.DOCU),
                    i.replaceIcoClass(d, j, f.folder.DOCU),
                    h.css("display", "none");
                else if (a.view.showLine && h > 0) {
                    var r = g[h - 1]
                      , h = l(r, f.id.UL, a)
                      , k = l(r, f.id.SWITCH, a);
                    j = l(r, f.id.ICON, a);
                    d == c ? g.length == 1 ? i.replaceSwitchClass(r, k, f.line.ROOT) : (c = l(g[0], f.id.SWITCH, a),
                    i.replaceSwitchClass(g[0], c, f.line.ROOTS),
                    i.replaceSwitchClass(r, k, f.line.BOTTOM)) : i.replaceSwitchClass(r, k, f.line.BOTTOM);
                    h.removeClass(f.line.LINE)
                }
            }
        },
        replaceIcoClass: function(a, b, c) {
            if (b && !a.isAjaxing && (a = b.attr("class"),
            a != void 0)) {
                a = a.split("_");
                switch (c) {
                case f.folder.OPEN:
                case f.folder.CLOSE:
                case f.folder.DOCU:
                    a[a.length - 1] = c
                }
                b.attr("class", a.join("_"))
            }
        },
        replaceSwitchClass: function(a, b, c) {
            if (b) {
                var d = b.attr("class");
                if (d != void 0) {
                    d = d.split("_");
                    switch (c) {
                    case f.line.ROOT:
                    case f.line.ROOTS:
                    case f.line.CENTER:
                    case f.line.BOTTOM:
                    case f.line.NOLINE:
                        d[0] = i.makeNodeLineClassEx(a) + c;
                        break;
                    case f.folder.OPEN:
                    case f.folder.CLOSE:
                    case f.folder.DOCU:
                        d[1] = c
                    }
                    b.attr("class", d.join("_"));
                    c !== f.folder.DOCU ? b.removeAttr("disabled") : b.attr("disabled", "disabled")
                }
            }
        },
        selectNode: function(a, b, c) {
            c || i.cancelPreSelectedNode(a, null, b);
            l(b, f.id.A, a).addClass(f.node.CURSELECTED);
            e.addSelectedNode(a, b);
            a.treeObj.trigger(f.event.SELECTED, [a.treeId, b])
        },
        setNodeFontCss: function(a, b) {
            var c = l(b, f.id.A, a)
              , d = i.makeNodeFontCss(a, b);
            d && c.css(d)
        },
        setNodeLineIcos: function(a, b) {
            if (b) {
                var c = l(b, f.id.SWITCH, a)
                  , d = l(b, f.id.UL, a)
                  , g = l(b, f.id.ICON, a)
                  , h = i.makeUlLineClass(a, b);
                h.length == 0 ? d.removeClass(f.line.LINE) : d.addClass(h);
                c.attr("class", i.makeNodeLineClass(a, b));
                e.nodeIsParent(a, b) ? c.removeAttr("disabled") : c.attr("disabled", "disabled");
                g.removeAttr("style");
                g.attr("style", i.makeNodeIcoStyle(a, b));
                g.attr("class", i.makeNodeIcoClass(a, b))
            }
        },
        setNodeName: function(a, b) {
            var c = e.nodeTitle(a, b)
              , d = l(b, f.id.SPAN, a);
            d.empty();
            a.view.nameIsHTML ? d.html(e.nodeName(a, b)) : d.text(e.nodeName(a, b));
            j.apply(a.view.showTitle, [a.treeId, b], a.view.showTitle) && l(b, f.id.A, a).attr("title", !c ? "" : c)
        },
        setNodeTarget: function(a, b) {
            l(b, f.id.A, a).attr("target", i.makeNodeTarget(b))
        },
        setNodeUrl: function(a, b) {
            var c = l(b, f.id.A, a)
              , d = i.makeNodeUrl(a, b);
            d == null || d.length == 0 ? c.removeAttr("href") : c.attr("href", d)
        },
        switchNode: function(a, b) {
            b.open || !j.canAsync(a, b) ? i.expandCollapseNode(a, b, !b.open) : a.async.enable ? i.asyncNode(a, b) || i.expandCollapseNode(a, b, !b.open) : b && i.expandCollapseNode(a, b, !b.open)
        }
    };
    q.fn.zTree = {
        consts: {
            className: {
                BUTTON: "button",
                LEVEL: "level",
                ICO_LOADING: "ico_loading",
                SWITCH: "switch",
                NAME: "node_name"
            },
            event: {
                NODECREATED: "ztree_nodeCreated",
                CLICK: "ztree_click",
                EXPAND: "ztree_expand",
                COLLAPSE: "ztree_collapse",
                ASYNC_SUCCESS: "ztree_async_success",
                ASYNC_ERROR: "ztree_async_error",
                REMOVE: "ztree_remove",
                SELECTED: "ztree_selected",
                UNSELECTED: "ztree_unselected"
            },
            id: {
                A: "_a",
                ICON: "_ico",
                SPAN: "_span",
                SWITCH: "_switch",
                UL: "_ul"
            },
            line: {
                ROOT: "root",
                ROOTS: "roots",
                CENTER: "center",
                BOTTOM: "bottom",
                NOLINE: "noline",
                LINE: "line"
            },
            folder: {
                OPEN: "open",
                CLOSE: "close",
                DOCU: "docu"
            },
            node: {
                CURSELECTED: "curSelectedNode"
            }
        },
        _z: {
            tools: j,
            view: i,
            event: n,
            data: e
        },
        getZTreeObj: function(a) {
            return (a = e.getZTreeTools(a)) ? a : null
        },
        destroy: function(a) {
            if (a && a.length > 0)
                i.destroy(e.getSetting(a));
            else
                for (var b in s)
                    i.destroy(s[b])
        },
        init: function(a, b, c) {
            var d = j.clone(N);
            q.extend(!0, d, b);
            d.treeId = a.attr("id");
            d.treeObj = a;
            d.treeObj.empty();
            s[d.treeId] = d;
            if (typeof document.body.style.maxHeight === "undefined")
                d.view.expandSpeed = "";
            e.initRoot(d);
            a = e.getRoot(d);
            c = c ? j.clone(j.isArray(c) ? c : [c]) : [];
            d.data.simpleData.enable ? e.nodeChildren(d, a, e.transformTozTreeFormat(d, c)) : e.nodeChildren(d, a, c);
            e.initCache(d);
            n.unbindTree(d);
            n.bindTree(d);
            n.unbindEvent(d);
            n.bindEvent(d);
            var g = {
                setting: d,
                addNodes: function(a, b, c, g) {
                    function f() {
                        i.addNodes(d, a, b, n, g == !0)
                    }
                    a || (a = null);
                    var l = e.nodeIsParent(d, a);
                    if (a && !l && d.data.keep.leaf)
                        return null;
                    l = parseInt(b, 10);
                    isNaN(l) ? (g = !!c,
                    c = b,
                    b = -1) : b = l;
                    if (!c)
                        return null;
                    var n = j.clone(j.isArray(c) ? c : [c]);
                    j.canAsync(d, a) ? i.asyncNode(d, a, g, f) : f();
                    return n
                },
                cancelSelectedNode: function(a) {
                    i.cancelPreSelectedNode(d, a)
                },
                destroy: function() {
                    i.destroy(d)
                },
                expandAll: function(a) {
                    a = !!a;
                    i.expandCollapseSonNode(d, null, a, !0);
                    return a
                },
                expandNode: function(a, b, c, g, f) {
                    function n() {
                        var b = l(a, d).get(0);
                        b && g !== !1 && i.scrollIntoView(d, b)
                    }
                    if (!a || !e.nodeIsParent(d, a))
                        return null;
                    b !== !0 && b !== !1 && (b = !a.open);
                    if ((f = !!f) && b && j.apply(d.callback.beforeExpand, [d.treeId, a], !0) == !1)
                        return null;
                    else if (f && !b && j.apply(d.callback.beforeCollapse, [d.treeId, a], !0) == !1)
                        return null;
                    b && a.parentTId && i.expandCollapseParentNode(d, a.getParentNode(), b, !1);
                    if (b === a.open && !c)
                        return null;
                    e.getRoot(d).expandTriggerFlag = f;
                    !j.canAsync(d, a) && c ? i.expandCollapseSonNode(d, a, b, !0, n) : (a.open = !b,
                    i.switchNode(this.setting, a),
                    n());
                    return b
                },
                getNodes: function() {
                    return e.getNodes(d)
                },
                getNodeByParam: function(a, b, c) {
                    return !a ? null : e.getNodeByParam(d, c ? e.nodeChildren(d, c) : e.getNodes(d), a, b)
                },
                getNodeByTId: function(a) {
                    return e.getNodeCache(d, a)
                },
                getNodesByParam: function(a, b, c) {
                    return !a ? null : e.getNodesByParam(d, c ? e.nodeChildren(d, c) : e.getNodes(d), a, b)
                },
                getNodesByParamFuzzy: function(a, b, c) {
                    return !a ? null : e.getNodesByParamFuzzy(d, c ? e.nodeChildren(d, c) : e.getNodes(d), a, b)
                },
                getNodesByFilter: function(a, b, c, f) {
                    b = !!b;
                    return !a || typeof a != "function" ? b ? null : [] : e.getNodesByFilter(d, c ? e.nodeChildren(d, c) : e.getNodes(d), a, b, f)
                },
                getNodeIndex: function(a) {
                    if (!a)
                        return null;
                    for (var b = a.parentTId ? a.getParentNode() : e.getRoot(d), b = e.nodeChildren(d, b), c = 0, f = b.length; c < f; c++)
                        if (b[c] == a)
                            return c;
                    return -1
                },
                getSelectedNodes: function() {
                    for (var a = [], b = e.getRoot(d).curSelectedList, c = 0, f = b.length; c < f; c++)
                        a.push(b[c]);
                    return a
                },
                isSelectedNode: function(a) {
                    return e.isSelectedNode(d, a)
                },
                reAsyncChildNodesPromise: function(a, b, c) {
                    return new Promise(function(d, e) {
                        try {
                            g.reAsyncChildNodes(a, b, c, function() {
                                d(a)
                            })
                        } catch (f) {
                            e(f)
                        }
                    }
                    )
                },
                reAsyncChildNodes: function(a, b, c, g) {
                    if (this.setting.async.enable) {
                        var j = !a;
                        j && (a = e.getRoot(d));
                        if (b == "refresh") {
                            for (var b = e.nodeChildren(d, a), n = 0, q = b ? b.length : 0; n < q; n++)
                                e.removeNodeCache(d, b[n]);
                            e.removeSelectedNode(d);
                            e.nodeChildren(d, a, []);
                            j ? this.setting.treeObj.empty() : l(a, f.id.UL, d).empty()
                        }
                        i.asyncNode(this.setting, j ? null : a, !!c, g)
                    }
                },
                refresh: function() {
                    this.setting.treeObj.empty();
                    var a = e.getRoot(d)
                      , b = e.nodeChildren(d, a);
                    e.initRoot(d);
                    e.nodeChildren(d, a, b);
                    e.initCache(d);
                    i.createNodes(d, 0, e.nodeChildren(d, a), null, -1)
                },
                removeChildNodes: function(a) {
                    if (!a)
                        return null;
                    var b = e.nodeChildren(d, a);
                    i.removeChildNodes(d, a);
                    return b ? b : null
                },
                removeNode: function(a, b) {
                    a && (b = !!b,
                    b && j.apply(d.callback.beforeRemove, [d.treeId, a], !0) == !1 || (i.removeNode(d, a),
                    b && this.setting.treeObj.trigger(f.event.REMOVE, [d.treeId, a])))
                },
                selectNode: function(a, b, c) {
                    function e() {
                        if (!c) {
                            var b = l(a, d).get(0);
                            i.scrollIntoView(d, b)
                        }
                    }
                    if (a && j.uCanDo(d)) {
                        b = d.view.selectedMulti && b;
                        if (a.parentTId)
                            i.expandCollapseParentNode(d, a.getParentNode(), !0, !1, e);
                        else if (!c)
                            try {
                                l(a, d).focus().blur()
                            } catch (f) {}
                        i.selectNode(d, a, b)
                    }
                },
                transformTozTreeNodes: function(a) {
                    return e.transformTozTreeFormat(d, a)
                },
                transformToArray: function(a) {
                    return e.transformToArrayFormat(d, a)
                },
                updateNode: function(a) {
                    a && l(a, d).get(0) && j.uCanDo(d) && (i.setNodeName(d, a),
                    i.setNodeTarget(d, a),
                    i.setNodeUrl(d, a),
                    i.setNodeLineIcos(d, a),
                    i.setNodeFontCss(d, a))
                }
            };
            a.treeTools = g;
            e.setZTreeTools(d, g);
            (c = e.nodeChildren(d, a)) && c.length > 0 ? i.createNodes(d, 0, c, null, -1) : d.async.enable && d.async.url && d.async.url !== "" && i.asyncNode(d);
            return g
        }
    };
    var O = q.fn.zTree
      , l = j.$
      , f = O.consts
}
)(jQuery);

/*
 * JQuery zTree excheck v3.5.36
 * http://treejs.cn/
 *
 * Copyright (c) 2010 Hunter.z
 *
 * Licensed same as jquery - MIT License
 * http://www.opensource.org/licenses/mit-license.php
 *
 * email: hunter.z@263.net
 * Date: 2018-06-26
 */
(function(n) {
    var q, r, s, p = {
        event: {
            CHECK: "ztree_check"
        },
        id: {
            CHECK: "_check"
        },
        checkbox: {
            STYLE: "checkbox",
            DEFAULT: "chk",
            DISABLED: "disable",
            FALSE: "false",
            TRUE: "true",
            FULL: "full",
            PART: "part",
            FOCUS: "focus"
        },
        radio: {
            STYLE: "radio",
            TYPE_ALL: "all",
            TYPE_LEVEL: "level"
        }
    }, w = {
        check: {
            enable: !1,
            autoCheckTrigger: !1,
            chkStyle: p.checkbox.STYLE,
            nocheckInherit: !1,
            chkDisabledInherit: !1,
            radioType: p.radio.TYPE_LEVEL,
            chkboxType: {
                Y: "ps",
                N: "ps"
            }
        },
        data: {
            key: {
                checked: "checked"
            }
        },
        callback: {
            beforeCheck: null,
            onCheck: null
        }
    };
    q = function(c, a) {
        if (a.chkDisabled === !0)
            return !1;
        var b = e.getSetting(c.data.treeId);
        if (i.apply(b.callback.beforeCheck, [b.treeId, a], !0) == !1)
            return !0;
        var d = e.nodeChecked(b, a);
        e.nodeChecked(b, a, !d);
        f.checkNodeRelation(b, a);
        d = m(a, h.id.CHECK, b);
        f.setChkClass(b, d, a);
        f.repairParentChkClassWithSelf(b, a);
        b.treeObj.trigger(h.event.CHECK, [c, b.treeId, a]);
        return !0
    }
    ;
    r = function(c, a) {
        if (a.chkDisabled === !0)
            return !1;
        var b = e.getSetting(c.data.treeId)
          , d = m(a, h.id.CHECK, b);
        a.check_Focus = !0;
        f.setChkClass(b, d, a);
        return !0
    }
    ;
    s = function(c, a) {
        if (a.chkDisabled === !0)
            return !1;
        var b = e.getSetting(c.data.treeId)
          , d = m(a, h.id.CHECK, b);
        a.check_Focus = !1;
        f.setChkClass(b, d, a);
        return !0
    }
    ;
    n.extend(!0, n.fn.zTree.consts, p);
    n.extend(!0, n.fn.zTree._z, {
        tools: {},
        view: {
            checkNodeRelation: function(c, a) {
                var b, d, j;
                d = h.radio;
                b = e.nodeChecked(c, a);
                if (c.check.chkStyle == d.STYLE) {
                    var g = e.getRadioCheckedList(c);
                    if (b)
                        if (c.check.radioType == d.TYPE_ALL) {
                            for (d = g.length - 1; d >= 0; d--) {
                                b = g[d];
                                var k = e.nodeChecked(c, b);
                                k && b != a && (e.nodeChecked(c, b, !1),
                                g.splice(d, 1),
                                f.setChkClass(c, m(b, h.id.CHECK, c), b),
                                b.parentTId != a.parentTId && f.repairParentChkClassWithSelf(c, b))
                            }
                            g.push(a)
                        } else {
                            g = a.parentTId ? a.getParentNode() : e.getRoot(c);
                            g = e.nodeChildren(c, g);
                            for (d = 0,
                            j = g.length; d < j; d++)
                                if (b = g[d],
                                (k = e.nodeChecked(c, b)) && b != a)
                                    e.nodeChecked(c, b, !1),
                                    f.setChkClass(c, m(b, h.id.CHECK, c), b)
                        }
                    else if (c.check.radioType == d.TYPE_ALL)
                        for (d = 0,
                        j = g.length; d < j; d++)
                            if (a == g[d]) {
                                g.splice(d, 1);
                                break
                            }
                } else
                    g = e.nodeChildren(c, a),
                    b && (!g || g.length == 0 || c.check.chkboxType.Y.indexOf("s") > -1) && f.setSonNodeCheckBox(c, a, !0),
                    !b && (!g || g.length == 0 || c.check.chkboxType.N.indexOf("s") > -1) && f.setSonNodeCheckBox(c, a, !1),
                    b && c.check.chkboxType.Y.indexOf("p") > -1 && f.setParentNodeCheckBox(c, a, !0),
                    !b && c.check.chkboxType.N.indexOf("p") > -1 && f.setParentNodeCheckBox(c, a, !1)
            },
            makeChkClass: function(c, a) {
                var b = h.checkbox
                  , d = h.radio
                  , j = ""
                  , g = e.nodeChecked(c, a)
                  , j = a.chkDisabled === !0 ? b.DISABLED : a.halfCheck ? b.PART : c.check.chkStyle == d.STYLE ? a.check_Child_State < 1 ? b.FULL : b.PART : g ? a.check_Child_State === 2 || a.check_Child_State === -1 ? b.FULL : b.PART : a.check_Child_State < 1 ? b.FULL : b.PART
                  , d = c.check.chkStyle + "_" + (g ? b.TRUE : b.FALSE) + "_" + j
                  , d = a.check_Focus && a.chkDisabled !== !0 ? d + "_" + b.FOCUS : d;
                return h.className.BUTTON + " " + b.DEFAULT + " " + d
            },
            repairAllChk: function(c, a) {
                if (c.check.enable && c.check.chkStyle === h.checkbox.STYLE)
                    for (var b = e.getRoot(c), b = e.nodeChildren(c, b), d = 0, j = b.length; d < j; d++) {
                        var g = b[d];
                        g.nocheck !== !0 && g.chkDisabled !== !0 && e.nodeChecked(c, g, a);
                        f.setSonNodeCheckBox(c, g, a)
                    }
            },
            repairChkClass: function(c, a) {
                if (a && (e.makeChkFlag(c, a),
                a.nocheck !== !0)) {
                    var b = m(a, h.id.CHECK, c);
                    f.setChkClass(c, b, a)
                }
            },
            repairParentChkClass: function(c, a) {
                if (a && a.parentTId) {
                    var b = a.getParentNode();
                    f.repairChkClass(c, b);
                    f.repairParentChkClass(c, b)
                }
            },
            repairParentChkClassWithSelf: function(c, a) {
                if (a) {
                    var b = e.nodeChildren(c, a);
                    b && b.length > 0 ? f.repairParentChkClass(c, b[0]) : f.repairParentChkClass(c, a)
                }
            },
            repairSonChkDisabled: function(c, a, b, d) {
                if (a) {
                    if (a.chkDisabled != b)
                        a.chkDisabled = b;
                    f.repairChkClass(c, a);
                    if ((a = e.nodeChildren(c, a)) && d)
                        for (var j = 0, g = a.length; j < g; j++)
                            f.repairSonChkDisabled(c, a[j], b, d)
                }
            },
            repairParentChkDisabled: function(c, a, b, d) {
                if (a) {
                    if (a.chkDisabled != b && d)
                        a.chkDisabled = b;
                    f.repairChkClass(c, a);
                    f.repairParentChkDisabled(c, a.getParentNode(), b, d)
                }
            },
            setChkClass: function(c, a, b) {
                a && (b.nocheck === !0 ? a.hide() : a.show(),
                a.attr("class", f.makeChkClass(c, b)))
            },
            setParentNodeCheckBox: function(c, a, b, d) {
                var j = m(a, h.id.CHECK, c);
                d || (d = a);
                e.makeChkFlag(c, a);
                a.nocheck !== !0 && a.chkDisabled !== !0 && (e.nodeChecked(c, a, b),
                f.setChkClass(c, j, a),
                c.check.autoCheckTrigger && a != d && c.treeObj.trigger(h.event.CHECK, [null, c.treeId, a]));
                if (a.parentTId) {
                    j = !0;
                    if (!b)
                        for (var g = e.nodeChildren(c, a.getParentNode()), k = 0, o = g.length; k < o; k++) {
                            var l = g[k]
                              , i = e.nodeChecked(c, l);
                            if (l.nocheck !== !0 && l.chkDisabled !== !0 && i || (l.nocheck === !0 || l.chkDisabled === !0) && l.check_Child_State > 0) {
                                j = !1;
                                break
                            }
                        }
                    j && f.setParentNodeCheckBox(c, a.getParentNode(), b, d)
                }
            },
            setSonNodeCheckBox: function(c, a, b, d) {
                if (a) {
                    var j = m(a, h.id.CHECK, c);
                    d || (d = a);
                    var g = !1
                      , k = e.nodeChildren(c, a);
                    if (k)
                        for (var o = 0, l = k.length; o < l; o++) {
                            var i = k[o];
                            f.setSonNodeCheckBox(c, i, b, d);
                            i.chkDisabled === !0 && (g = !0)
                        }
                    if (a != e.getRoot(c) && a.chkDisabled !== !0) {
                        g && a.nocheck !== !0 && e.makeChkFlag(c, a);
                        if (a.nocheck !== !0 && a.chkDisabled !== !0) {
                            if (e.nodeChecked(c, a, b),
                            !g)
                                a.check_Child_State = k && k.length > 0 ? b ? 2 : 0 : -1
                        } else
                            a.check_Child_State = -1;
                        f.setChkClass(c, j, a);
                        c.check.autoCheckTrigger && a != d && a.nocheck !== !0 && a.chkDisabled !== !0 && c.treeObj.trigger(h.event.CHECK, [null, c.treeId, a])
                    }
                }
            }
        },
        event: {},
        data: {
            getRadioCheckedList: function(c) {
                for (var a = e.getRoot(c).radioCheckedList, b = 0, d = a.length; b < d; b++)
                    e.getNodeCache(c, a[b].tId) || (a.splice(b, 1),
                    b--,
                    d--);
                return a
            },
            getCheckStatus: function(c, a) {
                if (!c.check.enable || a.nocheck || a.chkDisabled)
                    return null;
                var b = e.nodeChecked(c, a);
                return {
                    checked: b,
                    half: a.halfCheck ? a.halfCheck : c.check.chkStyle == h.radio.STYLE ? a.check_Child_State === 2 : b ? a.check_Child_State > -1 && a.check_Child_State < 2 : a.check_Child_State > 0
                }
            },
            getTreeCheckedNodes: function(c, a, b, d) {
                if (!a)
                    return [];
                for (var j = b && c.check.chkStyle == h.radio.STYLE && c.check.radioType == h.radio.TYPE_ALL, d = !d ? [] : d, g = 0, f = a.length; g < f; g++) {
                    var i = a[g]
                      , l = e.nodeChildren(c, i)
                      , m = e.nodeChecked(c, i);
                    if (i.nocheck !== !0 && i.chkDisabled !== !0 && m == b && (d.push(i),
                    j))
                        break;
                    e.getTreeCheckedNodes(c, l, b, d);
                    if (j && d.length > 0)
                        break
                }
                return d
            },
            getTreeChangeCheckedNodes: function(c, a, b) {
                if (!a)
                    return [];
                for (var b = !b ? [] : b, d = 0, j = a.length; d < j; d++) {
                    var g = a[d]
                      , f = e.nodeChildren(c, g)
                      , h = e.nodeChecked(c, g);
                    g.nocheck !== !0 && g.chkDisabled !== !0 && h != g.checkedOld && b.push(g);
                    e.getTreeChangeCheckedNodes(c, f, b)
                }
                return b
            },
            makeChkFlag: function(c, a) {
                if (a) {
                    var b = -1
                      , d = e.nodeChildren(c, a);
                    if (d)
                        for (var j = 0, g = d.length; j < g; j++) {
                            var f = d[j]
                              , i = e.nodeChecked(c, f)
                              , l = -1;
                            if (c.check.chkStyle == h.radio.STYLE)
                                if (l = f.nocheck === !0 || f.chkDisabled === !0 ? f.check_Child_State : f.halfCheck === !0 ? 2 : i ? 2 : f.check_Child_State > 0 ? 2 : 0,
                                l == 2) {
                                    b = 2;
                                    break
                                } else
                                    l == 0 && (b = 0);
                            else if (c.check.chkStyle == h.checkbox.STYLE)
                                if (l = f.nocheck === !0 || f.chkDisabled === !0 ? f.check_Child_State : f.halfCheck === !0 ? 1 : i ? f.check_Child_State === -1 || f.check_Child_State === 2 ? 2 : 1 : f.check_Child_State > 0 ? 1 : 0,
                                l === 1) {
                                    b = 1;
                                    break
                                } else if (l === 2 && b > -1 && j > 0 && l !== b) {
                                    b = 1;
                                    break
                                } else if (b === 2 && l > -1 && l < 2) {
                                    b = 1;
                                    break
                                } else
                                    l > -1 && (b = l)
                        }
                    a.check_Child_State = b
                }
            }
        }
    });
    var n = n.fn.zTree
      , i = n._z.tools
      , h = n.consts
      , f = n._z.view
      , e = n._z.data
      , m = i.$;
    e.nodeChecked = function(c, a, b) {
        if (!a)
            return !1;
        c = c.data.key.checked;
        typeof b !== "undefined" && (typeof b === "string" && (b = i.eqs(b, "true")),
        a[c] = !!b);
        return a[c]
    }
    ;
    e.exSetting(w);
    e.addInitBind(function(c) {
        c.treeObj.bind(h.event.CHECK, function(a, b, d, e) {
            a.srcEvent = b;
            i.apply(c.callback.onCheck, [a, d, e])
        })
    });
    e.addInitUnBind(function(c) {
        c.treeObj.unbind(h.event.CHECK)
    });
    e.addInitCache(function() {});
    e.addInitNode(function(c, a, b, d) {
        if (b) {
            a = e.nodeChecked(c, b);
            a = e.nodeChecked(c, b, a);
            b.checkedOld = a;
            if (typeof b.nocheck == "string")
                b.nocheck = i.eqs(b.nocheck, "true");
            b.nocheck = !!b.nocheck || c.check.nocheckInherit && d && !!d.nocheck;
            if (typeof b.chkDisabled == "string")
                b.chkDisabled = i.eqs(b.chkDisabled, "true");
            b.chkDisabled = !!b.chkDisabled || c.check.chkDisabledInherit && d && !!d.chkDisabled;
            if (typeof b.halfCheck == "string")
                b.halfCheck = i.eqs(b.halfCheck, "true");
            b.halfCheck = !!b.halfCheck;
            b.check_Child_State = -1;
            b.check_Focus = !1;
            b.getCheckStatus = function() {
                return e.getCheckStatus(c, b)
            }
            ;
            c.check.chkStyle == h.radio.STYLE && c.check.radioType == h.radio.TYPE_ALL && a && e.getRoot(c).radioCheckedList.push(b)
        }
    });
    e.addInitProxy(function(c) {
        var a = c.target
          , b = e.getSetting(c.data.treeId)
          , d = ""
          , f = null
          , g = ""
          , k = null;
        if (i.eqs(c.type, "mouseover")) {
            if (b.check.enable && i.eqs(a.tagName, "span") && a.getAttribute("treeNode" + h.id.CHECK) !== null)
                d = i.getNodeMainDom(a).id,
                g = "mouseoverCheck"
        } else if (i.eqs(c.type, "mouseout")) {
            if (b.check.enable && i.eqs(a.tagName, "span") && a.getAttribute("treeNode" + h.id.CHECK) !== null)
                d = i.getNodeMainDom(a).id,
                g = "mouseoutCheck"
        } else if (i.eqs(c.type, "click") && b.check.enable && i.eqs(a.tagName, "span") && a.getAttribute("treeNode" + h.id.CHECK) !== null)
            d = i.getNodeMainDom(a).id,
            g = "checkNode";
        if (d.length > 0)
            switch (f = e.getNodeCache(b, d),
            g) {
            case "checkNode":
                k = q;
                break;
            case "mouseoverCheck":
                k = r;
                break;
            case "mouseoutCheck":
                k = s
            }
        return {
            stop: g === "checkNode",
            node: f,
            nodeEventType: g,
            nodeEventCallback: k,
            treeEventType: "",
            treeEventCallback: null
        }
    }, !0);
    e.addInitRoot(function(c) {
        e.getRoot(c).radioCheckedList = []
    });
    e.addBeforeA(function(c, a, b) {
        c.check.enable && (e.makeChkFlag(c, a),
        b.push("<span ID='", a.tId, h.id.CHECK, "' class='", f.makeChkClass(c, a), "' treeNode", h.id.CHECK, a.nocheck === !0 ? " style='display:none;'" : "", "></span>"))
    });
    e.addZTreeTools(function(c, a) {
        a.checkNode = function(a, b, g, k) {
            var o = e.nodeChecked(c, a);
            if (a.chkDisabled !== !0 && (b !== !0 && b !== !1 && (b = !o),
            k = !!k,
            (o !== b || g) && !(k && i.apply(this.setting.callback.beforeCheck, [this.setting.treeId, a], !0) == !1) && i.uCanDo(this.setting) && this.setting.check.enable && a.nocheck !== !0))
                e.nodeChecked(c, a, b),
                b = m(a, h.id.CHECK, this.setting),
                (g || this.setting.check.chkStyle === h.radio.STYLE) && f.checkNodeRelation(this.setting, a),
                f.setChkClass(this.setting, b, a),
                f.repairParentChkClassWithSelf(this.setting, a),
                k && this.setting.treeObj.trigger(h.event.CHECK, [null, this.setting.treeId, a])
        }
        ;
        a.checkAllNodes = function(a) {
            f.repairAllChk(this.setting, !!a)
        }
        ;
        a.getCheckedNodes = function(a) {
            var a = a !== !1
              , b = e.nodeChildren(c, e.getRoot(this.setting));
            return e.getTreeCheckedNodes(this.setting, b, a)
        }
        ;
        a.getChangeCheckedNodes = function() {
            var a = e.nodeChildren(c, e.getRoot(this.setting));
            return e.getTreeChangeCheckedNodes(this.setting, a)
        }
        ;
        a.setChkDisabled = function(a, b, c, e) {
            b = !!b;
            c = !!c;
            f.repairSonChkDisabled(this.setting, a, b, !!e);
            f.repairParentChkDisabled(this.setting, a.getParentNode(), b, c)
        }
        ;
        var b = a.updateNode;
        a.updateNode = function(c, e) {
            b && b.apply(a, arguments);
            if (c && this.setting.check.enable && m(c, this.setting).get(0) && i.uCanDo(this.setting)) {
                var g = m(c, h.id.CHECK, this.setting);
                (e == !0 || this.setting.check.chkStyle === h.radio.STYLE) && f.checkNodeRelation(this.setting, c);
                f.setChkClass(this.setting, g, c);
                f.repairParentChkClassWithSelf(this.setting, c)
            }
        }
    });
    var t = f.createNodes;
    f.createNodes = function(c, a, b, d, e) {
        t && t.apply(f, arguments);
        b && f.repairParentChkClassWithSelf(c, d)
    }
    ;
    var u = f.removeNode;
    f.removeNode = function(c, a) {
        var b = a.getParentNode();
        u && u.apply(f, arguments);
        a && b && (f.repairChkClass(c, b),
        f.repairParentChkClass(c, b))
    }
    ;
    var v = f.appendNodes;
    f.appendNodes = function(c, a, b, d, h, g, i) {
        var m = "";
        v && (m = v.apply(f, arguments));
        d && e.makeChkFlag(c, d);
        return m
    }
}
)(jQuery);

/*
 * JQuery zTree exedit v3.5.36
 * http://treejs.cn/
 *
 * Copyright (c) 2010 Hunter.z
 *
 * Licensed same as jquery - MIT License
 * http://www.opensource.org/licenses/mit-license.php
 *
 * email: hunter.z@263.net
 * Date: 2018-06-26
 */
(function(B) {
    var I = {
        event: {
            DRAG: "ztree_drag",
            DROP: "ztree_drop",
            RENAME: "ztree_rename",
            DRAGMOVE: "ztree_dragmove"
        },
        id: {
            EDIT: "_edit",
            INPUT: "_input",
            REMOVE: "_remove"
        },
        move: {
            TYPE_INNER: "inner",
            TYPE_PREV: "prev",
            TYPE_NEXT: "next"
        },
        node: {
            CURSELECTED_EDIT: "curSelectedNode_Edit",
            TMPTARGET_TREE: "tmpTargetzTree",
            TMPTARGET_NODE: "tmpTargetNode"
        }
    }
      , v = {
        onHoverOverNode: function(a, b) {
            var c = i.getSetting(a.data.treeId)
              , d = i.getRoot(c);
            if (d.curHoverNode != b)
                v.onHoverOutNode(a);
            d.curHoverNode = b;
            e.addHoverDom(c, b)
        },
        onHoverOutNode: function(a) {
            var a = i.getSetting(a.data.treeId)
              , b = i.getRoot(a);
            if (b.curHoverNode && !i.isSelectedNode(a, b.curHoverNode))
                e.removeTreeDom(a, b.curHoverNode),
                b.curHoverNode = null
        },
        onMousedownNode: function(a, b) {
            function c(a) {
                if (m.dragFlag == 0 && Math.abs(N - a.clientX) < f.edit.drag.minMoveSize && Math.abs(O - a.clientY) < f.edit.drag.minMoveSize)
                    return !0;
                var b, c, g, j;
                L.css("cursor", "pointer");
                if (m.dragFlag == 0) {
                    if (k.apply(f.callback.beforeDrag, [f.treeId, n], !0) == !1)
                        return l(a),
                        !0;
                    for (b = 0,
                    c = n.length; b < c; b++) {
                        if (b == 0)
                            m.dragNodeShowBefore = [];
                        g = n[b];
                        i.nodeIsParent(f, g) && g.open ? (e.expandCollapseNode(f, g, !g.open),
                        m.dragNodeShowBefore[g.tId] = !0) : m.dragNodeShowBefore[g.tId] = !1
                    }
                    m.dragFlag = 1;
                    y.showHoverDom = !1;
                    k.showIfameMask(f, !0);
                    j = !0;
                    var p = -1;
                    if (n.length > 1) {
                        var o = n[0].parentTId ? i.nodeChildren(f, n[0].getParentNode()) : i.getNodes(f);
                        g = [];
                        for (b = 0,
                        c = o.length; b < c; b++)
                            if (m.dragNodeShowBefore[o[b].tId] !== void 0 && (j && p > -1 && p + 1 !== b && (j = !1),
                            g.push(o[b]),
                            p = b),
                            n.length === g.length) {
                                n = g;
                                break
                            }
                    }
                    j && (H = n[0].getPreNode(),
                    Q = n[n.length - 1].getNextNode());
                    C = q("<ul class='zTreeDragUL'></ul>", f);
                    for (b = 0,
                    c = n.length; b < c; b++)
                        g = n[b],
                        g.editNameFlag = !1,
                        e.selectNode(f, g, b > 0),
                        e.removeTreeDom(f, g),
                        b > f.edit.drag.maxShowNodeNum - 1 || (j = q("<li id='" + g.tId + "_tmp'></li>", f),
                        j.append(q(g, d.id.A, f).clone()),
                        j.css("padding", "0"),
                        j.children("#" + g.tId + d.id.A).removeClass(d.node.CURSELECTED),
                        C.append(j),
                        b == f.edit.drag.maxShowNodeNum - 1 && (j = q("<li id='" + g.tId + "_moretmp'><a>  ...  </a></li>", f),
                        C.append(j)));
                    C.attr("id", n[0].tId + d.id.UL + "_tmp");
                    C.addClass(f.treeObj.attr("class"));
                    C.appendTo(L);
                    u = q("<span class='tmpzTreeMove_arrow'></span>", f);
                    u.attr("id", "zTreeMove_arrow_tmp");
                    u.appendTo(L);
                    f.treeObj.trigger(d.event.DRAG, [a, f.treeId, n])
                }
                if (m.dragFlag == 1) {
                    t && u.attr("id") == a.target.id && w && a.clientX + G.scrollLeft() + 2 > B("#" + w + d.id.A, t).offset().left ? (g = B("#" + w + d.id.A, t),
                    a.target = g.length > 0 ? g.get(0) : a.target) : t && (t.removeClass(d.node.TMPTARGET_TREE),
                    w && B("#" + w + d.id.A, t).removeClass(d.node.TMPTARGET_NODE + "_" + d.move.TYPE_PREV).removeClass(d.node.TMPTARGET_NODE + "_" + I.move.TYPE_NEXT).removeClass(d.node.TMPTARGET_NODE + "_" + I.move.TYPE_INNER));
                    w = t = null;
                    J = !1;
                    h = f;
                    g = i.getSettings();
                    for (var z in g)
                        if (g[z].treeId && g[z].edit.enable && g[z].treeId != f.treeId && (a.target.id == g[z].treeId || B(a.target).parents("#" + g[z].treeId).length > 0))
                            J = !0,
                            h = g[z];
                    z = G.scrollTop();
                    j = G.scrollLeft();
                    p = h.treeObj.offset();
                    b = h.treeObj.get(0).scrollHeight;
                    g = h.treeObj.get(0).scrollWidth;
                    c = a.clientY + z - p.top;
                    var E = h.treeObj.height() + p.top - a.clientY - z
                      , r = a.clientX + j - p.left
                      , s = h.treeObj.width() + p.left - a.clientX - j
                      , p = c < f.edit.drag.borderMax && c > f.edit.drag.borderMin
                      , o = E < f.edit.drag.borderMax && E > f.edit.drag.borderMin
                      , F = r < f.edit.drag.borderMax && r > f.edit.drag.borderMin
                      , v = s < f.edit.drag.borderMax && s > f.edit.drag.borderMin
                      , E = c > f.edit.drag.borderMin && E > f.edit.drag.borderMin && r > f.edit.drag.borderMin && s > f.edit.drag.borderMin
                      , r = p && h.treeObj.scrollTop() <= 0
                      , s = o && h.treeObj.scrollTop() + h.treeObj.height() + 10 >= b
                      , M = F && h.treeObj.scrollLeft() <= 0
                      , P = v && h.treeObj.scrollLeft() + h.treeObj.width() + 10 >= g;
                    if (a.target && k.isChildOrSelf(a.target, h.treeId)) {
                        for (var D = a.target; D && D.tagName && !k.eqs(D.tagName, "li") && D.id != h.treeId; )
                            D = D.parentNode;
                        var R = !0;
                        for (b = 0,
                        c = n.length; b < c; b++)
                            if (g = n[b],
                            D.id === g.tId) {
                                R = !1;
                                break
                            } else if (q(g, f).find("#" + D.id).length > 0) {
                                R = !1;
                                break
                            }
                        if (R && a.target && k.isChildOrSelf(a.target, D.id + d.id.A))
                            t = B(D),
                            w = D.id
                    }
                    g = n[0];
                    if (E && k.isChildOrSelf(a.target, h.treeId)) {
                        if (!t && (a.target.id == h.treeId || r || s || M || P) && (J || !J && g.parentTId))
                            t = h.treeObj;
                        p ? h.treeObj.scrollTop(h.treeObj.scrollTop() - 10) : o && h.treeObj.scrollTop(h.treeObj.scrollTop() + 10);
                        F ? h.treeObj.scrollLeft(h.treeObj.scrollLeft() - 10) : v && h.treeObj.scrollLeft(h.treeObj.scrollLeft() + 10);
                        t && t != h.treeObj && t.offset().left < h.treeObj.offset().left && h.treeObj.scrollLeft(h.treeObj.scrollLeft() + t.offset().left - h.treeObj.offset().left)
                    }
                    C.css({
                        top: a.clientY + z + 3 + "px",
                        left: a.clientX + j + 3 + "px"
                    });
                    b = j = 0;
                    if (t && t.attr("id") != h.treeId) {
                        var A = w == null ? null : i.getNodeCache(h, w)
                          , p = (a.ctrlKey || a.metaKey) && f.edit.drag.isMove && f.edit.drag.isCopy || !f.edit.drag.isMove && f.edit.drag.isCopy;
                        c = !!(H && w === H.tId);
                        F = !!(Q && w === Q.tId);
                        o = g.parentTId && g.parentTId == w;
                        g = (p || !F) && k.apply(h.edit.drag.prev, [h.treeId, n, A], !!h.edit.drag.prev);
                        c = (p || !c) && k.apply(h.edit.drag.next, [h.treeId, n, A], !!h.edit.drag.next);
                        p = (p || !o) && !(h.data.keep.leaf && !i.nodeIsParent(f, A)) && k.apply(h.edit.drag.inner, [h.treeId, n, A], !!h.edit.drag.inner);
                        o = function() {
                            t = null;
                            w = "";
                            x = d.move.TYPE_INNER;
                            u.css({
                                display: "none"
                            });
                            if (window.zTreeMoveTimer)
                                clearTimeout(window.zTreeMoveTimer),
                                window.zTreeMoveTargetNodeTId = null
                        }
                        ;
                        if (!g && !c && !p)
                            o();
                        else if (F = B("#" + w + d.id.A, t),
                        v = A.isLastNode ? null : B("#" + A.getNextNode().tId + d.id.A, t.next()),
                        E = F.offset().top,
                        r = F.offset().left,
                        s = g ? p ? 0.25 : c ? 0.5 : 1 : -1,
                        M = c ? p ? 0.75 : g ? 0.5 : 0 : -1,
                        z = (a.clientY + z - E) / F.height(),
                        (s == 1 || z <= s && z >= -0.2) && g ? (j = 1 - u.width(),
                        b = E - u.height() / 2,
                        x = d.move.TYPE_PREV) : (M == 0 || z >= M && z <= 1.2) && c ? (j = 1 - u.width(),
                        b = v == null || i.nodeIsParent(f, A) && A.open ? E + F.height() - u.height() / 2 : v.offset().top - u.height() / 2,
                        x = d.move.TYPE_NEXT) : p ? (j = 5 - u.width(),
                        b = E,
                        x = d.move.TYPE_INNER) : o(),
                        t) {
                            u.css({
                                display: "block",
                                top: b + "px",
                                left: r + j + "px"
                            });
                            F.addClass(d.node.TMPTARGET_NODE + "_" + x);
                            if (S != w || T != x)
                                K = (new Date).getTime();
                            if (A && i.nodeIsParent(f, A) && x == d.move.TYPE_INNER && (z = !0,
                            window.zTreeMoveTimer && window.zTreeMoveTargetNodeTId !== A.tId ? (clearTimeout(window.zTreeMoveTimer),
                            window.zTreeMoveTargetNodeTId = null) : window.zTreeMoveTimer && window.zTreeMoveTargetNodeTId === A.tId && (z = !1),
                            z))
                                window.zTreeMoveTimer = setTimeout(function() {
                                    x == d.move.TYPE_INNER && A && i.nodeIsParent(f, A) && !A.open && (new Date).getTime() - K > h.edit.drag.autoOpenTime && k.apply(h.callback.beforeDragOpen, [h.treeId, A], !0) && (e.switchNode(h, A),
                                    h.edit.drag.autoExpandTrigger && h.treeObj.trigger(d.event.EXPAND, [h.treeId, A]))
                                }, h.edit.drag.autoOpenTime + 50),
                                window.zTreeMoveTargetNodeTId = A.tId
                        }
                    } else if (x = d.move.TYPE_INNER,
                    t && k.apply(h.edit.drag.inner, [h.treeId, n, null], !!h.edit.drag.inner) ? t.addClass(d.node.TMPTARGET_TREE) : t = null,
                    u.css({
                        display: "none"
                    }),
                    window.zTreeMoveTimer)
                        clearTimeout(window.zTreeMoveTimer),
                        window.zTreeMoveTargetNodeTId = null;
                    S = w;
                    T = x;
                    f.treeObj.trigger(d.event.DRAGMOVE, [a, f.treeId, n])
                }
                return !1
            }
            function l(a) {
                if (window.zTreeMoveTimer)
                    clearTimeout(window.zTreeMoveTimer),
                    window.zTreeMoveTargetNodeTId = null;
                T = S = null;
                G.unbind("mousemove", c);
                G.unbind("mouseup", l);
                G.unbind("selectstart", g);
                L.css("cursor", "");
                t && (t.removeClass(d.node.TMPTARGET_TREE),
                w && B("#" + w + d.id.A, t).removeClass(d.node.TMPTARGET_NODE + "_" + d.move.TYPE_PREV).removeClass(d.node.TMPTARGET_NODE + "_" + I.move.TYPE_NEXT).removeClass(d.node.TMPTARGET_NODE + "_" + I.move.TYPE_INNER));
                k.showIfameMask(f, !1);
                y.showHoverDom = !0;
                if (m.dragFlag != 0) {
                    m.dragFlag = 0;
                    var b, j, o;
                    for (b = 0,
                    j = n.length; b < j; b++)
                        o = n[b],
                        i.nodeIsParent(f, o) && m.dragNodeShowBefore[o.tId] && !o.open && (e.expandCollapseNode(f, o, !o.open),
                        delete m.dragNodeShowBefore[o.tId]);
                    C && C.remove();
                    u && u.remove();
                    var r = (a.ctrlKey || a.metaKey) && f.edit.drag.isMove && f.edit.drag.isCopy || !f.edit.drag.isMove && f.edit.drag.isCopy;
                    !r && t && w && n[0].parentTId && w == n[0].parentTId && x == d.move.TYPE_INNER && (t = null);
                    if (t) {
                        var p = w == null ? null : i.getNodeCache(h, w);
                        if (k.apply(f.callback.beforeDrop, [h.treeId, n, p, x, r], !0) == !1)
                            e.selectNodes(v, n);
                        else {
                            var s = r ? k.clone(n) : n;
                            b = function() {
                                if (J) {
                                    if (!r)
                                        for (var b = 0, c = n.length; b < c; b++)
                                            e.removeNode(f, n[b]);
                                    x == d.move.TYPE_INNER ? e.addNodes(h, p, -1, s) : e.addNodes(h, p.getParentNode(), x == d.move.TYPE_PREV ? p.getIndex() : p.getIndex() + 1, s)
                                } else if (r && x == d.move.TYPE_INNER)
                                    e.addNodes(h, p, -1, s);
                                else if (r)
                                    e.addNodes(h, p.getParentNode(), x == d.move.TYPE_PREV ? p.getIndex() : p.getIndex() + 1, s);
                                else if (x != d.move.TYPE_NEXT)
                                    for (b = 0,
                                    c = s.length; b < c; b++)
                                        e.moveNode(h, p, s[b], x, !1);
                                else
                                    for (b = -1,
                                    c = s.length - 1; b < c; c--)
                                        e.moveNode(h, p, s[c], x, !1);
                                e.selectNodes(h, s);
                                b = q(s[0], f).get(0);
                                e.scrollIntoView(f, b);
                                f.treeObj.trigger(d.event.DROP, [a, h.treeId, s, p, x, r])
                            }
                            ;
                            x == d.move.TYPE_INNER && k.canAsync(h, p) ? e.asyncNode(h, p, !1, b) : b()
                        }
                    } else
                        e.selectNodes(v, n),
                        f.treeObj.trigger(d.event.DROP, [a, f.treeId, n, null, null, null])
                }
            }
            function g() {
                return !1
            }
            var o, j, f = i.getSetting(a.data.treeId), m = i.getRoot(f), y = i.getRoots();
            if (a.button == 2 || !f.edit.enable || !f.edit.drag.isCopy && !f.edit.drag.isMove)
                return !0;
            var r = a.target
              , s = i.getRoot(f).curSelectedList
              , n = [];
            if (i.isSelectedNode(f, b))
                for (o = 0,
                j = s.length; o < j; o++) {
                    if (s[o].editNameFlag && k.eqs(r.tagName, "input") && r.getAttribute("treeNode" + d.id.INPUT) !== null)
                        return !0;
                    n.push(s[o]);
                    if (n[0].parentTId !== s[o].parentTId) {
                        n = [b];
                        break
                    }
                }
            else
                n = [b];
            e.editNodeBlur = !0;
            e.cancelCurEditNode(f);
            var G = B(f.treeObj.get(0).ownerDocument), L = B(f.treeObj.get(0).ownerDocument.body), C, u, t, J = !1, h = f, v = f, H, Q, S = null, T = null, w = null, x = d.move.TYPE_INNER, N = a.clientX, O = a.clientY, K = (new Date).getTime();
            k.uCanDo(f) && G.bind("mousemove", c);
            G.bind("mouseup", l);
            G.bind("selectstart", g);
            return !0
        }
    };
    B.extend(!0, B.fn.zTree.consts, I);
    B.extend(!0, B.fn.zTree._z, {
        tools: {
            getAbs: function(a) {
                a = a.getBoundingClientRect();
                return [a.left + (document.body.scrollLeft + document.documentElement.scrollLeft), a.top + (document.body.scrollTop + document.documentElement.scrollTop)]
            },
            inputFocus: function(a) {
                a.get(0) && (a.focus(),
                k.setCursorPosition(a.get(0), a.val().length))
            },
            inputSelect: function(a) {
                a.get(0) && (a.focus(),
                a.select())
            },
            setCursorPosition: function(a, b) {
                if (a.setSelectionRange)
                    a.focus(),
                    a.setSelectionRange(b, b);
                else if (a.createTextRange) {
                    var c = a.createTextRange();
                    c.collapse(!0);
                    c.moveEnd("character", b);
                    c.moveStart("character", b);
                    c.select()
                }
            },
            showIfameMask: function(a, b) {
                for (var c = i.getRoot(a); c.dragMaskList.length > 0; )
                    c.dragMaskList[0].remove(),
                    c.dragMaskList.shift();
                if (b)
                    for (var d = q("iframe", a), g = 0, e = d.length; g < e; g++) {
                        var j = d.get(g)
                          , f = k.getAbs(j)
                          , j = q("<div id='zTreeMask_" + g + "' class='zTreeMask' style='top:" + f[1] + "px; left:" + f[0] + "px; width:" + j.offsetWidth + "px; height:" + j.offsetHeight + "px;'></div>", a);
                        j.appendTo(q("body", a));
                        c.dragMaskList.push(j)
                    }
            }
        },
        view: {
            addEditBtn: function(a, b) {
                if (!(b.editNameFlag || q(b, d.id.EDIT, a).length > 0) && k.apply(a.edit.showRenameBtn, [a.treeId, b], a.edit.showRenameBtn)) {
                    var c = q(b, d.id.A, a)
                      , l = "<span class='" + d.className.BUTTON + " edit' id='" + b.tId + d.id.EDIT + "' title='" + k.apply(a.edit.renameTitle, [a.treeId, b], a.edit.renameTitle) + "' treeNode" + d.id.EDIT + " style='display:none;'></span>";
                    c.append(l);
                    q(b, d.id.EDIT, a).bind("click", function() {
                        if (!k.uCanDo(a) || k.apply(a.callback.beforeEditName, [a.treeId, b], !0) == !1)
                            return !1;
                        e.editNode(a, b);
                        return !1
                    }).show()
                }
            },
            addRemoveBtn: function(a, b) {
                if (!(b.editNameFlag || q(b, d.id.REMOVE, a).length > 0) && k.apply(a.edit.showRemoveBtn, [a.treeId, b], a.edit.showRemoveBtn)) {
                    var c = q(b, d.id.A, a)
                      , l = "<span class='" + d.className.BUTTON + " remove' id='" + b.tId + d.id.REMOVE + "' title='" + k.apply(a.edit.removeTitle, [a.treeId, b], a.edit.removeTitle) + "' treeNode" + d.id.REMOVE + " style='display:none;'></span>";
                    c.append(l);
                    q(b, d.id.REMOVE, a).bind("click", function() {
                        if (!k.uCanDo(a) || k.apply(a.callback.beforeRemove, [a.treeId, b], !0) == !1)
                            return !1;
                        e.removeNode(a, b);
                        a.treeObj.trigger(d.event.REMOVE, [a.treeId, b]);
                        return !1
                    }).bind("mousedown", function() {
                        return !0
                    }).show()
                }
            },
            addHoverDom: function(a, b) {
                if (i.getRoots().showHoverDom)
                    b.isHover = !0,
                    a.edit.enable && (e.addEditBtn(a, b),
                    e.addRemoveBtn(a, b)),
                    k.apply(a.view.addHoverDom, [a.treeId, b])
            },
            cancelCurEditNode: function(a, b, c) {
                var l = i.getRoot(a)
                  , g = l.curEditNode;
                if (g) {
                    var o = l.curEditInput
                      , b = b ? b : c ? i.nodeName(a, g) : o.val();
                    if (k.apply(a.callback.beforeRename, [a.treeId, g, b, c], !0) === !1)
                        return !1;
                    i.nodeName(a, g, b);
                    q(g, d.id.A, a).removeClass(d.node.CURSELECTED_EDIT);
                    o.unbind();
                    e.setNodeName(a, g);
                    g.editNameFlag = !1;
                    l.curEditNode = null;
                    l.curEditInput = null;
                    e.selectNode(a, g, !1);
                    a.treeObj.trigger(d.event.RENAME, [a.treeId, g, c])
                }
                return l.noSelection = !0
            },
            editNode: function(a, b) {
                var c = i.getRoot(a);
                e.editNodeBlur = !1;
                if (i.isSelectedNode(a, b) && c.curEditNode == b && b.editNameFlag)
                    setTimeout(function() {
                        k.inputFocus(c.curEditInput)
                    }, 0);
                else {
                    b.editNameFlag = !0;
                    e.removeTreeDom(a, b);
                    e.cancelCurEditNode(a);
                    e.selectNode(a, b, !1);
                    q(b, d.id.SPAN, a).html("<input type=text class='rename' id='" + b.tId + d.id.INPUT + "' treeNode" + d.id.INPUT + " >");
                    var l = q(b, d.id.INPUT, a);
                    l.attr("value", i.nodeName(a, b));
                    a.edit.editNameSelectAll ? k.inputSelect(l) : k.inputFocus(l);
                    l.bind("blur", function() {
                        e.editNodeBlur || e.cancelCurEditNode(a)
                    }).bind("keydown", function(b) {
                        b.keyCode == "13" ? (e.editNodeBlur = !0,
                        e.cancelCurEditNode(a)) : b.keyCode == "27" && e.cancelCurEditNode(a, null, !0)
                    }).bind("click", function() {
                        return !1
                    }).bind("dblclick", function() {
                        return !1
                    });
                    q(b, d.id.A, a).addClass(d.node.CURSELECTED_EDIT);
                    c.curEditInput = l;
                    c.noSelection = !1;
                    c.curEditNode = b
                }
            },
            moveNode: function(a, b, c, l, g, k) {
                var j = i.getRoot(a);
                if (b != c && (!a.data.keep.leaf || !b || i.nodeIsParent(a, b) || l != d.move.TYPE_INNER)) {
                    var f = c.parentTId ? c.getParentNode() : j
                      , m = b === null || b == j;
                    m && b === null && (b = j);
                    if (m)
                        l = d.move.TYPE_INNER;
                    j = b.parentTId ? b.getParentNode() : j;
                    if (l != d.move.TYPE_PREV && l != d.move.TYPE_NEXT)
                        l = d.move.TYPE_INNER;
                    if (l == d.move.TYPE_INNER)
                        if (m)
                            c.parentTId = null;
                        else {
                            if (!i.nodeIsParent(a, b))
                                i.nodeIsParent(a, b, !0),
                                b.open = !!b.open,
                                e.setNodeLineIcos(a, b);
                            c.parentTId = b.tId
                        }
                    var y;
                    m ? y = m = a.treeObj : (!k && l == d.move.TYPE_INNER ? e.expandCollapseNode(a, b, !0, !1) : k || e.expandCollapseNode(a, b.getParentNode(), !0, !1),
                    m = q(b, a),
                    y = q(b, d.id.UL, a),
                    m.get(0) && !y.get(0) && (y = [],
                    e.makeUlHtml(a, b, y, ""),
                    m.append(y.join(""))),
                    y = q(b, d.id.UL, a));
                    var r = q(c, a);
                    r.get(0) ? m.get(0) || r.remove() : r = e.appendNodes(a, c.level, [c], null, -1, !1, !0).join("");
                    y.get(0) && l == d.move.TYPE_INNER ? y.append(r) : m.get(0) && l == d.move.TYPE_PREV ? m.before(r) : m.get(0) && l == d.move.TYPE_NEXT && m.after(r);
                    var s;
                    y = -1;
                    var r = 0
                      , n = null
                      , m = null
                      , B = c.level
                      , v = i.nodeChildren(a, f)
                      , C = i.nodeChildren(a, j)
                      , u = i.nodeChildren(a, b);
                    if (c.isFirstNode) {
                        if (y = 0,
                        v.length > 1)
                            n = v[1],
                            n.isFirstNode = !0
                    } else if (c.isLastNode)
                        y = v.length - 1,
                        n = v[y - 1],
                        n.isLastNode = !0;
                    else
                        for (j = 0,
                        s = v.length; j < s; j++)
                            if (v[j].tId == c.tId) {
                                y = j;
                                break
                            }
                    y >= 0 && v.splice(y, 1);
                    if (l != d.move.TYPE_INNER)
                        for (j = 0,
                        s = C.length; j < s; j++)
                            C[j].tId == b.tId && (r = j);
                    if (l == d.move.TYPE_INNER) {
                        u || (u = i.nodeChildren(a, b, []));
                        if (u.length > 0)
                            m = u[u.length - 1],
                            m.isLastNode = !1;
                        u.splice(u.length, 0, c);
                        c.isLastNode = !0;
                        c.isFirstNode = u.length == 1
                    } else
                        b.isFirstNode && l == d.move.TYPE_PREV ? (C.splice(r, 0, c),
                        m = b,
                        m.isFirstNode = !1,
                        c.parentTId = b.parentTId,
                        c.isFirstNode = !0,
                        c.isLastNode = !1) : b.isLastNode && l == d.move.TYPE_NEXT ? (C.splice(r + 1, 0, c),
                        m = b,
                        m.isLastNode = !1,
                        c.parentTId = b.parentTId,
                        c.isFirstNode = !1,
                        c.isLastNode = !0) : (l == d.move.TYPE_PREV ? C.splice(r, 0, c) : C.splice(r + 1, 0, c),
                        c.parentTId = b.parentTId,
                        c.isFirstNode = !1,
                        c.isLastNode = !1);
                    i.fixPIdKeyValue(a, c);
                    i.setSonNodeLevel(a, c.getParentNode(), c);
                    e.setNodeLineIcos(a, c);
                    e.repairNodeLevelClass(a, c, B);
                    !a.data.keep.parent && v.length < 1 ? (i.nodeIsParent(a, f, !1),
                    f.open = !1,
                    b = q(f, d.id.UL, a),
                    l = q(f, d.id.SWITCH, a),
                    j = q(f, d.id.ICON, a),
                    e.replaceSwitchClass(f, l, d.folder.DOCU),
                    e.replaceIcoClass(f, j, d.folder.DOCU),
                    b.css("display", "none")) : n && e.setNodeLineIcos(a, n);
                    m && e.setNodeLineIcos(a, m);
                    a.check && a.check.enable && e.repairChkClass && (e.repairChkClass(a, f),
                    e.repairParentChkClassWithSelf(a, f),
                    f != c.parent && e.repairParentChkClassWithSelf(a, c));
                    k || e.expandCollapseParentNode(a, c.getParentNode(), !0, g)
                }
            },
            removeEditBtn: function(a, b) {
                q(b, d.id.EDIT, a).unbind().remove()
            },
            removeRemoveBtn: function(a, b) {
                q(b, d.id.REMOVE, a).unbind().remove()
            },
            removeTreeDom: function(a, b) {
                b.isHover = !1;
                e.removeEditBtn(a, b);
                e.removeRemoveBtn(a, b);
                k.apply(a.view.removeHoverDom, [a.treeId, b])
            },
            repairNodeLevelClass: function(a, b, c) {
                if (c !== b.level) {
                    var e = q(b, a)
                      , g = q(b, d.id.A, a)
                      , a = q(b, d.id.UL, a)
                      , c = d.className.LEVEL + c
                      , b = d.className.LEVEL + b.level;
                    e.removeClass(c);
                    e.addClass(b);
                    g.removeClass(c);
                    g.addClass(b);
                    a.removeClass(c);
                    a.addClass(b)
                }
            },
            selectNodes: function(a, b) {
                for (var c = 0, d = b.length; c < d; c++)
                    e.selectNode(a, b[c], c > 0)
            }
        },
        event: {},
        data: {
            setSonNodeLevel: function(a, b, c) {
                if (c) {
                    var d = i.nodeChildren(a, c);
                    c.level = b ? b.level + 1 : 0;
                    if (d)
                        for (var b = 0, g = d.length; b < g; b++)
                            d[b] && i.setSonNodeLevel(a, c, d[b])
                }
            }
        }
    });
    var H = B.fn.zTree
      , k = H._z.tools
      , d = H.consts
      , e = H._z.view
      , i = H._z.data
      , q = k.$;
    i.exSetting({
        edit: {
            enable: !1,
            editNameSelectAll: !1,
            showRemoveBtn: !0,
            showRenameBtn: !0,
            removeTitle: "remove",
            renameTitle: "rename",
            drag: {
                autoExpandTrigger: !1,
                isCopy: !0,
                isMove: !0,
                prev: !0,
                next: !0,
                inner: !0,
                minMoveSize: 5,
                borderMax: 10,
                borderMin: -5,
                maxShowNodeNum: 5,
                autoOpenTime: 500
            }
        },
        view: {
            addHoverDom: null,
            removeHoverDom: null
        },
        callback: {
            beforeDrag: null,
            beforeDragOpen: null,
            beforeDrop: null,
            beforeEditName: null,
            beforeRename: null,
            onDrag: null,
            onDragMove: null,
            onDrop: null,
            onRename: null
        }
    });
    i.addInitBind(function(a) {
        var b = a.treeObj
          , c = d.event;
        b.bind(c.RENAME, function(b, c, d, e) {
            k.apply(a.callback.onRename, [b, c, d, e])
        });
        b.bind(c.DRAG, function(b, c, d, e) {
            k.apply(a.callback.onDrag, [c, d, e])
        });
        b.bind(c.DRAGMOVE, function(b, c, d, e) {
            k.apply(a.callback.onDragMove, [c, d, e])
        });
        b.bind(c.DROP, function(b, c, d, e, f, i, q) {
            k.apply(a.callback.onDrop, [c, d, e, f, i, q])
        })
    });
    i.addInitUnBind(function(a) {
        var a = a.treeObj
          , b = d.event;
        a.unbind(b.RENAME);
        a.unbind(b.DRAG);
        a.unbind(b.DRAGMOVE);
        a.unbind(b.DROP)
    });
    i.addInitCache(function() {});
    i.addInitNode(function(a, b, c) {
        if (c)
            c.isHover = !1,
            c.editNameFlag = !1
    });
    i.addInitProxy(function(a) {
        var b = a.target
          , c = i.getSetting(a.data.treeId)
          , e = a.relatedTarget
          , g = ""
          , o = null
          , j = ""
          , f = null
          , m = null;
        if (k.eqs(a.type, "mouseover")) {
            if (m = k.getMDom(c, b, [{
                tagName: "a",
                attrName: "treeNode" + d.id.A
            }]))
                g = k.getNodeMainDom(m).id,
                j = "hoverOverNode"
        } else if (k.eqs(a.type, "mouseout"))
            m = k.getMDom(c, e, [{
                tagName: "a",
                attrName: "treeNode" + d.id.A
            }]),
            m || (g = "remove",
            j = "hoverOutNode");
        else if (k.eqs(a.type, "mousedown") && (m = k.getMDom(c, b, [{
            tagName: "a",
            attrName: "treeNode" + d.id.A
        }])))
            g = k.getNodeMainDom(m).id,
            j = "mousedownNode";
        if (g.length > 0)
            switch (o = i.getNodeCache(c, g),
            j) {
            case "mousedownNode":
                f = v.onMousedownNode;
                break;
            case "hoverOverNode":
                f = v.onHoverOverNode;
                break;
            case "hoverOutNode":
                f = v.onHoverOutNode
            }
        return {
            stop: !1,
            node: o,
            nodeEventType: j,
            nodeEventCallback: f,
            treeEventType: "",
            treeEventCallback: null
        }
    });
    i.addInitRoot(function(a) {
        var a = i.getRoot(a)
          , b = i.getRoots();
        a.curEditNode = null;
        a.curEditInput = null;
        a.curHoverNode = null;
        a.dragFlag = 0;
        a.dragNodeShowBefore = [];
        a.dragMaskList = [];
        b.showHoverDom = !0
    });
    i.addZTreeTools(function(a, b) {
        b.cancelEditName = function(a) {
            i.getRoot(this.setting).curEditNode && e.cancelCurEditNode(this.setting, a ? a : null, !0)
        }
        ;
        b.copyNode = function(b, l, g, o) {
            if (!l)
                return null;
            var j = i.nodeIsParent(a, b);
            if (b && !j && this.setting.data.keep.leaf && g === d.move.TYPE_INNER)
                return null;
            var f = this
              , m = k.clone(l);
            if (!b)
                b = null,
                g = d.move.TYPE_INNER;
            g == d.move.TYPE_INNER ? (l = function() {
                e.addNodes(f.setting, b, -1, [m], o)
            }
            ,
            k.canAsync(this.setting, b) ? e.asyncNode(this.setting, b, o, l) : l()) : (e.addNodes(this.setting, b.parentNode, -1, [m], o),
            e.moveNode(this.setting, b, m, g, !1, o));
            return m
        }
        ;
        b.editName = function(a) {
            a && a.tId && a === i.getNodeCache(this.setting, a.tId) && (a.parentTId && e.expandCollapseParentNode(this.setting, a.getParentNode(), !0),
            e.editNode(this.setting, a))
        }
        ;
        b.moveNode = function(b, l, g, o) {
            function j() {
                e.moveNode(m.setting, b, l, g, !1, o)
            }
            if (!l)
                return l;
            var f = i.nodeIsParent(a, b);
            if (b && !f && this.setting.data.keep.leaf && g === d.move.TYPE_INNER)
                return null;
            else if (b && (l.parentTId == b.tId && g == d.move.TYPE_INNER || q(l, this.setting).find("#" + b.tId).length > 0))
                return null;
            else
                b || (b = null);
            var m = this;
            k.canAsync(this.setting, b) && g === d.move.TYPE_INNER ? e.asyncNode(this.setting, b, o, j) : j();
            return l
        }
        ;
        b.setEditable = function(a) {
            this.setting.edit.enable = a;
            return this.refresh()
        }
    });
    var N = e.cancelPreSelectedNode;
    e.cancelPreSelectedNode = function(a, b) {
        for (var c = i.getRoot(a).curSelectedList, d = 0, g = c.length; d < g; d++)
            if (!b || b === c[d])
                if (e.removeTreeDom(a, c[d]),
                b)
                    break;
        N && N.apply(e, arguments)
    }
    ;
    var O = e.createNodes;
    e.createNodes = function(a, b, c, d, g) {
        O && O.apply(e, arguments);
        c && e.repairParentChkClassWithSelf && e.repairParentChkClassWithSelf(a, d)
    }
    ;
    var V = e.makeNodeUrl;
    e.makeNodeUrl = function(a, b) {
        return a.edit.enable ? null : V.apply(e, arguments)
    }
    ;
    var K = e.removeNode;
    e.removeNode = function(a, b) {
        var c = i.getRoot(a);
        if (c.curEditNode === b)
            c.curEditNode = null;
        K && K.apply(e, arguments)
    }
    ;
    var P = e.selectNode;
    e.selectNode = function(a, b, c) {
        var d = i.getRoot(a);
        if (i.isSelectedNode(a, b) && d.curEditNode == b && b.editNameFlag)
            return !1;
        P && P.apply(e, arguments);
        e.addHoverDom(a, b);
        return !0
    }
    ;
    var U = k.uCanDo;
    k.uCanDo = function(a, b) {
        var c = i.getRoot(a);
        if (b && (k.eqs(b.type, "mouseover") || k.eqs(b.type, "mouseout") || k.eqs(b.type, "mousedown") || k.eqs(b.type, "mouseup")))
            return !0;
        if (c.curEditNode)
            e.editNodeBlur = !1,
            c.curEditInput.focus();
        return !c.curEditNode && (U ? U.apply(e, arguments) : !0)
    }
}
)(jQuery);

"function" != typeof Object.create && (Object.create = function(t) {
    function o() {}
    return o.prototype = t,
    new o
}
),
function(t, o) {
    "use strict";
    var i = {
        _positionClasses: ["bottom-left", "bottom-right", "top-right", "top-left", "bottom-center", "top-center", "mid-center"],
        _defaultIcons: ["success", "error", "info", "warning"],
        init: function(o) {
            this.prepareOptions(o, t.toast.options),
            this.process()
        },
        prepareOptions: function(o, i) {
            var s = {};
            "string" == typeof o || o instanceof Array ? s.text = o : s = o,
            this.options = t.extend({}, i, s)
        },
        process: function() {
            this.setup(),
            this.addToDom(),
            this.position(),
            this.bindToast(),
            this.animate()
        },
        setup: function() {
            var o = "";
            if (this._toastEl = this._toastEl || t("<div></div>", {
                "class": "jq-toast-single"
            }),
            o += '<span class="jq-toast-loader"></span>',
            this.options.allowToastClose && (o += '<span class="close-jq-toast-single">&times;</span>'),
            this.options.text instanceof Array) {
                this.options.heading && (o += '<h2 class="jq-toast-heading">' + this.options.heading + "</h2>"),
                o += '<ul class="jq-toast-ul">';
                for (var i = 0; i < this.options.text.length; i++)
                    o += '<li class="jq-toast-li" id="jq-toast-item-' + i + '">' + this.options.text[i] + "</li>";
                o += "</ul>"
            } else
                this.options.heading && (o += '<h2 class="jq-toast-heading">' + this.options.heading + "</h2>"),
                o += this.options.text;
            this._toastEl.html(o),
            this.options.bgColor !== !1 && this._toastEl.css("background-color", this.options.bgColor),
            this.options.textColor !== !1 && this._toastEl.css("color", this.options.textColor),
            this.options.textAlign && this._toastEl.css("text-align", this.options.textAlign),
            this.options.icon !== !1 && (this._toastEl.addClass("jq-has-icon"),
            -1 !== t.inArray(this.options.icon, this._defaultIcons) && this._toastEl.addClass("jq-icon-" + this.options.icon))
        },
        position: function() {
            "string" == typeof this.options.position && -1 !== t.inArray(this.options.position, this._positionClasses) ? "bottom-center" === this.options.position ? this._container.css({
                left: t(o).outerWidth() / 2 - this._container.outerWidth() / 2,
                bottom: 20
            }) : "top-center" === this.options.position ? this._container.css({
                left: t(o).outerWidth() / 2 - this._container.outerWidth() / 2,
                top: 20
            }) : "mid-center" === this.options.position ? this._container.css({
                left: t(o).outerWidth() / 2 - this._container.outerWidth() / 2,
                top: t(o).outerHeight() / 2 - this._container.outerHeight() / 2
            }) : this._container.addClass(this.options.position) : "object" == typeof this.options.position ? this._container.css({
                top: this.options.position.top ? this.options.position.top : "auto",
                bottom: this.options.position.bottom ? this.options.position.bottom : "auto",
                left: this.options.position.left ? this.options.position.left : "auto",
                right: this.options.position.right ? this.options.position.right : "auto"
            }) : this._container.addClass("bottom-left")
        },
        bindToast: function() {
            var t = this;
            this._toastEl.on("afterShown", function() {
                t.processLoader()
            }),
            this._toastEl.find(".close-jq-toast-single").on("click", function(o) {
                o.preventDefault(),
                "fade" === t.options.showHideTransition ? (t._toastEl.trigger("beforeHide"),
                t._toastEl.fadeOut(function() {
                    t._toastEl.trigger("afterHidden")
                })) : "slide" === t.options.showHideTransition ? (t._toastEl.trigger("beforeHide"),
                t._toastEl.slideUp(function() {
                    t._toastEl.trigger("afterHidden")
                })) : (t._toastEl.trigger("beforeHide"),
                t._toastEl.hide(function() {
                    t._toastEl.trigger("afterHidden")
                }))
            }),
            "function" == typeof this.options.beforeShow && this._toastEl.on("beforeShow", function() {
                t.options.beforeShow()
            }),
            "function" == typeof this.options.afterShown && this._toastEl.on("afterShown", function() {
                t.options.afterShown()
            }),
            "function" == typeof this.options.beforeHide && this._toastEl.on("beforeHide", function() {
                t.options.beforeHide()
            }),
            "function" == typeof this.options.afterHidden && this._toastEl.on("afterHidden", function() {
                t.options.afterHidden()
            })
        },
        addToDom: function() {
            var o = t(".jq-toast-wrap");
            if (0 === o.length ? (o = t("<div></div>", {
                "class": "jq-toast-wrap"
            }),
            t("body").append(o)) : (!this.options.stack || isNaN(parseInt(this.options.stack, 10))) && o.empty(),
            o.find(".jq-toast-single:hidden").remove(),
            o.append(this._toastEl),
            this.options.stack && !isNaN(parseInt(this.options.stack), 10)) {
                var i = o.find(".jq-toast-single").length
                  , s = i - this.options.stack;
                s > 0 && t(".jq-toast-wrap").find(".jq-toast-single").slice(0, s).remove()
            }
            this._container = o
        },
        canAutoHide: function() {
            return this.options.hideAfter !== !1 && !isNaN(parseInt(this.options.hideAfter, 10))
        },
        processLoader: function() {
            if (!this.canAutoHide() || this.options.loader === !1)
                return !1;
            var t = this._toastEl.find(".jq-toast-loader")
              , o = (this.options.hideAfter - 400) / 1e3 + "s"
              , i = this.options.loaderBg
              , s = t.attr("style") || "";
            s = s.substring(0, s.indexOf("-webkit-transition")),
            s += "-webkit-transition: width " + o + " ease-in;                       -o-transition: width " + o + " ease-in;                       transition: width " + o + " ease-in;                       background-color: " + i + ";",
            t.attr("style", s).addClass("jq-toast-loaded")
        },
        animate: function() {
            var t = this;
            if (this._toastEl.hide(),
            this._toastEl.trigger("beforeShow"),
            "fade" === this.options.showHideTransition.toLowerCase() ? this._toastEl.fadeIn(function() {
                t._toastEl.trigger("afterShown")
            }) : "slide" === this.options.showHideTransition.toLowerCase() ? this._toastEl.slideDown(function() {
                t._toastEl.trigger("afterShown")
            }) : this._toastEl.show(function() {
                t._toastEl.trigger("afterShown")
            }),
            this.canAutoHide()) {
                var t = this;
                o.setTimeout(function() {
                    "fade" === t.options.showHideTransition.toLowerCase() ? (t._toastEl.trigger("beforeHide"),
                    t._toastEl.fadeOut(function() {
                        t._toastEl.trigger("afterHidden")
                    })) : "slide" === t.options.showHideTransition.toLowerCase() ? (t._toastEl.trigger("beforeHide"),
                    t._toastEl.slideUp(function() {
                        t._toastEl.trigger("afterHidden")
                    })) : (t._toastEl.trigger("beforeHide"),
                    t._toastEl.hide(function() {
                        t._toastEl.trigger("afterHidden")
                    }))
                }, this.options.hideAfter)
            }
        },
        reset: function(o) {
            "all" === o ? t(".jq-toast-wrap").remove() : this._toastEl.remove()
        },
        update: function(t) {
            this.prepareOptions(t, this.options),
            this.setup(),
            this.bindToast()
        }
    };
    t.toast = function(t) {
        var o = Object.create(i);
        return o.init(t, this),
        {
            reset: function(t) {
                o.reset(t)
            },
            update: function(t) {
                o.update(t)
            }
        }
    }
    ,
    t.toast.options = {
        text: "",
        heading: "",
        showHideTransition: "fade",
        allowToastClose: !0,
        hideAfter: 3e3,
        loader: !0,
        loaderBg: "#9EC600",
        stack: 5,
        position: "bottom-left",
        bgColor: !1,
        textColor: !1,
        textAlign: "left",
        icon: !1,
        beforeShow: function() {},
        afterShown: function() {},
        beforeHide: function() {},
        afterHidden: function() {}
    }
}(jQuery, window, document);

/**
 * 获取序列号
 * @param model
 * @param callback
 */
function getSerial(model,callback){
	ext.ajax.get("serial/"+model,function(data){
		callback(data);
	});
};

/**
 * 获取指定日期的序列号
 * @param model
 * @param date
 * @param callback
 */
function getSerialByDate(model,date,callback){
	ext.ajax.get("serial/"+model+"/"+date,function(data){
		callback(data);
	});
};

/*!
 * jquery.base64.js 0.1 - https://github.com/yckart/jquery.base64.js
 * Makes Base64 en & -decoding simpler as it is.
 *
 * Based upon: https://gist.github.com/Yaffle/1284012
 *
 * Copyright (c) 2012 Yannick Albert (http://yckart.com)
 * Licensed under the MIT license (http://www.opensource.org/licenses/mit-license.php).
 * 2013/02/10
 **/
;(function($) {

    var b64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/",
        a256 = '',
        r64 = [256],
        r256 = [256],
        i = 0;

    var UTF8 = {

        /**
         * Encode multi-byte Unicode string into utf-8 multiple single-byte characters
         * (BMP / basic multilingual plane only)
         *
         * Chars in range U+0080 - U+07FF are encoded in 2 chars, U+0800 - U+FFFF in 3 chars
         *
         * @param {String} strUni Unicode string to be encoded as UTF-8
         * @returns {String} encoded string
         */
        encode: function(strUni) {
            // use regular expressions & String.replace callback function for better efficiency
            // than procedural approaches
            var strUtf = strUni.replace(/[\u0080-\u07ff]/g, // U+0080 - U+07FF => 2 bytes 110yyyyy, 10zzzzzz
            function(c) {
                var cc = c.charCodeAt(0);
                return String.fromCharCode(0xc0 | cc >> 6, 0x80 | cc & 0x3f);
            })
            .replace(/[\u0800-\uffff]/g, // U+0800 - U+FFFF => 3 bytes 1110xxxx, 10yyyyyy, 10zzzzzz
            function(c) {
                var cc = c.charCodeAt(0);
                return String.fromCharCode(0xe0 | cc >> 12, 0x80 | cc >> 6 & 0x3F, 0x80 | cc & 0x3f);
            });
            return strUtf;
        },

        /**
         * Decode utf-8 encoded string back into multi-byte Unicode characters
         *
         * @param {String} strUtf UTF-8 string to be decoded back to Unicode
         * @returns {String} decoded string
         */
        decode: function(strUtf) {
            // note: decode 3-byte chars first as decoded 2-byte strings could appear to be 3-byte char!
            var strUni = strUtf.replace(/[\u00e0-\u00ef][\u0080-\u00bf][\u0080-\u00bf]/g, // 3-byte chars
            function(c) { // (note parentheses for precence)
                var cc = ((c.charCodeAt(0) & 0x0f) << 12) | ((c.charCodeAt(1) & 0x3f) << 6) | (c.charCodeAt(2) & 0x3f);
                return String.fromCharCode(cc);
            })
            .replace(/[\u00c0-\u00df][\u0080-\u00bf]/g, // 2-byte chars
            function(c) { // (note parentheses for precence)
                var cc = (c.charCodeAt(0) & 0x1f) << 6 | c.charCodeAt(1) & 0x3f;
                return String.fromCharCode(cc);
            });
            return strUni;
        }
    };

    while(i < 256) {
        var c = String.fromCharCode(i);
        a256 += c;
        r256[i] = i;
        r64[i] = b64.indexOf(c);
        ++i;
    }

    function code(s, discard, alpha, beta, w1, w2) {
        s = String(s);
        var buffer = 0,
            i = 0,
            length = s.length,
            result = '',
            bitsInBuffer = 0;

        while(i < length) {
            var c = s.charCodeAt(i);
            c = c < 256 ? alpha[c] : -1;

            buffer = (buffer << w1) + c;
            bitsInBuffer += w1;

            while(bitsInBuffer >= w2) {
                bitsInBuffer -= w2;
                var tmp = buffer >> bitsInBuffer;
                result += beta.charAt(tmp);
                buffer ^= tmp << bitsInBuffer;
            }
            ++i;
        }
        if(!discard && bitsInBuffer > 0) result += beta.charAt(buffer << (w2 - bitsInBuffer));
        return result;
    }

    var Plugin = $.base64 = function(dir, input, encode) {
            return input ? Plugin[dir](input, encode) : dir ? null : this;
        };

    Plugin.btoa = Plugin.encode = function(plain, utf8encode) {
        plain = Plugin.raw === false || Plugin.utf8encode || utf8encode ? UTF8.encode(plain) : plain;
        plain = code(plain, false, r256, b64, 8, 6);
        return plain + '===='.slice((plain.length % 4) || 4);
    };

    Plugin.atob = Plugin.decode = function(coded, utf8decode) {
        coded = String(coded).split('=');
        var i = coded.length;
        do {--i;
            coded[i] = code(coded[i], true, r64, a256, 6, 8);
        } while (i > 0);
        coded = coded.join('');
        return Plugin.raw === false || Plugin.utf8decode || utf8decode ? UTF8.decode(coded) : coded;
    };
}(jQuery));