func merge(nums1 []int, m int, nums2 []int, n int)  {
    for i, j, k := m-1, n-1, len(nums1)-1; k >= 0; k-- {
        if j < 0 || (i >= 0 && nums1[i] > nums2[j]) {
            nums1[k] = nums1[i]
            i--
        } else if i < 0 || (j >= 0 && nums1[i] <= nums2[j]) {
            nums1[k] = nums2[j]
            j--
        } 
    }
}
