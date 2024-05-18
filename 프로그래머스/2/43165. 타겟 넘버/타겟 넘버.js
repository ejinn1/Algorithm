function solution(numbers, target) {
 
    let res = 0
    function dfs(idx, sum){
        if(idx === numbers.length && sum === target){
            res++
            return
        } else if(idx === numbers.length && sum !== target){
            return
        }
        
        dfs(idx + 1, sum + numbers[idx])
        dfs(idx + 1, sum - numbers[idx])
    }
    
    dfs(0, 0)
    
    return res
}