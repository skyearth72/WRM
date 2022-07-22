package com.inswave.config;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.util.UrlPathHelper;

import com.google.gson.GsonBuilder;
import com.inswave.wrm.interceptor.SessionCheckInterceptor;

//@Configuration
//@ComponentScan(basePackages = {
//		"com.inswave" }, includeFilters = @ComponentScan.Filter({ Controller.class }), useDefaultFilters = false)
public class WebMvcConfiguration extends WebMvcConfigurationSupport {
	
//    @Bean
//    public ServletRegistrationBean getServletRegistrationBean()
//    {
//        ServletRegistrationBean websquareDispatcher = new ServletRegistrationBean(new websquare.http.DefaultRequestDispatcher());
//        websquareDispatcher.addUrlMappings("*.wq");
//        return websquareDispatcher;
//    }
//    
////    @Override
////    public void addCorsMappings(CorsRegistry registry) {
////        registry.addMapping("/**");
////    }
//
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
////		registry.addInterceptor(new SessionCheckInterceptor())
////				.addPathPatterns("/**")
//////				.excludePathPatterns("/favicon.ico")
//////				.excludePathPatterns("/websquare/**")
//////				.excludePathPatterns("/cm/**")
////				.excludePathPatterns("/message/getLanguagePack/**");
////				//.excludePathPatterns("/**/*.jsp");
//	}
//
//	@Override
//	public void configurePathMatch(PathMatchConfigurer configurer) {
//		UrlPathHelper urlPathHelper = new UrlPathHelper();
//		urlPathHelper.setRemoveSemicolonContent(false);
//		configurer.setUrlPathHelper(urlPathHelper);
//	}

	@Bean
	public MessageSourceAccessor messageSourceAccessor(@Autowired MessageSource messageSource) {
		return new MessageSourceAccessor(messageSource, Locale.KOREA);
	}

	/**
	 * ApplicationContext 설정
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) {
		super.setApplicationContext(applicationContext);
	}

	
//	@Bean
//	public RequestMappingHandlerMapping requestMappingHandlerMapping() {
//		RequestMappingHandlerMapping requestMappingHandlerMapping = super.createRequestMappingHandlerMapping();
//		requestMappingHandlerMapping.setOrder(0);
//		return requestMappingHandlerMapping;
//	}
	
//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		
//		registry
//		.addResourceHandler("/**")
//		.addResourceLocations("classpath:/static")
//		.setCachePeriod(0);
//	}
	
	
//	@Override
//	protected void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
//		configurer
//		.favorParameter(true)
//		.parameterName("mediaType")
//		.ignoreAcceptHeader(false)
//		.useRegisteredExtensionsOnly(false)
//		.defaultContentType(MediaType.APPLICATION_JSON)
//		.mediaType("html"	, MediaType.TEXT_HTML		)
//		.mediaType("xml"	, MediaType.APPLICATION_XML	)
//		.mediaType("json"	, MediaType.APPLICATION_JSON)
//		;
//	}
//	
//	@Bean
//	public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager, ApplicationContext applicationContext) {
//		List<ViewResolver> resolvers = new ArrayList<ViewResolver>();
//		
//		BeanNameViewResolver beanNameViewResolver = new BeanNameViewResolver();
//		beanNameViewResolver.setOrder(2);
//		resolvers.add(beanNameViewResolver);
//		
//		InternalResourceViewResolver irvr = new InternalResourceViewResolver();
//		irvr.setPrefix("/WEB-INF/jsp/");
//		irvr.setSuffix(".jsp");
//		irvr.setOrder(3);
//		
//		resolvers.add(irvr);
//
//
//		ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
//		resolver.setViewResolvers(resolvers);
//		resolver.setContentNegotiationManager(manager);
//
//		return resolver;
//	}
//	
//	/**
//	 * HTTP Request/Response Message converter 설정
//	 */
//	@Override
//	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//		//converters.add(gsonConverter());
//		
//		converters.add(jacksonConverter());
//		
//		super.configureMessageConverters(converters);
//	}
//	
//	public MappingJackson2HttpMessageConverter jacksonConverter() {
//		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
//		List<MediaType> supportedMediaTypes = new ArrayList();
//		supportedMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
//		
//		converter.setSupportedMediaTypes(supportedMediaTypes);
//		
//		return converter;
//	}
//
//	/**
//	 * google gson 을 converter 로 등록
//	 * 
//	 * @return
//	 */
//	@Bean
//	public GsonHttpMessageConverter gsonConverter() {
//
//		GsonHttpMessageConverter gsonHttpMessageConverter = new GsonHttpMessageConverter();
//
//		List<MediaType> supportedMediaTypes = new ArrayList<MediaType>();
//		supportedMediaTypes.add(MediaType.APPLICATION_JSON);
//
//		gsonHttpMessageConverter.setSupportedMediaTypes(supportedMediaTypes);
//		gsonHttpMessageConverter.setDefaultCharset(StandardCharsets.UTF_8);
//
//		GsonBuilder builder = new GsonBuilder();
//		gsonHttpMessageConverter.setGson(builder.serializeNulls().create());
//
//		return gsonHttpMessageConverter;
//	}
	
//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		registry
//				.addResourceHandler("/cm/**")
//				.addResourceLocations("classpath:/static/cm")
//				.setCachePeriod(0);
//	}
}
