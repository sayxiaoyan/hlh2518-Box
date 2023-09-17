package com.github.tvbox.osc.server;

import java.util.Map;

import org.nanohttpd.protocols.http.IHTTPSession;
import org.nanohttpd.protocols.http.response.Response;

/**
 * @author pj567
 * @date :2021/1/5
 * @description:
 */
public interface RequestProcess {
    public static final int KEY_ACTION_PRESSED = 0;
    public static final int KEY_ACTION_DOWN = 1;
    public static final int KEY_ACTION_UP = 2;

    /**
     * isRequest
     *
     * @param session
     * @param fileName
     * @return
     */
    boolean isRequest(IHTTPSession session, String fileName);

    /**
     * doResponse
     *
     * @param session
     * @param fileName
     * @param params
     * @param files
     * @return
     */
    Response doResponse(IHTTPSession session, String fileName, Map<String, String> params, Map<String, String> files);
}