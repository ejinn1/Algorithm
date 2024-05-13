function solution(topping) {
    
    let a = {}
    let b = new Set()
    let cnt = 0
    
    topping.forEach((t) => {
        if(a[t]){
            a[t]++
        } else {
            a[t] = 1
            cnt++
        }
    })
    
    let res = 0
    topping.forEach((t) => {
        a[t]--
        b.add(t)
        
        if(!a[t]){
            cnt--
        }
        
        if(cnt === b.size) res++
    })
    
    return res
    
}