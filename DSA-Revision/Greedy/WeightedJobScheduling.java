class Job {
    int s;
    int e;

    Job(int s, int e) {
        this.s = s;
        this.e = e;
    }
}

int solve(int[] s, int[] e, int n) {
    Job[] jobs = new Job[n];
    for (int i = 0; i < n; i++) {
        jobs[i] = new Job(s[i], e[i]);
    }

    Arrays.sort(jobs, (a, b) -> a.e - b.e);

    int prevJobEnded = jobs[0].e;
    int ans = 1;

    for (int i = 1; i < n; i++) {
        Job curr = jobs[i];
        if (curr.s >= prevJobEnded) {
            ans++;
            prevJobEnded = curr.e;
        }
    }

    return ans;
}
