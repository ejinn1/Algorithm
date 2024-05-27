function solution(cap, n, ds, ps) {
    
    let res = 0
    let num_deliveries = 0
    let num_pickups = 0

    for (let i = n-1 ; i>=0 ; i--) {
        let num_times = 0
        ds[i] = ds[i] + num_deliveries
        ps[i] = ps[i] + num_pickups

        while (ds[i] > 0 || ps[i] > 0) {
            ds[i] = ds[i] - cap
            ps[i] = ps[i] - cap
            num_times++
        }

        num_deliveries = ds[i]
        num_pickups = ps[i]

        if (ds[i] > 0 || ps[i] > 0) {
            res = res + 2 * (i + 1) * (num_times + 1)
        } else {
            res = res + 2 * (i + 1) * (num_times)
        }
    }
    
    return res
}