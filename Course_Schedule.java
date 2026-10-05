class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for (int course = 0; course < numCourses; course++) {
            adj.add(new ArrayList<>());
        }
        for (int[] pairValue : prerequisites) {
            int course = pairValue[0];
            int prerequisite = pairValue[1];
            adj.get(prerequisite).add(course);
            indegree[course]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int course = 0; course < numCourses; course++) {
            if (indegree[course] == 0) {
                q.offer(course);
            }
        }
        int completed = 0;
        while (!q.isEmpty()) {
            int course = q.poll();
            completed++;
            for (int nextCourse : adj.get(course)) {
                indegree[nextCourse]--;
                if (indegree[nextCourse] == 0) {
                    q.offer(nextCourse);
                }
            }
        }
        return completed == numCourses;
    }
}