public class SegmentTree {
    public int a[];
    public int v;
    public int tl;
    public int tr;

    public int t[];

    SegmentTree(int a[]) {

        this.a = a;
        v = 1;
        tl = 0;
        tr = a.length - 1;
        t = new int[a.length * 4];
        build(this.a, v, tl, tr);
    }

    void build (int a[], int v, int tl, int tr) {
        if (tl == tr)
            t[v] = a[tl];
        else {
            int tm = (tl + tr) / 2;
            build(a, v * 2, tl, tm);
            build(a, v * 2 + 1, tm + 1, tr);
            t[v] = t[v * 2] + t[v * 2 + 1];
        }
    }

    int sum (int v, int tl, int tr, int l, int r) {
        if (l > r)
            return 0;
        if (l == tl  && r == tr)
            return t[v];
        int tm = (tl + tr) / 2;
        return sum(v * 2, tl, tm, l, Math.min(r, tm))
                + sum(v * 2 + 1, tm + 1, tr, Math.max(l, tm + 1), r);
    }

    void update (int v, int tl, int tr, int pos, int newValue) {
        if (tl == tr)
            t[v] = newValue;
        else {
            int tm = (tl + tr) / 2;
            if (pos <= tm)
                update(v * 2, tl, tm, pos, newValue);
            else
                update(v * 2 + 1, tm + 1, tr, pos, newValue);
            t[v] = t[v * 2] + t[v * 2 + 1];
        }
    }

}
