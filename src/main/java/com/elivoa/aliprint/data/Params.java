package com.elivoa.aliprint.data;

import java.util.Map;

import com.alibaba.openapi.client.Request;
import com.google.common.collect.Maps;

public class Params {

	private Map<String, Object> params;

	public static Params create() {
		return new Params();
	}

	public static Params create(String key, Object value) {
		return new Params(key, value);
	}

	public Params() {
		this.params = Maps.newHashMap();
	}

	public Params(String key, Object value) {
		this.params = Maps.newHashMap();
		this.params.put(key, value);
	}

	public Params add(String key, Object value) {
		this.params.put(key, value);
		return this;
	}

	public static void injectParameters(Request req, Params params) {
		if (null != params) {
			params.injectParameters(req);
		}
	}

	public Params injectParameters(Request req) {
		if (null != params) {
			for (String k : params.keySet()) {
				req.setParam(k, params.get(k));
			}
		}
		return this;
	}

	public Map<String, Object> params() {
		return params;
	}
}
