package iot157.app.part3_3_smarthome.model.message;
/*响应消息
* @param <T>*/
public class ResMsg<T> {
    private static String errcode = "0";
    private String errmsg;
    private T data;

    public ResMsg(){}

    public ResMsg(String errcode,String errmsg){
        this.errcode = errcode;
        this.errmsg = errmsg;
    }

    public static boolean success(){
        return "0".equals(errcode);
    }
    public String getErrcode(){
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
