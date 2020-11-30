package com.oxygen.library.exception;

import com.oxygen.library.dto.Response;
import com.oxygen.library.enums.ErrorCode;


public class BusinessException extends RuntimeException {
    private ErrorCode errorCode;
    private String msg;
    private String msgCN;

    public BusinessException(Response response) {
        this.errorCode = new ErrorCode() {
            @Override
            public Integer getCode() {
                return response.getCode();
            }

            @Override
            public String getDesc() {
                return response.getMsg();
            }

            @Override
            public String getDescCN() {
                return response.getMsg();
            }
        };
        this.msg=response.getMsg();
        this.msgCN=response.getMsg();
    }

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getDesc());
        this.errorCode = errorCode;
        this.msg= errorCode.getDesc();
        this.msgCN=errorCode.getDescCN();
    }

    public BusinessException(ErrorCode errorCode, String msg) {
        super(errorCode.getDesc());
        this.errorCode = errorCode;
        this.msg = msg;
        this.msgCN=msg;
    }

    public BusinessException(Throwable cause, ErrorCode errorCode) {
        super(cause);
        this.errorCode = errorCode;
        this.msg= errorCode.getDesc();
        this.msgCN=errorCode.getDescCN();
    }


    public BusinessException(Throwable cause, ErrorCode errorCode, String msg) {
        super(cause);
        this.errorCode = errorCode;
        this.msg = msg;
        this.msgCN=msg;
    }

    public ErrorCode getErrorCode() {
        return this.errorCode;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getMsgCN() {
        return this.msgCN;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setMsgCN(String msgCN) {
        this.msgCN = msgCN;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof BusinessException)) return false;
        final BusinessException other = (BusinessException) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$errorCode = this.getErrorCode();
        final Object other$errorCode = other.getErrorCode();
        if (this$errorCode == null ? other$errorCode != null : !this$errorCode.equals(other$errorCode)) return false;
        final Object this$msg = this.getMsg();
        final Object other$msg = other.getMsg();
        if (this$msg == null ? other$msg != null : !this$msg.equals(other$msg)) return false;
        final Object this$msgCN = this.getMsgCN();
        final Object other$msgCN = other.getMsgCN();
        if (this$msgCN == null ? other$msgCN != null : !this$msgCN.equals(other$msgCN)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof BusinessException;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $errorCode = this.getErrorCode();
        result = result * PRIME + ($errorCode == null ? 43 : $errorCode.hashCode());
        final Object $msg = this.getMsg();
        result = result * PRIME + ($msg == null ? 43 : $msg.hashCode());
        final Object $msgCN = this.getMsgCN();
        result = result * PRIME + ($msgCN == null ? 43 : $msgCN.hashCode());
        return result;
    }

    public String toString() {
        return "BusinessException(errorCode=" + this.getErrorCode() + ", msg=" + this.getMsg() + ", msgCN=" + this.getMsgCN() + ")";
    }
}
