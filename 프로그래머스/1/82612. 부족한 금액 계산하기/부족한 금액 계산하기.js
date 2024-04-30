function solution(price, money, count) {
    function add(price, count){
        if(count === 1){
            return price
        }
        return price*count + add(price, count-1)
    }
    
    const sum = add(price, count)
    
    return sum - money > 0 ? sum-money : 0
}