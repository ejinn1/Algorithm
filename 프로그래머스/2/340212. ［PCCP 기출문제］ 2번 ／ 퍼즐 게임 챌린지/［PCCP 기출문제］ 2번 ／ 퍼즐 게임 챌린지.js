function solution(diffs, times, limit) {
    const len = diffs.length
    let left = 1
    let right = 100000
    let mid = undefined
    let result = right
    
    while(left <= right){
        mid = Math.floor((left+right)/2)
        let total = 0
        let over = false
        
        for(let i=0 ; i<len ; i++){
            if(diffs[i] <= mid){
                total += times[i]
            } else {
                total = total + (diffs[i]-mid)*(times[i]+times[i-1]) + times[i]
            }
            
            if(total > limit){
                over = true
                break
            }
        }
        
        if(over){
            left = mid + 1
        } else{
            result = mid
            right = mid - 1
        }
    }
    
    return result
}