webpackJsonp([4],{174:function(t,n,e){"use strict";e.d(n,"a",function(){return v});var o=e(205),i=e.n(o),a=e(79),r=e.n(a),u=e(452),c=e(448),s=e.n(c),l=e(183),d=e.n(l),p=e(455),f=e.n(p);r.a.use(u.a),r.a.use(s.a);var v=new u.a.Store({state:{initData:null,totalEmployee:0,workingUnitSelect:null,loading:!1,index:0},actions:{loadInitResource:function(t){var n=t.commit,e=t.state;return null==e.initData?new i.a(function(t,e){var o={},i=window.location.href,a=window.location.href.lastIndexOf("#/");a>0&&(i=window.location.href.substr(0,a)),d.a.get(i+f.a.renderURLInit,o).then(function(e){var o=e.data;n("setInitData",o),t(o)}).catch(function(t){console.log(t),e(t)})}):new i.a(function(t,n){t(e.initData)})},getWorkingUnit:function(t,n){var e=(t.commit,t.state);return new i.a(function(t,n){v.dispatch("loadInitResource").then(function(o){var i={headers:{groupId:e.initData.groupId,Accept:"application/json"},params:{}};d.a.get("/o/rest/v2/workingunits",i).then(function(n){var e=n.data;if(e.data){var o=e.data;t(o)}else t([])}).catch(function(t){n(t)})})})},getEmployee:function(t,n){var e=t.commit,o=t.state;return new i.a(function(t,i){v.dispatch("loadInitResource").then(function(a){var r=void 0;r="all"===n.workingunit?{start:n.start,end:n.end}:{workingunit:n.workingunit,start:n.start,end:n.end};var u={headers:{groupId:o.initData.groupId,Accept:"application/json"},params:r};d.a.get("/o/rest/v2/employees",u).then(function(n){var o=n.data;if(e("setTotalEmployee",o.total),o.data){var i=o.data;for(var a in i)i[a].totalEvaluation=0,i[a].veryGoodCount=0,i[a].perVeryGood=0,i[a].goodCount=0,i[a].perGood=0,i[a].badCount=0,i[a].perBad=0;t(i)}else e("setTotalEmployee",0),t([])}).catch(function(t){e("setTotalEmployee",0),i(t)})})})},getEvaluationEmployee:function(t,n){var e=(t.commit,t.state);return new i.a(function(t,o){v.dispatch("loadInitResource").then(function(i){var a={headers:{groupId:e.initData.groupId}};d.a.get("/o/rest/v2/pk5/evaluation/"+n.employeeId,a).then(function(n){var e=n.data;if(e.data){var o=e.data;t(o)}else t({})}).catch(function(t){o(t)})})})},postEvaluationEmployee:function(t,n){var e=(t.commit,t.state);return new i.a(function(t,o){var i={headers:{groupId:e.initData.groupId}},a=new URLSearchParams;a.append("evaluationName",n.evaluationName?n.evaluationName:""),a.append("score",n.score?n.score:""),d.a.post("/o/rest/v2/pk5/evaluation/"+n.employeeId,a,i).then(function(n){t(n.data)}).catch(function(t){o(t),s.a.error("Yêu cầu của bạn thực hiện thất bại.")})})}},mutations:{setIndex:function(t,n){t.index=n},setInitData:function(t,n){t.initData=n},setTotalEmployee:function(t,n){t.totalEmployee=n},setWorkingUnitSelect:function(t,n){t.workingUnitSelect=n}},getters:{loading:function(t){return t.loading},index:function(t){return t.index},getTotalEmployee:function(t){return t.totalEmployee},getWorkingUnitSelect:function(t){return t.workingUnitSelect}}})},176:function(t,n){},177:function(t,n){},178:function(t,n){},180:function(t,n,e){var o=e(182)(e(202),e(449),null,null);o.options.__file="d:\\FDS_OPENCPS\\front-end-v2.1\\frontend-opencps-v2.1\\onegate_21_evaluation\\src\\App.vue",o.esModule&&Object.keys(o.esModule).some(function(t){return"default"!==t&&"__esModule"!==t})&&console.error("named exports are not supported in *.vue files."),o.options.functional&&console.error("[vue-loader] App.vue: functional components are not supported with templates, they should use render functions."),t.exports=o.exports},201:function(t,n,e){"use strict";Object.defineProperty(n,"__esModule",{value:!0});var o=e(177),i=(e.n(o),e(176)),a=(e.n(i),e(178)),r=(e.n(a),e(79)),u=e.n(r),c=e(180),s=e.n(c),l=e(81),d=e(181),p=e.n(d),f=e(174),v=e(179),g=e(175);e.n(g);u.a.use(v.default),u.a.use(p.a),u.a.config.productionTip=!0,new u.a({el:"#app",router:l.a,store:f.a,render:function(t){return t(s.a)}})},202:function(t,n,e){"use strict";Object.defineProperty(n,"__esModule",{value:!0});var o=e(81);n.default={data:function(){return{workingUnitList:[],currentIndex:0,loading:!0}},created:function(){var t=this;t.$nextTick(function(){t.$store.dispatch("getWorkingUnit").then(function(n){t.loading=!1,n&&n.length>0&&(t.workingUnitList=n)}).catch(function(n){t.loading=!1,t.workingUnitList=[]}),t.currentIndex="all",o.a.push({path:"/"+t.currentIndex})})},watch:{$route:function(t,n){var e=this,o=t.params;t.query;o.index&&(e.currentIndex=o.index);var i=e.workingUnitList.filter(function(t){return t.workingUnitId.toString()===e.currentIndex.toString()});i&&i.length>0?this.$store.commit("setWorkingUnitSelect",i[0]):this.$store.commit("setWorkingUnitSelect",null)}},methods:{fiterWorkingUnit:function(t){this.currentIndex=t.workingUnitId,o.a.push({path:"/"+t.workingUnitId,query:{q:t.queryParamsqueryParams}})}}}},443:function(t,n){},449:function(t,n,e){t.exports={render:function(){var t=this,n=t.$createElement,e=t._self._c||n;return e("v-app",[e("v-navigation-drawer",{attrs:{app:"",clipped:"",floating:"",width:"240"}},[e("div",{staticClass:"row-header my-0 mb-2"},[e("div",{staticClass:"row-blue"},[t._v(" CƠ QUAN CHUYÊN MÔN ")])]),t._v(" "),t.loading?e("content-placeholders",{staticClass:"mt-3"},[e("content-placeholders-text",{attrs:{lines:7}})],1):e("v-list",{staticClass:"py-0 nav_trang_thai_ho_so overflowComment wrap_working",staticStyle:{"max-height":"500px",overflow:"auto"}},t._l(t.workingUnitList,function(n){return e("v-list-tile",{key:n.workingUnitId,class:n.workingUnitId.toString()===t.currentIndex.toString()?"list_item_active":"",on:{click:function(e){t.fiterWorkingUnit(n)}}},[e("v-list-tile-action",[e("v-icon",{attrs:{size:"18",color:"primary"}},[t._v("account_balance")])],1),t._v(" "),e("v-list-tile-content",[e("v-tooltip",{attrs:{top:""}},[e("v-list-tile-title",{attrs:{slot:"activator"},domProps:{textContent:t._s(n.name)},slot:"activator"}),t._v(" "),e("span",[t._v(t._s(n.name))])],1)],1)],1)}))],1),t._v(" "),e("v-content",[e("router-view")],1)],1)},staticRenderFns:[]},t.exports.render._withStripped=!0},454:function(t,n,e){function o(t){var n=i[t];return n?e.e(n[1]).then(function(){return e(n[0])}):Promise.reject(new Error("Cannot find module '"+t+"'."))}var i={"./Landing.vue":[457,0],"./NotFound.vue":[458,2],"./pagination.vue":[456,1]};o.keys=function(){return Object.keys(i)},t.exports=o,o.id=454},455:function(t,n){t.exports={renderURLInit:"?p_p_id=FrontendWebEvaluation&p_p_lifecycle=2&p_p_state=exclusive&p_p_mode=view&p_p_resource_id=renderURLInit"}},81:function(t,n,e){"use strict";var o=e(206),i=e.n(o),a=e(79),r=e.n(a),u=e(450),c=[{path:"/:index",component:"Landing",props:!0},{path:"*",component:"NotFound"}],s=c.map(function(t){return i()({},t,{component:function(){return e(454)("./"+t.component+".vue")}})});r.a.use(u.a);var l=new u.a({routes:s});n.a=l}},[201]);
//# sourceMappingURL=app.72a2218c32cc45517541.js.map