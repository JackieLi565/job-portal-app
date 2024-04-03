package com.workwise.authservice.util;

/**
 * Simple cookie class because NewCookie is dog water
 */
public class Cookie {
    private StringBuilder stringBuilder;

    public Cookie(String name, String value) {
        this.stringBuilder = new StringBuilder();
        this.stringBuilder.append(name);
        this.addEqual();
        this.stringBuilder.append(value);
    }

    public void setPath(String path) {
        this.addSeparator();
        this.stringBuilder.append("Path");
        this.addEqual();
        this.stringBuilder.append(path);
    }

    public void setMaxAge(int maxAge) {
        this.addSeparator();
        this.stringBuilder.append("Max-Age");
        this.addEqual();
        this.stringBuilder.append(maxAge);
    }

    public void isHTTP(boolean http) {
        if (http) {
            this.addSeparator();
            this.stringBuilder.append("HttpOnly");
        }
    }

    private void addEqual() {
        this.stringBuilder.append("=");
    }

    private void addSeparator() {
        this.stringBuilder.append("; ");
    }

    @Override
    public String toString() {
        return this.stringBuilder.toString();
    }
}
