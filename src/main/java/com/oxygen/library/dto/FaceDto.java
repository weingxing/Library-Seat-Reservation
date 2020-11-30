package com.oxygen.library.dto;

public class FaceDto {
    private String name;
    private int stuId;
    private byte[] faceId;
    private String haveFaceId;

    public FaceDto(String name, int stuId, byte[] faceId, String haveFaceId) {
        this.name = name;
        this.stuId = stuId;
        this.faceId = faceId;
        this.haveFaceId = haveFaceId;
    }

    public FaceDto() {
    }

    public String getName() {
        return this.name;
    }

    public int getStuId() {
        return this.stuId;
    }

    public byte[] getFaceId() {
        return this.faceId;
    }

    public String getHaveFaceId() {
        return this.haveFaceId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public void setFaceId(byte[] faceId) {
        this.faceId = faceId;
    }

    public void setHaveFaceId(String haveFaceId) {
        this.haveFaceId = haveFaceId;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof FaceDto)) return false;
        final FaceDto other = (FaceDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        if (this.getStuId() != other.getStuId()) return false;
        if (!java.util.Arrays.equals(this.getFaceId(), other.getFaceId())) return false;
        final Object this$haveFaceId = this.getHaveFaceId();
        final Object other$haveFaceId = other.getHaveFaceId();
        if (this$haveFaceId == null ? other$haveFaceId != null : !this$haveFaceId.equals(other$haveFaceId))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof FaceDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        result = result * PRIME + this.getStuId();
        result = result * PRIME + java.util.Arrays.hashCode(this.getFaceId());
        final Object $haveFaceId = this.getHaveFaceId();
        result = result * PRIME + ($haveFaceId == null ? 43 : $haveFaceId.hashCode());
        return result;
    }

    public String toString() {
        return "FaceDto(name=" + this.getName() + ", stuId=" + this.getStuId() + ", faceId=" + java.util.Arrays.toString(this.getFaceId()) + ", haveFaceId=" + this.getHaveFaceId() + ")";
    }
}
