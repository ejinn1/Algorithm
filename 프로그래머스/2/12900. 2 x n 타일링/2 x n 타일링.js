function solution(n) {
    const MOD = 1000000007
    let pre1 = 1
    let pre2 = 2
    let cur = 0
    
    for (let i = 3; i <= n; i++) {
        cur = (pre1 + pre2) % MOD
        pre1 = pre2
        pre2 = cur
    }
    
    return cur
}
