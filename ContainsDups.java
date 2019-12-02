// If we approach an element that hasnt been found yet, then add it to the hashset
// else return true;

class ContainsDups {
    public boolean containsDuplicate(int[] nums) {
        // We will be using a hashset only because its O(1) to access elements
        HashSet<Integer> set = new HashSet<>();
        for (int num: nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
