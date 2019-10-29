package com.dx.test.module;

public enum ArticleType {
    News(0),
    Goods(1);

    private int type;

    ArticleType(int type) {
        this.type = type;
    }

    public int getType() {
        return this.type;
    }
}
