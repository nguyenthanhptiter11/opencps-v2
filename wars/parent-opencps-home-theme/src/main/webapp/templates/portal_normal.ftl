<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<title>Hệ thống Dịch vụ công trực tuyến</title>

	<meta content="initial-scale=1.0, width=device-width" name="viewport" />
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	
	<link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700,900&amp;subset=vietnamese" rel="stylesheet">

	<@liferay_util["include"] page=top_head_include />
	
	<!-- Mainly scripts -->
	<script>
        window.__define = window.define;
        window.__require = window.require;
        window.define = undefined;
        window.require = undefined;
    </script>
	 
	<script src="${themeDisplay.getPathThemeRoot()}/js/jquery.min.js"></script>
	<script src="${themeDisplay.getPathThemeRoot()}/js/bootstrap.min.js"></script>
	<script src="${themeDisplay.getPathThemeRoot()}/js/slick.min.js"></script>
	<script src="${themeDisplay.getPathThemeRoot()}/js/custom.js"></script>
	<script src="${themeDisplay.getPathThemeRoot()}/js/kendo.ui.core.min.js"></script>
	<script src="${themeDisplay.getPathThemeRoot()}/js/kendo.messages.en-US.min.js"></script>
	<script src="${themeDisplay.getPathThemeRoot()}/js/kendo.culture.vi-VN.js"></script>
	
	<script>
        window.define = window.__define;
        window.require = window.__require;
        window.__define = undefined;
        window.__require = undefined;
    </script>
</head>

<body class="${css_class} OpenCPS mBody page-theme">

<@liferay_ui["quick-access"] contentId="#main-content" />
<@liferay_util["include"] page=body_top_include />

<#if permissionChecker.isOmniadmin()>
  	<@liferay.control_menu />
<#else>
  	<style>
	    html .has-control-menu #wrapper {
	        margin-top: 0 !important;
	    }
	    html body.open #wrapper {
	      padding-left: 0 !important;
	    }
  	</style>
</#if>

<div class="mWrapper">
	<header id="banner">		
		<div class="container align-middle hide-title">
			<div class="logo align-middle">
				<a href="${site_default_url}">
					<img src="${themeDisplay.getPathThemeRoot()}/images/logo.png">
					<div class="text-logo">
						Cổng dịch vụ công trực tuyến
						<span>${site_name}</span>
					</div>
				</a>
			</div>
			<@liferay_portlet["runtime"]
              defaultPreferences="${freeMarkerPortletPreferences}"
              portletProviderAction=portletProviderAction.VIEW
              instanceId="FrontendWebPortal_LoginPortlet_1"
              portletName="FrontendWebPortal_LoginPortlet"/>
		</div>
		
		<#if has_navigation && is_setup_complete>
			<#include "${full_templates_path}/navigation.ftl" />
		</#if>
	</header>

	<section id="main-content">
		<div class="container-fluid">
			<#if selectable>
				<@liferay_util["include"] page=content_include />
			<#else>
				${portletDisplay.recycle()}

				${portletDisplay.setTitle(the_title)}

				<@liferay_theme["wrap-portlet"] page="portlet.ftl">
					<@liferay_util["include"] page=content_include />
				</@>
			</#if>
		</div>
	</section>

	<footer id="footer">
		<div class="container align-middle-lg">
			<div>
				<div class="site-name">Cổng dịch vụ công trực tuyến <span>Ủy ban nhân dân Tỉnh Phú Thọ</span> </div>
			</div>
			<div class="contact">
				<p>Địa chỉ: <b>Đường Nguyễn Tất Thành, phường Tân Dân, thành phố Việt Trì, tỉnh Phú Thọ</b></p>
				<p>Điện thoại: <b>0210.3811486</b> | Fax: <b>0210.3811485</b></p>
				<p>Email: <b>sotttt@phutho.gov.vn</b></p>
			</div>
		</div>
	</footer>
</div>

<@liferay_util["include"] page=body_bottom_include />

<@liferay_util["include"] page=bottom_include />
</body>

</html>
