// Dont think about every hashmap in terms of value and index, for this we need to look at duplicates hence use hashmap to keep track of the count of each value

// The time complexity for this brute force would be O(n^2) but that can be optimized 
// For this solution, we know that we need to take the length of the arrays in account hence lets try to keep it O(n)

class FindIntersectionOfArrays {
    public int[] intersect(int[] nums1, int[] nums2) {
        boolean isArrOneLarger = (nums1.length > nums2.length) ? true : false;
        
        // Data structures needed:
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> intersection = new ArrayList<>();
        
        if (isArrOneLarger) {
            map = createHashMapFromArr(nums1);
            // now that our hashmap has count of each number in smaller array, we need to iterate through the other one and add that to the intersection
            intersection = getIntersection(map, nums2);
        } else {
            map = createHashMapFromArr(nums2);
            intersection = getIntersection(map, nums1);
        }
        
        
        map.clear();
        
        return intersection.stream().mapToInt(i -> i).toArray();
        
    }
    
    public HashMap<Integer, Integer> createHashMapFromArr(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        return map;
    }
    
    public ArrayList<Integer> getIntersection(HashMap<Integer, Integer>map, int[] arr) {
        ArrayList<Integer> intersection = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                intersection.add(arr[i]);
                if (map.get(arr[i]) == 1) {
                    map.remove(arr[i]);
                } else {
                    map.put(arr[i], map.get(arr[i]) - 1);
                }
            }
        }
        return intersection;
    }
}
