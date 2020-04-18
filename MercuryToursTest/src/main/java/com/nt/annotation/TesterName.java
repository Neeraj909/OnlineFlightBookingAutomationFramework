package com.nt.annotation;

public enum TesterName {
    Neeraj("Neeraj Sharma");

    public String authorName;
    TesterName(String authorName)
    {
        this.authorName=authorName;
    }

    public String toString() {
        return this.authorName;
    }
}
