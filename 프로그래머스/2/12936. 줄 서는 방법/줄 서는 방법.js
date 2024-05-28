function solution(n, k) {
    
    let nums = Array.from({length: n}, (_, i) => i+1)
    let factorial = Array(n + 1).fill(1)
    let res = []
    
    for(let i=2 ; i<=n ; i++) {
        factorial[i] = factorial[i - 1] * i
    }
    
    k -= 1
    for(let i=n ; i>0 ; i--) {
        let index = Math.floor(k / factorial[i - 1])
        res.push(nums[index])
        nums.splice(index, 1)
        k %= factorial[i - 1]
    }
    
    return res
}