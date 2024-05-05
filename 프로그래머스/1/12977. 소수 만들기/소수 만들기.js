function solution(nums) {
    let result = 0
    
    function isPrime(n){
        let f = 1
        for(let i=2 ; i<n/2 ; i++){
            if(n%i === 0){
                f=0
                break
            }
        }
        return f
    }
    
    for(let i=0 ; i<nums.length-2 ; i++){
        for(let j=i+1 ; j<nums.length-1 ; j++){
            for(let k=j+1 ; k<nums.length ; k++){
                if(isPrime(nums[i] + nums[j] + nums[k])){
                    result++
                }
            }
        }
    }
    
    return result
}