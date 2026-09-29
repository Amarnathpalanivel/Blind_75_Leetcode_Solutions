class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        findCombinations(0, target, candidates, new ArrayList<>(), result);
        return result;
    }
    private void findCombinations(
            int index,
            int target,
            int[] candidates,
            List<Integer> current,
            List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (index == candidates.length) {
            return;
        }
        if (candidates[index] <= target) {
            current.add(candidates[index]);
            findCombinations(
                index,
                target - candidates[index],
                candidates,
                current,
                result
            );
            current.remove(current.size() - 1);
        }
        findCombinations(
            index + 1,
            target,
            candidates,
            current,
            result
        );
    }
}