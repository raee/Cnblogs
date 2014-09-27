package com.rae.cnblogs.sdk.model;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.content.Context;

/**
 * 博客接口地址参数说明：
 * 
 * @index 获取当前页的索引
 * @size 获取分页个数
 * 
 * @author admin
 * 
 */
public final class Constant {
	public static final String OTHER_BLOGS_HOME = "http://cnblogs.davismy.com/Handler.ashx?op=GetTimeLine&page={page}&since_id={sinceId}&max_id={maxId}&channelpath={cateId}&t={date}";

	/**
	 * 获取首页文章列表
	 * 
	 * @index
	 * @size
	 */
	public static final String CNBLOGS_RECENT = "http://wcf.open.cnblogs.com/blog/sitehome/recent/{size}";

	/**
	 * 分页获取首页文章列表
	 * 
	 * @index
	 * @size
	 */
	public static final String CNBLOGS_PAGE = "http://wcf.open.cnblogs.com/blog/sitehome/paged/{index}/{size}";

	/**
	 * 获取文章内容
	 * 
	 * @id
	 */
	public static final String CNBLOGS_CONTENT = "http://wcf.open.cnblogs.com/blog/post/body/{id}";

	/**
	 * 48小时阅读排行
	 * 
	 * @size
	 */
	public static final String CNBLOGS_HOUR_READING = "http://wcf.open.cnblogs.com/blog/48HoursTopViewPosts/{size}";

	/**
	 * 分页获取推荐博客列表
	 * 
	 * @index
	 * @size
	 */
	public static final String CNBLOGS_RECOMMENT_PAGE = "http://wcf.open.cnblogs.com/blog/bloggers/recommend/{index}/{size}";

	/**
	 * 根据作者名搜索博主
	 * 
	 * @name
	 */
	public static final String CNBLOGS_SEARCH_USER = "http://wcf.open.cnblogs.com/blog/bloggers/search?t={name}";

	/**
	 * 分页获取文章评论
	 * 
	 * @id 博客ID
	 * @index
	 * @size
	 */
	public static final String CNBLOGS_COMMENETS_PAGE = "http://wcf.open.cnblogs.com/blog/post/{id}/comments/{index}/{size}";

	/**
	 * 10天内推荐排行
	 * 
	 * @size
	 */
	public static final String CNBLOGS_DAY_READING = "http://wcf.open.cnblogs.com/blog/TenDaysTopDiggPosts/{size}";

	/**
	 * 分页获取个人博客文章列表
	 * 
	 * @blogapp
	 * @index
	 * @size
	 */
	public static final String CNBLOGS_HOUR_STRING = "http://wcf.open.cnblogs.com/blog/u/{blogapp}/posts/{index}/{size}";

	/**
	 * 初始化数据库语句
	 * 
	 * @return
	 */
	public static final String getInitSql(Context context) {
		String result = "";
		try {
			InputStream stream = context.getAssets().open("init.sql");
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			int len = 0;
			byte[] buffer = new byte[512];
			while ((len = stream.read(buffer)) > 0) {
				out.write(buffer, 0, len);
			}
			result = out.toString();
			out.close();
			stream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
		// return
		// "create table categroys(cateid VARCHAR(255)not null,cate_name VARCHAR(36)not null,is_show INT not null default 1,cate_order INT not null default 0,primary key(cateid,cate_name,is_show,cate_order));create table blogs(blogid VARCHAR(255)not null,cateid VARCHAR(255),title VARCHAR(120)not null,summary VARCHAR(300)not null,body TEXT not null,author VARCHAR(36)not null,viewcout INTEGER not null,commentcount INTEGER not null,postdate VARCHAR(36)not null,isreaded INTEGER not null default 0,primary key(blogid,title,summary,body,author,viewcout,commentcount,postdate,isreaded),foreign key(cateid)references categroys(cateid));create table options(dicid INTEGER not null,codename VARCHAR(36)not null,dic_key VARCHAR(36)not null,value_a VARCHAR(2048),value_b VARCHAR(2048),value_c VARCHAR(2048),primary key(dicid,codename,dic_key));insert into categroys(cate_name,cateid)values('NET技术','108698');insert into categroys(cate_name,cateid)values('NET新手区','beginner');insert into categroys(cate_name,cateid)values('ASP.NET','aspnet');insert into categroys(cate_name,cateid)values('C#','csharp');insert into categroys(cate_name,cateid)values('WinForm','winform');insert into categroys(cate_name,cateid)values('Silverlight','silverlight');insert into categroys(cate_name,cateid)values('WCF','wcf');insert into categroys(cate_name,cateid)values('WPF','wpf');insert into categroys(cate_name,cateid)values('ASP.NET MVC','mvc');insert into categroys(cate_name,cateid)values('控件开发','control');insert into categroys(cate_name,cateid)values('Entity Framework','ef');insert into categroys(cate_name,cateid)values('WinRT & Metro','winrt_metro');insert into categroys(cate_name,cateid)values('编程语言','cate12');insert into categroys(cate_name,cateid)values('Java','java');insert into categroys(cate_name,cateid)values('C++','cpp');insert into categroys(cate_name,cateid)values('PHP','php');insert into categroys(cate_name,cateid)values('Python','python');insert into categroys(cate_name,cateid)values('C','c');insert into categroys(cate_name,cateid)values('delphi','delphi');insert into categroys(cate_name,cateid)values('ruby','ruby');insert into categroys(cate_name,cateid)values('erlang','erlang');insert into categroys(cate_name,cateid)values('go','go');insert into categroys(cate_name,cateid)values('verilog','verilog');insert into categroys(cate_name,cateid)values('软件设计','108701');insert into categroys(cate_name,cateid)values('架构设计','design');insert into categroys(cate_name,cateid)values('面向对象','108702');insert into categroys(cate_name,cateid)values('Web前端','108703');insert into categroys(cate_name,cateid)values('Html/Css','web');insert into categroys(cate_name,cateid)values('JavaScript','javascript');insert into categroys(cate_name,cateid)values('JQuery','jquery');insert into categroys(cate_name,cateid)values('HTML5','html5');insert into categroys(cate_name,cateid)values('手机开发','108705');insert into categroys(cate_name,cateid)values('Android开发','android');insert into categroys(cate_name,cateid)values('IOS开发','ios');insert into categroys(cate_name,cateid)values('Windows Phone','wp');insert into categroys(cate_name,cateid)values('Windows Mobile','wm');insert into categroys(cate_name,cateid)values('软件工程','108709');insert into categroys(cate_name,cateid)values('敏捷开发','agile');insert into categroys(cate_name,cateid)values('项目与团队管理','pm');insert into categroys(cate_name,cateid)values('软件工程其他','pm');insert into categroys(cate_name,cateid)values('数据库技术','108712');insert into categroys(cate_name,cateid)values('SqlServer','sqlserver');insert into categroys(cate_name,cateid)values('Oracle','oracle');insert into categroys(cate_name,cateid)values('MySQL','mysql');insert into categroys(cate_name,cateid)values('NoSQL','nosql');insert into categroys(cate_name,cateid)values('其他数据库','database');";
	}
}
