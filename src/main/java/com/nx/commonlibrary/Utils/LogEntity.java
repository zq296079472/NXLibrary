package com.nx.commonlibrary.Utils;

/**
 * Log日志相关的实体类
 * @author  wanghexin@uzoo.cn
 * @date:  2016年5月4日 下午6:26:11
 */
public class LogEntity {
	/**
	 * 当前日志的级别
	 */
	LogLevel level;
	/**
	 * 当前日志信息
	 */
	String msg;
	/**
	 * 当前日志标签
	 */
	String tag;
	/**
	 * 当前日志所在方法
	 */
	String method;

	/**
	 * 构造方法
	 *
	 * @param level
	 *            日志级别
	 * @param tag
	 *            日志标签
	 * @param method
	 *            所处于的函数名称
	 * @param msg
	 *            日志信息
	 */
	public LogEntity(LogLevel level, String tag, String method, String msg) {
		this.tag = tag;
		this.msg = msg;
		this.level = level;
		this.method = method;
	}

	/**
	 *
	 * @return 日志级别
	 */
	public LogLevel getLevel() {
		return level;
	}

	/**
	 * 设置日志级别
	 *
	 * @param level
	 *            日志级别
	 */
	public void setLevel(LogLevel level) {
		this.level = level;
	}

	/**
	 * @return 日志消息
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg
	 *            设置日志消息
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * @return 获取当前日志标签
	 */
	public String getTAG() {
		return tag;
	}

	/**
	 * @param tag
	 *            设置日志标签
	 */
	public void setTAG(String tag) {
		this.tag = tag;
	}

	/**
	 * @return 获取所在方法
	 */
	public String getMethod() {
		return method;
	}

	/**
	 * @param method
	 *            设置当前方法
	 */
	public void setMethod(String method) {
		this.method = method;
	}
}
