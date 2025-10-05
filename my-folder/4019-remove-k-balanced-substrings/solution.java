class Solution {
    static class Run {
        char ch;
        int cnt;
        Run(char ch, int cnt) { this.ch = ch; this.cnt = cnt; }
    }

    public String removeSubstring(String s, int k) {
        if (s == null || k <= 0) return s;
        List<Run> runs = new ArrayList<>();

        for (int idx = 0; idx < s.length(); idx++) {
            char c = s.charAt(idx);
            if (runs.isEmpty() || runs.get(runs.size() - 1).ch != c) {
                runs.add(new Run(c, 1));
            } else {
                runs.get(runs.size() - 1).cnt++;
            }
            while (runs.size() >= 2) {
                Run last = runs.get(runs.size() - 1);
                Run prev = runs.get(runs.size() - 2);
                if (prev.ch == '(' && last.ch == ')' && prev.cnt >= k && last.cnt >= k) {
                    int times = Math.min(prev.cnt / k, last.cnt / k);
                    prev.cnt -= times * k;
                    last.cnt -= times * k;
                    if (prev.cnt == 0) {
                        runs.remove(runs.size() - 2);
                    }
                    if (!runs.isEmpty() && runs.get(runs.size() - 1).cnt == 0) {
                        runs.remove(runs.size() - 1);
                    }
                } else {
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Run r : runs) {
            for (int i = 0; i < r.cnt; i++) sb.append(r.ch);
        }
        return sb.toString();
    }
}
