package cn.huischool.huixiao.framework.network;



import org.json.JSONObject;

import java.util.Map;

import cn.huischool.huixiao.framework.BaseParser;

/**
 * 定义Request 类
 *
 * @author han
 *         <p/>
 *         2016-4-15
 */


public class Request {
    private ServerInterfaceDefinition serverInterfaceDefinition;
    private Map<String, String> paramsMap;
    private BaseParser<?> jsonParser;
    private JSONObject jsonObject = null;


    public Request(ServerInterfaceDefinition serverInterfaceDefinition,
                   Map<String, String> paramsMap, BaseParser<?> jsonParser) {
        super();
        this.serverInterfaceDefinition = serverInterfaceDefinition;
        this.paramsMap = paramsMap;
        this.jsonParser = jsonParser;
    }

    public Request(ServerInterfaceDefinition serverInterfaceDefinition,


                   JSONObject jsonObject,
                   BaseParser<?> jsonParser) {
        super();

        this.serverInterfaceDefinition = serverInterfaceDefinition;
        this.jsonParser = jsonParser;

        this.jsonObject = jsonObject;


    }


    public ServerInterfaceDefinition getServerInterfaceDefinition() {
        // TODO Auto-generated method stub
        return serverInterfaceDefinition;
    }

    public BaseParser<?> getJsonParser() {
        return jsonParser;
    }

    public JSONObject getJsonObject() {

        return jsonObject;
    }


    public Map getParamsMap() {
        // TODO Auto-generated method stub
        return paramsMap;
    }

}
