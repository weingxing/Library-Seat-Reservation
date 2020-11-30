package com.oxygen.library.dto;

public class Welcome {
    private int today;
    private int seat;
    private int all;
    private int student;

    public Welcome(int today, int seat, int all, int student) {
        this.today = today;
        this.seat = seat;
        this.all = all;
        this.student = student;
    }

    public Welcome() {
    }

    public int getToday() {
        return this.today;
    }

    public int getSeat() {
        return this.seat;
    }

    public int getAll() {
        return this.all;
    }

    public int getStudent() {
        return this.student;
    }

    public void setToday(int today) {
        this.today = today;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public void setAll(int all) {
        this.all = all;
    }

    public void setStudent(int student) {
        this.student = student;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Welcome)) return false;
        final Welcome other = (Welcome) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getToday() != other.getToday()) return false;
        if (this.getSeat() != other.getSeat()) return false;
        if (this.getAll() != other.getAll()) return false;
        if (this.getStudent() != other.getStudent()) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Welcome;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getToday();
        result = result * PRIME + this.getSeat();
        result = result * PRIME + this.getAll();
        result = result * PRIME + this.getStudent();
        return result;
    }

    public String toString() {
        return "Welcome(today=" + this.getToday() + ", seat=" + this.getSeat() + ", all=" + this.getAll() + ", student=" + this.getStudent() + ")";
    }
}
