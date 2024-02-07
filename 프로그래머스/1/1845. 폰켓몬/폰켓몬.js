function solution(nums) {
    var answer = 0;
    
    const N = nums.length
    console.log(N/2)
    const numsSet = new Set(nums)
    console.log(numsSet.size)
    
    return N/2 > numsSet.size ? numsSet.size : N/2
}