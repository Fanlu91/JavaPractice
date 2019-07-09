package com.fanlu.geektime;

public class BackTrack {
    public int maxW = Integer.MIN_VALUE; // 存储背包中物品总重量的最大值
    // cw 表示当前已经装进去的物品的重量和；
    // i 表示考察到哪个物品了；
    // w 背包重量；
    // items 表示每个物品的重量；
    // n 表示物品个数
    // 假设背包可承受重量 100，物品个数 10，物品重量存储在数组 a 中，那可以这样调用函数：
    // fillBag(0, 0, a, 10, 100)

    public void fillBag(int i, int cw, int[] items, int n, int w) {
        if (cw == w || i == n) { // cw==w 表示装满了 ;i==n 表示已经考察完所有的物品
            if (cw > maxW)
                maxW = cw;
            return;
        }

        if (cw + items[i] <= w) {// 已经超过可以背包承受的重量的时候，就不要再装了
            // 装当前物品
            fillBag(i + 1, cw + items[i], items, n, w);
        }

        // 不装当前物品
        fillBag(i + 1, cw, items, n, w);
    }

}

class Pattern {
    private boolean matched = false;
    private char[] pattern; // 正则表达式
    private int plen; // 正则表达式长度

    public Pattern(char[] pattern, int plen) {
        this.pattern = pattern;
        this.plen = plen;
    }

    public boolean match(char[] text, int tlen) { // 文本串及长度
        matched = false;
        rmatch(0, 0, text, tlen);
        return matched;
    }

    private void rmatch(int ti, int pj, char[] text, int tlen) {
        if (matched) return; // 如果已经匹配了，就不要继续递归了
        if (pj == plen) { // 正则表达式到结尾了
            if (ti == tlen) matched = true; // 文本串也到结尾了
            return;
        }
        if (pattern[pj] == '*') { // * 匹配任意个字符
            for (int k = 0; k <= tlen - ti; ++k) {
                rmatch(ti + k, pj + 1, text, tlen);
            }
        } else if (pattern[pj] == '?') { // ? 匹配 0 个或者 1 个字符
            rmatch(ti, pj + 1, text, tlen);
            rmatch(ti + 1, pj + 1, text, tlen);
        } else if (ti < tlen && pattern[pj] == text[ti]) { // 纯字符匹配才行
            rmatch(ti + 1, pj + 1, text, tlen);
        }
    }
}

