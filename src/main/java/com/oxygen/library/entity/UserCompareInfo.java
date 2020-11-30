package com.oxygen.library.entity;

public class UserCompareInfo {
    private Float similar;
    private String faceId;
    private String name;
    private byte[] faceFeature;

    public UserCompareInfo() {
    }

    public Float getSimilar() {
        return this.similar;
    }

    public String getFaceId() {
        return this.faceId;
    }

    public String getName() {
        return this.name;
    }

    public byte[] getFaceFeature() {
        return this.faceFeature;
    }

    public void setSimilar(Float similar) {
        this.similar = similar;
    }

    public void setFaceId(String faceId) {
        this.faceId = faceId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFaceFeature(byte[] faceFeature) {
        this.faceFeature = faceFeature;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof UserCompareInfo)) return false;
        final UserCompareInfo other = (UserCompareInfo) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$similar = this.getSimilar();
        final Object other$similar = other.getSimilar();
        if (this$similar == null ? other$similar != null : !this$similar.equals(other$similar)) return false;
        final Object this$faceId = this.getFaceId();
        final Object other$faceId = other.getFaceId();
        if (this$faceId == null ? other$faceId != null : !this$faceId.equals(other$faceId)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        if (!java.util.Arrays.equals(this.getFaceFeature(), other.getFaceFeature())) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof UserCompareInfo;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $similar = this.getSimilar();
        result = result * PRIME + ($similar == null ? 43 : $similar.hashCode());
        final Object $faceId = this.getFaceId();
        result = result * PRIME + ($faceId == null ? 43 : $faceId.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        result = result * PRIME + java.util.Arrays.hashCode(this.getFaceFeature());
        return result;
    }

    public String toString() {
        return "UserCompareInfo(similar=" + this.getSimilar() + ", faceId=" + this.getFaceId() + ", name=" + this.getName() + ", faceFeature=" + java.util.Arrays.toString(this.getFaceFeature()) + ")";
    }
}
