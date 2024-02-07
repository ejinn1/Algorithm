function solution(prices) {
    
    const answer = prices.map((price, index) => {
        let time = 0
        
        for (let j = index + 1; j < prices.length; j++) {
            time++
            if (price > prices[j]) {
                break
            }
        }
        return time
    });

    return answer
}